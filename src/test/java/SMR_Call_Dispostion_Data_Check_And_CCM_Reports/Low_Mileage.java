package SMR_Call_Dispostion_Data_Check_And_CCM_Reports;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Low_Mileage extends Login_Page{
	
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
	  //.....................................................................................................

	    @Test(priority = 6)
	    public void Click_On_MY_Leads() throws InterruptedException {
	        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        WebElement Leads = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"My Leads \"]")));
	        Leads.click();
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));	 		
	        Speed_Dialer();
	    }
//.....................................................................................................
	    @Test(priority = 7)
	    public void click_On_first_Customer() throws InterruptedException {
	        // Find and get the first customer name
	        WebElement firstCustomer = driver.findElement(By.xpath("(//*[@class=\"mat-tooltip-trigger text-truncate\"])[1]"));
	        String firstCustomerText = firstCustomer.getText();
	        String firstCustomerName = firstCustomerText.split(" - ")[0];
	        System.out.println("First customer name  :: " + firstCustomerName);

	        // Click on the first customer
	        if (firstCustomer.isDisplayed()) {
	            firstCustomer.click();
	        } else {
	            System.out.println("First customer element is not visible.");
	            Assert.fail("First customer element not found or not clickable.");
	        }

	        // Sleep to simulate a wait, replace with explicit waits if possible
	        Thread.sleep(5000);

	        // Scroll down to the Vehicle Information section
	        Actions actions = new Actions(driver);
	        actions.sendKeys(Keys.PAGE_DOWN).perform();

	        Thread.sleep(3000);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement Call_Dispostion = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Call Disposition\"]")));
	        Call_Dispostion.click();

	        Thread.sleep(2000);

	        // Scroll down to the Vehicle Information section
	        Actions actions2 = new Actions(driver);
	        actions2.sendKeys(Keys.PAGE_DOWN).perform();

	        // Click on the 'Did you talk to the customer' - YES
	        Thread.sleep(2000);

	        WebElement YES = driver.findElement(By.cssSelector("[value=\"yes\"]"));
	        YES.click();

	        // Click on 'Book an Appointment'
	        WebElement Low_Mileage = driver.findElement(By.cssSelector("[value=\"Low mileage\"]"));
	        Low_Mileage.click();

	        Thread.sleep(1000);
	        actions2.sendKeys(Keys.PAGE_UP).perform();
	        actions2.sendKeys(Keys.PAGE_UP).perform();
	        Thread.sleep(1000);
     //.................Odometer  Reading...................................................................................
	      
	        
	        // Open the calendar
	        WebElement date_Picker = driver.findElement(By.cssSelector("[aria-label='Open calendar']"));
	        date_Picker.click();

	        // Get today's date
	        LocalDate today = LocalDate.now();
	        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("d");
	        String currentDay = today.format(dayFormatter);

	        // Locate today's date and click it
	        List<WebElement> allDays = driver.findElements(By.xpath("//*[contains(@class, 'mat-calendar-body-cell-content')]"));
	        for (WebElement day : allDays) {
	            if (day.getText().trim().equals(currentDay)) {
	                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", day);
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", day);
	                break;
	            }
	        }
	        
	        Thread.sleep(1000);
	        WebElement Odometer = driver.findElement(By.cssSelector("[formcontrolname=\"odometerReading\"]"));
	        Odometer.clear();
	        Thread.sleep(1000);
	        Odometer.sendKeys("30000");

	        Thread.sleep(1000);

	        // Fill in the time picker
	        WebElement hour = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder=\"HH\"]")));
	        hour.sendKeys("20");
	        Thread.sleep(1000);

	        WebElement minute = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder=\"MM\"]")));
	        minute.sendKeys("30");
	        Thread.sleep(1000);

	        WebElement CustomerVOC = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname=\"customerVOC\"]")));
	        CustomerVOC.sendKeys("Low Mileage");
	        Thread.sleep(1000);

	        WebElement CRE_Remark = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname=\"creRemark\"]")));
	        CRE_Remark.sendKeys("Low Mileage");
	        Thread.sleep(1000);

	        WebElement Submit = driver.findElement(By.xpath("//*[text()=\"Submit\"]"));
	        Submit.click();
	        Thread.sleep(2000);

	        // Refresh the page
         driver.navigate().refresh();
         
	        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));	 		


         // Click "Try Again"
	        WebElement Try_Again = driver.findElement(By.xpath("//*[contains(text(), 'Try Again')]"));
	        Try_Again.click();
	       
            Thread.sleep(2000);           
            WebElement Search_Button = driver.findElement(By.id("mat-input-0"));
            Search_Button.sendKeys(firstCustomerName);           
            Thread.sleep(2000);

	        // After clicking "Try Again," get the updated customer list
	        List<WebElement> customers = driver.findElements(By.xpath("//*[@class=\"mat-tooltip-trigger text-truncate\"]"));

	        // Search for the customer that matches firstCustomerName
	        boolean customerFound = false;
	        for (WebElement customer : customers) {
	            String customerText = customer.getText();
	            String customerName = customerText.split(" - ")[0];
	            
	            if (customerName.equals(firstCustomerName)) {
	                // If a match is found, click the customer
	                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", customer);
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", customer);
	                customerFound = true;
	                break;
	            }
	        }

	        if (!customerFound) {
	            Assert.fail("Customer with name " + firstCustomerName + " not found after clicking 'Try Again'.");
	      
	        }
	    }
	    //.....................................................................................................

	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();  // Close the browser and end the WebDriver session
	        }
	    }
	    //.......................................................................................................
		private void Speed_Dialer() throws InterruptedException {
		    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    
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
}