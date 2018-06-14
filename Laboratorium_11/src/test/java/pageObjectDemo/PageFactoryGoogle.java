package pageObjectDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFactoryGoogle {
  
  //Nie uzywamy FindByElement !!!
  private final Wait<WebDriver> wait;
  private WebElement q;
  public WebDriver driver;
  
  public PageFactoryGoogle(WebDriver driver){
	  this.driver = driver;
	  driver.get("http://www.google.com/");
	  wait = new WebDriverWait(driver,10);
  }
  
  public void search(String text) throws Exception{
	  q.sendKeys(text);
	  q.submit();
	  wait.until(ExpectedConditions.titleContains(text));
  }
  
  public boolean assertTitle() throws Exception{
		Boolean result = driver.getTitle().contains("Mateusz Miotk");
		System.out.println(driver.getTitle());
		return(result);
	}
  
  
}
