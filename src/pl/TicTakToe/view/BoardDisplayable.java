package pl.TicTakToe.view;

import pl.TicTakToe.model.CharacterType;

public interface BoardDisplayable {
    void displayBoard(char[][] arrayBoard);

    void displayCommand(CharacterType character);

    void displayWin(CharacterType character);

    void displayWrongCoordinates(String message);
}
