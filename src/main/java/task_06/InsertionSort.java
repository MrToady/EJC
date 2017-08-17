package task_06;

import java.util.ArrayList;
import java.util.Random;

public class InsertionSort {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = createArrayList();
        arrayList.forEach(o -> System.out.print(o + " "));
        System.out.println();
        insertIntoSort(arrayList);
        arrayList.forEach(o -> System.out.print(o + " "));
    }

    private static ArrayList<Integer> createArrayList() {
        Random random = new Random();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            arrayList.add(random.nextInt(1001));
        }
        return arrayList;
    }

    /**
     * Insertion sort implementation
     *
     * @param arrayToSort array what need to be sorted
     */
    public static void insertIntoSort(ArrayList<Integer> arrayToSort) {
        int temp;
        int j;
        for (int i = 0; i < arrayToSort.size() - 1; i++) {
            if (arrayToSort.get(i) > arrayToSort.get(i + 1)) {
                temp = arrayToSort.get(i + 1);
                arrayToSort.set(i + 1, arrayToSort.get(i));
                j = i;
                while (j > 0 && temp < arrayToSort.get(j - 1)) {
                    arrayToSort.set(j, arrayToSort.get(j - 1));
                    j--;
                }
                arrayToSort.set(j, temp);
            }
        }
    }
}
