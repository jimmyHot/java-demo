package org.java.datastructure.Recursion;

import org.java.datastructure.linkedList.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * 递归应用case
 */
public class RecursionApplication {

    private int count;

    public int getCount() {
        return count;
    }

    /**
     * 通过递归实现链表的反转
     *
     * @param node
     * @return
     */
    public Node reverse(Node node) {
        count++;
        if (node.getNext() == null) {
            return node;
        }
        Node temp = reverse(node.getNext());
        node.getNext().setNext(node);
        node.setNext(null);
        return temp;
    }

    /**
     * 迷宫问题
     * 思路：按照“下，右，上，下”查找路线
     * 二维数组中：0表示未走过，1表示墙，2表示走过，3表示走不通
     */
    public boolean findWay(int[][] map, int i, int j) {
        count++;
        if (map[2][2] == 2) {
            return true;
        }
        //i,j 参数的长度不用校验吗？
        if (i >= map.length || j >= map[0].length) {
            return false;
        }
        if (map[i][j] == 0) {
            map[i][j] = 2;
            if (findWay(map, i + 1, j)) {//说明向“下”能走通
                return true;
            } else if (findWay(map, i, j + 1)) {//说明向“右”能走通
                return true;
            } else if (findWay(map, i - 1, j)) {//说明向“上”能走通
                return true;
            } else if (findWay(map, i, j - 1)) {//说明向“左”能走通
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }
        } else {
            return false;
        }
    }


    /**
     * 八皇后问题
     * 思路：
     * 将第一个皇后从第一行的第一列位置开始，循环
     * 例如：放第3个皇后位置时，第一个和第二个皇后位置固定的情况下，将第3个皇后可以放置的所有位置统计出
     * 每一次回溯都是一种解法
     * <p>
     * todo:这个思路写的太不好了，抽离不出来
     */
    private int max = 8;
    private int[] array = new int[8];

    public void queen8(int n) {
        if (n == max) {
            printQueenPosition(array);
            return;
        }
        for (int i = 0; i < max; i++) { //循环列放置
            array[n] = i;//第n个皇后从第n行的第一列开始循环
            if (!isConflict(n)) {
                //当前第n个皇后与之前的n-1个皇后位置不冲突
                queen8(n + 1);
            }
            //冲突，则继续执行for循环，寻找最佳列为止
        }
    }


    /**
     * 汉若塔问题
     * 思路：
     * 递归分治
     *
     * @param from
     * @param to
     * @param temp
     * @param n
     */
    public void hanota(List<Integer> from, List<Integer> to, List<Integer> temp, int n) {
        if (n == 1) {
            to.add(from.remove(from.size() - 1));
        } else {
            //将A上的n-1个挪到B上
            hanota(from, temp, to, n - 1);
            //将A上的最后一个挪到C上
            hanota(from, to, temp, 1);
            //将B上的n-1个挪到C上
            hanota(temp, to, from, n - 1);
        }
    }

    /**
     * 判断第n个皇后与之前的n-1个皇后位置是否冲突
     *
     * @param n
     * @return
     */
    private boolean isConflict(int n) {
        count++;
        for (int i = 0; i < n; i++) {
            //同一行，同一列，同一斜线上视为 冲突
            if (array[i] == array[n] || Math.abs(n - i) == Math.abs(array[n] - array[i])) {
                return true;
            }
        }
        return false;
    }

    private void printQueenPosition(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }


}
