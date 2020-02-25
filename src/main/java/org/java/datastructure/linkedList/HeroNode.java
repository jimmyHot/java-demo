package org.java.datastructure.linkedList;

import lombok.Data;

@Data
public class HeroNode {
    private int no;
    private String name;
    private HeroNode next;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name +"'"+
                '}';
    }
}
