package sem3;

public class DivideByZeroException extends ArithmeticException {
    public DivideByZeroException() {
        super("You can't divide by zero");
    }
}
