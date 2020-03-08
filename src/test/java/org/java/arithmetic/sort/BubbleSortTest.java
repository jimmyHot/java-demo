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



    @Test
    void TestTime() {
        long startTime = System.currentTimeMillis();
        int[] toSort = new int[80000];
        for (int i = 0; i < toSort.length; i++) {
            toSort[i] = (int) (Math.random() * 80000);
        }
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.solutionA(toSort);
        long endTime = System.currentTimeMillis();
        System.out.println("花费时间为" + (endTime - startTime));
    }
}