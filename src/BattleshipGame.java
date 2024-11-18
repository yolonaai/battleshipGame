import java.util.Scanner;

public class BattleshipGame {
    public static void main(String[] args) {
        // Read configuration file and create the board
        String path = "C:\\Users\\naail\\Downloads\\a2StarterFiles\\src\\config.txt";
        Board compBoard = ConfigFileReader.parseBoard(path);
        ComputerPlayer compPlayer = new ComputerPlayer("Computer", compBoard);

        // Initialize Player 1's board
        Board player1Board = new Board();
        HumanPlayer player1 = new HumanPlayer("Player 1", player1Board);

        // Place Player 1 ships manually
        player1.placeShips();

        // Start the game loop
        boolean gameOver = false;
        while (!gameOver) {
            // Player 1's turn
            System.out.println("Player 1's turn:");
            player1.takeTurn(compPlayer);

            // Check for game over conditions
            if (compPlayer.getBoard().allShipsSunk()) {
                System.out.println("Player 1 wins!");
                gameOver = true;
                break;
            }

            // Computer's turn
            System.out.println("Computer's turn:");
            compPlayer.takeTurn(player1);

            // Check for game over conditions
            if (player1Board.allShipsSunk()) {
                System.out.println("Computer wins!");
                gameOver = true;
            }
        }
    }
}