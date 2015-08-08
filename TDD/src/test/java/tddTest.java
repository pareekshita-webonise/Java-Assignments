import static org.junit.Assert.assertArrayEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class tddTest {
private removeDuplicate r; 
	
	@Before
	public void init() {
		System.out.println("Before");
		r = new removeDuplicate();
	}
	@After
	public void teardown() {
		System.out.println("nothing to teardown");
	}
	
	@Test
	public void testRemoveDuplicateElem() {
		int[] arr = new int[] { 1, 2, 1, 1, 1, 5 };
		int[] resultArr = r.removeDup(arr);		
		assertArrayEquals(new int[] {1, 2, 1, 5},  resultArr);
	}
	@Test
		public void testRemoveDuplicateElem1() {
			int[] arr = new int[] { 1, 2, 1, 1, 1, 5, 6, 6, 6, 6, 0, 6, 6, 8};
			int[] resultArr = r.removeDup(arr);		
			assertArrayEquals(new int[] {1, 2, 1, 5, 6, 0, 6, 8},  resultArr);
	}
	@Test
	public void testRemoveElemNoDuplicate() {
		int[] arr = new int[] { 1, 2, 3, 4, 1, 5 };
		int[] resultArr = r.removeDup(arr);		
		assertArrayEquals(new int[] { 1, 2, 3, 4, 1, 5 },  resultArr);
	}
	@Test
	public void testRemoveElemAllDuplicate() {
		int[] arr = new int[] { 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4, 4 };
		int[] resultArr = r.removeDup(arr);		
		assertArrayEquals(new int[] { 4 },  resultArr);
	}
	@Test
	public void testRemoveDuplicateEmptyArray() {
		int[] arr = new int[] {};
		int[] resultArr = r.removeDup(arr);		
		assertArrayEquals(new int[] { },  resultArr);
	}
}