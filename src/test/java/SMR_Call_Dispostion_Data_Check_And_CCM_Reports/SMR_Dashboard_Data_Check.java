package SMR_Call_Dispostion_Data_Check_And_CCM_Reports;

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

public class SMR_Dashboard_Data_Check extends Login_Page{

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
	// .....................................................................................................

 // .....................................................................................................

  	@Test(priority = 8)
  	public void Click_On_Dashboard() throws InterruptedException {
  					  		
  		WebElement Dashboard = wait
  			    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Dashboard \"]")));
  			// Call the JavaScript Executor method instead of directly clicking
  			clickElementUsingJS(driver, Dashboard);
            Thread.sleep(1500);
  	}
  	
  	 // .....................................................................................................

  	@Test(priority = 9)
  	public void Click_On_Business_Metrics() throws InterruptedException {
  					  		
  		clickOnTab("Business Matrix");
		verifyReportData("Business Matrix");
  	}
  	 // .....................................................................................................

  	@Test(priority = 10)
  	public void Click_On_Agent_Metrics() throws InterruptedException {
  					  		
  		clickOnTab("Agent Metrics");
		verifyReportData("Agent Metrics");
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
		  //................................................................................................
			//Helper method to check if the report table contains data
			private void verifyReportData(String tabName) {
				List<WebElement> reportRows = driver.findElements(By.xpath("//*[@class=\"mat-card-content ng-star-inserted\"]"));
				if (reportRows.size() > 1) {
					System.out.println("'" + tabName + "' contains data.");
				} else {
					Assert.fail("'" + tabName + "' does not contain any data.");
				}
			}

			
		//.......................................................................................
			private void clickOnTab(String tabName) throws InterruptedException {
				wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			    WebElement tab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),\"" + tabName + "\")]")));
			 // Click on the tab once it's clickable
			    tab.click();
			    // Now wait until the tab is clickable (fully loaded )
			    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));
			}
}
