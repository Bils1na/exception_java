package hw3;

import hw3.exception.DataSizeException;
import hw3.exception.NumberSizeException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        DataHandler dataHandler = new DataHandler();
        try {
            dataHandler.addNewUser();
            try {
                FileHandler.writeUserData(dataHandler, Path.of(String.format("./hw3/phonebook/%s.txt", dataHandler.getUserSurname())));
            } catch (IOException e) {
                System.out.println("Ошибка в работе с файлом");
            }
        } catch (DataSizeException | NumberSizeException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Не верный формат ввода для номера телефона. Введите по образцу - 89991234567.");
        }


    }

}