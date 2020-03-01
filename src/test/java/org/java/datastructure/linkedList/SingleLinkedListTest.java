package org.java.datastructure.linkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListTest {


    SingleLinkedList singleLinkedList;
    HeroNode node1;
    HeroNode node2;
    HeroNode node3;
    HeroNode node4;

    @BeforeEach
    void setUp() {
        singleLinkedList = new SingleLinkedList();
        node1 = new HeroNode(1, "贾丽敏");
        node2 = new HeroNode(2, "贾hanhan");
        node3 = new HeroNode(3, "贾涛涛");
        node4 = new HeroNode(4, "贾傻傻");
    }


    @Test
    void addHeroNode() {
        //test
        singleLinkedList.addHeroNode(node1);
        assertEquals(1, singleLinkedList.getCount());
        singleLinkedList.addHeroNode(node2);
        assertEquals(2, singleLinkedList.getCount());
        //TODO 再次添加重复元素node1时，为何node1原结构发生改变？
        //reason:node1即是链表，添加链表指定有问题，那问题来了，我怎么能够添加重复节点？只能新实例化对象
        //singleLinkedList.addHeroNode(node1);
        singleLinkedList.addHeroNode(new HeroNode(1, "贾丽敏"));
        assertEquals(3, singleLinkedList.getCount());
        singleLinkedList.list();
    }

    @Test
    void addHeroNodeInOrder() {
        singleLinkedList.addHeroNodeInOrder(node2);
        singleLinkedList.addHeroNodeInOrder(node4);
        singleLinkedList.addHeroNodeInOrder(node1);
        singleLinkedList.addHeroNodeInOrder(node3);
        assertEquals(4, singleLinkedList.getCount());
        singleLinkedList.list();
    }

    @Test
    void delHeroNode() {
        singleLinkedList.addHeroNodeInOrder(node2);
        singleLinkedList.addHeroNodeInOrder(node4);
        singleLinkedList.addHeroNodeInOrder(node1);
        singleLinkedList.addHeroNodeInOrder(node3);
        singleLinkedList.delHeroNode(new HeroNode(1, "贾丽敏"));
        assertEquals(3, singleLinkedList.getCount());
        singleLinkedList.list();
    }

    @Test
    void updateHeroNode() {
        singleLinkedList.addHeroNodeInOrder(node2);
        singleLinkedList.addHeroNodeInOrder(node4);
        singleLinkedList.addHeroNodeInOrder(node1);
        singleLinkedList.addHeroNodeInOrder(node3);
        singleLinkedList.updateHeroNode(new HeroNode(1, "贾丽敏11"));
        assertEquals(4, singleLinkedList.getCount());
        singleLinkedList.list();
    }

    @Test
    void list() {
        singleLinkedList.list();
        singleLinkedList.addHeroNodeInOrder(node2);
        singleLinkedList.list();
    }


    @Test
    void getLastIndexNode() {
        singleLinkedList.addHeroNodeInOrder(node2);
        singleLinkedList.addHeroNodeInOrder(node4);
        singleLinkedList.addHeroNodeInOrder(node1);
        singleLinkedList.addHeroNodeInOrder(node3);
        HeroNode lastIndexNode = singleLinkedList.getLastIndexNode(2);
        HeroNode actualNode = new HeroNode(3, "贾涛涛");
        assertEquals(actualNode.toString(), lastIndexNode.toString());
    }

    @Test
    void getLastIndexNode2() {
        singleLinkedList.addHeroNodeInOrder(node2);
        singleLinkedList.addHeroNodeInOrder(node4);
        singleLinkedList.addHeroNodeInOrder(node1);
        singleLinkedList.addHeroNodeInOrder(node3);
        HeroNode lastIndexNode = singleLinkedList.getLastIndexNode2(2);
        HeroNode actualNode = new HeroNode(3, "贾涛涛");
        assertEquals(actualNode.toString(), lastIndexNode.toString());
    }

    @Test
    void reverseByStack() {
        singleLinkedList.addHeroNodeInOrder(node2);
        singleLinkedList.addHeroNodeInOrder(node4);
        singleLinkedList.addHeroNodeInOrder(node1);
        singleLinkedList.addHeroNodeInOrder(node3);
        HeroNode reverseNode = singleLinkedList.reverseByStack();
        System.out.println(reverseNode.toString());
        singleLinkedList.list();
    }

    @Test
    void reverseOld() {
        singleLinkedList.addHeroNodeInOrder(node2);
        singleLinkedList.addHeroNodeInOrder(node4);
        singleLinkedList.addHeroNodeInOrder(node1);
        singleLinkedList.addHeroNodeInOrder(node3);
        singleLinkedList.reverseOld();
        System.out.println("原结构链表-----------------------");
        singleLinkedList.list();
    }

    @Test
    void reverse() {
        singleLinkedList.addHeroNodeInOrder(node2);
        singleLinkedList.addHeroNodeInOrder(node4);
        singleLinkedList.addHeroNodeInOrder(node1);
        singleLinkedList.addHeroNodeInOrder(node3);
        singleLinkedList.reverse();
        singleLinkedList.list();
    }

    @Test
    void reversePrint() {
        singleLinkedList.addHeroNodeInOrder(node2);
        singleLinkedList.addHeroNodeInOrder(node4);
        singleLinkedList.addHeroNodeInOrder(node1);
        singleLinkedList.addHeroNodeInOrder(node3);
        singleLinkedList.reversePrint();
        System.out.println("原结构链表-----------------------");
        singleLinkedList.list();
    }
}