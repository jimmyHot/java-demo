package org.java.datastructure.stack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 基于数组实现栈结构
 */
public class ArrayStack {

    /**
     * 栈顶
     */
    private int top;
    /**
     * 最大值
     * 为什么需要有最大值：基于数组实现栈结构时，数组需要初始化大小，所以即需要maxSize
     */
    private int maxSize;

    /**
     * 栈中元素个数
     */
    private int count;
    /**
     * 数组组装数据
     */
    private String[] stack;

    public int getCount() {
        return count;
    }

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.top=-1;
        this.stack=new String[maxSize];
    }



    public boolean isEmpty(){
        return top==-1;
    }

    public boolean isFull(){
        return top==maxSize-1;
    }

    public void push(String content){
        if(isFull()){
            System.out.println("栈已满~");
            return;
        }
        top++;
        stack[top]=content;
        count++;
    }

    public String pop(){
        if(isEmpty()){
            System.out.println("空栈~");
            return "";
        }
        String value=stack[top];
        top--;
        count--;
        return value;
    }

    public String peek(){
        if(isEmpty()){
            System.out.println("空栈~");
            return "";
        }
        return stack[top];
    }

    public void list(){
        for (int i=top;i>-1;i--){
            System.out.println(stack[i]);
        }
    }
}
