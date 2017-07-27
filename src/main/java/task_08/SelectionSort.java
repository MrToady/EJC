package task_08;

public class SelectionSort {
    /**
     * Selection sort implementation
     *
     * @param arrayToSort array what need to be sorted
     */
    public void selectionSort(int[] arrayToSort) {
        for (int min = 0; min < arrayToSort.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < arrayToSort.length; j++) {
                if (arrayToSort[j] < arrayToSort[least]) {
                    least = j;
                }
            }
            int temp = arrayToSort[min];
            arrayToSort[min] = arrayToSort[least];
            arrayToSort[least] = temp;
        }
    }
}
