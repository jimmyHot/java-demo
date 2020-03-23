package org.java.design.mode;

/**
 * 单例模式
 * 实现方式：枚举
 * 特点：网上写单例的一种方式，自己看着感觉很怪，为什么类要用枚举去做？
 */
public enum Singleton2 {
    INSTANCE;

    public void doSomeThing() {
        System.out.println("枚举方法实现单例");
    }
}
