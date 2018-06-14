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
	public void CzyCyfrokrad_works_properly() {
		assertThat(test.CyfroKrad(37), Matchers.either(is(3)).or(is(7)));
	}
	
	@Test
	public void CzyCyfrokrad_different_from_input() {
		assertThat(test.CyfroKrad(37), not(37));
	}
	
	@Test
	public void CzyCyfrokrad_one_less_length_than_input() {
		assertThat(test.CyfroKrad(342).toString().length(), is(2));
	}
	
	@Test
	public void Cyfrokrad_is_Null_with_OneNumber_Input() {
		assertNull(test.CyfroKrad(9));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void Cyfrokrad_expected_IllegalArgumantException_with_null_Input() {
		test.CyfroKrad(null);
        fail("Expected an IllegalArgumentException to be thrown");
	}
	
	@After
	public void tearDown() {
		test = null;
	}

}
