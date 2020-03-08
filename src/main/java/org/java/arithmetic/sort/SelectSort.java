package org.java.arithmetic.sort;

/**
 * 选择排序
 * 思路：同冒泡排序，因一次循环遍历，只能将一个最大的值找到并放到最后，所以循环toSort.length-1次数即可排序完成
 * 每一次循环中，先假设第一个值为最大值，遍历数组，如比假设值大则更换， 最后将最大值与相应位置的值变更
 *
 * todo：同样的时间复杂度，为什么选择排序比冒泡排序快那么多？？
 */
public class SelectSort {

    public void solutionA(int[] toSort) {

        int i = 0;//表示外层循环的起始位置
        while (i < toSort.length - 1) {
            int maxValue = toSort[i];
            int maxIndex = i;
            for (int j = i + 1; j < toSort.length; j++) {
                if (toSort[j] > maxValue) {
                    maxValue = toSort[j];
                    maxIndex = j;
                }
            }
            toSort[maxIndex] = toSort[i];
            toSort[i] = maxValue;
            i++;
        }
    }
}
