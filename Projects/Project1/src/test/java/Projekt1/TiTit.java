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
	public void Should_return_Exception_With_Null_Input() {
		testNumber.Titit(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void Should_return_Exception_With_Zero_Input() {
		testNumber.Titit(0);
	}
	
	@Test
	public void Should_return_True_with_correct_Input() {
		assertTrue(testNumber.Titit(5));
	}
	
	@Test
	public void Should_return_False_with_Incorrect_Input() {
		assertFalse(testNumber.Titit(4));
	}
	

	@After
	public void tearDown() {
		testNumber = null;
	}

}
