package task_07;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    private int[] array;
    private int[] tempMergArr;
    private int length;

    public static void main(String[] args) {

        MergeSort mergeSort = new MergeSort();
        int[] array = mergeSort.createArray();
        System.out.println(Arrays.toString(array));
        mergeSort.sort(array);
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
     * Merge sort implementation
     *
     * @param arrayToSort array what need to be sorted
     */
    public void sort(int[] arrayToSort) {
        this.array = arrayToSort;
        this.length = arrayToSort.length;
        this.tempMergArr = new int[length];
        doMergeSort(0, length - 1);
    }

    private void doMergeSort(int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = (lowerIndex + higherIndex) / 2;
            doMergeSort(lowerIndex, middle);
            doMergeSort(middle + 1, higherIndex);
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private void mergeParts(int lowerIndex, int middle, int higherIndex) {
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergArr[i] = array[i];
        }
        int i = lowerIndex;
        int j = middle + 1;
        int k = lowerIndex;
        while (i <= middle && j <= higherIndex) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            } else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }
    }
}
