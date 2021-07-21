package pl.TicTakToe.model;

public class BoardModel implements BoardSettable {
    public final static int HEIGHT = 3;
    public final static int WIDTH = 3;
    public final static String[][] ARRAY_BOARD = new String[HEIGHT][WIDTH];     // To nie powinno być static. Lepiej zrobić do tego gettera i tak się do tego dostawać. Czemu to jest tablica stringów, a nie np charów? tu się powinien pojawić tylko pojedynczy znak
    private int paramX, paramY;

    @Override
    public void setCoordinates(CharacterType character, char x, char y) { // czemu x i y to są char a nie int?
        if (!checkForErrors(x, y)) {
            BoardModel.ARRAY_BOARD[paramY][paramX] = String.valueOf(character.getValue());
        }
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
    private static int convertX(char x) { // char to pojedynczy znak z tablicy ASCII. Każdy znak ma swój unikalny kod, np A = 65, B=66 itp. Można zatem tę metodę sprowadzić do rzutowania char na int i odjęciu 64.
        return switch (x) {
            case 'A' -> 1;
            case 'B' -> 2;
            case 'C' -> 3;
            default -> 0;
        };
    }
}
