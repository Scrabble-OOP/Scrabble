public class Board {

    private Cell[][] board;

    private TrieTree dictionary;

    public Board(){

        board = new Cell[15][15];
        for(int i = 0; i<225; i++) board[i/15][i%15] = new Cell();

        DictionaryReader a = new DictionaryReader();
        dictionary = a.getDiccionario();

        board[0][0] = new Cell(1, 3);
        board[0][7] = new Cell(1, 3);
        board[0][14] = new Cell(1, 3);
        board[7][0] = new Cell(1, 3);   //aqui se llenan las casillas 3P
        board[7][14] = new Cell(1, 3);
        board[14][0] = new Cell(1, 3);
        board[14][7] = new Cell(1, 3);
        board[14][14] = new Cell(1, 3);


        board[1][5] = new Cell(3, 1);
        board[1][9] = new Cell(3, 1);
        board[5][1] = new Cell(3, 1);
        board[5][5] = new Cell(3, 1);
        board[5][9] = new Cell(3, 1);
        board[5][13] = new Cell(3, 1);   // aqui se llenan las casillas 3L
        board[9][1] = new Cell(3, 1);
        board[9][5] = new Cell(3, 1);
        board[9][9] = new Cell(3, 1);
        board[9][13] = new Cell(3, 1);
        board[13][5] = new Cell(3, 1);
        board[13][9] = new Cell(3, 1);


        board[0][3] = new Cell(2, 1);
        board[0][11] = new Cell(2, 1);
        board[2][6] = new Cell(2, 1);
        board[2][8] = new Cell(2, 1);
        board[3][0] = new Cell(2, 1);
        board[3][7] = new Cell(2, 1);
        board[3][14] = new Cell(2, 1);
        board[6][2] = new Cell(2, 1);
        board[6][6] = new Cell(2, 1);
        board[6][8] = new Cell(2, 1);
        board[6][12] = new Cell(2, 1);  //aqui se llenan las casillas 2L
        board[7][3] = new Cell(2, 1);
        board[7][11] = new Cell(2, 1);
        board[8][2] = new Cell(2, 1);
        board[8][6] = new Cell(2, 1);
        board[8][8] = new Cell(2, 1);
        board[8][12] = new Cell(2, 1);
        board[11][0] = new Cell(2, 1);
        board[11][7] = new Cell(2, 1);
        board[11][14] = new Cell(2, 1);
        board[12][6] = new Cell(2, 1);
        board[12][8] = new Cell(2, 1);
        board[14][3] = new Cell(2, 1);
        board[14][11] = new Cell(2, 1);


        board[1][1] = new Cell(1, 2);
        board[1][13] = new Cell(1, 2);
        board[2][2] = new Cell(1, 2);
        board[2][12] = new Cell(1, 2);
        board[3][3] = new Cell(1, 2);
        board[3][11] = new Cell(1, 2);
        board[4][4] = new Cell(1, 2); //aqui se llenan las casillas 2P
        board[4][10] = new Cell(1, 2);
        board[7][7] = new Cell(1, 2);
        board[10][4] = new Cell(1, 2);
        board[10][10] = new Cell(1, 2);
        board[11][3] = new Cell(1, 2);
        board[11][11] = new Cell(1, 2);
        board[12][2] = new Cell(1, 2);
        board[12][12] = new Cell(1, 2);
        board[13][1] = new Cell(1, 2);
        board[13][13] = new Cell(1, 2);


    }

    public Cell getCell(int x, int y){

        return board[x][y];

    }

    public Cell[][] getBoard(){

        return board;

    }




















    private boolean verifyHor(int x, int y) {

        while(board[x][y].getLetter() != '_') --y;

        String word = "";

        while(y<15 && board[x][y].getLetter() != '_') {

            word += board[x][y].getLetter();
            ++y;

        }return dictionary.search(word);

    }

    //En estas verificaciones, nos vamos hasta el inicio de la palabra y despues verificamos si la palabra es valida
    private boolean verifyVert(int x, int y) {

        while(board[x][y].getLetter() != '_') --x;

        String word = "";

        while(x<15 && board[x][y].getLetter() != '_'){

            word += board[x][y].getLetter();
            ++x;

        }return dictionary.search(word);


    }
















    public boolean verify(){

        for(int i = 0; i<15; i++)
            for(int j = 0; j<15; j++){

                if(board[i][j].getLetter() != '_'){

                    if(i<14 && j<14 && board[i+1][j].getLetter() == '_' && board[i][j+1].getLetter() == '_') return false;
                    if(i<14 && board[i+1][j].getLetter() != '_' && !verifyVert(i, j)) return false;
                    if(j<14 && board[i][j+1].getLetter() != '_' && !verifyHor(i, j)) return false;

                }

            }return !(board[14][14].getLetter() != '_' &&
                board[14][13].getLetter() == '_' &&
                board[13][14].getLetter() == '_');

    }










    public void insertChar(int x, int y, char letter){

        if(board[x][y].getLetter() == '_')

            board[x][y].setLetter(letter);



    }











    public static Cell[][] copy(Cell[][] board){

        Cell[][] copy = new Cell[15][15];
        for(int i = 0; i<225; i++)
            copy[i/15][i%15] = new Cell(board[i/15][i%15].getFactLetter(), board[i/15][i%15].getFactWord(), board[i/15][i%15].getToken());
        return copy;

    }















    public String toString(){

        String s = "";

        for(int i = 0; i<15; i++){
            for(int j = 0; j<15; j++){

                s += board[i][j].getLetter() + " ";

            }
            s += "\n";
        }
        return s;
    }





}
