package hw3;

public class Main {
    public static void main(String[] args) {
        DataHandler dataHandler = new DataHandler();
        dataHandler.addNewUser();
        System.out.println(dataHandler.printUserData());
    }

}
