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

    public void setDeck(List<Token> aux){

        deck = new Deck(aux);

    }


    public void replenishDeck(Sack sack){

        deck.replenishDeck(sack);

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



    public void removeChar(char i){

        deck.remove(i);

    }





    //Un jugador gana cuando se queda sin fichas y ademas el saco esta vacio
    public boolean win(Sack sack){

        return deck.isEmpty() && sack.isEmpty();

    }



    //Si el jugador no cambio ninguna ficha se cuenta como salto de turno
    //En otro caso true
    public boolean changeDeck(Sack sack){

        return deck.changeDeck(sack);

    }







    public int sumDeck(){

        return deck.sumDeck();

    }



    public String toString(){

        return name + " "  + " " + deck.toString();

    }











}
