public class Board {

    private Cell[][] board;

    private TrieTree dictionary;

    public Board(){

        board = new Cell[15][15];
        for(int i = 0; i<225; i++) board[i/15][i%15] = new Cell();

        DictionaryReader a = new DictionaryReader();
        TrieTree dictionary = a.getDiccionario();

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




    //primer intento de verificación
    public boolean verify(){

        for(int i = 0; i<15; i++){
            for(int j = 0; j<15; j++){

                if(board[i][j].getLetter() == '\0') {

                    String s = board[i][j].getLetter() + "";
                    while (j < 15 && board[i][j].getLetter() == '\0') {

                        s += board[i][j].getLetter();
                        j++;

                    }
                    if(!dictionary.search(s)){
                        return false;
                    }
                }
            }

        }return true;

    }




}
