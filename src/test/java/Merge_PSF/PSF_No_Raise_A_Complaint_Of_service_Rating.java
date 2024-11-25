package Merge_PSF;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PSF_No_Raise_A_Complaint_Of_service_Rating {

	String customerFullName;

	public static WebDriver driver;
	public WebDriverWait wait;

	 @SuppressWarnings("static-access")
	    @BeforeClass
	    public void SMR() throws InterruptedException {
	        // Initialize the driver (assuming it's static in the SMR_due_Datewise class)
	        this.driver = Psf_All_Fillter_Check.driver;

	     // Initialize WebDriverWait with a timeout of 10 seconds using Duration
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }
	// .....................................................................................................

	@Test(priority = 10)
	public void PSf_No_Raise_A_Complaint_Of_service_Rating() throws InterruptedException {

		verifyReportData(" Total Due PSF ");		
		
	}
	//.................................................................................................

	@Test(priority = 16)
	public void Check_Call_Dispostion_Service_Rating() throws InterruptedException {
		WebElement Total_Psf_Due = driver.findElement(By.xpath("//*[contains(text(),\"Total PSF Due \")]"));
        clickElementUsingJS(driver, Total_Psf_Due);
       
		getAndClickFirstCustomer();
		  Thread.sleep(7000);
		//...............................................................................................
	
		  WebElement Registration_Number = driver.findElement(By.xpath("//*[@class=\"plateno-row second\"]"));       
		     // Click the element using JavaScript
		        clickElementUsingJS(driver, Registration_Number);
		        String Reg_NO  = Registration_Number.getText();
		       Thread.sleep(2000);
		     // Split the text by newline and take the first part
		        Reg_NO = Reg_NO.split("\n")[0];
		        System.out.println("Registration_NO::" + Reg_NO);
//...............................................................................................
        Thread.sleep(2000);
	    Call_Dispostion_Click();
		// Click on the 'Did you talk to the customer' - YES
        Thread.sleep(2000);
        WebElement YES = driver.findElement(By.xpath("(//*[@value=\"yes\"])[2]"));
        clickElementUsingJS(driver, YES);	

        // Click on 'Service_Rating'
        WebElement Service_Rating = driver.findElement(By.xpath("//*[text()=\"Service Rating \"]"));
        Service_Rating.click();			        
        Thread.sleep(1000);
        // Click on 'Click_On_Psf_Rating'
        WebElement Click_On_Psf_Rating = driver.findElement(By.cssSelector("[aria-label=\"Default select example\"]"));
       
        clickElementUsingJS(driver, Click_On_Psf_Rating);			        
        Thread.sleep(1000); 
        WebElement Select_Excellent = driver.findElement(By.xpath("//*[text()=\"Excellent\"]"));
        Select_Excellent.click();			        
        Thread.sleep(1000); 
        WebElement What_did_You_like_Most = driver.findElement(By.xpath("(//*[@id=\"exampleFormControlTextarea1\"])[1]"));
        What_did_You_like_Most.sendKeys(Reg_NO);			        
        Thread.sleep(1000);
        WebElement CcE_Remarks = driver.findElement(By.xpath("(//*[@id=\"exampleFormControlTextarea1\"])[2]"));
        CcE_Remarks.sendKeys(Reg_NO);			        
        Thread.sleep(1000);
        WebElement Submit = driver.findElement(By.xpath("//*[text()=\"Submit\"]"));
        Submit.click();
        Thread.sleep(3000);
        Save_Succesfully("Service Rating Save succesfully");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));
  
        clickOnTab("PSF Calibration Due");
        Thread.sleep(3000);
        WebElement Click_On_Search_Button = driver.findElement(By.cssSelector("[data-placeholder=\"Search..\"]"));
        Click_On_Search_Button.sendKeys(Reg_NO);
        Thread.sleep(1000);
        
        getAndClickFirstCustomer();
        Thread.sleep(2000);
        
        WebElement YES2 = driver.findElement(By.xpath("(//*[@value=\"yes\"])[2]"));
        clickElementUsingJS(driver, YES2);		
        Thread.sleep(2000);
        
        WebElement Did_Customer_Satisfied = driver.findElement(By.xpath("//*[text()=\"Did Customer confirm Satisfied Rating?\"]"));
        Did_Customer_Satisfied.click();
        
        WebElement No_RAise_Complaint = driver.findElement(By.xpath("//*[text()=\"No, Raise a Complaint\"]"));
        No_RAise_Complaint.click();
        Thread.sleep(3000);
        
     // Locate the element
        WebElement Select_Complaint = driver.findElement(By.xpath("(//*[@class=\"form-select\"])[1]"));
        // Use Actions class to perform a double-click
        Actions actions = new Actions(driver);
        actions.doubleClick(Select_Complaint).perform();
        
        WebElement New_Problem = driver.findElement(By.xpath("//*[text()=\"New Problem\"]"));
        New_Problem.click();
        Thread.sleep(3000);
        
        WebElement ComplaintSub_Reason = driver.findElement(By.xpath("(//*[@class=\"form-select\"])[2]"));
        actions.doubleClick(ComplaintSub_Reason).perform();
        
        WebElement SelectOthers = driver.findElement(By.xpath("//*[text()=\"Others\"]"));
        SelectOthers.click();
        
        WebElement Customer_discription = driver.findElement(By.xpath("(//*[@id=\"exampleFormControlTextarea1\"])[1]"));
        Customer_discription.sendKeys("CO");
        
        WebElement CRE_RemARK = driver.findElement(By.xpath("(//*[@id=\"exampleFormControlTextarea1\"])[2]"));
        CRE_RemARK.sendKeys("CO");
       
        WebElement NO = driver.findElement(By.xpath("(//*[text()=\"No\"])[1]"));
        NO.click();       
        WebElement Submit2 = driver.findElement(By.xpath("//*[text()=\"Submit\"]"));
        Submit2.click();        
        Thread.sleep(7000);
                
	}
