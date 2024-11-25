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

public class PSF_Due_Analysis extends   LOGINs{
	
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
	 	public void Click_On_PSF_Due_Analysis_Report() throws InterruptedException {
	 		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 		WebElement Last = wait.until(
	 				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"PSF Due Analysis Report \"]")));
	 		clickElementUsingJS(driver, Last);
	 		Thread.sleep(3000);
	 		
	 	}
	 	
	 // ..............................................................................................................
 	 	@Test(priority = 11)
 	 	public void Click_On_Workshop() throws InterruptedException {
 	 		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	 		 WebElement Select_Logic = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@role=\"combobox\"])[1]")));
 	 		Select_Logic.click();
 	        Thread.sleep(500);
 	        
 	        WebElement Select_JC_Bill_Date = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class=\"mat-option-text\"])[1]")));
 	        Select_JC_Bill_Date.click();
 	        Thread.sleep(500);
 	       
 	        WebElement Vehicle_Channel = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@role=\"combobox\"])[2]"))); 
 	        Vehicle_Channel.click();
 	        Thread.sleep(500);
 	        
 	        WebElement Select_ALL2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class=\"mat-option-text\"])[1]")));
 	        Select_ALL2.click();
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
 	 		WebElement Total_Psf_Due = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));

 	 		WebElement PSF_Done = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
 	 		WebElement PSF_Done_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
 	 		WebElement PSF_Done_By_Kara = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
 	 		WebElement PSF_Done_By_Kara_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
 	 		WebElement PSF_Done_By_AMIE = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
 	 		WebElement PSF_Done_By_AMIE_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
 	 		WebElement PSF_Done_By_CCE = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
 	 		WebElement PSF_Done_By_CCE_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
 	 		WebElement Satisfied_Rating = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
 	 		WebElement DiSatisfied_Rating = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[12]"));
 	 		WebElement Call_Me_Later = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[13]"));
 	 		WebElement Not_Intrested_Providing_Feedback = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[14]"));

 	 		WebElement Wrong_Number = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[15]"));
 	 		WebElement Call_Not_Connected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[16]"));
 	 		WebElement fresh = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[17]"));
 	 		WebElement pending_fresh = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[18]"));
 	 		WebElement Unallocated_area = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[19]"));

 	 		Thread.sleep(2000);
 	 		w1  =Total_Psf_Due.getText();
 	 		w2 = PSF_Done.getText();
 	 		w3 = PSF_Done_Percent.getText();
 	 		w4 = PSF_Done_By_Kara.getText();
 	 		w5 = PSF_Done_By_Kara_Percent.getText();
 	 		w6 = PSF_Done_By_AMIE.getText();
 	 		w7 = PSF_Done_By_AMIE_Percent.getText();
 	 		w8 = PSF_Done_By_CCE.getText();
 	 		w9 = PSF_Done_By_CCE_Percent.getText();
 	 		w10 = Satisfied_Rating.getText();
 	 		w11 = DiSatisfied_Rating.getText();
 	 		w12 = Call_Me_Later.getText();
 	 		w13 = Not_Intrested_Providing_Feedback.getText();
 	 		
 	 		w14 = Wrong_Number.getText();
 	 		w15 = Call_Not_Connected.getText();
 	 		w16 = fresh.getText();
 	 		w17 = pending_fresh.getText();
 	 		w18 = Unallocated_area.getText();
 	 		
 	 		 Thread.sleep(1000);

  	        try {
  	        	 // Parse the 'Total Leads Recieved' value to a numeric type
  	            Integer TotalLeadRecieved = Integer.parseInt( w1);

  	            if (TotalLeadRecieved <= 0 || w1 == null) {
  	                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
  	                Assert.fail("No Data Found for Workshop_Wise In PSF_Due_Analysis : " +  w1);
  	            } else {
  	                // Print the 'Total Leads Recieved' value
  	                System.out.println("'Total_Psf_Due of Workshop_Wise Wise Tab In PSF_Due_Analysis::: " + w1);
  	            }

  	        } catch (Exception e) {
  	            // Fail the test if an exception is thrown
  	            Assert.fail("No Data Found for Workshop_Wise Tab In PSF_Due_Analysis " + e.getMessage());
  	        }
  	    }
 	 	 // ..............................................................................................................
 	 	@Test(priority = 11)
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
 	 		WebElement Total_Psf_Due = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));

 	 		WebElement PSF_Done = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
 	 		WebElement PSF_Done_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
 	 		WebElement PSF_Done_By_Kara = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
 	 		WebElement PSF_Done_By_Kara_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
 	 		WebElement PSF_Done_By_AMIE = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
 	 		WebElement PSF_Done_By_AMIE_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
 	 		WebElement PSF_Done_By_CCE = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
 	 		WebElement PSF_Done_By_CCE_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
 	 		WebElement Satisfied_Rating = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
 	 		WebElement DiSatisfied_Rating = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[12]"));
 	 		WebElement Call_Me_Later = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[13]"));
 	 		WebElement Not_Intrested_Providing_Feedback = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[14]"));

 	 		WebElement Wrong_Number = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[15]"));
 	 		WebElement Call_Not_Connected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[16]"));
 	 		WebElement fresh = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[17]"));
 	 		WebElement pending_fresh = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[18]"));
 	 		WebElement Unallocated_area = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[19]"));

 	 		Thread.sleep(2000);
 	 		day1  =Total_Psf_Due.getText();
 	 		day2 = PSF_Done.getText();
 	 		day3 = PSF_Done_Percent.getText();
 	 		day4 = PSF_Done_By_Kara.getText();
 	 		day5 = PSF_Done_By_Kara_Percent.getText();
 	 		day6 = PSF_Done_By_AMIE.getText();
 	 		day7 = PSF_Done_By_AMIE_Percent.getText();
 	 		day8 = PSF_Done_By_CCE.getText();
 	 		day9 = PSF_Done_By_CCE_Percent.getText();
 	 		day10 = Satisfied_Rating.getText();
 	 		day11 = DiSatisfied_Rating.getText();
 	 		day12 = Call_Me_Later.getText();
 	 		day13 = Not_Intrested_Providing_Feedback.getText();
 	 		
 	 		day14 = Wrong_Number.getText();
 	 		day15 = Call_Not_Connected.getText();
 	 		day16 = fresh.getText();
 	 		day17 = pending_fresh.getText();
 	 		day18 = Unallocated_area.getText();
 	 		
 	 		 Thread.sleep(1000);

  	        try {
  	        	 // Parse the 'Total Leads Recieved' value to a numeric type
  	            Integer TotalLeadRecieved = Integer.parseInt( day1);

  	            if (TotalLeadRecieved <= 0 || day1 == null) {
  	                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
  	                Assert.fail("No Data Found for Day_Wise In PSF_Due_Analysis : " +  day1);
  	            } else {
  	                // Print the 'Total Leads Recieved' value
  	                System.out.println("'Total_Psf_Due of Day_Wise Wise Tab In PSF_Due_Analysis::: " + day1);
  	            }

  	        } catch (Exception e) {
  	            // Fail the test if an exception is thrown
  	            Assert.fail("No Data Found for Day_Wise Tab In PSF_Due_Analysis " + e.getMessage());
  	        }
  	    }
 	 	
 	// ..............................................................................................................
 	 	@Test(priority = 12)
 	 	public void Click_On_Service_Type_Wise() throws InterruptedException {
 	 		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 	 		WebElement Service_Type_Wise = wait
 					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Service Type Wise\"]")));
 			Service_Type_Wise.click();
 			Thread.sleep(2000);	 	 		
 	 		WebElement Generate = wait.until(
	 				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Generate \"]")));
 	 		Generate.click();
 	 		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));
 	 	// Proceed with the rest of your element locators and text retrievals
 	 		WebElement Total_Psf_Due = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));

 	 		WebElement PSF_Done = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
 	 		WebElement PSF_Done_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
 	 		WebElement PSF_Done_By_Kara = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
 	 		WebElement PSF_Done_By_Kara_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
 	 		WebElement PSF_Done_By_AMIE = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
 	 		WebElement PSF_Done_By_AMIE_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
 	 		WebElement PSF_Done_By_CCE = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
 	 		WebElement PSF_Done_By_CCE_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
 	 		WebElement Satisfied_Rating = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
 	 		WebElement DiSatisfied_Rating = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[12]"));
 	 		WebElement Call_Me_Later = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[13]"));
 	 		WebElement Not_Intrested_Providing_Feedback = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[14]"));

 	 		WebElement Wrong_Number = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[15]"));
 	 		WebElement Call_Not_Connected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[16]"));
 	 		WebElement fresh = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[17]"));
 	 		WebElement pending_fresh = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[18]"));
 	 		WebElement Unallocated_area = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[19]"));

 	 		Thread.sleep(2000);
 	 		s1  =Total_Psf_Due.getText();
 	 		s2 = PSF_Done.getText();
 	 		s3 = PSF_Done_Percent.getText();
 	 		s4 = PSF_Done_By_Kara.getText();
 	 		s5 = PSF_Done_By_Kara_Percent.getText();
 	 		s6 = PSF_Done_By_AMIE.getText();
 	 		s7 = PSF_Done_By_AMIE_Percent.getText();
 	 		s8 = PSF_Done_By_CCE.getText();
 	 		s9 = PSF_Done_By_CCE_Percent.getText();
 	 		s10 = Satisfied_Rating.getText();
 	 		s11 = DiSatisfied_Rating.getText();
 	 		s12 = Call_Me_Later.getText();
 	 		s13 = Not_Intrested_Providing_Feedback.getText();
 	 		
 	 		s14 = Wrong_Number.getText();
 	 		s15 = Call_Not_Connected.getText();
 	 		s16 = fresh.getText();
 	 		s17 = pending_fresh.getText();
 	 		s18 = Unallocated_area.getText();
 	 		
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
 	    	                         w12, w13,w14,w15,w16,w17,w18};
 	    	String[] dayWise = {day1, day2, day3, day4, day5, day6, day7, day8, day9, 
 	                            day10, day11, day12, day13,day14, day15, day16, day17, day18,};
 	    	String[] Service_TypeWise = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18};
 	    	
 	    	String[] comparisonLabels = {
 	    			 	    			
 	    	    "Total_Psf_Due", "PSF_Done", "PSF_Done_Percent", "PSF_Done_By_Kara", 
 	    	    "PSF_Done_By_Kara_Percent", "PSF_Done_By_AMIE", "PSF_Done_By_AMIE_Percent", "PSF_Done_By_CCE", 
 	    	    "PSF_Done_By_CCE_Percent", "Satisfied_Rating", "DiSatisfied_Rating",  "Call_Me_Later",
 	    	    "Not_Intrested_Providing_Feedback","Wrong_Number", 	"Call_Not_Connected", "fresh",    	   
 	    	     "pending_fresh",  "Unallocated_area"
 	    	    
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

