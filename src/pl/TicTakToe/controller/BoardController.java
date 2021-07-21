package pl.TicTakToe.controller;

import pl.TicTakToe.model.BoardModel;
import pl.TicTakToe.model.CharacterType;
import pl.TicTakToe.model.Win;
import pl.TicTakToe.view.BoardView;

import java.util.Scanner;

public class BoardController {
    private final BoardModel boardModel = new BoardModel(); // przy restarcie gry dobrze by było wyczyścić planszę, więc może nie powinna być final
    private final BoardView boardView = new BoardView();
    private final Win win = new Win();

    public void run() {
        Scanner scan = new Scanner(System.in);
        String coordinates = ""; //coordinates = scan.nextLine().toUpperCase(); jak pobierzesz dane od użytkownika przed pętlą, to możliwe, że nawet w nią nie będziesz musiał wchodzić
        int i = 0;
        CharacterType character;
        while (!coordinates.equals("Q")) {
            i++;
            character = i % 2 == 0 ? CharacterType.NOUGHT : CharacterType.CROSS;
            boardView.displayCommand(character);
            coordinates = scan.nextLine().toUpperCase(); 
            if (!continueGame(coordinates, character)) {
                coordinates = "Q";
            }
        }
    }

    private boolean continueGame(String coordinates, CharacterType character) {
        if (coordinates.equals("Q")) {
            return false;
        } else { // trzeba sprawdzić, czy występują 2 elementy, zanim się do nich odniesiesz
            boardModel.setCoordinates(character, coordinates.charAt(0), coordinates.charAt(1)); // a jeśli się nie da, to trzeba by powtórzyć ruch
            boardView.displayBoard();
            if (win.isWin()) {
                boardView.displayWin(character);
                return false;
            }
            return true;
        }
    }
}
