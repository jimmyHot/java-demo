package org.java.arithmetic.sort;

/**
 * 冒泡排序
 */
public class BubbleSort {


    /**
     * 解法1
     * 思路：循环遍历，遇到逆序则换位置
     * 时间复杂度：
     *
     * @param toSort
     * @return
     */
    public void solutionA(int[] toSort) {

        //因一次循环遍历，只能将一个最大的值找到并放到最后，所以循环toSort.length-1次数即可排序完成
        int count = 0;//循环遍历次数
        boolean changeFlag=false;//表示这轮循环是否发生逆序,如果未发生逆序，则可直接结束循环
        while (count <= toSort.length - 1) {
            for (int i = 0; i < toSort.length - 1; i++) {
                if (toSort[i] > toSort[i + 1]) {
                    int temp = toSort[i];
                    toSort[i] = toSort[i + 1];
                    toSort[i + 1] = temp;
                    changeFlag=true;
                }
            }
            if(!changeFlag){
                //这一趟排序中未发生变更，则可跳出循环
                break;
            }else {
                changeFlag=false;
            }
            count++;
        }
    }

}
