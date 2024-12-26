package USER_Admin_Reports;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Marketing_campign extends Login_Admin {
	
	private  List<String> Dealer_parentTexts;
	private  List<String> Zone_RegionTexts;
	private  List<String> Workshop_WiseTexts ;
	private  List<String> Day_WiseTexts;
		 
	public static WebDriver driver;
    public WebDriverWait wait;

    @SuppressWarnings("static-access")
    @BeforeClass
    public void Admin_Reports() throws InterruptedException {
        // Initialize the driver (assuming it's static in the SMR_due_Datewise class)
        this.driver = Login_Admin.driver;

     // Initialize WebDriverWait with a timeout of 10 seconds using Duration
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    //.....................................................................................................

    @Test(priority = 6)
    public void Click_On_Reports() throws InterruptedException {
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Reports = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Reports \"]")));
        clickElementUsingJS(driver, Reports);
       // wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));	 		
      
    }
    //.....................................................................................................

    @Test(priority = 7)
    public void Click_On_Marketing_Campign() throws InterruptedException {
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Marketing_Campign = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Marketing Campaign \"]")));
        clickElementUsingJS(driver, Marketing_Campign);	
        
    }
    
  //.....................................................................................................

    @Test(priority = 8)
    public void Check_Data__Of_Dealer_parent_Group_Wise() throws InterruptedException {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement Dealer_Parent_Group_Wise1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Dealer Parent Group Wise \"]")));
        Dealer_Parent_Group_Wise1.click();
        
        WebElement clickOn_Marketing_Campign = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@class, 'mat-select-arrow')])[2]")));
        clickOn_Marketing_Campign.click();
	    
	    WebElement Select_All = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@role=\"option\"])[1]")));
	    Select_All.click();
	    
        select_date();
        
//	    WebElement reportContainer = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//tr[td[contains(., 'CENTRAL')]])[1]/td"))); // Replace with the actual locator for the report
//	    reportContainer.click();
      
        String Xpath="//*[@class=\"mat-row cdk-row ng-tns-c314-7 ng-star-inserted\"]";
        String Name="Dealer parent Group Wise";    
        checkDataPresence(Xpath,Name);
        
              
     // Fetch required table data
        String[] Dealer_parent_Group_Wise = {
            "(//tr[td[contains(., 'Total')]])[1]/td[2]",
            "(//tr[td[contains(., 'Total')]])[1]/td[3]",
            "(//tr[td[contains(., 'Total')]])[1]/td[4]",
            "(//tr[td[contains(., 'Total')]])[1]/td[5]",
            "(//tr[td[contains(., 'Total')]])[1]/td[6]",
            "(//tr[td[contains(., 'Total')]])[1]/td[7]",
            "(//tr[td[contains(., 'Total')]])[1]/td[8]",
            "(//tr[td[contains(., 'Total')]])[1]/td[9]",
            "(//tr[td[contains(., 'Total')]])[1]/td[10]",
            "(//tr[td[contains(., 'Total')]])[1]/td[11]",
            
            "(//tr[td[contains(., 'Total')]])[1]/td[12]",
            "(//tr[td[contains(., 'Total')]])[1]/td[13]",
            "(//tr[td[contains(., 'Total')]])[1]/td[14]",
            "(//tr[td[contains(., 'Total')]])[1]/td[15]",
            "(//tr[td[contains(., 'Total')]])[1]/td[16]",
            "(//tr[td[contains(., 'Total')]])[1]/td[17]",
            "(//tr[td[contains(., 'Total')]])[1]/td[18]",
            "(//tr[td[contains(., 'Total')]])[1]/td[19]",
            "(//tr[td[contains(., 'Total')]])[1]/td[20]",
           
        };
              
        // Initialize a list to store the fetched text
         Dealer_parentTexts = new ArrayList<>();

        // Loop through each XPath and fetch the text
        for (String xpath : Dealer_parent_Group_Wise) {
            try {
                WebElement cell = driver.findElement(By.xpath(xpath));
                Dealer_parentTexts.add(cell.getText()); // Get the text of the element
            } catch (Exception e) {
            	Dealer_parentTexts.add("Not found"); // Handle case where element is not found
            }
        }

        // Print the collected texts
        System.out.println("Dealer_parent_Group_Wise Texts: " + Dealer_parentTexts);
        
	}    
    //.....................................................................................................

    @Test(priority = 9)
    public void Check_Data__Of_Zone_And_Region_Wise() throws InterruptedException {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement Zone_And_Region_Wise1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Zone & Region Wise \"]")));
        Zone_And_Region_Wise1.click();
               
        WebElement clickOnGenerate = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
	    clickOnGenerate.click();
