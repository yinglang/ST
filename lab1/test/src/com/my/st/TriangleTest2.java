package com.my.st;
import org.junit.Test;
import static org.junit.Assert.*; // ʹ��static������������ľ�̬�������þͲ�����ǰ��д��������

/**
 * �������Ϊ���� Suite.class
 */
public class TriangleTest2 {

    @Test
    public void test1(){
        assertTrue("error in Test2", new Triangle(4, 3, 5).getType() == Triangle.Type.RIGHT);
    }
}
