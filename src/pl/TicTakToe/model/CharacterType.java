package pl.TicTakToe.model;

public enum CharacterType {
    NOUGHT('O'), CROSS('X');

    private char value;

    CharacterType(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}
