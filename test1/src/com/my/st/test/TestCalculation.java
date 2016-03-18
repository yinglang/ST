package com.my.st.test;

import static org.junit.Assert.*; //注意这边,静态导入

import com.my.st.Calculation;
import org.junit.Ignore;
import org.junit.Test;


public class TestCalculation {

    @Test
    public void testPlus() {
        Calculation cal = new Calculation();
        assertEquals(cal.plus(5, 5), 10);
    }

    @Test
    public void testSubtraction() {
        Calculation cal = new Calculation();
        assertEquals(cal.subtraction(5, 5), 0);
    }

    @Ignore
    @Test
    public void testMultiplication() {
        Calculation cal = new Calculation();
        assertTrue(cal.multiplication(5, 5) > 20);
    }

    // 不抛异常会报错
    @Test(expected = java.lang.ArithmeticException.class, timeout = 50)
    public void testDivision() {
        Calculation cal = new Calculation();
        assertEquals(cal.division(8, 0), 4); //大家注意看,除数是0
    }
}

