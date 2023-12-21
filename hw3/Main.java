package hw3;

import hw3.exception.DataSizeException;
import hw3.exception.NumberSizeException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        DataHandler dataHandler = new DataHandler();
        try {
            dataHandler.addNewUser();
            System.out.println(dataHandler.getUserData());
            try {
                writeUserData(dataHandler, Path.of(String.format("./hw3/%s.txt", dataHandler.getUserSurname())));
            } catch (IOException e) {
                System.out.println("Ошибка в работе с файлом");
            }
        } catch (DataSizeException | NumberSizeException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Не верный формат ввода для номера телефона. Введите по образцу - 89991234567.");
        }


    }

    public static void writeUserData(DataHandler dh, Path pathWrite) throws IOException {
        try (FileWriter writer = new FileWriter(String.valueOf(pathWrite), true)) {
            writer.write(dh.getUserData() + "\n");
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом");
        }
    }

    private static void checkPhonebook (Path pathRead, DataHandler dh) throws FileNotFoundException {
        File file = new File(String.valueOf(pathRead));
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

    }

}
