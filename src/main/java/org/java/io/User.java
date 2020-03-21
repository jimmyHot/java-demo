package org.java.io;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    //年龄
    private int age;
    //名字
    private String name ;
}
