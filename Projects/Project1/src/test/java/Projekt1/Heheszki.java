package Projekt1;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.hamcrest.Matchers;

public class Heheszki {
	
	private Kontrakt test;
	
	@Before
	public void setUp() {
		test = new Kontrakt();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void Heheszki_Lesser_Than_Zero_Should_Throw_Exception() {
		test.Heheszki(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void Heheszki_Null_Input_Should_Throw_Exception() {
		test.Heheszki(null);
	}
	
	@Test
	public void Heheszki_Should_Be_Different_from_Input() {
		assertThat(test.Heheszki(1), not(1));
	}
	
	@Test
	public void Heheszki_Should_Be_Different_From_One_Is_Zero() {
		assertThat(test.Heheszki(1), is(0));
	}
	
	@Test
	public void Heheszki_Proper_Input_Should_Be_Less_Than_Input() {
		assertTrue(test.Heheszki(12) < 12);
	}
	
	@Test
	public void Heheszki_Proper_Input_Should_Be_GreaterEqual_Than_Zero() {
		assertTrue(test.Heheszki(12) >= 0);
	}
	
	@Test
	public void Heheszki_Zero_Input_Should_return_Zero() {
		assertTrue(test.Heheszki(0) == 0);
	}
	
	@After
	public void tearDown() {
		test = null;
	}

}
