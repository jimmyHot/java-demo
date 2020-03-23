package org.java.datastructure.linkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class JosepfuTest {

    private Josepfu josepfu;
    private Node node1;
    private Node node2;
    private Node node3;
    private Node node4;
    private Node node5;


    @BeforeEach
    void setUp() {
        josepfu = new Josepfu();
        node1 = new Node(1);
        node2 = new Node(2);
        node3 = new Node(3);
        node4 = new Node(4);
        node5 = new Node(5);
    }

    @Test
    void addNode() {
        josepfu.addNode(node1);
        assertEquals(1,josepfu.getCount());
        josepfu.addNode(node2);
        assertEquals(2,josepfu.getCount());
        josepfu.addNode(node3);
        assertEquals(3,josepfu.getCount());
        josepfu.addNode(node4);
        assertEquals(4,josepfu.getCount());
        josepfu.addNode(node5);
        assertEquals(5,josepfu.getCount());
    }

    @Test
    void init(){
        assertTrue(josepfu.init(1));
        assertEquals(1,josepfu.getCount());
        assertTrue(josepfu.init(2));
        assertEquals(2,josepfu.getCount());
        assertTrue(josepfu.init(5));
        assertEquals(5,josepfu.getCount());
    }

    @Test
    void getResult(){
        //case1:n=5;k=1;m=2;
        assertEquals("24153",josepfu.getResult(5, 1, 2));
        //case2:n=5;k=2;m=2;
        assertEquals("35214",josepfu.getResult(5, 2, 2));
        //case3:n=5;k=2;m=5;
        assertEquals("12453",josepfu.getResult(5, 2, 5));
        //case4:n=5;k=4;m=4;
        assertEquals("21354",josepfu.getResult(5, 4, 4));
    }


    @Test
    void getFirst(){
        System.out.println(josepfu.getFirst());
    }
}