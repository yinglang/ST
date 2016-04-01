import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class SortTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	int[] array = new int[11];
	@Before
	public void setUp() throws Exception {
		for(int i = 0; i < 11; i++){
			array[i] = i;
		}
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertionSort() {
		array[0] = 5;
		array[5] = 3;
		array[3] = 9;
		array[9] = 0;
		array[10] = 3;
		new Sorting().insertionSort(array);
		assertTrue(array[0] == 0);
		assertTrue(array[1] == 1);
		assertTrue(array[2] == 2);
		assertTrue(array[3] == 3);
		for(int i = 4; i < 11; i++){
			//System.out.println(array[i]);
			assertTrue(array[i] == i - 1);
		}
		//fail("Not yet implemented");
	}

	@Test
	public void testIsSorted() {

		assertTrue(new Sorting().isSorted(array));
		array[0] = 5;
		array[5] = 3;
		array[3] = 9;
		array[9] = 3;
		assertFalse(new Sorting().isSorted(array));
	}

	@Test
	public void testQuicksort() {
		array[0] = 5;
		array[5] = 3;
		array[3] = 9;
		array[9] = 0;
		new Sorting().quicksort(array);
		for(int i = 0; i < 10; i++)
			assertTrue(array[i] == i);
	}

	@Test
	public void testSwapReferences() {
		//fail("Not yet implemented");
		//new Sorting().swapReferences((Object[])(array), 0, 3);
	}

	@Test
	public void testSwap() {
		//fail("Not yet implemented");
		
	}

}