//	    WebElement reportContainer = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//tr[td[contains(., 'CENTRAL')]])[1]/td"))); // Replace with the actual locator for the report
//	    reportContainer.click();
      
        String Xpath="(//tr[td[contains(., 'CENTRAL')]])[1]/td";
        String Name="Zone And Region Wise";    
        checkDataPresence(Xpath,Name);
        
              
     // Fetch required table data
        String[] Zone_And_Region_Wise = {
            "(//tr[td[contains(., 'CENTRAL')]])[1]/td[2]",
            "(//tr[td[contains(., 'CENTRAL')]])[1]/td[3]",
            "(//tr[td[contains(., 'CENTRAL')]])[1]/td[4]",
            "(//tr[td[contains(., 'CENTRAL')]])[1]/td[5]",
            "(//tr[td[contains(., 'CENTRAL')]])[1]/td[6]",
            "(//tr[td[contains(., 'CENTRAL')]])[1]/td[7]",
            "(//tr[td[contains(., 'CENTRAL')]])[1]/td[8]",
            "(//tr[td[contains(., 'CENTRAL')]])[1]/td[9]",
            "(//tr[td[contains(., 'CENTRAL')]])[1]/td[10]",
            "(//tr[td[contains(., 'CENTRAL')]])[1]/td[11]",
            
            "(//tr[td[contains(., 'CENTRAL')]])[1]/td[12]",
            "(//tr[td[contains(., 'CENTRAL')]])[1]/td[13]",
            "(//tr[td[contains(., 'CENTRAL')]])[1]/td[14]",
            "(//tr[td[contains(., 'CENTRAL')]])[1]/td[15]",
            "(//tr[td[contains(., 'CENTRAL')]])[1]/td[16]",
            "(//tr[td[contains(., 'CENTRAL')]])[1]/td[17]",
            "(//tr[td[contains(., 'CENTRAL')]])[1]/td[18]",
            "(//tr[td[contains(., 'CENTRAL')]])[1]/td[19]",
            "(//tr[td[contains(., 'CENTRAL')]])[1]/td[20]",
           
        };
              
        // Initialize a list to store the fetched text
        Zone_RegionTexts = new ArrayList<>();

        // Loop through each XPath and fetch the text
        for (String xpath : Zone_And_Region_Wise) {
            try {
                WebElement cell = driver.findElement(By.xpath(xpath));
                Zone_RegionTexts.add(cell.getText()); // Get the text of the element
            } catch (Exception e) {
            	Zone_RegionTexts.add("Not found"); // Handle case where element is not found
            }
        }

        // Print the collected texts
        System.out.println("Zone And Region Wise Texts: " + Zone_RegionTexts);
        
	}    
    //.....................................................................................................

    @Test(priority = 10)
    public void Check_Data__Of_Workshop_Wise() throws InterruptedException {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement Workshop_WisE = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Workshop Wise \"]")));
        Workshop_WisE.click();
               
        WebElement clickOnGenerate = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
	    clickOnGenerate.click();
