package Projekt1;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Cyfrokrad {
	
	private Kontrakt test;
	
	@Before
	public void setUp() {
		test = new Kontrakt();
	}
	
	@Test
	public void CyfrokradWorksProperly() {
		assertThat(test.CyfroKrad(37), Matchers.either(is(3)).or(is(7)));
	}
	
	@Test
	public void CyfrokradReturnsValueDifferentFromInput() {
		assertThat(test.CyfroKrad(37), not(37));
	}
	
	@Test
	public void CyfrokradReturnsValueWithLengthLesserThanInput() {
		assertThat(test.CyfroKrad(342).toString().length(), is(2));
	}
	
	@Test
	public void CyfrokradReturnsNullWithOneNumberInput() {
		assertNull(test.CyfroKrad(9));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void CyfrokradExpectedIllegalArgumantExceptionEithNullInput() {
		test.CyfroKrad(null);
        fail("Expected an IllegalArgumentException to be thrown");
	}
	
	@After
	public void tearDown() {
		test = null;
	}

}
