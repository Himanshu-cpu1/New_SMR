package cCM_Reports;

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

public class Auto_Dialer_report {
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
	        WebElement Username = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id=\"mat-input-0\"]")));
	        Username.sendKeys("081001CCM00001");
	        Thread.sleep(1000);
	    }

	    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	    @Test(priority = 2)
	    public void Password() throws InterruptedException {
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id=\"mat-input-1\"]")));
	        password.sendKeys("Maruti@1234");
	               
	          Thread.sleep(1000);		    	    
	        WebElement login_Button = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[type=\"submit\"]")));
	        login_Button.click();
	      
	    }

	    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

	    @Test(priority = 3)
	    public void Captcha() throws InterruptedException {
	        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        
	      //.................Enter The Captcha ..................................................................
	        WebElement Image = driver.findElement(By.xpath("(//*[@type=\"text\"])[1]"));
			
			String S1 = Image.getAttribute("value");
			System.out.println("captcha ::"+S1);
						
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
		//.....................................................................................................
	 
	  		@Test(priority = 5)
	  		public void Click_On_SMR() throws InterruptedException {
	  				  			
	  			 //close the pop up message first
	  			 WebElement PopUp= driver.findElement(By.xpath("(//*[@title=\"Close message\"])"));
	  			 PopUp.click();
	  		    Thread.sleep(1000);
	  			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		        WebElement SMR = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),\"SERVICE MARKETING REMINDER (SMR)\")]")));
		      
		        SMR.click();
	  			 // Wait until the page or the expected content is fully loaded after clicking (adjust the condition as needed)
	  		    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));
	  		}
	  
	  	// .....................................................................................................

	  	@Test(priority = 7)
	  	public void Click_Reports() throws InterruptedException {
	  					  		
	  		WebElement Reports = wait
	  			    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Reports \"]")));
	  			// Call the JavaScript Executor method instead of directly clicking
	  			clickElementUsingJS(driver, Reports);
	            Thread.sleep(1000);
	  	}
	  	 	
		//.................................Navigate To Auto Dialer Report.................................................................
	 	   @Test(priority = 8)
	 	   public void Click_On_AutoDialer_REPORT() throws InterruptedException {
	 	   wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	   WebElement AutoDialer = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Auto Dialer Report \"]")));
	 	  clickElementUsingJS(driver, AutoDialer);
	  		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

	 				
	 }
	 	//................clcik on the Delear parent ......................................................................................
		   @Test(priority = 9)
		   public void delaer_Parent_group_wise() throws InterruptedException {
		       wait = new WebDriverWait(driver, Duration.ofSeconds(10));		       		   		      
		       // Click on the generate report button
		       // Click on dropdown Marketing Campaign
		        WebElement Workshop = driver.findElement(By.xpath("(//*[@role=\"combobox\"])"));
		        Workshop.click();
		        Thread.sleep(1000);
		        // select Marketing Campaign
		        WebElement Select_all = driver.findElement(By.xpath("//*[text()=\"All\"]"));
		        Select_all.click();
		        Thread.sleep(1000);
		        
		        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));

		        Actions actions = new Actions(driver);
		        actions.doubleClick(clickOnGenerate).perform();

		        // JavaScript click
		        clickElementUsingJS(driver, clickOnGenerate);

		  		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

		   }
	  //...........................To Validate Data is available for Dealer Parent Group Wise tab..................................................................................................	   
		   @Test(priority = 10)
		   public void Data_Verification_Dealer_Parent_Group_Wise_Tab() throws InterruptedException {
			// Locate the column element using the provided XPath
			   List<WebElement> reportRows = driver.findElements(By.xpath("(//*[@role=\"table\"])[2]//tr"));
		       
			 // Check if the report contains data
			       if (reportRows.size() > 1) {
			           System.out.println("Dealer Parent Group Wise report contains data In Auto Dialer Report.."); // Message when data is present
			       }
			       
			       // Assert to fail the method if data is not present
			       Assert.assertTrue(reportRows.size() > 1, "The Dealer Parent Group Wise report does not contain any data  In Auto Dialer Report..");
			   }
		   //...........................To Validate Data is available for Dealer Parent Group Wise tab..................................................................................................	   
		   @Test(priority = 11)
		   public void Data_Verification_For_Workshop_Wise_Tab() throws InterruptedException {
			   WebElement Workshop_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Workshop Wise \"]")));
		 	      Workshop_Wise.click();
		 	     Thread.sleep(1000);
		 	     // Click on the generate report button
			      WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
			      clickOnGenerate.click();
			  		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

			  	// Verify if the report contains data
				       List<WebElement> reportRows = driver.findElements(By.xpath("(//*[@role=\"table\"])[3]//tr"));
				       
				       // Check if the report contains data
				       if (reportRows.size() > 1) {
				           System.out.println("Workshop Wise report contains data In Auto Dialer Report.."); // Message when data is present
				       }
				       
				       // Assert to fail the method if data is not present
				       Assert.assertTrue(reportRows.size() > 1, "The Workshop Wise report does not contain any data In Auto Dialer Report.In Auto Dialer Report..");
				   }
		   
//..........................To Validate if data is available for Day Wise tab..................................................................................................	   
	 	   
	 	   @Test(priority = 13)
	 	   public void Data_Verification_Day_Wise_Tab() throws InterruptedException {
	 		// Verify if the report contains data
	 		  WebElement Day_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Day Wise \"]")));
	 	       Day_Wise.click();
	 	       Thread.sleep(3000);
	 	       	 //Click on the generate report button
	 	       WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
	 	       clickOnGenerate.click();
		  		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

		       List<WebElement> reportRows = driver.findElements(By.xpath("(//*[@role=\"table\"])[4]//tr"));
		       
		       // Check if the report contains data
		       if (reportRows.size() > 1) {
		           System.out.println("Day Wise report contains data In Auto Dialer Report.."); // Message when data is present
		       }
		       
		       // Assert to fail the method if data is not present
		       Assert.assertTrue(reportRows.size() > 1, "The Day Wise report does not contain any data In Auto Dialer Report..");
		   }
//..........................To Validate if data is available for Day Wise tab..................................................................................................	   
	 	   
	 	   @Test(priority = 14)
	 	   public void Data_Verification_SMRE_Wise_Tab() throws InterruptedException {
	 		// Verify if the report contains data
	 		  WebElement SMRE_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),\" SMRE Wise \")]")));
	          SMRE_Wise.click();
	          Thread.sleep(2000);
	          WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
	          clickOnGenerate.click();
	      		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));      
	 		
		       List<WebElement> reportRows = driver.findElements(By.xpath("(//*[@role=\"table\"])[6]//tr"));
		       
		       // Check if the report contains data
		       if (reportRows.size() > 1) {
		           System.out.println("Smre Wise report contains data In Auto Dialer Report.."); // Message when data is present
		       }
		       
		       // Assert to fail the method if data is not present
		       Assert.assertTrue(reportRows.size() > 1, "The Smre Wise report does not contain any data In Auto Dialer Report..");
		   }
	 	   
	  //.....................Helper Method...........................................................................
		
	  	private void clickElementUsingJS(WebDriver driver, WebElement element) {
	  	    JavascriptExecutor js = (JavascriptExecutor) driver;
	  	    js.executeScript("arguments[0].click();", element);
	  	}
	 
	  }




