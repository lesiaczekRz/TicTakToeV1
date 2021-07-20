package pl.TicTakToe;

import pl.TicTakToe.controller.BoardController;

public class Main {
    public static void main(String[] args) {
        BoardController boardController = new BoardController();
        boardController.run();
    }
}