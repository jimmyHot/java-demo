package org.java.datastructure.linkedList;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Unit test for simple App.
 */
public class SingleLinkedListTest {

    SingleLinkedList singleLinkedList;
    HeroNode node1;
    HeroNode node2;
    HeroNode node3;
    HeroNode node4;

    @BeforeEach
    public void setUp() {
        singleLinkedList = new SingleLinkedList();
        node1 = new HeroNode(1, "贾丽敏");
        node2 = new HeroNode(2, "贾hanhan");
        node3 = new HeroNode(3, "贾涛涛");
        node4 = new HeroNode(4, "贾傻傻");
    }


    @Test
    public void addHeroNode() {
        //test
        singleLinkedList.addHeroNode(node1);
        assertEquals(1,singleLinkedList.getCount());
        singleLinkedList.addHeroNode(node2);
        assertEquals(2,singleLinkedList.getCount());
        //TODO 再次添加重复元素node1时，为何node1原结构发生改变？
        singleLinkedList.addHeroNode(node1);
        assertEquals(3,singleLinkedList.getCount());
        singleLinkedList.list();
    }


}
