package by.kastsiuchenka.third.exception;

public class CreatorException extends Exception {

    public CreatorException() {
    }

    public CreatorException(String message, Throwable e) {
        super(message,e);
    }

    public CreatorException(String message) {
        super(message);
    }

    public CreatorException(Throwable e) {
        super(e);
    }

}