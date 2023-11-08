import java.util.List;


public class Player {

    private String name;
    private int score;
    private Deck deck;

    public Player(String name, Sack sack){

        this.name = name;
        deck = new Deck(sack);
        score = 0;

    }





    public List<Token> getDeck(){

        return deck.getDeck();

    }


    public String getName(){

        return name;

    }

    public int getScore(){

        return score;

    }

    public void addScore(int score){

        this.score += score;

    }


    public void add(Sack sack){

        deck.add(sack.pop());

    }

    public void remove(int i){

        deck.remove(i);

    }



    public boolean empty(){

        return deck.isEmpty();

    }


    public boolean win(){

        return deck.isEmpty();

    }




    public String toString(){

        return name + " "  + " " + deck.toString();

    }











}
