package hw3.exception;

public class DataSizeException extends RuntimeException {

    public DataSizeException(int size) {
        super("Программа принимает только 6 типов данных. Вы указали " + size + ".");
    }
}
