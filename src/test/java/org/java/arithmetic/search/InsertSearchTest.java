package org.java.arithmetic.search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsertSearchTest {

    @Test
    void insertSearch() {
        InsertSearch insertSearch = new InsertSearch();
        int[] arr = new int[]{1, 3, 9, 10, 23, 100, 123, 345, 500, 1000};
        int resultIndex;
        resultIndex = insertSearch.insertSearch(arr, 0, arr.length - 1, 23);
        assertEquals(4, resultIndex);
        System.out.println(insertSearch.getModCount());
    }

    @Test
    void insertSearch2() {
        //left+(findValue-arr[left])/(arr[right]-arr[left])*(right-left)
        InsertSearch insertSearch = new InsertSearch();
        int[] arr = new int[]{1,2,3,4,5,6,7,9,11,23,32,33,34,56,67,78,79,89,90,91,92,93,94,95,96,97,99,100,103,105,110,120,130};
        int resultIndex;
        resultIndex = insertSearch.insertSearch(arr, 0, arr.length - 1, 1);
        assertEquals(0, resultIndex);
        System.out.println(insertSearch.getModCount());
    }

    @Test
    void insertSearch3() {
        //left+(findValue-arr[left])/(arr[right]-arr[left])*(right-left)
        InsertSearch insertSearch = new InsertSearch();
        int[] arr = new int[100];
        for (int i=0;i<arr.length;i++){
            arr[i]=i+1;
        }
        int resultIndex;
        resultIndex = insertSearch.insertSearch(arr, 0, arr.length - 1, 58);
        assertEquals(57, resultIndex);
        System.out.println(insertSearch.getModCount());
    }
}