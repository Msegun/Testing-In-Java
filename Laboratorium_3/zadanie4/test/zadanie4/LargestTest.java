package zadanie4;
//zad 4

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
 
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
 
 
@RunWith(Parameterized.class)
public class LargestTest {
 
    private int expected;
    private int[] elements;
   
    public LargestTest(int largestElement, int[] elements){
        this.expected = largestElement;
        this.elements = elements;
    }
 
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] c = {
                {5, new int[]{1, 2, 5}}, 
                {8, new int[]{7, 5, 4, 8, 7}},
                {16, new int[]{12, 16}},
                {42, new int[]{12, 42, 31}},
        };
        return  Arrays.asList(c);
    }
   
    @Test
    public void TestForLargest() {
        assertEquals(expected, Largest.largest(elements));
    }
 
}