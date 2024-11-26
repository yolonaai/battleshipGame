package ships;

public abstract class Ship {
    private String name;
    private String identifier;
    private int startX;
    private int startY;
    private int size;
    private boolean horizontal;
    private int hits;

    public Ship(String name, int size, int startX, int startY, boolean horizontal) {
        this.name = name;
        this.identifier = name.substring(0, 1).toUpperCase();
        this.startX = startX;
        this.startY = startY;
        this.size = size;
        this.horizontal = horizontal;
        this.hits = 0;
    }

    public String getName() {
        return name;
    }

    public String getIdentifier() {
        return identifier;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public int getSize() {
        return size;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public void hit() {
        hits++;
    }

    public boolean isSunk() {
        return hits >= size;
    }
}