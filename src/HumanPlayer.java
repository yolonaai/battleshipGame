import ships.BattleshipType;
import ships.Ship;
import ships.ShipFactory;

import java.util.Scanner;

public class HumanPlayer extends Player {

    private Scanner scanner = new Scanner(System.in);

    public HumanPlayer(String name, Board board) {
        super(name, board);
    }

    @Override
    public void placeShips() {
        System.out.println("Place your ships:");

        // Place Patrol Boat
        placeShip(BattleshipType.PATROLBOAT, "Patrol Boat", 2);

        // Place Submarine
        placeShip(BattleshipType.SUBMARINE, "Submarine", 3);

        // Place Battleship
        placeShip(BattleshipType.BATTLESHIP, "Battleship", 4);

        // Place Carrier
        placeShip(BattleshipType.CARRIER, "Carrier", 5);
    }

    private void placeShip(BattleshipType type, String name, int size) {
        boolean placed = false;
        while (!placed) {
            System.out.printf("Enter coordinates for %s (x y orientation): ", name);
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String orientation = scanner.next();

            boolean horizontal = orientation.equalsIgnoreCase("H");
            Ship ship = ShipFactory.createShip(type, x, y, horizontal);

            if (board.placeShip(ship)) {
                System.out.printf("%s placed successfully.\n", name);
                placed = true;
            } else {
                System.out.println("Failed to place " + name + ". Try again.");
            }
        }
    }

    @Override
    public int[] makeGuess(Player opponent) {
        System.out.print("Enter your guess (x y): ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        return new int[]{x, y};
    }

    public void takeTurn(ComputerPlayer opponent) {
        int[] guess = makeGuess(opponent);
        boolean hit = opponent.getBoard().receiveGuess(guess[0], guess[1]);
        if (hit) {
            System.out.println("Hit!");
        } else {
            System.out.println("Miss.");
        }
    }
}