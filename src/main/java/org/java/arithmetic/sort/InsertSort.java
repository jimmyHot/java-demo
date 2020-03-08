package org.java.arithmetic.sort;

/**
 * 插入排序（由小到大）
 * 将一个待排序的数组，视为两个数组A和B，A中只包含第一个元素，然后遍历B，依次将每一个元素有序的插入到A数组中，即可
 * 例如：3,9,-1,20,10——》-1,3,9,10,20
 * 第一次遍历结果——》3,9,-1,20,10
 * 第二次遍历结果——》-1,3,9,20,10
 * 第三次遍历结果——》-1,3,9,10,20
 * 第四次遍历结果——》-1,3,9,10,20
 */
public class InsertSort {


    public void solutionA(int[] toSort) {
        //外层遍历四次，默认将i=0位置视为有序数组，从i=1开始，依次插入到有序数组中
        int insertValue;
        int insertIndex;
        for (int i = 1; i < toSort.length; i++) {
            insertValue = toSort[i];
            insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < toSort[insertIndex]) {
                //说明还没找到插入位置
                //需要将insertIndex的值后移
                toSort[insertIndex + 1] = toSort[insertIndex];
                insertIndex--;//待插入点继续前移
            }
            //退出循环后，即找到插入点
            toSort[insertIndex + 1] = insertValue;

        }


    }
}