//	    WebElement reportContainer = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//tr[td[contains(., 'CENTRAL')]])[1]/td"))); // Replace with the actual locator for the report
//	    reportContainer.click();
      
        String Xpath="(//*[@id=\"excel-table\"]/tbody/tr)[2]";
        String Name="Workshop Wise";    
        checkDataPresence(Xpath,Name);
        
              
     // Fetch required table data
        String[] Workshop_Wise = {
        		 "(//tr[td[contains(., 'Total')]])[2]/td[3]",
                 "(//tr[td[contains(., 'Total')]])[2]/td[4]",
                 "(//tr[td[contains(., 'Total')]])[2]/td[5]",
                 "(//tr[td[contains(., 'Total')]])[2]/td[6]",
                 "(//tr[td[contains(., 'Total')]])[2]/td[7]",
                 "(//tr[td[contains(., 'Total')]])[2]/td[8]",
                 "(//tr[td[contains(., 'Total')]])[2]/td[9]",
                 "(//tr[td[contains(., 'Total')]])[2]/td[10]",
                 "(//tr[td[contains(., 'Total')]])[2]/td[11]",
                 "(//tr[td[contains(., 'Total')]])[2]/td[12]",
                
                 "(//tr[td[contains(., 'Total')]])[2]/td[13]",
                 "(//tr[td[contains(., 'Total')]])[2]/td[14]",
                 "(//tr[td[contains(., 'Total')]])[2]/td[15]",
                 "(//tr[td[contains(., 'Total')]])[2]/td[16]",
                 "(//tr[td[contains(., 'Total')]])[2]/td[17]",
                 "(//tr[td[contains(., 'Total')]])[2]/td[18]",
                 "(//tr[td[contains(., 'Total')]])[2]/td[19]",
                 "(//tr[td[contains(., 'Total')]])[2]/td[20]",
                 "(//tr[td[contains(., 'Total')]])[2]/td[21]",
           
        };
              
        // Initialize a list to store the fetched text
         Workshop_WiseTexts = new ArrayList<>();

        // Loop through each XPath and fetch the text
        for (String xpath : Workshop_Wise) {
            try {
                WebElement cell = driver.findElement(By.xpath(xpath));
                Workshop_WiseTexts.add(cell.getText()); // Get the text of the element
            } catch (Exception e) {
            	Workshop_WiseTexts.add("Not found"); // Handle case where element is not found
            }
        }

        // Print the collected texts
        System.out.println("Workshop Wise Texts: " + Workshop_WiseTexts);
        
	}   
    //.....................................................................................................

    @Test(priority = 11)
    public void Check_Data__Of_Day_Wise() throws InterruptedException {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement Day_WisE = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Day Wise \"]")));
        Day_WisE.click();
               
        WebElement clickOnGenerate = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
	    clickOnGenerate.click();
