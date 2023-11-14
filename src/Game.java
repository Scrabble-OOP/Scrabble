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

        players = new ArrayList<Player>();
        sack = new Sack();
        board = new Board();
        for(int i = 0; i<n; i++){

            players.add(new Player("Player: " + i, sack));

        }turn = jumps = 0;
        turn();

    }






    public void nextTurn(){

        turn = (turn+1)%players.size();
        turn();

    }



















































    public void turn(){




    }


}
