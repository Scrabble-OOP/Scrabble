import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Deck {

    List<Token> deck;

    private Scanner scanner = new Scanner(System.in);

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


    //Este metodo devuelve falso, si no hubo ningun cambio por lo que se contara como un salto de turno
    //En otro caso true
    public boolean changeDeck(Sack sack){

        List<Token> aux = new ArrayList<>();

        while(true){

            System.out.println("Your deck is: " + this);
            System.out.println("Which letter do you want to change? or if you want to terminate press (E? ");
            char letter = scanner.next().charAt(0);

            if(letter == 'E') break;

            int index = search(letter);

            if(index == -1){

                System.out.println("You don't have that letter in your deck");
                continue;

            }
            aux.add(deck.get(index));
            deck.remove(index);

        }

        if(aux.isEmpty()) return false;

        List<Token> changes = sack.changeDeck(aux);

        for(int i = 0; i<changes.size(); i++) deck.add(new Token(changes.get(i).getLetter()));

        return true;

    }






















}
