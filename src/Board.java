public class Board {

    private Cell[][] board;
    private int score;
    private TrieTree dictionary;

    public Board(){

        board = new Cell[15][15];
        for(int i = 0; i<225; i++) board[i/15][i%15] = new Cell();

        DictionaryReader a = new DictionaryReader();
        dictionary = a.getDiccionario();
        score = 0;

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
    public Board(Board aux){

        score = aux.getScore();
        dictionary = aux.dictionary;
        board = new Cell[15][15];
        for(int i = 0; i<225; i++) board[i/15][i%15] = new Cell(aux.getCell(i/15, i%15));

    }




    public Cell getCell(int x, int y){

        return board[x][y];

    }

    public Cell[][] getBoard(){

        return board;

    }



    public int getScore(){

        return score;

    }











    //En estas verificaciones, nos vamos hasta el inicio de la palabra y despues verificamos si la palabra es valida
    //Ademas cada vez que se verifica un tablero, se actualizan sus puntos
    //El puntaje de un jugador es la diferencia entre el tablero actual y el anterior

    private boolean verifyFirstRow(){

        for(int i = 1; i<14; ++i){

            if(board[0][i].getLetter() != '_'){

                if(board[0][i+1].getLetter() == '_' && board[1][i].getLetter() == '_' && board[0][i-1].getLetter() == '_') return false;
                if(board[0][i+1].getLetter() != '_' && !verifyHor(0, i)) return false;
                if(board[1][i].getLetter() != '_' && !verifyVert(0, i)) return false;

            }

        }return true;

    }
    private boolean verifyLastRow(){

        for(int i = 1; i<14; i++){

            if(board[14][i].getLetter() != '_'){

                if(board[14][i+1].getLetter() == '_' && board[13][i].getLetter() == '_' && board[14][i-1].getLetter() == '_') return false;
                if(board[14][i+1].getLetter() != '_' && !verifyHor(14, i)) return false;
                if(board[13][i].getLetter() != '_' && !verifyVert(14, i)) return false;

            }

        }return true;

    }
    private boolean verifyFirstColumn(){

        for(int j = 1; j<14; j++){

            if(board[j][0].getLetter() != '_'){

                if(board[j+1][0].getLetter() == '_' && board[j][1].getLetter() == '_' && board[j-1][0].getLetter() == '_') return false;
                if(board[j+1][0].getLetter() != '_' && !verifyVert(j, 0)) return false;
                if(board[j][1].getLetter() != '_' && !verifyHor(j, 0)) return false;

            }
        }return true;

    }
    private boolean verifyLastColumn(){

        for(int j = 1; j<14; j++){

            if(board[j][14].getLetter() != '_'){

                if(board[j+1][14].getLetter() == '_' && board[j][13].getLetter() == '_' && board[j-1][14].getLetter() == '_') return false;
                if(board[j+1][14].getLetter() != '_' && !verifyVert(j, 14)) return false;
                if(board[j][13].getLetter() != '_' && !verifyHor(j, 14)) return false;

            }

        }return true;

    }
    private boolean verifyPoints(){

        if(board[0][0].getLetter() != '_'){

            if(board[0][1].getLetter() == '_' && board[1][0].getLetter() == '_') return false;
            if(board[0][1].getLetter() != '_' && !verifyHor(0, 0)) return false;
            if(board[1][0].getLetter() != '_' && !verifyVert(0, 0)) return false;

        }if(board[0][14].getLetter() != '_'){

            if(board[0][13].getLetter() == '_' && board[1][14].getLetter() == '_') return false;
            if(board[0][13].getLetter() != '_' && !verifyHor(0, 14)) return false;
            if(board[1][14].getLetter() != '_' && !verifyVert(0, 14)) return false;

        }if(board[14][0].getLetter() != '_'){

            if(board[14][1].getLetter() == '_' && board[13][0].getLetter() == '_') return false;
            if(board[14][1].getLetter() != '_' && !verifyHor(14, 0)) return false;
            if(board[13][0].getLetter() != '_' && !verifyVert(14, 0)) return false;

        }if(board[14][14].getLetter() != '_'){

            if(board[14][13].getLetter() == '_' && board[13][14].getLetter() == '_') return false;
            if(board[14][13].getLetter() != '_' && !verifyHor(14, 14)) return false;
            if(board[13][14].getLetter() != '_' && !verifyVert(14, 14)) return false;

        }return true;

    }
    private boolean verifyHor(int x, int y) {

        while(y > 0 && board[x][y-1].getLetter() != '_') --y;
        String word = ""; int temp = 0; int fact = 1;
        while(y<15 && board[x][y].getLetter() != '_') {

            word += board[x][y].getLetter();
            temp += board[x][y].getToken().getScore() * board[x][y].getFactLetter();
            fact *= board[x][y].getFactWord();
            ++y;

        }score += temp * fact;
        return dictionary.search(word);

    }
    private boolean verifyVert(int x, int y) {

        while(x > 0 && board[x-1][y].getLetter() != '_') --x;
        String word = ""; int temp = 0; int fact = 1;
        while(x<15 && board[x][y].getLetter() != '_') {

            word += board[x][y].getLetter();
            temp += board[x][y].getToken().getScore() * board[x][y].getFactLetter();
            fact *= board[x][y].getFactWord();
            ++x;

        }score += temp * fact;
        return dictionary.search(word);

    }
    public boolean verify(){

        score = 0;
        for(int i = 1; i<14; i++)
            for(int j = 1; j<14; ++j){

                if(board[i][j].getLetter() != '_'){

                    if(board[i][j+1].getLetter() == '_' && board[i][j-1].getLetter() == '_' && board[i+1][j].getLetter() == '_' && board[i-1][j].getLetter() == '_') return false;
                    if((board[i][j+1].getLetter() != '_' || board[i][j-1].getLetter() != '_') && !verifyHor(i, j)) return false;
                    if((board[i+1][j].getLetter() != '_' || board[i-1][j].getLetter() != '_') && !verifyVert(i, j)) return false;

                }

            }
        return verifyFirstRow() && verifyLastRow() && verifyFirstColumn() && verifyLastColumn() && verifyPoints();
    }









    //Si retorna true, entonces se quita el char del deck del jugador
    public boolean insertChar(int x, int y, char letter){

        if(board[x][y].getLetter() == '_') {

            board[x][y].setToken(new Token(letter));
            return true;

        }return false;

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
