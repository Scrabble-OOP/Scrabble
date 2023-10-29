public class Cell {

    private int factLetter;
    private int factWord;
    private Token token;







    public Cell(int factLetter, int factWord) {
        this.factLetter = factLetter;
        this.factWord = factWord;
        this.token = null;
    }

    public Cell(int factLetter, int factWord, Token token) {

        this.factLetter = factLetter;
        this.factWord = factWord;
        this.token = token;

    }

    public Cell(){

        this.factLetter = 1;
        this.factWord = 1;
        this.token = null;

    }


    public int getFactLetter() {
        return factLetter;
    }

    public void setFactLetter(byte factLetter) {
        this.factLetter = factLetter;
    }

    public int getFactWord() {
        return factWord;
    }

    public void setFactWord(byte factWord) {
        this.factWord = factWord;
    }


    public void setToken(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }

    public char getLetter(){ return token.getToken();}


}
