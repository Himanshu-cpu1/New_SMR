package PSf_Static_Report_and_Call_Dispostion;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Complaint_Report extends LOGINs {

	public static WebDriver driver;
	public WebDriverWait wait;
	  String d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13,d14,
      d15,d16,d17,d18,d19,d20,d21,d22,d23;
       String w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11, 
      w12, w13, w14,w15,w16,w17,w18,w19,w20,w21,w22,w23;
     String day1, day2, day3, day4, day5, day6, day7, day8, day9, 
       day10, day11, day12, day13, day14,day15,day16,day17,day18,day19,day20,day21,day22,day23;
     String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14,s15,
      s16,s17,s18,s19,s20,s21,s22,s23;
//   String SM1, SM2, SM3, SM4, SM5, SM6, SM7, SM8, SM9, SM10, SM11, SM12, SM13, SM14,SM15,SM16,SM17,SM18,SM19,SM20,SM21,SM22,SM23;

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
	  	public void Click_On_Static_Reports() throws InterruptedException {
	  					  		
	  		WebElement Static_Reports = wait
	  			    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Static Report \"]")));
	  			// Call the JavaScript Executor method instead of directly clicking
	  			clickElementUsingJS(driver, Static_Reports);
	            Thread.sleep(1000);
	  	}
	  	
	 // ..............................................................................................................
	 	@Test(priority = 9)
	 	public void Click_On_Complaint_Report() throws InterruptedException {
	 		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 		WebElement Complaint = wait.until(
	 				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Complaint Report \"]")));
	 		clickElementUsingJS(driver, Complaint);
	 		Thread.sleep(5000);
	 		
	 	}
	 // ..............................................................................................................
 	 	@Test(priority = 11)
 	 	public void Click_On_Workshop() throws InterruptedException {
 	 		Thread.sleep(3000);	 	
 	 		
 	 	// Open the calendar
	        WebElement openCalendar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label='Open calendar']")));
	        openCalendar.click();
	        Thread.sleep(2000);

	       
	 		WebElement Select1date = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class=\"mat-calendar-body-cell-container ng-star-inserted\"])[1]")));
	 		Select1date.click();
	       Thread.sleep(500);
	        
	        WebElement TodayDate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class=\"mat-calendar-body-cell-content mat-focus-indicator mat-calendar-body-today\"]")));
	       TodayDate.click();
           Thread.sleep(500);
 	 		WebElement Generate = wait.until(
	 				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
 	       Generate.click();
	 		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));	 		
 	        
 	 	// Proceed with the rest of your element locators and text retrievals
 	 		WebElement Total_complaints = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));

 	 		WebElement Adhoc_Complaints = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
 	 		WebElement post_Psf_Calibration = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
 	 		WebElement open = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
 	 		WebElement In_Progress = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
 	 		WebElement Resolved = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
 	 		WebElement Closed = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
 	 		WebElement OPEN2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
 	 		WebElement In_Progress2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
 	 		WebElement Resolved2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
 	 		WebElement Closed2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[12]"));
 	 		WebElement Open3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[13]"));
 	 		WebElement In_Progress3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[14]"));

 	 		WebElement Resolved3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[15]"));
 	 		WebElement Closed3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[16]"));
 	 		
 	 		Thread.sleep(2000);
 	 		w1  =Total_complaints.getText();
 	 		w2 = Adhoc_Complaints.getText();
 	 		w3 = post_Psf_Calibration.getText();
 	 		w4 = open.getText();
 	 		w5 = In_Progress.getText();
 	 		w6 = Resolved.getText();
 	 		w7 = Closed.getText();
 	 		w8 = OPEN2.getText();
 	 		w9 = In_Progress2.getText();
 	 		w10 = Resolved2.getText();
 	 		w11 = Closed2.getText();
 	 		w12 = Open3.getText();
 	 		w13 = In_Progress3.getText();
 	 		
 	 		w14 = Resolved3.getText();
 	 		w15 = Closed3.getText(); 	 			
 	 		 Thread.sleep(1000);

  	        try {
  	        	 // Parse the 'Total Leads Recieved' value to a numeric type
  	            Integer TotalLeadRecieved = Integer.parseInt( w1);

  	            if (TotalLeadRecieved <= 0 || w1 == null) {
  	                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
  	                Assert.fail("No Data Found for Workshop_Wise In Complaints_Reports : " +  w1);
  	            } else {
  	                // Print the 'Total Leads Recieved' value
  	                System.out.println("'Total_complaints of Workshop_Wise Wise Tab In Complaints_Reports::: " + w1);
  	            }

  	        } catch (Exception e) {
  	            // Fail the test if an exception is thrown
  	            Assert.fail("No Data Found for Workshop_Wise Tab In Complaints_Reports " + e.getMessage());
  	        }
  	    }
 	 	 // ..............................................................................................................
 	 	@Test(priority = 12)
 	 	public void Click_On_Day_Wise() throws InterruptedException {
 	 		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	 		 
 	 		WebElement Day_Wise = wait
 					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Day Wise \"]")));
 			Day_Wise.click();
 			Thread.sleep(2000);	
 	      
 	        WebElement Generate = wait.until(
	 				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
 	       Generate.click();
	 		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));	 		
 	               
 	 	// Proceed with the rest of your element locators and text retrievals
 	 		WebElement Total_complaints = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));

 	 		WebElement Adhoc_Complaints = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
 	 		WebElement post_Psf_Calibration = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
 	 		WebElement open = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
 	 		WebElement In_Progress = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
 	 		WebElement Resolved = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
 	 		WebElement Closed = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
 	 		WebElement OPEN2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
 	 		WebElement In_Progress2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
 	 		WebElement Resolved2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
 	 		WebElement Closed2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[12]"));
 	 		WebElement Open3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[13]"));
 	 		WebElement In_Progress3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[14]"));

 	 		WebElement Resolved3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[15]"));
 	 		WebElement Closed3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[16]"));
 	 		
 	 		Thread.sleep(2000);
 	 		day1  =Total_complaints.getText();
 	 		day2 = Adhoc_Complaints.getText();
 	 		day3 = post_Psf_Calibration.getText();
 	 		day4 = open.getText();
 	 		day5 = In_Progress.getText();
 	 		day6 = Resolved.getText();
 	 		day7 = Closed.getText();
 	 		day8 = OPEN2.getText();
 	 		day9 = In_Progress2.getText();
 	 		day10 = Resolved2.getText();
 	 		day11 = Closed2.getText();
 	 		day12 = Open3.getText();
 	 		day13 = In_Progress3.getText();
 	 		
 	 		day14 = Resolved3.getText();
 	 		day15 = Closed3.getText(); 	 			
 	 		 Thread.sleep(1000);

  	        try {
  	        	 // Parse the 'Total Leads Recieved' value to a numeric type
  	            Integer TotalLeadRecieved = Integer.parseInt( day1);

  	            if (TotalLeadRecieved <= 0 || day1 == null) {
  	                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
  	                Assert.fail("No Data Found for Day_Wise In Complaints_Reports : " +  day1);
  	            } else {
  	                // Print the 'Total Leads Recieved' value
  	                System.out.println("'Total_complaints of Day_Wise Wise Tab In Complaints_Reports::: " + day1);
  	            }

  	        } catch (Exception e) {
  	            // Fail the test if an exception is thrown
  	            Assert.fail("No Data Found for Day_Wise Tab In Complaints_Reports " + e.getMessage());
  	        }
  	    }
 	// ..............................................................................................................
 	 	@Test(priority = 13)
 	 	public void Click_On_Service_Type_Wise() throws InterruptedException {
 	 		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	 		WebElement Service_Type_Wise = wait
 					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Service Type Wise\"]")));
 			Service_Type_Wise.click();
 			Thread.sleep(2000);	 	 		
 	 		WebElement Generate = wait.until(
	 				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
 	 		Generate.click();
 	 		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));
  	               
 	 	// Proceed with the rest of your element locators and text retrievals
 	 		WebElement Total_complaints = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));

 	 		WebElement Adhoc_Complaints = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
 	 		WebElement post_Psf_Calibration = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
 	 		WebElement open = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
 	 		WebElement In_Progress = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
 	 		WebElement Resolved = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
 	 		WebElement Closed = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
 	 		WebElement OPEN2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
 	 		WebElement In_Progress2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
 	 		WebElement Resolved2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
 	 		WebElement Closed2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[12]"));
 	 		WebElement Open3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[13]"));
 	 		WebElement In_Progress3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[14]"));

 	 		WebElement Resolved3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[15]"));
 	 		WebElement Closed3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[16]"));
 	 		
 	 		Thread.sleep(2000);
 	 		s1  =Total_complaints.getText();
 	 		s2 = Adhoc_Complaints.getText();
 	 		s3 = post_Psf_Calibration.getText();
 	 		s4 = open.getText();
 	 		s5 = In_Progress.getText();
 	 		s6 = Resolved.getText();
 	 		s7 = Closed.getText();
 	 		s8 = OPEN2.getText();
 	 		s9 = In_Progress2.getText();
 	 		s10 = Resolved2.getText();
 	 		s11 = Closed2.getText();
 	 		s12 = Open3.getText();
 	 		s13 = In_Progress3.getText();
 	 	
 	 		s14 = Resolved3.getText();
 	 		s15 = Closed3.getText();	 			
 	 		Thread.sleep(1000);

  	        try {
  	        	 // Parse the 'Total Leads Recieved' value to a numeric type
  	            Integer TotalLeadRecieved = Integer.parseInt( s1);

  	            if (TotalLeadRecieved <= 0 || s1 == null) {
  	                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
  	                Assert.fail("No Data Found for Service_Type_Wise In Complaints_Reports : " +  s1);
  	            } else {
  	                // Print the 'Total Leads Recieved' value
  	                System.out.println("'Total_complaints of Service_Type_Wise Wise Tab In Complaints_Reports::: " + s1);
  	            }

  	        } catch (Exception e) {
  	            // Fail the test if an exception is thrown
  	            Assert.fail("No Data Found for Service_Type_Wise Tab In Complaints_Reports " + e.getMessage());
  	        }
  	    }
 	 	
 //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	   
 	    
 	    @Test(priority = 15)
 	    public void Comparison_0f_all_Data() throws InterruptedException {
 	    	    		    	
 	    	String[] workshopWise = {w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11, 
 	    	                         w12, w13,w14,w15};
 	    	String[] dayWise = {day1, day2, day3, day4, day5, day6, day7, day8, day9, 
 	                            day10, day11, day12, day13,day14, day15};
 	    	String[] Service_TypeWise = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15};
 	    	
 	    	String[] comparisonLabels = {
 	    			 	    			
 	    	    "Total_complaints", "Adhoc_Complaints", "post_Psf_Calibration", "open", 
 	    	    "In_Progress", "Resolved", "Closed", "OPEN2", 
 	    	    "In_Progress2", "Resolved2", "Closed2",  "Open3",
 	    	    "In_Progress3","Resolved3", 	"Closed3", 
 	    	    
 	    	};

 	    	for (int i = 0; i < workshopWise.length; i++) {
 	    	    Assert.assertEquals(workshopWise[i], dayWise[i], "Compare " + comparisonLabels[i] + "_of_workshopWise_With_dayWise");
 	    	    Assert.assertEquals(workshopWise[i], Service_TypeWise[i], "Compare " + comparisonLabels[i] + "_of_workshopWise_With_Service_TypeWise");
 	    	  
 	    	}
 	    } 	
 	 //.....................................................................................................

	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();  // Close the browser and end the WebDriver session
	        }
	    }
	 	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
	 	 //.....................Helper Method...........................................................................
	 			
	 		  	private void clickElementUsingJS(WebDriver driver, WebElement element) {
	 		  	    JavascriptExecutor js = (JavascriptExecutor) driver;
	 		  	    js.executeScript("arguments[0].click();", element);
	 		  	}
	 		
	 	}
