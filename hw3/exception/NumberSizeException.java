package hw3.exception;

public class NumberSizeException extends RuntimeException {

    public NumberSizeException(int size) {
        super("Длина номера должна быть 11 символов. Вы укзаали длинну " + size + ".");
    }
}
