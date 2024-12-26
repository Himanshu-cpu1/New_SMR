package SMR_Call_Dispostion_Data_Check_And_CCM_Reports;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
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

public class BodyShop_All_tab_Data_Check_and_Call_Dispostion {

	public static WebDriver driver;
	public WebDriverWait wait;

	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://dealercrm.co.in/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(16, TimeUnit.SECONDS);

	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Test(priority = 1)
	public void Username() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Username = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id=\"mat-input-0\"]")));
		Username.sendKeys("111201TC00326");

		Thread.sleep(2000);
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Test(priority = 2)
	public void Password() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement password = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id=\"mat-input-1\"]")));
		password.sendKeys("Bansal@123");

		Thread.sleep(3000);

		WebElement login_Button = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[type=\"submit\"]")));
		login_Button.click();

	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Test(priority = 3)
	public void Captcha() throws InterruptedException {

		// .................Enter The Captcha
		// ..................................................................
		WebElement Image = driver.findElement(By.xpath("(//*[@type=\"text\"])[1]"));

		String S1 = Image.getAttribute("value");
		System.out.println("captcha ::" + S1);

		Thread.sleep(3000);

		WebElement captcha_field = driver.findElement(By.cssSelector("[placeholder=\"Enter the captcha..\"]"));
		captcha_field.sendKeys(S1);
		// ......................................................................
	}

	// wait for 15 Second and put the captcha code

//.....................................................................................................

	@Test(priority = 4)
	public void SUBMIT_Button() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement Submit = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Submit\"]")));
		Submit.click();
		 // Wait until the page or the expected content is fully loaded after clicking (adjust the condition as needed)
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));
	}

	// .....................................................................................................

	@Test(priority = 7)
	public void Click_Bodyshop_Leads() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
				
		// click on spped dialer
		Speed_Dialer();
		WebElement Leads = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"BodyShop Leads \"]")));
		Leads.click();
		 // Wait until the page or the expected content is fully loaded after clicking (adjust the condition as needed)
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));
	}

	

	
