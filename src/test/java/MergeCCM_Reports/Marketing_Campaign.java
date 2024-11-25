package MergeCCM_Reports;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Marketing_Campaign {

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
    String SM1, SM2, SM3, SM4, SM5, SM6, SM7, SM8, SM9, SM10, SM11, SM12, SM13, SM14,SM15,SM16,SM17,SM18,SM19,SM20,SM21,SM22,SM23;

    @SuppressWarnings("static-access")
    @BeforeClass
    public void SMR() throws InterruptedException {
        // Initialize the driver (assuming it's static in the SMR_due_Datewise class)
        this.driver = Smart_Eye_Overall_Performace.driver;

     // Initialize WebDriverWait with a timeout of 10 seconds using Duration
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
  	
  //.............................................................................................
    @Test(priority = 8)
	public void Click_On_MARKETING_CAMPAIGN_REPORT() throws InterruptedException {
	   
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	  
	    WebElement MarketingCamp = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Marketing Campaign ']")));
	    clickElementUsingJS(driver, MarketingCamp);
	    Thread.sleep(1000);
    }
  //......................................................................................................................
    @Test(priority = 9)
    public void Dealer_Parent_Group_Wise_Tab() throws InterruptedException {
        Thread.sleep(1000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));    
        // Click on the generate report button
        
     // Click on dropdown Marketing Campaign
        WebElement MarketCamp = driver.findElement(By.xpath("(//*[@role=\"combobox\"])"));
        MarketCamp.click();
        Thread.sleep(1000);
        // select Marketing Campaign
        WebElement Select_all = driver.findElement(By.xpath("//*[text()=\"All\"]"));
        Select_all.click();
      
        Thread.sleep(1000);
        DateSelector();
        
        WebElement TotalCampaignLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));       
        WebElement LeadsAttempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
        WebElement FollowUp = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
        WebElement Connected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
        WebElement AppointmentBooked = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
        WebElement PercentAppointmentBooked = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
        WebElement Reported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
        WebElement PercentReported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
        WebElement ReportedForFreeService = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
        WebElement PercentReportedForFreeService = driver
                .findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
        WebElement ReportedForPaidService = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[12]"));
        WebElement PercentReportedForPaidService = driver
                .findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[13]"));
        WebElement FreeServicePaidServiceReported = driver
                .findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[14]"));
        WebElement PercentFreeServicePaidServiceReported = driver
                .findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[15]"));
        WebElement NotAttempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[16]"));
        WebElement NotConnected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[17]"));
        WebElement LabourRevenue = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[18]"));
        WebElement PartsRevenue = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[19]"));
        WebElement LabourPartsRevenue = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[20]"));

        Thread.sleep(1000);
        // GET THE VALUES

        d1 = TotalCampaignLeads.getText();
        d2 = LeadsAttempted.getText();
        d3 = FollowUp.getText();
        d4 = Connected.getText();
        d5 = AppointmentBooked.getText();
        d6 = PercentAppointmentBooked.getText();
        d7 = Reported.getText();
        d8 = PercentReported.getText();
        d9 = ReportedForFreeService.getText();
        d10 = PercentReportedForFreeService.getText();
        d11 = ReportedForPaidService.getText();
        d12 = PercentReportedForPaidService.getText();
        d13 = FreeServicePaidServiceReported.getText();
        d14 = PercentFreeServicePaidServiceReported.getText();
        d15 = NotAttempted.getText();
        d16 = NotConnected.getText();
        d17 = LabourRevenue.getText();
        d18 = PartsRevenue.getText();
        d19 = LabourPartsRevenue.getText();
        Thread.sleep(1000);
              
        try {
        	 // Parse the Total Due value to a numeric type
            Integer totalDueValue = Integer.parseInt(d1);
            if (totalDueValue <= 0 || d1 == null) {

               // Fail the test if Total Due value is 0 or less
                Assert.fail("No Data Found for TotalCampaignLeads   In Dealer_Parent__Group_wise:: " + d1);
            } else {
                // Print the Total Due value
                 System.out.println("TotalCampaignLeads of Dealer_Parent__Group_wise::: " + d1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for TotalCampaignLeads   In Dealer_Parent__Group_wise: " + e.getMessage());
        }
    }
        
  //.............................................................................................................................
    @Test(priority = 11)
    public void WorkShop_Wise_Tab() throws InterruptedException {
        Thread.sleep(1000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement WorkShop_Wise = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Workshop Wise \"]")));
        WorkShop_Wise.click();        
        Thread.sleep(4000);
        // Locate the "Generate" button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

		 // Elements of Workshop Wise
        WebElement TotalCampaignLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[3]"));
        WebElement LeadsAttempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[4]"));
        WebElement FollowUp = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[5]"));
        WebElement Connected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[6]"));
        WebElement AppointmentBooked = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[7]"));
        WebElement PercentAppointmentBooked = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[8]"));
        WebElement Reported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[9]"));
        WebElement PercentReported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[10]"));
        WebElement ReportedForFreeService = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[11]"));
        WebElement PercentReportedForFreeService = driver
                .findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[12]"));
        WebElement ReportedForPaidService = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[13]"));
        WebElement PercentReportedForPaidService = driver
                .findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[14]"));
        WebElement FreeServicePaidServiceReported = driver
                .findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[15]"));
        WebElement PercentFreeServicePaidServiceReported = driver
                .findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[16]"));
        WebElement NotAttempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[17]"));
        WebElement NotConnected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[18]"));
        WebElement LabourRevenue = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[19]"));
        WebElement PartsRevenue = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[20]"));
        WebElement LabourPartsRevenue = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[21]"));

        Thread.sleep(1000);
        // GET THE VALUES

        w1 = TotalCampaignLeads.getText();
        w2 = LeadsAttempted.getText();
        w3 = FollowUp.getText();
        w4 = Connected.getText();
        w5 = AppointmentBooked.getText();
        w6 = PercentAppointmentBooked.getText();
        w7 = Reported.getText();
        w8 = PercentReported.getText();
        w9 = ReportedForFreeService.getText();
        w10 = PercentReportedForFreeService.getText();
        w11 = ReportedForPaidService.getText();
        w12 = PercentReportedForPaidService.getText();
        w13 = FreeServicePaidServiceReported.getText();
        w14 = PercentFreeServicePaidServiceReported.getText();
        w15 = NotAttempted.getText();
        w16 = NotConnected.getText();
        w17 = LabourRevenue.getText();
        w18 = PartsRevenue.getText();
        w19 = LabourPartsRevenue.getText();

        Thread.sleep(1000);

        try {
        	 // Parse the Total Due value to a numeric type
            Integer totalDueValue = Integer.parseInt(w1);
            if (totalDueValue <= 0 || w1 == null) {
                // Fail the test if Total Campaign Leads value is 0 or less
                Assert.fail("No Data Found for WorkShop_Wise Marketing campagin report: " + w1);
            } else {
                // Print the Total Campaign Leads value
                System.out.println(
                        "'Total Campaign Leads' column value of WorkShop Wise Tab Marketing campagin report::: " + w1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for WorkShop Wise Tab Marketing campagin report " + e.getMessage());
        }
    }

    //..........................................................................................................
    @Test(priority = 12)
    public void Day_Wise_Tab() throws InterruptedException {
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

		  // Elements of Day Wise
        WebElement TotalCampaignLeads = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[2]"));
        WebElement LeadsAttempted = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[3]"));
        WebElement FollowUp = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[4]"));
        WebElement Connected = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[5]"));
        WebElement AppointmentBooked = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[6]"));
        WebElement PercentAppointmentBooked = driver
                .findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[7]"));
        WebElement Reported = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[8]"));
        WebElement PercentReported = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[9]"));
        WebElement ReportedForFreeService = driver
                .findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[10]"));
        WebElement PercentReportedForFreeService = driver
                .findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[11]"));
        WebElement ReportedForPaidService = driver
                .findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[12]"));
        WebElement PercentReportedForPaidService = driver
                .findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[13]"));
        WebElement FreeServicePaidServiceReported = driver
                .findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[14]"));
        WebElement PercentFreeServicePaidServiceReported = driver
                .findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[15]"));
        WebElement NotAttempted = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[16]"));
        WebElement NotConnected = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[17]"));
        WebElement LabourRevenue = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[18]"));
        WebElement PartsRevenue = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[19]"));
        WebElement LabourPartsRevenue = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[20]"));

        Thread.sleep(1000);
        // GET THE VALUES
        day1 = TotalCampaignLeads.getText();
        day2 = LeadsAttempted.getText();
        day3 = FollowUp.getText();
        day4 = Connected.getText();
        day5 = AppointmentBooked.getText();
        day6 = PercentAppointmentBooked.getText();
        day7 = Reported.getText();
        day8 = PercentReported.getText();
        day9 = ReportedForFreeService.getText();
        day10 = PercentReportedForFreeService.getText();
        day11 = ReportedForPaidService.getText();
        day12 = PercentReportedForPaidService.getText();
        day13 = FreeServicePaidServiceReported.getText();
        day14 = PercentFreeServicePaidServiceReported.getText();
        day15 = NotAttempted.getText();
        day16 = NotConnected.getText();
        day17 = LabourRevenue.getText();
        day18 = PartsRevenue.getText();
        day19 = LabourPartsRevenue.getText();

        Thread.sleep(1000);

        try {

        	 Integer totalDueValue = Integer.parseInt(day1);
             if (totalDueValue <= 0 || day1 == null) {
                // Fail the test if Total Campaign Leads value is 0 or less
                Assert.fail("No Data Found for Day Wise Tab In-Marketing campagin report: " + day1);
            } else {
                // Print the Total Campaign Leads value
                System.out.println(
                        "'Total Campaign Leads' column value of Day Wise Tab In-Marketing campagin report ::: " + day1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Day Wise Tab  " + e.getMessage());
        }
    }		
    //..........................................................................................................
    @Test(priority = 13)
    public void SMRE_Wise() throws InterruptedException {
    	 Thread.sleep(1000);
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         // Click on the generate report button
         WebElement SMRE_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),\" Smre Wise\")]")));
         SMRE_Wise.click();
         Thread.sleep(2000);
         WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
         clickOnGenerate.click();
     		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));      
		  
     		// Elements of Day Wise
        WebElement TotalCampaignLeads = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[3]"));
        WebElement LeadsAttempted = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[4]"));
        WebElement FollowUp = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[5]"));
        WebElement Connected = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[6]"));
        WebElement AppointmentBooked = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[7]"));
        WebElement PercentAppointmentBooked = driver
                .findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[8]"));
        WebElement Reported = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[9]"));
        WebElement PercentReported = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[10]"));
        WebElement ReportedForFreeService = driver
                .findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[11]"));
        WebElement PercentReportedForFreeService = driver
                .findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[12]"));
        WebElement ReportedForPaidService = driver
                .findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[13]"));
        WebElement PercentReportedForPaidService = driver
                .findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[14]"));
        WebElement FreeServicePaidServiceReported = driver
                .findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[15]"));
        WebElement PercentFreeServicePaidServiceReported = driver
                .findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[16]"));
        WebElement NotAttempted = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[17]"));
        WebElement NotConnected = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[18]"));
        WebElement LabourRevenue = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[19]"));
        WebElement PartsRevenue = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[20]"));
        WebElement LabourPartsRevenue = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[21]"));

        Thread.sleep(1000);
        // GET THE VALUES
        SM1 = TotalCampaignLeads.getText();
        SM2 = LeadsAttempted.getText();
        SM3 = FollowUp.getText();
        SM4 = Connected.getText();
        SM5 = AppointmentBooked.getText();
        SM6 = PercentAppointmentBooked.getText();
        SM7 = Reported.getText();
        SM8 = PercentReported.getText();
        SM9 = ReportedForFreeService.getText();
        SM10 = PercentReportedForFreeService.getText();
        SM11 = ReportedForPaidService.getText();
        SM12 = PercentReportedForPaidService.getText();
        SM13 = FreeServicePaidServiceReported.getText();
        SM14 = PercentFreeServicePaidServiceReported.getText();
        SM15 = NotAttempted.getText();
        SM16 = NotConnected.getText();
        SM17 = LabourRevenue.getText();
        SM18 = PartsRevenue.getText();
        SM19 = LabourPartsRevenue.getText();

        Thread.sleep(1000);

        try {

        	 Integer totalDueValue = Integer.parseInt(SM1);
             if (totalDueValue <= 0 || SM1 == null) {
                // Fail the test if Total Campaign Leads value is 0 or less
                Assert.fail("No Data Found for SMRE wise Tab  report: " + SM1);
            } else {
                // Print the Total Campaign Leads value
                System.out.println(
                        "'Total Campaign Leads' column value of SMRE wise Tab report ::: " + SM1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for SMRE wise Tab  " + e.getMessage());
        }
    }	
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	   
    
    @Test(priority = 15)
    public void Comparison_0f_all_Data() throws InterruptedException {
    	    	
    	String[] dealerParentWise = {d1, d2, d3, d4, d5, d6, d7, d8,d9,d10,d11,d12,d13,
    			d14,d15,d16,d17,d18,d19};
    	String[] workshopWise = {w1, w2, w3, w4, w5, w6, w7, w8,w9,w10,w11,w12
    			,w13,w14,w15,w16,w17,w18,w19};
    	String[] dayWise = {day1, day2, day3, day4, day5, day6, day7, day8,day9,day10,day11,day12,
    			day13,day4, day15, day16, day17, day18,day19 };
                           
    	String[] SMRE = {s1, s2, s3, s4, s5, s6, s7, s8,s9, s10, s11, s12, s13, s14, s15, s16
    			,s17,s18,s19};
    	
    	
    	String[] comparisonLabels = {
    	    "TotalCampaignLeads", "LeadsAttempted", "FollowUp", "Connected", 
    	    "AppointmentBooked", "PercentAppointmentBooked", "Reported", "PercentReported",
    	 "ReportedForFreeService", "PercentReportedForFreeService", "ReportedForPaidService", "PercentReportedForPaidService", "FreeServicePaidServiceReported" ,
    	
    	 "PercentFreeServicePaidServiceReported", "NotAttempted", "NotConnected", "LabourRevenue",
    	 "PartsRevenue", "LabourPartsRevenue"};

    	for (int i = 0; i < dealerParentWise.length; i++) {
    	    Assert.assertEquals(dealerParentWise[i], workshopWise[i], "Compare " + comparisonLabels[i] + "_of_DealerParentWise_With_Workshop_Wise");
    	    Assert.assertEquals(dealerParentWise[i], dayWise[i], "Compare " + comparisonLabels[i] + "_of_DealerParentWise_With_Day_Wise");
    	    Assert.assertEquals(dealerParentWise[i], SMRE[i], "Compare " + comparisonLabels[i] + "_of_DealerParentWise_With_SMRE");
    	  
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
      // Perform double-click action
      Actions actions = new Actions(driver);
      actions.doubleClick(select).perform();   
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

   // Locate the "Generate" button
      WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
      clickOnGenerate.click();
  		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

  	}
  	
  }



