package task_07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    private BinarySearch binarySearch = new BinarySearch();
    private int[] arrayForTest = {1, 2, 6, 8, 9, 123, 1567, 176756};

    @Test
    void testSearch() {
        assertEquals(3, binarySearch.search(arrayForTest, 8));
        assertEquals(5, binarySearch.search(arrayForTest, 123));
        assertEquals(-1, binarySearch.search(arrayForTest, 124));
    }
}
