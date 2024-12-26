package USER_Admin_Reports;

import java.time.Duration;

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

public class Admin_User_Ip_Range_Negative_Scenario extends Login_Admin{

	
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
    public void Click_On_User_Management() throws InterruptedException {
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement User_Management = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"User Management \"]")));
        clickElementUsingJS(driver, User_Management);
       // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));	 		
      
    }
    //.....................................................................................................

    @Test(priority = 7)
    public void Click_On_User_Ip_Restriction() throws InterruptedException {
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement User_Ip_Restriction = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"User Ip Restriction \"]")));
        clickElementUsingJS(driver, User_Ip_Restriction);	
        
    }
    
    //.....................................................................................................

    @Test(priority = 8)
    public void Click_On_Employe_Name() throws InterruptedException {
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Employe_Name = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class=\"mat-checkbox-label\"])[5]")));
        clickElementUsingJS(driver, Employe_Name);	
        
    }
    //.....................................................................................................

    @Test(priority = 9)
    public void Click_On_Update_Ip_Range() throws InterruptedException {
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Update_Ip_Range = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Update Ip Range\"]")));
        clickElementUsingJS(driver, Update_Ip_Range);	
        
        WebElement Enter_Ip_Range = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@placeholder=\"Enter Ip Range\"]")));
        Enter_Ip_Range.sendKeys("10.379.39.5");
        
        WebElement Click_On_Submit = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Submit\"]")));
        Click_On_Submit.click();
        
        
        
    } 
  //.....................................................................................................

    @Test(priority = 11)
    public void Updated_succesfully() throws InterruptedException {
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Updated_succesfully1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Update SuccessFully\"]")));
        String Actual_message =Updated_succesfully1.getText();
        System.out.println("Message::"+Actual_message);
        String Uppdated="Update SuccessFully";
       
        Assert.assertEquals(Actual_message, Uppdated,"Ip restrication Saved  succesfully");
       
  
    
    }
    //.....................................................................................................

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser and end the WebDriver session
        }
    }

    
  //.....................................................................
  		private void clickElementUsingJS(WebDriver driver, WebElement element) {
  			JavascriptExecutor js = (JavascriptExecutor) driver;
  			js.executeScript("arguments[0].click();", element);
  		}
}
