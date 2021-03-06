package task_07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {
    MergeSort mergeSort = new MergeSort();

    @Test
    void testMergeSort() {
        int[] originalArray = {2, 3, 6, 3, 9, 9, 10, 0};
        mergeSort.sort(originalArray);
        int[] expectedArray = {0, 2, 3, 3, 6, 9, 9, 10};
        assertArrayEquals(expectedArray, originalArray);
    }
}