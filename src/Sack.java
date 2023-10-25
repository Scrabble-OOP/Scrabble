import java.util.ArrayList;
import java.util.Collections;


public class Sack {

    private ArrayList<Token> tokens;

    public Sack() {
        tokens = new ArrayList<Token>();
        //aqui llenamos el saco de fichas
    }

    public Token pop(){

        Token a = tokens.get(0);
        tokens.remove(0);
        return a;

    }


    private void shuffle(){
        Collections.shuffle(tokens);
    }




    public int size() {
        return tokens.size();
    }


}
