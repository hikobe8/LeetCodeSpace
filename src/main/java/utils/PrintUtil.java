package utils;

public class PrintUtil {

    public static void printArray(int[] array){
        printArray(array, array.length);
    }

    public static void printArray(int[] array, int size){
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + "\t");
        }
    }

}
