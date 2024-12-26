package SMR_Call_Dispostion_Data_Check_And_CCM_Reports;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
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

public class All_fillter_check2 extends Login_Page {
	public static WebDriver driver;
    public WebDriverWait wait;

    @SuppressWarnings("static-access")
    @BeforeClass
    public void SMR() throws InterruptedException {
        // Initialize the driver (assuming it's static in the SMR_due_Datewise class)
        this.driver = Login_Page.driver;

     // Initialize WebDriverWait with a timeout of 10 seconds using Duration
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
  //.....................................................................................................

    @Test(priority = 5)
    public void Click_On_MY_Leads() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Leads = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"My Leads \"]")));
        Leads.click();
 		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));	 		

        Speed_Dialer();
//        WebElement Start_Now = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Start Now\"]")));
//        Start_Now.click();
//        Thread.sleep(1000);
//        
//        WebElement Stop_Calling = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Stop Calling\"]")));
//        Stop_Calling.click();
//        Thread.sleep(2000);
//         
    }
    //.....................................................................................................

    @Test(priority = 6)
    public void All_Filters_check() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Select priority
        selectOptionByIdAndText(wait, "mat-select-0", "PMS 20");

        // Select channel
        selectOptionByIdAndText(wait, "mat-select-value-3", "Arena");

        // Select campaign name
        selectOptionByIdAndText(wait, "mat-select-value-7", "Adhoc Bot Campaign");

        // Validate if data is present in the table
        validateReportData("(//*[@summary='table']//tr)", "Priority, Channel, Campaign Name");
    }

   
  

 //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    
  //................Refactored code with improved readability and dynamic waits ............................................

    @Test(priority = 7)
    public void CCP_Filters_check() {
        clickElementWithWait(By.xpath("//*[text()=\"filter_list\"]"));
        clickElementWithWait(By.xpath("(//*[text()=\"CCP\"])[2]"));
        clickElementWithWait(By.id("mat-expansion-panel-header-11"));

        // XPaths for the checkboxes
        String[] xpaths = {
            "//*[text()=\"CCP Gold - Plus \"]",
            "//*[text()=\"CCP Platinum Hydro 2 year \"]",
            "//*[text()=\"CCP Platinum - Fuel \"]",
            "//*[text()=\"CCP Royal Platinum - Plus \"]",
            "//*[text()=\"CCP Platinum - Plus \"]"
        };

        // Click each checkbox dynamically
        clickCheckboxes(xpaths);

        // Validate if data is present in the table
        validateReportData("(//*[@summary='table']//tr)", "CCP Tie filter");
    }
