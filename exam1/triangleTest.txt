import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TriangleTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	Triangle[] tri = new Triangle[4];
	@Before
	public void setUp() throws Exception {
		tri[0] = new Triangle(3,3,3);
		tri[1] = new Triangle(3,3,4);
		tri[2] = new Triangle(3,4,5);
		tri[3] = new Triangle(1,2,3);
		
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testIsTriangle() {
		assertTrue(tri[0].isTriangle(tri[0]));
		assertTrue(tri[0].isTriangle(tri[1]));
		assertTrue(tri[0].isTriangle(tri[2]));
		assertTrue(tri[0].isTriangle(tri[3]) == false);
		//assertTrue(tri[0].isTriangle(tri[0]));
		
	}

	@Test
	public void testGetType() {
		assertTrue(tri[0].getType(tri[0]).equals("Regular"));
		assertTrue(tri[0].getType(tri[1]).equals("Isosceles"));
		assertTrue(tri[0].getType(tri[2]).equals("Scalene"));
		assertTrue(tri[0].getType(tri[3]).equals("Illegal"));
	}

	@Test
	public void testDiffOfBorders() {
		
	}

	@Test
	public void testGetBorders() {
		for(int i = 0; i < 3; i++){
			
			long[] b = tri[0].getBorders();
			assertTrue(b[i] == 3);
		}
	}

}
