package pl.TicTakToe.model;

import org.apache.commons.lang3.ArrayUtils;

public class Validator {

    /**
     * Sprawdza czy podano dopuszczalny znak
     *
     * @param type char
     * @param x    char
     */
    static void checkCoordinate(char type, char x) throws WrongParameter {
        char[] charArray = new char[]{};
        if (type == 'X') {
            charArray = new char[]{'A', 'B', 'C'};
        } else if (type == 'Y') {
            charArray = new char[]{ '1', '2', '3' };
        }
        if (!ArrayUtils.contains(charArray, x)) { // poprawione na ArrayUtils.contains z regexp
            throw new WrongParameter("Podano nieprawidłowy znak: " + x);
        }
    }

    /**
     * // ta metoda wygląda mi jakby dotyczyła planszy, powinna być zawarta w Board
     * Sprawdza czy w tym polu już istnieje jakaś wartość
     *
     * @param arrayBoard char[][]
     * @param x          int
     * @param y          int
     */
    static void checkIfExists(char[][] arrayBoard, int x, int y) throws WrongParameter { // czy ta metoda musi rzucać wyjątkiem? nie wystarczy by zwracała true/false?
        if (!((int) arrayBoard[y][x] == 0)) {
            throw new WrongParameter("W tym polu już istnieje wartość");
        }
    }
}
