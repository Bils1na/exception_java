package hw3;

import hw3.exception.DataSizeException;
import hw3.exception.DateFormException;
import hw3.exception.NumberSizeException;
import hw3.exception.SexDataException;

import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        DataHandler dataHandler = new DataHandler();
//        try {
//            dataHandler.addNewUser();
//            try {
//                FileHandler.writeUserData(dataHandler,
//                        Path.of(String.format("./hw3/phonebook/%s.txt", dataHandler.getUserSurname())));
//            } catch (IOException e) {
//                System.out.println("Ошибка в работе с файлом");
//            }
//        } catch (DataSizeException | NumberSizeException | SexDataException | DateFormException e) {
//            System.out.println(e.getMessage());
//        } catch (NumberFormatException e) {
//            System.out.println("Не верный формат ввода для номера телефона. Введите по образцу - 89991234567.");
//        }

        boolean isActive = true;
        Scanner scanner = new Scanner(System.in);

        while (isActive) {
            DataHandler dataHandler = new DataHandler();
            System.out.println("Если хотите добавить контакт введите - 1 \n" +
                                "Если хотите выйти введите - 0");
            String input = scanner.next();

            if (input.equals("0")) isActive = false;
            if (input.equals("1")) {
                try {
                    dataHandler.addNewUser();
                    try {
                        FileHandler.writeUserData(dataHandler,
                                Path.of(String.format("./hw3/phonebook/%s.txt", dataHandler.getUserSurname())));
                    } catch (IOException e) {
                        System.out.println("Ошибка в работе с файлом");
                    }
                } catch (DataSizeException | NumberSizeException | SexDataException | DateFormException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                } catch (NumberFormatException e) {
                    System.out.println("Не верный формат ввода для номера телефона. Введите по образцу - 89991234567.");
                    e.printStackTrace();
                }
            }
        }
    }

}