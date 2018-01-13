public class Connect4Game {

    public static void main(String[] args) {
     
        Connect4Board board = new Connect4Board();
        Connect4Player player = new Connect4Player();
        
        boolean isOver = false;
        
        int playCount = 0;
        
        while ( !isOver ) {

            System.out.println(board.printBoard());

            if (player.isX())
                System.out.println("X's turn!");
            else {
                System.out.println("O's turn!");
            }
            
            System.out.println("Choose a column:");
            
            int column = player.getInput();
            
            if (column < 1 || column > 7) {
                System.out.println("Choose a column through 1-7");
                continue;
            }

            if (!board.putToken(column - 1, player.isX() ? 'X' : 'O')) {
                System.out.println("A token is already there.");
                continue;
            }
            
            if ( board.diagLR() || board.diagRL() || board.down4() || board.across4() ) {
                System.out.println("\n" + board.printBoard());
                System.out.println(player.currentPlayer() + " won!");
                isOver = true;
                break;
            }

            System.out.println();
            playCount++;
            
            if ( playCount == 49 ) {
                System.out.println("Board full.");
                board.emptyBoard();
                System.out.println(board.printBoard());
                playCount = 0;
            }
            
            player.swapPlayers();
        }
    }
    
    
    
    
}
