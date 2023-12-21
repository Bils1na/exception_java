package sem3;

public class ContainsNullException extends NullPointerException {
    public ContainsNullException () {
        super("This array contains null-element");
    }
}
