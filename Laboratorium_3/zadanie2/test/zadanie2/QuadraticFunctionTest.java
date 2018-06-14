package zadanie2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QuadraticFunctionTest {

	private QuadraticFunction q;
	private QuadraticFunction wrong;
	private QuadraticFunction zero;
	double epsilon = 1E-10;
	
	@Before
	public void Setup(){
		q = QuadraticFunction.of(1.0, 4.0, 3.0);
		zero = QuadraticFunction.of(1.0, -8.0, 16.0);
	}
	
	@Test
	public void ReturnATest() {
		assertEquals(1.0, q.getA(), epsilon);
	}
	
	@Test
	public void ReturnBTest() {
		assertEquals(4.0, q.getB(), epsilon);
	}
	
	@Test
	public void ReturnCTest() {
		assertEquals(3.0, q.getC(), epsilon);
	}
	
	
	@Test
	public void Getx1FromQTest(){
		assertEquals(-3.0, q.getX1(), epsilon);
	}
	
	@Test
	public void Getx2FromQTest(){
		assertEquals(-1.0, q.getX2(), epsilon);
	}
	
	@Test
	public void Getx1FromZeroTest(){
		assertEquals(4.0, zero.getX1(), epsilon);
	}
	
	@Test
	public void Getx1WhenAisZero(){
		assertEquals(2.5, QuadraticFunction.of(0.0, -4.0, 10.0).getX1(), epsilon);
	}
	
	@Test
	public void Getx1WhenBothAAndBisZero(){
		assertEquals(Double.NEGATIVE_INFINITY, QuadraticFunction.of(0.0, 0.0, 2.0).getX1(), epsilon);
	}
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void Getx1WhenBisZero(){
		assertEquals(0.0, QuadraticFunction.of(1.0, 0.0, 10.0).getX1(), epsilon);
	}
	
	@Test()
	public void Getx1WhenABCisZero(){
		assertEquals(Double.NaN, QuadraticFunction.of(0.0, 0.0, 0.0).getX1(), epsilon);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void returnNull(){
		assertEquals(null, QuadraticFunction.of(1.0, -4.0, 10.0));
	}
	
	
	
	
	
}
