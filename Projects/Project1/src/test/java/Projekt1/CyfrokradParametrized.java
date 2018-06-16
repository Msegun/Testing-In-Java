package Projekt1;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.hamcrest.Matchers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CyfrokradParametrized {

	private Kontrakt test;
	private Integer value;
	
	@Before
	public void setUp() {
		test = new Kontrakt();
	}
	
	@Parameters
    public static Collection<Object[]> dane() {
        return Arrays.asList(new Object[][] {     
        		{ 32 }, { 301 }, { -1234 }, { 12345678 }, { 2137 }  
           });
    }
    
    public CyfrokradParametrized (Integer value) {
        this.value = value;
	}
    
    @Test
	public void CyfroKradReturnsValueDifferentFromInput() {
		assertThat(test.CyfroKrad(value), not(value));
    }
	
	@After
	public void tearDown() {
		test = null;
	}

}
