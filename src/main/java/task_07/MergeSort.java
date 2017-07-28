package task_07;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
    private int[] array;
    private int[] tempArray;

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
        int[] resultArray = new int[100];
        for (int i = 0; i < 100; i++) {
            resultArray[i] = random.nextInt(1001);
        }
        return resultArray;
    }

    /**
     * Applies @{code doMergeSort} to whole array
     *
     * @param inputArray - unsorted int array
     */
    public void sort(int inputArray[]) {
        this.array = inputArray;
        int length = inputArray.length;
        this.tempArray = new int[length];
        doMergeSort(0, length - 1);
    }

    /**
     * Sorts an array in a specified range
     *
     * @param lowerIndex  - lower index
     * @param higherIndex - higher index
     */

    private void doMergeSort(int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = (lowerIndex + higherIndex) / 2;
            doMergeSort(lowerIndex, middle);
            doMergeSort(middle + 1, higherIndex);
            mergeParts(lowerIndex, middle, higherIndex);
        }
    }

    private void mergeParts(int bottomIndex, int middleIndex, int topIndex) {
        for (int i = bottomIndex; i <= topIndex ; i++) {
            tempArray[i] = array[i];
        }
        int i = bottomIndex;
        int j = middleIndex + 1;
        int k = bottomIndex;
        while (i <= middleIndex && j <= topIndex) {
            if (tempArray[i] <= tempArray[j]) {
                array[k] = tempArray[i];
                i++;
            } else {
                array[k] = tempArray[j];
                j++;
            }
            k++;
        }
        while (i <= middleIndex) {
            array[k] = tempArray[i];
            k++;
            i++;
        }
    }
}
