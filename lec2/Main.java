package lec2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
//        int number = 1;
//        try {
//            number = 10 / 1;
//            String test = null;
////            System.out.println(test.length());
//            Collections.emptyList().add(new Object());
//        }  catch (ArithmeticException e) {
//            System.out.println("You can't divide by zero");
//        } catch (NullPointerException e) {
//            System.out.println("nullpointer exception");
//        } catch (Exception e) {
//            System.out.println("exception");
//        }
//        System.out.println(number);
//    }
        FileReader test = null;
        try {
            test = new FileReader("test");
            test.read();
        } catch (RuntimeException | IOException e) {
            System.out.println("catch exception:" + e.getClass().getSimpleName());
        } finally {
            System.out.println("finally start");
            if (test != null) {
                try {
                test.close();
                } catch (IOException e) {
                    System.out.println("exception with close");
                }
            }
            System.out.println("finally close");
        }

    }
}