//......................................................................................
	@Test(priority = 17)
	public void Open_Complaint_Management_tab() throws InterruptedException, AWTException {
		WebElement Complaint_Management = driver.findElement(By.xpath("//*[text()=\"Complaint Management \"]"));
        clickElementUsingJS(driver, Complaint_Management);
        
        Thread.sleep(4000);
        
        WebElement Total_Complaint = driver.findElement(By.xpath("//*[contains(text(),\"Total Complaints\")]"));
        clickElementUsingJS(driver, Total_Complaint);
        
        Thread.sleep(3000);
        getAndClickFirstCustomer();
     
        Thread.sleep(3000);
        WebElement YES2 = driver.findElement(By.xpath("(//*[@value=\"yes\"])[2]"));
        clickElementUsingJS(driver, YES2);		
        Thread.sleep(2000);
        
        WebElement Update_Complaints_Status = driver.findElement(By.xpath("//*[text()=\"Update Complaints Status\"]"));
        clickElementUsingJS(driver, Update_Complaints_Status);		
        Thread.sleep(2000);
        
        WebElement Complaint_status = driver.findElement(By.xpath("(//*[@class=\"form-select\"])[1]"));
        // Use Actions class to perform a double-click
        Actions actions = new Actions(driver);
        actions.doubleClick(Complaint_status).perform();
        Thread.sleep(2000);
        
        WebElement Resolved = driver.findElement(By.xpath("//*[text()=\"Resolved\"]"));
        Resolved.click();
        Thread.sleep(2000);
        WebElement Resolution_Mechansim = driver.findElement(By.xpath("(//*[@class=\"form-select\"])[1]"));
        actions.doubleClick(Resolution_Mechansim).perform();
        
        WebElement Explanation = driver.findElement(By.xpath("//*[text()=\"Explanation\"]"));
        Explanation.click();
        Thread.sleep(2000);
        WebElement OpenCalender = driver.findElement(By.xpath("(//*[@aria-label=\"Open calendar\"])[1]"));
        OpenCalender.click();
        current_date_picker();
        
        Thread.sleep(2000);
        WebElement OpenCalender2 = driver.findElement(By.xpath("(//*[@aria-label=\"Open calendar\"])[2]"));
        OpenCalender2.click();
        current_date_picker();
        
        Thread.sleep(2000);
        WebElement Action_Taken = driver.findElement(By.xpath("(//*[@id=\"exampleFormControlInput1\"])[1]"));
        Action_Taken.sendKeys("YES");
        Thread.sleep(1000);
        WebElement Counter_Measure = driver.findElement(By.xpath("(//*[@id=\"exampleFormControlInput1\"])[2]"));
        Counter_Measure.sendKeys("YES");
   }
	
      //......................................................................................
    	@Test(priority = 18)
    	public void Upload_file() throws InterruptedException, AWTException {
    		 Thread.sleep(1000);
    	        WebElement Choose_File = driver.findElement(By.xpath("//*[@id=\"inputGroupFile02\"]"));
    	     // Perform a triple-click by clicking three times
    	      
    	        Actions actions = new Actions(driver);
    	        actions.click(Choose_File)
    	               .click(Choose_File)
    	               .click(Choose_File)
    	               .perform();
        // Path to the file to be uploaded
        String filePath = "\"C:\\Users\\AA\\Downloads\\New Microsoft Excel Worksheet (1).xlsx\"";
        
        // Call the upload function
        uploadFile(filePath);
        uploadFile(filePath);

        WebElement Submit = driver.findElement(By.xpath("//*[text()=\"Submit\"]"));
        clickElementUsingJS(driver, Submit);
        Thread.sleep(3000);
    }
   //......................................................................................
    	@Test(priority = 19)
    	public void Clcik_On_Resolved_Complaint() throws InterruptedException, AWTException {
    		 Thread.sleep(3000);
    		 clickOnTab("Resolved Complaints");
    		 getAndClickFirstCustomer();
    		 
    		 Thread.sleep(3000);
    		    WebElement YES = driver.findElement(By.xpath("(//*[text()=\"Yes\"])[1]"));
    	        clickElementUsingJS(driver, YES);		
    	       
    	        WebElement YES2 = driver.findElement(By.xpath("(//*[text()=\"Yes\"])[2]"));
    	        clickElementUsingJS(driver, YES2);		
    	        Thread.sleep(1000);
    	        
    	        WebElement Other_Sub_Reason = driver.findElement(By.xpath("(//*[@id=\"exampleFormControlTextarea1\"])[3]"));
    	        Other_Sub_Reason.sendKeys("other");
    	        
    	        WebElement Submit = driver.findElement(By.xpath("//*[text()=\"Submit\"]"));
    	        clickElementUsingJS(driver, Submit);
    	        Thread.sleep(3000); 	        
    	}
    	 //......................................................................................
    	@Test(priority = 20)
    	public void Customer_Will_Be_Available_In_Closed_Complaints() throws InterruptedException, AWTException {
    		 Thread.sleep(1000);
    		 clickOnTab("Closed Complaints"); 					
    		// Check if the first customer is still present after the submit
    		
    		     WebElement firstCustomer = driver.findElement(By.xpath("(//*[@role='row'])[2]"));
    		     if (firstCustomer.isDisplayed()) {
    		         System.out.println("The first customer is  present after submit, test PASS.");
    		     } else {
    		         Assert.fail("The first customer is not  available after Clicking on the Closed Complaints ");
    		     }
    		
    	}
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	public static void uploadFile(String filePath) throws AWTException, InterruptedException {
        // Provide the path of the file to be uploaded
        StringSelection fileToUpload = new StringSelection(filePath);
        
        // Copy the file path to the clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileToUpload, null);
        
        // Use Robot class to handle the system dialog and upload file
        Robot robot = new Robot();
        
        // Brief delay to ensure the upload dialog is open
        Thread.sleep(1000);
        
        // Press Ctrl + V to paste the file path into the dialog
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        
        // Brief delay to ensure the path is pasted
        Thread.sleep(500);
        
        // Press Enter to confirm the file upload
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        // Additional delay for confirmation if necessary
        Thread.sleep(1000);
    }
	// .....................Helper
	// Method...........................................................................
	public void setValueUsingJS(WebDriver driver, WebElement element, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = arguments[1];", element, value);
	}

