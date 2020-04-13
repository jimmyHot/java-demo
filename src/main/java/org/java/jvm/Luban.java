package org.java.jvm;

import org.openjdk.jol.info.ClassLayout;

public class Luban {

    public static void main(String[] args) {
        Luban luban=new Luban();
        System.out.println(ClassLayout.parseInstance(luban).toPrintable());
    }
}
