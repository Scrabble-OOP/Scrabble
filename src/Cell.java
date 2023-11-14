public class Cell {

    private int factLetter;
    private int factWord;
    private Token token;








    public Cell(int factLetter, int factWord) {

        this.factLetter = factLetter;
        this.factWord = factWord;
        this.token = new Token();
    }

    public Cell(int factLetter, int factWord, Token token) {

        this.factLetter = factLetter;
        this.factWord = factWord;
        this.token = token;

    }

    public Cell(){

        this.factLetter = 1;
        this.factWord = 1;
        this.token = new Token();

    }



    public Cell(Cell aux){

        this.factLetter = aux.getFactLetter();
        this.factWord = aux.getFactWord();
        this.token = new Token(aux.getToken());

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

    public char getLetter(){
        return token.getLetter();
    }


    public void setLetter(char letter){

        token.setToken(letter);

    }



}
