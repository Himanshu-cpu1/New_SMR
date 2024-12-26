package SMR_Call_Dispostion_Data_Check_And_CCM_Reports;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class Book_An_Appointment extends  Login_Page {
	
	
	 
	 public static WebDriver driver;
	    public WebDriverWait wait;
	    
	    String firstCustomerName;
		 String firstCustomerText;
		 @SuppressWarnings("static-access")
		    @BeforeClass
		    public void SMR() throws InterruptedException {
		        // Initialize the driver (assuming it's static in the SMR_due_Datewise class)
		        this.driver = Login_Page.driver;

		     // Initialize WebDriverWait with a timeout of 10 seconds using Duration
		        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    }
		 
		    //.....................................................................................................

		    @Test(priority = 5)
		    public void Click_On_MY_Leads() throws InterruptedException {
		        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		        WebElement Leads = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"My Leads \"]")));
		        Leads.click();
		        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));	 		

		        Speed_Dialer();
		       
		    }
		  //.............................................................................................................

		    @Test(priority = 7)
		    public void Data_Verification_For_Total_calls() throws InterruptedException {
		        // Find rows in the report table
		        List<WebElement> reportRows = driver.findElements(By.xpath("(//*[@summary='table']//tr)"));

		        // Check if data is available
		        if (reportRows.size() > 2) {
		            System.out.println("'Total Calls' contains data."); // Data is available
		        } else {
		            System.out.println("'Total Calls' does not contain any data."); // No data available
		            Assert.fail("Total Calls' does not contain any data.");
		        }

		        // Sleep to simulate a wait, replace with explicit waits if possible
		        Thread.sleep(5000);

		     // Find the car model name of the 1st customer and click on that car
		        WebElement modelNameElement = driver.findElement(By.xpath("(//*[@role='cell'])[5]"));
		        String model = modelNameElement.getText();

		        // Split the text by a line break and take the first line
		        String firstLine = model.split("\n")[0].trim();

		        // We can split by the registration number pattern if necessary
		        String carModel = firstLine.split("\\d")[0].trim();  // This will split at the first number and get the model name part

		        System.out.println("Model Name: " + carModel);

	            Thread.sleep(4000);
	//..............................................................................................................
	            WebElement firstCustomer = driver.findElement(By.xpath("(//*[@class=\"mat-tooltip-trigger text-truncate\"])[1]"));
	             firstCustomerText = firstCustomer.getText();

	            // Split the string based on " - " and take the first part
	             firstCustomerName = firstCustomerText.split(" - ")[0];

	            System.out.println("First customer name  :: " + firstCustomerName);
	//........................................................................................................

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

		        // Sleep to simulate a wait, replace with explicit waits if possible
		        Thread.sleep(4000);

		        // Click on Vehicle Info if visible
		        WebElement vehicleInfo = driver.findElement(By.xpath("//*[text()='Vehicle Info']"));
		        if (vehicleInfo.isDisplayed()) {
		            vehicleInfo.click();
		        } else {
		            System.out.println("Vehicle Info button is not visible.");
		            Assert.fail("Vehicle Info element not found or not clickable.");
		        }

		        // Sleep to simulate a wait, replace with explicit waits if possible
		        Thread.sleep(4000);

		        // Find and retrieve the model name from Vehicle Info section
		        WebElement modelName2Element = driver.findElement(By.xpath("(//*[@class=\"dtl-right\"])[1]"));
		        String model2 = modelName2Element.getText();
		        System.out.println("Model Name2: " + model2);

		        // Compare the two model names and assert if they match
		     //   Assert.assertEquals(model2, carModel, "Model names does not match.");
		        	        
		    }
		  //.............................................................................................................

		    @Test(priority = 8)
		    public void Click_On_Call_Dispostion() throws InterruptedException {
		    	
		    	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			        WebElement Call_Dispostion = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Call Disposition\"]")));
			        Call_Dispostion.click();
			        
			        Thread.sleep(4000);
			        
			     // Scroll down to the Vehicle Information section
			        Actions actions = new Actions(driver);
			        actions.sendKeys(Keys.PAGE_DOWN).perform();
			       
			 //...................click on the Did you talk to the customer YES.......................................................................       
			        Thread.sleep(4000);
			        
			        WebElement YES = driver.findElement(By.cssSelector("[value=\"yes\"]"));
			        YES.click();
			        
			        //.............click on Book an Appointment................................................
			        WebElement Appointmnet = driver.findElement(By.cssSelector("[value=\"Book an appointment\"]"));
			        Appointmnet.click();
			        
			        Thread.sleep(2000);
			        		      		        
			        WebElement odometer = driver.findElement(By.cssSelector("[formcontrolname=\"odometerReading\"]"));
			        odometer.sendKeys("30000");
			        Thread.sleep(2000);
			        actions.sendKeys(Keys.PAGE_UP).perform();
			        
			        Thread.sleep(2000);
			     // Open the calendar
			        WebElement date_Picker = driver.findElement(By.cssSelector("[aria-label=\"Open calendar\"]"));
			        date_Picker.click();		        

			        // Pause to allow the calendar to render
			        Thread.sleep(2000);

			        // Get today's date
			        LocalDate today = LocalDate.now();

			        // Get the date two days after today
			        LocalDate twoDaysAfter = today.plusDays(1);

			        // Format the date to match the format used in the calendar
			        DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("d");
			        String dayAfterTwo = twoDaysAfter.format(dayFormatter);

			        // Locate the element representing two days after the current date
			        List<WebElement> allDays = driver.findElements(By.xpath("//*[@class=\"mat-calendar-body-cell-content mat-focus-indicator\"]"));

			        for (WebElement day : allDays) {
			            if (day.getText().equals(dayAfterTwo)) {
			                day.click();
			                break;
			            }
			        }
			        
			        Thread.sleep(4000);
			     //..................select Appointmnet Type....................................................................   
			        WebElement appointmnet_Type = driver.findElement(By.cssSelector("[class=\"mat-select-arrow ng-tns-c122-328\"]"));
			        appointmnet_Type.click();
			        
			        Thread.sleep(2000);
			        WebElement select_Incoming_Calls = driver.findElement(By.xpath("//*[text()=\" Incoming Telephone Calls\"]"));
			        select_Incoming_Calls.click();
			        
			        Thread.sleep(4000);
			        WebElement Book_Slot = driver.findElement(By.xpath("//*[text()=\" Book Slot \"]"));
			        Book_Slot.click();
			        
			        Thread.sleep(4000);
			        WebElement Time_Slot = driver.findElement(By.id("mat-select-value-87"));
			        Time_Slot.click();
			        
			        Thread.sleep(4000);
			        WebElement select_Time = driver.findElement(By.xpath("(//*[@class=\"mat-option-text\"])[6]"));
			        select_Time.click();
			        // List of checkbox XPath expressions
			        List<String> checkboxXPaths = Arrays.asList(
			        	"(//*[contains(@id, 'mat-checkbox')])[1]",
			            "(//*[contains(@id, 'mat-checkbox')])[3]", 
			            "(//*[contains(@id, 'mat-checkbox')])[5]", 
			            "(//*[contains(@id, 'mat-checkbox')])[7]", 
			            "(//*[contains(@id, 'mat-checkbox')])[9]"
			        );

			        // Iterate over all checkboxes
			        for (String checkboxXPath : checkboxXPaths) {

			            // Wait for the checkbox to be visible and located using XPath
			            WebElement checkbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(checkboxXPath)));

			            // Check if the checkbox is already selected
			            WebElement checkboxInput = checkbox.findElement(By.tagName("input")); // Locate the checkbox input element
			            if (!checkboxInput.isSelected()) {
			                // If not selected, click the checkbox
			                checkbox.click();
			                System.out.println("Checkbox with XPath: " + checkboxXPath + " is now selected.");
			            } else {
			                System.out.println("Checkbox with XPath: " + checkboxXPath + " was already selected.");
			            }
			        }

			        
			        Thread.sleep(4000);
			        WebElement Click_on_Submit = driver.findElement(By.cssSelector("[value=\"Submit\"]"));
			        Click_on_Submit.click();
			        
			        Thread.sleep(4000);		        
			        actions.sendKeys(Keys.PAGE_DOWN).perform();
			        actions.sendKeys(Keys.PAGE_DOWN).perform();
			        
			        Thread.sleep(4000);
			        WebElement Customer_VOC = driver.findElement(By.cssSelector("[formcontrolname=\"customerVOC\"]"));
			        Customer_VOC.sendKeys("Appointmnet Booked2");
			        
			        Thread.sleep(4000);
			        WebElement CRE_Remark = driver.findElement(By.cssSelector("[formcontrolname=\"creRemark\"]"));
			        CRE_Remark.sendKeys("Appointmnet Booked2");
			        
			        Thread.sleep(4000);
			        WebElement Submit = driver.findElement(By.xpath("//*[text()=\"Submit\"]"));
			        Submit.click();
			        
			        Thread.sleep(4000);
			        WebElement close_Button = driver.findElement(By.cssSelector("[class=\"close-btn\"]"));
			        close_Button.click();
			        
			        Thread.sleep(4000);
			        		        
		    }
		    //.............................................................................................................

		    @Test(priority = 10)
		    public void Click_On_Future_Booking() throws InterruptedException {
		    	
		    	 Thread.sleep(4000);
		    	  wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			        WebElement FutureBooking = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("mat-tab-label-3-5")));
			        FutureBooking.click();        
			        
			        Thread.sleep(4000);           
		            WebElement Search_Button = driver.findElement(By.id("mat-input-2"));
		            Search_Button.sendKeys(firstCustomerName);           
		            Thread.sleep(4000);
			        
			        WebElement secondCustomer = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class=\"mat-tooltip-trigger text-truncate\"])[1]")));
					String secondCustomerText = secondCustomer.getText();

					// Split the string again and get the customer name
					String secondCustomerName = secondCustomerText.split(" - ")[0];

					System.out.println("Second customer name :: " + secondCustomerName);

					// Compare the names and assert
					Assert.assertEquals(firstCustomerName, secondCustomerName,"Customer names do not match");
					
					    Thread.sleep(2000);
				       
		    }
	    //.............................................................................................................

	    @Test(priority = 11)
	    public void Click_On_Total_Calls() throws InterruptedException {
	    	
	    	  WebElement Total_Calls_Click = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),\"Total calls\")]")));
	    	  Total_Calls_Click.click();

	    	    Thread.sleep(5000);
		        // Refresh the page
	            driver.navigate().refresh();
	            
	            Thread.sleep(15000);
	    	  
	    	  
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
