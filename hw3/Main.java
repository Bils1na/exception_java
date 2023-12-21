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
                rwLine(dataHandler, Path.of("./hw3/phonebook.txt"));
            } catch (IOException e) {
                System.out.println("Ошибка в работе с файлом");
            }
        } catch (DataSizeException | NumberSizeException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Не верный формат ввода для номера телефона. Введите по образцу - 89991234567.");
        }


    }

    public static void rwLine(DataHandler dh, Path pathWrite) throws IOException {
        File file = new File(String.valueOf(pathWrite));
        FileWriter writer = new FileWriter(String.valueOf(pathWrite), true);
        try {
            writer.write(dh.getUserData() + "\n");
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом");
        } finally {
            writer.close();
        }
    }

}
