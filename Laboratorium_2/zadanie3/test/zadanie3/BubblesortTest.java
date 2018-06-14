package zadanie3;

import static org.junit.Assert.*;

import org.junit.Test;

public class BubblesortTest {

	@Test
	public void testTrueForSortedArray() {
		Integer[] table = {1, 2, 3};
		Bubblesort sortedArc = new Bubblesort(table);
		assertTrue(sortedArc.isSorted("R"));
	}
	
	@Test
	public void testArraywithSameElements() {
		Integer[] table = {1, 1, 1};
		Bubblesort sortedArc = new Bubblesort(table);
		assertTrue(sortedArc.isSorted("R"));
	}
	
	@Test
	public void testArraywithSameElementsRev() {
		Integer[] table = {1, 1, 1};
		Bubblesort sortedArc = new Bubblesort(table);
		assertTrue(sortedArc.isSorted("M"));
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void testSortedwithnullArg() {
		Bubblesort sortedArc = new Bubblesort();
		sortedArc.bubbleSort(null);
		assertTrue(sortedArc.isSorted("R"));
	}
	
	@Test
	public void testFalseForSortedArrayReversed() {
		Integer[] table = {1, 2, 3};
		Bubblesort sortedArc = new Bubblesort(table);
		assertFalse(sortedArc.isSorted("M"));
	}
	
	@Test
	public void testSortingArray() {
		Integer[] table = {5, 31, 12, 7};
		Bubblesort newtable = new Bubblesort(table);
		newtable.bubbleSort("M");
		assertTrue(newtable.isSorted("M"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEvilStringUno() {
		Integer[] table = {5, 31, 12, 7};
		Bubblesort newtable = new Bubblesort(table);
		newtable.bubbleSort("KUPA");
		assertTrue(newtable.isSorted("M"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEvilStringDos() {
		Integer[] table = {5, 31, 12, 7};
		Bubblesort newtable = new Bubblesort(table);
		newtable.bubbleSort("R");
		assertTrue(newtable.isSorted("Maryna"));
	}
	
	@Test
	public void testSortingArrayReversed() {
		Integer[] table = {5, 31, 12, 7};
		Bubblesort newtable = new Bubblesort(table);
		newtable.bubbleSort("R");
		assertTrue(newtable.isSorted("R"));
	}
	
	@Test
	public void testIsSortedIfTablewasSortedBeforeRev() {
		Integer[] table = {5, 31, 12, 7};
		Bubblesort newtable = new Bubblesort(table);
		newtable.bubbleSort("R");
		assertFalse(newtable.isSorted("M"));
	}
	
	@Test
	public void testRevesedSortedTest() {
		Integer[] table = {5, 31, 12, 7};
		Bubblesort newtable = new Bubblesort(table);
		newtable.bubbleSort("M");
		assertFalse(newtable.isSorted("R"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNullTableSort() {
		Bubblesort newtable = new Bubblesort();
		newtable.bubbleSort("M");
		assertFalse(newtable.isSorted("R"));
	}
	
	@Test(expected = NullPointerException.class)
	public void testEmptyTableSort() {
		Integer[] table = {};
		Bubblesort newtable = new Bubblesort(table);
		newtable.bubbleSort("M");
		assertFalse(newtable.isSorted("R"));
	}

}
