package pl.TicTakToe.model;

import org.apache.commons.lang3.ArrayUtils;

public class Validator {

    /**
     * Sprawdza czy podano dopuszczalny znak
     *
     * @param type char
     * @param x    char
     * @return boolean
     */
    static boolean isWrongCoordinate(char type, char x) {
        char[] charArray = new char[]{};
        if (type == 'X') {
            charArray = new char[]{'A', 'B', 'C'};
        } else if (type == 'Y') {
            charArray = new char[]{'1', '2', '3'};
        }
        return !ArrayUtils.contains(charArray, x);
    }

    /**
     * Sprawdza czy w tym polu już istnieje jakaś wartość
     *
     * @param arrayBoard char[][]
     * @param x          int
     * @param y          int
     * @return boolean
     */
    static boolean checkIfExists(char[][] arrayBoard, int x, int y) {
        return !((int) arrayBoard[y][x] == 0);
    }
}
