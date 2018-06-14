import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class TableTest {
	
	private Table SortedTableTest;
	private Table UnsortedTableTest;
	private Table EmptyTableTest;
	private Table NullTableTest;
	private Table TableEqualToSorted;
	private Table NullObject;
	
	@Before
	public void SetUp() {
		NullObject = null;
		SortedTableTest = new Table(5);
		TableEqualToSorted = new Table(5);
		for(int i = 0; i < SortedTableTest.array.length; i++){
			SortedTableTest.array[i] = i + 2;
			TableEqualToSorted.array[i] = i + 2;
		}
		UnsortedTableTest = new Table(5);
		
		UnsortedTableTest.array[0] = 63;
		UnsortedTableTest.array[1] = 62;
		UnsortedTableTest.array[2] = 3;
		UnsortedTableTest.array[3] = 21;
		UnsortedTableTest.array[4] = 18;
		
		EmptyTableTest = new Table(0);
		NullTableTest = new Table();
	}

	@Test
	public void CheckEmptyIsSorted() {
		assertEquals(true, EmptyTableTest.isSorted());
	}
	
	@Test(expected = IllegalStateException.class)
	public void CheckNullIsSorted() {
		assertEquals(null, NullTableTest.isSorted());
	}
	
	@Test
	public void CheckSortedIsSorted() {
		assertEquals(true, SortedTableTest.isSorted());
	}
	
	@Test
	public void CheckUnsortedIsSorted() {
		assertEquals(false, UnsortedTableTest.isSorted());
	}
	
	@Test
	public void CheckSortedLargest() {
		assertEquals(6, SortedTableTest.largest());
	}
	
	@Test
	public void CheckSortedSmallest() {
		assertEquals(2, SortedTableTest.smallest());
	}
	
	@Test
	public void CheckUnSortedLargest() {
		assertEquals(63, UnsortedTableTest.largest());
	}
	
	@Test
	public void CheckUnSortedSmallest() {
		assertEquals(3, UnsortedTableTest.smallest());
	}
	
	@Test(expected = IllegalStateException.class)
	public void CheckEmptySmallest() {
		assertEquals(null, EmptyTableTest.smallest());
	}
	
	@Test(expected = IllegalStateException.class)
	public void CheckEmptyLargest() {
		assertEquals(null, EmptyTableTest.largest());
	}
	
	@Test(expected = IllegalStateException.class)
	public void CheckENullSmallest() {
		assertEquals(null, NullTableTest.smallest());
	}
	
	@Test(expected = IllegalStateException.class)
	public void CheckENullLargest() {
		assertEquals(null, NullTableTest.largest());
	}
	
	@Test
	public void CheckEqualsTwoSameTableObjects() {
		assertTrue(SortedTableTest.equals(SortedTableTest));
	}
	
	@Test
	public void CheckEqualsTwoDifferentTableWithSameValues() {
		assertTrue(SortedTableTest.equals(TableEqualToSorted));
	}
	
	@Test
	public void CheckEqualsTwoDifferentTablesValues() {
		assertFalse(SortedTableTest.equals(UnsortedTableTest));
	}
	
	@Test
	public void CheckNullTablesWithSortedTable() {
		assertFalse(SortedTableTest.equals(NullTableTest));
	}
	
	@Test
	public void CheckTwoNullTables() {
		assertTrue(NullTableTest.equals(NullTableTest));
	}
	
	@Test(expected = NullPointerException.class)
	public void CheckTwoNullObjects() {
		assertFalse(NullObject.equals(NullObject));
	}
	
	@Test
	public void CheckTwoNullTablesWithEquals() {
		assertEquals(NullTableTest, NullTableTest);
	}

}