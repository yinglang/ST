package com.my.st;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

// �������������� @Parameterized.Parameters�������ɹ��캯���Ĳ���������ÿ�����ǰ˳���ʹ��һ���������һ�����󣨼����³�Ա������
// �������ǿ��Խ���������������
@RunWith(Parameterized.class)
public class TriangleParameterizedTest {
    private double[] edge = new double[3];
    private Triangle.Type expected;

    // ���캯������public
    public TriangleParameterizedTest(double[] edge, Triangle.Type expected){
        this.edge = edge;
        this.expected = expected;
    }

    // ���� TriangleParameterizedTest ���캯���Ĳ���
    @Parameterized.Parameters
    public static Collection<Object[]> getData(){
        return Arrays.asList(new Object[][]{
                {new double[]{1, 1, 1}, Triangle.Type.SHARP},
                {new double[]{1,2,3}, Triangle.Type.ILLEGAL}
        });
    }

    @Before
    public void setUp(){

    }

    @Test
    public void test(){
        assertEquals(this.expected, new Triangle(this.edge[0], this.edge[1], this.edge[2]).getType());
    }
}
