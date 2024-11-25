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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HperLocal_Status {

	
	public static WebDriver driver;
    public WebDriverWait wait;
   
   // String d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14;
   // String w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11, w12, w13, w14,w15,w16,w17,w18,w19,w20,w21,w22,w23;
  //  String day1, day2, day3, day4, day5, day6, day7, day8, day9, day10, day11, day12, day13, day14,day15,day16,day17,day18,day19,day20,day21,day22,day23;
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
        password.sendKeys("Maruti@123");
               
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
//................................................................................................  	
    @Test(priority = 8)
    public void Click_On_HyperLocal() throws InterruptedException {
    	 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         WebElement Hyperlocal = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Hyperlocal Status \"]")));        
        clickElementUsingJS(driver, Hyperlocal);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));  			
			
    }   
    
    //........................................................................................................................
    @Test(priority =9)
    public void Summary_Report() throws InterruptedException {
    	
    	WebElement Workshop_name = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@role=\"combobox\"])[1]")));
    	 Workshop_name.click();
    	 Thread.sleep(2000);
    	 WebElement Select_all = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class=\"mat-option-text\"])[1]")));
    	 Select_all.click();   	 
    	 Thread.sleep(1000);
    	
    	 DateSelector();  			  		
      	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));  			
        //set item per page as 100

        WebElement ItemPerPage = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[5]"));
        ItemPerPage.click();


        WebElement Items = driver.findElement(By.xpath("(//*[@role=\"option\"])[4]"));
        Items.click();
        Thread.sleep(3000);

        boolean lastPageReached = false;

        while (!lastPageReached) {
            // Check if the next page button is disabled
            WebElement nextPageButton = driver.findElement(By.xpath("(//*[@type=\"button\"])[8]"));

            if (!nextPageButton.isEnabled()) {
                lastPageReached = true;
            } else {
                // Click on the next page button
              //  nextPageButton = driver.findElement(By.xpath("(//*[@type=\"button\"])[8]"));
                nextPageButton.click();
                Thread.sleep(3000);
            }
        }

        //Elements of Dealer Parent Wise
        WebElement LeadGenerated = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));
        WebElement LeadAttempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
        WebElement FollowUp = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
        WebElement TotalConnected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
        WebElement RegNoConfirmed = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
        WebElement RegNoNotConfirmed = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
        WebElement AppointmentBooked = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
        WebElement PercentAppointmentBooked = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
        WebElement TotalReported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
        WebElement PercentReported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
        WebElement Reported_At_same_Parent_Other_oultet = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[12]"));
        WebElement ReportedAtOwn = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[13]"));
        WebElement ReportedAtOther = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[14]"));
        WebElement NotConnected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[15]"));
        WebElement NotAttempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[16]"));

        Thread.sleep(1000);
        //GET THE VALUES

        s1 = LeadGenerated.getText();
        s2 = LeadAttempted.getText();
        s3 = FollowUp.getText();
        s4 = TotalConnected.getText();
        s5 = RegNoConfirmed.getText();
        s6 = RegNoNotConfirmed.getText();
        s7 = AppointmentBooked.getText();
        s8 = PercentAppointmentBooked.getText();
        s9 = TotalReported.getText();
        s10 = PercentReported.getText();
        s11 =Reported_At_same_Parent_Other_oultet.getText();
        s12 = ReportedAtOwn.getText();
        s13 = ReportedAtOther.getText();
        s14 = NotConnected.getText();
        s15 = NotAttempted.getText();
        Thread.sleep(1000);
        
        try {

            // Parse the Total Due value to a numeric type
            double totalDueValue = Double.parseDouble(s1);

            if (totalDueValue <= 0 ||s1 == null) {
                // Fail the test if Total Due value is 0 or less
                Assert.fail("No Data Found for Summary_Report In HyperLocal_Status : " + s1);
            } else {
                // Print the Total Due value
                System.out.println(" LeadGenerated of Summary_Report In HyperLocal_Status  ::: " + s1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Summary_Report  In HyperLocal_Status " + e.getMessage());
        }
    }
   //..................................................................................
    @Test(priority = 11)
    public void SMRE_Report() throws InterruptedException {
        Thread.sleep(1000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement SMRE_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[normalize-space(text())=\"Smre Report\"]")));
        SMRE_Wise.click();
        Thread.sleep(3000);
        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

	   wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));  			

        WebElement ItemPerPage = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[5]"));
        ItemPerPage.click();
        WebElement Items = driver.findElement(By.xpath("(//*[@role=\"option\"])[4]"));
        Items.click();
        Thread.sleep(1000);

        boolean lastPageReached = false;

        while (!lastPageReached) {
            // Check if the next page button is disabled
            WebElement nextPageButton = driver.findElement(By.xpath("(//*[@type=\"button\"])[8]"));

            if (!nextPageButton.isEnabled()) {
                lastPageReached = true;
            } else {
                // Click on the next page button
              //  nextPageButton = driver.findElement(By.xpath("(//*[@type=\"button\"])[8]"));
                nextPageButton.click();
                Thread.sleep(1000);
            }
        }

        //Elements of Dealer Parent Wise
        WebElement LeadGenerated = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[2]"));
        WebElement LeadAttempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[3]"));
        WebElement FollowUp = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[4]"));
        WebElement TotalConnected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[5]"));
        WebElement RegNoConfirmed = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[6]"));
        WebElement RegNoNotConfirmed = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[7]"));
        WebElement AppointmentBooked = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[8]"));
        WebElement PercentAppointmentBooked = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[9]"));
        WebElement TotalReported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[10]"));
        WebElement PercentReported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[11]"));
        WebElement Reported_At_same_Parent_Other_oultet = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[12]"));
        WebElement ReportedAtOwn = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[13]"));
        WebElement ReportedAtOther = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[14]"));
        WebElement NotConnected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[15]"));
        WebElement NotAttempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[16]"));

        Thread.sleep(1000);
        //GET THE VALUES

        SM1 = LeadGenerated.getText();
        SM2 = LeadAttempted.getText();
        SM3 = FollowUp.getText();
        SM4 = TotalConnected.getText();
        SM5 = RegNoConfirmed.getText();
        SM6 = RegNoNotConfirmed.getText();
        SM7 = AppointmentBooked.getText();
        SM8 = PercentAppointmentBooked.getText();
        SM9 = TotalReported.getText();
        SM10 = PercentReported.getText();
        SM11 =Reported_At_same_Parent_Other_oultet.getText();
        SM12 = ReportedAtOwn.getText();
        SM13 = ReportedAtOther.getText();
        SM14 = NotConnected.getText();
        SM15 = NotAttempted.getText();
        Thread.sleep(1000);
        
        try {

            // Parse the Total Due value to a numeric type
            double totalDueValue = Double.parseDouble(SM1);

            if (totalDueValue <= 0 ||SM1 == null) {
                // Fail the test if Total Due value is 0 or less
                Assert.fail("No Data Found for SMRE_Report In HyperLocal_Status : " + SM1);
            } else {
                // Print the Total Due value
                System.out.println(" LeadGenerated of SMRE_Report In HyperLocal_Status  ::: " + SM1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for SMRE_Report  In SMR due Date wise " + e.getMessage());
        }
    }	
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	   
    
    @Test(priority = 14)
    public void Comparison_0f_all_Data() throws InterruptedException {    	    	    	    	
    	String[] Summary_Report = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, 
    			                     s12, s13, s14,s15};
    	String[] SMRE_Report = {SM1, SM2, SM3, SM4, SM5, SM6, SM7, SM8,
    			              SM9, SM10, SM11, SM12, SM13, SM14,SM15};
    			            

    	String[] comparisonLabels = {
    	    "LeadGenerated", "LeadAttempted", "FollowUp", "TotalConnected", 
    	    "RegNoConfirmed", "RegNoNotConfirmed", "AppointmentBooked", "PercentAppointmentBooked", 
    	    "TotalReported", "PercentReported", "Reported_At_same_Parent_Other_oultet"
    	    , "ReportedAtOwn", "ReportedAtOther", "NotConnected","NotAttempted"	};
    	      	        	     
    	for (int i = 0; i < Summary_Report.length; i++) {
    	   	    Assert.assertEquals(Summary_Report[i], SMRE_Report[i], "Compare " + comparisonLabels[i] + "_of_Summary_Report_With_SMRE_Report");

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

  		Actions actions = new Actions(driver);
  		actions.doubleClick(select).perform();

  		Thread.sleep(1000); // Keep this if you need a wait after the double-click

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





