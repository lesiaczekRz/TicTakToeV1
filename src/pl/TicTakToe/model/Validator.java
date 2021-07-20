package pl.TicTakToe.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    /**
     * Sprawdza czy podano dopuszczalny znak
     *
     * @param type char
     * @param x    char
     */
    static void checkCoordinate(char type, char x) throws MyNewException {
        String search = "";
        if (type == 'X') {
            search = "[ABC]";
        } else if (type == 'Y') {
            search = "[123]";
        }
        Pattern compiledPattern = Pattern.compile(search);
        Matcher matcher = compiledPattern.matcher(String.valueOf(x));
        if (!matcher.find()) {
            throw new MyNewException("Podano nieprawidłowy znak: " + x);
        }
    }

    /**
     * Sprawdza czy w tym polu już istnieje jakaś wartość
     *
     * @param x          int
     * @param y          int
     */
    static void checkIfExists(int x, int y) throws MyNewException {
        if (!(BoardModel.ARRAY_BOARD[y][x] == null)) {
            throw new MyNewException("W tym polu już istnieje wartość");
        }
    }
}
