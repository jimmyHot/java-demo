package org.java.datastructure.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {

    ArrayStack arrayStack = new ArrayStack(5);

    @Test
    void push() {
        arrayStack.push("1");
        assertEquals(1, arrayStack.getCount());
        arrayStack.push("1");
        assertEquals(2, arrayStack.getCount());
        arrayStack.list();
    }

    @Test
    void pop() {
        arrayStack.push("1");
        assertEquals("1", arrayStack.pop());
        assertEquals(0, arrayStack.getCount());
    }


}