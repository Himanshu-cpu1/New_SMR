package PSf_Static_Report_and_Call_Dispostion;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Psf_Service_Rating_Select_Good extends LOGINs{

	
	String customerFullName;

	public static WebDriver driver;
	public WebDriverWait wait;
	String Reg_NO;


 	@SuppressWarnings("static-access")
    @BeforeClass
    public void PSF() throws InterruptedException {
        // Initialize the driver (assuming it's static in the SMR_due_Datewise class)
        this.driver = LOGINs.driver;

     // Initialize WebDriverWait with a timeout of 10 seconds using Duration
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
	// .....................................................................................................

	@Test(priority = 10)
	public void Click_On_Total_Due_Psf() throws InterruptedException {

		verifyReportData(" Total Due PSF ");		
		
	}
	
	//.................................................................................................

		@Test(priority = 16)
		public void Check_Call_Dispostion_Service_Rating__Good() throws InterruptedException {
			WebElement Total_Psf_Due = driver.findElement(By.xpath("//*[contains(text(),\"Total PSF Due \")]"));
	        clickElementUsingJS(driver, Total_Psf_Due);
	       
			getAndClickFirstCustomer();
			  Thread.sleep(7000);
			//...............................................................................................
		
			  WebElement Registration_Number = driver.findElement(By.xpath("//*[@class=\"plateno-row second\"]"));       
			     // Click the element using JavaScript
			        clickElementUsingJS(driver, Registration_Number);
			         Reg_NO  = Registration_Number.getText();
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
	        WebElement Select_Good = driver.findElement(By.xpath("//*[text()=\"Good\"]"));
	        Select_Good.click();			        
	        Thread.sleep(1000); 
	        WebElement What_did_You_like_Most = driver.findElement(By.xpath("(//*[@id=\"exampleFormControlTextarea1\"])[1]"));
	        What_did_You_like_Most.sendKeys(Reg_NO);			        
	        Thread.sleep(1000);
	        WebElement CcE_Remarks = driver.findElement(By.xpath("(//*[@id=\"exampleFormControlTextarea1\"])[2]"));
	        CcE_Remarks.sendKeys(Reg_NO);			        
	        Thread.sleep(1000);
	        WebElement Submit = driver.findElement(By.xpath("//*[text()=\"Submit\"]"));
	        Submit.click();
	       
	        
	        Save_Succesfully("customer  satisfied with Service Rating Save succesfully");
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));
	  
	        
		}
	      //.................................................................................................

			@Test(priority = 17)
			public void Check_Yes_Customer_Is_Satisfied() throws InterruptedException {
				 Thread.sleep(1000);
				clickOnTab("PSF Calibration Due");
		        Thread.sleep(3000);
		        WebElement Click_On_Search_Button = driver.findElement(By.cssSelector("[data-placeholder=\"Search..\"]"));
		        Click_On_Search_Button.sendKeys(Reg_NO);
		        Thread.sleep(1000);
		        
	        getAndClickFirstCustomer();
	        Thread.sleep(3000);
	        
	        WebElement YES2 = driver.findElement(By.xpath("(//*[@value=\"yes\"])[2]"));
	        clickElementUsingJS(driver, YES2);		
	        Thread.sleep(2000);
	        
	        WebElement Did_Customer_Satisfied = driver.findElement(By.xpath("//*[text()=\"Did Customer confirm Satisfied Rating?\"]"));
	        Did_Customer_Satisfied.click();
	        
	        WebElement Customer_Satisfied = driver.findElement(By.xpath("//*[text()=\"Yes, Customer is satisfied\"]"));
	        Customer_Satisfied.click();
	        Thread.sleep(1000);
	        WebElement Customer_VOC = driver.findElement(By.xpath("(//*[@id=\"exampleFormControlTextarea1\"])[1]"));
	        Customer_VOC.sendKeys(Reg_NO);			        
	      
	        WebElement CcE_Remarks2 = driver.findElement(By.xpath("(//*[@id=\"exampleFormControlTextarea1\"])[2]"));
	        CcE_Remarks2.sendKeys(Reg_NO);			        
	        Thread.sleep(1000);
	        
	        WebElement Submit2 = driver.findElement(By.xpath("//*[text()=\"Submit\"]"));
	        Submit2.click();
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	        WebElement notificationMessage = wait1.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[text()=\"Saved Successfully\"]")));

	// Perform assertion to check if the correct message is displayed
			String expectedMessage = "Saved Successfully";
			String actualMessage = notificationMessage.getText();
			System.out.println("actualMessage  :: " + actualMessage);

			Assert.assertEquals(actualMessage, expectedMessage, "Customer satisfied with service Rating save succesfully");
		}
			 //.....................................................................................................

		    @AfterClass
		    public void tearDown() {
		        if (driver != null) {
		            driver.quit();  // Close the browser and end the WebDriver session
		        }
		    }
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	
			//// .....................Helper Method...........................................................................
			public void setValueUsingJS(WebDriver driver, WebElement element, String value) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].value = arguments[1];", element, value);
			}

		//.....................................................................
			private void clickElementUsingJS(WebDriver driver, WebElement element) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", element);
			}

		
			//..................................................................................
			private void Save_Succesfully(String name) {
				 WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement notificationMessage = wait2.until(ExpectedConditions
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
		
		}



