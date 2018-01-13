public class Connect4Board {
    
    char[][] board;
    
    public Connect4Board() {
        board = new char[7][7];
        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 7; ++j) {
                board[i][j] = ' ';
            }
        }
    }
    
    public void emptyBoard() {
        for (int i = 0; i < 7; ++i) {
            for (int j = 0; j < 7; ++j) {
                board[i][j] = ' ';
            }
        }
    }
    
    public String printBoard() {
        String output = "";
        
        for (int row = 0; row < 7; ++row) {
            for (int col = 0; col < 7; ++col)
                output+= "[" + board[row][col] + "] ";
            output += "\n";
        }
        
        return output;
    }
    
    public boolean putToken(int column, char player) {
        if (board[0][column] != ' ')
            return false;
        
        for (int row = 0; row < 7; ++row) {
            
            
            if (board[row][column] != ' ') {
                board[row - 1][column] = player;
                return true;
            }
        }
        
        board[6][column] = player;

        return true;
    }

    public boolean checkDiagLR(int row, int column) {
        if (board[row][column] == ' ') {
            return false;
        }

        if ( board[row][column] == board[row + 1][column + 1] && board[row + 1][column + 1] == board[row + 2][column + 2] && board[row + 2][column + 2] == board[row + 3][column + 3]) {
            return true;
        }
        return false;
    }
    
    public boolean diagRL() {
        for ( int row = 0; row <= 3; row++ ) {
            for (int column = 0; column <= 3; column++) {
                if (checkDiagLR(row, column)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkDiagRL(int row, int column) {

        if (board[row][column] == ' ') {
            return false;
        }

        if ( board[row][column] == board[row + 1][column - 1] && board[row + 1][column - 1] == board[row + 2][column - 2] && board[row + 2][column - 2] == board[row + 3][column - 3]) {
            return true;
        }

        return false;
    }
    
    public boolean diagLR() {
        for ( int row = 0; row <= 3; row++ ) {
            for ( int column = 6; column >= 3; column--) {
                if (checkDiagRL(row, column)) {
                    return true;
                }
            }
        }

        return false;
    }
    
    public boolean down4() {
        for (int i = 0; i < 7; i++) {
            int a = 0;
            for (int k = 1; k < 7; k++) {
                if (board[k][i] != ' ' && board[k][i] == board[k-1][i]) {
                    a++;
                } else {
                    a = 1;
                }
                if (a >= 4) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean across4() {
        for (int row = 0; row < 7; row++) {
            int a = 1;
            for (int column = 0; column < 6; column++) {
                if (board[row][column] != ' ' && board[row][column] == board[row][column + 1]) {
                    a++;
                } else {
                    a = 1;
                }
                if (a >= 4) {
                    return true;
                }
            }
        }
        return false;
    }
    
}
