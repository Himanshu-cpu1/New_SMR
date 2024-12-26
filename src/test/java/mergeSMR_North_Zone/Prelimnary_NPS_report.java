package mergeSMR_North_Zone;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

public class Prelimnary_NPS_report extends LOGIN  {
	
	public static WebDriver driver;
	public WebDriverWait wait;
	
	 String z1, z2, z3, z4, z5, z6, z7, z8, z9, z10, z11, z12, z13,z14;
	  String d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13,d14,
      d15,d16,d17,d18,d19,d20,d21,d22,d23,d24;
       String w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11, 
      w12, w13, w14,w15,w16,w17,w18,w19,w20,w21,w22,w23,w24;
     String day1, day2, day3, day4, day5, day6, day7, day8, day9, 
       day10, day11, day12, day13, day14,day15,day16,day17,day18,day19,day20,day21,day22,day23,day24;
     String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14,s15,
      s16,s17,s18,s19,s20,s21,s22,s23,s24;
//   String SM1, SM2, SM3, SM4, SM5, SM6, SM7, SM8, SM9, SM10, SM11, SM12, SM13, SM14,SM15,SM16,SM17,SM18,SM19,SM20,SM21,SM22,SM23;

   //..................................................................................................
     @SuppressWarnings("static-access")
     @BeforeClass
     	public void SMR() throws InterruptedException {
     	 this.driver=LOGIN.driver;	
     	 // Initialize WebDriverWait with a timeout of 10 seconds using Duration
         this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     	}
	// .....................................................................................................

