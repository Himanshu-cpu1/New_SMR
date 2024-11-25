package cCM_Reports;

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

public class Booking_Conversio_Report {
	public static WebDriver driver;
    public WebDriverWait wait;
   
    String d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14;
    String w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11, w12, w13, w14,w15,w16,w17,w18,w19,w20,w21,w22,w23;
    String day1, day2, day3, day4, day5, day6, day7, day8, day9, day10, day11, day12, day13, day14,day15,day16,day17,day18,day19,day20,day21,day22,day23;
    String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14,s15,s16,s17,s18,s19,s20,s21,s22,s23;
    String SM1, SM2, SM3, SM4, SM5, SM6, SM7, SM8, SM9, SM10, SM11, SM12, SM13, SM14,SM15,SM16,SM17,SM18,SM19,SM20,SM21,SM22,SM23;

    @SuppressWarnings("deprecation")
    @BeforeClass
    public void setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://dealercrm.co.in/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(16, TimeUnit.SECONDS);

    }
 // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 1)
    public void Username() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Username = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id=\"mat-input-0\"]")));
        Username.sendKeys("081001CCM00001");
        Thread.sleep(1000);
    }

    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 2)
    public void Password() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement password = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id=\"mat-input-1\"]")));
        password.sendKeys("Maruti@1234");
               
          Thread.sleep(1000);		    	    
        WebElement login_Button = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[type=\"submit\"]")));
        login_Button.click();
      
    }

    // >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test(priority = 3)
    public void Captcha() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        
      //.................Enter The Captcha ..................................................................
        WebElement Image = driver.findElement(By.xpath("(//*[@type=\"text\"])[1]"));
		
		String S1 = Image.getAttribute("value");
		System.out.println("captcha ::"+S1);
					
	    Thread.sleep(2000);		
        WebElement captcha_field = driver.findElement(By.cssSelector("[placeholder=\"Enter the captcha..\"]"));
	    captcha_field.sendKeys(S1);
    }

