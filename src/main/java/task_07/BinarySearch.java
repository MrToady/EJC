package task_07;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] array = binarySearch.createArrayForSearch(643);
        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(binarySearch.search(array, 643));
    }

    public int[] createArrayForSearch(int required) {
        Random random = new Random();
        int[] result = new int[100];
        for (int i = 0; i < 100; i++) {
            result[i] = random.nextInt(1001);
        }
        result[random.nextInt(100)] = required;
        return result;
    }

    public int search(int[] array, int x) {
        int i = -1;
        int low = 0;
        int high = array.length;
        int mid;
        while (low < high) {
            mid = (low + high) / 2;
            if (x == array[mid]) {
                i = mid;
                break;
            } else {
                if (x < array[mid]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return i;
    }
}
