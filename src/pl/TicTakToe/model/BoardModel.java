package pl.TicTakToe.model;

public class BoardModel implements BoardSettable {
    public final static int HEIGHT = 3;
    public final static int WIDTH = 3;
    public final static String[][] ARRAY_BOARD = new String[HEIGHT][WIDTH];
    private int paramX, paramY;

    @Override
    public void setCoordinates(CharacterType character, char x, char y) {
        if (!checkForErrors(x, y)) {
            BoardModel.ARRAY_BOARD[paramY][paramX] = String.valueOf(character.getValue());
        }
    }

    /**
     * Sprawdza błędy
     *
     * @param x         char
     * @param y         char
     * @return boolean
     */
    private boolean checkForErrors(char x, char y) {
        try {
            Validator.checkCoordinate('X', x);
            //noinspection SuspiciousNameCombination
            Validator.checkCoordinate('Y', y);
            paramX = convertX(x) - 1;
            paramY = Character.getNumericValue(y) - 1;
            Validator.checkIfExists(paramX, paramY);
        } catch (MyNewException e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }

    /**
     * Konwertuje współrzędną x na indeks tablicy arrayBoard
     *
     * @param x char
     * @return int
     */
    private static int convertX(char x) {
        return switch (x) {
            case 'A' -> 1;
            case 'B' -> 2;
            case 'C' -> 3;
            default -> 0;
        };
    }
}
