package pl.TicTakToe.model;

public interface BoardSettable { // nie wydaje mi się, by to musiało być interfejsem, to mogłaby być po prostu metoda w modelu
    void setCoordinates(CharacterType character, char x, char y);
}
