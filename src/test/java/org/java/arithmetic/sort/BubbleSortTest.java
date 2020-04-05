package org.java.arithmetic.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void testMap() {
        HashMap<String, String> map = new HashMap<>();
        // 键不能重复，值可以重复
        map.put("san", "张三");
        map.put("si", "李四");
        map.put("wu", "王五");
        map.put("wang", "老王");
        map.put("wang", "老王2");// 老王被覆盖
        map.put("lao", "老王");
        System.out.println(map);
    }

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