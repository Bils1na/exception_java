package sem1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

//    public static void main(String[] args) {
//        System.out.println("Hello and welcome!");
//
//
//        for (int i = 0; i <= 5; i++) {
//            System.out.println("i = " + i);
//        }
//    }

    public static void main(String[] args) {
//        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int[] arr = new int[100];
//        int[] arr = null;
//        System.out.println(searchError(arr));

//        System.out.println(getIndex(arr, 1));
//        System.out.println(getIndex(arr, 9));
//        System.out.println(getIndex(arr, 11));
//        client();

//        int[][] array = {{1, 2, 3, 4},
//                        {5, 6, 7, 8},
//                        {9, 0, 1, 2},
//                        {3, 4, 5, 6}};
//        int[][] array1 = {
//                {1, 0},
//                null,
//        };
//        int[][] array2 = null;
//        System.out.println(task4(array2));

//        Integer[] array = new Integer[]{1, 2, 3, 4, null, 6, 7, null, 9};
//        checkArray(array);

        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{4, 5, 6, 7};

        System.out.println(Arrays.toString(task6(a, b)));
    }

    public  static int searchError(int[] arr) {
        if (arr == null || arr.length < 10) {
            return -1;
        }
        return arr.length;
    }

    public static int getIndex(int[] array, int value) {
        if (array == null) return -3;

        if (array.length < 2) return -1;
        if (array.length > 99) return -4;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) return i;
        }
        return -2;
    }

    public static void client() {
        int[] ints = new int[10];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number: ");
        int next = scanner.nextInt();

        switch (getIndex(ints, next)) {
            case -1:
            System.out.println("The length of array is too small");
                break;
            case -2:
                System.out.println("Element doesn't found");
                break;
            case -3:
                System.out.println("The array is null");
                break;
            case -4:
                System.out.println("The length of array is too big");
                break;
            default:
                System.out.println("Element doesn't exist");
        }

    }

    public static int task4(int[][] array) {
        if (array == null) throw new RuntimeException("The array is null");
        for (int[] row : array) {
            if (row == null) throw new RuntimeException("The array has null row");
        }

        int count = 0;
        if (array.length != array[0].length) throw new RuntimeException("Array sides are not equal!");
        for (int[] row : array) {
            for (int j : row) {
                if (j > 1 || j < 0) throw new RuntimeException("Mistake!");
                count += j;
            }
        }
        return 0;
    }

    public static void checkArray(Integer[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                System.out.println(i + " is null");
            }
        }
    }

    public static int[] task6(int[] a, int[] b) {
        if (a.length != b.length) {
            throw new RuntimeException("The length of array is not equal! "
                    + a.length + " length of array a. "
                    + b.length + " length of array b.");
        }
        int[] newArray = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            newArray[i] = a[i] + b[i];
        }
        return newArray;
    }

}
