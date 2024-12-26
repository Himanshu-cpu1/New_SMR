package SMR_Call_Dispostion_Data_Check_And_CCM_Reports;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

public class CCM_Cross_sell_Intrest_Log_Reports extends LOgin_CCM{

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
    public void ccm_Reports() throws InterruptedException {
        // Initialize the driver (assuming it's static in the SMR_due_Datewise class)
        this.driver = LOgin_CCM.driver;

     // Initialize WebDriverWait with a timeout of 10 seconds using Duration
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
  	
 // ..............................................................................................................
 	@Test(priority = 9)
 	public void Click_On_The_Cross_sell_Intrest() throws InterruptedException {
 		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 		WebElement Cross = wait.until(
 				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Cross-Sell Interest Log \"]")));
 		 clickElementUsingJS(driver, Cross);
 		Thread.sleep(3000);
 		
 	}
 // ...............................................................................................
 	@Test(priority = 10)
 	public void Dealer_Parent_Group_Wise() throws InterruptedException {
 		Thread.sleep(1000);
 		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 		
 		WebElement Dealer_Parent_Group_Wise = wait.until(
 				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Dealer Parent Group Wise \"]")));
 		Dealer_Parent_Group_Wise.click();
 		Thread.sleep(3000);
 		 DateSelector();	
 		// Proceed with the rest of your element locators and text retrievals
 		WebElement Total_Dispostion = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));

 		WebElement Total_Interest_Dispostion = driver
 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
 		WebElement Not_Interest_Dispostion = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
 		WebElement Not_confiremed_Dispostion = driver
 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
 		WebElement Total_Intrested = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
 		WebElement Yes = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
 		WebElement Gold = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
 		WebElement Platinum = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
 		WebElement Royal_Platinium = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
 		WebElement Total_Intrested1 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
 		WebElement Yes2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[12]"));
 		WebElement CCP_Hydro = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[13]"));
 		WebElement CCP_Fuel = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[14]"));
 		WebElement CCP_Plus = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[15]"));

 		WebElement Total_Intrested2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[16]"));
 		WebElement yes3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[17]"));
 		WebElement Platinum2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[18]"));
 		WebElement Royal_Platinium2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[19]"));
 		WebElement Total_Intrested3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[20]"));
 		WebElement Yes4 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[21]"));
 		WebElement CCP_Hydro2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[22]"));
 		WebElement CCP_Fuel2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[23]"));
 		WebElement CCP_Plus2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[24]"));

 		Thread.sleep(1000);

 	    d1  =Total_Dispostion.getText();
 		d2 = Total_Interest_Dispostion.getText();
 		d3 = Not_Interest_Dispostion.getText();
 		d4 = Not_confiremed_Dispostion.getText();
 		d5 = Total_Intrested.getText();
 		d6 = Yes.getText();
 		d7 = Gold.getText();
 		d8 = Platinum.getText();
 		d9 = Royal_Platinium.getText();
 		d10 = Total_Intrested1.getText();
 		d11 = Yes2.getText();
 		d12 = CCP_Hydro.getText();
 		d13 = CCP_Fuel.getText();
 		d14 = CCP_Plus.getText();

 		d15 = Total_Intrested2.getText();
 		d16 = yes3.getText();
 		d17 = Platinum2.getText();
 		d18 = Royal_Platinium2.getText();
 		d19 = Total_Intrested3.getText();
 		d20 = Yes4.getText();
 		d21 = CCP_Hydro2.getText();
 		d22 = CCP_Fuel2.getText();
 		d23 = CCP_Plus2.getText();
 		
 		  Thread.sleep(1000);

 	        try {
 	        	 // Parse the 'Total Leads Recieved' value to a numeric type
 	            Integer TotalLeadRecieved = Integer.parseInt( d1);

 	            if (TotalLeadRecieved <= 0 || d1 == null) {
 	                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
 	                Assert.fail("No Data Found for Dealer_Parent_Group_wise In Cross_Sell_Intrest_Log : " +  d1);
 	            } else {
 	                // Print the 'Total Leads Recieved' value
 	                System.out.println("'Total_Dispostion of Dealer_Parent_Group_wise Wise Tab In Cross_Sell_Intrest_Log::: " + d1);
 	            }

 	        } catch (Exception e) {
 	            // Fail the test if an exception is thrown
 	            Assert.fail("No Data Found for Dealer_Parent_Group_wise Tab In Cross_Sell_Intrest_Log " + e.getMessage());
 	        }
 	    }
 	 // ...............................................................................................
 	@Test(priority = 11)
 	public void WorkShop_Wise() throws InterruptedException {
 		Thread.sleep(1000);
 		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 		WebElement WorkShop_Wise = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Workshop Wise \"]")));
		WorkShop_Wise.click();
		Thread.sleep(3000);
		
		// Click on the generate report button
		WebElement clickOnGenerate = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
		clickOnGenerate.click();
  		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

  		
 		// ...............Proceed with the rest of your element locators and text retrievals............
 		WebElement Total_Dispostion = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[2]"));
 		WebElement Total_Interest_Dispostion = driver
 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[3]"));
 		WebElement Not_Interest_Dispostion = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[4]"));
 		WebElement Not_confiremed_Dispostion = driver
 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[5]"));
 		WebElement Total_Intrested = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[6]"));
 		WebElement Yes = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[7]"));
 		WebElement Gold = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[8]"));
 		WebElement Platinum = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[9]"));
 		WebElement Royal_Platinium = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[10]"));
 		WebElement Total_Intrested1 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[11]"));
 		WebElement Yes2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[12]"));
 		WebElement CCP_Hydro = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[13]"));
 		WebElement CCP_Fuel = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[14]"));
 		WebElement CCP_Plus = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[15]"));

 		WebElement Total_Intrested2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[16]"));
 		WebElement yes3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[17]"));
 		WebElement Platinum2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[18]"));
 		WebElement Royal_Platinium2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[19]"));
 		WebElement Total_Intrested3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[20]"));
 		WebElement Yes4 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[21]"));
 		WebElement CCP_Hydro2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[22]"));
 		WebElement CCP_Fuel2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[23]"));
 		WebElement CCP_Plus2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[24]"));

 		Thread.sleep(1000);
 	    w1  =Total_Dispostion.getText();
 		w2 = Total_Interest_Dispostion.getText();
 		w3 = Not_Interest_Dispostion.getText();
 		w4 = Not_confiremed_Dispostion.getText();
 		w5 = Total_Intrested.getText();
 		w6 = Yes.getText();
 		w7 = Gold.getText();
 		w8 = Platinum.getText();
 		w9 = Royal_Platinium.getText();
 		w10 = Total_Intrested1.getText();
 		w11 = Yes2.getText();
 		w12 = CCP_Hydro.getText();
 		w13 = CCP_Fuel.getText();
 		w14 = CCP_Plus.getText();

 		w15 = Total_Intrested2.getText();
 		w16 = yes3.getText();
 		w17 = Platinum2.getText();
 		w18 = Royal_Platinium2.getText();
 		w19 = Total_Intrested3.getText();
 		w20 = Yes4.getText();
 		w21 = CCP_Hydro2.getText();
 		w22 = CCP_Fuel2.getText();
 		w23 = CCP_Plus2.getText();
 		
 		  Thread.sleep(1000);

 	        try {
 	        	 // Parse the 'Total Leads Recieved' value to a numeric type
 	            Integer TotalLeadRecieved = Integer.parseInt( w1);

 	            if (TotalLeadRecieved <= 0 || w1 == null) {
 	                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
 	                Assert.fail("No Data Found for Workshop_Wise In Cross_Sell_Intrest_Log : " +  w1);
 	            } else {
 	                // Print the 'Total Leads Recieved' value
 	                System.out.println("'Total_Dispostion of Workshop_Wise Wise Tab In Cross_Sell_Intrest_Log::: " + w1);
 	            }

 	        } catch (Exception e) {
 	            // Fail the test if an exception is thrown
 	            Assert.fail("No Data Found for Workshop_Wise Tab In Cross_Sell_Intrest_Log " + e.getMessage());
 	        }
 	    }
	 // ...............................................................................................
	@Test(priority = 12)
	public void Day_Wise() throws InterruptedException {
		Thread.sleep(1000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Day_Wise = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Day Wise \"]")));
		Day_Wise.click();
		Thread.sleep(3000);
		
		// Click on the generate report button
		WebElement clickOnGenerate = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
		clickOnGenerate.click();
 		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));
 		
		// ...............Proceed with the rest of your element locators and text retrievals............
		WebElement Total_Dispostion = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[2]"));
		WebElement Total_Interest_Dispostion = driver
				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[3]"));
		WebElement Not_Interest_Dispostion = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[4]"));
		WebElement Not_confiremed_Dispostion = driver
				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[5]"));
		WebElement Total_Intrested = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[6]"));
		WebElement Yes = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[7]"));
		WebElement Gold = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[8]"));
		WebElement Platinum = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[9]"));
		WebElement Royal_Platinium = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[10]"));
		WebElement Total_Intrested1 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[11]"));
		WebElement Yes2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[12]"));
		WebElement CCP_Hydro = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[13]"));
		WebElement CCP_Fuel = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[14]"));
		WebElement CCP_Plus = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[15]"));

		WebElement Total_Intrested2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[16]"));
		WebElement yes3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[17]"));
		WebElement Platinum2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[18]"));
		WebElement Royal_Platinium2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[19]"));
		WebElement Total_Intrested3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[20]"));
		WebElement Yes4 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[21]"));
		WebElement CCP_Hydro2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[22]"));
		WebElement CCP_Fuel2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[23]"));
		WebElement CCP_Plus2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[24]"));

		Thread.sleep(1000);
	    day1  =Total_Dispostion.getText();
	    day2 = Total_Interest_Dispostion.getText();
	    day3 = Not_Interest_Dispostion.getText();
	    day4 = Not_confiremed_Dispostion.getText();
	    day5 = Total_Intrested.getText();
	    day6 = Yes.getText();
	    day7 = Gold.getText();
	    day8 = Platinum.getText();
	    day9 = Royal_Platinium.getText();
	    day10 = Total_Intrested1.getText();
	    day11 = Yes2.getText();
	    day12 = CCP_Hydro.getText();
	    day13 = CCP_Fuel.getText();
	    day14 = CCP_Plus.getText();

	    day15 = Total_Intrested2.getText();
	    day16 = yes3.getText();
	    day17 = Platinum2.getText();
	    day18 = Royal_Platinium2.getText();
	    day19 = Total_Intrested3.getText();
	    day20 = Yes4.getText();
	    day21 = CCP_Hydro2.getText();
	    day22 = CCP_Fuel2.getText();
	    day23 = CCP_Plus2.getText();
		
		  Thread.sleep(1000);

	        try {
	        	 // Parse the 'Total Leads Recieved' value to a numeric type
	            Integer TotalLeadRecieved = Integer.parseInt( day1);

	            if (TotalLeadRecieved <= 0 || day1 == null) {
	                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
	                Assert.fail("No Data Found for Day_Wise In Cross_Sell_Intrest_Log : " +  day1);
	            } else {
	                // Print the 'Total Leads Recieved' value
	                System.out.println("'Total_Dispostion of Day_Wise Wise Tab In Cross_Sell_Intrest_Log::: " + day1);
	            }

	        } catch (Exception e) {
	            // Fail the test if an exception is thrown
	            Assert.fail("No Data Found for Workshop_Wise Tab In Cross_Sell_Intrest_Log " + e.getMessage());
	        }
	    }
	
	 // ...............................................................................................
 	@Test(priority = 13)
 	public void Service_type_Wise() throws InterruptedException {
 		Thread.sleep(1000);
 		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 		WebElement Service_Type_Wise = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Service Type Wise \"]")));
		Service_Type_Wise.click();
		Thread.sleep(3000);
		
		// Click on the generate report button
		WebElement clickOnGenerate = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
		clickOnGenerate.click();
  		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

  		
 		// ...............Proceed with the rest of your element locators and text retrievals............
 		WebElement Total_Dispostion = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[2]"));
 		WebElement Total_Interest_Dispostion = driver
 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[3]"));
 		WebElement Not_Interest_Dispostion = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[4]"));
 		WebElement Not_confiremed_Dispostion = driver
 				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[5]"));
 		WebElement Total_Intrested = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[6]"));
 		WebElement Yes = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[7]"));
 		WebElement Gold = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[8]"));
 		WebElement Platinum = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[9]"));
 		WebElement Royal_Platinium = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[10]"));
 		WebElement Total_Intrested1 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[11]"));
 		WebElement Yes2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[12]"));
 		WebElement CCP_Hydro = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[13]"));
 		WebElement CCP_Fuel = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[14]"));
 		WebElement CCP_Plus = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[15]"));

 		WebElement Total_Intrested2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[16]"));
 		WebElement yes3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[17]"));
 		WebElement Platinum2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[18]"));
 		WebElement Royal_Platinium2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[19]"));
 		WebElement Total_Intrested3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[20]"));
 		WebElement Yes4 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[21]"));
 		WebElement CCP_Hydro2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[22]"));
 		WebElement CCP_Fuel2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[23]"));
 		WebElement CCP_Plus2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[24]"));

 		Thread.sleep(1000);
 	    s1  =Total_Dispostion.getText();
 		s2 = Total_Interest_Dispostion.getText();
 		s3 = Not_Interest_Dispostion.getText();
 		s4 = Not_confiremed_Dispostion.getText();
 		s5 = Total_Intrested.getText();
 		s6 = Yes.getText();
 		s7 = Gold.getText();
 		s8 = Platinum.getText();
 		s9 = Royal_Platinium.getText();
 		s10 = Total_Intrested1.getText();
 		s11 = Yes2.getText();
 		s12 = CCP_Hydro.getText();
 		s13 = CCP_Fuel.getText();
 		s14 = CCP_Plus.getText();
 		s15 = Total_Intrested2.getText();
 		s16 = yes3.getText();
 		s17 = Platinum2.getText();
 		s18 = Royal_Platinium2.getText();
 		s19 = Total_Intrested3.getText();
 		s20 = Yes4.getText();
 		s21 = CCP_Hydro2.getText();
 		s22 = CCP_Fuel2.getText();
 		s23 = CCP_Plus2.getText();
 		
 		  Thread.sleep(1000);

 	        try {
 	        	 // Parse the 'Total Leads Recieved' value to a numeric type
 	            Integer TotalLeadRecieved = Integer.parseInt( s1);

 	            if (TotalLeadRecieved <= 0 || s1 == null) {
 	                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
 	                Assert.fail("No Data Found for Service_type_Wise In Cross_Sell_Intrest_Log : " +  s1);
 	            } else {
 	                // Print the 'Total Leads Recieved' value
 	                System.out.println("'Total_Dispostion of Service_type_Wise Wise Tab In Cross_Sell_Intrest_Log::: " + s1);
 	            }

 	        } catch (Exception e) {
 	            // Fail the test if an exception is thrown
 	            Assert.fail("No Data Found for Service_type_Wise Tab In Cross_Sell_Intrest_Log " + e.getMessage());
 	        }
 	    }
 	
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	   
    
    @Test(priority = 15)
    public void Comparison_0f_all_Data() throws InterruptedException {
    	    	
    	String[] dealerParentWise = {d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13,d14,
    	                              d15,d16,d17,d18,d19,d20,d21,d22,d23};
    	String[] workshopWise = {w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11, 
    	                         w12, w13, w14,w15,w16,w17,w18,w19,w20,w21,w22,w23};
    	String[] dayWise = {day1, day2, day3, day4, day5, day6, day7, day8, day9, 
                            day10, day11, day12, day13, day14,day15,day16,day17,day18,
                            day19,day20,day21,day22,day23};
    	String[] Service_TypeWise = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14,s15,
    	                              s16,s17,s18,s19,s20,s21,s22,s23};
    	

    	String[] comparisonLabels = {
    	    "Total_Dispostion", "Total_Interest_Dispostion", "Not_Interest_Dispostion", "Not_confiremed_Dispostion", 
    	    "Total_Intrested", "Yes", "Gold", "Platinum", 
    	    "Royal_Platinium", "Total_Intrested1", "Yes2", "CCP_Hydro", "CCP_Fuel", "CCP_Plus"
    	   
    	    , "Total_Intrested2", "yes3", "Platinum2", "Royal_Platinium2", 
    	    "Total_Intrested3", "Yes4", "CCP_Hydro2", "CCP_Fuel2", "CCP_Plus2",
    	};

    	for (int i = 0; i < dealerParentWise.length; i++) {
    	    Assert.assertEquals(dealerParentWise[i], workshopWise[i], "Compare " + comparisonLabels[i] + "_of_DealerParentWise_With_Workshop_Wise");
    	    Assert.assertEquals(dealerParentWise[i], dayWise[i], "Compare " + comparisonLabels[i] + "_of_DealerParentWise_With_Day_Wise");
    	    Assert.assertEquals(dealerParentWise[i], Service_TypeWise[i], "Compare " + comparisonLabels[i] + "_of_DealerParentWise_With_Service_TypeWise");
    	  
    	}
    }
    
    //.....................................................................................................

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser and end the WebDriver session
        }
    }
  //.....................Helper Method...........................................................................
	
  	private void clickElementUsingJS(WebDriver driver, WebElement element) {
  	    JavascriptExecutor js = (JavascriptExecutor) driver;
  	    js.executeScript("arguments[0].click();", element);
  	}
  //............................................................................................
  	
  	private void DateSelector() throws InterruptedException {
  	  // Click on the calendar to open date picker
  		 wait = new WebDriverWait(driver, Duration.ofSeconds(15));
      WebElement select = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[alt=\"calendar\"]")));
      select.click();
      Thread.sleep(1000);

      // Select start date (1st of the current month)
      LocalDate today = LocalDate.now();
      LocalDate firstDayOfMonth = today.withDayOfMonth(1);
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
      WebElement selectStart = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label=\"" + firstDayOfMonth.format(formatter) + "\"]")));
      selectStart.click();
      Thread.sleep(1000);

      // Select today's date
      WebElement selectToday = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label=\"" + today.format(formatter) + "\"]")));
      selectToday.click();
      Thread.sleep(1000);

      // Click on the generate report button
      WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
      clickOnGenerate.click();
  		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

  	}
  	
  }

