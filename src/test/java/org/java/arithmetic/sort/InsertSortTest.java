package org.java.arithmetic.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InsertSortTest {

    @Test
    void solutionA() {
        InsertSort insertSort=new InsertSort();
        int[] toSort = new int[]{3, 9, -1, 20, 10};
        insertSort.solutionA(toSort);
        int[] actual = new int[]{-1, 3, 9, 10, 20};
        assertEquals(Arrays.toString(actual), Arrays.toString(toSort));
    }
}