public class Board {

    private Cell[][] board;

    public Board(){

        board = new Cell[15][15];

        board[0][0] = new Cell(0, 3);
        board[0][7] = new Cell(0, 3);
        board[0][14] = new Cell(0, 3);
        board[7][0] = new Cell(0, 3);   //aqui se llenan las casillas 3P
        board[7][14] = new Cell(0, 3);
        board[14][0] = new Cell(0, 3);
        board[14][7] = new Cell(0, 3);
        board[14][14] = new Cell(0, 3);


        board[1][5] = new Cell(3, 0);
        board[1][9] = new Cell(3, 0);
        board[5][1] = new Cell(3, 0);
        board[5][5] = new Cell(3, 0);
        board[5][9] = new Cell(3, 0);
        board[5][13] = new Cell(3, 0);   // aqui se llenan las casillas 3L
        board[9][1] = new Cell(3, 0);
        board[9][5] = new Cell(3, 0);
        board[9][9] = new Cell(3, 0);
        board[9][13] = new Cell(3, 0);
        board[13][5] = new Cell(3, 0);
        board[13][9] = new Cell(3, 0);


        board[0][3] = new Cell(2, 0);
        board[0][11] = new Cell(2, 0);
        board[2][6] = new Cell(2, 0);
        board[2][8] = new Cell(2, 0);
        board[3][0] = new Cell(2, 0);
        board[3][7] = new Cell(2, 0);
        board[3][14] = new Cell(2, 0);
        board[6][2] = new Cell(2, 0);
        board[6][6] = new Cell(2, 0);
        board[6][8] = new Cell(2, 0);
        board[6][12] = new Cell(2, 0);  //aqui se llenan las casillas 2L
        board[7][3] = new Cell(2, 0);
        board[7][11] = new Cell(2, 0);
        board[8][2] = new Cell(2, 0);
        board[8][6] = new Cell(2, 0);
        board[8][8] = new Cell(2, 0);
        board[8][12] = new Cell(2, 0);
        board[11][0] = new Cell(2, 0);
        board[11][7] = new Cell(2, 0);
        board[11][14] = new Cell(2, 0);
        board[12][6] = new Cell(2, 0);
        board[12][8] = new Cell(2, 0);
        board[14][3] = new Cell(2, 0);
        board[14][11] = new Cell(2, 0);


        board[1][1] = new Cell(0, 2);
        board[1][13] = new Cell(0, 2);
        board[2][2] = new Cell(0, 2);
        board[2][12] = new Cell(0, 2);
        board[3][3] = new Cell(0, 2);
        board[3][11] = new Cell(0, 2);
        board[4][4] = new Cell(0, 2); //aqui se llenan las casillas 2P
        board[4][10] = new Cell(0, 2);
        board[7][7] = new Cell(0, 2);
        board[10][4] = new Cell(0, 2);
        board[10][10] = new Cell(0, 2);
        board[11][3] = new Cell(0, 2);
        board[11][11] = new Cell(0, 2);
        board[12][2] = new Cell(0, 2);
        board[12][12] = new Cell(0, 2);
        board[13][1] = new Cell(0, 2);
        board[13][13] = new Cell(0, 2);


    }

    public Cell getCell(int x, int y){

        return board[x][y];

    }


}
