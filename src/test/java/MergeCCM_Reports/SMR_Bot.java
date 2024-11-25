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

public class SMR_Bot {
	
	public static WebDriver driver;
    public WebDriverWait wait;
   
   // String d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14;
    String w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11, w12, w13, w14,w15,w16,w17,w18,w19,w20,w21,w22,w23;
    String day1, day2, day3, day4, day5, day6, day7, day8, day9, day10, day11, day12, day13, day14,day15,day16,day17,day18,day19,day20,day21,day22,day23;
    String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14,s15,s16,s17,s18,s19,s20,s21,s22,s23;
    String SM1, SM2, SM3, SM4, SM5, SM6, SM7, SM8, SM9, SM10, SM11, SM12, SM13, SM14,SM15,SM16,SM17,SM18,SM19,SM20,SM21,SM22,SM23;

    @SuppressWarnings("static-access")
    @BeforeClass
    public void SMR() throws InterruptedException {
        // Initialize the driver (assuming it's static in the SMR_due_Datewise class)
        this.driver = HperLocal_Status.driver;

     // Initialize WebDriverWait with a timeout of 10 seconds using Duration
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
   //....................................................................................
  	@Test(priority = 7)
  	public void Click_Reports() throws InterruptedException {
  					  		
  		WebElement Reports = wait
  			    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Reports \"]")));

  			// Call the JavaScript Executor method instead of directly clicking
  			clickElementUsingJS(driver, Reports);
                Thread.sleep(3000);
  			  	}
