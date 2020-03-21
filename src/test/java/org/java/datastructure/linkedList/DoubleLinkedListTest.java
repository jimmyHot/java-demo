package org.java.datastructure.linkedList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {

    DoubleLinkedList doubleLinkedList;
    HeroNode2 node1;
    HeroNode2 node2;
    HeroNode2 node3;
    HeroNode2 node4;


    @BeforeEach
    void setUp() {
        doubleLinkedList = new DoubleLinkedList();
        node1 = new HeroNode2(1, "jimmy");
        node2 = new HeroNode2(2, "jimmy1");
        node3 = new HeroNode2(3, "jimmy2");
        node4 = new HeroNode2(4, "jimmy3");

    }

    @AfterEach
    void tearDown() {

    }

    @Test
    void add() {
        assertTrue(doubleLinkedList.add(node1));
        assertEquals(doubleLinkedList.getCount(), doubleLinkedList.getNumber());
        assertTrue(doubleLinkedList.add(node2));
        assertEquals(doubleLinkedList.getCount(), doubleLinkedList.getNumber());
    }

    @Test
    void delete() {
    }
}