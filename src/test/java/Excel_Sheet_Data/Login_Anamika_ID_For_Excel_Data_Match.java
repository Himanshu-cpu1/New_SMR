package Excel_Sheet_Data;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login_Anamika_ID_For_Excel_Data_Match extends Cce_Login {

	public static WebDriver driver;
    public WebDriverWait wait;
    
    
    //..........................................................   
    private static Login_Anamika_ID_For_Excel_Data_Match instance = null;
 
    public static Login_Anamika_ID_For_Excel_Data_Match getInstance() {
        if (instance == null) {
            instance = new Login_Anamika_ID_For_Excel_Data_Match();
        }
        return instance;
    }
 
    String extractedValue;
    String displayedText;
    WebElement displayedElement;
    
    @SuppressWarnings("static-access")
    @BeforeClass
    public void Admin_Reports() throws InterruptedException {
        // Initialize the driver (assuming it's static in the SMR_due_Datewise class)
        this.driver = Cce_Login.driver;

     // Initialize WebDriverWait with a timeout of 10 seconds using Duration
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    
    

    @Test(priority = 6)
    public void Click_On_My_Leads() throws InterruptedException, IOException {
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
    	
    	
    	WebElement My_Leads = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"My Leads \"]")));
        clickElementUsingJS(driver, My_Leads);
     
        Speed_Dialer();
        
        WebElement Clcik_Fresh_Call = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),\"Fresh calls\")]")));
        clickElementUsingJS(driver, Clcik_Fresh_Call);
        
        WebElement Clcik_On_Excel_Data = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(text(),\"Excel Data \")]")));
        clickElementUsingJS(driver, Clcik_On_Excel_Data);
                                              
    }
    
    //.....................................................................................................

    @SuppressWarnings("static-access")
	@Test(priority = 7)
    public void Click_On_Search() throws InterruptedException, IOException, java.util.concurrent.TimeoutException {
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
    	
    	  excel_Data_Match ExE =new excel_Data_Match();	
    	  ExE.excelData();
    	  
          WebElement Clcik_On_Search = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder=\"Search..\"]")));
          clickElementUsingJS(driver, Clcik_On_Search);
    	
          System.out.println("Value of MU1: " + ExE.MU1);
          Clcik_On_Search.sendKeys(ExE.MU1);
    }
       
        //.....................................................................................................

          @SuppressWarnings("static-access")
		@Test(priority = 8)
          public void Match_Campaign_Name1() throws InterruptedException, IOException, TimeoutException, java.util.concurrent.TimeoutException {
          	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
          	Import_Data_In_CCM ccm = new Import_Data_In_CCM();          	
            Thread.sleep(500);
          	// 1. campign name ..................................................   
          	SplitText();         				
			String enteredValueFromCCM = ccm.Campign_Name;         	
          	System.out.println("enteredValueFromCCM  :: "+enteredValueFromCCM);          	         	
          	Assert.assertEquals(extractedValue, enteredValueFromCCM,"Campaign name are not availabe of Respected Registration number");
                                     	             
    }
        //.....................................................................................................

          @SuppressWarnings("static-access")
		@Test(priority = 9)
          public void Match_Campaign_Name2() throws InterruptedException, IOException, TimeoutException, java.util.concurrent.TimeoutException {
          	 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
          	  Import_Data_In_CCM ccm = new Import_Data_In_CCM();          	
          	 excel_Data_Match ExE =new excel_Data_Match();	
       	  
          	  WebElement Clcik_On_Search = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder=\"Search..\"]")));
          	  Clcik_On_Search.clear();
             System.out.println("Value of MU1: " + ExE.MU2);
             Clcik_On_Search.sendKeys(ExE.MU2);
          	
          	// 2. campign name ..................................................   
          	SplitText();         				
			String enteredValueFromCCM = ccm.Campign_Name;         	
          	System.out.println("enteredValueFromCCM  :: "+enteredValueFromCCM);          	         	
          	Assert.assertEquals(extractedValue, enteredValueFromCCM,"Campaign name2 are not availabe of Respected Registration number");
                                     	             
    }
          
          //.....................................................................................................

          @SuppressWarnings("static-access")
		@Test(priority = 10)
          public void Match_Campaign_Name3() throws InterruptedException, IOException, TimeoutException, java.util.concurrent.TimeoutException {
          	 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
          	  Import_Data_In_CCM ccm = new Import_Data_In_CCM();          	
          	 excel_Data_Match ExE =new excel_Data_Match();	
       	  
          	  WebElement Clcik_On_Search = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder=\"Search..\"]")));
          	  Clcik_On_Search.clear();
             System.out.println("Value of MU1: " + ExE.MU3);
             Clcik_On_Search.sendKeys(ExE.MU3);
          	
          	// 2. campign name ..................................................   
          	SplitText();         				
			String enteredValueFromCCM = ccm.Campign_Name;         	
          	System.out.println("enteredValueFromCCM  :: "+enteredValueFromCCM);          	         	
          	Assert.assertEquals(extractedValue, enteredValueFromCCM,"Campaign name3 are not availabe of Respected Registration number");
                                     	             
    }
          //.....................................................................................................

          @SuppressWarnings("static-access")
		@Test(priority = 11)
          public void Match_Campaign_Name4() throws InterruptedException, IOException, TimeoutException, java.util.concurrent.TimeoutException {
          	 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
          	  Import_Data_In_CCM ccm = new Import_Data_In_CCM();          	
          	 excel_Data_Match ExE =new excel_Data_Match();	
       	  
          	  WebElement Clcik_On_Search = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder=\"Search..\"]")));
          	  Clcik_On_Search.clear();
             System.out.println("Value of MU4: " + ExE.MU4);
             Clcik_On_Search.sendKeys(ExE.MU4);
          	
          	// 2. campign name ..................................................   
          	SplitText();         				
			String enteredValueFromCCM = ccm.Campign_Name;         	
          	System.out.println("enteredValueFromCCM  :: "+enteredValueFromCCM);          	         	
          	Assert.assertEquals(extractedValue, enteredValueFromCCM,"Campaign name4 are not availabe of Respected Registration number");
                                     	             
    }
          //.....................................................................................................

          @SuppressWarnings("static-access")
		@Test(priority = 12)
          public void Match_Campaign_Name5() throws InterruptedException, IOException, TimeoutException, java.util.concurrent.TimeoutException {
          	 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
          	  Import_Data_In_CCM ccm = new Import_Data_In_CCM();          	
          	 excel_Data_Match ExE =new excel_Data_Match();	
       	  
          	  WebElement Clcik_On_Search = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@placeholder=\"Search..\"]")));
          	  Clcik_On_Search.clear();
             System.out.println("Value of MU5: " + ExE.MU5);
             Clcik_On_Search.sendKeys(ExE.MU5);
          	
          	// 2. campign name ..................................................   
          	SplitText();         				
			String enteredValueFromCCM = ccm.Campign_Name;         	
          	System.out.println("enteredValueFromCCM  :: "+enteredValueFromCCM);          	         	
          	Assert.assertEquals(extractedValue, enteredValueFromCCM,"Campaign name5 are not availabe of Respected Registration number");
                                     	             
    }
          //..................................................................................
          @AfterClass
          public void TearsDown() {
        	  
        	  driver.quit();
          }
          
       
 //.....................................................................................         
          private void SplitText() throws InterruptedException {
            	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));  
           	 //.........Campaign Name Pull Factor................................................................................
            	 displayedElement = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@id, 'mat-tab-content-')]//table/tbody/tr[1]/td[2]")));
            	 displayedText = displayedElement.getText();  
            	// System.out.println("displayedText222222 ::" + displayedText);
            	 
            	 Thread.sleep(500);
            	String[] parts = displayedText.split("Data Uploaded By Dealer-");
            	 extractedValue = parts.length > 1 ? parts[1].split("\\s+")[0] : "";
            	System.out.println("Extracted Value ::" + extractedValue);
            	Thread.sleep(400);
          }
  //.....................................................................
  		private void clickElementUsingJS(WebDriver driver, WebElement element) {
  			JavascriptExecutor js = (JavascriptExecutor) driver;
  			js.executeScript("arguments[0].click();", element);
  		}
  		 //.......................................................................................................
  		private void Speed_Dialer() throws InterruptedException {
  			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
  		    
  		    // Check if the Dialer element is visible and clickable
  		    try {
  		    	 WebElement Dialer = wait1
  		    	            .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Start Now']")));
  		    	        
  		    	        // Use Actions class to perform a double-click
  		    	        Actions actions = new Actions(driver);
  		    	        actions.doubleClick(Dialer).perform(); // Double-click on the Dialer element
  		    	        Thread.sleep(1000);
  		    	        System.out.println("Dialer double-clicked successfully.");
  		        
  		    } catch (TimeoutException e) {
  		        System.out.println("Dialer not found or not clickable, performing other actions.");
  		        // Perform other actions if Dialer is not found or not clickable
  		        return; // Exit method or handle alternative actions here
  		    }

  		    // Check if the Stop Calling element is visible and clickable
  		    try {
  		        WebElement Stop_Calling = wait1
  		            .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=' Stop Calling ']")));
  		        
  		        // Use JavaScript Executor to click
  		        JavascriptExecutor js = (JavascriptExecutor) driver;
  		        js.executeScript("arguments[0].click();", Stop_Calling);
  		        Thread.sleep(1000);
  		        System.out.println("Stop Calling clicked successfully.");
  		        
  		    } catch (TimeoutException e) {
  		        System.out.println("Stop Calling not found or not clickable, skipping to next step.");
  		        // Perform other actions if Stop Calling is not found or not clickable
  		    }
  		}
  	    }


