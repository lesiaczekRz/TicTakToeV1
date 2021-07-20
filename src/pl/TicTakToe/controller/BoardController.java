package pl.TicTakToe.controller;

import pl.TicTakToe.model.BoardModel;
import pl.TicTakToe.model.CharacterType;
import pl.TicTakToe.view.BoardView;

import java.util.Scanner;

public class BoardController {
    public void run() {
        Scanner scan = new Scanner(System.in);
        BoardView boardView = new BoardView();
        BoardModel boardModel = new BoardModel();
        String coordinates = "";
        int i = 0;
        CharacterType character;
        while (!coordinates.equals("Q")) {
            i++;
            character = i % 2 == 0 ? CharacterType.NOUGHT : CharacterType.CROSS;
            boardView.displayBoard(character);
            coordinates = scan.nextLine().toUpperCase();
            boardModel.setCoordinates(character, coordinates.charAt(0), coordinates.charAt(1));
        }
    }
}
