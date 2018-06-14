package Projekt1;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NieudanyPsikusException
    {
    	Kontrakt k = new Kontrakt();
        System.out.println( "Cyfrokrad Main Test: " + k.CyfroKrad(123) );
        System.out.println( "HultajHochla Main Test: " + k.HultajChochla(-123) );
    }
}
