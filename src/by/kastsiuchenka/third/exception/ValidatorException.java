package by.kastsiuchenka.third.exception;

public class ValidatorException extends Throwable {

    public ValidatorException() {
    }

    public ValidatorException(String message, Throwable e) {
        super(message,e);
    }

    public ValidatorException(String message) {
        super(message);
    }

    public ValidatorException(Throwable e) {
        super(e);
    }

}