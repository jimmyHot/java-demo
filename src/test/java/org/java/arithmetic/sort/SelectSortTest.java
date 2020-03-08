package org.java.arithmetic.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SelectSortTest {


    @Test
    void solutionA() {
        SelectSort selectSort = new SelectSort();
        int[] toSort = new int[]{3, 9, -1, 10, 20};
        selectSort.solutionA(toSort);
        int[] expect = new int[]{20, 10, 9, 3, -1};
        assertEquals(Arrays.toString(expect), Arrays.toString(toSort));

    }

    @Test
    void TestTime() {
        long startTime = System.currentTimeMillis();
        int[] toSort = new int[80000];
        for (int i = 0; i < toSort.length; i++) {
            toSort[i] = (int) (Math.random() * 80000);
        }
        SelectSort selectSort = new SelectSort();
        selectSort.solutionA(toSort);
        long endTime = System.currentTimeMillis();
        System.out.println("花费时间为" + (endTime - startTime));
    }

}