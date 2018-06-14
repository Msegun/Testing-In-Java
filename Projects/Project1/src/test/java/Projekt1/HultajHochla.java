package Projekt1;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;

import static org.hamcrest.CoreMatchers.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HultajHochla {
	
	private Kontrakt test;
	
	@Before
	public void setUp() {
		test = new Kontrakt();
	}
	
	@Test
	public void HultajHochla_Working_Properly() throws NieudanyPsikusException {
		int expected = 73;
		assertThat(test.HultajChochla(37), is(expected));
	}
	
	//With AssertJ
	@Test
	public void HultajHochla_Working_Properly_Bigger_Numbers_Assert_J() throws NieudanyPsikusException {
		assertThat(test.HultajChochla(123)).isNotNull().isIn(132, 213, 321);
	}
	
	//With AssertJ
	@Test
	public void HultajHochla_Working_Properly_Negative_Bigger_Numbers_Assert_J() throws NieudanyPsikusException {
		assertThat(test.HultajChochla(-123)).isNotNull().isIn(-132, -213, -321);
	}
	
	// With Hamcrest
	@Test
	public void HultajHochla_Working_Properly_Bigger_Numbers() throws NieudanyPsikusException {
		//For 1234 we should recieve 1243 or 1432 or 4231 or 1324 or 3214 or 2134
		assertThat(test.HultajChochla(1234), anyOf(
					is(1243), is(1432),
					is(4231), is(1324),
					is(3214),
					is(2134)));
	}
	
	@Test(expected = NieudanyPsikusException.class)
	public void HultajHochla_Expect_NPException_For_One_Number() throws NieudanyPsikusException {
		test.HultajChochla(5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void HultajHochla_Expect_IAException_For_Null_Input() throws NieudanyPsikusException {
		test.HultajChochla(null);
	}
	
	
	
	@After
	public void tearDown() {
		test = null;
	}

}
