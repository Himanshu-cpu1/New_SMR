package SMR_Call_Dispostion_Data_Check_And_CCM_Reports;

import java.time.Duration;
import java.util.List;
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

public class REFUSE_FOR_SERVICE_Dissatisfied_with_Service  extends Login_Page {
	
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
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement Leads = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"My Leads \"]")));
        Leads.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));	 		
        Speed_Dialer();
    }
  //.....................................................................................................
    @Test(priority = 7)
    public void click_On_first_Customer() throws InterruptedException {
        // Find and get the first customer name
        WebElement firstCustomer = driver.findElement(By.xpath("(//*[@class=\"mat-tooltip-trigger text-truncate\"])[1]"));
        String firstCustomerText = firstCustomer.getText();
        String firstCustomerName = firstCustomerText.split(" - ")[0];
        System.out.println("First customer name  :: " + firstCustomerName);

        // Click on the first customer
        if (firstCustomer.isDisplayed()) {
            firstCustomer.click();
        } else {
            System.out.println("First customer element is not visible.");
            Assert.fail("First customer element not found or not clickable.");
        }

        // Sleep to simulate a wait, replace with explicit waits if possible
        Thread.sleep(5000);

        // Scroll down to the Vehicle Information section
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        Thread.sleep(3000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Call_Dispostion = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Call Disposition\"]")));
        Call_Dispostion.click();

        Thread.sleep(3000);

        // Scroll down to the Vehicle Information section
        Actions actions2 = new Actions(driver);
        actions2.sendKeys(Keys.PAGE_DOWN).perform();

        // Click on the 'Did you talk to the customer' - YES
        Thread.sleep(3000);

        WebElement YES = driver.findElement(By.cssSelector("[value=\"yes\"]"));
        YES.click();

        // Click on 'Refuse_For_Service'
        WebElement Refuse_For_Service = driver.findElement(By.xpath("//*[text()=\"Refuse for service\"]"));
        Refuse_For_Service.click();
        
        Thread.sleep(2000);
        // Click on 'DisSatisfied service'
        WebElement DisSatisfied = driver.findElement(By.xpath("//*[text()=\"Dissatisfied with service\"]"));
        DisSatisfied.click();
        
        Thread.sleep(2000);
        actions2.sendKeys(Keys.PAGE_UP).perform();
        
        Thread.sleep(3000);
        WebElement Reason_For_DisSatisfaction = driver.findElement(By.id("mat-select-value-77"));
        Reason_For_DisSatisfaction.click();
        
        Thread.sleep(3000);
        WebElement select_High_Charges = driver.findElement(By.xpath("//*[text()=\"HIgh Charges \"]"));
        select_High_Charges.click();
        
        Thread.sleep(3000);
        WebElement Service_wORKSHOP = driver.findElement(By.id("mat-select-value-79"));
        Service_wORKSHOP.click();
        
        Thread.sleep(3000);
        WebElement select_NARIANA_INDUSTRIES = driver.findElement(By.xpath("//*[text()=\"NARAINA INDUSTRIAL AREA-SRV \"]"));
        select_NARIANA_INDUSTRIES.click();
        Thread.sleep(3000);
        
        WebElement Service_Advisor_Name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname=\"serviceAdvisorName\"]")));
        Service_Advisor_Name.sendKeys("Mohan singh");
        Thread.sleep(3000);

        WebElement CustomerVOC = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname=\"customerVOC\"]")));
        CustomerVOC.sendKeys("Dissatisfied with service");
        Thread.sleep(3000);

        WebElement CRE_Remark = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[formcontrolname=\"creRemark\"]")));
        CRE_Remark.sendKeys("Dissatisfied with service");
        Thread.sleep(3000);

        WebElement Submit = driver.findElement(By.xpath("//*[text()=\"Submit\"]"));
        Submit.click();
        Thread.sleep(5000);

        // Refresh the page
        driver.navigate().refresh();
     
        Thread.sleep(17000);    
        WebElement Forward_Button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@class=\"mat-tab-header-pagination-chevron\"])[2]")));
        Forward_Button.click();
        Thread.sleep(4000);
        
        WebElement Lost_calls = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),\"Lost Calls\")]")));
        Lost_calls.click();
        Thread.sleep(15000);
        
        WebElement Search_Button = driver.findElement(By.id("mat-input-0"));
        Search_Button.sendKeys(firstCustomerName);           
        Thread.sleep(3000);

        
        List<WebElement> customers = driver.findElements(By.xpath("//*[@class=\"mat-tooltip-trigger text-truncate\"]"));

        // Search for the customer that matches firstCustomerName
        boolean customerFound = false;
        for (WebElement customer : customers) {
            String customerText = customer.getText();
            String customerName = customerText.split(" - ")[0];
            System.out.println("customerName "+customerName);
            
            if (customerName.equals(firstCustomerName)) {
                // If a match is found, click the customer
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", customer);
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", customer);
               
                System.out.println("Dissatisfied with service is completed");
                Thread.sleep(3000);
                WebElement close = driver.findElement(By.xpath("//*[text()=\"close\"]"));
                close.click();           
                Thread.sleep(3000);
                customerFound = true;
                break;
            }
        }

        if (!customerFound) {
            Assert.fail("Customer with name " + firstCustomerName + " not found after clicking 'Lost calls'.");
        }
    }
    //.....................................................................................................

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser and end the WebDriver session
        }
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
    }


