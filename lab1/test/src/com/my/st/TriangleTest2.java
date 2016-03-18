package com.my.st;
import org.junit.Test;
import static org.junit.Assert.*; // 使用static，这样这里面的静态函数引用就不用在前面写上类名了

/**
 * 这个类视为测试 Suite.class
 */
public class TriangleTest2 {

    @Test
    public void test1(){
        assertTrue("error in Test2", new Triangle(4, 3, 5).getType() == Triangle.Type.RIGHT);
    }
}
