package coordinates.exceptions;

public class ObjectDoesNotExistInMapException extends NullPointerException{
    public ObjectDoesNotExistInMapException(String message) {
        super(message);
    }
}
