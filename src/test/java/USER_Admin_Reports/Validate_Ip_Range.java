package USER_Admin_Reports;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Validate_Ip_Range   {
	
	
	public static WebDriver driver;
	public WebDriverWait wait;
	 //........................................................................
	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://dealercrm.co.in/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(16, TimeUnit.SECONDS);

	}
	 //........................................................................
    @Test(priority = 5)
    public void Validate_Ip_Restriction() throws InterruptedException {
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10)); 	        
        // Attempt to log in with test credentials
        WebElement Username = wait1
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id=\"mat-input-0\"]")));        
		WebElement password = wait1
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id=\"mat-input-1\"]")));
		WebElement login_Button = wait1
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[type=\"submit\"]")));
	     Thread.sleep(400);		
		Username.sendKeys("081001cce00001"); // Replace with test username
		password.sendKeys("Maruti@123"); // Replace with test password
		login_Button.click();
      
		// to fill the captcha   
		WebElement Image = wait1
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@type=\"text\"])[1]")));
		String S1 = Image.getAttribute("value");
		System.out.println("captcha ::" + S1);
		
		WebElement captcha = wait1
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[placeholder=\"Enter the captcha..\"]")));
		captcha.sendKeys(S1);
		
		WebElement Submit = wait1
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Submit\"]")));
		Submit.click();
		
        // Check for restriction message or failed login
        WebElement restrictionMessage = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"You are Not Login From Valid IP Range \"]"))); // Replace with actual error message locator

     // Assert that the restriction message is displayed
        if (restrictionMessage.isDisplayed()) {
            System.out.println("PASS: The IP restriction message is displayed.");
        } else {
            Assert.fail("FAIL: The IP restriction is not enforced properly.");
        }

      
    }
    
    //.....................................................................................................

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser and end the WebDriver session
        }
    }
}
