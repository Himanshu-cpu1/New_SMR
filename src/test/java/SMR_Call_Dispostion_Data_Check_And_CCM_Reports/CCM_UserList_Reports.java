package SMR_Call_Dispostion_Data_Check_And_CCM_Reports;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class CCM_UserList_Reports extends LOgin_CCM{
	public static WebDriver driver;
    public WebDriverWait wait;
    
    @SuppressWarnings("static-access")
    @BeforeClass
    public void ccm_Reports() throws InterruptedException {
        // Initialize the driver (assuming it's static in the SMR_due_Datewise class)
        this.driver = LOgin_CCM.driver;

     // Initialize WebDriverWait with a timeout of 10 seconds using Duration
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
	//.....................................................................................................
 
  		@Test(priority = 5)
  		public void Click_On_SMR() throws InterruptedException {
  				  			
  			 //close the pop up message first
  			 WebElement PopUp= driver.findElement(By.xpath("(//*[@title=\"Close message\"])"));
  			 PopUp.click();
  		    Thread.sleep(1000);
  			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	        WebElement SMR = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),\"SERVICE MARKETING REMINDER (SMR)\")]")));
	      
	        SMR.click();
  			 // Wait until the page or the expected content is fully loaded after clicking (adjust the condition as needed)
  		    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));
  		}
  	// .....................................................................................................

  	@Test(priority = 7)
  	public void Click_Reports() throws InterruptedException {
  					  		
  		WebElement Reports = wait
  			    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Reports \"]")));
  			// Call the JavaScript Executor method instead of directly clicking
  			clickElementUsingJS(driver, Reports);
            Thread.sleep(1000);
  	}
  	
 // ..............................................................................................................
 	@Test(priority = 9)
 	 public void Click_On_USER_LIST_REPORT() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement UserList = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"User List \"]")));
        clickElementUsingJS(driver, UserList);
  		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));
 		
 	}
	//.............................................................................................................   
    @Test(priority = 10)
    public void Data_Verification_User_List() throws InterruptedException {
        // Verify if the report contains data
        List<WebElement> reportRows = driver.findElements(By.xpath("(//*[@role=\"rowgroup\"][2]//tr)"));

        // Check if the report contains data
        if (reportRows.size() > 1) {
            System.out.println("The UserList report contains data."); // Message when data is present
        }

        // Assert to fail the method if data is not present
        Assert.assertTrue(reportRows.size() > 1, "The UserList report does not contain any data.");
        Thread.sleep(3000);
    }

    //.....................................................................................................

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser and end the WebDriver session
        }
    }
 //.....................Helper Method...........................................................................
	
  	private void clickElementUsingJS(WebDriver driver, WebElement element) {
  	    JavascriptExecutor js = (JavascriptExecutor) driver;
  	    js.executeScript("arguments[0].click();", element);
  	}
}
