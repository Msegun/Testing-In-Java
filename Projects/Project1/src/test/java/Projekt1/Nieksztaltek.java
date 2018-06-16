package Projekt1;

import static org.junit.Assert.*;

import org.hamcrest.Matchers;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.is;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Nieksztaltek {
	
	private Kontrakt test;
	
	@Before
	public void setUp() {
		test = new Kontrakt();
	}
	// When Input For Nieksztaltek Contains 3, 7 or 6 it changes 
	@Test
	public void NieksztaltekReturnsValueWithoutChanges() {
		assertThat(test.Nieksztaltek(924), is(924));
	}
	
	@Test
	public void NieksztaltekReturnsDifferentValue() {
		assertNotSame(test.Nieksztaltek(435), 435);
	}
	
	@Test
	public void NieksztaltekReturnsNotNullValue() {
		assertNotSame(test.Nieksztaltek(435), null);
	}
	
	// 3 -> 8
	@Test
	public void NieksztaltekChangesTheNumberThreeToEight() {
		assertThat(test.Nieksztaltek(435), is(485));
	}
	
	// 7 -> 1
	@Test
	public void NieksztaltekChangesTheNumberSevenToOne() {
		assertThat(test.Nieksztaltek(427), is(421));
	}
	
	// 6 -> 9
	@Test
	public void NieksztaltekChangesTheNumberSixToNine() {
		assertThat(test.Nieksztaltek(625), is(925));
	}
	
	// 7 -> 1 Or 6 -> 9
	@Test
	public void NieksztaltekChangesOnlyOneNumber() {
		assertThat(test.Nieksztaltek(627), Matchers.either(is(927)).or(is(621)));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void NieksztaltekThrowsIllegalArgumentExectionWithNullInput() {
		test.Nieksztaltek(null);
	}
	
	@Test
	public void NumberChangerTestWithThree() {
		assertEquals('8', test.NumberChanger('3'));
	}
	
	@Test
	public void NumberChangerTestWithSeven() {
		assertEquals('1', test.NumberChanger('7'));
	}
	
	@Test
	public void NumberChangerTestWithSix() {
		assertEquals('9', test.NumberChanger('6'));
	}
	
	@Test
	public void NumberChanger_Test_with_OtherValue() {
		assertEquals('9', test.NumberChanger('9'));
	}
	
	
	
	
	@After
	public void tearDown() {
		test = null;
	}

}
