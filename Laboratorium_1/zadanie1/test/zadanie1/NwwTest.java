package zadanie1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NwwTest {
	private Nww test;
	
	@Before 
	public void setup() {
		test = new Nww();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void CheckBothZero() {
		assertEquals(null, test.nww(0, 0));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void CheckOneLesserThanZero(){
		assertEquals(null, test.nww(-3, 5));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void CheckTwoLesserThanZero(){
		assertEquals(null, test.nwd(3, -5));
	}
	
	@Test
	public void CheckBothProperValues() {
		assertEquals(72, test.nww(24, 36));
	}
	
	@After
	public void teardown(){
		test = null;
	}

}
