package org.java.arithmetic.dynamicplanning;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DpTest {

    @Test
    void jumpNum() {
        Dp dp = new Dp();
        assertEquals(3, dp.jumpNum(3));
        assertEquals(5, dp.jumpNum(4));
    }

    @Test
    void uniquePaths() {
        Dp dp = new Dp();
        assertEquals(2,dp.uniquePaths(2,2));
        assertEquals(3,dp.uniquePaths(3,2));

    }

    @Test
    void minCount(){
        Dp dp = new Dp();
        assertEquals(3,dp.minCount("horse","ros"));
    }
}