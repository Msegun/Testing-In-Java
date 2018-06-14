package webdemo.seleniumDemo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleTest {
	
	private static WebDriver driver;
	@BeforeAll
	public static void setUp() throws Exception {
		//Od wersji selenium 3.0 samo FirefoxDriver nie wystarcza
		//Należy dodać sterownik geckodriver
		//Do pobrania tutaj: https://github.com/mozilla/geckodriver/releases
		System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
		driver = new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void testTitlePage() {
		driver.get("https://duckduckgo.com/");
    	assertEquals("DuckDuckGo — Privacy, simplified.", driver.getTitle());
	}
	
	@Test
	public void testClick(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.findElement(By.id("search_form_input_homepage")).sendKeys("Mateusz Miotk");
		driver.findElement(By.id("search_button_homepage")).click();
		wait.until(ExpectedConditions.titleIs("Mateusz Miotk at DuckDuckGo"));
		assertEquals("Mateusz Miotk at DuckDuckGo", driver.getTitle());
	}
	
	@Test
	public void GoToJG(){
		driver.get("https://google.com/");
		driver.findElement(By.id("lst-ib")).sendKeys("Jastrzebie gramatyki");
		driver.findElement(By.name("btnK")).click();

		//driver.findElement(By.linkText("Jastrzębie Gramatyki: Strona Główna")).click();
		driver.findElement(By.xpath("(//h3)[1]/a")).click();
		assertEquals("Strona Główna - Jastrzębie Gramatyki", driver.getTitle());
	}
	
	
	@Test
	public void NotFoundIngoogle(){
		driver.get("https://google.com/");
		driver.findElement(By.id("lst-ib")).sendKeys("dafdsfgbasdhgfsdkgjdfs");
		driver.findElement(By.name("btnK")).click();
		boolean found = driver.findElements(By.xpath("(//h3)[1]/a")).size() > 1;
		//driver.findElement(By.linkText("Jastrzębie Gramatyki: Strona Główna")).click();
		assertFalse(found);
	}
	
	
	
	@Test
	public void GoToSignInAndLogin(){
		driver.get("https://inf.ug.edu.pl/sq/src/login.php");
		driver.findElement(By.id("login_username")).sendKeys("kborawski@sigma.ug.edu.pl");
		driver.findElement(By.id("secretkey")).sendKeys("toniemojehaslo");
		driver.findElement(By.id("smsubmit")).click();
		
	}
	
	
	@AfterAll
	public static void tearDown() throws Exception {
		driver.quit();
	}

}
