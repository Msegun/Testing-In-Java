package zadanie4;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class StringOperationsTest {

	private StringOperations s;
	
	@Before
	public void SetUp(){
		s = new StringOperations();
	}
	
	//Reversions
	@Test
	public void ReverseTest() {
		assertThat(s.reverse("Bob")).isEqualTo("boB");
	}
	
	@Test(expected = NullPointerException.class)
	public void Reverse_With_Null_Expected_Poiner_Test() {
		assertThat(s.reverse(null)).isEqualTo(null);
	}
	
	@Test(expected = NullPointerException.class)
	public void Reverse_With_EmptyS_Expected_Poiner_Test() {
		assertThat(s.reverse("")).isEqualTo(null);
	}
	
	
	//Concatenations
	@Test
	public void Concat_With_Empty_FirstS_Test() {
		assertThat(s.concat("", "string")).isEqualTo("string");
	}
	
	@Test
	public void Concat_With_Empty_SecondS_Test() {
		assertThat(s.concat("string", "")).isEqualTo("string");
	}
	
	@Test(expected = NullPointerException.class)
	public void Concat_With_Null_FirstS_Expected_Poiner_Test() {
		assertThat(s.concat(null, "string")).isEqualTo(null);
	}

	@Test(expected = NullPointerException.class)
	public void Concat_With_Null_SecondS_Expected_Poiner_Test() {
		assertThat(s.concat("a", null)).isEqualTo(null);
	}
	
	@Test
	public void Concat_With_Valid_Strings_Test() {
		assertThat(s.concat("a", "b")).startsWith("a").endsWith("b");
	}
	
	@Test
	public void Concat_With_Valid_longer_Strings_Test() {
		assertThat(s.concat("b", "aab")).startsWith("b").endsWith("aab");
	}
	
	@Test
	public void Concat_With_Valid_longer_Strings2_Test() {
		assertThat(s.concat("baa", "b")).isEqualTo("baab");
	}
	
	@Test
	public void IsPalindrome_Letter_Test() {
		assertThat(s.isPalindrome("a")).isEqualTo(true);
	}
	
	@Test
	public void IsPalindrome_Empty_Test() {
		assertThat(s.isPalindrome("")).isEqualTo(true);
	}
	
	@Test(expected = NullPointerException.class)
	public void IsPalindrome_Null_Test() {
		assertThat(s.isPalindrome(null)).isEqualTo(true);
	}
	
	@Test
	public void IsPalindrome_True_Test() {
		assertThat(s.isPalindrome("baab")).isEqualTo(true);
	}
	
	@After
	public void tearDown(){
		s = null;
	}
}
