import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private List<Player> players;

    private Sack sack;

    private Board board;

    private int turn;

    private int jumps;


    public Game(int n){

        String name = "";
        players = new ArrayList<Player>();
        sack = new Sack();
        board = new Board();
        for(int i = 0; i<n; i++){

            name = "Player " + (i+1);
            players.add(new Player(name, new Sack()));

        }turn = jumps = 0;
        turn();

    }






    public void nextTurn(){

        turn = (turn+1)%players.size();
        turn();

    }




    public void turn(){

        Scanner scanner = new Scanner(System.in);
        Board aux = new Board();
        aux.copy(board.getBoard());

        System.out.println("Turn of " + players.get(turn).getName());

        System.out.println("Your deck is: ");
        for(int i = 0; i<players.get(turn).getDeck().size(); i++) {

            System.out.println(players.get(turn).getDeck().get(i).toString());

        }System.out.println("The board is: ");
        System.out.println(board.toString());


        System.out.println("Do you want to play or skip? (p/s)");

        String option = System.console().readLine();

        if(option.equals("s")){
            nextTurn();
            return;
        }

        while(true){

            System.out.println("Your deck is: ");
            for(int i = 0; i<players.get(turn).getDeck().size(); i++) {

                System.out.println(players.get(turn).getDeck().get(i).toString());

            }

            System.out.println("Do you want to insert a word horizontally, vertically or get a Token? (h/v/g)");
            char orientation = System.console().readLine().charAt(0);

            if(orientation == 'g'){

                players.get(turn).add(sack);
                nextTurn(); return;

            }

            System.out.println("Insert the word: ");
            String word = scanner.nextLine();

            if(!players.get(turn).contains(word)) continue;

            System.out.println("Insert the row: ");
            int row = Integer.parseInt(System.console().readLine());
            System.out.println("Insert the column: ");
            int column = Integer.parseInt(System.console().readLine());

            board.insertWord(row, column, word, orientation);

            if(board.verify()){

                players.get(turn).removeWord(word);
                System.out.println("is valid!");
                nextTurn(); return;

            }

            System.out.println("invalid word");
            board.copy(aux.getBoard());

        }


    }


}
