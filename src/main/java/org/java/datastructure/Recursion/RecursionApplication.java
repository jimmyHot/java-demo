package org.java.datastructure.Recursion;

import org.java.datastructure.linkedList.Node;

/**
 * 递归应用case
 */
public class RecursionApplication {


    /**
     * 通过递归实现链表的反转
     *
     * @param node
     * @return
     */
    public Node reverse(Node node) {
        Node temp;
        if (node.getNext() == null) {
            return node;
        } else {
            temp = reverse(node.getNext());
        }
        node.getNext().setNext(node);
        node.setNext(null);
        return temp;
    }
}
