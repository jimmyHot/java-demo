package org.java.arithmetic.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {


    @Test
    void solutionA() {
        BubbleSort bubbleSort = new BubbleSort();
        int[] toSort = new int[]{3, 9, -1, 10, 20};
        bubbleSort.solutionA(toSort);
        int[] actual = new int[]{-1, 3, 9, 10, 20};
        assertEquals(Arrays.toString(actual), Arrays.toString(toSort));
    }
}