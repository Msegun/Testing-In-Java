package zadanie3;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import org.junit.Test;

public class ExceptionsTestFile {

	static BufferedReader rdr;
	String line;
	double epsilon = 0.1;
	
	private QuadraticFunction q;

	@Test
	public void checkZeros() {
		q = QuadraticFunction.of(0, 0, 0);
		assertEquals(Double.NaN, q.getX1(), epsilon);
	}

	@Test(expected = IllegalArgumentException.class)
	public void checkDeltaNegative() {
		q = QuadraticFunction.of(1, -3, 7);
		assertEquals(0, q.getX1(), epsilon);
	}

	@Test
	public void checkTest() {
		q = QuadraticFunction.of(0.0, 0.0, 2.0);
		assertEquals(Double.NEGATIVE_INFINITY, q.getX1(), epsilon);
	}
}
