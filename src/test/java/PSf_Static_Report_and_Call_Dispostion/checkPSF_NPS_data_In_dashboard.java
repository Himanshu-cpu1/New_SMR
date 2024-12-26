package PSf_Static_Report_and_Call_Dispostion;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class checkPSF_NPS_data_In_dashboard extends LOGINs {
	
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
	  	public void Click_On_Dashboard() throws InterruptedException {
	  					  		
	  		WebElement Dashboard = wait
	  			    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Dashboard \"]")));
	  			// Call the JavaScript Executor method instead of directly clicking
	  			clickElementUsingJS(driver, Dashboard);
	            Thread.sleep(500);
	  	}
	  	
	 // ..............................................................................................................
	 	@Test(priority = 9)
	 	public void Click_On_NPS_Dashboard() throws InterruptedException {
		  		
	   		WebElement NPS_Dashboard = wait
	   			    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"NPS Dashboard \"]")));
	   			// Call the JavaScript Executor method instead of directly clicking
	   			clickElementUsingJS(driver, NPS_Dashboard);
	   			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

	   	}
	 	
	 	 
	 	 // .....................................................................................................

	   	@Test(priority = 10)
	   	public void Data_Check_Of_NPS_Dashboard() throws InterruptedException {
	   
	   		       Select_Service_Date_Range_And_Worshop_Wise();
	             Thread.sleep(500);
	             verifyReportData();
	   	}
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
		//.........................................................................................	  	
				private void Select_Service_Date_Range_And_Worshop_Wise() throws InterruptedException {
					
					// Locate the iframe
			   		WebElement iframeElement = driver.findElement(By.xpath("//iframe[@title='Cei Report Integration']"));
			   		// Switch to the iframe
			   		driver.switchTo().frame(iframeElement);				
			   		WebElement fromDateInput = driver.findElement(By.xpath("//*[@name='fromDate']"));
			   		fromDateInput.click(); // Example: Enter a date

					Thread.sleep(500);												
					
			   		WebElement Select2023 = wait
			   			    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" 2023 \"]")));
			   		Select2023.click();
			   	  
			   		Thread.sleep(500);
			   		WebElement Select_OCT = wait
			   			    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" OCT \"]")));
			   		Select_OCT.click();
			   		 
			   		Thread.sleep(1000);
			   		WebElement Todate = driver.findElement(By.xpath("//*[@name='toDate']"));
			   		Todate.click();
			   		Thread.sleep(500);
			   		
			   		WebElement Select2024 = wait
			   			    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" 2024 \"]")));
			   		Select2024.click();
			   	  
			   		Thread.sleep(500);
			   		WebElement Select_SEP = wait
			   			    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" SEP \"]")));
			   		Select_SEP.click();
			   		

			   		Thread.sleep(100);
			   		WebElement Choose_Workshop = wait
			   			    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class=\"dropdown-btn\"])[4]")));
			   		Choose_Workshop.click();
			   		Thread.sleep(500);
			   		WebElement Select_ALL = wait
			   			    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[text()=\"All\"])[2]")));
			   		Select_ALL.click();
			   		
			   		Thread.sleep(500);
			   		WebElement Click_Apply = wait
			   			    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Apply\"]")));
			   		Click_Apply.click();
		   			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

			   	// Switch back to the main document
			   	//	driver.switchTo().defaultContent();
			   	
			   		
			  	}
				
				 //................................................................................................
				//Helper method to check if the report table contains data
				private void verifyReportData() {
					List<WebElement> reportRows = driver.findElements(By.xpath("//*[@class=\"chartjs-render-monitor\"]"));
					if (reportRows.size() > 1) {
						System.out.println(" NPS Dashboard  contains data.");
					} else {
						Assert.fail("NPS Dashboard does not contain any data.");
					}
				}
	}
