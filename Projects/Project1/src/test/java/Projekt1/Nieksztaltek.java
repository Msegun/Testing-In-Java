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
	
	@Test
	public void Nieksztaltek_Should_Return_Value_Without_Changes() {
		assertThat(test.Nieksztaltek(924), is(924));
	}
	
	@Test
	public void Nieksztaltek_Should_Return_Different_Value() {
		assertNotSame(test.Nieksztaltek(435), 435);
	}
	
	@Test
	public void Nieksztaltek_Should_Non_Null_Different_Value() {
		assertNotSame(test.Nieksztaltek(435), null);
	}
	
	@Test
	public void Nieksztaltek_Should_Change_Number_Three_to_Eight() {
		assertThat(test.Nieksztaltek(435), is(485));
	}
	
	@Test
	public void Nieksztaltek_Should_Change_Number_Seven_to_One() {
		assertThat(test.Nieksztaltek(427), is(421));
	}
	
	@Test
	public void Nieksztaltek_Should_Change_Number_Six_to_Nine() {
		assertThat(test.Nieksztaltek(625), is(925));
	}
	
	@Test
	public void Nieksztaltek_Should_Change_one_Number() {
		assertThat(test.Nieksztaltek(627), Matchers.either(is(927)).or(is(621)));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void Nieksztaltek_Should_Throw_Exection_with_null_Input() {
		test.Nieksztaltek(null);
	}
	
	@Test
	public void NumberChanger_Test_with_Three() {
		assertEquals('8', test.NumberChanger('3'));
	}
	
	@Test
	public void NumberChanger_Test_with_Seven() {
		assertEquals('1', test.NumberChanger('7'));
	}
	
	@Test
	public void NumberChanger_Test_with_Six() {
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
