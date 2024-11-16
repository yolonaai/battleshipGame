import ships.BattleshipType;
import ships.Ship;
import ships.ShipFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ConfigFileReader {
    public static Board parseBoard(String filename) {
        Board board = new Board();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String shipType = parts[0];
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);
                boolean horizontal = parts[3].equalsIgnoreCase("H");

                Ship ship = ShipFactory.createShip(BattleshipType.fromString(shipType), x, y, horizontal);
                board.placeShip(ship);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return board;
    }
}