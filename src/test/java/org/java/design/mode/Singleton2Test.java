package org.java.design.mode;

import org.junit.jupiter.api.Test;


class Singleton2Test {

    @Test
    void getInstance() {
        Singleton2 singleton = Singleton2.INSTANCE;
        singleton.doSomeThing();//output:枚举方法实现单例
    }

}