package exceptions;

public class AnimalIsNotDeadException extends RuntimeException {
    public AnimalIsNotDeadException(String message) {
        super(message);
    }
}
