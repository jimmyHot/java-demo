package org.java.datastructure.linkedList;

import lombok.Data;

@Data
public class Node {
    private int no;
    private Node next;

    public Node(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", next=" + next +
                '}';
    }
}
