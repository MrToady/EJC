package task_08;

public class RadixSort {
    /**
     * Radix sort implementation
     *
     * @param arrayToSort array what need to be sorted
     */
    public void radixSort(int[] arrayToSort) {
        int digitPlace = 1;
        int maxNumberOfArray = getMax(arrayToSort);
        int[] temporaryArray = new int[arrayToSort.length];
        while (maxNumberOfArray / digitPlace > 0) {
            int[] count = new int[10];
            for (int i = 0; i < 10; i++) {
                count[i] = 0;
            }
            for (int anArray : arrayToSort) {
                count[(anArray / digitPlace) % 10]++;
            }
            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }
            for (int i = arrayToSort.length - 1; i >= 0; i--) {
                temporaryArray[--count[(arrayToSort[i] / digitPlace) % 10]] = arrayToSort[i];
            }
            System.arraycopy(temporaryArray, 0, arrayToSort, 0, arrayToSort.length);
            digitPlace *= 10;
        }
    }

    /**
     * @param array of integers
     * @return maximum element of this array
     */
    private int getMax(int[] array) {
        int max = array[0];
        for (int element : array) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }
}
