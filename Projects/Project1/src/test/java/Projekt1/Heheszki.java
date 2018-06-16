package Projekt1;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Heheszki {
	
	private Kontrakt test;
	
	@Before
	public void setUp() {
		test = new Kontrakt();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void HeheszkiThrowsExceptionWhenInputIsLesserThanZero() {
		test.Heheszki(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void HeheszkiThrowsExceptionWhenInputIsNull() {
		test.Heheszki(null);
	}
	
	@Test
	public void HeheszkiReturnsValueDifferentFromInput() {
		assertThat(test.Heheszki(1), not(1));
	}
	
	@Test
	public void HeheszkiReturnsZeroWhenInputIsOne() {
		assertThat(test.Heheszki(1), is(0));
	}
	
	@Test
	public void HeheszkiRetunsValueLesserThanInput() {
		assertTrue(test.Heheszki(12) < 12);
	}
	
	@Test
	public void HeheszkiReturnsValueGreaterEqualThanZero() {
		assertTrue(test.Heheszki(12) >= 0);
	}
	
	@Test
	public void HeheszkiReturnsZeroWhenInputIsZero() {
		assertTrue(test.Heheszki(0) == 0);
	}
	
	@After
	public void tearDown() {
		test = null;
	}

}
