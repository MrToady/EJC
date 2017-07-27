package task_08;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {
    @Test
    void selectionSort() {
        int[] firstArrayToSort = {1, 534, 234, 2, 234, 54, 456, 47, 46, 735, 634, 5342, 23, 42, 34, 23};
        int[] sortedFirstArray = {1, 2, 23, 23, 34, 42, 46, 47, 54, 234, 234, 456, 534, 634, 735, 5342};
        int[] secondArrayToSort = {53, 8, 678, 68, 809, 890, 76, 3422, 31, 2523, 45634, 6745, 68009, 98, 675, 54234, 1};
        int[] sortedSecondArray = {1, 8, 31, 53, 68, 76, 98, 675, 678, 809, 890, 2523, 3422, 6745, 45634, 54234, 68009};
        SelectionSort ss = new SelectionSort();
        ss.selectionSort(firstArrayToSort);
        ss.selectionSort(secondArrayToSort);
        assertArrayEquals(sortedFirstArray, firstArrayToSort);
        assertArrayEquals(sortedSecondArray, secondArrayToSort);
    }
}