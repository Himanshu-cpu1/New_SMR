package SMR_Call_Dispostion_Data_Check_And_CCM_Reports;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class All_TabData_Check extends Login_Page {

	
	public static WebDriver driver;
	public WebDriverWait wait;

	@SuppressWarnings("static-access")
    @BeforeClass
    public void SMR() throws InterruptedException {
        // Initialize the driver (assuming it's static in the SMR_due_Datewise class)
        this.driver = Login_Page.driver;

     // Initialize WebDriverWait with a timeout of 10 seconds using Duration
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
/// .....................................................................................................

	@Test(priority = 7)
	public void Click_My_Leads() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));				
		WebElement Leads = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"My Leads \"]")));
		   clickElementUsingJS(driver, Leads);
		 // Wait until the page or the expected content is fully loaded after clicking (adjust the condition as needed)
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));
	    Speed_Dialer();
	}
	// .....................................................................................................

			@Test(priority = 10)
			public void Click_On_Today_Booking() throws InterruptedException {
			
				verifyReportData("Total calls");
			}
	// .....................................................................................................

			@Test(priority = 11)
			public void Click_On_Future_Booking() throws InterruptedException {
				clickOnTab("Future Booking");
				verifyReportData("Future Booking");
			}
			// .....................................................................................................

						@Test(priority = 12)
						public void Click_On_Pending_Booking() throws InterruptedException {
							clickOnTab("Pending Booking");
							verifyReportData("Pending Booking");
						}
						// .....................................................................................................

						@Test(priority = 13)
						public void Click_On_Quick_wins() throws InterruptedException {
							clickOnTab("Quick wins");
							verifyReportData("Quick wins");
						}
						// .....................................................................................................

						@Test(priority = 14)
						public void Click_On_Lost_Calls() throws InterruptedException {
							clickOnTab("Lost Calls");
							verifyReportData("Lost Calls");
						}
						// .....................................................................................................

						@Test(priority = 15)
						public void Click_On_Reported_Calls() throws InterruptedException {
							clickOnTab("Reported Calls");
							verifyReportData("Reported Calls");
						}
						  //.....................................................................................................

					    @AfterClass
					    public void tearDown() {
					        if (driver != null) {
					            driver.quit();  // Close the browser and end the WebDriver session
					        }
					    }
	////////////////////////////////////////////////////////////////////////////////////////////////////
	 // Helper method to click on a button or tab based on its visible text
			private void clickOnTab(String tabName) throws InterruptedException {
				wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			    WebElement tab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),\"" + tabName + "\")]")));
			 // Click on the tab once it's clickable
			    tab.click();
			    // Now wait until the tab is clickable (fully loaded or interactive)
			    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));
			            
   //..............................................................................................     
    }				private void Speed_Dialer() throws InterruptedException {
				    
				    // Check if the Dialer element is visible and clickable
				    try {
				    	 WebElement Dialer = wait
				    	            .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Start Now']")));
				    	        
				    	        // Use Actions class to perform a double-click
				    	        Actions actions = new Actions(driver);
				    	        actions.doubleClick(Dialer).perform(); // Double-click on the Dialer element
				    	        Thread.sleep(1000);
				    	        System.out.println("Dialer double-clicked successfully.");
				        
				    } catch (TimeoutException e) {
				        System.out.println("Dialer not found or not clickable, performing other actions.");
				        // Perform other actions if Dialer is not found or not clickable
				        return; // Exit method or handle alternative actions here
				    }

				    // Check if the Stop Calling element is visible and clickable
				    try {
				        WebElement Stop_Calling = wait
				            .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Stop Calling ']")));
				        
				        // Use JavaScript Executor to click
				        JavascriptExecutor js = (JavascriptExecutor) driver;
				        js.executeScript("arguments[0].click();", Stop_Calling);
				        Thread.sleep(1000);
				        System.out.println("Stop Calling clicked successfully.");
				        
				    } catch (TimeoutException e) {
				        System.out.println("Stop Calling not found or not clickable, skipping to next step.");
				        // Perform other actions if Stop Calling is not found or not clickable
				    }
				}

	//................................................................................................
	//Helper method to check if the report table contains data
	private void verifyReportData(String tabName) {
		List<WebElement> reportRows = driver.findElements(By.xpath("(//*[@summary='table']//tr)"));
		if (reportRows.size() > 1) {
			System.out.println("'" + tabName + "' contains data.");
		} else {
			Assert.fail("'" + tabName + "' does not contain any data.");
		}
	}    
	 //.....................Helper Method...........................................................................
	
  	private void clickElementUsingJS(WebDriver driver, WebElement element) {
  	    JavascriptExecutor js = (JavascriptExecutor) driver;
  	    js.executeScript("arguments[0].click();", element);
  	}
  	

}
