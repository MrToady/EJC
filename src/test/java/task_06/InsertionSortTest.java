package task_06;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InsertionSortTest {
    @Test
    void testInsertIntoSort() {
        ArrayList<Integer> originalArray = new ArrayList<>();
        originalArray.add(10);
        originalArray.add(40);
        originalArray.add(20);
        originalArray.add(17);
        originalArray.add(0);
        originalArray.add(-7);
        InsertionSort.insertIntoSort(originalArray);

        ArrayList<Integer> sortedOriginalArray = new ArrayList<>();
        sortedOriginalArray.add(-7);
        sortedOriginalArray.add(0);
        sortedOriginalArray.add(10);
        sortedOriginalArray.add(17);
        sortedOriginalArray.add(20);
        sortedOriginalArray.add(40);

        assertEquals(sortedOriginalArray, originalArray);
    }
}