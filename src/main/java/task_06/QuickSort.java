package task_06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class QuickSort {
    public static void main(String[] args) {
        ArrayList<Integer> array = createNewCollection();
        array.forEach(o -> System.out.print(o + " "));
        System.out.println();
        quickSort(array);
        array.forEach(o -> System.out.print(o + " "));
    }

    private static ArrayList<Integer> createNewCollection() {
        ArrayList<Integer> resultCollection = new ArrayList<>(25);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String input;
            while (resultCollection.size() < 25) {
                input = reader.readLine();
                if (input.matches("[-+]?\\d+")) {
                    resultCollection.add(Integer.parseInt(input));
                } else {
                    System.out.println("Wrong input");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultCollection;
    }

    /**
     * Quick sort implementation
     *
     * @param arrayToSort array what need to be sorted
     */
    public static void quickSort(ArrayList<Integer> arrayToSort) {
        quickSortByIndices(arrayToSort, 0, arrayToSort.size() - 1);
    }

    private static void quickSortByIndices(ArrayList<Integer> arrayList, int bottomIndex, int topIndex) {
        if ((arrayList == null) || (arrayList.size() == 0)) {
            return;
        }
        if (bottomIndex >= topIndex) {
            return;
        }
        int pivot = arrayList.get((topIndex + bottomIndex) / 2);
        int i = bottomIndex;
        int j = topIndex;
        while (i <= j) {
            while (arrayList.get(i) < pivot) {
                i++;
            }
            while (pivot < arrayList.get(j)) {
                j--;
            }
            if (i <= j) {
                Collections.swap(arrayList, i, j);
                i++;
                j--;
            }
        }
        if (bottomIndex < j) {
            quickSortByIndices(arrayList, bottomIndex, j);
        }
        if (topIndex > i) {
            quickSortByIndices(arrayList, i, topIndex);
        }
    }
}