//.....................................................................
	private void clickElementUsingJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

//.........................................................................................	
	private void current_date_picker() {
		
// Get today's date
		LocalDate today = LocalDate.now();
		DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("d");
		String currentDay = today.format(dayFormatter);

// Locate today's date and click it
		List<WebElement> allDays = driver
				.findElements(By.xpath("//*[contains(@class, 'mat-calendar-body-cell-content')]"));
		for (WebElement day : allDays) {
			if (day.getText().trim().equals(currentDay)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", day);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", day);
				break;
			}
		}
	}

//..................................................................................
	private void Save_Succesfully(String name) {

		WebElement notificationMessage = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Details Saved Successfully.')]")));

// Perform assertion to check if the correct message is displayed
		String expectedMessage = "Details Saved Successfully.";
		String actualMessage = notificationMessage.getText();
		System.out.println("actualMessage  :: " + actualMessage);

		Assert.assertEquals(actualMessage, expectedMessage, "save succesfully");
	}

////////////////////////////////////////////////////////////////////////////////////////////////////
//Helper method to click on a button or tab based on its visible text
	private void clickOnTab(String tabName) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement tab = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),\"" + tabName + "\")]")));
//Click on the tab once it's clickable
		tab.click();
		Thread.sleep(5000);
	}