//	    WebElement reportContainer = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//tr[td[contains(., 'CENTRAL')]])[1]/td"))); // Replace with the actual locator for the report
//	    reportContainer.click();
      
        String Xpath="(//*[@class=\"mat-row cdk-row ng-tns-c314-7 ng-star-inserted\"])[3]";
        String Name="Day Wise";    
        checkDataPresence(Xpath,Name);
        
              
     // Fetch required table data
        String[] Day_Wise = {
        		 "(//tr[td[contains(., 'Total')]])[3]/td[2]",
        		 "(//tr[td[contains(., 'Total')]])[3]/td[3]",
                 "(//tr[td[contains(., 'Total')]])[3]/td[4]",
                 "(//tr[td[contains(., 'Total')]])[3]/td[5]",
                 "(//tr[td[contains(., 'Total')]])[3]/td[6]",
                 "(//tr[td[contains(., 'Total')]])[3]/td[7]",
                 "(//tr[td[contains(., 'Total')]])[3]/td[8]",
                 "(//tr[td[contains(., 'Total')]])[3]/td[9]",
                 "(//tr[td[contains(., 'Total')]])[3]/td[10]",
                 "(//tr[td[contains(., 'Total')]])[3]/td[11]",
                 "(//tr[td[contains(., 'Total')]])[3]/td[12]",
                
                 "(//tr[td[contains(., 'Total')]])[3]/td[13]",
                 "(//tr[td[contains(., 'Total')]])[3]/td[14]",
                 "(//tr[td[contains(., 'Total')]])[3]/td[15]",
                 "(//tr[td[contains(., 'Total')]])[3]/td[16]",
                 "(//tr[td[contains(., 'Total')]])[3]/td[17]",
                 "(//tr[td[contains(., 'Total')]])[3]/td[18]",
                 "(//tr[td[contains(., 'Total')]])[3]/td[19]",
                 "(//tr[td[contains(., 'Total')]])[3]/td[20]",              
           
        };
              
        // Initialize a list to store the fetched text
        Day_WiseTexts = new ArrayList<>();

        // Loop through each XPath and fetch the text
        for (String xpath : Day_Wise) {
            try {
                WebElement cell = driver.findElement(By.xpath(xpath));
                Day_WiseTexts.add(cell.getText()); // Get the text of the element
            } catch (Exception e) {
            	Day_WiseTexts.add("Not found"); // Handle case where element is not found
            }
        }

        // Print the collected texts
        System.out.println("Day Wise Texts  ::: " + Day_WiseTexts);
        
	} 
  //...........................................................................................
    @Test(priority = 13)
    public void Comparison_Of_All_Tab_Text() throws InterruptedException {   	      	    	
    	
    	StringBuilder failureMessages = new StringBuilder();

        try {
            Assert.assertEquals(Zone_RegionTexts, Workshop_WiseTexts, 
                    "Zone Region Texts do not match Workshop Wise Texts!");
        } catch (AssertionError e) {
            Assert.fail("Assertion failed: " + e.getMessage());
        }

        try {
            Assert.assertEquals(Zone_RegionTexts, Day_WiseTexts, 
                    "Zone Region Texts do not match Day Wise Texts!");
        } catch (AssertionError e) {
            Assert.fail("Assertion failed: " + e.getMessage());
        }

        try {
            Assert.assertEquals(Zone_RegionTexts, Dealer_parentTexts, 
                    "Zone Region Texts do not match Dealer parent Texts!");
        } catch (AssertionError e) {
            Assert.fail("Assertion failed: " + e.getMessage());
        }

        if (failureMessages.length() > 0) {
            Assert.fail("Test failed with the following issues:\n" + failureMessages);
        }
    }

  //.....................................................................
		private void clickElementUsingJS(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}
///........................................................................................		
		public void checkDataPresence(String xpath, String contextName) {
			 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(35));
		try {	
			 List<WebElement> allData =  wait1.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath)));

		    if (allData == null || allData.size()== 0) { // Check for null or if the list is empty
		        Assert.fail("'" + contextName + "' does not contain any data.");
		    } else {
		        System.out.println("'" + contextName + "' contains " + allData.size() + " data element(s).");
		    }
		} catch (org.openqa.selenium.TimeoutException e) {
		        // If elements are not found within the specified timeout
			 Assert.fail("'" + contextName + "' does not contain any data.");	    }
		}
			
//................................................................................................		
		private void select_date() throws InterruptedException {
		    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(25));
		   
		    // Click on the calendar to open the date picker
		    WebElement selectCalendar = wait1.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[alt=\"calendar\"]")));
		
		    // Use Actions class for double-click
		     Actions actions = new Actions(driver);
		     actions.doubleClick(selectCalendar).perform();

		    // Click on the "Previous month" button
		    WebElement clickOnPreviousMonth = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Previous month\"]")));
		    clickOnPreviousMonth.click();

		 // Click on the "Previous month" button
		    WebElement clickOn_1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" 1 \"]")));
		    clickOn_1.click();
		 // Click on the "Previous month" button
		    WebElement clickOn_27 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" 27 \"]")));
		    clickOn_27.click();
		  	
		    WebElement clickOnGenerate = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
		    clickOnGenerate.click();
		    

		   
		}
		 //.................................................................................
	    @AfterClass
	    public void tearDown() {
	        if (driver != null) {
	            driver.quit();  
	        }
	    }
		}




    

