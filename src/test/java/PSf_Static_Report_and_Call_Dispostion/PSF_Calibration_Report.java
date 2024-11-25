package PSf_Static_Report_and_Call_Dispostion;

import java.time.Duration;
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

public class PSF_Calibration_Report extends LOGINs {

	public static WebDriver driver;
	public WebDriverWait wait;
	  String d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13,d14,
      d15,d16,d17,d18,d19,d20,d21,d22,d23,d24;
       String w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11, 
      w12, w13, w14,w15,w16,w17,w18,w19,w20,w21,w22,w23,w24;
     String day1, day2, day3, day4, day5, day6, day7, day8, day9, 
       day10, day11, day12, day13, day14,day15,day16,day17,day18,day19,day20,day21,day22,day23,day24;
     String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14,s15,
      s16,s17,s18,s19,s20,s21,s22,s23,s24;
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
	 	public void Click_On_PSF_Calibration_Report() throws InterruptedException {
	 		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 		WebElement PSF_Calibration = wait.until(
	 				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"PSF Calibration Report \"]")));
	 		clickElementUsingJS(driver, PSF_Calibration);
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
           
 	 		 WebElement select_Dealer_Channel = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@role=\"combobox\"])[3]")));
  	        select_Dealer_Channel.click();
  	        Thread.sleep(500);
  	        
  	        WebElement Select_ALL3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class=\"mat-option-text\"])[1]")));
  	        Select_ALL3.click();
  	        Thread.sleep(500);
  	        
  	        WebElement select_service_Type = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@role=\"combobox\"])[4]")));
  	       Actions actions = new Actions(driver);      
 	        actions.doubleClick(select_service_Type).perform();
  	        
  	        Thread.sleep(500);
  	        
  	        WebElement Select_ALL4 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class=\"mat-option-text\"])[1]")));
  	        Select_ALL4.click();
  	        Thread.sleep(500);
 	 		
  	        WebElement Generate = wait.until(
	 				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
	        actions.doubleClick(Generate).perform();
	 		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));	 		
	     
	 	// Proceed with the rest of your element locators and text retrievals
 	 		WebElement Total_PSF_Due = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));

 	 		WebElement Total_Done = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
 	 		WebElement Done_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
 	 		WebElement Psf_Calibration_To_Be_done = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
 	 		WebElement Psf_Calibration_E_V_G = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
 	 		WebElement Total_Calibration_Done = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
 	 		WebElement Total_Calibration_Done_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
 	 		WebElement PSF_Closed = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[12]"));
 	 		WebElement PSF_Closed_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[13]"));
 	 		WebElement Complaint_Opened = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[14]"));
 	 		WebElement Complaint_Opened_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[15]"));
 	 		WebElement Whatssp_Sent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[16]"));
 	 		WebElement Done_By_KARA = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[17]"));
 	 		WebElement Percent_By_KARA = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[18]"));
 	 		WebElement PSF_Closed2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[19]"));
 	 		
 	 		WebElement Percent_PSF_Closed2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[20]"));
 	 		WebElement complaint_Opened2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[21]"));
 	 		WebElement complaint_Opened_Percent2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[22]"));
 	 		WebElement Done_by_CCE_CCM = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[23]"));
 	 		WebElement Percent_by_CCE_CCM = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[24]"));
 	 		WebElement PSF_Closed3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[25]"));
 	 		WebElement Percent_PSF_Closed3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[26]"));
 	 		WebElement complaint_Opened3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[27]"));
 	 		WebElement complaint_Opened_Percent3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[28]"));
 	 		
 	 		Thread.sleep(2000);
 	 		w1  =Total_PSF_Due.getText();
 	 		w2 = Total_Done.getText();
 	 		w3 = Done_Percent.getText();
 	 		w4 = Psf_Calibration_To_Be_done.getText();
 	 		w5 = Psf_Calibration_E_V_G.getText();
 	 		w6 = Total_Calibration_Done.getText();
 	 		w7 = Total_Calibration_Done_Percent.getText();
 	 		w8 = PSF_Closed.getText();
 	 		w9 = PSF_Closed_Percent.getText();
 	 		w10 = Complaint_Opened.getText();
 	 		w11 = Complaint_Opened_Percent.getText();
 	 		w12 = Whatssp_Sent.getText();
 	 		w13 = Done_By_KARA.getText(); 	 		
 	 		w14 = Percent_By_KARA.getText();
 	 		w15 = PSF_Closed2.getText();
 	 		
 	 		w16 = Percent_PSF_Closed2.getText();
 	 		w17 = complaint_Opened2.getText();
 	 		w18 = complaint_Opened_Percent2.getText();
 	 		w19 = Done_by_CCE_CCM.getText();
 	 		w20 = Percent_by_CCE_CCM.getText();
 	 		w21 = PSF_Closed3.getText();
 	 		w22 = Percent_PSF_Closed3.getText(); 	 		
 	 		w23 = complaint_Opened3.getText();
 	 		w24 = complaint_Opened_Percent3.getText(); 
 	 		 
 	 		Thread.sleep(1000);

  	        try {
  	        	 // Parse the 'Total Leads Recieved' value to a numeric type
  	            Integer TotalLeadRecieved = Integer.parseInt( w1);

  	            if (TotalLeadRecieved <= 0 || w1 == null) {
  	                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
  	                Assert.fail("No Data Found for Workshop_Wise In PSF_Calibration_Reoport : " +  w1);
  	            } else {
  	                // Print the 'Total Leads Recieved' value
  	                System.out.println("'Total_PSF_Due of Workshop_Wise Wise Tab In PSF_Calibration_Reoport::: " + w1);
  	            }

  	        } catch (Exception e) {
  	            // Fail the test if an exception is thrown
  	            Assert.fail("No Data Found for Workshop_Wise Tab In PSF_Calibration_Reoport " + e.getMessage());
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
 	 		WebElement Total_PSF_Due = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));

 	 		WebElement Total_Done = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
 	 		WebElement Done_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
 	 		WebElement Psf_Calibration_To_Be_done = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
 	 		WebElement Psf_Calibration_E_V_G = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
 	 		WebElement Total_Calibration_Done = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
 	 		WebElement Total_Calibration_Done_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
 	 		WebElement PSF_Closed = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
 	 		WebElement PSF_Closed_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
 	 		WebElement Complaint_Opened = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
 	 		WebElement Complaint_Opened_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[12]"));
 	 		WebElement Whatssp_Sent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[13]"));
 	 		WebElement Done_By_KARA = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[14]"));
 	 		WebElement Percent_By_KARA = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[15]"));
 	 		WebElement PSF_Closed2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[16]"));
 	 		
 	 		WebElement Percent_PSF_Closed2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[17]"));
 	 		WebElement complaint_Opened2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[18]"));
 	 		WebElement complaint_Opened_Percent2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[19]"));
 	 		WebElement Done_by_CCE_CCM = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[20]"));
 	 		WebElement Percent_by_CCE_CCM = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[21]"));
 	 		WebElement PSF_Closed3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[22]"));
 	 		WebElement Percent_PSF_Closed3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[23]"));
 	 		WebElement complaint_Opened3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[24]"));
 	 		WebElement complaint_Opened_Percent3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[25]"));
 	 		
 	 		Thread.sleep(2000);
 	 		day1  =Total_PSF_Due.getText();
 	 		day2 = Total_Done.getText();
 	 		day13 = Done_Percent.getText();
 	 		day14 = Psf_Calibration_To_Be_done.getText();
 	 		day15 = Psf_Calibration_E_V_G.getText();
 	 		day16 = Total_Calibration_Done.getText();
 	 		day17 = Total_Calibration_Done_Percent.getText();
 	 		day18 = PSF_Closed.getText();
 	 		day19 = PSF_Closed_Percent.getText();
 	 		day10 = Complaint_Opened.getText();
 	 		day11 = Complaint_Opened_Percent.getText();
 	 		day12 = Whatssp_Sent.getText();
 	 		day13 = Done_By_KARA.getText(); 	 		
 	 		day14 = Percent_By_KARA.getText();
 	 		day15 = PSF_Closed2.getText();
 	 		
 	 		day16 = Percent_PSF_Closed2.getText();
 	 		day17 = complaint_Opened2.getText();
 	 		day18 = complaint_Opened_Percent2.getText();
 	 		day19 = Done_by_CCE_CCM.getText();
 	 		day20 = Percent_by_CCE_CCM.getText();
 	 		day21 = PSF_Closed3.getText();
 	 		day22 = Percent_PSF_Closed3.getText(); 	 		
 	 		day23= complaint_Opened3.getText();
 	 		day24 = complaint_Opened_Percent3.getText(); 
 	 		 
 	 		Thread.sleep(1000);

  	        try {
  	        	 // Parse the 'Total Leads Recieved' value to a numeric type
  	            Integer TotalLeadRecieved = Integer.parseInt( day1);

  	            if (TotalLeadRecieved <= 0 || day1 == null) {
  	                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
  	                Assert.fail("No Data Found for Day_Wise In PSF_Calibration_Reoport : " +  day1);
  	            } else {
  	                // Print the 'Total Leads Recieved' value
  	                System.out.println("'Total_PSF_Due of Day_Wise Wise Tab In PSF_Calibration_Reoport::: " + day1);
  	            }

  	        } catch (Exception e) {
  	            // Fail the test if an exception is thrown
  	            Assert.fail("No Data Found for Day_Wise Tab In PSF_Calibration_Reoport " + e.getMessage());
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
 	 		WebElement Total_PSF_Due = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));

 	 		WebElement Total_Done = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
 	 		WebElement Done_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
 	 		WebElement Psf_Calibration_To_Be_done = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
 	 		WebElement Psf_Calibration_E_V_G = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
 	 		WebElement Total_Calibration_Done = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
 	 		WebElement Total_Calibration_Done_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
 	 		WebElement PSF_Closed = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
 	 		WebElement PSF_Closed_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
 	 		WebElement Complaint_Opened = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
 	 		WebElement Complaint_Opened_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[12]"));
 	 		WebElement Whatssp_Sent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[13]"));
 	 		WebElement Done_By_KARA = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[14]"));
 	 		WebElement Percent_By_KARA = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[15]"));
 	 		WebElement PSF_Closed2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[16]"));
 	 		
 	 		WebElement Percent_PSF_Closed2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[17]"));
 	 		WebElement complaint_Opened2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[18]"));
 	 		WebElement complaint_Opened_Percent2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[19]"));
 	 		WebElement Done_by_CCE_CCM = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[20]"));
 	 		WebElement Percent_by_CCE_CCM = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[21]"));
 	 		WebElement PSF_Closed3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[22]"));
 	 		WebElement Percent_PSF_Closed3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[23]"));
 	 		WebElement complaint_Opened3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[24]"));
 	 		WebElement complaint_Opened_Percent3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[25]"));
 
 	 		Thread.sleep(2000);
 	 		s1  =Total_PSF_Due.getText();
 	 		s2 = Total_Done.getText();
 	 		s3 = Done_Percent.getText();
 	 		s4 = Psf_Calibration_To_Be_done.getText();
 	 		s5 = Psf_Calibration_E_V_G.getText();
 	 		s6 = Total_Calibration_Done.getText();
 	 		s7 = Total_Calibration_Done_Percent.getText();
 	 		s8 = PSF_Closed.getText();
 	 		s9 = PSF_Closed_Percent.getText();
 	 		s10 = Complaint_Opened.getText();
 	 		s11 = Complaint_Opened_Percent.getText();
 	 		s12 = Whatssp_Sent.getText();
 	 		s13 = Done_By_KARA.getText(); 	 		
 	 		s14 = Percent_By_KARA.getText();
 	 		s15 = PSF_Closed2.getText();
 	 	
 	 		s16 = Percent_PSF_Closed2.getText();
 	 		s17 = complaint_Opened2.getText();
 	 		s18 = complaint_Opened_Percent2.getText();
 	 		s19 = Done_by_CCE_CCM.getText();
 	 		s20 = Percent_by_CCE_CCM.getText();
 	 		s21 = PSF_Closed3.getText();
 	 		s22 = Percent_PSF_Closed3.getText(); 	 		
 	 		s23 = complaint_Opened3.getText();
 	 		s24 = complaint_Opened_Percent3.getText(); 
 	 		 
 	 		Thread.sleep(1000);


  	        try {
  	        	 // Parse the 'Total Leads Recieved' value to a numeric type
  	            Integer TotalLeadRecieved = Integer.parseInt( s1);

  	            if (TotalLeadRecieved <= 0 || s1 == null) {
  	                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
  	                Assert.fail("No Data Found for Service_Type_Wise In PSF_Due_Analysis : " +  s1);
  	            } else {
  	                // Print the 'Total Leads Recieved' value
  	                System.out.println("'Total_Psf_Due of Service_Type_Wise  Tab In PSF_Due_Analysis::: " + s1);
  	            }

  	        } catch (Exception e) {
  	            // Fail the test if an exception is thrown
  	            Assert.fail("No Data Found for Service_Type_Wise Tab In PSF_Due_Analysis " + e.getMessage());
  	        }
  	    }
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	   
 	    
 	    @Test(priority = 15)
 	    public void Comparison_0f_all_Data() throws InterruptedException {
 	    	    		    	
 	    	String[] workshopWise = {w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11, 
 	    	                         w12, w13,w14,w15,w16,w17,w18,w19,w20,w21,w22,w23,w24};
 	    	String[] dayWise = {day1, day2, day3, day4, day5, day6, day7, day8, day9, 
 	                            day10, day11, day12, day13,day14, day15,day16,day17,day18,day19
 	                           ,day20,day21,day22,day23,day24};
 	    	String[] Service_TypeWise = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15,
 	    			s16, s17, s18, s19, s20, s21, s22, s23, s24};
 	    	
 	    	String[] comparisonLabels = {
 	    			 	    			
 	     	    "Total_PSF_Due", "Total_Done", "Done_Percent", "Psf_Calibration_To_Be_done", 
 	    	    "Psf_Calibration_E_V_G", "Total_Calibration_Done", "Total_Calibration_Done_Percent", "PSF_Closed", 
 	    	    "PSF_Closed_Percent", "Complaint_Opened", "Complaint_Opened_Percent",  "Whatssp_Sent",
 	    	    "Done_By_KARA","Percent_By_KARA", 	"PSF_Closed2",
 	    	    
 	    	   "Percent_PSF_Closed2", "complaint_Opened2", "complaint_Opened_Percent2", 
	    	    "Done_by_CCE_CCM", "Percent_by_CCE_CCM", "PSF_Closed3",  "Percent_PSF_Closed3",
	    	    "complaint_Opened3","complaint_Opened_Percent3"
 	    	    
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
