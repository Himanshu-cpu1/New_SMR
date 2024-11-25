package PSf_Static_Report_and_Call_Dispostion;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

public class Wrong_Number extends LOGINs{

	String customerFullName;
	public static WebDriver driver;
	public WebDriverWait wait;

	
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
				public void PSF_Calibration_Due() throws InterruptedException {				
					getAndClickFirstCustomer();
					  Thread.sleep(3000);
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
					  Thread.sleep(7000);
				        WebElement YES = driver.findElement(By.xpath("(//*[@value=\"yes\"])[2]"));
				        clickElementUsingJS(driver, YES);
				        Thread.sleep(1000);
				        WebElement Wrong_number = driver.findElement(By.xpath("//*[text()=\"Wrong Number\"]"));
				        clickElementUsingJS(driver, Wrong_number);
				        Thread.sleep(2000);
				        
				        WebElement Clcik_On_Dialed_Number = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[4]"));
				        clickElementUsingJS(driver, Clcik_On_Dialed_Number);
				        Thread.sleep(1000);
				      
				        WebElement Select_Number = driver.findElement(By.xpath("(//*[@class=\"mat-option-text\"])[2]"));
				        clickElementUsingJS(driver, Select_Number);
				        Thread.sleep(1000);
				        
				        WebElement mark_Unreliable = driver.findElement(By.xpath("//*[text()=\"Mark Unreliable\"]"));
				        clickElementUsingJS(driver, mark_Unreliable);
				        Thread.sleep(3000);
				
				        Save_Succesfully("Wrong Number Save Succesfully");
				     
				        WebElement Click_On_Search_Button = driver.findElement(By.cssSelector("[data-placeholder=\"Search..\"]"));
				        Click_On_Search_Button.sendKeys(Reg_NO);
				        Thread.sleep(1000);
				        //.............................................................................................   
				        WebElement Registration_Number2 = driver.findElement(By.xpath("(//*[@role=\"cell\"])[3]"));       
					    
					        String Reg_NO2  = Registration_Number2.getText();
					       
					        Reg_NO2 = Reg_NO2.split("\\n")[1];
					    
					        System.out.println("Registration_NO2::" + Reg_NO2);
					//...............................................................................................
					 Assert.assertEquals(Reg_NO, Reg_NO2,"Wrong number will be not in Total PSF due after Submit ");
					        Thread.sleep(1000);
					        Click_On_Search_Button.clear();
					      driver.navigate().refresh();
					      wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));
					    
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

			WebElement notificationMessage = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Saved Successfully')]")));

	// Perform assertion to check if the correct message is displayed
			String expectedMessage = "Saved Successfully";
			String actualMessage = notificationMessage.getText();
			System.out.println("actualMessage  :: " + actualMessage);

			Assert.assertEquals(actualMessage, expectedMessage, "save succesfully");
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

	//.........................................................................................	
		private void current_date_picker() {
	// Open the calendar
				
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


	}




