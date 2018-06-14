package webdemo.seleniumDemo;

import static org.junit.jupiter.api.Assertions.assertFalse;
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

public class RepositoryTest {
	
	private static WebDriver driver;
    private LoginPageObject GitHubLogin;
    
	@BeforeAll
	public static void driverSetup() {
		System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
		
		driver = new FirefoxDriver();
		//driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void AddANewRepositoryTest() throws InterruptedException {
		GitHubLogin = PageFactory.initElements(driver, LoginPageObject.class);
		String nameOfRepository = "AnewRepository";
		GitHubLogin.MoveAndAddANewRepositoryAfterLoggingIn(nameOfRepository);
		
		assertTrue(driver.getPageSource().contains(nameOfRepository));
	}
	
	@Test
	public void DeleteAddedRepositoryTest() throws InterruptedException {
		GitHubLogin = new LoginPageObject(driver);
		String nameOfRepository = "AnewRepository";
		GitHubLogin.DeleteAddedRepository(nameOfRepository);
		
		assertFalse(driver.getPageSource().contains(nameOfRepository));
	}
	
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}
}
