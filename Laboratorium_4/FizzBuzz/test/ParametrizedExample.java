import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.runner.RunWith;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;

@RunWith(JUnitParamsRunner.class)
public class ParametrizedExample {

	private FizzBuzz sut;
	
	@Before
	public void setUp() {
		sut = new FizzBuzz();
	}
	
	@Test
	@Parameters(value = {"15", "30", "150"})
	public void paramsExampleTest(int p) throws Exception {
		assertThat(sut.play(p), is("Fizz"));
	}
	
	@After
	public void teardown() {
		sut = null;
	}

}
