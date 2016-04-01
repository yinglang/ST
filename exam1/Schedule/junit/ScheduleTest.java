import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class ScheduleTest {

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	List<Work> lst = new ArrayList<Work>();
	@Before
	public void setUp() throws Exception {
		lst.add(new Work("1", 0, 1));
		lst.add(new Work("2", 0, 2));
		lst.add(new Work("5", 1, 6));
		lst.add(new Work("6", 2, 7));
		lst.add(new Work("3", 1, 4));
		lst.add(new Work("4", 3, 5));

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFCFS() {
		//fail("Not yet implemented");
		List l = new Schedule().FCFS(lst);
		//System.out.println((Double)(l.get(0)));
		//System.out.println((Double)(l.get(1)));
		assertTrue((Double)(l.get(0)) == 11.166666666666666);
		assertTrue((Double)(l.get(1)) == 2.4972222222222222);
	}

	@Test
	public void testSJF() {
		List l = new Schedule().SJF(lst);
		//System.out.println((Double)(l.get(0)));
		//System.out.println((Double)(l.get(1)));
		assertTrue((Double)(l.get(0)) == 9.833333333333334);
		assertTrue((Double)(l.get(1)) == 1.9865079365079368);
	}

	@Test
	public void testSortByServiceTime() {
		List l = new Schedule().sortByServiceTime(lst);
		for(int i = 0; i < l.size(); i++){
			Work w = (Work)l.get(i);
			//System.out.println(w.getArrivalTime() + " " + w.getServiceTime());
		}
		
		assertTrue(((Work)(l.get(0))).getServiceTime() == 1);
		assertTrue(((Work)(l.get(1))).getServiceTime() == 2);
		assertTrue(((Work)(l.get(2))).getServiceTime() == 4);
		assertTrue(((Work)(l.get(3))).getServiceTime() == 5);
		assertTrue(((Work)(l.get(4))).getServiceTime() == 6);
		assertTrue(((Work)(l.get(5))).getServiceTime() == 7);
	}

}
