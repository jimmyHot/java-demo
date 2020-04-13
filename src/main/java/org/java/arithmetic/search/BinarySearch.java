package org.java.arithmetic.search;

/**
 * 二分查找
 * 适用于：有序 数组
 * 思路：（该case中从小到大）
 * 1·确认midIndex=(left+right)/2=low+1/2*(high-low)
 * 2·比较findValue与midIndex对应值大小，大则右移，小则左移
 * 3·推出条件：findValue=arr[midIndex] || left>right
 */
public class BinarySearch {

    private int modCount;

    public int getModCount() {
        return modCount;
    }

    public int binarySearch(int[] arr, int left, int right, int findValue) {
        modCount++;
        //参数校验
        if (arr.length == 0 || left > right || findValue < arr[0] || findValue > arr[arr.length - 1]) {
            return -1;
        }
        int midIndex = (left + right) / 2;
        if (findValue > arr[midIndex]) {
            //向右移
            return binarySearch(arr, midIndex + 1, right, findValue);
        } else if (findValue < arr[midIndex]) {
            //向左移
            return binarySearch(arr, left, midIndex - 1, findValue);
        } else {
            //相等返回
            return midIndex;
        }
    }
}
