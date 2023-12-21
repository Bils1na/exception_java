package hw3.exception;

public class DateFormException extends RuntimeException{
    public DateFormException() {
        super("Дата введене в неверной форме. Введите по примеру - дд.мм.гггг.");
    }
}