//......................................................................................................
    @Test(priority = 8)
    public void removeFilterCheck() {
        clickElementWithWait(By.xpath("//*[text()=\"close\"]"));
        clickElementWithWait(By.id("mat-expansion-panel-header-11"));
    }
  //......................................................................................................

    @Test(priority = 9)
    public void CCP_New_Sale_Eligible_Filters() {
        clickElementWithWait(By.xpath("//*[text()=\"CCP New Sale Eligible\"]"));

        String[] xpaths = {
            "(//*[text()=\"No \"])[1]",
            //"(//*[text()=\"Yes \"])[1]"
        };

        clickCheckboxes(xpaths);
        validateReportData("(//*[@summary='table']//tr)", "CCP New Sale Eligible filter");
    }
  //......................................................................................................

    @Test(priority = 11)
    public void removeNewSaleEligibleFilter() {
        clickElementWithWait(By.xpath("//*[text()=\"close\"]"));
        clickElementWithWait(By.xpath("//*[text()=\"CCP New Sale Eligible\"]"));
    }
  //......................................................................................................

    @Test(priority = 12)
    public void CCP_Renewal_Filters() {
        clickElementWithWait(By.xpath("//*[text()=\"CCP Renewal Eligible\"]"));

        String[] xpaths = {
            "(//*[text()=\"No \"])[2]"
        };

        clickCheckboxes(xpaths);
        validateReportData("(//*[@summary='table']//tr)", "CCP Renewal Eligible filter");
    }
  //......................................................................................................

    @Test(priority = 13)
    public void removeRenewalFilter() {
        clickElementWithWait(By.xpath("//*[text()=\"close\"]"));
        clickElementWithWait(By.xpath("(//*[text()=\"CCP\"])[2]"));
    }
  //......................................................................................................

    @Test(priority = 14)
    public void EW_Filters() {
        clickElementWithWait(By.xpath("//*[text()=\"EW\"]"));
        clickElementWithWait(By.xpath("//*[text()=\"EW New Sale Eligible\"]"));

        String[] xpaths = {
            "(//*[text()=\"No \"])[3]",
            "(//*[text()=\"Yes \"])[2]"
        };

        clickCheckboxes(xpaths);
        validateReportData("(//*[@summary='table']//tr)", "EW New Sale Eligible filter");
    }
  //......................................................................................................

    @Test(priority = 15)
    public void removeEWFilter() {
        clickElementWithWait(By.xpath("//*[text()=\"close\"]"));
        clickElementWithWait(By.xpath("//*[text()=\"EW New Sale Eligible\"]"));
    }
  //......................................................................................................

    @Test(priority = 16)
    public void Loyality_Filters() {
        clickElementWithWait(By.xpath("(//*[text()=\"Loyalty\"])[2]"));
        clickElementWithWait(By.xpath("//*[text()=\"Loyalty Tier\"]"));

        String[] xpaths = {
        		 "//*[text()=\" Platinum \"]",
                 "//*[text()=\" Silver \"]",
                 "//*[text()=\" Gold \"]",
                 "//*[text()=\" Member \"]"
        };

        clickCheckboxes(xpaths);
        validateReportData("(//*[@summary='table']//tr)", "Loyality filter");
    }
  //......................................................................................................

    @Test(priority = 17)
    public void removeLoyalityFilter() {
        clickElementWithWait(By.xpath("//*[text()=\"close\"]"));
        clickElementWithWait(By.xpath("(//*[text()=\"Loyalty\"])[2]"));
    }
    
    
    //......................................................................................................

    @Test(priority = 18)
    public void Customer_tag_Filters() {
        clickElementWithWait(By.xpath("//*[text()=\"Customer Tag\"]"));
      
        String[] xpaths = {
        		 "//*[text()=\"Warm \"]",
                
        };

        clickCheckboxes(xpaths);
        validateReportData("(//*[@summary='table']//tr)", "Customer Tag");
    }
  //......................................................................................................

    @Test(priority = 19)
    public void removeCustomer_tag() {
        clickElementWithWait(By.xpath("//*[text()=\"close\"]"));
        clickElementWithWait(By.xpath("//*[text()=\"Customer Tag\"]"));
    }
    
    //......................................................................................................

    @Test(priority = 20)
    public void lastService_Workshop_Fillters() {
        clickElementWithWait(By.xpath("//*[text()=\"Last Service Workshop\"]"));
      
        String[] xpaths = {
        		 "//*[text()=\" Not Available \"]",
                 "//*[text()=\" OWN \"]",
                 "//*[text()=\" OTHER \"]"
                
        };

        clickCheckboxes(xpaths);
        validateReportData("(//*[@summary='table']//tr)", "lastService Workshop");
    }

    @Test(priority = 21)
    public void remove_lastService_Workshop_Fillters() {
        clickElementWithWait(By.xpath("//*[text()=\"close\"]"));
        clickElementWithWait(By.xpath("//*[text()=\"Last Service Workshop\"]"));
    }
    
  //......................................................................................................

    @Test(priority = 22)
    public void Service_due_Workshop_Filters() {
        clickElementWithWait(By.xpath("//*[text()='Service Due Workshop']"));
      
        String[] xpaths = {
        		 "(//*[@class=\"mat-checkbox-inner-container\"])[20]",
                
        };

        clickCheckboxes(xpaths);
        validateReportData("(//*[@summary='table']//tr)", "Service due  Workshop Filters");
    }

    @Test(priority = 23)
    public void remove_Service_due_Workshop_Filters() {
        clickElementWithWait(By.xpath("//*[text()=\"close\"]"));
        clickElementWithWait(By.xpath("//*[text()='Service Due Workshop']"));
    }
    
    //......................................................................................................

    @Test(priority = 24)
    public void CRE_Fillters_check() {
        clickElementWithWait(By.xpath("//*[text()=\"CRE Name\"]"));
      
        String[] xpaths = {
        		 "(//*[contains(text(),\" ANAMIKA . \")])[4]",
                
        };

        clickCheckboxes(xpaths);
        validateReportData("(//*[@summary='table']//tr)", "CRE Fillters check");
    }

    @Test(priority = 25)
    public void remove_CRE_Fillters_check() {
        clickElementWithWait(By.xpath("//*[text()=\"close\"]"));
        clickElementWithWait(By.xpath("//*[text()=\"CRE Name\"]"));
    }
    //......................................................................................................

    @Test(priority = 26)
    public void Fuel_Type_Fillters_check() {
        clickElementWithWait(By.xpath("//*[text()=\"Fuel Type\"]"));
      
        String[] xpaths = {
        		 "//*[text()=\" Petrol \"]",
                 "//*[text()=\" Diesel \"]",
                 "//*[text()=\" CNG \"]",
                 "//*[text()=\" LPG \"]",
                
        };

        clickCheckboxes(xpaths);
        validateReportData("(//*[@summary='table']//tr)", "Fuel Type Fillters check");
    }

    @Test(priority = 27)
    public void remove_Fuel_Type_Fillters_check() {
        clickElementWithWait(By.xpath("//*[text()=\"close\"]"));
        clickElementWithWait(By.xpath("//*[text()=\"Fuel Type\"]"));
    }
    //......................................................................................................

    @Test(priority = 29)
    public void Dnc_Applicable_Fillters_check() {
        clickElementWithWait(By.xpath("//*[text()=\"DNC Applicable\"]"));
      
        String[] xpaths = {
        		 "//*[text()=\"Yes\"]",
                
        };

        clickCheckboxes(xpaths);
        validateReportData("(//*[@summary='table']//tr)", "Dnc_Applicable_Fillters_check");
    }

    @Test(priority = 30)
    public void remove_Dnc_Applicable_Fillters_check() {
        clickElementWithWait(By.xpath("//*[text()=\"close\"]"));
        clickElementWithWait(By.xpath("//*[text()=\"DNC Applicable\"]"));
    }
    //......................................................................................................

    @Test(priority = 31)
    public void Model_name_Fillters_check() {
        clickElementWithWait(By.xpath("//*[text()=\"Model Name\"]"));
      
        String[] xpaths = {
        		  "//*[text()=\"NEW SWIFT \"]",
                  "//*[text()=\"CIAZ \"]",
                  "//*[text()=\"VITARA BREZZA  \"]",
                  "//*[text()=\"NEW SWIFT DZIRE \"]",
                  "//*[text()=\"NEW WAGON-R \"]",
                  "//*[text()=\"BALENO \"]",
                  "//*[text()=\"Ignis \"]",
                  "//*[text()=\"SWIFT DZIRE \"]",
                  "//*[text()=\"CELERIO \"]",
                  "//*[text()=\"ALTO K10 \"]",
                  
                  "//*[text()=\"ALTO 800 \"]",
                  "//*[text()=\"DZIRE \"]",
                  "//*[text()=\"NEW ERTIGA \"]",
                  "//*[text()=\"NEW ALTO K10 \"]",
                  "//*[text()=\"SWIFT \"]",
                  "//*[text()=\"FRONX \"]",
                  "//*[text()=\"ERTIGA \"]",
                  "//*[text()=\"RITZ \"]",
                  "//*[text()=\"EECO \"]",
                  "//*[text()=\"NEW BREZZA \"]",
                  
                  "//*[text()=\"NEW BALENO \"]",
                  "//*[text()=\"WagonR \"]",
                  "//*[text()=\"NEW CELERIO \"]",
                  "//*[text()=\"ALTO \"]",
                  "//*[text()=\"S-CROSS \"]",
                  "//*[text()=\"SUPER CARRY \"]",
                  "//*[text()=\"M 800 \"]",
                  "//*[text()=\"XL6 \"]",
                  "//*[text()=\"JIMNY \"]",
                  "//*[text()=\"GRAND VITARA \"]",
                  "//*[text()=\"SMG DZIRE \"]",
                
        };

        clickCheckboxes(xpaths);
        validateReportData("(//*[@summary='table']//tr)", "Model_name_Fillters_check");
    }

    @Test(priority = 32)
    public void remove_Model_name_Fillters_check() {
        clickElementWithWait(By.xpath("//*[text()=\"close\"]"));
        clickElementWithWait(By.xpath("//*[text()=\"Model Name\"]"));
    }
  //......................................................................................................

    @Test(priority = 34)
    public void Vehicle_Type_Fillters_check() {
        clickElementWithWait(By.xpath("//*[text()=\"Vehicle Type\"]"));
      
        String[] xpaths = {
        		  "//*[text()=\" Private \"]",
                  "//*[text()=\" Commercial \"]",
                  "//*[text()=\" Corporate \"]",
                
        };

        clickCheckboxes(xpaths);
        validateReportData("(//*[@summary='table']//tr)", "Vehicle_Type_Fillters_check");
    }

    @Test(priority = 35)
    public void remove_Vehicle_Type_Fillters_check() {
        clickElementWithWait(By.xpath("//*[text()=\"close\"]"));
        clickElementWithWait(By.xpath("//*[text()=\"Vehicle Type\"]"));
    }
  //......................................................................................................

    @Test(priority = 36)
    public void Location_Fillters_check() {
        clickElementWithWait(By.xpath("//*[text()=\"Location\"]"));
      
        String[] xpaths = {
        		"(//*[text()=\" NARAINA INDUSTRIAL AREA-SRV \"])[2]",
                
        };

        clickCheckboxes(xpaths);
        validateReportData("(//*[@summary='table']//tr)", "Location_Fillters_check");
    }

    @Test(priority = 37)
    public void remove_Location_Fillters_check() {
        clickElementWithWait(By.xpath("//*[text()=\"close\"]"));
        clickElementWithWait(By.xpath("//*[text()=\"Location\"]"));
    }
    //......................................................................................................

    @Test(priority = 38)
    public void Sold_By_Fillters_check() {
        clickElementWithWait(By.xpath("//*[text()=\"Sold By\"]"));
      
        String[] xpaths = {
        		 "//*[text()=\" Own \"]",
                
        };

        clickCheckboxes(xpaths);
        validateReportData("(//*[@summary='table']//tr)", "Sold_By_Fillters_check");
    }

    @Test(priority = 39)
    public void remove_Sold_By_Fillters_check() {
        clickElementWithWait(By.xpath("//*[text()=\"close\"]"));
        clickElementWithWait(By.xpath("//*[text()=\"Sold By\"]"));
    }
    
    //......................................................................................................

    @Test(priority = 40)
    public void MI_Active_Fillters_check() {
        clickElementWithWait(By.xpath("//*[text()=\"MI Active\"]"));
      
        String[] xpaths = {
        		 "(//*[text()=\"Yes \"])[5]",
                
        };

        clickCheckboxes(xpaths);
        validateReportData("(//*[@summary='table']//tr)", "MI_Active_Fillters_check");
    }

    @Test(priority = 41)
    public void remove_MI_Active_Fillters_check() {
        clickElementWithWait(By.xpath("//*[text()=\"close\"]"));
        clickElementWithWait(By.xpath("//*[text()=\"MI Active\"]"));
    }
  //......................................................................................................

    @Test(priority = 43)
    public void Model_Varient_Fillters_check() {
        clickElementWithWait(By.xpath("//*[text()=\"Model Variant\"]"));
      
        String[] xpaths = {
        		  "(//*[@class=\"mat-checkbox-inner-container\"])[137]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[138]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[139]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[140]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[141]",
                  
                  "(//*[@class=\"mat-checkbox-inner-container\"])[142]",
                  "(//*[@class=\"mat-checkbox-inner-container\"])[143]",
                 
                  "(//*[@class=\"mat-checkbox-inner-container\"])[144]",
                 
                
        };

        clickCheckboxes(xpaths);
        validateReportData("(//*[@summary='table']//tr)", "Model_Varient_Fillters_check");
    }

    @Test(priority = 44)
    public void remove_Model_Varient_Fillters_check() {
        clickElementWithWait(By.xpath("//*[text()=\"close\"]"));
        clickElementWithWait(By.xpath("//*[text()=\"Model Variant\"]"));
    }
  //......................................................................................................

    @Test(priority = 45)
    public void Corporate_Name_Fillters_check() {
        clickElementWithWait(By.xpath("//*[text()=\"Corporate Name\"]"));
      
        String[] xpaths = {
        		"//*[text()=\"IT / ITES \"]",
                "//*[text()=\"Airlines \"]",
                
        };

        clickCheckboxes(xpaths);
        validateReportData("(//*[@summary='table']//tr)", "Corporate_Name_Fillters_check");
    }

    @Test(priority = 46)
    public void remove_Corporate_Name_Fillters_check() {
        clickElementWithWait(By.xpath("//*[text()=\"close\"]"));
        clickElementWithWait(By.xpath("//*[text()=\"Corporate Name\"]"));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Closes the browser and ends the WebDriver session
        }
    }
    
    //.................................................................................................
    //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Helper Methods<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    // Method to click an element with dynamic wait
    private void clickElementWithWait(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
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
    private void selectOptionByIdAndText(WebDriverWait wait, String selectId, String optionText) {
        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id(selectId)));
        dropdown.click();
        
        WebElement option = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"" + optionText + "\"]")));
        option.click();
    }
    
    
  //.......................................................................................................
	private void Speed_Dialer() throws InterruptedException {
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    // Check if the Dialer element is visible and clickable
	    try {
	    	 WebElement Dialer = wait
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
	        WebElement Stop_Calling = wait
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
//.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        
}
