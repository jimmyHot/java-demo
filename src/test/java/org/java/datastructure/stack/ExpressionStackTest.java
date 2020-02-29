package org.java.datastructure.stack;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ExpressionStackTest {
    ExpressionStack expressionStack = new ExpressionStack();

    @Test
    void Calculate() {
        int calculate;
        calculate = expressionStack.Calculate("1+2*3-4+8/2");
        assertEquals(7, calculate);
        calculate = expressionStack.Calculate("4*2+3-4+4/2");
        assertEquals(9, calculate);
        calculate = expressionStack.Calculate("14*2+3-4+4/2");
        assertEquals(29, calculate);

    }

    @Test
    void CalculatePostfixExpression() {
        assertEquals(11, expressionStack.CalculatePostfixExpression("1 3 4 + 2 * + 4 -"));
        assertEquals(20, expressionStack.CalculatePostfixExpression("10 3 4 + 2 * + 4 -"));
    }

    @Test
    void formatMidToPostFixExpression(){
        assertEquals("1 3 4 + 2 * + 4 -",expressionStack.formatMidToPostFixExpression("1+(3+4)*2-4"));
        assertEquals("1 2 3 + 4 * + 5 -",expressionStack.formatMidToPostFixExpression("1+((2+3)*4)-5"));
        assertEquals("1 10 3 + 4 * + 5 -",expressionStack.formatMidToPostFixExpression("1+((10+3)*4)-5"));
    }
}