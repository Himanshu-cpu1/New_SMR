package USER_Admin_Reports;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Allocation_rule_log extends Login_Admin{
	
	public static WebDriver driver;
    public WebDriverWait wait;

    @SuppressWarnings("static-access")
    @BeforeClass
    public void Admin_Reports() throws InterruptedException {
        // Initialize the driver (assuming it's static in the SMR_due_Datewise class)
        this.driver = Login_Admin.driver;

     // Initialize WebDriverWait with a timeout of 10 seconds using Duration
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    //.....................................................................................................

    @Test(priority = 6)
    public void Click_On_Reports() throws InterruptedException {
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Reports = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Reports \"]")));
        clickElementUsingJS(driver, Reports);
       // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));	 		
      
    }
    //.....................................................................................................

    @Test(priority = 7)
    public void Click_On_Allocation_rule_log() throws InterruptedException {
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Allocation_rule_log = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Allocation Rule Log \"]")));
        clickElementUsingJS(driver, Allocation_rule_log);	
        
    }
   //.....................................................................................
    @Test(priority = 8)
    public void Verify_Allocation_rule_log_Data() throws InterruptedException {
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(35));
    	Thread.sleep(400);
	    WebElement clickOnWorkshop_Name = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@class, 'mat-select-arrow')])[2]")));
	    clickOnWorkshop_Name.click();
	    
	    WebElement Select_Narina = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@role=\"option\"])[2]")));
	    Select_Narina.click();
		   
	    verifyReportData();
    }
    //.................................................................................
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();  
        }
    }
  //.....................................................................
  		private void clickElementUsingJS(WebDriver driver, WebElement element) {
  			JavascriptExecutor js = (JavascriptExecutor) driver;
  			js.executeScript("arguments[0].click();", element);
  		}
  		
  	//................................................................................................
			
			private void verifyReportData() {
			    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(35));

			    try {
			        // Wait until at least one element matching the given XPath is present in the DOM
			        wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@colspan=\"9\"]")));

			        // Fetch the list of elements after waiting
			        List<WebElement> reportRows = driver.findElements(By.xpath("//*[@colspan=\"9\"]"));

			        if (reportRows.size() > 1) {
			        	System.out.println(" Allocation Rule Log   contains data.");
		  			} else {
		  				Assert.fail("  Allocation Rule Log  does not contain any data.");
			        }
			    } catch (org.openqa.selenium.TimeoutException e) {
			        // If elements are not found within the specified timeout
			    	Assert.fail("  Allocation Rule Log  does not contain any data.");			    }
			}
}
  

