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

public class PRF_Report extends LOGINs {

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
	 	public void Click_On_PRF_Report() throws InterruptedException {
	 		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 		WebElement PRF_report = wait.until(
	 				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"PRF Report \"]")));
	 		clickElementUsingJS(driver, PRF_report);
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
 	 		WebElement Total_Complaints = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));

 	 		WebElement PRF_pending = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
 	 		WebElement PRF_pending_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
 	 		WebElement Complaints_closed = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
 	 		WebElement Complaints_closed_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
 	 		WebElement PRF_Whatssp_Sent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
 	 		WebElement Respsonse_recived = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
 	 		WebElement Percent_Respsonse_recived = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[12]"));
 	 		WebElement Complaints_reopened = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[13]"));
 	 		WebElement Complaints_reopened_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[14]"));
 	 		WebElement Complaints_closed2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[15]"));
 	 		WebElement Complaints_closed_Percent2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[16]"));
 	 		WebElement PRF_Done_By_CCE_CCM = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[17]"));
 	 		WebElement Percent_CCE_CCM = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[18]"));
 	 		WebElement Complaint_Re_Opened = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[19]"));
 	 		
 	 		WebElement Complaint_Re_Opened_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[20]"));
 	 		WebElement complaint_closed3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[21]"));
 	 		WebElement complaint_closed_Percent3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[22]"));
 	 				
 	 		Thread.sleep(2000);
 	 		w1  =Total_Complaints.getText();
 	 		w2 = PRF_pending.getText();
 	 		w3 = PRF_pending_Percent.getText();
 	 		w4 = Complaints_closed.getText();
 	 		w5 = Complaints_closed_Percent.getText();
 	 		w6 = PRF_Whatssp_Sent.getText();
 	 		w7 = Respsonse_recived.getText();
 	 		w8 = Percent_Respsonse_recived.getText();
 	 		w9 = Complaints_reopened.getText();
 	 		w10 = Complaints_reopened_Percent.getText();
 	 		w11 = Complaints_closed2.getText();
 	 		w12 = Complaints_closed_Percent2.getText();
 	 		w13 = PRF_Done_By_CCE_CCM.getText(); 	 		
 	 		w14 = Percent_CCE_CCM.getText();
 	 		w15 = Complaint_Re_Opened.getText();
 	 		
 	 		w16 = Complaint_Re_Opened_Percent.getText();
 	 		w17 = complaint_closed3.getText();
 	 		w18 = complaint_closed_Percent3.getText();
 	 		 
 	 		Thread.sleep(1000);

  	        try {
  	        	 // Parse the 'Total Leads Recieved' value to a numeric type
  	            Integer TotalLeadRecieved = Integer.parseInt( w1);

  	            if (TotalLeadRecieved <= 0 || w1 == null) {
  	                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
  	                Assert.fail("No Data Found for Workshop_Wise In PRF_Report : " +  w1);
  	            } else {
  	                // Print the 'Total Leads Recieved' value
  	                System.out.println("'Total_Complaints of Workshop_Wise Wise Tab In PRF_Report::: " + w1);
  	            }

  	        } catch (Exception e) {
  	            // Fail the test if an exception is thrown
  	            Assert.fail("No Data Found for Workshop_Wise Tab In PRF_Report " + e.getMessage());
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
 	 		WebElement Total_Complaints = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));

 	 		WebElement PRF_pending = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
 	 		WebElement PRF_pending_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
 	 		WebElement Complaints_closed = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
 	 		WebElement Complaints_closed_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
 	 		WebElement PRF_Whatssp_Sent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
 	 		WebElement Respsonse_recived = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
 	 		WebElement Percent_Respsonse_recived = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
 	 		WebElement Complaints_reopened = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
 	 		WebElement Complaints_reopened_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
 	 		WebElement Complaints_closed2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[12]"));
 	 		WebElement Complaints_closed_Percent2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[13]"));
 	 		WebElement PRF_Done_By_CCE_CCM = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[14]"));
 	 		WebElement Percent_CCE_CCM = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[15]"));
 	 		WebElement Complaint_Re_Opened = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[16]"));
 	 		
 	 		WebElement Complaint_Re_Opened_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[17]"));
 	 		WebElement complaint_closed3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[18]"));
 	 		WebElement complaint_closed_Percent3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[19]"));
 	 				
 	 		Thread.sleep(2000);
 	 		day1  =Total_Complaints.getText();
 	 		day2 = PRF_pending.getText();
 	 		day3 = PRF_pending_Percent.getText();
 	 		day4 = Complaints_closed.getText();
 	 		day5 = Complaints_closed_Percent.getText();
 	 		day6 = PRF_Whatssp_Sent.getText();
 	 		day7 = Respsonse_recived.getText();
 	 		day8 = Percent_Respsonse_recived.getText();
 	 		day9 = Complaints_reopened.getText();
 	 		day10 = Complaints_reopened_Percent.getText();
 	 		day11 = Complaints_closed2.getText();
 	 		day12 = Complaints_closed_Percent2.getText();
 	 		day13 = PRF_Done_By_CCE_CCM.getText(); 	 		
 	 		day14 = Percent_CCE_CCM.getText();
 	 		day15 = Complaint_Re_Opened.getText();
 	 		
 	 		day16 = Complaint_Re_Opened_Percent.getText();
 	 		day17 = complaint_closed3.getText();
 	 		day18 = complaint_closed_Percent3.getText();
 	 		 
 	 		Thread.sleep(1000);

  	        try {
  	        	 // Parse the 'Total Leads Recieved' value to a numeric type
  	            Integer TotalLeadRecieved = Integer.parseInt( day1);

  	            if (TotalLeadRecieved <= 0 || day1 == null) {
  	                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
  	                Assert.fail("No Data Found for Day_Wise In PRF_Report : " +  day1);
  	            } else {
  	                // Print the 'Total Leads Recieved' value
  	                System.out.println("'Total_Complaints of Day_Wise Wise Tab In PRF_Report::: " + day1);
  	            }

  	        } catch (Exception e) {
  	            // Fail the test if an exception is thrown
  	            Assert.fail("No Data Found for Day_Wise Tab In PRF_Report " + e.getMessage());
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
 	 		WebElement Total_Complaints = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));

 	 		WebElement PRF_pending = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
 	 		WebElement PRF_pending_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
 	 		WebElement Complaints_closed = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
 	 		WebElement Complaints_closed_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
 	 		WebElement PRF_Whatssp_Sent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
 	 		WebElement Respsonse_recived = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
 	 		WebElement Percent_Respsonse_recived = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
 	 		WebElement Complaints_reopened = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
 	 		WebElement Complaints_reopened_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
 	 		WebElement Complaints_closed2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[12]"));
 	 		WebElement Complaints_closed_Percent2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[13]"));
 	 		WebElement PRF_Done_By_CCE_CCM = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[14]"));
 	 		WebElement Percent_CCE_CCM = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[15]"));
 	 		WebElement Complaint_Re_Opened = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[16]"));
 	 		
 	 		WebElement Complaint_Re_Opened_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[17]"));
 	 		WebElement complaint_closed3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[18]"));
 	 		WebElement complaint_closed_Percent3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[19]"));
 	 				
 	 		Thread.sleep(2000);
 	 		s1  =Total_Complaints.getText();
 	 		s2 = PRF_pending.getText();
 	 		s3 = PRF_pending_Percent.getText();
 	 		s4 = Complaints_closed.getText();
 	 		s5 = Complaints_closed_Percent.getText();
 	 		s6 = PRF_Whatssp_Sent.getText();
 	 		s7 = Respsonse_recived.getText();
 	 		s8 = Percent_Respsonse_recived.getText();
 	 		s9 = Complaints_reopened.getText();
 	 		s10 = Complaints_reopened_Percent.getText();
 	 		s11 = Complaints_closed2.getText();
 	 		s12 = Complaints_closed_Percent2.getText();
 	 		s13 = PRF_Done_By_CCE_CCM.getText(); 	 		
 	 		s14 = Percent_CCE_CCM.getText();
 	 		s15 = Complaint_Re_Opened.getText();
 	 		
 	 		s16 = Complaint_Re_Opened_Percent.getText();
 	 		s17 = complaint_closed3.getText();
 	 		s18 = complaint_closed_Percent3.getText();    
 	 		 
 	 		Thread.sleep(1000);

  	        try {
  	        	 // Parse the 'Total Leads Recieved' value to a numeric type
  	            Integer TotalLeadRecieved = Integer.parseInt( s1);

  	            if (TotalLeadRecieved <= 0 || s1 == null) {
  	                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
  	                Assert.fail("No Data Found for Service_Type_Wise In PRF_Report : " +  s1);
  	            } else {
  	                // Print the 'Total Leads Recieved' value
  	                System.out.println("'Total_Complaints of Service_Type_Wise  Tab In PRF_Report::: " + s1);
  	            }

  	        } catch (Exception e) {
  	            // Fail the test if an exception is thrown
  	            Assert.fail("No Data Found for Service_Type_Wise Tab In PRF_Report " + e.getMessage());
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
 	    			 	    			
 	      		
 	     	    "Total_Complaints", "PRF_pending", "PRF_pending_Percent", "Complaints_closed", 
 	    	    "Complaints_closed_Percent", "PRF_Whatssp_Sent", "Respsonse_recived", "Percent_Respsonse_recived", 
 	    	    "Complaints_reopened", "Complaints_reopened_Percent", "Complaints_closed2",  "Complaints_closed_Percent2",
 	    	    "PRF_Done_By_CCE_CCM","Percent_CCE_CCM", 	"Complaint_Re_Opened", "Complaint_Re_Opened_Percent",
 	    	    
 	    	   "complaint_closed3", "complaint_closed_Percent3", 
	    	   
 	    	};

 	    	 for (int i = 0; i < workshopWise.length; i++) {
  	            // Normalize by removing spaces
  	            String normalizedWorkshopWise = workshopWise[i].replace(" ", "").trim();
  	            String normalizedDayWise = dayWise[i].replace(" ", "").trim();
  	            String normalizedServiceTypeWise = Service_TypeWise[i].replace(" ", "").trim();

  	            // Compare normalized values
  	            Assert.assertEquals(normalizedWorkshopWise, normalizedDayWise, 
  	                "Compare " + comparisonLabels[i] + "_of_workshopWise_With_dayWise");
  	            Assert.assertEquals(normalizedWorkshopWise, normalizedServiceTypeWise, 
  	                "Compare " + comparisonLabels[i] + "_of_workshopWise_With_Service_TypeWise");
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
