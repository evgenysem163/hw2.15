package pro.sky.hw25.sky24;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Random;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        int[]initialArray= generateArray(1_000);
        long timeForBubbleSorting = calculateTime(10,
                ()->sortBubble(Arrays.copyOf((initialArray),
                        initialArray.length)));
        long timeForSelectionSorting = calculateTime(10,
                ()->sortBubble(Arrays.copyOf((initialArray),
                        initialArray.length)));
        long timeForInsertSorting = calculateTime(10,
                ()->sortBubble(Arrays.copyOf((initialArray),
                        initialArray.length)));
        System.out.println("timeBubbleSorting = "+ timeForBubbleSorting);
        System.out.println(" timeForSelectionSorting = " +  timeForSelectionSorting);
        System.out.println("timeForInsertSorting = " + timeForInsertSorting);

    }
    private static long calculateTime(int iteration, Runnable runnable)
    {
        long sum =0;
        for (int i = 0; i < iteration; i++) {
            long start  =System.currentTimeMillis();
            runnable.run();
            sum+=System.currentTimeMillis()-start;
        }
        return sum/iteration;
    }
    private static int[] generateArray(int n) {
        Random random =new Random();
        int[]array =new  int[n];
        for (int i = 0; i < n; i++) {
            array[i]= random.nextInt();

        }
        return array;
    }
    private static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minElementIndex = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }

    }

    private static void swapElements(int[] arr, int i, int minElementIndex) {
    }

    private static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = 1;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;

            }
            arr[j] = temp;
        }


    }

    private static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }

            }

        }
    }
}



