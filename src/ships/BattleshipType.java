package ships;

/**
 * Enumerates the different types of battleships.
 */
public enum BattleshipType {
  BATTLESHIP,
  SUBMARINE,
  PATROL_BOAT,
  CARRIER;

  /**
   * Converts the string representation of a battleship type to the corresponding BattleshipType.
   *
   * @param type The string representation of the battleship type.
   * @return The corresponding BattleshipType.
   */
  public static BattleshipType fromString(String type) {
    switch (type.toUpperCase()) {
      case "BATTLESHIP":
        return BATTLESHIP;
      case "SUBMARINE":
        return SUBMARINE;
      case "PATROLBOAT":
      case "PATROL_BOAT":
        return PATROL_BOAT;
      case "CARRIER":
        return CARRIER;
      default:
        throw new IllegalArgumentException("Unknown ship type: " + type);
    }
  }
}