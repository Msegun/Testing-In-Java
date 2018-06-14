package pageObjectDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageFactoryGoogleLoginPage {
	  
	private final Wait<WebDriver> wait;
	public WebDriver driver;
	
	@FindBy(id = "login_username")
	private WebElement login;
	
	@FindBy(id = "secretkey")
	private WebElement pass;
	
	@FindBy(id = "smsubmit")
	private WebElement submitButton;
	
	@FindBy(id = "fs1")
	private WebElement sigmaPocztapage;
	
	public PageFactoryGoogleLoginPage(WebDriver driver){
		  this.driver = driver;
		  driver.get("https://inf.ug.edu.pl/poczta");
		  wait = new WebDriverWait(driver,10);
	}
	
	public void LogIn(String text, String password) throws Exception{
		login.sendKeys(text);
		pass.sendKeys(password);
		submitButton.submit();
		wait.until(ExpectedConditions.titleContains(".ug.edu.pl"));
	}
	
	public boolean assertTitle() throws Exception{
		Boolean result = driver.getTitle().contains(".ug.edu.pl");
		System.out.println(driver.getTitle());
		return(result);
	}
}
