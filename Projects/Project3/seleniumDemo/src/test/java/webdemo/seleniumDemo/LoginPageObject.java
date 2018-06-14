package webdemo.seleniumDemo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject {
	
    public WebDriver driver;
    private WebDriverWait wait;
    
    // Selector that i use for certain situations (for example in methods that require logging in)
	@FindBy(linkText = "Sign in")
	private WebElement Sign_In;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
        driver.get("https://github.com/");
        wait = new WebDriverWait(driver, 10);
    }

    public void loginToExistingAccount() throws InterruptedException {
    	Sign_In.click();
        driver.findElement(By.id("login_field")).sendKeys("FakeSeleniumAcount");
        driver.findElement(By.name("password")).sendKeys("password1");
        driver.findElement(By.name("commit")).click();
        wait.until(ExpectedConditions.urlMatches("https://github.com/"));
    }
    
    public void logoutFromExistingAccount() throws InterruptedException {
    	driver.get("https://github.com/logout");
    	driver.findElement(By.tagName("form")).submit();
    	Thread.sleep(1000);
    }
    
    public void BadAccount() throws InterruptedException {
    	Sign_In.click();
        driver.findElement(By.id("login_field")).sendKeys("This account Does Not Exist");
        driver.findElement(By.name("password")).sendKeys("some wrong password");
        driver.findElement(By.name("commit")).click();
        wait.until(ExpectedConditions.urlContains("https://github.com/session"));
    }
    
    public void SearchForPhrase(String phrase) throws InterruptedException {    	
    	//We're searching for element of name "q" because it's the name of search bar in github
    	driver.get("https://github.com/search");
    	driver.findElement(By.name("q")).sendKeys(phrase);
    	driver.findElement(By.id("search_form")).submit();
    	wait.until(ExpectedConditions.urlContains("https://github.com/search?"));
    }
    
    public void MoveAndAddANewRepositoryAfterLoggingIn(String name) throws InterruptedException {
    	loginToExistingAccount();
    	
    	driver.get("https://github.com/FakeSeleniumAcount?tab=repositories");
    	driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div[2]/div[3]/div[1]/form/div[2]/a")).click();
    	wait.until(ExpectedConditions.urlContains("https://github.com/new"));
    	
    	driver.findElement(By.id("repository_name")).sendKeys(name);
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/form/div[3]/button")).click(); 
    	//driver.get("https://github.com/FakeSeleniumAcount?tab=repositories");
    }
    
    public void DeleteAddedRepository(String name) throws InterruptedException {
    	// I dont like using xpath sometimes but i believe this time i have no choice 
    	driver.get("https://github.com/FakeSeleniumAcount/AnewRepository");
    	// Settings
    	driver.findElement(By.xpath("/html/body/div[4]/div/div/div[1]/nav/a[4]")).click();
    	// Delete button
    	driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div[1]/div/div[2]/div/div[10]/ul/li[4]/button")).click();
    	// Send Keys to opened window
    	driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div[1]/div/div[2]/div/div[10]/ul/li[4]/div/div/div/div/div[2]/form/p/input")).sendKeys(name);
    	Thread.sleep(1000);
    	driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/div[1]/div/div[2]/div/div[10]/ul/li[4]/div/div/div/div/div[2]/form/button")).click();
    	wait.until(ExpectedConditions.urlContains("https://github.com/"));
    	
    	driver.get("https://github.com/FakeSeleniumAcount?tab=repositories");
    }
    

    public String getLoggedInUrl(){
        return driver.getCurrentUrl();
    }
    
    public String getErrorMessage(){
        return driver.findElement(By.xpath("/html/body[@class='logged-out env-production page-responsive min-width-0 session-authentication']/div[@class='application-main ']/div[@id='js-pjax-container']/div[@id='login']/form/div[@id='js-flash-container']/div[@class='flash flash-full flash-error']/div[@class='container']")).getText();
    }
}