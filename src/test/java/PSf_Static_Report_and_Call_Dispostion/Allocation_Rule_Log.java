package PSf_Static_Report_and_Call_Dispostion;

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

public class Allocation_Rule_Log extends LOGINs {

	public static WebDriver driver;
	public WebDriverWait wait;
	
	@SuppressWarnings("static-access")
    @BeforeClass
    public void SMR() throws InterruptedException {
        // Initialize the driver (assuming it's static in the SMR_due_Datewise class)
        this.driver = LOGINs.driver;

     // Initialize WebDriverWait with a timeout of 10 seconds using Duration
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
	// .....................................................................................................

	  	@Test(priority = 8)
	  	public void Click_On_Static_Reports() throws InterruptedException {
	  					  		
	  		WebElement Static_Reports = wait
	  			    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Static Report \"]")));
	  			// Call the JavaScript Executor method instead of directly clicking
	  			clickElementUsingJS(driver, Static_Reports);
	            Thread.sleep(1000);
	  	}
	  	
	 // ..............................................................................................................
	 	@Test(priority = 9)
	 	public void Click_On_Allocation_Rule_Log() throws InterruptedException {
	 		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 		WebElement Allocation_Rule_Log = wait.until(
	 				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Allocation Rule Log \"]")));
	 		clickElementUsingJS(driver, Allocation_Rule_Log);
	 		Thread.sleep(5000);
	 		
	 	}
	 	
	 	 //.....................................................................................................

	    @Test(priority = 11)
	    public void Data_Check_Of_Allocation_Rule_Log() throws InterruptedException {
	      	        
	        // Find rows in the report table
	        List<WebElement> reportRows = driver.findElements(By.xpath("//*[@class=\"ng-star-inserted\"]"));

	        // Check if data is available
	        if (reportRows.size() > 1) {
	            System.out.println("'Allocation_Rule_Log' contains data."); // Data is available
	        } else {
	          //  System.out.println("'Tab' does not contain any data."); // No data available
	            Assert.fail("Allocation_Rule_Log' does not contain any data.");
	           
	        }}
	    //.....................................................................................................

	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();  // Close the browser and end the WebDriver session
	        }
	    }
	     
	    
		//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	 	 //.....................Helper Method...........................................................................
	 			
	 		  	private void clickElementUsingJS(WebDriver driver, WebElement element) {
	 		  	    JavascriptExecutor js = (JavascriptExecutor) driver;
	 		  	    js.executeScript("arguments[0].click();", element);
	 		  	}
	 		
	 	}
