package zadanie5;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class PersonTest {

	//https://github.com/Pragmatists/junitparams/wiki/Quickstart
	//http://www.baeldung.com/junit-params
	@Test
	@Parameters(method = "adultValues")
	public void personIsAdult(int age, boolean valid) throws Exception {
	    assertEquals(valid, new Person(age).isAdult());
	}

	private Object[] adultValues() {
	    return new Object[]{
	                 new Object[]{13, false},
	                 new Object[]{17, false},
	                 new Object[]{18, true},
	                 new Object[]{22, true}
	            };
	}
	
	@Test
	@FileParameters("parameters.csv")
	public void personIsAdultFromFile(int age, boolean valid) throws Exception {
		 assertEquals(valid, new Person(age).isAdult());
	}

}