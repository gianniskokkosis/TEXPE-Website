package exceptionstexpe;

public class UserNotFoundApplicationException extends Exception {
 
    public UserNotFoundApplicationException(String message) {
        super(message);
    }
}