//................................................................................................  	
    @Test(priority = 8)
    public void Click_On_SMR_Bot() throws InterruptedException {
    	wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement SMR_Bot = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"SMR Bot Status \"]")));
        clickElementUsingJS(driver, SMR_Bot);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));  			
			
    }    
  //.................................................................................................................
    @Test(priority = 9)
    public void WorkShop_Wise() throws InterruptedException {	       
    	
    	DateSelector();  			  		
      	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));  			

		  //Elements of Zone and Region Wise
        WebElement Total_LeadsRecieved = driver.findElement(By.xpath("//*[@id=\"excel-table\"]//tr[2]/td[3]"));	
        WebElement Total_Booking = driver.findElement(By.xpath("//*[@id=\"excel-table\"]//tr[2]/td[4]"));
        WebElement Total_Reported = driver.findElement(By.xpath("//*[@id=\"excel-table\"]//tr[2]/td[5]"));
        WebElement Total_Leads = driver.findElement(By.xpath("//*[@id=\"excel-table\"]//tr[2]/td[6]"));
        WebElement Fresh = driver.findElement(By.xpath("//*[@id=\"excel-table\"]//tr[2]/td[7]"));
        WebElement Pending = driver.findElement(By.xpath("//*[@id=\"excel-table\"]//tr[2]/td[8]"));
        WebElement FolloUp = driver.findElement(By.xpath("//*[@id=\"excel-table\"]//tr[2]/td[9]"));
        WebElement Appointment_Booked = driver.findElement(By.xpath("//*[@id=\"excel-table\"]//tr[2]/td[10]"));
        WebElement Reported = driver.findElement(By.xpath("//*[@id=\"excel-table\"]//tr[2]/td[11]"));
        WebElement Reported_At_Own = driver.findElement(By.xpath("//*[@id=\"excel-table\"]//tr[2]/td[12]"));
        WebElement Reported_at_same_Parent_Other_Outlet = driver.findElement(By.xpath("//*[@id=\"excel-table\"]//tr[2]/td[13]"));
        WebElement Reported_At_Other = driver.findElement(By.xpath("//*[@id=\"excel-table\"]//tr[2]/td[14]"));
        WebElement Lost = driver.findElement(By.xpath("//*[@id=\"excel-table\"]//tr[2]/td[15]"));
        WebElement Total_Leads2 = driver.findElement(By.xpath("//*[@id=\"excel-table\"]//tr[2]/td[16]"));
    
        WebElement Fresh2 = driver.findElement(By.xpath("//*[@id=\"excel-table\"]//tr[2]/td[17]"));
        WebElement Pending2 = driver.findElement(By.xpath("//*[@id=\"excel-table\"]//tr[2]/td[18]"));
        WebElement FolloUp2 = driver.findElement(By.xpath("//*[@id=\"excel-table\"]//tr[2]/td[19]"));
        WebElement Appointment_Booked2 = driver.findElement(By.xpath("//*[@id=\"excel-table\"]//tr[2]/td[20]"));
        WebElement Reported2 = driver.findElement(By.xpath("//*[@id=\"excel-table\"]//tr[2]/td[21]"));
        WebElement ReportedAt_Own2 = driver.findElement(By.xpath("//*[@id=\"excel-table\"]//tr[2]/td[22]"));
        WebElement Reported_at_same_Parent_Other_Outlet2 = driver.findElement(By.xpath("//*[@id=\"excel-table\"]//tr[2]/td[23]"));
        WebElement Reported_At_Other2 = driver.findElement(By.xpath("//*[@id=\"excel-table\"]//tr[2]/td[24]"));
        WebElement Lost2 = driver.findElement(By.xpath("//*[@id=\"excel-table\"]//tr[2]/td[25]"));
    
        Thread.sleep(1000);
        //GET THE VALUES

        w1 = Total_LeadsRecieved.getText();
        w2 = Total_Booking.getText();
        w3 = Total_Reported.getText();
        w4 = Total_Leads.getText();
        w5 = Fresh.getText();
        w6 = Pending.getText();
        w7 = FolloUp.getText();
        w8 = Appointment_Booked.getText();
        w9 = Reported.getText();
        w10 = Reported_At_Own.getText();
        w11 = Reported_at_same_Parent_Other_Outlet.getText();
        w12 = Reported_At_Other.getText();
        w13 = Lost.getText();
        w14 = Total_Leads2.getText();
        
        w15 = Fresh2.getText();
        w16= Pending2.getText();
        w17 = FolloUp2.getText();
        w18 = Appointment_Booked2.getText();
        w19 = Reported2.getText();
        w20 = ReportedAt_Own2.getText();
        w21 = Reported_at_same_Parent_Other_Outlet2.getText();
        w22 = Reported_At_Other2.getText();
        w23 = Lost2.getText();
        
        
        Thread.sleep(1000);
       
        try {

            // Parse the Total Due value to a numeric type
            double totalDueValue = Double.parseDouble(w1);

            if (totalDueValue <= 0 || w1 == null) {
                // Fail the test if Total Due value is 0 or less
                Assert.fail("No Data Found for WorkShop_Wise In SMR due Date wise : " + w1);
            } else {
                // Print the Total Due value
                System.out.println(" Total_LeadsRecieved of WorkShop_Wise In SMR due Date wise  ::: " + w1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for WorkShop_Wise  In SMR due Date wise " + e.getMessage());
        }
    }
    	 
    //..........................................................................................................

    @Test(priority = 10)
    public void Day_Wise() throws InterruptedException {
        Thread.sleep(1000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement Day_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Day Wise \"]")));
        Day_Wise.click();
        Thread.sleep(3000);

        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));  			

			  //Elements of Zone and Region Wise
	        WebElement Total_LeadsRecieved = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[2]"));	
	        WebElement Total_Booking = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[3]"));
	        WebElement Total_Reported = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[4]"));
	        WebElement Total_Leads = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[5]"));
	        WebElement Fresh = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[6]"));
	        WebElement Pending = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[7]"));
	        WebElement FolloUp = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[8]"));
	        WebElement Appointment_Booked = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[9]"));
	        WebElement Reported = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[10]"));
	        WebElement Reported_At_Own = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[11]"));
	        WebElement Reported_at_same_Parent_Other_Outlet = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[12]"));
	        WebElement Reported_At_Other = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[13]"));
	        WebElement Lost = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[14]"));
	        WebElement Total_Leads2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[15]"));
	    
	        WebElement Fresh2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[16]"));
	        WebElement Pending2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[17]"));
	        WebElement FolloUp2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[18]"));
	        WebElement Appointment_Booked2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[19]"));
	        WebElement Reported2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[20]"));
	        WebElement ReportedAt_Own2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[21]"));
	        WebElement Reported_at_same_Parent_Other_Outlet2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[22]"));
	        WebElement Reported_At_Other2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[23]"));
	        WebElement Lost2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[24]"));
	    
	        Thread.sleep(1000);
	        //GET THE VALUES

	        day1 = Total_LeadsRecieved.getText();
	        day2 = Total_Booking.getText();
	        day3 = Total_Reported.getText();
	        day4 = Total_Leads.getText();
	        day5 = Fresh.getText();
	        day6 = Pending.getText();
	        day7 = FolloUp.getText();
	        day8 = Appointment_Booked.getText();
	        day9 = Reported.getText();
	        day10 = Reported_At_Own.getText();
	        day11 = Reported_at_same_Parent_Other_Outlet.getText();
	        day12 = Reported_At_Other.getText();
	        day13 = Lost.getText();
	        day14 = Total_Leads2.getText();
	        
	        day15 = Fresh2.getText();
	        day16= Pending2.getText();
	        day17 = FolloUp2.getText();
	        day18 = Appointment_Booked2.getText();
	        day19 = Reported2.getText();
	        day20 = ReportedAt_Own2.getText();
	        day21 = Reported_at_same_Parent_Other_Outlet2.getText();
	        day22 = Reported_At_Other2.getText();
	        day23 = Lost2.getText();           
       
        Thread.sleep(1000);
        try {

            // Parse the Total Due value to a numeric type
            double totalDueValue = Double.parseDouble(day1);

            if (totalDueValue <= 0 || day1 == null) {
                // Fail the test if Total Due value is 0 or less
                Assert.fail("No Data Found for Day Wise In SMR due Date wise  : " + day1);
            } else {
                // Print the Total Due value
                System.out.println("Total_LeadsRecieved of Day_Wise In SMR due Date wise ::: " + day1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Day_Wise  In SMR due Date wise  " + e.getMessage());
        }
    }
    
  //...............................................................................................................

    @Test(priority = 11)
    public void Service_Type_Wise() throws InterruptedException {
        Thread.sleep(1000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement Service_Type_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Service Type Wise \"]")));
        Service_Type_Wise.click();

        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));  			
			  //Elements of Zone and Region Wise
	        WebElement Total_LeadsRecieved = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[2]"));	
	        WebElement Total_Booking = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[3]"));
	        WebElement Total_Reported = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[4]"));
	        WebElement Total_Leads = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[5]"));
	        WebElement Fresh = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[6]"));
	        WebElement Pending = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[7]"));
	        WebElement FolloUp = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[8]"));
	        WebElement Appointment_Booked = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[9]"));
	        WebElement Reported = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[10]"));
	        WebElement Reported_At_Own = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[11]"));
	        WebElement Reported_at_same_Parent_Other_Outlet = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[12]"));
	        WebElement Reported_At_Other = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[13]"));
	        WebElement Lost = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[14]"));
	        WebElement Total_Leads2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[15]"));
	    
	        WebElement Fresh2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[16]"));
	        WebElement Pending2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[17]"));
	        WebElement FolloUp2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[18]"));
	        WebElement Appointment_Booked2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[19]"));
	        WebElement Reported2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[20]"));
	        WebElement ReportedAt_Own2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[21]"));
	        WebElement Reported_at_same_Parent_Other_Outlet2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[22]"));
	        WebElement Reported_At_Other2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[23]"));
	        WebElement Lost2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[24]"));
	    
	        Thread.sleep(1000);
	        //GET THE VALUES

	        s1 = Total_LeadsRecieved.getText();
	        s2 = Total_Booking.getText();
	        s3 = Total_Reported.getText();
	        s4 = Total_Leads.getText();
	        s5 = Fresh.getText();
	        s6 = Pending.getText();
	        s7 = FolloUp.getText();
	        s8 = Appointment_Booked.getText();
	        s9 = Reported.getText();
	        s10 = Reported_At_Own.getText();
	        s11 = Reported_at_same_Parent_Other_Outlet.getText();
	        s12 = Reported_At_Other.getText();
	        s13 = Lost.getText();
	        s14 = Total_Leads2.getText();
	       
	        s15 = Fresh2.getText();
	        s16= Pending2.getText();
	        s17 = FolloUp2.getText();
	        s18 = Appointment_Booked2.getText();
	        s19 = Reported2.getText();
	        s20 = ReportedAt_Own2.getText();
	        s21 = Reported_at_same_Parent_Other_Outlet2.getText();
	        s22 = Reported_At_Other2.getText();
	        s23 = Lost2.getText();           
        
        Thread.sleep(1000);
        try {
            // Find the attribute value of Total Due
            // Parse the Total Due value to a numeric type
            double totalDueValue = Double.parseDouble(s1);

            if (totalDueValue <= 0 || s1 == null) {
                // Fail the test if Total Due value is 0 or less
                Assert.fail("No Data Found for Service Type Wise   In SMR due Date wise : " + s1);
            } else {
                // Print the Total Due value
                System.out.println("Total_LeadsRecieved of Service Type  Wise In SMR due Date wise ::: " + s1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Service Type Wise In SMR due Date wise  " + e.getMessage());
        }
    }
    //...............................................................................................................

    @Test(priority = 12)
    public void SMRE_Wise() throws InterruptedException {
        Thread.sleep(1000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement SMRE_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[normalize-space(text())=\"Smre Wise\"]")));
        SMRE_Wise.click();

        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));  			
			  //Elements of Zone and Region Wise
			 //Elements of Zone and Region Wise
	        WebElement Total_LeadsRecieved = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[2]"));	
	        WebElement Total_Booking = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[3]"));
	        WebElement Total_Reported = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[4]"));
	        WebElement Total_Leads = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[5]"));
	        WebElement Fresh = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[6]"));
	        WebElement Pending = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[7]"));
	        WebElement FolloUp = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[8]"));
	        WebElement Appointment_Booked = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[9]"));
	        WebElement Reported = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[10]"));
	        WebElement Reported_At_Own = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[11]"));
	        WebElement Reported_at_same_Parent_Other_Outlet = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[12]"));
	        WebElement Reported_At_Other = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[13]"));
	        WebElement Lost = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[14]"));
	        WebElement Total_Leads2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[15]"));
	    
	        WebElement Fresh2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[16]"));
	        WebElement Pending2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[17]"));
	        WebElement FolloUp2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[18]"));
	        WebElement Appointment_Booked2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[19]"));
	        WebElement Reported2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[20]"));
	        WebElement ReportedAt_Own2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[21]"));
	        WebElement Reported_at_same_Parent_Other_Outlet2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[22]"));
	        WebElement Reported_At_Other2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[23]"));
	        WebElement Lost2 = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[24]"));
	    
	        Thread.sleep(1000);
	        //GET THE VALUES

	        SM1 = Total_LeadsRecieved.getText();
	        SM2 = Total_Booking.getText();
	        SM3 = Total_Reported.getText();
	        SM4 = Total_Leads.getText();
	        SM5 = Fresh.getText();
	        SM6 = Pending.getText();
	        SM7 = FolloUp.getText();
	        SM8 = Appointment_Booked.getText();
	        SM9 = Reported.getText();
	        SM10 = Reported_At_Own.getText();
	        SM11 = Reported_at_same_Parent_Other_Outlet.getText();
	        SM12 = Reported_At_Other.getText();
	        SM13 = Lost.getText();
	        SM14 = Total_Leads2.getText();
	        
	        SM15 = Fresh2.getText();
	        SM16= Pending2.getText();
	        SM17 = FolloUp2.getText();
	        SM18 = Appointment_Booked2.getText();
	        SM19 = Reported2.getText();
	        SM20 = ReportedAt_Own2.getText();
	        SM21 = Reported_at_same_Parent_Other_Outlet2.getText();
	        SM22 = Reported_At_Other2.getText();
	        SM23 = Lost2.getText();           
       
        Thread.sleep(1000);
        try {
            // Find the attribute value of Total Due
            // Parse the Total Due value to a numeric type
            double totalDueValue = Double.parseDouble(SM1);

            if (totalDueValue <= 0 || SM1 == null) {
                // Fail the test if Total Due value is 0 or less
                Assert.fail("No Data Found for SMRE_Wise   In SMR due Date wise : " + SM1);
            } else {
                // Print the Total Due value
                System.out.println("Total_LeadsRecieved of SMRE_Wise  Wise In SMR due Date wise ::: " + SM1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for SMRE_Wise In SMR due Date wise  " + e.getMessage());
        }
    }
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	   
    
    @Test(priority = 14)
    public void Comparison_0f_all_Data() throws InterruptedException {
    	
    	
    	String[] workshopWise = {w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11, w12, w13, w14
    			                ,w15,w16,w17,w18,w19,w20,w22,w23};
    	
    	String[] dayWise = {day1, day2, day3, day4, day5, day6, day7, day8 , day9,day10, day11,
    	            day12, day13, day14,day15,day16,day17,day18,day19,day20,day21,day22,day23};
    	
    	String[] Service_TypeWise = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, 
    			                     s12, s13, s14,s15,s16,s17,s18,s19,s20,s21,s22,s23};
    	String[] SMRE_Wise = {SM1, SM2, SM3, SM4, SM5, SM6, SM7, SM8,
    			              SM9, SM10, SM11, SM12, SM13, SM14,SM15,
    			              SM16,SM17,SM18,SM19,SM20,SM21,SM22,SM23};

    	String[] comparisonLabels = {
    	    "Total_LeadsRecieved", "Total_Booking", "Total_Reported", "Total_Leads", 
    	    "Fresh", "Pending", "FolloUp", "Appointment_Booked", 
    	    "Reported", "Reported_At_Own", "Reported_at_same_Parent_Other_Outlet"
    	    , "Reported_At_Other", "Lost", "Total_Leads2"
    	      	    
    	   , "Fresh2", "Pending2", "FolloUp2"
    	    , "Appointment_Booked2", "Reported2", "ReportedAt_Own2" ,
    	    "Reported_at_same_Parent_Other_Outlet2", "Reported_At_Other2", "Lost2"
    	};

    	for (int i = 0; i < workshopWise.length; i++) {
    	    Assert.assertEquals(workshopWise[i], dayWise[i], "Compare " + comparisonLabels[i] + "_of_workshopWise_With_Day_Wise");
    	    Assert.assertEquals(workshopWise[i], Service_TypeWise[i], "Compare " + comparisonLabels[i] + "_of_workshopWise_With_Service_TypeWise");
    	    Assert.assertEquals(workshopWise[i], SMRE_Wise[i], "Compare " + comparisonLabels[i] + "_of_workshopWise_With_SMRE_Wise");

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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy"); 

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



