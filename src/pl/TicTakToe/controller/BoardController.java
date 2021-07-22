package pl.TicTakToe.controller;

import pl.TicTakToe.model.BoardModel;
import pl.TicTakToe.model.CharacterType;
import pl.TicTakToe.model.Win;
import pl.TicTakToe.view.BoardView;

import java.util.Scanner;

public class BoardController {
    private final BoardModel boardModel = new BoardModel(); // IntelliJ upiera się że powinno być final. Pewnie dlatego, że nowa gra, to ponowne uruchomienie programu.
    private final BoardView boardView = new BoardView();
    private final Win win = new Win();

    public void run() {
        if (playGame(CharacterType.CROSS)) {
            CharacterType character = CharacterType.NOUGHT;
            while (playGame(character)) {
                character = character == CharacterType.CROSS ? CharacterType.NOUGHT : CharacterType.CROSS;
            }
        }
    }

    /**
     * Rozpoczyna grę wyświetlając komendę i pobierając dane od użytkownika
     *
     * @param character {@link CharacterType}
     * @return boolean
     */
    private boolean playGame(CharacterType character) {
        Scanner scan = new Scanner(System.in);
        boardView.displayCommand(character);
        String coordinates = scan.nextLine().toUpperCase();
        return continueGame(coordinates, character);
    }

    /**
     * Decyduje o tym czy kontynuować grę
     *
     * @param coordinates {@link String}
     * @param character   {@link CharacterType}
     * @return boolean
     */
    private boolean continueGame(String coordinates, CharacterType character) {
        if (coordinates.equals("Q")) {
            return false;
        } else if (coordinates.length() == 2) {
            return changeBoard(coordinates, character);
        } else {
            boardView.displayWrongCoordinates();
            return playGame(character);
        }
    }

    /**
     * Zmienia i wyświetla planszę
     *
     * @param coordinates {@link String}
     * @param character   {@link CharacterType}
     * @return boolean
     */
    private boolean changeBoard(String coordinates, CharacterType character) {
        if (!boardModel.setCoordinates(character, coordinates.charAt(0), coordinates.charAt(1))) {
            return playGame(character);
        }
        boardView.displayBoard(boardModel.getArrayBoard());
        if (win.isWin(boardModel.getArrayBoard())) {
            boardView.displayWin(character);
            return false;
        }
        return true;
    }
}
