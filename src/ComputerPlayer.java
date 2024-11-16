import ships.BattleshipType;
import ships.Ship;
import ships.ShipFactory;

import java.util.Random;

public class ComputerPlayer extends Player {
    private Random random = new Random();

    public ComputerPlayer(String name, Board board) {
        super(name, board);
    }

    @Override
    public void placeShips() {
        // Randomly place ships on the board
        for (BattleshipType type : BattleshipType.values()) {
            boolean placed = false;
            while (!placed) {
                int x = random.nextInt(Board.getSize());
                int y = random.nextInt(Board.getSize());
                boolean horizontal = random.nextBoolean();

                Ship ship = ShipFactory.createShip(type, x, y, horizontal);
                placed = getBoard().placeShip(ship);
            }
        }
    }

    @Override
    public void makeGuess(Player opponent) {
        int x = random.nextInt(Board.getSize());
        int y = random.nextInt(Board.getSize());
        System.out.println("Computer guesses: (" + x + ", " + y + ")");

        if (opponent.getBoard().receiveGuess(x, y)) {
            System.out.println("Computer hit!");
            if (opponent.getBoard().allShipsSunk()) {
                System.out.println("Computer sunk all your ships! Computer wins!");
            }
        } else {
            System.out.println("Computer miss!");
        }
    }
}