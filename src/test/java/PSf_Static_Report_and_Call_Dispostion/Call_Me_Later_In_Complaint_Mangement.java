package PSf_Static_Report_and_Call_Dispostion;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Call_Me_Later_In_Complaint_Mangement extends LOGINs {

	String Reg_NO;
	String CCERemark;
	String CCERemark2;
	String CCERemark3;
	
	String customerFullName;
	public static WebDriver driver;
	public WebDriverWait wait;

	
	@SuppressWarnings("static-access")
    @BeforeClass
    public void SMR() throws InterruptedException {
        // Initialize the driver (assuming it's static in the SMR_due_Datewise class)
        this.driver = LOGINs.driver;

     // Initialize WebDriverWait with a timeout of 10 seconds using Duration
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
	// .....................................................................................................

		@Test(priority = 8)
		public void Click_On_The_Complaint_Management() throws InterruptedException {

			WebElement Complaint_Management = driver.findElement(By.xpath("//*[text()=\"Complaint Management \"]"));
			 clickElementUsingJS(driver, Complaint_Management);			
			Thread.sleep(3000);
		}
	
		// .....................................................................................................

				@Test(priority = 9)
				public void Click_On_In_Progress_Complaints() throws InterruptedException {

					clickOnTab("In-Progress Complaints");			
					Thread.sleep(1000);
				}
				
				// .....................................................................................................

				@Test(priority = 10)
				public void Click_On_Reshedule_Appointment() throws InterruptedException {

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
					        Thread.sleep(1000);
					        WebElement YES = driver.findElement(By.xpath("(//*[@value=\"yes\"])[2]"));
					        clickElementUsingJS(driver, YES);	
					        
					        // Click on 'Update Complaint Status'
					        WebElement Call_Me_Later = driver.findElement(By.xpath("//*[text()=\"Call Me Later\"]"));
					        Call_Me_Later.click();			        
					        Thread.sleep(1000);					       					        
					        WebElement Open_Calender = driver.findElement(By.xpath("//*[@aria-label=\"Open calendar\"]"));
					        Open_Calender.click();			       
					        current_date_picker();
					        Thread.sleep(1000);

					        WebElement Time_Picker = driver.findElement(By.xpath("//*[@class=\"ngx-material-timepicker-toggle\"]"));
					        clickElementUsingJS(driver, Time_Picker);
					        Thread.sleep(1000);

					        WebElement Select20 = driver.findElement(By.xpath("//*[text()=\" 20\"]"));
					        Select20.click();
					        Thread.sleep(1000);

					        WebElement OK = driver.findElement(By.xpath("//*[text()=\"Ok\"]"));
					        OK.click();
					        
					        Thread.sleep(1000); 
					        
					        WebElement Customer_VOC = driver.findElement(By.xpath("(//*[@id=\"exampleFormControlTextarea1\"])[1]"));
					        Customer_VOC.clear();
					       
					        Customer_VOC.sendKeys(Reg_NO);
					        Thread.sleep(1000);

					        WebElement CCE_Remarks = driver.findElement(By.xpath("(//*[@id=\"exampleFormControlTextarea1\"])[2]"));
					        CCE_Remarks.clear();
					        CCE_Remarks.sendKeys(Reg_NO);
					        Thread.sleep(1000);
					   
					        WebElement Submit2 = driver.findElement(By.xpath("//*[text()=\"Submit\"]"));
					        clickElementUsingJS(driver, Submit2);
					        
					        Thread.sleep(5000);
					        
					        WebElement Click_On_Today_Follwup = driver.findElement(By.xpath("//*[contains(text(),\" Today Followup\")]"));
					        clickElementUsingJS(driver, Click_On_Today_Follwup);
					        
					        Thread.sleep(1000);
					        WebElement Click_On_Search_Button = driver.findElement(By.cssSelector("[data-placeholder=\"Search..\"]"));
					        Click_On_Search_Button.sendKeys(Reg_NO);
					        Thread.sleep(1000);
					        WebElement CCE_Remark = driver.findElement(By.xpath("(//*[@mattooltipposition=\"above\"])[5]"));

							  CCERemark  = CCE_Remark.getText();
						       Thread.sleep(2000);
						     // Split the text by newline and take the first part
						       CCERemark = CCERemark.split("\n")[0];
						        System.out.println("CCERemark::" + CCERemark);
						        
						        Assert.assertEquals(CCERemark, Reg_NO, " Call me later  , Customer is not in Today followup ");
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
		//.............................................................
				//Helper method to click on a button or tab based on its visible text
				private void clickOnTab(String tabName) throws InterruptedException {
					wait = new WebDriverWait(driver, Duration.ofSeconds(15));
					WebElement tab = wait.until(
							ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),\"" + tabName + "\")]")));
			
					tab.click();
					Thread.sleep(5000);
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





