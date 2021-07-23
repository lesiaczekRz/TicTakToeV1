package pl.TicTakToe.model;

import pl.TicTakToe.view.BoardView;

public class BoardModel {
    public final static int HEIGHT = 3;
    public final static int WIDTH = 3;
    private final char[][] arrayBoard = new char[HEIGHT][WIDTH];
    private final BoardView boardView = new BoardView();
    private int paramX, paramY;

    public boolean setCoordinates(CharacterType character, char x, char y) {
        if (checkForErrors(x, y)) {
            return false;
        } else {
            arrayBoard[paramY][paramX] = character.getValue();
            return true;
        }
    }

    public char[][] getArrayBoard() {
        return arrayBoard;
    }

    /**
     * Sprawdza błędy
     *
     * @param x         char
     * @param y         char
     * @return boolean
     */
    private boolean checkForErrors(char x, char y) {
        if (Validator.isWrongCoordinate('X', x)) {
            boardView.displayWrongCoordinates("Podano błędną współrzędną: " + x);
            return true;
        }
        //noinspection SuspiciousNameCombination
        if (Validator.isWrongCoordinate('Y', y)) {
            boardView.displayWrongCoordinates("Podano błędną współrzędną: " + y);
            return true;
        }
        paramX = (int) x - 65;
        paramY = Character.getNumericValue(y) - 1;
        if (Validator.checkIfExists(arrayBoard, paramX, paramY)) {
            boardView.displayWrongCoordinates("W tym polu istnieje już wartość");
            return true;
        }
        return false;
    }
}
