

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SquareArrayTest {
	
	private SquareArray array; 

	@Before
	public void setUp() throws Exception {
		array = new SquareArray();
	}
	
	@Test
	public void getArray(){
		array.setList(Arrays.asList(1,2,3));
		List <Integer> tempList = array.getList();
		assertThat(tempList,contains(1,2,3));
	}

	@After
	public void tearDown() throws Exception {
		array = null;
	}
	
}
