package pl.TicTakToe.model;

public class MyNewException extends Exception { // Ten wyjątek powinien mieć jakąś bardziej deskryptywną nazwę. W jakich sytuacjach się go rzuca?
    public MyNewException(String errorMessage) {
        super(errorMessage);
    }
}
