package homeworks.homework12.exception;

public class NotValidData extends RuntimeException{
    public NotValidData(String message) {
        super(message);
    }
}
