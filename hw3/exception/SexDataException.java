package hw3.exception;

public class SexDataException extends RuntimeException {
    public SexDataException() {
        super("Пол введен в неверном формате");
    }
}
