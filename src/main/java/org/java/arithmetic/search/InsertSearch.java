package org.java.arithmetic.search;

/**
 * 插入查找（对二分查找的一种优化方案）
 * 适用于：海量的有序数组，关键字分布比较均匀的情况下
 * 思路：（该case中从小到大）
 * 1·确认 自适应midIndex=left+(findValue-arr[left])/(arr[right]-arr[left])*(right-left)
 * 2·比较findValue与midIndex对应值大小，大则右移，小则左移
 * 3·推出条件：findValue=arr[midIndex] || left>right
 */
public class InsertSearch {

    private int modCount;

    public int getModCount(){
        return modCount;
    }

    public int insertSearch(int[] arr, int left, int right, int findValue) {
        modCount++;
        //参数校验
        if (arr.length == 0 || left > right || findValue < arr[0] || findValue > arr[arr.length - 1]) {
            return -1;
        }
        int midIndex = left+(findValue-arr[left])/(arr[right]-arr[left])*(right-left);
        if (findValue > arr[midIndex]) {
            //向右移
            return insertSearch(arr, midIndex + 1, right, findValue);
        } else if (findValue < arr[midIndex]) {
            //向左移
            return insertSearch(arr, left, midIndex - 1, findValue);
        } else {
            //相等返回
            return midIndex;
        }
    }
}
