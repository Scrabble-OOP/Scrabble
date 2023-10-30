public class Token {

    private char letter;
    private byte score;

    private final byte[] scores = {

            1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 8, 1, 3, 1, 8, 1, 3, 5, 1, 1, 1, 1, 4, 8, 8, 4, 10

    };

    public Token() {

        this.letter = '_';
        this.score = 0;

    }
    public Token(char letter) {

        this.letter = letter;
        if(letter == '_') this.score = 0;

        else

            if(letter == 'ñ') this.score = 8;
            else this.score = scores[letter - 'a'];

    }










    public char getToken() {
        return letter;
    }

    public void setToken(char letter) {
        this.letter = letter;
    }

    public void setScore(byte score) {
        this.score = score;
    }

    public byte getScore(){
        return score;
    }



}
