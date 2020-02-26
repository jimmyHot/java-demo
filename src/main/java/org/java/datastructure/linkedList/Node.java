package org.java.datastructure.linkedList;

import lombok.Data;

@Data
public class Node {
    private int no;
    private Node next;

    public Node(int no) {
        this.no = no;
    }

}
