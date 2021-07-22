package pl.TicTakToe.model;

public class BoardModel {
    public final static int HEIGHT = 3;
    public final static int WIDTH = 3;
    private final char[][] arrayBoard = new char[HEIGHT][WIDTH];     // poprawione
    private int paramX, paramY;

    public boolean setCoordinates(CharacterType character, char x, char y) { // czemu x i y to są char a nie int?
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
     * @param x         char // czemu char a nie int?
     * @param y         char // czemu char a nie int?
     * @return boolean
     */
    private boolean checkForErrors(char x, char y) { 
        try {
            Validator.checkCoordinate('X', x); //ta metoda nic nie zwraca, czy nie interesuje nas wynik walidacji w tym miejscu?
            //noinspection SuspiciousNameCombination
            Validator.checkCoordinate('Y', y);
            paramX = (int) x - 65;
            paramY = Character.getNumericValue(y) - 1;
            Validator.checkIfExists(arrayBoard, paramX, paramY);
        } catch (WrongParameter e) {
            System.out.println(e.getMessage());
            return true;
        }
        return false;
    }
}
