package zadanie3Beta;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class StringOperationsTest {

	private StringOperations s;
	
	@Before
	public void SetUp(){
		s = new StringOperations();
	}
	
	//Reversions
	@Test
	public void ReverseTest() {
		assertThat(s.reverse("Bob"), is("boB"));
	}
	
	@Test(expected = NullPointerException.class)
	public void Reverse_With_Null_Expected_Poiner_Test() {
		assertThat(s.reverse(null), is(null));
	}
	
	@Test(expected = NullPointerException.class)
	public void Reverse_With_EmptyS_Expected_Poiner_Test() {
		assertThat(s.reverse(""), is(null));
	}
	
	
	//Concatenations
	@Test
	public void Concat_With_Empty_FirstS_Test() {
		assertThat(s.concat("", "string"), is("string"));
	}
	
	@Test
	public void Concat_With_Empty_SecondS_Test() {
		assertThat(s.concat("string", ""), is("string"));
	}
	
	@Test(expected = NullPointerException.class)
	public void Concat_With_Null_FirstS_Expected_Poiner_Test() {
		assertThat(s.concat(null, "string"), is(null));
	}

	@Test(expected = NullPointerException.class)
	public void Concat_With_Null_SecondS_Expected_Poiner_Test() {
		assertThat(s.concat("a", null), is(null));
	}
	
	@Test
	public void Concat_With_Valid_Strings_Test() {
		assertThat(s.concat("a", "b"), containsString("a" + "b"));
	}
	
	@Test
	public void Concat_With_Valid_longer_Strings_Test() {
		assertThat(s.concat("b", "aab"), containsString("ba"+"ab"));
	}
	
	@Test
	public void Concat_With_Valid_longer_Strings2_Test() {
		assertThat(s.concat("baa", "b"), is("baab"));
	}
	
	@Test
	public void IsPalindrome_Letter_Test() {
		assertThat(s.isPalindrome("a"), is(true));
	}
	
	@Test
	public void IsPalindrome_Empty_Test() {
		assertThat(s.isPalindrome(""), is(true));
	}
	
	@Test(expected = NullPointerException.class)
	public void IsPalindrome_Null_Test() {
		assertThat(s.isPalindrome(null), is(true));
	}
	
	@Test
	public void IsPalindrome_True_Test() {
		assertThat(s.isPalindrome("baab"), is(true));
	}
	
	
	
	@After
	public void tearDown(){
		s = null;
	}
}
