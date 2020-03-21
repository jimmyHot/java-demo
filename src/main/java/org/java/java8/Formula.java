package org.java.java8;

/**
 * 特性1：接口中可使用default关键字
 */
public interface Formula {

    double calculate(int a);

    /**
     * 可提供default实现
     * @param a
     * @return
     */
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
