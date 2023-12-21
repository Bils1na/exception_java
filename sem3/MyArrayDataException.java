package sem3;

public class MyArrayDataException extends NumberFormatException {
    public MyArrayDataException(int i, int j) {
        super("Element is not a number in [" + i + " " + j + "]");
    }
}
