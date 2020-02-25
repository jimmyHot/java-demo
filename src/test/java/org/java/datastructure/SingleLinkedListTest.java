package org.java.datastructure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.java.datastructure.linkedList.HeroNode;
import org.java.datastructure.linkedList.SingleLinkedList;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * Unit test for simple App.
 */
public class SingleLinkedListTest {

    SingleLinkedList singleLinkedList;
    HeroNode node1;
    HeroNode node2;
    HeroNode node3;
    HeroNode node4;

    @Before
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
        singleLinkedList.addHeroNode(node2);
        //TODO 再次添加重复元素node1时，为何node1原结构发生改变？
       /* singleLinkedList.addHeroNode(node1);
        singleLinkedList.addHeroNode(node2);*/
        singleLinkedList.list();
    }


}
