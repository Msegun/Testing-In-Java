package zadanie3;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import org.junit.Before;
import org.junit.Test;

public class QuadraticFunctionFileTest {

		
	static BufferedReader rdr;
	String line;
	double epsilon = 1E-10;
	
	private QuadraticFunction q;
	private double a;
	private double b;
	private double c;

	private double x1;
	private double x2;
	
	@Before
	public void Setup() throws IOException{
		
		rdr = new BufferedReader(new FileReader("test/test1.txt"));
		
	}
	
	@Test
	public void CheckTestX1() throws IOException{
		while ((line = rdr.readLine()) != null) {
			if (CheckLineForInput(line)) {
				continue;
			}
			
			StringTokenizer st = new StringTokenizer(line);
			
			a = Double.valueOf(st.nextToken());
			b = Double.valueOf(st.nextToken());
			c = Double.valueOf(st.nextToken());
			x1 = Double.valueOf(st.nextToken());
			x2 = Double.valueOf(st.nextToken());
			
			q = QuadraticFunction.of(a, b, c);
			
			assertEquals(x1, q.getX1(), epsilon);
		}
	}
	
	@Test
	public void CheckTestX2() throws IOException{
		while ((line = rdr.readLine()) != null) {
			if (CheckLineForInput(line)) {
				continue;
			}
			
			StringTokenizer st = new StringTokenizer(line);
			
			a = Double.valueOf(st.nextToken());
			b = Double.valueOf(st.nextToken());
			c = Double.valueOf(st.nextToken());
			x1 = Double.valueOf(st.nextToken());
			x2 = Double.valueOf(st.nextToken());
			
			q = QuadraticFunction.of(a, b, c);
			
			assertEquals(x2, q.getX2(), epsilon);
		}
	}
	
	private boolean CheckLineForInput(String line){
		if (line.startsWith("#")) {
			return true;
		}
			
		StringTokenizer st = new StringTokenizer(line);
		if (!st.hasMoreTokens() || st.countTokens() != 5) {
			return true;
		}
		return false;
	}

}
