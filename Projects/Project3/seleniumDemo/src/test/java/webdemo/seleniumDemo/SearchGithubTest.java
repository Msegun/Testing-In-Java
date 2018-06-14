package webdemo.seleniumDemo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchGithubTest {
	
	private static WebDriver driver;
    private LoginPageObject GitHubLogin;
    
	@BeforeAll
	public static void driverSetup() {
		System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
		
		//driver = new FirefoxDriver();
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void FindCoolPhraseInSearchBarTest() throws InterruptedException {
		GitHubLogin = PageFactory.initElements(driver, LoginPageObject.class);
	    GitHubLogin.SearchForPhrase("Cool");


	    assertTrue(driver.getPageSource().contains("Cool"));
	}
	
	@Test
	public void SearchFindsNothingTest() throws InterruptedException {
		GitHubLogin = new LoginPageObject(driver);
	    GitHubLogin.SearchForPhrase("fjfdskjafldsjfaksfjdak");
	    assertTrue(driver.getPageSource().contains("We couldn’t find any repositories matching 'fjfdskjafldsjfaksfjdak'"));
	}
	
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}
}
