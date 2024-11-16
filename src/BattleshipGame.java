public class BattleshipGame {
    public static void main(String[] args) {
        String path = "C:\\Users\\naail\\Downloads\\a2StarterFiles\\src\\config.txt";
        Board computerBoard = ConfigFileReader.parseBoard(path);
        Board humanBoard = new Board();

        HumanPlayer humanPlayer = new HumanPlayer("Human", humanBoard);
        ComputerPlayer computerPlayer = new ComputerPlayer("Computer", computerBoard);

        humanPlayer.placeShips();
        computerPlayer.placeShips();

        while (!humanBoard.allShipsSunk() && !computerBoard.allShipsSunk()) {
            humanPlayer.makeGuess(computerPlayer);
            if (!computerBoard.allShipsSunk()) {
                computerPlayer.makeGuess(humanPlayer);
            }
        }
    }
}