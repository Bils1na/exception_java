package sem2;

import java.io.*;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
//        int index = 0;
//        Scanner scanner = new Scanner(System.in);
//        int[] arr = new int[10];
//        System.out.println("Укажите индекс элемента массива, в который хотите записать значение 1");
//
//        try {
//            index = scanner.nextInt();
//        } catch (InputMismatchException e) {
//            throw new RuntimeException("Не тот тип данных");
////            System.out.println("Не тот тип данных");
//        }
//
//        if (index < arr.length && index > -1) arr[index] = 1;
//        else System.out.println("IndexOutOfBoundsException");

//        String[][] arr2d = {
//                {"a", null, "7"},
//                null,
//                {"4", "5"},
//        };
//        System.out.println(sum2d(arr2d));

        // Task2

        System.out.println(checkFile("fileTest"));
        HashMap<String, Integer> temp = checkFile("fileTest");
        FileWriter fileWriter = new FileWriter("fileTest", false);
        for (String key : temp.keySet()) {
            fileWriter.append(key + "=" + temp.get(key) + "\n");
        }
        fileWriter.close();
    }

    public static int sum2d(String[][] arr) {
        if (arr == null) throw new RuntimeException("NullPointerException");
        int val = 0;
        int sum = 0;
        for (int i = 0; i < arr. length; i++) {
            if (arr[i] == null) {
                arr[i] = new String[]{"0"};
            };
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == null) arr[i][j] = "0";
                try {
                    val = Integer.parseInt(arr[i][j]);
                } catch (NumberFormatException e) {
//                    e.printStackTrace();
                    System.out.println("Не тот тип данныx");
                }
                sum += val;
            }
        }
        return sum;
    }

//    Запишите в файл следующие строки:
//
//    Анна=4
//
//    Елена=5
//
//    Марина=6
//
//    Владимир=?
//
//    Константин=?
//
//    Иван=4
//
//    Реализуйте метод, который считывает данные из файла и сохраняет в
//    двумерный массив (либо HashMap, если студенты с ним знакомы).
//    В отдельном методе нужно будет пройти по структуре данных, если
//    сохранено значение ?, заменить его на соответствующее число.Если
//    на каком-то месте встречается символ, отличный от числа или ?, бросить
//    подходящее исключение.Записать в тот же файл данные с замененными символами ?.

        public static HashMap<String, Integer> checkFile(String pathToFile) {
            HashMap<String, Integer> temp = new HashMap<>();
            try {
                File file = new File(pathToFile);
                if (!file.exists()) {
                    return null;
                } else {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader((file)));
                    System.out.println("file.existed");
                    Iterator<String> iterator = bufferedReader.lines().iterator();
                    while (iterator.hasNext()) {
                        String[] strings = iterator.next().split("=");
                        try {
                            if (strings[1].equals("?")) temp.put(strings[0], strings[0].length());
                            else temp.put(strings[0], Integer.parseInt(strings[1]));
                        } catch (NumberFormatException e) {
                            throw new RuntimeException("Ошибка преобразования");
                        }
                    }
                    bufferedReader.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return temp;
        }
}
