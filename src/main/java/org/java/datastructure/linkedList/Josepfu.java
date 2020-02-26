package org.java.datastructure.linkedList;


import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * 约瑟夫问题
 */
@NoArgsConstructor
public class Josepfu {

    /**
     * 链表中第一个节点
     */
    private Node first;
    /**
     * 链表中最后一个节点
     */
    private Node last;

    /**
     * 链表中总节点个数
     */
    private int count;

    public Josepfu(Node first) {
        this.first = first;
    }

    public Node getFirst() {
        return first;
    }

    public int getCount() {
        return count;
    }

    public Node getLast() {
        return last;
    }

    /**
     * 添加节点
     * //todo 第一版
     * 缺点：需要遍历链表来插入，看第二版（增加类变量：last）
     *
     * @param node
     */
    @Deprecated
    public boolean addNode(Node node) {
        //如果头结点为空，直接添加即可
        if (first == null) {
            first = node;
            node.setNext(node);
            count++;
            return true;
        }
        //定义一个临时变量culNode，用于遍历该链表,当curNode.getNext=first即可添加node
        Node culNode = first;
        while (true) {
            if (culNode.getNext() == first) {
                culNode.setNext(node);
                node.setNext(first);
                count++;
                break;
            }
            culNode = culNode.getNext();
        }
        return true;
    }

    /**
     * 初始化n个节点的环形链表
     *
     * @param n 节点个数
     * @return
     */
    public boolean init(int n) {
        //参数校验
        if (n < 0) {
            System.out.println("节点个数不得小于0~");
        }
        Node node;
        //当添加第一个节点时，（即链表为空）
        if (n >= 1) {
            node = new Node(1);
            first = node;
            last = node;
            count = 1;
        }
        //当n>1时，在last节点后添加
        for (int i = 2; i <= n; i++) {
            node = new Node(i);
            last.setNext(node);
            node.setNext(first);
            last = node;
            count++;
        }
        return true;
    }


    /**
     * 约瑟夫计算
     * n个小孩环绕而坐，从第k个小孩开始数m个数，数到m数的这个小孩依次出圈，求最后出圈列表
     * 定义两个变量outPointer,outPrinterPre
     * outPointer表示要出圈的节点，初始值为first
     * outPointerPre表示outPointer的前一个节点，outPrinter出圈时，辅助设置链表指针使用,初始值为last
     * outPointer 移动m-1个节点后，即要出圈的节点
     *
     * @return
     */
    public String getResult(int n, int k, int m) {
        //入参校验
        if(n<0 || k>n){
            System.out.println("参数有误~");
        }
        //初始化环形链表
        init(n);
        Node outPointer = first;
        Node outPointerPre = last;
        //设置outPointer第k个节点的位置
        while (outPointer.getNo() != k) {
            outPointer = outPointer.getNext();
            outPointerPre = outPointerPre.getNext();
        }
        //遍历链表，移动m-1时，即出圈
        int count =0;//表示当前移动了多少次
       StringBuilder result = new StringBuilder();
        while (outPointer!=outPointerPre){
            if(count==m-1){
                //此时outPointer对应的节点即出圈
                result.append(outPointer.getNo());
                outPointer=outPointer.getNext();
                outPointerPre.setNext(outPointer);
                count=0;
            }else {
                //移动指针，继续循环
                outPointer = outPointer.getNext();
                outPointerPre = outPointerPre.getNext();
                count++;
            }
        }
        result.append(outPointer.getNo());
        return result.toString();
    }


}
