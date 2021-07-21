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
        Pattern compiledPattern = Pattern.compile(search);  // jest taki żart programistyczny: miałem problem, postanowiłem rozwiązać go przy pomocy regexa. Teraz mam dwa problemy.
        Matcher matcher = compiledPattern.matcher(String.valueOf(x)); // zamiast używać regexa, wrzuć ABC i 123 do dwóch tablic i użyj ArrayUtils.contains()
        if (!matcher.find()) {
            throw new MyNewException("Podano nieprawidłowy znak: " + x);
        }
    }

    /** // ta metoda wygląda mi jakby dotyczyła planszy, powinna być zawarta w Board
     * Sprawdza czy w tym polu już istnieje jakaś wartość
     *
     * @param x          int
     * @param y          int
     */
    static void checkIfExists(int x, int y) throws MyNewException { // czy ta metoda musi rzucać wyjątkiem? nie wystarczy by zwracała true/false?
        if (!(BoardModel.ARRAY_BOARD[y][x] == null)) {
            throw new MyNewException("W tym polu już istnieje wartość");
        }
    }
}
