package org.java.design.mode;

/**
 * 单例模式
 * 实现方式：懒汉式
 * 特点：
 * 线程不安全（原因：在使用对象实例时才会加载，这时，在多线程情况下即可能触发多个实例）；
 * 解决方案：synchronized关键字
 */
public class Singleton3 {
    private static Singleton3 singleton3;

    private Singleton3() {
    }

    /**
     * 缺点1：syncchronized 锁太重，影响性能
     * 缺点2：易发生阻塞（不知道为什么会发生阻塞？？）
     *
     * @return
     */
    public static synchronized Singleton3 getInstance() {
        if (singleton3 == null) {
            singleton3 = new Singleton3();
        }
        return singleton3;
    }

    /**
     * 解决上边问题
     *
     * @return
     */
    public static Singleton3 getInstanceForDoubleCheck() {
        if (singleton3 == null) {
            synchronized (Singleton3.class) {
                if (singleton3 == null) {
                    singleton3 = new Singleton3();
                }
            }
        }
        return singleton3;
    }
}
