import ships.Ship;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class Board {
    private Map<Coordinate, Ship> grid = new HashMap<>();
    private List<Ship> ships = new ArrayList<>();
    private static final int size = 10;

    public boolean placeShip(Ship ship) {
        if (canPlaceShip(ship.getStartX(), ship.getStartY(), ship.getSize(), ship.isHorizontal())) {
            int x = ship.getStartX();
            int y = ship.getStartY();
            for (int i = 0; i < ship.getSize(); i++) {
                if (ship.isHorizontal()) {
                    grid.put(new Coordinate(x + i, y), ship);
                } else {
                    grid.put(new Coordinate(x, y + i), ship);
                }
            }
            ships.add(ship);
            return true;
        }
        return false;
    }

    private boolean canPlaceShip(int x, int y, int length, boolean horizontal) {
        for (int i = 0; i < length; i++) {
            if (horizontal) {
                if (grid.containsKey(new Coordinate(x + i, y))) return false;
            } else {
                if (grid.containsKey(new Coordinate(x, y + i))) return false;
            }
        }
        return true;
    }

    public boolean receiveGuess(int x, int y) {
        Coordinate coord = new Coordinate(x, y);
        Ship ship = grid.get(coord);
        if (ship != null) {
            ship.hit();
            if (ship.isSunk()) {
                System.out.println(ship.getName() + " has been sunk!");
            }
            return true;
        }
        return false;
    }

    public boolean allShipsSunk() {
        return ships.stream().allMatch(Ship::isSunk);
    }

    public void displayBoard() {
        // Display logic for the board
    }

    /**
     * Gets the size of the board.
     *
     * @return The size of the board.
     */
    public static int getSize() {
        return size;
    }
}