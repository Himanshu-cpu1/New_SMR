package cCM_Reports;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
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

public class Website_Lead_report {

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
  	 	  	
 // ..............................................................................................................
 	@Test(priority = 9) 	
 		  public void Click_On_Website_lead_Report() throws InterruptedException {
 		      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 		      WebElement Cross = wait
 		     .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Website Lead Report \"]")));
             clickElementUsingJS(driver, Cross);
             wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));		
 	}
 	 // ...............................................................................................
    @Test(priority = 10)
    public void Dealer_Parent_Group_Wise() throws InterruptedException {
        Thread.sleep(1000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        DateSelector();	
        // Proceed with the rest of your element locators and text retrievals
        WebElement Lead_Generated = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));
        WebElement Lead_attempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
        WebElement Total_connected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
        WebElement followup = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
        WebElement appointment_booked = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
        WebElement appointment_booked_percent = driver
                .findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
        WebElement Total_reported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
        WebElement Total_Reported_PERCENT = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
        WebElement Reported_At_OWN = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
        WebElement Reported_At_Same_Parent_Other_Outlet = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));

        WebElement Reported_At_Other = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[12]"));
        WebElement Not_Connected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[13]"));
        WebElement Not_Attempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[14]"));

        Thread.sleep(1000);       
        d1  =Lead_Generated.getText();
        d2 = Lead_attempted.getText();
        d3 = Total_connected.getText();
        d4 = followup.getText();
        d5 = appointment_booked.getText();
        d6 = appointment_booked_percent.getText();
        d7 = Total_reported.getText();
        d8 = Total_Reported_PERCENT.getText();
        d9 = Reported_At_OWN.getText();
       
        d10=Reported_At_Same_Parent_Other_Outlet.getText();
        d11 = Reported_At_Other.getText();
        d12 = Not_Connected.getText();
        d13 = Not_Attempted.getText();

        Thread.sleep(1000);
        try {
            // Parse the Total Due value to a numeric type
            Integer totalDueValue = Integer.parseInt(d1);

            if (totalDueValue <= 0) {

                // Fail the test if Total Due value is 0 or less
                Assert.fail("No Data Found for Dealer_parent_Group_Wise  Lead Generated   In website Lead Report:: " + d1);
            } else {
                // Print the Total Due value
                 System.out.println("Lead_Generated of Dealer_parent_Group_Wise::: " + d1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Dealer_parent_Group_Wise of Lead Generated  In website Lead Report: " + e.getMessage());
        }
    }
    
    // ...............................................................................................
    @Test(priority = 11)
    public void WorkShop_Wise() throws InterruptedException {
        Thread.sleep(1000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Click on the generate report button
        WebElement WorkShop_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Workshop Wise \"]")));
        WorkShop_Wise.click();
        Thread.sleep(3000);
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

        // Proceed with the rest of your element locators and text retrievals
        WebElement Lead_Generated = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[3]"));
        WebElement Lead_attempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[4]"));
        WebElement Total_connected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[5]"));
        WebElement followup = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[6]"));
        WebElement appointment_booked = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[7]"));
        WebElement appointment_booked_percent = driver
                .findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[8]"));
        WebElement Total_reported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[9]"));
        WebElement Total_Reported_PERCENT = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[10]"));
        WebElement Reported_At_OWN = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[11]"));
        WebElement Reported_At_Same_Parent_Other_Outlet = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[12]"));

        WebElement Reported_At_Other = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[13]"));
        WebElement Not_Connected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[14]"));
        WebElement Not_Attempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[15]"));

        Thread.sleep(1000);       
        w1  =Lead_Generated.getText();
        w2 = Lead_attempted.getText();
        w3 = Total_connected.getText();
        w4 = followup.getText();
        w5 = appointment_booked.getText();
        w6 = appointment_booked_percent.getText();
        w7 = Total_reported.getText();
        w8 = Total_Reported_PERCENT.getText();
        w9 = Reported_At_OWN.getText();
        w10=Reported_At_Same_Parent_Other_Outlet.getText();
        w11 = Reported_At_Other.getText();
        w12 = Not_Connected.getText();
        w13 = Not_Attempted.getText();

        Thread.sleep(1000);
        try {
            // Parse the Total Due value to a numeric type
            Integer totalDueValue = Integer.parseInt(w1);

            if (totalDueValue <= 0) {

                // Fail the test if Total Due value is 0 or less
                Assert.fail("No Data Found for WorkShop_Wise  Lead Generated   In website Lead Report:: " + w1);
            } else {
                // Print the Total Due value
                 System.out.println("Lead_Generated of WorkShop_Wise::: " + w1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for WorkShop_Wise of Lead Generated  In website Lead Report: " + e.getMessage());
        }
    }
	 // ...............................................................................................
    @Test(priority = 12)
    public void Day_Wise() throws InterruptedException {
        Thread.sleep(1000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Day_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Day Wise \"]")));
        Day_Wise.click();
        Thread.sleep(3000);
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

        // Proceed with the rest of your element locators and text retrievals
        WebElement Lead_Generated = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[2]"));
        WebElement Lead_attempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[3]"));
        WebElement Total_connected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[4]"));
        WebElement followup = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[5]"));
        WebElement appointment_booked = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[6]"));
        WebElement appointment_booked_percent = driver
                .findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[7]"));
        WebElement Total_reported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[8]"));
        WebElement Total_Reported_PERCENT = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[9]"));
        WebElement Reported_At_OWN = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[10]"));
        WebElement Reported_At_Same_Parent_Other_Outlet = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[11]"));

        WebElement Reported_At_Other = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[12]"));
        WebElement Not_Connected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[13]"));
        WebElement Not_Attempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[14]"));

        Thread.sleep(1000);       
        day1  =Lead_Generated.getText();
        day2 = Lead_attempted.getText();
        day3 = Total_connected.getText();
        day4 = followup.getText();
        day5 = appointment_booked.getText();
        day6 = appointment_booked_percent.getText();
        day7 = Total_reported.getText();
        day8 = Total_Reported_PERCENT.getText();
        day9 = Reported_At_OWN.getText();
     
        day10=Reported_At_Same_Parent_Other_Outlet.getText();
        day11 = Reported_At_Other.getText();
        day12 = Not_Connected.getText();
        day13 = Not_Attempted.getText();

        Thread.sleep(1000);
        try {
            // Parse the Total Due value to a numeric type
            Integer totalDueValue = Integer.parseInt(day1);

            if (totalDueValue <= 0) {

                // Fail the test if Total Due value is 0 or less
                Assert.fail("No Data Found for Day_Wise  Lead Generated   In website Lead Report:: " + day1);
            } else {
                // Print the Total Due value
                 System.out.println("Lead_Generated of Day_Wise::: " + day1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Day_Wise of Lead Generated  In website Lead Report: " + e.getMessage());
        }
    }
    // ...............................................................................................
    @Test(priority = 13)
    public void SMRE_Wise() throws InterruptedException {
        Thread.sleep(1000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Click on the generate report button
        WebElement SMRE_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Smre Wise \"]")));
        SMRE_Wise.click();
        Thread.sleep(2000);
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();
    		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

        // Proceed with the rest of your element locators and text retrievals
        WebElement Lead_Generated = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[3]"));
        WebElement Lead_attempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[4]"));
        WebElement Total_connected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[5]"));
        WebElement followup = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[6]"));
        WebElement appointment_booked = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[7]"));
        WebElement appointment_booked_percent = driver
                .findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[8]"));
        WebElement Total_reported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[9]"));
        WebElement Total_Reported_PERCENT = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[10]"));
        WebElement Reported_At_OWN = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[11]"));
      //  WebElement Reported_At_Same_Parent_Other_Outlet = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[12]"));

        WebElement Reported_At_Other = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[12]"));
        WebElement Not_Connected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[13]"));
        WebElement Not_Attempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[14]"));

        Thread.sleep(1000);       
        SM1  =Lead_Generated.getText();
        SM2 = Lead_attempted.getText();
        SM3 = Total_connected.getText();
        SM4 = followup.getText();
        SM5 = appointment_booked.getText();
        SM6 = appointment_booked_percent.getText();
        SM7 = Total_reported.getText();
        SM8 = Total_Reported_PERCENT.getText();
        SM9 = Reported_At_OWN.getText();     
        SM10 = Reported_At_Other.getText();
        SM11 = Not_Connected.getText();
        SM12 = Not_Attempted.getText();

        Thread.sleep(1000);
        try {
            // Parse the Total Due value to a numeric type
            Integer totalDueValue = Integer.parseInt(SM1);

            if (totalDueValue <= 0) {

                // Fail the test if Total Due value is 0 or less
                Assert.fail("No Data Found for SMRE_Wise  Lead Generated   In website Lead Report:: " + SM1);
            } else {
                // Print the Total Due value
                 System.out.println("Lead_Generated of SMRE_Wise::: " + SM1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for SMRE_Wise of Lead Generated  In website Lead Report: " + e.getMessage());
        }
    }
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	   
    
    @Test(priority = 15)
    public void Comparison_0f_all_Data() throws InterruptedException {
    	    	
    	String[] dealerParentWise = {d1, d2, d3, d4, d5, d6, d7, d8,d9,d10,d11,d12,d13};
    	String[] workshopWise = {w1, w2, w3, w4, w5, w6, w7, w8,w9,w10,w11,w12,w13};
    	String[] dayWise = {day1, day2, day3, day4, day5, day6, day7, day8,day9,day10,day11,day12,day13 };
                           
    //	String[] SMRE = {s1, s2, s3, s4, s5, s6, s7, s8};
    	

    	String[] comparisonLabels = {
    	    "Lead_Generated", "Lead_attempted", "Total_connected", "followup", 
    	    "appointment_booked", "appointment_booked_percent", "Total_reported", "Total_Reported_PERCENT",
    	 "Reported_At_OWN", "Reported_At_Same_Parent_Other_Outlet", "Reported_At_Other", "Not_Connected", "Not_Attempted" };
    	

    	for (int i = 0; i < dealerParentWise.length; i++) {
    	    Assert.assertEquals(dealerParentWise[i], workshopWise[i], "Compare " + comparisonLabels[i] + "_of_DealerParentWise_With_Workshop_Wise");
    	    Assert.assertEquals(dealerParentWise[i], dayWise[i], "Compare " + comparisonLabels[i] + "_of_DealerParentWise_With_Day_Wise");
    	//    Assert.assertEquals(dealerParentWise[i], SMRE[i], "Compare " + comparisonLabels[i] + "_of_DealerParentWise_With_SMRE");
    	  
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


