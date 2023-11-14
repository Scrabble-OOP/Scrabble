import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private List<Player> players;

    private TrieTree dictionary;
    private Sack sack;

    private Board board;

    private int turn;

    private int jumps;


    public Game(int n, TrieTree dictionary){

        players = new ArrayList<Player>();
        sack = new Sack();
        board = new Board();
        for(int i = 0; i<n; i++){

            players.add(new Player("Player: " + i, sack));

        }turn = jumps = 0;
        this.dictionary = dictionary;
        turn();

    }






    public void nextTurn(){

        turn = (turn+1)%players.size();
        turn();

    }



















































    public void turn(){




    }


}
