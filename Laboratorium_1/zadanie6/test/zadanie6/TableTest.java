package zadanie6;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TableTest {

	private Table<Integer> UnsortedIntArray;
	private Table<Integer> SortedIntArray;
	private Table<Character> UnsortedCharArray;
	private Table<Character> SortedCharArray;
	private Table<String> UnsortedStringArray;	
	private Table<String> SortedStringArray;
	private Table<Double> EmptyArray;
	
	@Before
	public void Setup() {
		
		UnsortedIntArray = new Table<Integer>();
		UnsortedIntArray.add(4);
		UnsortedIntArray.add(5);
		UnsortedIntArray.add(2);
		
		SortedIntArray = new Table<Integer>();
		SortedIntArray.add(1);
		SortedIntArray.add(2);
		SortedIntArray.add(3);
		
		UnsortedCharArray = new Table<Character>();
		UnsortedCharArray.add('z');
		UnsortedCharArray.add('b');
		UnsortedCharArray.add('g');
		UnsortedCharArray.add(' ');
		UnsortedCharArray.add('.');
		
		SortedCharArray = new Table<Character>();
		SortedCharArray.add(' ');
		SortedCharArray.add('b');
		SortedCharArray.add('c');
		SortedCharArray.add('g');
		SortedCharArray.add('z');
		
		UnsortedStringArray = new Table<String>();
		UnsortedStringArray.add("Bobby");
		UnsortedStringArray.add("Angel");
		UnsortedStringArray.add("Joe");
		
		SortedStringArray = new Table<String>();
		SortedStringArray.add("Angel");
		SortedStringArray.add("Bobby");
		SortedStringArray.add("Joe");
		
		EmptyArray = new Table<Double>();
	}
	
	@Test
	public void CheckLargestSortedInt() {
		assertEquals(Integer.valueOf(3), SortedIntArray.largest());
	}
	
	@Test
	public void CheckSmallestSortedInt() {
		assertEquals(Integer.valueOf(1), SortedIntArray.smallest());
	}
	
	@Test
	public void CheckisSortedSortedInt() {
		assertEquals(true, SortedIntArray.isSorted());
	}
	
	@Test
	public void CheckLargestUnSortedInt() {
		assertEquals(Integer.valueOf(5), UnsortedIntArray.largest());
	}
	
	@Test
	public void CheckSmallestUnsortedInt() {
		assertEquals(Integer.valueOf(2), UnsortedIntArray.smallest());
	}
	
	@Test
	public void CheckisSortedUnsortedInt() {
		assertEquals(false, UnsortedIntArray.isSorted());
	}
	
	@Test
	public void CheckLargestSortedChar() {
		assertEquals(Character.valueOf('z'), SortedCharArray.largest());
	}
	
	@Test
	public void CheckSmallestSortedChar() {
		assertEquals(Character.valueOf(' '), SortedCharArray.smallest());
	}
	
	@Test
	public void CheckIsSortedSortedChar() {
		assertEquals(true, SortedCharArray.isSorted());
	}
	
	@Test
	public void CheckIsSortedSortedString() {
		assertEquals(true, SortedStringArray.isSorted());
	}
	
	@Test
	public void CheckIsLargestSortedString() {
		assertEquals("Joe", SortedStringArray.largest());
	}
	
	@Test
	public void CheckIsSmallestSortedString() {
		assertEquals("Angel", SortedStringArray.smallest());
	}
	
	@Test
	public void CheckIsSortedUnsortedString() {
		assertEquals(false, UnsortedStringArray.isSorted());
	}
	
	@Test
	public void CheckIsLargestUnsortedString() {
		assertEquals("Joe", UnsortedStringArray.largest());
	}
	
	@Test
	public void CheckIsSmallestUnsortedString() {
		assertEquals("Angel", UnsortedStringArray.smallest());
	}
	
	@Test(expected = IllegalStateException.class)
	public void CheckSmallestEmpty() {
		assertEquals(null, EmptyArray.smallest());
	}
	
	@Test(expected = IllegalStateException.class)
	public void CheckLargestEmpty() {
		assertEquals(null, EmptyArray.largest());
	}
	
	@Test
	public void CheckIsSortedEmpty() {
		assertEquals(true, EmptyArray.isSorted());
	}
}
