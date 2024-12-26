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

public class Data_Allocation_Report extends Login_Admin{
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
    public void Click_On_Data_Allocation_Reports() throws InterruptedException {
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Data_Allocation_Reports = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Data Allocation Report \"]")));
        clickElementUsingJS(driver, Data_Allocation_Reports);	
        
    }
   //.....................................................................................
    @Test(priority = 8)
    public void Verify_Data_Allocation_Reports_Data() throws InterruptedException {
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(35));
    	Thread.sleep(400);
	    WebElement clickOnWorkshop_Name = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@class, 'mat-select-arrow')])[2]")));
	    clickOnWorkshop_Name.click();
	    
	    WebElement Select_Narina = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@role=\"option\"])[2]")));
	    Select_Narina.click();
		   
	    WebElement clickOnGenerate = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
	    clickOnGenerate.click();
	    
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
  		    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));

  		    try {
  		        // Wait for the specific element to be present in the DOM
  		        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class='ng-star-inserted'])[18]")));

  		        // Fetch the single element as it's indexed at position 18
  		        WebElement reportRow = driver.findElement(By.xpath("(//*[@class='ng-star-inserted'])[18]"));

  		        // Verify if the element contains data (non-empty)
  		        if (reportRow.getText().trim().isEmpty()) {
  		            Assert.fail("Data Allocation Report does not contain any data.");
  		        } else {
  		            System.out.println("Data Allocation Report contains data.");
  		        }
  		    } catch (org.openqa.selenium.TimeoutException e) {
  		        // Handle the case where the element is not found within the timeout
  		        Assert.fail("Data Allocation Report does not contain any data.");
  		    }
  		}
}
  



