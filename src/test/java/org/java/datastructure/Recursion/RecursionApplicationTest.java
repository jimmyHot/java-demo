package org.java.datastructure.Recursion;

import org.java.datastructure.linkedList.Node;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


class RecursionApplicationTest {


    @Test
    void reverse() {
        RecursionApplication recursionApplication = new RecursionApplication();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node3.setNext(node4);
        node2.setNext(node3);
        node1.setNext(node2);
        Node reverse = recursionApplication.reverse(node1);
        System.out.println(reverse.toString());
        System.out.printf("共计执行方法%d次",recursionApplication.getCount());
    }

    @Test
    void findWay() {
        RecursionApplication recursionApplication = new RecursionApplication();
        int[][] map = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                map[i][j] = 0;
            }
        }
        printMap(map);
        System.out.println("找到路之后~~~~~~~~~~");
        recursionApplication.findWay(map,0,0);
        printMap(map);
        System.out.printf("共计执行方法%d次",recursionApplication.getCount());
    }

    void printMap(int[][] map) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(map[i][j] +" ");
            }
            System.out.println();
        }
    }

    @Test
    void queen(){
        RecursionApplication recursionApplication = new RecursionApplication();
        recursionApplication.queen8(0);
        System.out.printf("共计执行方法%d次",recursionApplication.getCount());
    }

    @Test
    void hanota(){
        RecursionApplication recursionApplication = new RecursionApplication();
        ArrayList<Integer> A=new ArrayList<>();
        A.add(2);
        A.add(1);
        A.add(0);
        ArrayList<Integer> B=new ArrayList<>();
        ArrayList<Integer> C=new ArrayList<>();
        recursionApplication.hanota(A,C,B,A.size());
        System.out.println(C.toString());
    }
}