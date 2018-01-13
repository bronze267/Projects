import java.util.Scanner;

public class Connect4Player {

    Scanner scan;
    boolean isX;

    public Connect4Player() {
        scan = new Scanner(System.in);
        isX = true;
    }

    public int getInput() {
        while (!scan.hasNextInt()) 
        {        
            scan.next();
            System.out.print("Please enter an integer: \n");
        }
        return scan.nextInt();
    }

    public void swapPlayers() {
        isX = !isX;
    }

    public boolean isX() {
        return isX;
    }
    
    public String currentPlayer() {
        if ( isX ) {
            return "X";
        } else {
            return "O";
        }
    }
}
