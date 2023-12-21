package sem3;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;


public class Main {
    public static void main(String[] args) throws MyArraySizeException {
//         Task3
//        rwLine(Path.of("1.txt"), Path.of("test"));

        // Task 4
//        try (Counter counter = new Counter()) {
//            System.out.println(counter.add());
//        }

//        FileReader fileReader = new FileReader("pov.xml"); example
//        fileReader.read();
//        fileReader.close();
//        fileReader = null;


        // Task5
//        1. Создайте класс исключения, который будет выбрасываться при делении на 0.
//        Исключение должно отображать понятное для пользователя сообщение об ошибке.
//
//        2. Создайте класс исключений, которое будет возникать при обращении к пустому
//        элементу в массиве ссылочного типа. Исключение должно отображать понятное для
//        пользователя сообщение об ошибке.
//
//        3. Создайте класс исключения, которое будет возникать при попытке открыть
//        несуществующий файл. Исключение должно отображать понятное для пользователя сообщение об ошибке.
//        try {
//            int num1 = 7 / 0;
//        } catch (ArithmeticException e) {
//            throw new DivideByZeroException();
//        }

//        String[] array = {"01", null};
//
//        try {
//            for (int i = 0; i < array.length; i++) {
//                System.out.println(array[i].length());
//            }
//        } catch (NullPointerException e) {
//            throw new ContainsNullException();
//        }

//        FileReader fileReader = null;
//        try {
//            fileReader = new FileReader("testNotFound.txt");
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//        try {
//            fileReader.read();
//        } catch (IOException e) {
//            throw new FileDoesNotExist();
//        }

        //Task 6
//        Напишите метод, на вход которого подаётся двумерный строковый массив размером 4х4.
//            При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
//
//        1. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
//                Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит
//                символ или текст вместо числа), должно быть брошено исключение MyArrayDataException с
//    детализацией, в какой именно ячейке лежат неверные данные.
//        2. В методе main() вызвать полученный метод, обработать возможные исключения MyArraySizeException
//        и MyArrayDataException и вывести результат расчета (сумму элементов, при условии что подали
//        на вход корректный массив).

        String[][] array2d = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4", "5"},
                {"1", "2", "3", "4"},
        };
        try {
        System.out.println(sumArray(array2d));
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

    }

    public  static int sumArray(String[][] array2d) throws MyArraySizeException {
        int sum = 0;
        int rows = array2d.length;
        boolean isReact = true;

        for (int i = 0; i < array2d.length; i++) {
            if (array2d[i].length != rows) isReact = false;
            for (int j = 0; j < array2d[i].length; j++) {
                try {
                    sum += Integer.parseInt(array2d[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }

        if (!isReact) throw new MyArraySizeException();

        return sum;
    }

    public static void rwLine(Path pathRead, Path pathWrite) throws IOException {

        try (BufferedReader in = Files.newBufferedReader(pathRead);
             BufferedWriter out = Files.newBufferedWriter(pathWrite)) {
            while (in.ready()) {
                out.write(in.readLine());
            }
        }
    }
}
