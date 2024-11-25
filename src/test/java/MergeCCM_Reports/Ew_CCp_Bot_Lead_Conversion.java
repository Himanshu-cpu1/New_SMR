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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ew_CCp_Bot_Lead_Conversion {

	public static WebDriver driver;
    public WebDriverWait wait;
   
    String d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14;
    String w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11, w12, w13, w14,w15,w16,w17,w18,w19,w20,w21,w22,w23;
    String day1, day2, day3, day4, day5, day6, day7, day8, day9, day10, day11, day12, day13, day14,day15,day16,day17,day18,day19,day20,day21,day22,day23;
    String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14,s15,s16,s17,s18,s19,s20,s21,s22,s23;
    String SM1, SM2, SM3, SM4, SM5, SM6, SM7, SM8, SM9, SM10, SM11, SM12, SM13, SM14,SM15,SM16,SM17,SM18,SM19,SM20,SM21,SM22,SM23;

    @SuppressWarnings("static-access")
    @BeforeClass
    public void SMR() throws InterruptedException {
        // Initialize the driver (assuming it's static in the SMR_due_Datewise class)
        this.driver = Booking_Conversio_Report.driver;

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
  //..................................................................................................
    @Test(priority = 8)
    public void Click_On_EW_CCP_bot_Lead_CONVERSION_REPORT() throws InterruptedException {
    	 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         WebElement EWCCP = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"EW-CCP Bot Lead Conversion \"]")));
         clickElementUsingJS(driver, EWCCP);
        Thread.sleep(4000);

    }
    
    //.................................Dealer Parent Group Wise tab.....................................................................................
    @Test(priority = 9)
    public void Dealer_Parent_Group_Wise_Tab() throws InterruptedException {
        Thread.sleep(1000);  
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement Campaign= driver.findElement(By.xpath("(//*[@role=\"combobox\"])[1]"));
        Campaign.click();        
        Thread.sleep(1000);       
        //select Campaign Name- ALL
        WebElement CampaignName= driver.findElement(By.xpath("//*[text()=\" All\"]"));
        CampaignName.click();
        Thread.sleep(1000);
        
        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();
	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

        //Elements of Dealer Parent Group Wise
        WebElement TotalLeadsRecieved = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));
        WebElement NotAttemptedLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
        WebElement NotConnectedLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
        WebElement ConnectedFollowUpLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
        WebElement ProposalSharedLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
        WebElement ReadyToPurchaseLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
        WebElement PurchaseCompletedLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
        WebElement PurchaseCancelledLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));

        Thread.sleep(1000);
        //GET THE VALUES
        d1 = TotalLeadsRecieved.getText();
        d2 = NotAttemptedLeads.getText();
        d3 = NotConnectedLeads.getText();
        d4 = ConnectedFollowUpLeads.getText();
        d5 = ProposalSharedLeads.getText();
        d6 = ReadyToPurchaseLeads.getText();
        d7 = PurchaseCompletedLeads.getText();
        d8 = PurchaseCancelledLeads.getText();
        Thread.sleep(1000);
        try {
            // Find the attribute value of 'Total Leads Recieved'

            // Parse the 'Total Leads Recieved' value to a numeric type
        	  Integer TotalLeadRecieved = Integer.parseInt(d1);

            if (TotalLeadRecieved <= 0 || d1 == null) {
                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
                Assert.fail("No Data Found for Dealer Parent Group Wise In EW-CCP-lead conversion_Report : " + d1);
            } else {
                // Print the 'Total Leads Recieved' value
                System.out.println("'TotalLeadsRecieved of Dealer Parent Group Wise Tab In EW-CCP-lead conversion_Report::: " + d1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Dealer Parent Group Wise Tab In EW-CCP-lead conversion_Report " + e.getMessage());
        }
    }
    
    //.................................Workshop_Wise_Tab.....................................................................................
    @Test(priority = 10)
    public void Workshop_Wise_Tab() throws InterruptedException {
        Thread.sleep(1000);  
        WebElement WorkShop_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Workshop Wise \"]")));
        WorkShop_Wise.click();
        Thread.sleep(3000);
        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();
	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

        //Elements of Dealer Parent Group Wise
        WebElement TotalLeadsRecieved = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[3]"));
        WebElement NotAttemptedLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[4]"));
        WebElement NotConnectedLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[5]"));
        WebElement ConnectedFollowUpLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[6]"));
        WebElement ProposalSharedLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[7]"));
        WebElement ReadyToPurchaseLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[8]"));
        WebElement PurchaseCompletedLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[9]"));
        WebElement PurchaseCancelledLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[10]"));
        Thread.sleep(1000);
        //GET THE VALUES
        w1 = TotalLeadsRecieved.getText();
        w2 = NotAttemptedLeads.getText();
        w3 = NotConnectedLeads.getText();
        w4 = ConnectedFollowUpLeads.getText();
        w5 = ProposalSharedLeads.getText();
        w6 = ReadyToPurchaseLeads.getText();
        w7 = PurchaseCompletedLeads.getText();
        w8 = PurchaseCancelledLeads.getText();
        Thread.sleep(1000);
        try {

            // Parse the 'Total Leads Recieved' value to a numeric type
            Integer TotalLeadRecieved = Integer.parseInt(w1);

            if (TotalLeadRecieved <= 0 ||w1 == null) {
                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
                Assert.fail("No Data Found for Workshop_Wise Wise In EW-CCP-lead conversion_Report : " + w1);
            } else {
                // Print the 'Total Leads Recieved' value
                System.out.println("'TotalLeadsRecieved of Workshop_Wise Wise Tab In EW-CCP-lead conversion_Report::: " + w1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Workshop_Wise Tab In EW-CCP-lead conversion_Report " + e.getMessage());
        }
    }
    //.................................Day_Wise.....................................................................................
    @Test(priority = 11)
    public void Day_Wise_Tab() throws InterruptedException {
        Thread.sleep(1000);
        WebElement Day_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Day Wise \"]")));
        Day_Wise.click();
        Thread.sleep(3000);
        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();
	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

        //Elements of Dealer Parent Group Wise
        WebElement TotalLeadsRecieved = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[2]"));
        WebElement NotAttemptedLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[3]"));
        WebElement NotConnectedLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[4]"));
        WebElement ConnectedFollowUpLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[5]"));
        WebElement ProposalSharedLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[6]"));
        WebElement ReadyToPurchaseLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[7]"));
        WebElement PurchaseCompletedLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[8]"));
        WebElement PurchaseCancelledLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[9]"));
        Thread.sleep(1000);
        //GET THE VALUES
        day1 = TotalLeadsRecieved.getText();
        day2 = NotAttemptedLeads.getText();
        day3 = NotConnectedLeads.getText();
        day4 = ConnectedFollowUpLeads.getText();
        day5 = ProposalSharedLeads.getText();
        day6 = ReadyToPurchaseLeads.getText();
        day7 = PurchaseCompletedLeads.getText();
        day8 = PurchaseCancelledLeads.getText();
        Thread.sleep(1000);
        try {

            // Parse the 'Total Leads Recieved' value to a numeric type
            Integer TotalLeadRecieved = Integer.parseInt( day1);

            if (TotalLeadRecieved <= 0 || day1 == null) {
                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
                Assert.fail("No Data Found for Day_Wise Wise In EW-CCP-lead conversion_Report : " +  day1);
            } else {
                // Print the 'Total Leads Recieved' value
                System.out.println("'TotalLeadsRecieved of Day_Wise Wise Tab In EW-CCP-lead conversion_Report::: " +  day1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Day_Wise Tab In EW-CCP-lead conversion_Report " + e.getMessage());
        }
    }
    
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	   
    
    @Test(priority = 14)
    public void Comparison_0f_all_Data() throws InterruptedException {
    	
    	String[] dealerParentWise = {d1, d2, d3, d4, d5, d6, d7, d8};
    	String[] workshopWise = {w1, w2, w3, w4, w5, w6, w7, w8};
    	String[] dayWise = {day1, day2, day3, day4, day5, day6, day7, day8};
    	

    	String[] comparisonLabels = {
    	    "TotalLeadsRecieved", "NotAttemptedLeads", "NotConnectedLeads", "ConnectedFollowUpLeads", 
    	    "ProposalSharedLeads", "ReadyToPurchaseLeads", "PurchaseCompletedLeads", "PurchaseCancelledLeads", 
    	};

    	for (int i = 0; i < dealerParentWise.length; i++) {
    	    Assert.assertEquals(dealerParentWise[i], workshopWise[i], "Compare " + comparisonLabels[i] + "_of_DealerParentWise_With_Workshop_Wise");
    	    Assert.assertEquals(dealerParentWise[i], dayWise[i], "Compare " + comparisonLabels[i] + "_of_DealerParentWise_With_Day_Wise");

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

