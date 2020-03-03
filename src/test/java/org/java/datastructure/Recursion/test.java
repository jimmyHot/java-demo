package org.java.datastructure.Recursion;

public class test {

    public static void main(String[] args) {
        print(4);
    }

    private static void print(int n) {
        if (n > 2) {
            print(n - 1);
        }
        System.out.println("n=" + n);
    }



}
