import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class NestedTestExample {

	private FizzBuzz sut;
	
	@BeforeEach
	public void setUp() {
		sut = new FizzBuzz();
	}
	
	@Test
	public void test() {
		assertEquals("Fizz", sut.play(15));
	}
	
	@AfterEach
	public void teardown() {
		sut = null;
	}
	
	@Nested
	@DisplayName("Nested class test")
	class ParametrizedExample {
		
		@ParameterizedTest
		@ValueSource(ints = {15,30,150})
		public void testWithParameters(int p) throws Exception{
			assertEquals("Fizz", sut.play(p));
		}
	}

}
