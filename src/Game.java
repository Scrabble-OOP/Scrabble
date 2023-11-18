import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game extends JFrame implements ActionListener {

    private List<Player> players;

    private Sack sack;

    private Board board;

    private int turn;

    private int jumps;

    private Scanner scanner = new Scanner(System.in);


    public Game(int n){

        players = new ArrayList<Player>();
        sack = new Sack();
        board = new Board();
        this.setResizable(true);
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        for(int i = 0; i<n; i++){

            players.add(new Player("Player: " + i, sack));

        }
        turn = jumps = 0;
        turn();

    }

    private Font fontC = new Font("Roboto", Font.BOLD, 10);

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
        if(cell.getFactLetter() != 1){
            cell.setText(cell.getFactLetter() + "XL");
        }
        if(cell.getFactWord() != 1){
            cell.setText(cell.getFactWord() + "XW");
            cell.setBackground(Color.RED);
        }
        this.add(cell);
        cell.addActionListener(this);

    }
    private Player current;






    public void nextTurn(){

        turn = (turn+1)%players.size();
        aux = new Board(board);
        auxDeck = new Deck(players.get(turn).getDeck());
        current = players.get(turn);

    }

    private Token buffer = null;

    private JButton skip = new JButton();
    private JButton restart = new JButton();
    private Board aux;
    Deck auxDeck;

    public void addToken(Token token, int x, int y){
        token.setBounds(x, y, 62, 62);
        token.setFont(fontC);
        this.add(token);
        token.addActionListener(this);
    }

    public void addDeck(){
        for(int i = 0; i < current.getDeck().size(); i++){
            addToken(current.getDeck().get(i), i * 62 + 280, 640);
        }
    }

    public void removeCell(Cell cell){
        cell.setBounds(1500, 1500, 0, 0);
        cell.removeActionListener(this);
        this.remove(cell);
    }

    public void removeTablero(){
        for(int k = 0; k < 15; k ++){
            for(int u = 0; u < 15; u ++){
                removeCell(board.getCell(k, u));
            }
        }
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
        if(e.getSource() == skip){
            refTablero();
            nextTurn();
            refDeck();
        }
        if(e.getSource() == restart){
            refTablero();
            refDeck();
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
        aux = new Board(board);
        auxDeck = new Deck(players.get(turn).getDeck());

        skip.setBounds(850, 320, 100, 80);
        skip.setText("Saltar Turno");
        skip.addActionListener(this);
        skip.setFont(fontC);
        this.add(skip);
        restart.setBounds(50, 320, 100, 80);
        restart.setText("Reiniciar Tablero");
        restart.addActionListener(this);
        restart.setFont(fontC);
        this.add(restart);

        current = players.get(turn);
        addDeck();
        addTablero();

        this.setVisible(true);


        System.out.println("Turn of " + players.get(turn).getName());
        System.out.println("Score: " + players.get(turn).getScore());
        System.out.println(jumps + " players skipped their turn");

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

        jumps=0; //Si algun jugador no salto, entonces la cuenta de saltos vuelve a cero

        while(true){

            System.out.println("Board: ");
            System.out.println(board);
            System.out.println("Deck: ");
            System.out.println(players.get(turn).getDeck());
            System.out.println("Enter a character, E to end turn or T to take a token: ");
            input = scanner.nextLine();

            if (input.equals("E")) break;

            if(input.equals("T")){


                board = new Board(aux);
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

            if(score == 0 && skippedEnd()){

                System.out.println("Game over");
                return;

            }

            System.out.println("Valid");
            players.get(turn).addScore(score);


            return;

        }

        System.out.println("Invalid");
        board = new Board(aux);
        players.get(turn).setDeck(auxDeck.getDeck());
        turn();


    }






    private boolean skippedEnd(){

        jumps++;
        return jumps == players.size();


    }




}
