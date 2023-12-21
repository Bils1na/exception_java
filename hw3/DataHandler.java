package hw3;

import hw3.exception.DataSizeException;

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
            } else if (string.contains(".")) {
                this.date = string;
                input.remove(string);
            } else if (string.length() == 1) {
                this.sex = string;
                input.remove(string);
            } else if (string.length() == 11) {
//                try {
                    this.phone = Long.parseLong(string);
                    input.remove(string);
//                } catch (NumberFormatException e) {
//                    throw new NumberFormatException();
//                }
            } else {
                this.fullName[1] = string;
                input.remove(string);
            }
        }
    }

    public String printUserData() {
        return Arrays.asList(this.fullName) +" "+ this.sex +" "+ this.date +" "+ this.phone;
    }
}
