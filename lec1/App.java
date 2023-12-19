package lec1;

public class App {
    public static void main(String[] args) {
        divide(10, 0);
    }

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new RuntimeException("Divide by zero not permited");
        }
        return a / b;
    }
}
