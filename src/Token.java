public class Token {

    private char letter;
    private byte score;

    public Token(char letter, byte score) {

        this.letter = letter;
        this.score = score;

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
