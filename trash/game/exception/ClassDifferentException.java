package scptcg.game.exception;

public class ClassDifferentException extends RuntimeException {
    public ClassDifferentException(String s) {
        super(s);
    }

    public ClassDifferentException() {
        super();
    }
}