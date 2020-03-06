package org.java.arithmetic.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {


    /**
     * 解法1
     * 思路：循环遍历，遇到逆序则换位置
     *
     * @param toSort
     * @return
     */
    public void solutionA(int[] toSort) {

        int count = 0;
        while (count <= toSort.length - 1) {
            for (int i = 0; i < toSort.length - 1; i++) {
                if (toSort[i] > toSort[i + 1]) {
                    int temp = toSort[i];
                    toSort[i] = toSort[i + 1];
                    toSort[i + 1] = temp;
                }
            }
            count++;
        }

    }

}
