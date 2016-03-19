package com.my.st;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

// 参数化的类会调用 @Parameterized.Parameters函数生成构造函数的参数，并在每组测试前顺序的使用一组参数生成一个对象（即更新成员变量）
// 所以我们可以将测试用例参数化
@RunWith(Parameterized.class)
public class TriangleParameterizedTest {
    private double[] edge = new double[3];
    private Triangle.Type expected;

    // 构造函数必须public
    public TriangleParameterizedTest(double[] edge, Triangle.Type expected){
        this.edge = edge;
        this.expected = expected;
    }

    // 生成 TriangleParameterizedTest 构造函数的参数
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
