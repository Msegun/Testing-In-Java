package zadanie2;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	Calculator test;
	static double epsilon = 1E-10;
	
	@Before
	public void setup() {
		test = new Calculator();
	}
	
	@Test
	public void addCheck(){
		assertEquals(5, test.add(3, 2), epsilon);		
	}
	
	@Test
	public void subCheck(){
		assertEquals(1, test.sub(3, 2), epsilon);	
	}
	
	@Test
	public void multiCheck(){
		assertEquals(6, test.multi(3, 2), epsilon);	
	}
	
	@Test(expected = ArithmeticException.class)
	public void divby0Check(){
		test.div(3, 0);
	}
	
	@Test
	public void divCheck(){
		assertEquals(1, test.div(2, 2), epsilon);
	}
	
	@Test
	public void greaterTrueCheck(){
		assertEquals(true, test.greater(6, 2));	
	}
	
	@Test
	public void greaterFalseCheck(){	
		assertEquals(false, test.greater(1, 1));
	}
	
	@Test
	public void LesserFalseCheck(){	
		assertEquals(false, test.less(1, 1));
	}
	
	@Test
	public void LesserTrueCheck(){	
		assertEquals(true, test.less(1, 3));
	}
	
	@Test
	public void EqualsTrueCheck(){	
		assertEquals(true, test.equality(3, 3));
	}
	
	@Test
	public void EqualsFalseCheck(){	
		assertEquals(false, test.equality(1, 3));
	}


}
