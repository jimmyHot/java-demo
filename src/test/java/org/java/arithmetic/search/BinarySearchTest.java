package org.java.arithmetic.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void binarySearch() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = new int[]{1, 3, 9, 10, 23, 100, 123, 345, 500, 1000};
        int resultIndex;
        resultIndex = binarySearch.binarySearch(arr, 0, arr.length - 1, 23);
        assertEquals(4, resultIndex);
        System.out.println(binarySearch.getModCount());
        resultIndex = binarySearch.binarySearch(arr, 0, arr.length - 1, 230);
        assertEquals(-1, resultIndex);
        System.out.println(binarySearch.getModCount());

    }

    @Test
    void binarySearch2() {
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = new int[]{1,2,3,4,5,6,7,9,11,23,32,33,34,56,67,78,79,89,90,91,92,93,94,95,96,97,99,100,103,105,110,120,130};
        int resultIndex;
        resultIndex = binarySearch.binarySearch(arr, 0, arr.length - 1, 23);
        assertEquals(9, resultIndex);
        System.out.println(binarySearch.getModCount());

    }
}