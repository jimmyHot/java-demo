package org.java.design.mode;

import lombok.Data;

import java.io.Serializable;

/**
 * 单例模式
 * 实现方式：饿汉式
 * 特点：
 * 线程安全（原因：static静态变量会在jvm加载这个类时创建实例，而非使用该实例时）；
 * 空间换时间方式
 */
@Data
public class Singleton1 implements Serializable {

    public String name;

    private static Singleton1 instance = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return instance;
    }


    /**
     * 序列化会通过反射调用无参数的构造方法创建一个新的对象
     * 在Singleton中定义readResolve方法，并在该方法中指定要返回的对象的生成策略，就可以防止单例被破坏
     * @return
     */
    private Object readResolve() {
        return instance;
    }

    @Override
    public String toString() {
        return "Singleton1{" +
                "name='" + name + '\'' +
                '}';
    }
}
