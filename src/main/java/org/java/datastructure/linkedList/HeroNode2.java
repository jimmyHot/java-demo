package org.java.datastructure.linkedList;

import lombok.Data;

@Data
public class HeroNode2 {

    private int no;
    private String name;
    private HeroNode2 next;
    private HeroNode2 pre;

    public HeroNode2(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
