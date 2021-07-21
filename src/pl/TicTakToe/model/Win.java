package pl.TicTakToe.model;

import static java.lang.StrictMath.abs;

public class Win implements Winnable {

    /**
     * Sprawdza czy wystąpiła wygrana
     *
     * @return boolean
     */
    @Override
    public boolean isWin() {
        return checkObliquelyRight()
                || checkObliquelyLeft()
                || checkVertically()
                || checkHorizontally();
    }

    /**
     * Sprawdza poziomo czy istnieją 3 takie same znaki
     *
     * @return boolean
     */
    private static boolean checkHorizontally() {    // ta metoda ma złożoność obliczeniową O(n^2), bo porównujesz każdy element z każdym. wystarczy, że jeden się będzie różnił, nie musisz sprawdzać wszystkich.
        String first;
        int sameItem = 0;
        for (int y = 0; y < BoardModel.HEIGHT; y++) {
            first = BoardModel.ARRAY_BOARD[y][0];
            for (int x = 1; x < BoardModel.WIDTH; x++) {
                if (sameItem == BoardModel.WIDTH - 1) {
                    return true;
                }
                sameItem++;
                if (checkIfDifferent(first, y, x)) {
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
     * @return boolean
     */
    private static boolean checkVertically() {
        String first;
        int sameItem = 0;
        for (int x = 0; x < BoardModel.WIDTH; x++) {
            first = BoardModel.ARRAY_BOARD[0][x];
            for (int y = 1; y < BoardModel.HEIGHT; y++) {
                if (sameItem == BoardModel.HEIGHT - 1) {
                    return true;
                }
                sameItem++;
                if (checkIfDifferent(first, y, x)) {
                    sameItem = 0;
                    break;
                }
            }
        }
        return false;
    }

    /**
     * Sprawdza ukośnie w prawo czy istnieją 3 takie same znaki
     *
     * @return boolean
     */
    private static boolean checkObliquelyRight() {
        String first = BoardModel.ARRAY_BOARD[BoardModel.HEIGHT - 1][0];
        int x;
        for (int y = BoardModel.HEIGHT - 2; y >= 0; y--) {
            x = abs(y - BoardModel.WIDTH + 1);
            if (checkIfDifferent(first, y, x)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sprawdza ukośnie w lewo czy istnieją 3 takie same znaki
     *
     * @return boolean
     */
    private static boolean checkObliquelyLeft() {
        String first = BoardModel.ARRAY_BOARD[0][0];
        for (int y = 1; y < BoardModel.HEIGHT; y++) {
            //noinspection SuspiciousNameCombination
            if (checkIfDifferent(first, y, y)) {
                return false;
            }
        }
        return true;
    }

    /** // otototo mniej więcej o coś takiego chodziło, ale dla wszystkich elementów, a niekoniecznie tylko dwóch...
     * Sprawdza czy pierwszy element jest różny od kolejnego podanego na podstawie współrzędnych
     * Jeżeli jest różny, lub null to w wyniku jest true
     *
     * @param first String
     * @param y     int
     * @param x     int
     * @return boolean
     */
    private static boolean checkIfDifferent(String first, int y, int x) {
        return BoardModel.ARRAY_BOARD[y][x] == null ||
                !BoardModel.ARRAY_BOARD[y][x].equals(first);
    }
    
    
    //ja bym zaproponował coś takiego:
    private boolean isAllEqual(char[] charArray){
        for (int i=1; i<charArray.length; i++){
            if (charArray[i] != charArray[i-1])
                return false;
        } return true;
    }
    // jest uniwersalna metoda sprawdzająca, której trzeba tylko podać zbiór danych.
}
