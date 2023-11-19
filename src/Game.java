import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;


public class Game extends JFrame implements ActionListener {

    private List<Player> players;
    private Sack sack;
    private Board board;
    private int turn;
    private int jumps;
    private char[] alphabet = new char[15]; // Creating an array to hold 15 characters (A to O)
    private char currentChar = 'A';
    private JButton terminate = new JButton();
    private JButton insert = new JButton();
    private Sack auxSack;
    private Token buffer = null;
    private JButton skip = new JButton();
    private JButton restart = new JButton();
    private JButton change = new JButton();
    private JButton makeT = new JButton();
    private Board aux;
    private Deck auxDeck;
    private JLabel name = new JLabel();
    private JLabel score = new JLabel();
    private int counter = 0;
    private JLabel cont = new JLabel();
    private Scanner scanner = new Scanner(System.in);
    private Player current;
    private Font fontC = new Font("Roboto", Font.BOLD, 10);
    private Font fontD = new Font("Roboto", Font.BOLD, 20);
    private Font fontE = new Font("Roboto", Font.BOLD, 15);
    private List<Token> changes = new ArrayList<>();
    private JLabel jumpsLabel = new JLabel();
    private JLabel fichasRestantesLabel = new JLabel();























    public void fill() {

        for (int i = 0; i < 15; i++) {
            alphabet[i] = currentChar;
            if (currentChar == 'O') {
                break; // Stops when 'O' is reached
            }
            currentChar++;
        }
    }














    public Game(int n){

        fill();
        players = new ArrayList<Player>();
        sack = new Sack();
        board = new Board();
        this.setResizable(true);
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        for(int i = 0; i<n; i++) players.add(new Player("Player: " + i, sack)); //aqui hay que introducir los nombres de los jugadores
        Collections.shuffle(players);
        turn = jumps = 0;
        fichasRestantesLabel = new JLabel("Fichas restantes: " + sack.size());
        fichasRestantesLabel.setBounds(697, 613, 200, 20);
        fichasRestantesLabel.setFont(new Font("Roboto", Font.BOLD, 9));
        this.add(fichasRestantesLabel);
        turn();


    }




















    public void addTablero(){
        for(int k = 0; k < 15; k ++){
            for(int u = 0; u < 15; u ++){
                addCell(board.getCell(k, u), k * 40 + 200, u * 40 + 15);
            }
        }
    }




















    public void addCell(Cell cell, int x, int y){
        cell.setBounds(x, y, 40, 40);
        cell.setFont(fontC);
        if(cell.getFactLetter() != 1 && cell.getToken().getLetter() == '_'){
            cell.setText(cell.getFactLetter() + "XL");
            cell.setBackground(Color.RED);
        }
        if(cell.getFactWord() != 1 && cell.getToken().getLetter() == '_'){
            cell.setText(cell.getFactWord() + "XW");
            cell.setBackground(Color.ORANGE);
        }
        this.add(cell);
        cell.addActionListener(this);

    }

















    public void nextTurn(){

        if(skippedEnd()){ //si todos los jugadores saltaron su turno, el juego termina

            JOptionPane.showMessageDialog(null, "Game over");
            System.exit(0);

        }
        current.replenishDeck(sack);
        turn = (turn+1)%players.size();
        aux = new Board(board);
        auxSack = new Sack(sack);
        removeDeck();
        current = players.get(turn);
        auxDeck = new Deck(current.getDeck());
        name.setText("Turno de: " + players.get(turn).getName());
        score.setText("Puntaje: " + players.get(turn).getScore());
        jumpsLabel.setText("Quedan: " + (players.size()-jumps) + " saltos");
        changes.clear();
        addDeck();
        fichasRestantesLabel.setText("Fichas restantes: " + sack.size());

    }















    public void addToken(Token token, int x, int y){
        token.setBounds(x, y, 62, 62);
        token.setFont(fontC);
        this.add(token);
        token.addActionListener(this);
    }















    public void addDeck(){
        for(int i = 0; i < current.getDeck().size(); i++){
            addToken(current.getDeck().get(i), i * 62 + 250, 640);
        }
    }













    public void addChangeButtons(){

        terminate.setVisible(true);
        insert.setVisible(true);
        change.setVisible(false);

    }











    public void removeCell(Cell cell){

        cell.setBounds(1500, 1500, 0, 0);
        cell.removeActionListener(this);
        this.remove(cell);

    }










