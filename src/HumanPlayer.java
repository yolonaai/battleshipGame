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
        // Loop to place each type of ship
        for (BattleshipType type : BattleshipType.values()) {
            System.out.println("Enter details for " + type + " (x y H/V):");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            boolean horizontal = parts[2].equalsIgnoreCase("H");

            Ship ship = ShipFactory.createShip(type, x, y, horizontal);
            if (getBoard().placeShip(ship)) {
                getBoard().displayBoard();
            } else {
                System.out.println("Invalid placement. Try again.");
            }
        }
    }


    @Override
    public void makeGuess(Player opponent) {
        System.out.println("Enter your guess (x y):");
        String input = scanner.nextLine();
        String[] parts = input.split(" ");
        int x = Integer.parseInt(parts[0]);
        int y = Integer.parseInt(parts[1]);

        if (opponent.getBoard().receiveGuess(x, y)) {
            System.out.println("Hit!");
            if (opponent.getBoard().allShipsSunk()) {
                System.out.println("You sunk all opponent's ships! You win!");
            }
        } else {
            System.out.println("Miss!");
            opponent.makeGuess(this); // Computer's turn
        }
    }
}