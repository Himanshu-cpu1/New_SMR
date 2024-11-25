package PSF_CAll_Dispostion;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Call_me_Later_for_Service_Rating {
	String customerFullName;
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
		Username.sendKeys("081001CCM00001");
		Thread.sleep(1000);
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Test(priority = 2)
	public void Password() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement password = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id=\"mat-input-1\"]")));
		password.sendKeys("Maruti@1234");

		Thread.sleep(1000);
		WebElement login_Button = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[type=\"submit\"]")));
		login_Button.click();

	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	@Test(priority = 3)
	public void Captcha() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// .................Enter The Captcha
		// ..................................................................
		WebElement Image = driver.findElement(By.xpath("(//*[@type=\"text\"])[1]"));

		String S1 = Image.getAttribute("value");
		System.out.println("captcha ::" + S1);

		Thread.sleep(2000);
		WebElement captcha_field = driver.findElement(By.cssSelector("[placeholder=\"Enter the captcha..\"]"));
		captcha_field.sendKeys(S1);
	}

//.....................................................................................................

	@Test(priority = 4)
	public void SUBMIT_Button() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement Submit = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Submit\"]")));
		Submit.click();
		Thread.sleep(2000);
	}
//	// .....................................................................................................

	@Test(priority = 5)
	public void Click_On_PSF() throws InterruptedException {

		WebElement PopUp = driver.findElement(By.xpath("(//*[@title=\"Close message\"])"));
		PopUp.click();
		Thread.sleep(1000);

		WebElement PSF = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//*[contains(text(),\"POST SERVICE FEEDBACK(PSF)\")]")));

		PSF.click();
		// Wait until the page or the expected content is fully loaded after clicking
		// (adjust the condition as needed)
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));
	}
	// .....................................................................................................

	@Test(priority = 7)
	public void Remove_PouP() throws InterruptedException {

		WebElement PopUp = driver.findElement(By.xpath("(//*[@title=\"Close message\"])"));
		PopUp.click();
		Thread.sleep(1000);

	}
	
	// .....................................................................................................

		@Test(priority = 10)
		public void PSF_Calibration_Due() throws InterruptedException {
			clickOnTab("PSF Calibration Due");
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
				        
				        Thread.sleep(2000);
				        WebElement YES = driver.findElement(By.xpath("(//*[@value=\"yes\"])[2]"));
				        clickElementUsingJS(driver, YES);
				        Thread.sleep(1000);
				        WebElement Call_Me_Later = driver.findElement(By.xpath("//*[text()=\"Call Me Later\"]"));
				        clickElementUsingJS(driver, Call_Me_Later);
				        Thread.sleep(2000);
				         
				        WebElement date_Picker = driver.findElement(By.cssSelector("[aria-label='Open calendar']"));
						 clickElementUsingJS(driver, date_Picker);
				
				        current_date_picker();
				        
				        WebElement Time_Picker = driver.findElement(By.xpath("//*[@class=\"ngx-material-timepicker-toggle\"]"));
				        clickElementUsingJS(driver, Time_Picker);
				       
				        WebElement Select20 = driver.findElement(By.xpath("//*[text()=\" 20\"]"));
				        Select20.click();
				        
				        WebElement OK = driver.findElement(By.xpath("//*[text()=\"Ok\"]"));
				        OK.click();
				        
				        Thread.sleep(1000); 
				        WebElement customer_VOC = driver.findElement(By.xpath("(//*[@id=\"exampleFormControlTextarea1\"])[1]"));
				        customer_VOC.sendKeys(Reg_NO);			        
				        
				        WebElement CcE_Remarks = driver.findElement(By.xpath("(//*[@id=\"exampleFormControlTextarea1\"])[2]"));
				        CcE_Remarks.sendKeys(Reg_NO);			        
				        
				        WebElement Submit = driver.findElement(By.xpath("//*[text()=\"Submit\"]"));
				        Submit.click();
				        Thread.sleep(1000);
				        Save_Succesfully("Call me later of Service Rating Save succesfully");
						wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));
				 				        
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

			//..........................................................................................
			
			}



