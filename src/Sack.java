import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Sack {

    private ArrayList<Token> tokens;

    private final char[] letters = {

            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    private final byte[] cant = {

            12, 2, 4, 5, 12, 1, 2, 2, 6, 1, 1, 4, 2, 5, 1, 9, 2, 2, 5, 6, 4, 5, 1, 1, 1, 1, 1

    };







    //Este metodo recibe una lista de tokens
    //y los agrega al saco
    //baraja el saco
    //y devuelve una lista de mismo tamaño pero con otros tokens
    public List<Token> changeDeck(List<Token> changes){

        List<Token> aux = new ArrayList<>(); int size = changes.size();

        for(int i = 0; i<changes.size(); i++)  tokens.add(new Token(changes.get(i).getLetter()));

        shuffle();

        for(int i = 0; i<size; i++) aux.add(pop());

        return aux;


    }









    public Sack() {

        tokens = new ArrayList<Token>();
        //tokens.add(new Token(true)); Esta lineas estan comentadas por ahora para evitar los jokers
        //tokens.add(new Token(true));
        for(int i = 0; i<27; i++){

            for(int j = 0; j<cant[i]; j++){

                tokens.add(new Token(letters[i]));
            }
        }shuffle();

    }



    public Sack(Sack aux){

        tokens = new ArrayList<>(aux.getSack());
        shuffle();

    }





    public ArrayList<Token> getSack(){

        return tokens;

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


    public boolean isEmpty() {
        return tokens.isEmpty();
    }

    public String toString() {

        String s = "";
        for(int i = 0; i<tokens.size(); i++){
            s += tokens.get(i).toString() + " ";
        }
        return s;
    }


}
