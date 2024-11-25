package PSf_Static_Report_and_Call_Dispostion;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Psf_All_Fillter_Check extends LOGINs{

	String customerFullName;

	public static WebDriver driver;
	public WebDriverWait wait;

	@SuppressWarnings("static-access")
    @BeforeClass
    public void SMR() throws InterruptedException {
        // Initialize the driver (assuming it's static in the SMR_due_Datewise class)
        this.driver = LOGINs.driver;

     // Initialize WebDriverWait with a timeout of 10 seconds using Duration
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
	//.....................................................................................................

    @Test(priority =8)
    public void Fillters_check() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        WebElement Service_Type = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@role=\"combobox\"])[1]")));
        Service_Type.click();
        Thread.sleep(500);
        
        WebElement Select_All = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class=\"mat-option-text\"])[1]")));
        Select_All.click();
        Thread.sleep(500);
        
        WebElement Workshop = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@role=\"combobox\"])[2]"))); 
        Actions actions = new Actions(driver);      
        actions.doubleClick(Workshop).perform();
        Thread.sleep(500);
        
        WebElement Select_ALL2 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class=\"mat-option-text\"])[1]")));
        Select_ALL2.click();
        Thread.sleep(500);
        
        WebElement CCE_NAme = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@role=\"combobox\"])[3]")));
        actions.doubleClick(CCE_NAme).perform();
        Thread.sleep(500);
        
        WebElement Select_ALL3 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class=\"mat-option-text\"])[1]")));
        Select_ALL3.click();
        Thread.sleep(500);
        
        WebElement Channel = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@role=\"combobox\"])[4]")));
        actions.doubleClick(Channel).perform();
        Thread.sleep(500);
        
        WebElement Select_ALL4 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class=\"mat-option-text\"])[1]")));
        Select_ALL4.click();
        Thread.sleep(500);
        
        // Find rows in the report table
        List<WebElement> reportRows = driver.findElements(By.xpath("//*[@class=\"mat-row cdk-row ng-star-inserted\"]"));

        // Check if data is available
        if (reportRows.size() > 1) {
            System.out.println(" Selecting ( Service type ,workshop, CCE Name,Channel ) contains data."); // Data is available
        } else {
          
            Assert.fail( "Selecting  (Service type ,workshop, CCE Name,Channel  ) does not contain any data.");
           
        }}
  //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    
      @Test(priority = 9)
      public void Service_Advisor_Name_Fillter() {
    	  WebElement Additional = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"filter_list\"]")));
          Actions actions = new Actions(driver);      
          actions.doubleClick(Additional).perform();
         
          clickElementWithWait(By.xpath("//*[text()=\" Service Advisor Name\"]"));
         
          // XPaths for the checkboxes
          String[] xpaths = {
                  "(//*[@class=\"mat-checkbox-inner-container\"])[1]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[2]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[3]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[4]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[5]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[6]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[7]",
              };


          // Click each checkbox dynamically
          clickCheckboxes(xpaths);

          // Validate if data is present in the table
          validateReportData("//*[@class=\"mat-row cdk-row ng-star-inserted\"]", "Service_Advisor_Name_");
      }
    //......................................................................................................
      @Test(priority = 10)
      public void removeFilterCheck() {
          clickElementWithWait(By.xpath("//*[text()=\"close\"]"));
          clickElementWithWait(By.xpath("//*[text()=\" Service Advisor Name\"]"));
      }
    //......................................................................................................
      @Test(priority = 11)
      public void  Technician_Name_Name_Fillter() {
    	     
          clickElementWithWait(By.xpath("//*[text()=\" Technician Name\"]"));
         
          // XPaths for the checkboxes
          String[] xpaths = {
                  "(//*[@class=\"mat-checkbox-inner-container\"])[8]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[9]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[10]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[11]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[12]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[13]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[14]",
                  
                  "(//*[@class=\"mat-checkbox-inner-container\"])[15]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[16]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[17]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[18]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[19]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[20]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[21]",
                  
                  "(//*[@class=\"mat-checkbox-inner-container\"])[22]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[23]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[24]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[25]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[26]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[27]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[28]",
                  
                  "(//*[@class=\"mat-checkbox-inner-container\"])[29]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[30]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[31]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[32]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[33]",
                 
              };

          // Click each checkbox dynamically
          clickCheckboxes(xpaths);

          // Validate if data is present in the table
          validateReportData("//*[@class=\"mat-row cdk-row ng-star-inserted\"]", "Technician_Name_Name_");
      }
    //......................................................................................................
      @Test(priority = 12)
      public void removeFilterCheck2() {
          clickElementWithWait(By.xpath("//*[text()=\"close\"]"));
          clickElementWithWait(By.xpath("//*[text()=\" Technician Name\"]"));
      }
    //......................................................................................................
      @Test(priority = 13)
      public void  FuelType_Fillter() {
    	     
          clickElementWithWait(By.xpath("//*[text()=\" Fuel Type \"]"));
         
          // XPaths for the checkboxes
          String[] xpaths = {
                  "(//*[@class=\"mat-checkbox-inner-container\"])[34]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[35]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[36]",
                                             
              };

          // Click each checkbox dynamically
          clickCheckboxes(xpaths);

          // Validate if data is present in the table
          validateReportData("//*[@class=\"mat-row cdk-row ng-star-inserted\"]", "FuelType");
      }
    //......................................................................................................
      @Test(priority = 14)
      public void removeFilterCheck3() {
          clickElementWithWait(By.xpath("//*[text()=\"close\"]"));
          clickElementWithWait(By.xpath("//*[text()=\" Fuel Type \"]"));
      }
      //......................................................................................................
      @Test(priority = 15)
      public void  Model_name_Fillter() {
    	     
          clickElementWithWait(By.xpath("//*[text()=\" Model Name\"]"));
         
          // XPaths for the checkboxes
          String[] xpaths = {
                  "(//*[@class=\"mat-checkbox-inner-container\"])[37]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[38]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[39]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[40]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[41]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[42]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[43]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[44]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[45]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[46]",
                  
                  "(//*[@class=\"mat-checkbox-inner-container\"])[47]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[48]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[49]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[50]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[51]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[52]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[53]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[54]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[55]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[56]",
                  
                  "(//*[@class=\"mat-checkbox-inner-container\"])[57]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[58]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[59]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[60]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[61]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[62]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[63]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[64]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[65]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[66]",
                  
                  "(//*[@class=\"mat-checkbox-inner-container\"])[67]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[68]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[69]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[70]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[71]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[72]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[73]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[74]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[75]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[76]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[77]",
                                             
              };

          // Click each checkbox dynamically
          clickCheckboxes(xpaths);

          // Validate if data is present in the table
          validateReportData("//*[@class=\"mat-row cdk-row ng-star-inserted\"]", "Model_name");
      }
    //......................................................................................................
      @Test(priority = 16)
      public void removeFilterCheck4() {
          clickElementWithWait(By.xpath("//*[text()=\"close\"]"));
          clickElementWithWait(By.xpath("//*[text()=\" Model Name\"]"));
      }
      //......................................................................................................
      @Test(priority = 17)
      public void  Model_Variant_Fillter() {
    	     
          clickElementWithWait(By.xpath("//*[text()=\" Model Variant \"]"));
         
          // XPaths for the checkboxes
          String[] xpaths = {
                  "(//*[@class=\"mat-checkbox-inner-container\"])[78]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[79]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[80]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[81]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[82]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[83]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[84]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[85]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[86]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[87]",
                  
                  "(//*[@class=\"mat-checkbox-inner-container\"])[88]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[89]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[90]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[91]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[92]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[93]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[94]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[95]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[96]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[97]",
                  
                  "(//*[@class=\"mat-checkbox-inner-container\"])[98]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[99]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[100]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[101]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[102]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[103]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[104]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[105]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[106]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[107]",
                  
                  "(//*[@class=\"mat-checkbox-inner-container\"])[108]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[109]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[110]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[111]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[112]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[113]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[114]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[115]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[116]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[117]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[118]",
                  
                  
                  "(//*[@class=\"mat-checkbox-inner-container\"])[119]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[120]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[121]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[122]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[123]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[124]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[125]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[126]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[127]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[128]",
                  
                  "(//*[@class=\"mat-checkbox-inner-container\"])[129]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[130]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[131]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[132]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[133]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[134]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[135]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[136]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[137]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[138]",
                  
                  "(//*[@class=\"mat-checkbox-inner-container\"])[139]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[140]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[141]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[142]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[143]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[144]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[145]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[146]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[147]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[148]",
                  
                  "(//*[@class=\"mat-checkbox-inner-container\"])[149]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[150]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[151]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[152]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[153]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[154]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[155]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[156]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[157]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[158]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[159]",
                                             
              };

          // Click each checkbox dynamically
          clickCheckboxes(xpaths);

          // Validate if data is present in the table
          validateReportData("//*[@class=\"mat-row cdk-row ng-star-inserted\"]", "Model Variant");
      }
    //......................................................................................................
      @Test(priority = 18)
      public void removeFilterCheck5() {
          clickElementWithWait(By.xpath("//*[text()=\"close\"]"));
          clickElementWithWait(By.xpath("//*[text()=\" Model Variant \"]"));
      }
      @Test(priority = 19)
      public void Click_On_Refresh() {
    	  driver.navigate().refresh();
  		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

      }
      
      //.....................................................................................................

	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();  // Close the browser and end the WebDriver session
	        }
	    }
    //.................................................................................................
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Helper Methods<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    // Method to click an element with dynamic wait
    private void clickElementWithWait(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    // Method to click checkboxes dynamically
    private void clickCheckboxes(String[] xpaths) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for (String xpath : xpaths) {
            WebElement checkbox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            checkbox.click();
        }
    }

    // Method to validate if report data is available
    private void validateReportData(String rowLocator, String filterType) {
        List<WebElement> reportRows = driver.findElements(By.xpath(rowLocator));

        if (reportRows.size() > 1) {
            System.out.println("Selecting (" + filterType + ") contains data.");
        } else {
            Assert.fail("Selecting (" + filterType + ") does not contain any data.");
        }
    }
    // Helper method to select an option from a dropdown using the element's ID and the text to select
    private void selectOptionByxpathAndText(WebDriverWait wait, String selectxpath, String optionText) throws InterruptedException {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(selectxpath)));
     // Initialize Actions for double-click
        Actions actions = new Actions(driver);

        // Perform double-click
        actions.doubleClick(dropdown).perform();
        
        WebElement option = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"" + optionText + "\"]")));
        option.click();
    }
//.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        
}