	  	@Test(priority = 8)
	  	public void Click_On_PSF_Reports() throws InterruptedException {
	  					  		
	  		WebElement PSF_Reports = wait
	  			    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"PSF-Reports \"]")));
	  			// Call the JavaScript Executor method instead of directly clicking
	  			clickElementUsingJS(driver, PSF_Reports);
	            Thread.sleep(1000);
	  	}
	  	
	 // ..............................................................................................................
	 	@Test(priority = 9)
	 	public void Click_On_Preliminary_NPS_Report() throws InterruptedException {
	 		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 		WebElement Preliminary_NPS_Report = wait.until(
	 				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Preliminary NPS Report \"]")));
	 		clickElementUsingJS(driver, Preliminary_NPS_Report);
	 		Thread.sleep(5000);
	 		
	 	}
	 	
	 	 // ..............................................................................................................
 	 	@Test(priority = 11)
 	 	public void Click_On_Zone_And_Region_wise() throws InterruptedException {
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
  	        
  	        WebElement Select_ALL = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class=\"mat-option-text\"])[1]")));
  	        Select_ALL.click();
  	        Thread.sleep(500);
  	        
  	        WebElement select_service_Type = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@role=\"combobox\"])[4]")));
  	        Actions actions = new Actions(driver);      
 	        actions.doubleClick(select_service_Type).perform();
  	        
  	        Thread.sleep(500);
  	        
  	        WebElement Select_ALL2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class=\"mat-option-text\"])[1]")));
  	        Select_ALL2.click();
  	        Thread.sleep(500);
  	        
  	        WebElement select_NPS = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@role=\"combobox\"])[5]")));	             
	        actions.doubleClick(select_NPS).perform();
	        
	        Thread.sleep(500);
	        
	        WebElement Select_ALL3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class=\"mat-option-text\"])[1]")));
	        Select_ALL3.click();
	        Thread.sleep(500);
	       
  	        WebElement Generate = wait.until(
	 				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
	        actions.doubleClick(Generate).perform();
	 		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));	 		
	     
	 	// Proceed with the rest of your element locators and text retrievals
 	 		WebElement Percent_Promoter = driver.findElement(By.xpath("//*[contains(text(),\"\")]//following::tbody[1]/tr[1]/td[3]"));

 	 		WebElement Percent_Passives = driver
 	 				.findElement(By.xpath("//*[contains(text(),\"\")]//following::tbody[1]/tr[1]/td[4]"));
 	 		WebElement Percent_Detractors = driver.findElement(By.xpath("//*[contains(text(),\"\")]//following::tbody[1]/tr[1]/td[5]"));
 	 		WebElement NPS = driver
 	 				.findElement(By.xpath("//*[contains(text(),\"\")]//following::tbody[1]/tr[1]/td[6]"));
 	 		WebElement Excellent_Percent = driver.findElement(By.xpath("//*[contains(text(),\"\")]//following::tbody[1]/tr[1]/td[7]"));
 	 		WebElement VeryGood_Percent = driver.findElement(By.xpath("//*[contains(text(),\"\")]//following::tbody[1]/tr[1]/td[8]"));
 	 		WebElement Good_Percent = driver.findElement(By.xpath("//*[contains(text(),\"\")]//following::tbody[1]/tr[1]/td[9]"));
 	 		WebElement Average_Percent = driver.findElement(By.xpath("//*[contains(text(),\"\")]//following::tbody[1]/tr[1]/td[10]"));
 	 		WebElement poor_Percent = driver.findElement(By.xpath("//*[contains(text(),\"\")]//following::tbody[1]/tr[1]/td[11]"));
 	 				
 	 		Thread.sleep(2000);
 	 		z1  =Percent_Promoter.getText();
 	 		z2 = Percent_Passives.getText();
 	 		z3 = Percent_Detractors.getText();
 	 		z4 = NPS.getText();
 	 		z5 = Excellent_Percent.getText();
 	 		z6 = VeryGood_Percent.getText();
 	 		z7 = Good_Percent.getText();
 	 		z8 = Average_Percent.getText();
 	 		z9 = poor_Percent.getText();
 	 		
 	 		Thread.sleep(1000);

  	        try {
  	        	 // Remove the '%' sign and trim whitespace if present
 	 		    String numericPart = z1.replace("%", "").trim();

 	 		    // Parse the 'Total Leads Recieved' value to a numeric type
 	 		    Integer totalLeadReceived = Integer.parseInt(numericPart);

  	            if (totalLeadReceived <= 0 || z1 == null) {
  	                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
  	                Assert.fail("No Data Found for Zone_And_Region_Wise In Premilinary_NPS_Report : " +  z1);
  	            } else {
  	                // Print the 'Total Leads Recieved' value
  	                System.out.println("'Percent_Promoter of Zone_And_Region_Wise Wise Tab In Premilinary_NPS_Report::: " + z1);
  	            }

  	        } catch (Exception e) {
  	            // Fail the test if an exception is thrown
  	            Assert.fail("No Data Found for Zone_And_Region_Wise Tab In Premilinary_NPS_Report " + e.getMessage());
  	        }
  	    }
 	 	
 	 	 // ..............................................................................................................
 	 	@Test(priority = 12)
 	 	public void Click_On_Dealer_Parent_Group_wise() throws InterruptedException {
 	 		Thread.sleep(3000);	 	 			 		
 	 		WebElement Dealer_Parent_Group_wise = wait
 					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Dealer Parent Group Wise\"]")));
 	 		Dealer_Parent_Group_wise.click();
 			Thread.sleep(2000);	
 	      
 	        WebElement Generate = wait.until(
	 				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
 	       Generate.click();
	 		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));	 		
 	        
	 	// Proceed with the rest of your element locators and text retrievals
 	 		WebElement Percent_Promoter = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));

 	 		WebElement Percent_Passives = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
 	 		WebElement Percent_Detractors = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
 	 		WebElement NPS = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
 	 		WebElement Excellent_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
 	 		WebElement VeryGood_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
 	 		WebElement Good_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
 	 		WebElement Average_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
 	 		WebElement poor_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
 	 				
 	 		Thread.sleep(2000);
 	 		d1  =Percent_Promoter.getText();
 	 		d2 = Percent_Passives.getText();
 	 		d3 = Percent_Detractors.getText();
 	 		d4 = NPS.getText();
 	 		d5 = Excellent_Percent.getText();
 	 		d6 = VeryGood_Percent.getText();
 	 		d7 = Good_Percent.getText();
 	 		d8 = Average_Percent.getText();
 	 		d9 = poor_Percent.getText();
 	 		
 	 		Thread.sleep(1000);

  	        try {
  	       // Remove the '%' sign and trim whitespace if present
 	 		    String numericPart = d1.replace("%", "").trim();

 	 		    // Parse the 'Total Leads Recieved' value to a numeric type
 	 		    Integer totalLeadReceived = Integer.parseInt(numericPart);

  	            if (totalLeadReceived <= 0 || d1 == null) {
  	                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
  	                Assert.fail("No Data Found for Dealer_Parent_Group_wise In Premilinary_NPS_Report : " +  d1);
  	            } else {
  	                // Print the 'Total Leads Recieved' value
  	                System.out.println("'Percent_Promoter of Dealer_Parent_Group_wise Wise Tab In Premilinary_NPS_Report::: " + d1);
  	            }

  	        } catch (Exception e) {
  	            // Fail the test if an exception is thrown
  	            Assert.fail("No Data Found for Dealer_Parent_Group_wise Tab In Premilinary_NPS_Report " + e.getMessage());
  	        }
  	    }
 	 	
 	// ..............................................................................................................
 	 	@Test(priority = 13)
 	 	public void Click_On_Workshop_wise() throws InterruptedException {
 	 		Thread.sleep(3000);	 	 			 		
 	 		WebElement Workshop_wise = wait
 					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Workshop Wise \"]")));
 	 		Workshop_wise.click();
 			Thread.sleep(2000);	
 	      
 	        WebElement Generate = wait.until(
	 				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
 	       Generate.click();
	 		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));	 		
 	        
	 	// Proceed with the rest of your element locators and text retrievals
 	 		WebElement Percent_Promoter = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));

 	 		WebElement Percent_Passives = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
 	 		WebElement Percent_Detractors = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
 	 		WebElement NPS = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
 	 		WebElement Excellent_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
 	 		WebElement VeryGood_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
 	 		WebElement Good_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
 	 		WebElement Average_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
 	 		WebElement poor_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[12]"));
 	 				
 	 		Thread.sleep(2000);
 	 		w1  =Percent_Promoter.getText();
 	 		w2 = Percent_Passives.getText();
 	 		w3 = Percent_Detractors.getText();
 	 		w4 = NPS.getText();
 	 		w5 = Excellent_Percent.getText();
 	 		w6 = VeryGood_Percent.getText();
 	 		w7 = Good_Percent.getText();
 	 		w8 = Average_Percent.getText();
 	 		w9 = poor_Percent.getText();
 	 	
 	 		Thread.sleep(1000);

  	        try {
  	        	 // Remove the '%' sign and trim whitespace if present
 	 		    String numericPart = w1.replace("%", "").trim();

 	 		    // Parse the 'Total Leads Recieved' value to a numeric type
 	 		    Integer totalLeadReceived = Integer.parseInt(numericPart);

  	            if (totalLeadReceived <= 0 || w1 == null) {
  	                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
  	                Assert.fail("No Data Found for Workshop_wise In Premilinary_NPS_Report : " +  w1);
  	            } else {
  	                // Print the 'Total Leads Recieved' value
  	                System.out.println("'Percent_Promoter of Workshop_wise Wise Tab In Premilinary_NPS_Report::: " + w1);
  	            }

  	        } catch (Exception e) {
  	            // Fail the test if an exception is thrown
  	            Assert.fail("No Data Found for Workshop_wise Tab In Premilinary_NPS_Report " + e.getMessage());
  	        }
  	    }
 	 	 // ..............................................................................................................
 	 	@Test(priority = 14)
 	 	public void Click_On_Day_Wise() throws InterruptedException {
 	 		Thread.sleep(3000);	 	 			 		
 	 		WebElement Day_Wise = wait
 					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Day Wise \"]")));
 			Day_Wise.click();
 			Thread.sleep(2000);	
 	      
 	        WebElement Generate = wait.until(
	 				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
 	       Generate.click();
	 		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));	 		
 	        
	 	// Proceed with the rest of your element locators and text retrievals
 	 		WebElement Percent_Promoter = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));

 	 		WebElement Percent_Passives = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
 	 		WebElement Percent_Detractors = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
 	 		WebElement NPS = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
 	 		WebElement Excellent_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
 	 		WebElement VeryGood_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
 	 		WebElement Good_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
 	 		WebElement Average_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
 	 		WebElement poor_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
 	 				
 	 		Thread.sleep(2000);
 	 		day1  =Percent_Promoter.getText();
 	 		day2 = Percent_Passives.getText();
 	 		day3 = Percent_Detractors.getText();
 	 		day4 = NPS.getText();
 	 		day5 = Excellent_Percent.getText();
 	 		day6 = VeryGood_Percent.getText();
 	 		day7 = Good_Percent.getText();
 	 		day8 = Average_Percent.getText();
 	 		day9 = poor_Percent.getText();
 	 		
 	 		Thread.sleep(1000);

  	        try {
  	        	 // Remove the '%' sign and trim whitespace if present
 	 		    String numericPart = day1.replace("%", "").trim();

 	 		    // Parse the 'Total Leads Recieved' value to a numeric type
 	 		    Integer totalLeadReceived = Integer.parseInt(numericPart);

  	            if (totalLeadReceived <= 0 || day1 == null) {
  	                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
  	                Assert.fail("No Data Found for Day_Wise In Premilinary_NPS_Report : " +  day1);
  	            } else {
  	                // Print the 'Total Leads Recieved' value
  	                System.out.println("'Percent_Promoter of Day_Wise Wise Tab In Premilinary_NPS_Report::: " + day1);
  	            }

  	        } catch (Exception e) {
  	            // Fail the test if an exception is thrown
  	            Assert.fail("No Data Found for Day_Wise Tab In Premilinary_NPS_Report " + e.getMessage());
  	        }
  	    }
 	 	 // ..............................................................................................................
 	 	@Test(priority = 15)
 	 	public void Click_On_Service_Type_Wise() throws InterruptedException {
 	 		Thread.sleep(3000);	 	 			 		
 	 		WebElement Service_Type_Wise = wait
 					.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Service Type Wise\"]")));
 			Service_Type_Wise.click();
 			Thread.sleep(2000);	 	 		
 			WebElement Generate = wait.until(
	 				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
 	       Generate.click();
	 		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));	 		
 	        
	 	// Proceed with the rest of your element locators and text retrievals
 	 		WebElement Percent_Promoter = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));

 	 		WebElement Percent_Passives = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
 	 		WebElement Percent_Detractors = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
 	 		WebElement NPS = driver
 	 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
 	 		WebElement Excellent_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
 	 		WebElement VeryGood_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
 	 		WebElement Good_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
 	 		WebElement Average_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
 	 		WebElement poor_Percent = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
 	 				
 	 		Thread.sleep(2000);
 	 		s1  =Percent_Promoter.getText();
 	 		s2 = Percent_Passives.getText();
 	 		s3 = Percent_Detractors.getText();
 	 		s4 = NPS.getText();
 	 		s5 = Excellent_Percent.getText();
 	 		s6 = VeryGood_Percent.getText();
 	 		s7 = Good_Percent.getText();
 	 		s8 = Average_Percent.getText();
 	 		s9 = poor_Percent.getText();
 	 		
 	 		Thread.sleep(1000);

  	        try {
  	        	 // Remove the '%' sign and trim whitespace if present
 	 		    String numericPart = s1.replace("%", "").trim();

 	 		    // Parse the 'Total Leads Recieved' value to a numeric type
 	 		    Integer totalLeadReceived = Integer.parseInt(numericPart);

  	            if (totalLeadReceived <= 0 || s1 == null) {
  	                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
  	                Assert.fail("No Data Found for Service_Type_Wise In Premilinary_NPS_Report : " +  s1);
  	            } else {
  	                // Print the 'Total Leads Recieved' value
  	                System.out.println("'Percent_Promoter of Service_Type_Wise Wise Tab In Premilinary_NPS_Report::: " + s1);
  	            }

  	        } catch (Exception e) {
  	            // Fail the test if an exception is thrown
  	            Assert.fail("No Data Found for Service_Type_Wise Tab In Premilinary_NPS_Report " + e.getMessage());
  	        }
  	    }
 	 	
 	 	
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	   
 	    
 	    @Test(priority = 16)
 	    public void Comparison_0f_all_Data() throws InterruptedException {
 	    	String[] Zone_Region_Wise = {z1, z2, z3, z4, z5, z6, z7, z8, z9};
 	    	String[] Dealer_Parent_Group_wise = {d1, d2, d3, d4, d5, d6, d7, d8, d9};
 	    	String[] workshopWise = {w1, w2, w3, w4, w5, w6, w7, w8, w9};
 	    	String[] dayWise = {day1, day2, day3, day4, day5, day6, day7, day8, day9, 
 	                            };
 	    	String[] Service_TypeWise = {s1, s2, s3, s4, s5, s6, s7, s8, s9};
 	    	
 	    	String[] comparisonLabels = {
 	    			 	    			
 	      		
 	     	    "Percent_Promoter", "Percent_Passives", "Percent_Detractors", "NPS", 
 	    	    "Excellent_Percent", "VeryGood_Percent", "Good_Percent", "Average_Percent", 
 	    	    "poor_Percent" 
	    	   
 	    	};

 	    	for (int i = 0; i < workshopWise.length; i++) {
 	    	    // Normalize by removing spaces
 	    	    String normalizedZoneRegionWise = Zone_Region_Wise[i].replace(" ", "").trim();
 	    	    String normalizedDealerParentGroupWise = Dealer_Parent_Group_wise[i].replace(" ", "").trim();
 	    	    String normalizedWorkshopWise = workshopWise[i].replace(" ", "").trim();
 	    	    String normalizedDayWise = dayWise[i].replace(" ", "").trim();
 	    	    String normalizedServiceTypeWise = Service_TypeWise[i].replace(" ", "").trim();

 	    	    // Compare normalized values
 	    	    Assert.assertEquals(normalizedZoneRegionWise, normalizedDealerParentGroupWise,
 	    	        "Compare " + comparisonLabels[i] + "_of_Zone and Region Wise With Dealer Parent Group Wise");
 	    	    Assert.assertEquals(normalizedZoneRegionWise, normalizedWorkshopWise,
 	    	        "Compare " + comparisonLabels[i] + "_of_Zone and Region Wise With Workshop Wise");
 	    	    Assert.assertEquals(normalizedZoneRegionWise, normalizedDayWise,
 	    	        "Compare " + comparisonLabels[i] + "_of_Zone and Region Wise With Day Wise");
 	    	    Assert.assertEquals(normalizedZoneRegionWise, normalizedServiceTypeWise,
 	    	        "Compare " + comparisonLabels[i] + "_of_Zone and Region Wise With Service Type Wise");
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
	 		private void DateSelect() throws InterruptedException {
	 			 // Click on the calendar to open date picker
	 	        WebElement Calender = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("(//*[@aria-label=\"Open calendar\"])[1]")));
	 	        Calender.click();
	 	        Thread.sleep(2000);

	 	        // Select start date (1st of the current month)
	 	        LocalDate today = LocalDate.now();
	 	        LocalDate firstDayOfMonth = today.withDayOfMonth(1);
	 	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	 	        WebElement selectStart = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label=\"" + firstDayOfMonth.format(formatter) + "\"]")));
	 	        selectStart.click();
	 	        Thread.sleep(2000);

	 	        // Select today's date
	 	        WebElement selectToday = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label=\"" + today.format(formatter) + "\"]")));
	 	        selectToday.click();
	 	        Thread.sleep(2000);
	 		}
	 	}