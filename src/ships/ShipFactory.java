package ships;

public class ShipFactory {
    public static Ship createShip(BattleshipType type, int startX, int startY, boolean horizontal) {
        switch (type) {
            case BATTLESHIP:
                return new Battleship(startX, startY, horizontal);
            case SUBMARINE:
                return new Submarine(startX, startY, horizontal);
            case PATROL_BOAT:
                return new PatrolBoat(startX, startY, horizontal);
            case CARRIER:
                return new Carrier(startX, startY, horizontal);
            default:
                throw new IllegalArgumentException("Unknown ship type: " + type);
        }
    }
}