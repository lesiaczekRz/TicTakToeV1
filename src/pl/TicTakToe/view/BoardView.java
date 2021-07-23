package pl.TicTakToe.view;

import pl.TicTakToe.model.BoardModel;
import pl.TicTakToe.model.CharacterType;

public class BoardView implements BoardDisplayable {

    /**
     * Wyświetla plansze do gry
     *
     * @param arrayBoard char[][]
     */
    @Override
    public void displayBoard(char[][] arrayBoard) {
        String[][] tableForUser = getTableForUser(arrayBoard);
        for (int y = 0; y < BoardModel.HEIGHT + 1; y++) {
            for (int x = 0; x < BoardModel.WIDTH + 1; x++) {
                System.out.print(tableForUser[y][x]);
            }
            System.out.println();
        }
    }

    /**
     * Wyświetla komendę dla użytkownika
     *
     * @param character {@link CharacterType}
     */
    @Override
    public void displayCommand(CharacterType character) {
        System.out.println("Proszę podać współrzędne od A1 do C3 (wielkość liter nie ma znaczenia).");
        System.out.println("Wyjście z programu po wpisaniu q.");
        System.out.println("Teraz: " + character.getValue());
    }

    /**
     * Wyświetla informacje o wygranym
     *
     * @param character {@link CharacterType}
     */
    @Override
    public void displayWin(CharacterType character) {
        System.out.println("Wygrał: " + character.getValue());
    }

    /**
     * Wyświetla komunikat w momencie podanie błędnych współrzędnych
     * @param message String
     */
    @Override
    public void displayWrongCoordinates(String message) {
        System.out.println(message);
    }

    /**
     * Pobiera tabelę wygodną dla użytkownika (informacje na temat współrzędnych, itp.)
     *
     * @return String[][]
     */
    private String[][] getTableForUser(char[][] arrayBoard) {
        String[][] tableForUser = new String[BoardModel.HEIGHT + 1][BoardModel.WIDTH + 1];
        tableForUser[0] = new String[]{"  ", " A ", " B ", " C "};
        for (int y = 1; y < BoardModel.HEIGHT + 1; y++) {
            tableForUser[y] = new String[BoardModel.WIDTH + 1];
            tableForUser[y][0] = y + " ";
            for (int x = 1; x < BoardModel.WIDTH + 1; x++) {
                tableForUser[y][x] = (int) arrayBoard[y - 1][x - 1] == 0 ?
                        "   " : " " + arrayBoard[y - 1][x - 1] + " ";
            }
        }
        return tableForUser;
    }
}
