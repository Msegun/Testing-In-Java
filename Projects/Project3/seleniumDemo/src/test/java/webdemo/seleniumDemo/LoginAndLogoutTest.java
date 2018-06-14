package webdemo.seleniumDemo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginAndLogoutTest {

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
	public void loginWrong() throws InterruptedException {
		GitHubLogin = PageFactory.initElements(driver, LoginPageObject.class);
	    GitHubLogin.BadAccount();
	    assertTrue(GitHubLogin.getErrorMessage().contains("Incorrect username or password"));
	}
	
	@Test
    public void loginFromAndLogoutFromGithub() throws InterruptedException {
		GitHubLogin = PageFactory.initElements(driver, LoginPageObject.class);
        GitHubLogin.loginToExistingAccount();
        assertTrue(GitHubLogin.getLoggedInUrl().endsWith("github.com/"));
        
        //Adding Logout below so that i'm sure that ill log out every time
        GitHubLogin.logoutFromExistingAccount();
	}
	
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}
}
