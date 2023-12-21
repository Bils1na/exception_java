package sem2;

import java.io.*;

public class SomeClass {
    public static void main(String[] args) {
        InputStream inputStream;
        try {
            String[] strings =
                    {"asdf", "asdf"};
            String string s1 = strings[2];
            test();
            int a = 1 / 0;
            inputStream = new FileInputStream("sdfgdsf");
        } catch(Throwable e) {
            e.printStackTrace();
        } catch (StackOverflowError error) {
            System.out.println("asdfasdfdsa");
        } finally {
            System.out.println("Я все равно выполнился!");
        }
            System.out.println("Я жив!");
    }


    public static void test() throws IOException {
        File file = new File("1");
        file.createNewFile();
        FileReader reader = new FileReader(file);
        reader.read();
        test();
    }
}