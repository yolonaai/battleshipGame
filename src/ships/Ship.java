package ships;

public abstract class Ship {
    private String name;
    private int startX;
    private int startY;
    private boolean horizontal;
    private int size;
    private int hits;

    public Ship(String name, int size, int startX, int startY, boolean horizontal) {
        this.name = name;
        this.size = size;
        this.startX = startX;
        this.startY = startY;
        this.horizontal = horizontal;
        this.hits = 0;
    }

    public void hit() {
        hits++;
    }

    public boolean isSunk() {
        return hits >= size;
    }

    public String getName() {
        return name;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public int getSize() {
        return size;
    }

    public String getIdentifier() {
        return name.substring(0, 1).toUpperCase(); // Returns the first letter of the ship's name as the identifier
    }
}