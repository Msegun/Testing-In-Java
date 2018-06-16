package Projekt1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TiTit {
	
	private Kontrakt testNumber;
	
	@Before
	public void setUp() {
		testNumber = new Kontrakt(5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void TiTitThrowsExceptionWithNullInput() {
		testNumber.Titit(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void TiTitThrowsExceptionWithZeroInput() {
		testNumber.Titit(0);
	}
	
	@Test
	public void TiTitReturnsTrueWithCorrectInput() {
		assertTrue(testNumber.Titit(5));
	}
	
	@Test
	public void TiTitReturnsFalseWithIncorrectInput() {
		assertFalse(testNumber.Titit(4));
	}
	

	@After
	public void tearDown() {
		testNumber = null;
	}

}
