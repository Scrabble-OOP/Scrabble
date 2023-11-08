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



    public boolean canFormWord(String word) {

        int[] letterCount = new int[27]; // Incluimos un índice adicional para la 'ñ'
        // Contar las letras en el ArrayList
        for (Token token : deck) {

            if (token.getLetter() == 'ñ')
                letterCount[26]++;
            else
                letterCount[token.getLetter() - 'a']++;

        }
        // Verificar si es posible formar la palabra
        for (char c : word.toCharArray()) {

            int index = ((c =='ñ') ? 26 : c - 'a');
            if (letterCount[index] < 0)  return false;
            letterCount[index]--;                       // No hay suficientes letras para formar la palabra

        } return true;
    }


    public void removeWord(String word){

        for(int i = 0; i<word.length(); i++){

            int index = search(word.charAt(i));
            deck.remove(index);

        }

    }





}
