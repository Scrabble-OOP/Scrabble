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


        board.insertChar(7, 7, 'h');
        board.insertChar(7, 8, 'o');
        board.insertChar(7, 9, 'l');
        board.insertChar(7, 10, 'a');
        board.insertChar(8, 8, 'l');
        board.insertChar(9, 8, 'a');
        board.insertChar(10, 8, 's');
        board.insertChar(10, 9, 'o');
        board.insertChar(10, 10, 'l');
        Board aux = new Board(board);
        aux.verify();


        board.insertChar(0, 0, 'a');
        board.insertChar(0, 1, 'd');
        board.insertChar(0, 2, 'i');
        board.insertChar(0, 3, 'o');
        board.insertChar(0, 4, 's');
        board.insertChar(0, 14, 'a');
        board.insertChar(1, 14, 'd');
        board.insertChar(2, 14, 'i');
        board.insertChar(3, 14, 'o');
        board.insertChar(4, 14, 's');
        board.insertChar(1, 13, 'a');
        board.insertChar(1, 12, 'r');
        System.out.println(board);
        System.out.println(board.verify());
        System.out.println(board.getScore());
        System.out.println(aux.getScore());
        System.out.println(board.getScore() - aux.getScore());

    }


}