//	// .....................................................................................................

		@Test(priority = 10)
		public void Click_On_Fresh_Calls() throws InterruptedException {
			clickOnTab("Fresh Calls");
			verifyReportData("Fresh Calls");
		}
		// .....................................................................................................

				@Test(priority = 11)
				public void Click_On_Pending_Calls() throws InterruptedException {
					clickOnTab("Pending Calls");
					verifyReportData("Pending Calls");
				}
				// .....................................................................................................

				@Test(priority = 12)
				public void Click_On_Follow_up_Calls() throws InterruptedException {
					clickOnTab("Follow-up Calls");
					verifyReportData("Follow-up Calls");
				}
				// .....................................................................................................

				@Test(priority = 13)
				public void Click_On_Today_Booking() throws InterruptedException {
					clickOnTab(" Today Booking");
					verifyReportData(" Today Booking");
				}
				// .....................................................................................................

				@Test(priority = 14)
				public void Click_On_Future_Booking() throws InterruptedException {
					clickOnTab(" Future Booking");
					verifyReportData(" Future Booking");
				}
				// .....................................................................................................

				@Test(priority = 15)
				public void Click_On_Pending_Booking() throws InterruptedException {
					clickOnTab("Pending Booking");
					verifyReportData("Pending Booking");
				}
				// .....................................................................................................

				@Test(priority = 17)
				public void Click_On_Lost_Calls() throws InterruptedException {
					clickOnTab("Lost Calls");
					verifyReportData("Lost Calls");
				}
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>.....Helper Method....<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

	//....................................................................................................   
    @Test(priority = 15)
    public void ChecK_Call_Dispostion_On_Body_Shop_Leads() throws InterruptedException {
    	verifyReportData("BodyShop Leads");
    	
        getAndClickFirstCustomer();
        
        Call_Dispostion_Click();
        // Click on the 'Did you talk to the customer' - YES
        Thread.sleep(3000);

        WebElement YES = driver.findElement(By.cssSelector("[value=\"yes\"]"));
        YES.click();
        
        Thread.sleep(2000);
       
        //.............click on Book an Appointment................................................
        WebElement Appointmnet = driver.findElement(By.cssSelector("[value=\"Book an appointment\"]"));
        Appointmnet.click();
        
        Thread.sleep(1000);
        		      		        
        WebElement odometer = driver.findElement(By.cssSelector("[formcontrolname=\"odometerReading\"]"));
        odometer.clear();
        odometer.sendKeys("30000");
        Thread.sleep(1000);
        
        WebElement appointmnet_Type = driver.findElement(By.xpath("(//*[contains(@id, 'mat-select-value')])[8]"));
        appointmnet_Type.click();
        
        Thread.sleep(1000);
        WebElement select_Incoming_Calls = driver.findElement(By.xpath("//*[text()=\" Incoming Telephone Calls\"]"));
        select_Incoming_Calls.click();
        
//         Thread.sleep(2000);
//        
//        WebElement Service_Type = driver.findElement(By.xpath("(//*[contains(@id, 'mat-select-value')])[7]"));
//        Service_Type.click();
//       	       	        
//        Thread.sleep(2000);
//        
//        WebElement select_Service_Type = driver.findElement(By.xpath("//*[text()=\"PAID SERVICE \"]"));
//        select_Service_Type.click();
        
        Thread.sleep(2000);
        Actions actions = new Actions(driver);

        actions.sendKeys(Keys.PAGE_UP).perform();
        
        Thread.sleep(2000);
                
        WebElement Service_Workshop = driver.findElement(By.xpath("(//*[contains(@id, 'mat-select-value')])[10]"));
        Service_Workshop.click();
       	       	        
        Thread.sleep(2000);
        
        WebElement select_Service_Type = driver.findElement(By.xpath("//*[text()=\"KAROLBAGH-SRV (08B7-ZZ) \"]"));
        select_Service_Type.click();
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
        
        Thread.sleep(3000);
     //..................select Appointmnet Type....................................................................   
       
        
        Thread.sleep(3000);
        WebElement Book_Slot = driver.findElement(By.xpath("//*[text()=\" Book Slot \"]"));
        Book_Slot.click();
        
        Thread.sleep(3000);
        WebElement Time_Slot = driver.findElement(By.xpath("(//*[contains(@id, 'mat-select-value')])[15]"));
        Time_Slot.click();
        
        Thread.sleep(3000);
        WebElement select_Time = driver.findElement(By.xpath("(//*[@class=\"mat-option-text\"])[5]"));
        select_Time.click();
        
        // Wait for the checkboxes to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

        
        Thread.sleep(3000);
        WebElement Click_on_Submit = driver.findElement(By.cssSelector("[value=\"Submit\"]"));
        Click_on_Submit.click();
        
        Thread.sleep(3000);	
                
     // Scroll down to bring the "Service Due Workshop" element into view
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        Thread.sleep(1000);
        WebElement Customer_VOC = driver.findElement(By.cssSelector("[formcontrolname=\"customerVOC\"]"));
        js.executeScript("arguments[0].scrollIntoView(true);", Customer_VOC);       
        Customer_VOC.sendKeys("Appointmnet Booked2");
        
        Thread.sleep(3000);
        WebElement CRE_Remark = driver.findElement(By.cssSelector("[formcontrolname=\"creRemark\"]"));
        CRE_Remark.sendKeys("Appointmnet Booked2");
        
        Thread.sleep(2000);
        WebElement Submit = driver.findElement(By.xpath("//*[text()=\"Submit\"]"));
        Submit.click();
        
        try {
            Thread.sleep(3000);

            // Try to locate the booking confirmation message
            WebElement Booking_Done = driver.findElement(By.xpath("//*[contains(text(),\"Your booking has been done.\")]"));

            // Assert if the booking confirmation message is displayed
            Assert.assertTrue(Booking_Done.isDisplayed(), "Booking has not been completed.");

            // If the message is displayed, click the close button
            System.out.println("Booking has been completed.");
            Thread.sleep(3000);

            WebElement close_Button = driver.findElement(By.cssSelector("[class=\"close-btn\"]"));
            close_Button.click();

            Thread.sleep(3000);

        } catch (NoSuchElementException e) {
            // If the element is not found, fail the test with a message
            Assert.fail("Booking has not been completed. Confirmation message not found.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
           
       driver.navigate().refresh();
       // Wait until the page or the expected content is fully loaded after clicking (adjust the condition as needed)
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));
    }
