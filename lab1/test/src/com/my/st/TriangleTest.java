// 这个Test添加dependencies
package com.my.st;

import static org.junit.Assert.*;
import org.junit.*;

public class TriangleTest {

    @BeforeClass
    public static void initBeforeClass(){
        System.out.println("initBeforeClass");
    }

    @Before
    public void initBeforeEveryTest(){
        System.out.println("initBeforeEveryTest");
    }

    // test 必须是public
    @Test
    public void test1(){
        System.out.println("test1");
        Triangle triangle = new Triangle(1,2,3);
        assertTrue("error", triangle.getType() == Triangle.Type.ILLEGAL);
    }

    @Test
    public void test2(){
        System.out.println("test2");
        Triangle triangle = new Triangle(3,2,2);
        assertTrue("error", triangle.getType() == Triangle.Type.OBTUSE);
    }

    @After
    public void releaseAfterEveryTest(){
        System.out.println("releaseAfterEveryTest");
    }

    @AfterClass
    public static void releaseAfterClass(){
        System.out.println("releaseAfterClass");
    }
}
