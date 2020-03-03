package org.java.datastructure.Recursion;

import org.java.datastructure.linkedList.Node;
import org.junit.jupiter.api.Test;



class RecursionApplicationTest {


    @Test
    void reverse() {
        RecursionApplication recursionApplication=new RecursionApplication();
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        node3.setNext(node4);
        node2.setNext(node3);
        node1.setNext(node2);
        Node reverse = recursionApplication.reverse(node1);
        System.out.println(reverse.toString());
    }
}