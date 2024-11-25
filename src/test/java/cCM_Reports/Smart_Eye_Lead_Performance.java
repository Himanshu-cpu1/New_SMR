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

public class Smart_Eye_Lead_Performance {
	public static WebDriver driver;
    public WebDriverWait wait;
   
    String d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14;
    String w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11, w12, w13, w14,w15,w16,w17,w18,w19,w20,w21,w22,w23;
    String day1, day2, day3, day4, day5, day6, day7, day8, day9, day10, day11, day12, day13, day14,day15,day16,day17,day18,day19,day20,day21,day22,day23;
    String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14,s15,s16,s17,s18,s19,s20,s21,s22,s23;
 //   String SM1, SM2, SM3, SM4, SM5, SM6, SM7, SM8, SM9, SM10, SM11, SM12, SM13, SM14,SM15,SM16,SM17,SM18,SM19,SM20,SM21,SM22,SM23;

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
    public void Click_On_Smart_Eye_Lead_Perfomrnace_REPORT() throws InterruptedException {
    	 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	 WebElement Smart_Eye = wait.until(
                 ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Smart Eye Lead Performance \"]")));       
         clickElementUsingJS(driver, Smart_Eye);
        Thread.sleep(4000);
    }
   //..................................................................................................
    @Test(priority = 9)
    public void Workshop_Wise() throws InterruptedException {
        Thread.sleep(1000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Workshop_Wise = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Workshop Wise \"]")));
        Workshop_Wise.click();
        Thread.sleep(4000);
        DateSelector();        
        // Proceed with the rest of your element locators and text retrievals
        WebElement Total_Lead_Recived = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[2]"));
        WebElement Actual_Earning = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[3]"));
        WebElement Total_Reported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[4]"));
        WebElement Total_Booking = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[5]"));
        WebElement Fresh = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[6]"));
        WebElement Pending_Fresh = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[7]"));
        WebElement Follow_up_and_Pending_FollowUp = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[8]"));
        WebElement Refused = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[9]"));

        Thread.sleep(1000);
        w1 = Total_Lead_Recived.getText();
        w2 = Actual_Earning.getText();
        w3 = Total_Reported.getText();
        w4 = Total_Booking.getText();
        w5 = Fresh.getText();
        w6 = Pending_Fresh.getText();
        w7 = Follow_up_and_Pending_FollowUp.getText();
        w8 = Refused.getText();

        Thread.sleep(1000);

        try {
        	 // Parse the 'Total Leads Recieved' value to a numeric type
            Integer TotalLeadRecieved = Integer.parseInt( w1);

            if (TotalLeadRecieved <= 0 || w1 == null) {
                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
                Assert.fail("No Data Found for Workshop_Wise Wise In Smart_EyeLead_Performance : " +  w1);
            } else {
                // Print the 'Total Leads Recieved' value
                System.out.println("'TotalLeadsRecieved of Workshop_Wise Wise Tab In Smart_EyeLead_Performance_Report::: " + w1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Workshop_Wise Tab In Smart_EyeLead_Performance_Report " + e.getMessage());
        }
    }
    //..................................................................................................
    @Test(priority =10)
    public void Day_Wise() throws InterruptedException {
        Thread.sleep(2000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Day_Wise = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Day Wise \"]")));
        Day_Wise.click();
        Thread.sleep(3000);       
        // Click on the generate report button
        WebElement clickOnGenerate = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

        // Proceed with the rest of your element locators and text retrievals
        WebElement Total_Lead_Recived = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[2]"));
        WebElement Actual_Earning = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[3]"));
        WebElement Total_Reported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[4]"));
        WebElement Total_Booking = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[5]"));
        WebElement Fresh = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[6]"));
        WebElement Pending_Fresh = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[7]"));
        WebElement Follow_up_and_Pending_FollowUp = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[8]"));
        WebElement Refused = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[9]"));

        Thread.sleep(1000);
       day1 = Total_Lead_Recived.getText();
       day2 = Actual_Earning.getText();
       day3 = Total_Reported.getText();
       day4 = Total_Booking.getText();
       day5 = Fresh.getText();
       day6 = Pending_Fresh.getText();
       day7 = Follow_up_and_Pending_FollowUp.getText();
       day8 = Refused.getText();

        Thread.sleep(1000);

        try {
        	 // Parse the 'Total Leads Recieved' value to a numeric type
            Integer TotalLeadRecieved = Integer.parseInt( day1);

            if (TotalLeadRecieved <= 0 || day1 == null) {
                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
                Assert.fail("No Data Found for Day_Wise Wise In Smart_EyeLead_Performance : " +  day1);
            } else {
                // Print the 'Total Leads Recieved' value
                System.out.println("'TotalLeadsRecieved of Day_Wise Wise Tab In Smart_EyeLead_Performance_Report::: " + day1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Day_Wise Tab In Smart_EyeLead_Performance_Report " + e.getMessage());
        }
    }  
    //..................................................................................................
    @Test(priority =11)
    public void User_Wise() throws InterruptedException {
        Thread.sleep(1000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement User_Wise = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" User Wise \"]")));
        User_Wise.click();
        Thread.sleep(3000);       
        // Click on the generate report button
        WebElement clickOnGenerate = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

        // Proceed with the rest of your element locators and text retrievals
        WebElement Total_Lead_Recived = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[2]"));
        WebElement Actual_Earning = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[3]"));
        WebElement Total_Reported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[4]"));
        WebElement Total_Booking = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[5]"));
        WebElement Fresh = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[6]"));
        WebElement Pending_Fresh = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[7]"));
        WebElement Follow_up_and_Pending_FollowUp = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[8]"));
        WebElement Refused = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[9]"));

        Thread.sleep(1000);
       s1 = Total_Lead_Recived.getText();
       s2 = Actual_Earning.getText();
       s3 = Total_Reported.getText();
       s4 = Total_Booking.getText();
       s5 = Fresh.getText();
       s6 = Pending_Fresh.getText();
       s7 = Follow_up_and_Pending_FollowUp.getText();
       s8 = Refused.getText();

        Thread.sleep(1000);

        try {
        	 // Parse the 'Total Leads Recieved' value to a numeric type
            Integer TotalLeadRecieved = Integer.parseInt( s1);

            if (TotalLeadRecieved <= 0 ||s1 == null) {
                // Fail the test if 'Total Leads Recieved' column Value is 0 or less
                Assert.fail("No Data Found for User_Wise Wise In Smart_EyeLead_Performance : " +  s1);
            } else {
                // Print the 'Total Leads Recieved' value
                System.out.println("'TotalLeadsRecieved of User_Wise Wise Tab In Smart_EyeLead_Performance_Report::: " + s1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for User_Wise Tab In Smart_EyeLead_Performance_Report " + e.getMessage());
        }
    }  
    
    
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	   
    
    @Test(priority = 14)
    public void Comparison_0f_all_Data() throws InterruptedException {
    	
    	
    	String[] workshopWise = {w1, w2, w3, w4, w5, w6, w7, w8};
    	String[] dayWise = {day1, day2, day3, day4, day5, day6, day7, day8};
    	String[] UserWise = {s1, s2, s3, s4, s5, s6, s7, s8};

    	String[] comparisonLabels = {
    	    "Total_Lead_Recived", "Actual_Earning", "Total_Reported", "Total_Booking", 
    	    "Fresh", "Pending_Fresh", "Follow_up_and_Pending_FollowUp", "Refused", 
    	};

    	for (int i = 0; i < workshopWise.length; i++) {
    	    Assert.assertEquals(workshopWise[i], dayWise[i], "Compare " + comparisonLabels[i] + " of workshopWise With  dayWise");
    	    Assert.assertEquals(workshopWise[i], UserWise[i], "Compare " + comparisonLabels[i] + "of workshopWise With  UserWise");

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
