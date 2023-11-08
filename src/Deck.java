import java.util.ArrayList;
import java.util.List;

public class Deck {

    List<Token> deck;

    public Deck(Sack a){

        deck = new ArrayList<Token>();
        for(int i = 0; i<7; ++i) deck.add(a.pop());

    }

    public List<Token> getDeck(){

        return deck;

    }

    public void remove(int i){

        deck.remove(i);

    }

    public void add(Token a){

        deck.add(a);

    }


    public boolean isEmpty(){

        return deck.isEmpty();

    }


    public String toString(){

        String s = "";
        for (Token token : deck) s += token.getLetter() + " ";
        return s;

    }


}
