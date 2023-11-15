import java.util.ArrayList;
import java.util.List;

public class Deck {

    List<Token> deck;

    public Deck(Sack a){

        deck = new ArrayList<Token>();
        for(int i = 0; i<7; ++i) deck.add(a.pop());

    }


    public Deck(List<Token> aux){

        deck = new ArrayList<>(aux);

    }





    public List<Token> getDeck(){

        return deck;

    }










    public void remove(char i){

        deck.remove(search(i));

    }








    public void add(Token a){

        deck.add(a);

    }







    public int search(char letter){

        for(int i = 0; i<deck.size(); ++i){

            if(deck.get(i).getLetter() == letter) return i;

        }return -1;

    }








    public boolean isEmpty(){

        return deck.isEmpty();

    }










    public String toString(){

        String s = "";
        for (Token token : deck) s += token.getLetter() + " ";
        return s;

    }



    public void replenishDeck(Sack a){

        while(deck.size()<7 && !a.isEmpty()) deck.add(a.pop());

    }





    public boolean canFormWord(String word) {

        int[] letterCount = new int[27]; // Incluimos un índice adicional para la 'ñ'
        // Contar las letras en el ArrayList
        for (Token token : deck) {

            int index = ((token.getLetter() == 'ñ') ? 26 : token.getLetter() - 'a');
            letterCount[index]++;

        }

        for (char c : word.toCharArray()) {

            int index = ((c =='ñ') ? 26 : c - 'a');
            if (letterCount[index] < 0)  return false;
            letterCount[index]--;                       // No hay suficientes letras para formar la palabra

        }return true;
    }


















}
