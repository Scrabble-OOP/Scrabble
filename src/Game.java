import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

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
        for(int i = 0; i<n; i++){

            players.add(new Player("Player: " + i, sack));

        }turn = jumps = 0;

    }



    public void start(){

        turn();

    }



    //Se llama cuando un jugador termina su turno
    //Reponemos su deck y pasamos al siguiente jugador
    private void nextTurn(){

        players.get(turn).replenishDeck(sack);
        turn = (turn+1)%players.size();
        turn();

    }



















































    private void turn(){

        Board aux = new Board(board);
        Deck auxDeck = new Deck(players.get(turn).getDeck());
        Sack auxSack = new Sack(sack);

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

                //si el jugador no cambio ninguna ficha se cuenta como salto de turno
                if(!players.get(turn).changeDeck(sack) && skippedEnd()){

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

            jumps=0; //Si algun jugador no salto, entonces la cuenta de saltos vuelve a cero

            int score = board.getScore() - aux.getScore();

            if(score == 0 && skippedEnd()){

                System.out.println("Game over");
                return;

            }

            System.out.println("Valid");
            players.get(turn).addScore(score);

            if(players.get(turn).win(sack)){

                System.out.println("Player " + players.get(turn).getName() + " wins!");
                return;

            }nextTurn();
            return;

        }

        System.out.println("Invalid");
        board = new Board(aux);
        players.get(turn).setDeck(auxDeck.getDeck());
        sack = new Sack(auxSack);
        turn();


    }






    private boolean skippedEnd(){

        jumps++;
        return jumps == players.size();


    }


}
