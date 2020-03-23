package org.java.design.mode;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;


class Singleton1Test {

    @Test
    void getInstance() {
        Singleton1 singleton1 = Singleton1.getInstance();
        singleton1.setName("贾丽敏");
        Singleton1 singleton2 = Singleton1.getInstance();
        singleton2.setName("jialimin");
        System.out.println(singleton1.toString());
        System.out.println(singleton2.toString());
        assertEquals(singleton1, singleton2);
    }


    /**
     * 测试序列化&反序列化对单例模式的影响
     * 序列化会通过反射调用无参数的构造方法创建一个新的对象
     *
     */
    @Test
    void testSerializableForSingleton() throws Exception {
        Stack<Integer> resultStack=new Stack<>();
        Singleton1 singleton1 = Singleton1.getInstance();
        //write object to file
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/jialimin/Desktop/testSerializableForSingleton.txt"));
        objectOutputStream.writeObject(singleton1);
        //read file to object
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("/Users/jialimin/Desktop/testSerializableForSingleton.txt"));
        Singleton1 newInstance = (Singleton1) inputStream.readObject();
        assertEquals(singleton1, newInstance);//true
        System.out.println(singleton1==newInstance);//false
    }
}