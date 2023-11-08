import java.util.ArrayList;
import java.util.List;
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

        }turn = 0;
        jumps = 0;

    }

    public void nextTurn(){

        turn = (turn+1)%players.size();

    }


}
