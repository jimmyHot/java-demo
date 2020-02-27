package org.java.datastructure.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionStackTest {
    ExpressionStack expressionStack=new ExpressionStack();

    @Test
    void Calculate(){
        String expression="1+2*3-4+8/2";
        int calculate = expressionStack.Calculate(expression);
        assertEquals(7,calculate);
    }

}