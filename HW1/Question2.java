import java.util.Arrays;
import java.util.Random;

public class Question2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Original array: " + Arrays.toString(arr));

        // Multiply every value in array with a random value between 0.1 and 0.9
        Random rand = new Random();
        double[] arrRandom = new double[arr.length];
        for (int i = 0; i < arr.length; i++) {
            double randomValue = 0.1 + (0.9 - 0.1) * rand.nextDouble();
            arrRandom[i] = arr[i] * randomValue;
        }
        System.out.println("Array with random values: " + Arrays.toString(arrRandom));

        // Calculate sum of array in serial
        long startSerial = System.currentTimeMillis();
        double sumSerial = 0;
        for (int i = 0; i < arrRandom.length; i++) {
            sumSerial += arrRandom[i];
        }
        long endSerial = System.currentTimeMillis();
        System.out.println("Sum of array in serial: " + sumSerial);
        System.out.println("Time taken in serial: " + (endSerial - startSerial) + " ms");

        // Calculate sum of array in parallel
        long startParallel = System.currentTimeMillis();
        double sumParallel = Arrays.stream(arrRandom).parallel().sum();
        long endParallel = System.currentTimeMillis();
        System.out.println("Sum of array in parallel: " + sumParallel);
        System.out.println("Time taken in parallel: " + (endParallel - startParallel) + " ms");
    }
}