//.....................................................................................................

    @Test(priority = 4)
    public void SUBMIT_Button() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement Submit = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Submit\"]")));
        Submit.click();
         Thread.sleep(2000);
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
  //..................................................................................................
    @Test(priority = 8)
    public void Click_On_BOOKING_CONVERSION_REPORT() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement BookingConv = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Booking Conversion \"]")));
        clickElementUsingJS(driver, BookingConv);
        Thread.sleep(4000);

    }
    
    //......................................................................................................................
    @Test(priority = 8)
    public void Dealer_Parent_Group_Wise_Tab() throws InterruptedException {
        Thread.sleep(1000);           
        DateSelector(); 
      
        //Elements of Dealer Parent Wise
        WebElement PendingConfirmation = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));
        WebElement Confirmed = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
        WebElement ReScheduled = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
        WebElement ReportedAtOther = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
        WebElement ReportedAtSame_Parent_Other_Outlet = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));

        WebElement ReportedAtOwn = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
        WebElement JobCardOpen = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
        WebElement TotalBooking = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));

        Thread.sleep(1000);
        //GET THE VALUES

        d1 = PendingConfirmation.getText();
        d2 = Confirmed.getText();
        d3 = ReScheduled.getText();
        d4 = ReportedAtOther.getText();
        d5 = ReportedAtSame_Parent_Other_Outlet.getText();
        d6 = ReportedAtOwn.getText();
        d7 = JobCardOpen.getText();
        d8 = TotalBooking.getText();
        Thread.sleep(1000);
        
        try {

            // Parse the Total Due value to a numeric type
            double totalDueValue = Double.parseDouble(d1);

            if (totalDueValue <= 0 ||d1 == null) {
                // Fail the test if Total Due value is 0 or less
                Assert.fail("No Data Found for Dealer_Parent_Group_Wise In Booking_conversion : " + d1);
            } else {
                // Print the Total Due value
                System.out.println(" PendingConfirmation of Dealer_Parent_Group_Wise In Booking_conversion  ::: " + d1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Dealer_Parent_Group_Wise  In Booking_conversion " + e.getMessage());
        }
    }
    //......................................................................................................................
    @Test(priority = 9)
    public void Workshop_Wise_Tab() throws InterruptedException {
        Thread.sleep(1000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement WorkShop_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Workshop Wise \"]")));
        WorkShop_Wise.click();
        Thread.sleep(3000);
     // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();
	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

             
        //Elements of Dealer Parent Wise
        WebElement PendingConfirmation = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[3]"));
        WebElement Confirmed = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[4]"));
        WebElement ReScheduled = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[5]"));
        WebElement ReportedAtOther = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[6]"));
        WebElement ReportedAtSame_Parent_Other_Outlet = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[7]"));

        WebElement ReportedAtOwn = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[8]"));
        WebElement JobCardOpen = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[9]"));
        WebElement TotalBooking = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[10]"));

        Thread.sleep(1000);
        //GET THE VALUES

        w1 = PendingConfirmation.getText();
        w2 = Confirmed.getText();
        w3 = ReScheduled.getText();
        w4 = ReportedAtOther.getText();
        w5 = ReportedAtSame_Parent_Other_Outlet.getText();
        w6 = ReportedAtOwn.getText();
        w7 = JobCardOpen.getText();
        w8 = TotalBooking.getText();
        Thread.sleep(1000);
        
        try {

            // Parse the Total Due value to a numeric type
            double totalDueValue = Double.parseDouble(w1);

            if (totalDueValue <= 0 ||w1 == null) {
                // Fail the test if Total Due value is 0 or less
                Assert.fail("No Data Found for Workshop_Wise In Booking_conversion : " + w1);
            } else {
                // Print the Total Due value
                System.out.println(" PendingConfirmation of Workshop_Wise In Booking_conversion  ::: " +w1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Workshop_Wise  In Booking_conversion " + e.getMessage());
        }
    } 
    
    //......................................................................................................................
    @Test(priority = 10)
    public void Day_Wise_Tab() throws InterruptedException {
        Thread.sleep(1000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement Day_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Day Wise \"]")));
        Day_Wise.click();
        Thread.sleep(3000);
     // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();
	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

             
        //Elements of Dealer Parent Wise
        WebElement PendingConfirmation = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[2]"));
        WebElement Confirmed = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[3]"));
        WebElement ReScheduled = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[4]"));
        WebElement ReportedAtOther = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[5]"));
        WebElement ReportedAtSame_Parent_Other_Outlet = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[6]"));

        WebElement ReportedAtOwn = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[7]"));
        WebElement JobCardOpen = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[8]"));
        WebElement TotalBooking = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[9]"));

        Thread.sleep(1000);
        //GET THE VALUES

        day1 = PendingConfirmation.getText();
        day2 = Confirmed.getText();
        day3 = ReScheduled.getText();
        day4 = ReportedAtOther.getText();
        day5 = ReportedAtSame_Parent_Other_Outlet.getText();
        day6 = ReportedAtOwn.getText();
        day7 = JobCardOpen.getText();
        day8 = TotalBooking.getText();
        Thread.sleep(1000);
        
        try {

            // Parse the Total Due value to a numeric type
            double totalDueValue = Double.parseDouble( day1);

            if (totalDueValue <= 0 || day1 == null) {
                // Fail the test if Total Due value is 0 or less
                Assert.fail("No Data Found for Day_Wise In Booking_conversion : " +  day1);
            } else {
                // Print the Total Due value
                System.out.println(" PendingConfirmation of Day_Wise In Booking_conversion  ::: " + day1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Day_Wise  In Booking_conversion " + e.getMessage());
        }
    }
  //......................................................................................................................
    @Test(priority = 11)
    public void ServiceType_Wise_Tab() throws InterruptedException {
        Thread.sleep(1000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement Service_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Service Type Wise \"]")));
        Service_Wise.click();
        Thread.sleep(3000);;
     // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();
	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

             
        //Elements of Dealer Parent Wise
        WebElement PendingConfirmation = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[2]"));
        WebElement Confirmed = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[3]"));
        WebElement ReScheduled = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[4]"));
        WebElement ReportedAtOther = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[5]"));
        WebElement ReportedAtSame_Parent_Other_Outlet = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[6]"));

        WebElement ReportedAtOwn = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[7]"));
        WebElement JobCardOpen = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[8]"));
        WebElement TotalBooking = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[9]"));

        Thread.sleep(1000);
        //GET THE VALUES

        s1 = PendingConfirmation.getText();
        s2 = Confirmed.getText();
        s3 = ReScheduled.getText();
        s4 = ReportedAtOther.getText();
        s5 = ReportedAtSame_Parent_Other_Outlet.getText();
        s6 = ReportedAtOwn.getText();
        s7 = JobCardOpen.getText();
        s8 = TotalBooking.getText();
        Thread.sleep(1000);
        
        try {

            // Parse the Total Due value to a numeric type
            double totalDueValue = Double.parseDouble( s1);

            if (totalDueValue <= 0 || s1 == null) {
                // Fail the test if Total Due value is 0 or less
                Assert.fail("No Data Found for ServiceType_Wise In Booking_conversion : " +  s1);
            } else {
                // Print the Total Due value
       System.out.println(" PendingConfirmation of ServiceType_Wise In Booking_conversion  ::: " + s1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for ServiceType_Wise  In Booking_conversion " + e.getMessage());
        }
    }
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	   
    
    @Test(priority = 14)
    public void Comparison_0f_all_Data() throws InterruptedException {
    	
    	String[] dealerParentWise = {d1, d2, d3, d4, d5, d6, d7, d8};
    	String[] workshopWise = {w1, w2, w3, w4, w5, w6, w7, w8};
    	String[] dayWise = {day1, day2, day3, day4, day5, day6, day7, day8};
    	String[] Service_TypeWise = {s1, s2, s3, s4, s5, s6, s7, s8};

    	String[] comparisonLabels = {
    	    "PendingConfirmation", "Confirmed", "ReScheduled", "ReportedAtOther", 
    	    "ReportedAtSame_Parent_Other_Outlet", "ReportedAtOwn", "JobCardOpen", "TotalBooking", 
    	};

    	for (int i = 0; i < dealerParentWise.length; i++) {
    	    Assert.assertEquals(dealerParentWise[i], workshopWise[i], "Compare " + comparisonLabels[i] + "_of_DealerParentWise_With_Workshop_Wise");
    	    Assert.assertEquals(dealerParentWise[i], dayWise[i], "Compare " + comparisonLabels[i] + "_of_DealerParentWise_With_Day_Wise");
    	    Assert.assertEquals(dealerParentWise[i], Service_TypeWise[i], "Compare " + comparisonLabels[i] + "_of_DealerParentWise_With_Service_TypeWise");

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




