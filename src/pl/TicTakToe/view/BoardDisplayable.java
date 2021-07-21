package pl.TicTakToe.view;

import pl.TicTakToe.model.CharacterType;

public interface BoardDisplayable {
    void displayBoard();

    void displayCommand(CharacterType character);

    void displayWin(CharacterType character);
}
