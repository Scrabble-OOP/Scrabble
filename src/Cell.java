public class Cell {

    private int value;
    private Token token;


    public Cell(int value) {
        this.value = value;
        this.token = null;
    }

    public Cell(int value, Token token) {
        this.value = value;
        this.token = token;
    }


    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public Token getToken() {
        return token;
    }


}
