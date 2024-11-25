package cCM_Reports;

import java.time.Duration;
import java.util.List;
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

public class DueVsDone {

	public static WebDriver driver;
    public WebDriverWait wait;
    
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
  			
  			 WebElement PopUp= driver.findElement(By.xpath("(//*[@title=\"Close message\"])"));
  			 PopUp.click();
  		    Thread.sleep(1000);
  			
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
 	public void Click_On_DUE_VS_DONE_REPORT() throws InterruptedException {
 		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
 		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement DueVsDone = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Due Vs Done \"]")));
      
        clickElementUsingJS(driver, DueVsDone);
 		Thread.sleep(3000);
 		
 	}
 	 //.........................................................................................................................
    @Test(priority = 10)
    public void Select_All_Fillter() throws InterruptedException {
    	  //click on Region dropdown
    	Actions actions = new Actions(driver);
    	
    	 WebElement Select_Vehicle_Channel = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[3]"));
         Select_Vehicle_Channel.click();
        
         WebElement Select_all3 = driver.findElement(By.xpath("(//*[@role=\"option\"])[1]"));
         Select_all3.click();
         Thread.sleep(3000);
                 
        WebElement Select_Service_Type = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[2]"));
        actions.doubleClick(Select_Service_Type).perform();
       
        WebElement Select_all2 = driver.findElement(By.xpath("(//*[@role=\"option\"])[1]"));
        Select_all2.click();
        Thread.sleep(3000);
        WebElement Selecet_Workshop = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[1]"));
        Selecet_Workshop.click();
       
        WebElement Select_all = driver.findElement(By.xpath("(//*[@role=\"option\"])[1]"));
        Select_all.click();
        Thread.sleep(3000);
               
    	
    }
    //.........................................................................................................................
    @Test(priority = 11)
    public void Click_On_Generate_Button() throws InterruptedException {

        //click on Generate Button
        WebElement Generate = driver.findElement(By.xpath("(//*[text()=\"Generate\"])"));
        Actions actions1 = new Actions(driver);
        actions1.doubleClick(Generate).perform();
  		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

    }
  //.............................................................................................................   

    @Test(priority = 12)
    public void Data_Verification_DueVsDone() throws InterruptedException {
        // Verify if the report contains data
        List<WebElement> reportRows = driver.findElements(By.xpath("(//*[@role=\"rowgroup\"][2]//tr)"));
        Assert.assertTrue(reportRows.size() > 1, "The report does not contain any data In Due-Vs-Done Report.");
      
        Thread.sleep(2000);

    }
 //.....................Helper Method...........................................................................
	
  	private void clickElementUsingJS(WebDriver driver, WebElement element) {
  	    JavascriptExecutor js = (JavascriptExecutor) driver;
  	    js.executeScript("arguments[0].click();", element);
  	}
}