    public void removeTablero(){
        for(int k = 0; k < 15; k ++)
            for(int u = 0; u < 15; u ++)
                removeCell(board.getCell(k, u));
    }









    public void removeToken(Token token){
        token.setBounds(1500, 1500, 0, 0);
        this.remove(token);
        token.removeActionListener(this);
    }










    public void removeDeck(){
        for(int i = 0; i < current.getDeck().size(); i++){
            removeToken(current.getDeck().get(i));
        }
    }









    public void refDeck(){
        removeDeck();
        current.setDeck(auxDeck.getDeck());
        addDeck();
    }












    public void refTablero(){

        removeTablero();
        board = new Board(aux);
        addTablero();
        removeDeck();
        current.setDeck(auxDeck.getDeck());

    }




























    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == terminate && buffer == null){

            terminate.setVisible(false);
            insert.setVisible(false);
            change.setVisible(true);
            if(players.get(turn).changeDeck(sack, changes)) jumps = 0;
            else jumps++;
            nextTurn();


        }
        if(e.getSource() == insert){

            if (buffer != null) {

                changes.add(buffer);
                insert.setText("" + (++counter));
                buffer = null;

            }

        }
        if(e.getSource() == change){

            //Aqui hay que encontrar alguna manera de no permitir que el jugador no pueda apretar ningun boton que no sea insert o terminate
            counter = 0;
            addChangeButtons();

        }
        if(e.getSource() == skip){

            jumps++;
            refTablero();
            nextTurn();

        }
        if(e.getSource() == makeT){
            if(board.verify()) {
                int auxScore = board.getScore() - aux.getScore();
                current.addScore(auxScore);
                if(auxScore == 0 && auxSack.size() == sack.size()) jumps++;

                else if(current.win(sack)){

                    sumWinnerEnd();
                    JOptionPane.showMessageDialog(null, "Player " + players.get(turn).getName() + " wins!");
                    System.exit(0);


                }jumps = 0;
                buffer = null;
                nextTurn();
            }

        }
        if(e.getSource() == restart){
            refTablero();
            refDeck();
            sack = new Sack(auxSack);
            buffer = null;
        }
        for(int i = 0; i < players.get(turn).getDeck().size(); i++){
            if(e.getSource() == current.getDeck().get(i)){
                if(buffer == null){
                    buffer = new Token(players.get(turn).getDeck().get(i));
                    removeDeck();
                    players.get(turn).removeChar(players.get(turn).getDeck().get(i).getLetter());
                    addDeck();
                }
            }
        }
        for(int i = 0; i < 15; i ++){
            for(int j = 0; j < 15; j++){
                if(e.getSource() == board.getCell(i, j)){
                    if(buffer != null){
                        board.getCell(i, j).setToken(new Token(buffer));
                        board.getCell(i, j).setText(board.getCell(i, j).getToken().getLetter() + "");
                        buffer = null;
                    }
                }
            }
        }
    }






    public void turn(){

        terminate.setBounds(690, 720, 100, 20);
        terminate.setText("Terminar");
        terminate.addActionListener(this);
        terminate.setFont(fontC);
        terminate.setVisible(false);
        this.add(terminate);
        insert.setBounds(690, 630, 100, 80);
        insert.setText("" + counter);
        insert.addActionListener(this);
        insert.setFont(fontD);
        insert.setVisible(false);
        this.add(insert);


        for(int i = 0; i < 15; i ++){
            JLabel letter = new JLabel();
            letter.setText("" + alphabet[i]);
            letter.setBounds(i * 40 + 215, -13, 40, 40);
            this.add(letter);
            letter.setVisible(true);
        }
        for(int i = 0; i < 15; i++){
            JLabel letter = new JLabel();
            letter.setText("" + (i + 1));
            letter.setBounds(177, i * 40 + 15, 40, 40);
            this.add(letter);
            letter.setVisible(true);
        }

        aux = new Board(board);
        auxDeck = new Deck(players.get(turn).getDeck());
        auxSack = new Sack(sack);

        change.setBounds(690, 630, 100, 80);
        change.setText("Cambiar Fichas");
        change.addActionListener(this);
        change.setFont(fontC);
        this.add(change);
        restart.setBounds(50, 280, 100, 80);
        restart.setText("Reiniciar Tablero");
        restart.addActionListener(this);
        restart.setFont(fontC);
        this.add(restart);
        makeT.setBounds(850, 214, 100, 80);
        makeT.setText("Jugar");
        makeT.addActionListener(this);
        makeT.setFont(fontC);
        this.add(makeT);
        skip.setBounds(850, 339, 100, 80);
        skip.setText("Saltar Turno");
        skip.addActionListener(this);
        skip.setFont(fontC);
        this.add(skip);


        current = players.get(turn);
        addDeck();
        addTablero();

        name.setText("Turno de: " + players.get(turn).getName());
        score.setText("Puntaje: " + players.get(turn).getScore());
        name.setBounds(438, 715, 300, 20);
        score.setBounds(465, 745, 100, 20);
        name.setFont(fontE);
        score.setFont(fontE);
        this.add(name);
        this.add(score);
        name.setVisible(true);
        score.setVisible(true);
        this.setVisible(true);
        jumpsLabel.setText("Quedan: " + (players.size()-jumps) + " saltos");
        jumpsLabel.setBounds(859, 400, 100, 80);
        jumpsLabel.setFont(fontC);
        this.add(jumpsLabel);


























        //juego en la terminal

















        /*
        System.out.println("Turn of " + players.get(turn).getName());
        System.out.println("Score: " + players.get(turn).getScore());
        System.out.println(jumps + " players skipped their turn");
        System.out.println("size of Sack: " + sack.size());

        System.out.println("Do you want to play or skip? (p/s)");
        String input = scanner.nextLine();

        if(input.equals("s")){

            if(skippedEnd()){
                System.out.println("Game over");
                return;
            }
            nextTurn();
            return;

        }


        while(true){

            System.out.println("Board: ");
            System.out.println(board);
            System.out.println("Deck: ");
            System.out.println(players.get(turn).getDeck());
            System.out.println("Enter a character, E to end turn or T to take a token: ");
            input = scanner.nextLine();

            if (input.equals("E")) break;

            if(input.equals("T")){

                if(sack.isEmpty()){

                    System.out.println("Sack is empty");
                    continue;
                }

                if(players.get(turn).changeDeck(sack)) jumps=0;
                else if(skippedEnd()){             //si el jugador no cambio ninguna ficha se cuenta como salto de turno

                    System.out.println("Game over");
                    return;

                }
                nextTurn();
                return;

            }

            if (input.length() != 1) continue;
            char c = input.charAt(0);
            int row, col;
            System.out.println("Enter row: ");
            row = scanner.nextInt();
            System.out.println("Enter column: ");
            col = scanner.nextInt();
            if (board.insertChar(row, col, c))
                players.get(turn).removeChar(c);
            else System.out.println("Invalid position");

        }


        if(board.verify()){

            int score = board.getScore() - aux.getScore();


            if(score == 0 && auxSack.size() == sack.size() && skippedEnd()){

                System.out.println("Game over");
                return;

            }


            //Si algun jugador no salto, entonces la cuenta de saltos vuelve a cero

            System.out.println("Valid");
            players.get(turn).addScore(score);

            if(players.get(turn).win(sack)){

                sumWinnerEnd();
                System.out.println("Player " + players.get(turn).getName() + " wins!");
                return;

            }nextTurn();
            return;

        }

        System.out.println("Invalid");
        board = new Board(aux);
        players.get(turn).setDeck(auxDeck.getDeck());
        sack = new Sack(auxSack);
        turn();*/


    }



    private boolean skippedEnd(){

        if(jumps < players.size()) return false;
        sumSkippedEnd();
        return true;

    }
    //Esta funcion resta la suma de las fichas que quedaron en el atril de cada jugador
    private void sumSkippedEnd(){

        for(Player player : players) player.addScore(-player.sumDeck());

    }

    private void sumWinnerEnd(){

        int min = Integer.MAX_VALUE, index = turn; //Esto es debido a que si se llama esta funcion implica que el jugador del turno actual fue el que gano

        for(int i = 0; i<players.size(); i++){

            if(i == index){
                players.get(i).addScore(players.get(i).sumDeck());   //Al que gano se le suman los puntajes de sus fichas
                continue;
            }
            players.get(i).addScore(-players.get(i).sumDeck());  // a los que perdieron se les restan

        }

    }



}
