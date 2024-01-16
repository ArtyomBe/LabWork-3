package coordinates.exceptions;

public class LocationWithThoseCoordinatesAlreadyExistException extends RuntimeException {
    public LocationWithThoseCoordinatesAlreadyExistException(String message) {
        super(message);
    }
}