//....................................................................................................
    @Test(priority = 16)
    public void Remove_Apppointment_Schedule() throws InterruptedException {
    	clickOnTab(" Future Booking");
    	 getAndClickFirstCustomer();
       	                       	
        Thread.sleep(1000); 
     // Scroll down to the Vehicle Information section
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(3000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Call_Dispostion = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Call Disposition\"]")));
        Call_Dispostion.click();

        Thread.sleep(3000);

        // Scroll down to the Vehicle Information section
        Actions actions2 = new Actions(driver);
        actions2.sendKeys(Keys.PAGE_DOWN).perform();

        // Click on the 'Did you talk to the customer' - YES
        Thread.sleep(2000);

        WebElement YES = driver.findElement(By.cssSelector("[value=\"yes\"]"));
        YES.click();
        Thread.sleep(1000);
        
        WebElement No = driver.findElement(By.cssSelector("[value=\"no\"]"));
        No.click();
        Thread.sleep(1000);
        
        WebElement NoT_Intrested = driver.findElement(By.cssSelector("[value=\"Not interested in service\"]"));
        NoT_Intrested.click();
               
        Thread.sleep(2000);
        actions2.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(2000);
        
        WebElement Reason_Type = driver.findElement(By.xpath("(//*[contains(@id, 'mat-select-value')])[10]"));           
        Reason_Type.click();
        
        Thread.sleep(2000);
        WebElement Select1 = driver.findElement(By.xpath("//*[text()=\"Service Booking Cancel \"]"));            
        Select1.click();
        
        Thread.sleep(2000);
        WebElement Reason_Description = driver.findElement(By.xpath("(//*[contains(@id, 'mat-select-value')])[11]"));            
        Reason_Description.click();
        
        Thread.sleep(2000);
        WebElement Select2 = driver.findElement(By.xpath("//*[text()=\"Others \"]"));            
        Select2.click();
        
        Thread.sleep(2000);
        WebElement Cre_Remark = driver.findElement(By.cssSelector("[formcontrolname=\"creRemark\"]"));
        scrollToElement(driver, Cre_Remark);      
        Cre_Remark.sendKeys("not");
        
        Thread.sleep(2000);
        WebElement customerVOC = driver.findElement(By.cssSelector("[formcontrolname=\"customerVOC\"]"));
        scrollToElement(driver, customerVOC);      
        customerVOC.sendKeys("not");

        
     // Wait and click on the "Submit" button
        Thread.sleep(2000); // Add sleep if necessary for UI stability
        WebElement Submit = driver.findElement(By.xpath("//*[text()=\"Submit\"]"));
        Submit.click();
        
        Save_Succesfully("Appointment detail removed succesfully");
        // Refresh the page
        driver.navigate().refresh();
        
        // Wait until the page or the expected content is fully loaded after clicking (adjust the condition as needed)
 	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));
        
    }
    
    //....................................................................................................   
    @Test(priority = 17)
    public void ChecK_Call_Dispostion_Of_Call_Me_Later() throws InterruptedException {
    	 WebElement BodyShop = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[text()=\"BodyShop Leads\"])[2]")));
    	 BodyShop.click();
    	 Thread.sleep(15000);
    	 WebElement Fresh1 = driver.findElement(By.xpath("//*[contains(text(),\" Pending Fresh \")]"));
         Fresh1.click();
         String FRESH1= Fresh1.getText();
      // Use regular expression to extract the number
         String numberOnly = FRESH1.replaceAll("[^0-9]", "");
         
         System.out.println("numberOnly  ::  "+ numberOnly);
         
      // Convert to integer
         int num1 = Integer.parseInt(numberOnly);
         Thread.sleep(2000);
    //..........................................................................
        getAndClickFirstCustomer();
        // Sleep to simulate a wait, replace with explicit waits if possible
        Thread.sleep(5000);

        // Scroll down to the Vehicle Information section
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(3000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Call_Dispostion = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Call Disposition\"]")));
        Call_Dispostion.click();

        Thread.sleep(3000);

        // Scroll down to the Vehicle Information section
        Actions actions2 = new Actions(driver);
        actions2.sendKeys(Keys.PAGE_DOWN).perform();

        // Click on the 'Did you talk to the customer' - YES
        Thread.sleep(3000);

        WebElement YES = driver.findElement(By.cssSelector("[value=\"yes\"]"));
        YES.click();

        // Click on 'Book an Appointment'
        WebElement call_Me_Later = driver.findElement(By.cssSelector("[value=\"Call me later\"]"));
        call_Me_Later.click();

        Thread.sleep(2000);
        actions2.sendKeys(Keys.PAGE_UP).perform();
        actions2.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(2000);

        current_date_picker();

        Thread.sleep(3000);

        // Fill in the time picker
        WebElement hour = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder=\"HH\"]")));
        hour.sendKeys("20");
        Thread.sleep(3000);

        WebElement minute = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[placeholder=\"MM\"]")));
        minute.sendKeys("30");
        Thread.sleep(3000);

        WebElement CustomerVOC = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname=\"customerVOC\"]")));
        CustomerVOC.sendKeys("CALL ME LATER2");
        Thread.sleep(3000);

        WebElement CRE_Remark = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname=\"creRemark\"]")));
        CRE_Remark.sendKeys("CALL ME LATER2");
        Thread.sleep(3000);

        WebElement Submit = driver.findElement(By.xpath("//*[text()=\"Submit\"]"));
        Submit.click();
        Thread.sleep(3000);
        
        Save_Succesfully("Call  me later save succesfully");

        // Refresh the page
        driver.navigate().refresh();
        
        // Wait until the page or the expected content is fully loaded after clicking (adjust the condition as needed)
 	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));
      
 	    WebElement Fresh2 = driver.findElement(By.xpath("//*[contains(text(),\" Pending Fresh \")]"));
        Fresh2.click();
        String FRESH2= Fresh2.getText();
     // Use regular expression to extract the number
        String numberOnly2 = FRESH2.replaceAll("[^0-9]", "");
        
        System.out.println("numberOnly2  ::  "+ numberOnly2);
     // Convert to integer
        int num2 = Integer.parseInt(numberOnly2);
        
     // Assert that the second number is 1 less than the first number
        Assert.assertEquals(num1-1, num2,"The numbers are NOT decremented In fresh when we Apply Call me later");

        System.out.println("The numbers are correctly decremented by 1.");
    }
    //....................................................................................................   
    @Test(priority = 19)
    public void ChecK_Call_Dispostion_Of_Transfer_To_New_Location_In_REFUSE_FOR_Repair() throws InterruptedException {
                	
        getAndClickFirstCustomer();
        // Sleep to simulate a wait, replace with explicit waits if possible
        Thread.sleep(5000);

        // Scroll down to the Vehicle Information section
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(3000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Call_Dispostion = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Call Disposition\"]")));
        Call_Dispostion.click();

        Thread.sleep(3000);

        // Scroll down to the Vehicle Information section
        Actions actions2 = new Actions(driver);
        actions2.sendKeys(Keys.PAGE_DOWN).perform();

        // Click on the 'Did you talk to the customer' - YES
        Thread.sleep(3000);

        WebElement YES = driver.findElement(By.cssSelector("[value=\"yes\"]"));
        YES.click();

        // Click on 'Refuse_For_Service'
        WebElement Refuse_For_Repaire = driver.findElement(By.xpath("//*[text()=\"Refuse for Repair\"]"));
        Refuse_For_Repaire.click();
        
        Thread.sleep(2000);
        // Click on 'Transfer_To_New_Location'
        WebElement Transfer_To_New_Location = driver.findElement(By.xpath("//*[text()=\"Transfer to a new location\"]"));
        Transfer_To_New_Location.click();
        
        Thread.sleep(2000);
        actions2.sendKeys(Keys.PAGE_UP).perform();
	       
        Thread.sleep(4000);	        
        WebElement Transfer_State = driver.findElement(By.cssSelector("[formcontrolname=\"transferState\"]"));
        Transfer_State.click();
        
        Thread.sleep(1000);	        
        WebElement select_state = driver.findElement(By.xpath("//*[text()=\"Gujarat\"]"));
        select_state.click();
        
        Thread.sleep(1000);	        
        WebElement Transfer_Pincode = driver.findElement(By.cssSelector("[formcontrolname=\"transferPincode\"]"));
        Transfer_Pincode.sendKeys("450045");
        
        Thread.sleep(1000);	        
        WebElement Transfer_city = driver.findElement(By.cssSelector("[formcontrolname=\"transferCity\"]"));
        Transfer_city.sendKeys("Jaipur");
        
        Thread.sleep(1000);	        
        WebElement Prefered_Workshop = driver.findElement(By.cssSelector("[formcontrolname=\"preferredWorkshop\"]"));
        Prefered_Workshop.sendKeys("Jaipur location");
        
        Thread.sleep(1000);	        
        WebElement Address = driver.findElement(By.cssSelector("[formcontrolname=\"address\"]"));
        Address.sendKeys("JAIPUR");
        
        Thread.sleep(1000);

        WebElement CustomerVOC = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname=\"customerVOC\"]")));
        CustomerVOC.sendKeys("Transfer To new location");
        Thread.sleep(1000);

        WebElement CRE_Remark = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname=\"creRemark\"]")));
        CRE_Remark.sendKeys("Transfer To new location");
        Thread.sleep(1000);

        WebElement Submit = driver.findElement(By.xpath("//*[text()=\"Submit\"]"));
        Submit.click();
        Thread.sleep(5000);
        
        Save_Succesfully("REFUSE FOR SERVICE Transfer to new location save succesfully");

        // Refresh the page
        driver.navigate().refresh();
     
        // Wait until the page or the expected content is fully loaded after clicking (adjust the condition as needed)
 	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));    
    }	
    //....................................................................................................   
    @Test(priority = 20)
    public void ChecK_Call_Dispostion_Of_Repaire_Already_Done_In_REFUSE_FOR_SERVICE() throws InterruptedException {
                           
        getAndClickFirstCustomer();
        // Sleep to simulate a wait, replace with explicit waits if possible
        Thread.sleep(5000);

        // Scroll down to the Vehicle Information section
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(3000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Call_Dispostion = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Call Disposition\"]")));
        Call_Dispostion.click();

        Thread.sleep(3000);

        // Scroll down to the Vehicle Information section
        Actions actions2 = new Actions(driver);
        actions2.sendKeys(Keys.PAGE_DOWN).perform();

        // Click on the 'Did you talk to the customer' - YES
        Thread.sleep(3000);

        WebElement YES = driver.findElement(By.cssSelector("[value=\"yes\"]"));
        YES.click();

        // Click on 'Refuse_For_Repaire'
        WebElement Refuse_For_Repaire = driver.findElement(By.xpath("//*[text()=\"Refuse for Repair\"]"));
        Refuse_For_Repaire.click();
        
        Thread.sleep(1000);
        // Click on 'Transfer_To_New_Location'
        WebElement Repaire_already_Done = driver.findElement(By.xpath("//*[text()=\"Repair already done\"]"));
        Repaire_already_Done.click();
        
        Thread.sleep(1000);
        actions2.sendKeys(Keys.PAGE_UP).perform();
	       
        Thread.sleep(2000);	        
        WebElement service_Workshop = driver.findElement(By.xpath("(//*[contains(@id, 'mat-select-value')])[10]"));
        service_Workshop.click();
        
        Thread.sleep(1000);	   
        WebElement select_Workshop = driver.findElement(By.xpath("//*[text()=\"new workshop \"]"));
        select_Workshop.click();
        
        Thread.sleep(1000);	  
        
        //.........select Current date .....................................................
        current_date_picker();
        Thread.sleep(1000);	
        WebElement odometer = driver.findElement(By.cssSelector("[formcontrolname=\"odometerReading\"]"));
        odometer.sendKeys("30000");
        Thread.sleep(1000);
        
        WebElement Bill_amount = driver.findElement(By.cssSelector("[formcontrolname=\"billAmount\"]"));
        Bill_amount.sendKeys("650000");
        Thread.sleep(1000);

        WebElement CustomerVOC = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname=\"customerVOC\"]")));
        CustomerVOC.sendKeys("Service_Already_DONE");
        Thread.sleep(1000);

        WebElement CRE_Remark = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname=\"creRemark\"]")));
        CRE_Remark.sendKeys("Service_Already_DONE");
        Thread.sleep(1000);

        WebElement Submit = driver.findElement(By.xpath("//*[text()=\"Submit\"]"));
        Submit.click();
        Thread.sleep(5000);
        
        Save_Succesfully("REFUSE FOR SERVICE Repaire already Done save succesfully");
        // Refresh the page
        driver.navigate().refresh();
        // Wait until the page or the expected content is fully loaded after clicking (adjust the condition as needed)
 	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));
    } 
   
  //....................................................................................................   
    @Test(priority = 21)
    public void ChecK_Call_Dispostion_Of_Vehicle_scraped_In_REFUSE_FOR_Repaire() throws InterruptedException {
                         
        getAndClickFirstCustomer();
        // Sleep to simulate a wait, replace with explicit waits if possible
        Thread.sleep(5000);

        // Scroll down to the Vehicle Information section
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(3000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement Call_Dispostion = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Call Disposition\"]")));
        Call_Dispostion.click();

        Thread.sleep(3000);

        // Scroll down to the Vehicle Information section
        Actions actions2 = new Actions(driver);
        actions2.sendKeys(Keys.PAGE_DOWN).perform();

        // Click on the 'Did you talk to the customer' - YES
        Thread.sleep(3000);

        WebElement YES = driver.findElement(By.cssSelector("[value=\"yes\"]"));
        YES.click();

        // Click on 'Refuse_For_Repaire'
        WebElement Refuse_For_Repaire = driver.findElement(By.xpath("//*[text()=\"Refuse for Repair\"]"));
        Refuse_For_Repaire.click();
        
        Thread.sleep(1000);
        // Click on 'Transfer_To_New_Location'
        WebElement vehicle_Scraped = driver.findElement(By.xpath("//*[text()=\"Vehicle scrapped./ total loss \"]"));
        vehicle_Scraped.click();
        
        Thread.sleep(1000);
        actions2.sendKeys(Keys.PAGE_UP).perform();
        
        Thread.sleep(1000);

        WebElement CustomerVOC = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname=\"customerVOC\"]")));
        CustomerVOC.sendKeys("Vehicle Scraped or Lost calls");
        Thread.sleep(1000);

        WebElement CRE_Remark = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname=\"creRemark\"]")));
        CRE_Remark.sendKeys("Vehicle Scraped or Lost calls");
        Thread.sleep(1000);

        WebElement Submit = driver.findElement(By.xpath("//*[text()=\"Submit\"]"));
        Submit.click();
        Thread.sleep(5000);
        Save_Succesfully("REFUSE FOR SERVICE Vehicle scraped save succesfully");

        // Refresh the page
        driver.navigate().refresh();
        // Wait until the page or the expected content is fully loaded after clicking (adjust the condition as needed)
 	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));
 	}
    //....................................................................................................   
    @Test(priority = 22)
    public void ChecK_Call_Dispostion_Of_Others_In_REFUSE_FOR_Repaire() throws InterruptedException {
                         
        getAndClickFirstCustomer();
        // Sleep to simulate a wait, replace with explicit waits if possible
        Thread.sleep(5000);

        // Scroll down to the Vehicle Information section
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(3000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement Call_Dispostion = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Call Disposition\"]")));
        Call_Dispostion.click();

        Thread.sleep(3000);

        // Scroll down to the Vehicle Information section
        Actions actions2 = new Actions(driver);
        actions2.sendKeys(Keys.PAGE_DOWN).perform();

        // Click on the 'Did you talk to the customer' - YES
        Thread.sleep(3000);

        WebElement YES = driver.findElement(By.cssSelector("[value=\"yes\"]"));
        YES.click();

        // Click on 'Refuse_For_Repaire'
        WebElement Refuse_For_Repaire = driver.findElement(By.xpath("//*[text()=\"Refuse for Repair\"]"));
        Refuse_For_Repaire.click();
        
        Thread.sleep(1000);
        // Click on 'Transfer_To_New_Location'
        WebElement Others = driver.findElement(By.xpath("//*[text()=\"Others\"]"));
        Others.click();
        
        Thread.sleep(1000);
        actions2.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(1000);
        WebElement Reason = driver.findElement(By.xpath("(//*[contains(@id, 'mat-select-value')])[10]"));
        Reason.click();        
        Thread.sleep(1000);
        WebElement Select_Reason = driver.findElement(By.xpath("//*[text()=\"Other \"]"));
        Select_Reason.click();        
        Thread.sleep(1000);

        WebElement CustomerVOC = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname=\"customerVOC\"]")));
        CustomerVOC.sendKeys("Other Region");
        Thread.sleep(1000);

        WebElement CRE_Remark = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname=\"creRemark\"]")));
        CRE_Remark.sendKeys("Other Region");
        Thread.sleep(1000);

        WebElement Submit = driver.findElement(By.xpath("//*[text()=\"Submit\"]"));
        Submit.click();
        Thread.sleep(5000);
        Save_Succesfully("REFUSE FOR SERVICE Other save succesfully");

        // Refresh the page
        driver.navigate().refresh();
        // Wait until the page or the expected content is fully loaded after clicking (adjust the condition as needed)
 	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));
 	}
    
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Closes the browser and ends the WebDriver session
        }
    }
    
  //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    
    // Helper method to click on a button or tab based on its visible text
    private void clickOnTab(String tabName) throws InterruptedException {
        Thread.sleep(3000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement tab = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),\"" + tabName + "\")]")));
        tab.click();
        Thread.sleep(12000);
    }
    
