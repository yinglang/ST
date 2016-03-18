package com.my.st;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

// 运行该程序会运行TriangleTest和TriangleTest2
@RunWith(Suite.class)
@Suite.SuiteClasses({TriangleTest.class, TriangleTest2.class})
public class TriangleSuitTest {

}