//................................................................................................
//Helper method to check if the report table contains data
	private void verifyReportData(String tabName) {
		List<WebElement> reportRows = driver.findElements(By.xpath("//*[@class=\"mat-row cdk-row ng-star-inserted\"]"));
		if (reportRows.size() > 1) {
			System.out.println("'" + tabName + "' contains data.");
		} else {
			Assert.fail("'" + tabName + "' does not contain any data.");
		}
	}

//...........................................................................      
	private String getAndClickFirstCustomer() {
		// Locate the first customer and get the text
		WebElement firstCustomer = driver.findElement(By.xpath("(//*[@role=\"row\"])[2]"));
				
		String firstCustomerText = firstCustomer.getText();
		// If the name consists of first and last names, you might want to keep the
		// first two words:
		String[] nameParts = firstCustomerText.split("\\s+");
		customerFullName = nameParts.length > 1 ? nameParts[0] + " " + nameParts[1] : nameParts[0];

		System.out.println("Customer Name: " + customerFullName);

// Click on the first customer
		if (firstCustomer.isDisplayed()) {
			// Double-click on the first customer
			Actions actions = new Actions(driver);
			actions.doubleClick(firstCustomer).perform();
		} else {
			System.out.println("First customer element is not visible.");
			Assert.fail("First customer element not found or not clickable.");
		}

		return customerFullName;
	}

//..........................................................................................
	private void Call_Dispostion_Click() throws InterruptedException {
// Sleep to simulate a wait, replace with explicit waits if possible
		Thread.sleep(1000);

// Scroll down to the Vehicle Information section
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.PAGE_DOWN).perform();

		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Call_Dispostion = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Call Disposition\"]")));
		Call_Dispostion.click();

		Thread.sleep(2000);

// Scroll down to the Vehicle Information section
		Actions actions2 = new Actions(driver);
		actions2.sendKeys(Keys.PAGE_DOWN).perform();

	}

//..........................................................................................
	private void matching_customer_name() throws InterruptedException {

// After clicking "Try Again," get the updated customer list
		List<WebElement> customers = driver.findElements(By.xpath("//*[@class=\"mat-tooltip-trigger text-truncate\"]"));

// Search for the customer that matches firstCustomerName
		boolean customerFound = false;
		for (WebElement customer : customers) {
			String customerText = customer.getText();
			String customerName = customerText.split(" - ")[0];

			if (customerName.equals(customerFullName)) {
				// If a match is found, click the customer
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", customer);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", customer);
				customerFound = true;
				break;
			}
		}

		if (!customerFound) {
			Assert.fail("Customer with name " + customerFullName + " not found after clicking 'Follow Up PSF'.");
		}
	}
}
