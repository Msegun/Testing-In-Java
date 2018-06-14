package MainPackage.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;

import ClaculatorSrc.Calculator;
public class MySteps {
	
	private Calculator test;
	private double result;
	private boolean Boolresult;
	
	// Zakładam ze chodziło o coś takiego bo w faktcznie w junit mamy cos takiego jak fail() ale nie mamy success()/pass()
	@AfterScenario
	public void fail() {
		if(result == 0)
			System.out.print("Cos chyba poszło nie tak\n");
	}
	
	@AfterScenario
	public void success() {
		if(result != 0)
			System.out.print("Pykło\n");
	}
	
	@Given("Mam utworzony nowy kalkulator")
	public void givenMamUtworzonyKolejnyNowyKalkulator(){
		 test = new Calculator();
	}
	@When("dodam liczby 5i5")
	public void whenDodamLiczby5I5(){
		result= test.add(5, 5);
	}
	@Then("po dodaniu dostane 10")
	public void thenPoDodaniuDostane10(){
		assertEquals(10, result);
	}
	
	@Given("Mam utworzony kolejny kalkulator")
	public void givenMamUtworzonyKolejnyKalkulator(){
		 test = new Calculator();
	}
	@When("Odejmuje liczby 5i5")
	public void whenOdejemeLiczby5I5(){
		result = test.sub(5, 5);
	}
	@Then("po dodaniu dostane 0")
	public void thenPoDodaniuDostane0(){
		assertEquals(0, result);
	}
	
	@When("mnoze liczby 5i5")
	public void whenMnozeLiczby5I5(){
		result = test.multi(5, 5);
	}
	
	@Then("po mnozeniu dostane 25")
	public void thenPoMnozeniyDostane25(){
		assertEquals(25, result);
	}
	
	@When("dziele liczby 1i10")
	public void whenDzieleLiczby1I10(){
		result = test.div(1, 10);
	}
	@Then("po dzieleniu dostane 0.1")
	public void thenPoDzieleniuDostane01(){
		assertEquals(0.1, result);
	}
	
	@When("Sprawdzam wiekszy 1i10")
	public void Wiekszy1i10(){
		Boolresult = test.greater(1, 10);
	}
	@Then("po greater dostane false")
	public void thenPoGreaterFalse(){
		assertEquals(false, Boolresult);
	}
	
	@Then("po greater dostane true")
	public void thenPoGreaterTrue(){
		assertEquals(true, Boolresult);
	}
	
	@When("mnoze liczby <value1> i <value2>")
	public void whenMnozeLiczbyvalue1Ivalue2(@Named("value1") double val1, @Named("value2") double val2) {
		  result = test.multi(val1, val2);
	}
	
	@Then("po mnozeniu dostane <resultValue>")
	public void thenPoMnozeniuDostaneresultValue(@Named("resultValue") double resultValue) {
		  assertEquals(resultValue, result);
	}

	
}
