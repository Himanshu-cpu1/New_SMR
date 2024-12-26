package USER_Admin_Reports;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Poistive_Scenario_Ip_Restriction extends Login_Admin {
	
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
  
   //.............................................................................................
   
    //.....................................................................................................

    @Test(priority = 6)
    public void Click_On_User_Management() throws InterruptedException {
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement User_Management = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"User Management \"]")));
        clickElementUsingJS(driver, User_Management);
      
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
    public void Validate_Postive_Scenario() throws InterruptedException {
    	Thread.sleep(2000);  
    
    	String Current_Url=driver.getCurrentUrl();
        System.out.println("Current Url  ::"+Current_Url);
       
        String Expected_Url="https://dealercrm.co.in/smr/employee-dashboard/userIp-restriction";
        
        Assert.assertEquals(Current_Url, Expected_Url,"Unable to login the Page");
        
    }
    
    
    //.....................................................................
	private void clickElementUsingJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
}
