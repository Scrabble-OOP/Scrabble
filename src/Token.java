import javax.swing.*;

public class Token extends JButton {

    private char letter;
    private int score;
    private boolean joker;

    private final byte[] scores = {

            1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 8, 1, 3, 1, 8, 1, 3, 5, 1, 1, 1, 1, 4, 8, 8, 4, 10

    };

    public Token() {

        this.letter = '_';
        this.score = 0;
        this.joker = false;

    }

    public Token(boolean joker) {

        this.letter = 'J';
        this.score = 0;
        this.joker = joker;

    }


    public Token(char letter) {
        this.setText("" + letter);

        this.letter = letter;

        if(letter == '_') this.score = 0;

        else if(letter == 'ñ') this.score = 8;

        else this.score = scores[letter - 'a'];


    }




    public Token(Token aux){

        this.letter = aux.getLetter();
        this.score = aux.getScore();
        this.joker = aux.isJoker();
        this.setText("" + getLetter());

    }










    public char getLetter() {
        return letter;
    }

    public void setToken(char letter) {
        this.letter = letter;
    }

    public void setScore(byte score) {
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public String toString() {
        return letter + "";
    }

    public boolean isJoker() {
        return joker;
    }



}
