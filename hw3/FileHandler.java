package hw3;

import java.io.*;
import java.nio.file.Path;
import java.util.Iterator;

public class FileHandler {

    public static void writeUserData(DataHandler dh, Path pathWrite) throws IOException {
        try (FileWriter writer = new FileWriter(String.valueOf(pathWrite), true)) {
            if (checkUserExisting(pathWrite, dh)) {
                writer.write(dh.getUserData() + "\n");
            } else {
                System.out.println("Такой пользователь уже существует");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при работе с файлом");
        }
    }

    private static boolean checkUserExisting (Path pathRead, DataHandler dh) throws FileNotFoundException {
        File file = new File(String.valueOf(pathRead));
        boolean isExist = true;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            Iterator<String> iterator = bufferedReader.lines().iterator();
            while (iterator.hasNext()) {
                String string = iterator.next();
                if (string.equals(dh.getUserData())) {
                    isExist = false;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
        return isExist;
    }
}
