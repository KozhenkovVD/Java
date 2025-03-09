package exceptions;

public class NotExistUser extends RuntimeException {
    public NotExistUser(String message) {
        super(message);
    }
}
