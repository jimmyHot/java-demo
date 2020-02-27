package org.java.datastructure.stack;

import org.java.datastructure.linkedList.Node;

/**
 * 基于链表实现栈结构
 * todo :不知道链表如何实现更好？
 */
public class LinkedStack {

    private Node top;

    /**
     * 栈顶的下一个节点
     */
    private Node topPre;

    private int count;

    public LinkedStack() {
        this.top = null;
        this.topPre=null;
    }


    public void push(int num) {
        Node node = new Node(num);
        if (top != null) {
            top.setNext(node);
        }
        topPre=top;
        top = node;
        if(topPre!=null){
            topPre.setNext(top);
        }


        count++;
    }

    public void pop(){

    }

}
