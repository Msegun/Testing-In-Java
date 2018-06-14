package zadanie1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NwdTest {
	
	private Nwd test;
	
	@Before
	public void setup() {
		test = new Nwd();
	}
	
	@Test
	public void CheckTwoValidExamples() {
		assertEquals(12, test.nwd(24, 36));
	}
	
	@Test
	public void CheckFirstZero(){
		assertEquals(9, test.nwd(0, 9));
	}
	
	@Test
	public void CheckSecondZero() {
		assertEquals(9, test.nwd(9, 0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void CheckBothZero() {
		assertEquals(null, test.nwd(0, 0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void CheckOneLesserThanZero(){
		assertEquals(null, test.nwd(-3, 5));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void CheckTwoLesserThanZero(){
		assertEquals(null, test.nwd(3, -5));
	}
	
	@After
	public void teardown(){
		test = null;
	}

}
