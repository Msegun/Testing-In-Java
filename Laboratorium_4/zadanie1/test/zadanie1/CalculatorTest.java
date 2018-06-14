package zadanie1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;


public class CalculatorTest {
	
	private Calculator calculator;
	private double epsilon = 1E-10;
	
	@Before
	public void setup(){
		calculator = new Calculator();
	}

	@Test
	public void addCheck(){	
		assertThat(calculator.add(3,2), closeTo(5, epsilon));		
	}
	
	@Test
	public void subCheck(){
		assertThat(calculator.sub(3, 2), closeTo(1, epsilon));	
	}
	
	@Test
	public void multiCheck(){
		assertThat(calculator.multi(3, 2), closeTo(6, epsilon));	
	}
	
	@Test
	public void divCheck(){
		assertThat(calculator.div(6, 2), closeTo(3, epsilon));
	}
	
	@Test
	public void divInfinityCheck(){
		assertThat(calculator.div(6, 0), is(Double.POSITIVE_INFINITY));
	}
	
	@Test
	public void divNegInfinityCheck(){
		assertThat(calculator.div(-6, 0), is(Double.NEGATIVE_INFINITY));
	}
	
	
	@Test
	public void greaterTrueCheck(){		
		assertThat(calculator.greater(6, 2), is(true));	
	}
	
	@Test
	public void greaterFalseCheck(){
		assertThat(calculator.greater(1, 2), is(false));	
	}
	
	@Test
	public void greaterEqualCheck(){
		assertThat(calculator.greater(1, 1), is(false));
	}
	
	@Test
	public void lessTrueCheck(){		
		assertThat(calculator.less(1, 2), is(true));	
	}
	
	@Test
	public void lessFalseCheck(){		
		assertThat(calculator.less(3, 2), is(false));	
	}
	
	@Test
	public void lessEqualCheck(){		
		assertThat(calculator.less(2, 2), is(false));	
	}
	
	@Test
	public void EqualityTrueCheck(){		
		assertThat(calculator.equality(2, 2), is(true));	
	}
	
	@Test
	public void EqualityFalseOneCheck(){		
		assertThat(calculator.equality(1, 2), is(false));	
	}
	
	@Test
	public void EqualityFalseTwoCheck(){		
		assertThat(calculator.equality(2, 1), is(false));	
	}


	@After
	public void teardown(){
		calculator = null;
	}
}