//...........................................................................      
    private String getAndClickFirstCustomer() {
        // Locate the first customer and get the text
        WebElement firstCustomer = driver.findElement(By.xpath("//*[@class='mat-row cdk-row cursor-pointer ng-star-inserted']"));
        String firstCustomerText = firstCustomer.getText();
        String firstCustomerName = firstCustomerText.split(" - ")[0];
        System.out.println("First customer name :: " + firstCustomerName);

        // Click on the first customer
        if (firstCustomer.isDisplayed()) {
        	 // Double-click on the first customer
            Actions actions = new Actions(driver);
            actions.doubleClick(firstCustomer).perform();
        } else {
            System.out.println("First customer element is not visible.");
            Assert.fail("First customer element not found or not clickable.");
        }

        return firstCustomerName;
    }
    
    //............................................................................................
    private void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
  //................................................................................................
   
    //..................................................................................
   	private void Save_Succesfully(String name) {
   		
   	// Wait for the notification message to appear (adjust xpath based on your actual notification element)
        WebElement notificationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"Save SuccessFully\"]")));

        // Perform assertion to check if the correct message is displayed
        String expectedMessage = "Save SuccessFully";
        String actualMessage = notificationMessage.getText();
        System.out.println("actualMessage  :: "+actualMessage);

        Assert.assertEquals(actualMessage, expectedMessage,"Low mileage has not been saved");
    }
     //.........................................................................................	
     private void current_date_picker() {
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
             }}
         }
    	//..........................................................................................
         private void Call_Dispostion_Click() throws InterruptedException {
             // Sleep to simulate a wait, replace with explicit waits if possible
             Thread.sleep(5000);

             // Scroll down to the Vehicle Information section
             Actions actions = new Actions(driver);
             actions.sendKeys(Keys.PAGE_DOWN).perform();

             Thread.sleep(3000);
             wait = new WebDriverWait(driver, Duration.ofSeconds(10));
             WebElement Call_Dispostion = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Call Disposition\"]")));
             Call_Dispostion.click();

             Thread.sleep(3000);

             // Scroll down to the Vehicle Information section
             Actions actions2 = new Actions(driver);
             actions2.sendKeys(Keys.PAGE_DOWN).perform();
         
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

//................................................................................................
//Helper method to check if the report table contains data
private void verifyReportData(String tabName) {
	List<WebElement> reportRows = driver.findElements(By.xpath("//*[@class='mat-row cdk-row cursor-pointer ng-star-inserted']"));
	if (reportRows.size() > 1) {
		System.out.println("'" + tabName + "' contains data.");
	} else {
		Assert.fail("'" + tabName + "' does not contain any data.");
	}
}    
}

