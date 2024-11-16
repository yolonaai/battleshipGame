/**
 * Represents a coordinate on a 2D grid.
 */
public class Coordinate {
    private int x; // x-coordinate
    private int y; // y-coordinate

    // Constructor that initializes the x and y coordinates
    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getter methods for the x and y coordinates
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Override the equals() method to compare coordinates
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Coordinate that = (Coordinate) obj;
        return x == that.x && y == that.y;
    }

    // Override the toString() method for easy debugging
    @Override
    public String toString() {
        return "Coordinate{" + "x=" + x + ", y=" + y + '}';
    }
}