package hw3;

import hw3.exception.DataSizeException;
import hw3.exception.DateFormException;
import hw3.exception.NumberSizeException;
import hw3.exception.SexDataException;

import java.util.*;

public class DataHandler {
    String[] fullName;
    String date, sex;
    Long phone;


    public DataHandler() {
        this.fullName = new String[3];
        this.date = "";
        this.sex = "";
        this.phone = null;
    }

    public void addNewUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите через пробел ФИО(латиницей), дату рождения(dd.mm.yyyy), " +
                            "пол(m/f) и ваш номер телефона(89991234567) >> ");
        ArrayList<String> inputData = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));
        setData(inputData);
    }

    private void setData(ArrayList<String> input) {
        if (input.size() != 6) {
            throw new DataSizeException(input.size());
        }
        while (input.iterator().hasNext()) {
            String string = input.iterator().next();

            if (string.contains("vich") || string.contains("vna")) {
                this.fullName[2] = string;
                input.remove(string);
            } else if (string.contains("ov") || string.contains("chuk")
                    || string.contains("ko") || string.contains("ova")) {
                this.fullName[0] = string;
                input.remove(string);
            } else if (string.contains(".") || string.length() == 10) {
                if (!string.contains(".") || string.contains("/")
                        || string.length() < 10) throw new DateFormException();
                this.date = string;
                input.remove(string);
            } else if (string.length() == 1) {
                if (!(string.contains("m") || string.contains("f"))) throw new SexDataException();
                this.sex = string;
                input.remove(string);
            } else if (string.length() == 11 || string.matches("\\d+")) {
                if (string.length() < 11) throw new NumberSizeException(string.length());
                this.phone = Long.parseLong(string);
                input.remove(string);
            } else {
                this.fullName[1] = string;
                input.remove(string);
            }
        }
    }

    public String getUserData() {
        return this.fullName[0] +" "+ this.fullName[1] +" "+ this.fullName[2] +" "+ this.date +" "+ this.phone +" "+ this.sex;
    }

    public String getUserSurname() {
        return this.fullName[0];
    }
}
