import java.util.ArrayList;


public class Player {

    private String name;
    private ArrayList<Token> deck;
    private int score;

    public Player(String name, Sack sack){

        this.name = name;
        deck = new ArrayList<Token>();

        for(int i = 0; i<7; i++) deck.add(sack.pop());

        score = 0;

    }

    public int getScore(){

        return score;

    }

    public void addScore(int score){

        this.score += score;

    }



    public String toString(){

        String s = name + ":\n";
        for(int i = 0; i<deck.size(); i++){

            s += deck.get(i).getToken() + " ";

        }
        return s;

    }





}
