package pageObjectDemo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class PageFactoryLoginTest {

    private static WebDriver driver;
		
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
		driver = new FirefoxDriver();
	}
	
	@Test
	public void test() throws Exception {
		PageFactoryGoogleLoginPage googlePage = PageFactory.initElements(driver, PageFactoryGoogleLoginPage.class);
		googlePage.LogIn("kborawski@sigma.ug.edu.pl", "");
		assertTrue(googlePage.assertTitle());
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
		driver.quit();
	}
}


