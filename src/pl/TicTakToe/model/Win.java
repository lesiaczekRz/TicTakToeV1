package pl.TicTakToe.model;

import static java.lang.StrictMath.abs;

public class Win {

    /**
     * Sprawdza czy wystąpiła wygrana
     *
     * @param arrayBoard char[][]
     * @return boolean
     */
    public boolean isWin(char[][] arrayBoard) {
        return checkObliquelyRight(arrayBoard)
                || checkObliquelyLeft(arrayBoard)
                || checkVertically(arrayBoard)
                || checkHorizontally(arrayBoard);
    }

    /**
     * Sprawdza poziomo czy istnieją 3 takie same znaki
     *
     * @param arrayBoard char[][]
     * @return boolean
     * @deprecated
     */
    private static boolean oldCheckHorizontally(char[][] arrayBoard) {    // ta metoda ma złożoność obliczeniową O(n^2), bo porównujesz każdy element z każdym. wystarczy, że jeden się będzie różnił, nie musisz sprawdzać wszystkich.
        char first;
        int sameItem = 0;
        for (int y = 0; y < BoardModel.HEIGHT; y++) {
            first = arrayBoard[y][0];
            for (int x = 1; x < BoardModel.WIDTH; x++) {
                if (sameItem == BoardModel.WIDTH - 1) {
                    return true;
                }
                sameItem++;
                if (oldCheckIfDifferent(arrayBoard, first, y, x)) {
                    sameItem = 0;
                    break;
                }
            }
        }
        return false;
    }

    /**
     * Sprawdza poziomo czy istnieją 3 takie same znaki
     *
     * @param arrayBoard char[][]
     * @return boolean
     */
    private static boolean checkHorizontally(char[][] arrayBoard) {
        for (int y = 0; y < BoardModel.HEIGHT; y++) {
            if (isAllEqual(arrayBoard[y])) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sprawdza pionowo czy istnieją 3 takie same znaki
     *
     * @param arrayBoard char[][]
     * @return boolean
     * @deprecated
     */
    private static boolean oldCheckVertically(char[][] arrayBoard) {
        char first;
        int sameItem = 0;
        for (int x = 0; x < BoardModel.WIDTH; x++) {
            first = arrayBoard[0][x];
            for (int y = 1; y < BoardModel.HEIGHT; y++) {
                if (sameItem == BoardModel.HEIGHT - 1) {
                    return true;
                }
                sameItem++;
                if (oldCheckIfDifferent(arrayBoard, first, y, x)) {
                    sameItem = 0;
                    break;
                }
            }
        }
        return false;
    }

    /**
     * Sprawdza pionowo czy istnieją 3 takie same znaki
     *
     * @param arrayBoard char[][]
     * @return boolean
     */
    private static boolean checkVertically(char[][] arrayBoard) {
        for (int x = 0; x < BoardModel.WIDTH; x++) {
            char[] workingArray = new char[BoardModel.HEIGHT];
            for (int y = 0; y < BoardModel.HEIGHT; y++) {
                workingArray[y] = arrayBoard[y][x];
            }
            if (isAllEqual(workingArray)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sprawdza ukośnie w prawo czy istnieją 3 takie same znaki
     *
     * @deprecated
     * @param arrayBoard char[][]
     * @return boolean
     */
    private static boolean oldCheckObliquelyRight(char[][] arrayBoard) {
        char first = arrayBoard[BoardModel.HEIGHT - 1][0];
        int x;
        for (int y = BoardModel.HEIGHT - 2; y >= 0; y--) {
            x = abs(y - BoardModel.WIDTH + 1);
            if (oldCheckIfDifferent(arrayBoard, first, y, x)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sprawdza ukośnie w prawo czy istnieją 3 takie same znaki
     *
     * @param arrayBoard char[][]
     * @return boolean
     */
    private static boolean checkObliquelyRight(char[][] arrayBoard) {
        int x, i = 0;
        char[] workingArray = new char[BoardModel.WIDTH];
        for (int y = BoardModel.HEIGHT - 1; y >= 0; y--) {
            x = abs(y - BoardModel.WIDTH + 1);
            workingArray[i++] = arrayBoard[y][x];
        }
        return isAllEqual(workingArray);
    }

    /**
     * Sprawdza ukośnie w lewo czy istnieją 3 takie same znaki
     *
     * @deprecated
     * @param arrayBoard char[][]
     * @return boolean
     */
    private static boolean oldCheckObliquelyLeft(char[][] arrayBoard) {
        char first = arrayBoard[0][0];
        for (int y = 1; y < BoardModel.HEIGHT; y++) {
            //noinspection SuspiciousNameCombination
            if (oldCheckIfDifferent(arrayBoard, first, y, y)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sprawdza ukośnie w lewo czy istnieją 3 takie same znaki
     *
     * @param arrayBoard char[][]
     * @return boolean
     */
    private static boolean checkObliquelyLeft(char[][] arrayBoard) {
        char[] workingArray = new char[BoardModel.HEIGHT];
        for (int y = 0; y < BoardModel.HEIGHT; y++) {
            workingArray[y] = arrayBoard[y][y];
        }
        return isAllEqual(workingArray);
    }

    /**
     * // o to to to mniej więcej o coś takiego chodziło, ale dla wszystkich elementów, a niekoniecznie tylko dwóch...
     * Sprawdza czy pierwszy element jest różny od kolejnego podanego na podstawie współrzędnych
     * Jeżeli jest różny, lub null to w wyniku jest true
     *
     * @deprecated
     * @param arrayBoard char[][]
     * @param first      char
     * @param y          int
     * @param x          int
     * @return boolean
     */
    private static boolean oldCheckIfDifferent(char[][] arrayBoard, char first, int y, int x) {
        return (int) arrayBoard[y][x] == 0 ||
                !(arrayBoard[y][x] == first);
    }

    /**
     * Porównuje czy wszystkie elementy tablicy są takie same
     *
     * @param charArray char[]
     * @return boolean
     */
    private static boolean isAllEqual(char[] charArray) {
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] != charArray[i - 1] || (int) charArray[i] == 0) {
                return false;
            }
        }
        return true;
    }
}
