package mavenFirstTime;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
/**
 * Unit test for simple binSearch.
 */
public class BinSearchTest 
{	 
	private BinSearch b;
	private int soratedIntTable[] = {1, 2 ,3 ,4 ,5};
	private int unsortedIntTable[] = {5, 2 ,1 ,7 ,6};
	private int emptyIntTable[] = {};
	private int nullTable[] = null;
	
	@BeforeEach
	public void setUp(){
		 b = new BinSearch();
	}
	
	 @Test
	 void SortedArraySearchTest(){
		 assertEquals(2, b.binarySearch(soratedIntTable, 3, 0, soratedIntTable.length-1));
	 }
	 
	 @Test
	 void UnSortedArraySearchTest(){
		 assertEquals(3, b.binarySearch(unsortedIntTable, 7, 0, unsortedIntTable.length-1));
	 }
	 
	 @Test
	 void EmptyArraySearchTest(){
		 assertEquals(-1, b.binarySearch(emptyIntTable, 7, 0, emptyIntTable.length-1));
	 }
	 
	 @Test
	 void nullArraySearchTest(){
		 //assertEquals(-1, b.binarySearch(nullTable, 7, 0, nullTable.length-1));
		 Throwable exception = assertThrows(NullPointerException.class,
		            ()->{b.binarySearch(nullTable, 7, 0, nullTable.length-1);} );
	 }
	 
	 
	 
	 
	 
	 @AfterEach
	 public void tearDown(){
		 b = null;
		 soratedIntTable = null;
		 unsortedIntTable= null;
	 }
}
