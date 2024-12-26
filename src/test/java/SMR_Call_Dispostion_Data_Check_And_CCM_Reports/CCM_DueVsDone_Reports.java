package SMR_Call_Dispostion_Data_Check_And_CCM_Reports;

import java.time.Duration;
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

import io.github.bonigarcia.wdm.WebDriverManager;

public class CCM_DueVsDone_Reports extends LOgin_CCM {

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
  			
  			 WebElement PopUp= driver.findElement(By.xpath("(//*[@title=\"Close message\"])"));
  			 PopUp.click();
  		    Thread.sleep(1000);
  			
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
 	public void Click_On_DUE_VS_DONE_REPORT() throws InterruptedException {
 		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement DueVsDone = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Due Vs Done \"]")));
      
        clickElementUsingJS(driver, DueVsDone);
 		Thread.sleep(3000);
 		
 	}
 	 //.........................................................................................................................
    @Test(priority = 10)
    public void Select_All_Fillter() throws InterruptedException {
    	  //click on Region dropdown
    	Actions actions = new Actions(driver);
    	
    	 WebElement Select_Vehicle_Channel = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[3]"));
         Select_Vehicle_Channel.click();
        
         WebElement Select_all3 = driver.findElement(By.xpath("(//*[@role=\"option\"])[1]"));
         Select_all3.click();
         Thread.sleep(3000);
                 
        WebElement Select_Service_Type = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[2]"));
        actions.doubleClick(Select_Service_Type).perform();
       
        WebElement Select_all2 = driver.findElement(By.xpath("(//*[@role=\"option\"])[1]"));
        Select_all2.click();
        Thread.sleep(3000);
        WebElement Selecet_Workshop = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[1]"));
        Selecet_Workshop.click();
       
        WebElement Select_all = driver.findElement(By.xpath("(//*[@role=\"option\"])[1]"));
        Select_all.click();
        Thread.sleep(3000);
               
    	
    }
    //.........................................................................................................................
    @Test(priority = 11)
    public void Click_On_Generate_Button() throws InterruptedException {

        //click on Generate Button
        WebElement Generate = driver.findElement(By.xpath("(//*[text()=\"Generate\"])"));
        Actions actions1 = new Actions(driver);
        actions1.doubleClick(Generate).perform();
  		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

    }
  //.............................................................................................................   

    @Test(priority = 12)
    public void Data_Verification_DueVsDone() throws InterruptedException {
        // Verify if the report contains data
        List<WebElement> reportRows = driver.findElements(By.xpath("(//*[@role=\"rowgroup\"][2]//tr)"));
        Assert.assertTrue(reportRows.size() > 1, "The report does not contain any data In Due-Vs-Done Report.");
      
        Thread.sleep(2000);

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
