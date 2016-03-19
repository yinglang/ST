package com.my.st.test;

import static org.junit.Assert.*; //ע�����,��̬����

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

    // �����쳣�ᱨ��
    @Test(expected = java.lang.ArithmeticException.class, timeout = 50)
    public void testDivision() {
        Calculation cal = new Calculation();
        assertEquals(cal.division(8, 0), 4); //���ע�⿴,������0
    }
}

