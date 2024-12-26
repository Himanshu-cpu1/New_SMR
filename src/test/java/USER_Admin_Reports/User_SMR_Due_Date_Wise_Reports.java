package USER_Admin_Reports;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class User_SMR_Due_Date_Wise_Reports extends Login_Admin {

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
	    public void Click_On_SMR_Due_Date_Wise() throws InterruptedException {
	    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement SMR_Due_Date_Wise = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"SMR Due Date Wise \"]")));
	        clickElementUsingJS(driver, SMR_Due_Date_Wise);	
	        
	    }
	    //.....................................................................................................

	    @Test(priority = 8)
	    public void Check_Data_In_Summary_Report() throws InterruptedException {
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(35));
	        select_date();

	        // Data contains or not  
	        String Xpath="(//tr[td[contains(., 'PMS')]])[1]/td";
	        String Name="SMR Due Date Wise";     
	        checkDataPresence(Xpath,Name);
	        
	            WebElement PendingConfirmation = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//tr[td[contains(., 'PMS')]])[1]/td[2]")));
	            String p = PendingConfirmation.getText();
                System.out.println("SMR Due DAte wise "+p);
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
		
		//.......................................................................
		public void checkDataPresence(String xpath, String contextName) {
  		    List<WebElement> AllData = driver.findElements(By.xpath(xpath));

  		    if (AllData.size() > 0) {
  		        System.out.println("'" + contextName + "' contains data.");
  		    } else {
  		        Assert.fail("'" + contextName + "' does not contain any data.");
  		    }
  		}
//...........................................................................................
		private void select_date() throws InterruptedException {
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
			 // Click on the calendar to open date picker
	        WebElement select = wait1.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[alt=\"calendar\"]")));
	        select.click();
	       	        // Select start date (1st of the current month)
	        LocalDate today = LocalDate.now();
	        LocalDate firstDayOfMonth = today.withDayOfMonth(1);
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");


	        WebElement selectStart = wait1.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label=\"" + firstDayOfMonth.format(formatter) + "\"]")));
	        selectStart.click();
	      	        // Select today's date
	        WebElement selectToday = wait1.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label=\"" + today.format(formatter) + "\"]")));
	        selectToday.click();
	        	        // Click on the generate report button
	        Thread.sleep(1000);
	        WebElement clickOnGenerate = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
	        clickOnGenerate.click();

		}
}
