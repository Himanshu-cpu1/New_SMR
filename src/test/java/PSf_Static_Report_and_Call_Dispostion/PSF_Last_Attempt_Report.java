package PSf_Static_Report_and_Call_Dispostion;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
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

public class PSF_Last_Attempt_Report extends  LOGINs {

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
     public void PSF() throws InterruptedException {
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
	 	public void Click_On_Last_Attempt_Report() throws InterruptedException {
	 		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 		WebElement Last = wait.until(
	 				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Last Attempt Report \"]")));
	 		clickElementUsingJS(driver, Last);
	 		Thread.sleep(3000);
	 		
	 	}
	 // ..............................................................................................................
	 	 	@Test(priority = 10)
	 	 	public void Click_On_Generate() throws InterruptedException {
	 	 		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	 		WebElement Generate = wait.until(
		 				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Generate \"]")));
	 	 		Generate.click();
	 	 		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));
	 	 		
	 	 	}
	 	// ..............................................................................................................
	 	 	@Test(priority = 11)
	 	 	public void Click_On_Workshop() throws InterruptedException {
	 	 		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	 	// Proceed with the rest of your element locators and text retrievals
	 	 		WebElement Total_Dispostion = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));

	 	 		WebElement PSF_Done = driver
	 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
	 	 		WebElement Satisfied_rating = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
	 	 		WebElement DiSatisfied_rating = driver
	 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
	 	 		WebElement Call_meLater = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
	 	 		WebElement Not_Intrested_Providing_Feedback = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
	 	 		WebElement wrong_Number = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
	 	 		WebElement Call_Not_Connected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
	 	 		WebElement Psf_Calibration_done = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
	 	 		WebElement complaint_Status_Updated = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
	 	 		WebElement Appointmnet_Reschedule = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[12]"));
	 	 		WebElement Psf_Done = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[13]"));
	 	 		WebElement Adhoc_Complaints = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[14]"));

	 	 		Thread.sleep(2000);
	 	 		w1  =Total_Dispostion.getText();
	 	 		w2 = PSF_Done.getText();
	 	 		w3 = Satisfied_rating.getText();
	 	 		w4 = DiSatisfied_rating.getText();
	 	 		w5 = Call_meLater.getText();
	 	 		w6 = Not_Intrested_Providing_Feedback.getText();
	 	 		w7 = wrong_Number.getText();
	 	 		w8 = Call_Not_Connected.getText();
	 	 		w9 = Psf_Calibration_done.getText();
	 	 		w10 = complaint_Status_Updated.getText();
	 	 		w11 = Appointmnet_Reschedule.getText();
	 	 		w12 = Psf_Done.getText();
	 	 		w13 = Adhoc_Complaints.getText();
	 	 		
	 	 		 Thread.sleep(1000);

	  	        try {
	  	        	 // Parse the 'Total Leads Recieved' value to a numeric type
	  	            Integer TotalLeadRecieved = Integer.parseInt( w1);

	  	            if (TotalLeadRecieved <= 0 || w1 == null) {
	  	                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
	  	                Assert.fail("No Data Found for Workshop_Wise In Last_Attempt_Report : " +  w1);
	  	            } else {
	  	                // Print the 'Total Leads Recieved' value
	  	                System.out.println("'Total_Dispostion of Workshop_Wise Wise Tab In Last_Attempt_Report::: " + w1);
	  	            }

	  	        } catch (Exception e) {
	  	            // Fail the test if an exception is thrown
	  	            Assert.fail("No Data Found for Workshop_Wise Tab In Last_Attempt_Report " + e.getMessage());
	  	        }
	  	    }
	 	 		
	 	// ..............................................................................................................
	 	 	@Test(priority = 12)
	 	 	public void Click_On_DayWise() throws InterruptedException {
	 	 		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	 		WebElement Day_Wise = wait
	 					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Day Wise \"]")));
	 			Day_Wise.click();
	 			Thread.sleep(2000);	 	 		
	 	 		WebElement Generate = wait.until(
		 				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Generate \"]")));
	 	 		Generate.click();
	 	 		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

	 	 		
	 	 	// Proceed with the rest of your element locators and text retrievals
	 	 		WebElement Total_Dispostion = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));

	 	 		WebElement PSF_Done = driver
	 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
	 	 		WebElement Satisfied_rating = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
	 	 		WebElement DiSatisfied_rating = driver
	 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
	 	 		WebElement Call_meLater = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
	 	 		WebElement Not_Intrested_Providing_Feedback = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
	 	 		WebElement wrong_Number = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
	 	 		WebElement Call_Not_Connected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
	 	 		WebElement Psf_Calibration_done = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
	 	 		WebElement complaint_Status_Updated = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
	 	 		WebElement Appointmnet_Reschedule = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[12]"));
	 	 		WebElement Psf_Done = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[13]"));
	 	 		WebElement Adhoc_Complaints = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[14]"));

	 	 		Thread.sleep(2000);
	 	 		day1  =Total_Dispostion.getText();
	 	 		day2 = PSF_Done.getText();
	 	 		day3 = Satisfied_rating.getText();
	 	 		day4 = DiSatisfied_rating.getText();
	 	 		day5 = Call_meLater.getText();
	 	 		day6 = Not_Intrested_Providing_Feedback.getText();
	 	 		day7 = wrong_Number.getText();
	 	 		day8 = Call_Not_Connected.getText();
	 	 		day9 = Psf_Calibration_done.getText();
	 	 		day10 = complaint_Status_Updated.getText();
	 	 		day11 = Appointmnet_Reschedule.getText();
	 	 		day12 = Psf_Done.getText();
	 	 		day13 = Adhoc_Complaints.getText();
	 	 		
	 	 		 Thread.sleep(1000);

	  	        try {
	  	        	 // Parse the 'Total Leads Recieved' value to a numeric type
	  	            Integer TotalLeadRecieved = Integer.parseInt( day1);

	  	            if (TotalLeadRecieved <= 0 || day1 == null) {
	  	                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
	  	                Assert.fail("No Data Found for Day Wise In Last_Attempt_Report : " +  day1);
	  	            } else {
	  	                // Print the 'Total Leads Recieved' value
	  	                System.out.println("'Total_Dispostion of Day Wise Tab In Last_Attempt_Report::: " + day1);
	  	            }

	  	        } catch (Exception e) {
	  	            // Fail the test if an exception is thrown
	  	            Assert.fail("No Data Found for Day Wise Tab In Last_Attempt_Report " + e.getMessage());
	  	        }
	  	    }
	 	// ..............................................................................................................
	 	 	@Test(priority = 12)
	 	 	public void Click_On_Service_Type_Wise() throws InterruptedException {
	 	 		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 	 		WebElement Service_Type_Wise = wait
	 					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Service Type Wise \"]")));
	 			Service_Type_Wise.click();
	 			Thread.sleep(2000);	 	 		
	 	 		WebElement Generate = wait.until(
		 				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Generate \"]")));
	 	 		Generate.click();
	 	 		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

	 	 		
	 	 	// Proceed with the rest of your element locators and text retrievals
	 	 		WebElement Total_Dispostion = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));

	 	 		WebElement PSF_Done = driver
	 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
	 	 		WebElement Satisfied_rating = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
	 	 		WebElement DiSatisfied_rating = driver
	 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
	 	 		WebElement Call_meLater = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
	 	 		WebElement Not_Intrested_Providing_Feedback = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
	 	 		WebElement wrong_Number = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
	 	 		WebElement Call_Not_Connected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
	 	 		WebElement Psf_Calibration_done = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
	 	 		WebElement complaint_Status_Updated = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
	 	 		WebElement Appointmnet_Reschedule = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[12]"));
	 	 		WebElement Psf_Done = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[13]"));
	 	 		WebElement Adhoc_Complaints = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[14]"));

	 	 		Thread.sleep(2000);
	 	 		s1  =Total_Dispostion.getText();
	 	 		s2 = PSF_Done.getText();
	 	 		s3 = Satisfied_rating.getText();
	 	 		s4 = DiSatisfied_rating.getText();
	 	 		s5 = Call_meLater.getText();
	 	 		s6 = Not_Intrested_Providing_Feedback.getText();
	 	 		s7 = wrong_Number.getText();
	 	 		s8 = Call_Not_Connected.getText();
	 	 		s9 = Psf_Calibration_done.getText();
	 	 		
	 	 		s10 = complaint_Status_Updated.getText();
	 	 		s11 = Appointmnet_Reschedule.getText();
	 	 		s12 = Psf_Done.getText();
	 	 		s13 = Adhoc_Complaints.getText();
	 	 		
	 	 		 Thread.sleep(1000);

	  	        try {
	  	        	 // Parse the 'Total Leads Recieved' value to a numeric type
	  	            Integer TotalLeadRecieved = Integer.parseInt( s1);

	  	            if (TotalLeadRecieved <= 0 || s1 == null) {
	  	                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
	  	                Assert.fail("No Data Found for Service_Type_Wise In Last_Attempt_Report : " +  s1);
	  	            } else {
	  	                // Print the 'Total Leads Recieved' value
	  	                System.out.println("'Total_Dispostion of Service_Type_Wise Tab In Last_Attempt_Report::: " + s1);
	  	            }

	  	        } catch (Exception e) {
	  	            // Fail the test if an exception is thrown
	  	            Assert.fail("No Data Found for Service_Type_Wise Tab In Last_Attempt_Report " + e.getMessage());
	  	        }
	  	    }
	 	 //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	   
	 	    
	 	 	@Test(priority = 15)
	 	 	public void Comparison_0f_all_Data() throws InterruptedException {

	 	 	    String[] workshopWise = {w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11, w12, w13};
	 	 	    String[] dayWise = {day1, day2, day3, day4, day5, day6, day7, day8, day9, day10, day11, day12, day13};
	 	 	    String[] Service_TypeWise = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13};

	 	 	    String[] comparisonLabels = {
	 	 	        "Total_Disposition", "PSF_Done", "Satisfied_rating", "DiSatisfied_rating",
	 	 	        "Call_meLater", "Not_Intrested_Providing_Feedback", "wrong_Number", "Call_Not_Connected",
	 	 	        "Psf_Calibration_done", "complaint_Status_Updated", "Appointmnet_Reschedule",
	 	 	        "Psf_Done", "Adhoc_Complaints"
	 	 	        
	 	 	        
	 	 	        
	 	 	    };
	 	 	    
	 	 	    
	 	 	  System.out.println("workshopWise: " + Arrays.toString(workshopWise));
	 	 	  System.out.println("dayWise: " + Arrays.toString(dayWise));
	 	 	  System.out.println("Service_TypeWise: " + Arrays.toString(Service_TypeWise));

	 	 	    StringBuilder errorMessages = new StringBuilder(); // Collect all errors

	 	 	    for (int i = 0; i < workshopWise.length; i++) {
	 	 	        try {
	 	 	            Assert.assertEquals(workshopWise[i], dayWise[i], "Compare " + comparisonLabels[i] + "_of_workshopWise_With_dayWise");
	 	 	        } catch (AssertionError e) {
	 	 	            errorMessages.append(e.getMessage()).append("\n"); // Append error message
	 	 	        }

	 	 	        try {
	 	 	            Assert.assertEquals(workshopWise[i], Service_TypeWise[i], "Compare " + comparisonLabels[i] + "_of_workshopWise_With_Service_TypeWise");
	 	 	        } catch (AssertionError e) {
	 	 	            errorMessages.append(e.getMessage()).append("\n"); // Append error message
	 	 	        }
	 	 	    }

	 	 	    // If there are errors, fail the test with all collected messages
	 	 	    if (errorMessages.length() > 0) {
	 	 	        Assert.fail("Comparison failed with the following errors:\n" + errorMessages.toString());
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
