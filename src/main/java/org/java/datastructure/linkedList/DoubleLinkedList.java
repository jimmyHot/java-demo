package org.java.datastructure.linkedList;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DoubleLinkedList {

    private HeroNode2 head = new HeroNode2(0, "");
    /**
     * 当前链表节点个数
     */
    private int count=0;

    /**
     * 获取当前链表节点个数
     * @return
     */
    public int getCount() {
        return count;
    }

    /**
     * 在链表的尾部添加节点
     *
     * @param node
     * @return
     */
    public boolean add(HeroNode2 node) {
        HeroNode2 temp = head;
        while (true) {
            if (temp.getNext() == null) {
                temp.setNext(node);
                node.setPre(temp);
                count++;
                break;
            }
            temp = temp.getNext();
        }
        return true;
    }

    /**
     * 删除节点（可自删除）
     *
     * @param no
     * @return
     */
    public boolean delete(int no) {
        HeroNode2 temp = head.getNext();
        if (temp == null) {
            System.out.println("链表为空~");
            return false;
        }
        while (true) {
            if (temp.getNo() == no) {
                //temp 即为要删除的节点
                temp.getPre().setNext(temp.getNext());
                temp.getNext().setPre(temp.getPre());
                count--;
                break;
            }
            temp=temp.getNext();
        }
        return true;
    }


    /**
     * 列表展示
     */
    public void list() {

        if (head.getNext() == null) {
            System.out.println("链表内容为空");
        }
        HeroNode2 temp = head.getNext();
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.getNext();
        }
    }


    /**
     * 获取链表的总节点个数
     *
     * @return
     */
    public int getNumber() {
        HeroNode2 temp = this.head;
        int count = 0;
        while (temp.getNext() != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

}
