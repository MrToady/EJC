package task_07;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

    public static void main(String[] args) {

        BubbleSort bubbleSort = new BubbleSort();
        int[] array = bubbleSort.createArray();
        System.out.println(Arrays.toString(array));
        bubbleSort.sort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * Creates an array of 100 random numbers from 0 to 1000
     *
     * @return new array
     */
    public int[] createArray() {
        Random random = new Random();
        int[] result = new int[100];
        for (int i = 0; i < 100; i++) {
            result[i] = random.nextInt(1001);
        }
        return result;
    }


    /**
     * Simple Bubble sort
     */
    public void sort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1; j > i; j--) {

                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }
}
