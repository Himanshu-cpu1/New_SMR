package Merge_PSF;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Not_Intrested_In_Providing_Feedback {
	String customerFullName;
	public static WebDriver driver;
	public WebDriverWait wait;

	@SuppressWarnings("static-access")
    @BeforeClass
    public void SMR() throws InterruptedException {
        // Initialize the driver (assuming it's static in the SMR_due_Datewise class)
        this.driver = Number_Busy_of_Service_Rating.driver;

     // Initialize WebDriverWait with a timeout of 10 seconds using Duration
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
	// .....................................................................................................

			@Test(priority = 10)
			public void Not_Intrested_Providing_Feedback() throws InterruptedException {				
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
				        
				        Thread.sleep(7000);
				        WebElement YES = driver.findElement(By.xpath("(//*[@value=\"yes\"])[2]"));
				        clickElementUsingJS(driver, YES);
				        Thread.sleep(1000);
				        WebElement clcik_Not_Intrested = driver.findElement(By.xpath("//*[text()=\"Not Interested in Providing Feedback\"]"));
				        clickElementUsingJS(driver, clcik_Not_Intrested);
				        Thread.sleep(1000);
				        
				        WebElement Customer_VOC = driver.findElement(By.xpath("(//*[@id=\"exampleFormControlTextarea1\"])[1]"));
				        Customer_VOC.sendKeys(Reg_NO);

				        WebElement CRE_Remark = driver.findElement(By.xpath("(//*[@id=\"exampleFormControlTextarea1\"])[2]"));
				        CRE_Remark.sendKeys(Reg_NO);
				        WebElement Submit = driver.findElement(By.xpath("//*[text()=\"Submit\"]"));
				        Submit.click();
				        Thread.sleep(3000);
				        Save_Succesfully("Not Intrested providing feedback  Save succesfully");
						wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));
			 			
						WebElement Click_On_Search_Button = driver.findElement(By.cssSelector("[data-placeholder=\"Search..\"]"));
				        Click_On_Search_Button.sendKeys(Reg_NO);
				        Thread.sleep(1000);  
						getAndClickFirstCustomer();
						Thread.sleep(2000);
						
						WebElement Intrection_History = driver.findElement(By.xpath("//*[text()=\"Interaction History\"]"));
				        clickElementUsingJS(driver, Intrection_History);	
				        Thread.sleep(1000);
				        
				        WebElement Click_On_View_Details = driver.findElement(By.xpath("//*[text()=\" View Details \"]"));
				        clickElementUsingJS(driver, Click_On_View_Details);	
				        Thread.sleep(1000);
				        
				        WebElement CCE_Remarks = driver.findElement(By.xpath("(//*[2]/span[3])[9]"));
				        String CCE =CCE_Remarks.getText();
				        System.out.println("CCE_Remarks  :: "  +  CCE);
				        
				        Thread.sleep(1000);
				        Assert.assertEquals(CCE, Reg_NO, "Not Intrested providing feedback will be not Showing  in Intrection history  ");
				        
				        Thread.sleep(2000);
				        WebElement Cross_Button = driver.findElement(By.xpath("//*[@id=\"Icon_ionic-ios-close\"]"));
				        Cross_Button.click();
				        Thread.sleep(2000);
				        Click_On_Search_Button.clear();
				        Thread.sleep(2000);
				        WebElement Arrow_back = driver.findElement(By.xpath("//*[text()=\"arrow_back\"]"));
				        Arrow_back.click();
				        Thread.sleep(2000);
				        driver.navigate().refresh();
						wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

				        
                  }
			
			
			
			// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
			
			//// .....................Helper Method...........................................................................
			public void setValueUsingJS(WebDriver driver, WebElement element, String value) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].value = arguments[1];", element, value);
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
		//.....................................................................
			private void clickElementUsingJS(WebDriver driver, WebElement element) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].click();", element);
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




