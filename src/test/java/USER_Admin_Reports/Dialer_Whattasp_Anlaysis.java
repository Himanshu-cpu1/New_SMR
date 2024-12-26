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

public class Dialer_Whattasp_Anlaysis extends Login_Admin{
	
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
    public void Click_On_Dialer_Whattasp_Anlaysis() throws InterruptedException {
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Dialer_Whattasp_Anlaysis = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Dialer WhatsApp Analysis \"]")));
        clickElementUsingJS(driver, Dialer_Whattasp_Anlaysis);	
        
    }
   //.....................................................................................
    @Test(priority = 8)
    public void Verify_Dialer_Whattasp_Anlaysis_Data() throws InterruptedException {
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(35));
    	    	
    	select_date();
    	WebElement clickOnGenerate = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
		clickOnGenerate.click();	        
	    verifyReportData();
    }
    
  //.....................................................................
  		private void clickElementUsingJS(WebDriver driver, WebElement element) {
  			JavascriptExecutor js = (JavascriptExecutor) driver;
  			js.executeScript("arguments[0].click();", element);
  		}
  	//................................................................................................		
  			private void select_date() throws InterruptedException {
  			    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
  			   
  			    // Click on the calendar to open the date picker
  			    WebElement selectCalendar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[alt=\"calendar\"]")));
  			    selectCalendar.click();
  			    // Click on the "Previous month" button
  			    WebElement clickOnPreviousMonth = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Previous month\"]")));
  			    clickOnPreviousMonth.click();

  			 // Click on the "Previous month" button
  			    WebElement clickOn_1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" 1 \"]")));
  			    clickOn_1.click();
  			 // Click on the "Previous month" button
  			    WebElement clickOn_27 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" 27 \"]")));
  			    clickOn_27.click();

  			    // Click on the "Generate" report button
  			    Thread.sleep(500);
  			    
  			
  			}
  			 //.................................................................................
  		    @AfterClass
  		    public void tearDown() {
  		        if (driver != null) {
  		            driver.quit();  
  		        }
  		    }
  		//.............................................................................................
  			
  			private void verifyReportData() {
  			    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(35));

  			    try {
  			        // Wait until at least one element matching the given XPath is present in the DOM
  			        wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@role=\"cell\"]")));

  			      List<WebElement> reportRows = driver.findElements(By.xpath("//*[@role=\"cell\"]"));
  	  			if (reportRows.size() > 1) {
  	  				System.out.println("  Dialer Whattasp Anlaysis,   contains data.");
  	  			} else {
  	  				Assert.fail("  Dialer Whattasp Anlaysis , does not contain any data.");
  	  			}
  			    } catch (org.openqa.selenium.TimeoutException e) {
  			        // If elements are not found within the specified timeout
  	  				Assert.fail("  Dialer Whattasp Anlaysis , does not contain any data.");
  			}
  			}}
  