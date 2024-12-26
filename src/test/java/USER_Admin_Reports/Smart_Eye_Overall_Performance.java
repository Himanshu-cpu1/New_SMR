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

public class Smart_Eye_Overall_Performance extends Login_Admin {
		
	private  List<String> Dealer_parentTexts;
	private  List<String> Zone_RegionTexts;
	private  List<String> Workshop_WiseTexts ;
	private  List<String> Day_WiseTexts;
	private  List<String> Service_TypeTexts;
	 
	 
	
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
    public void Click_On_Smart_Eye_Overall_Performance() throws InterruptedException {
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Smart_Eye_Overall_Performance = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Smart Eye Overall Performance \"]")));
        clickElementUsingJS(driver, Smart_Eye_Overall_Performance);	
        
    }
    
  //.....................................................................................................

    @Test(priority = 8)
    public void Check_Data__Of_Zone_And_Region_Wise() throws InterruptedException {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(35));               
        select_date();
       
        // Data contains or not  
        String Xpath="//tr[td[contains(normalize-space(), 'All INDIA')]]/td";
        String Name="Zone And Region Wise";    
        checkDataPresence(Xpath,Name);
        
     // Fetch required table data
        String[] Zone_And_Region_Wise = {
            "//tr[td[contains(normalize-space(), 'All INDIA')]]/td[2]",
            "//tr[td[contains(normalize-space(), 'All INDIA')]]/td[3]",
            "//tr[td[contains(normalize-space(), 'All INDIA')]]/td[4]",
            "//tr[td[contains(normalize-space(), 'All INDIA')]]/td[5]",
            "//tr[td[contains(normalize-space(), 'All INDIA')]]/td[6]",
            "//tr[td[contains(normalize-space(), 'All INDIA')]]/td[7]",
            "//tr[td[contains(normalize-space(), 'All INDIA')]]/td[8]",
            "//tr[td[contains(normalize-space(), 'All INDIA')]]/td[9]",
            "//tr[td[contains(normalize-space(), 'All INDIA')]]/td[10]",
            "//tr[td[contains(normalize-space(), 'All INDIA')]]/td[11]",
                     
           
        };
              
        // Initialize a list to store the fetched text
        Zone_RegionTexts = new ArrayList<>();

        // Loop through each XPath and fetch the text
        for (String xpath : Zone_And_Region_Wise) {
            try {
                WebElement cell = driver.findElement(By.xpath(xpath));
             // Ensure the element is visible (scroll into view)
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cell);
                
                // Optionally wait for the element to be interactable/visible
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.visibilityOf(cell));
                
                Zone_RegionTexts.add(cell.getText()); // Get the text of the element
            } catch (Exception e) {
            	Zone_RegionTexts.add("Not found"); // Handle case where element is not found
            }
        }

        // Print the collected texts
        System.out.println("Zone And Region Wise Texts: " + Zone_RegionTexts);
        
	}    
       
    //.....................................................................................................

    @Test(priority = 9)
    public void Check_Data__Of_Dealer_Parent_Group_Wise() throws InterruptedException {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(35));
        WebElement Dealer_Parent_Group_Wise1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Dealer Parent Group Wise \"]")));
        Dealer_Parent_Group_Wise1.click();
        
        WebElement clickOnGenerate = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
	    clickOnGenerate.click();
		Thread.sleep(3000);
       
        // Data contains or not  
        String Xpath="//*[@id=\"excel-table\"]/tbody/tr";
        String Name="Dealer Parent Group Wise";    
        checkDataPresence(Xpath,Name);
        
        // Fetch required table data
        String[] Dealer_Parent_Group_Wise = {
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
                     
           
        };
              
        // Initialize a list to store the fetched text
        Dealer_parentTexts = new ArrayList<>();

       // Loop through each XPath and fetch the text
       for (String xpath : Dealer_Parent_Group_Wise) {
           try {
               WebElement cell = driver.findElement(By.xpath(xpath));
            // Ensure the element is visible (scroll into view)
               ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cell);
               
               // Optionally wait for the element to be interactable/visible
               WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
               wait.until(ExpectedConditions.visibilityOf(cell));
               
               Dealer_parentTexts.add(cell.getText()); // Get the text of the element
           } catch (Exception e) {
           	Dealer_parentTexts.add("Not found"); // Handle case where element is not found
           }
       }

       // Print the collected texts
       System.out.println("Dealer_parent_Group_Wise Texts: " + Dealer_parentTexts);
       
	}    
          
    
    //.....................................................................................................

    @Test(priority = 10)
    public void Check_Data__Of_Workshop_Wise() throws InterruptedException {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(35));
        WebElement Workshop_WisE = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Workshop Wise \"]")));
        Workshop_WisE.click();
        
        WebElement clickOnGenerate = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
	    clickOnGenerate.click();
		Thread.sleep(3000);
       
        // Data contains or not  
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
                 
        };
     // Initialize a list to store the fetched text
        Workshop_WiseTexts = new ArrayList<>();

       // Loop through each XPath and fetch the text
       for (String xpath : Workshop_Wise) {
           try {
               WebElement cell = driver.findElement(By.xpath(xpath));
            // Ensure the element is visible (scroll into view)
               ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cell);
               
               // Optionally wait for the element to be interactable/visible
               WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
               wait.until(ExpectedConditions.visibilityOf(cell));
               
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
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(35));
        WebElement Day_WisE = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Day Wise \"]")));
        Day_WisE.click();
        
        WebElement clickOnGenerate = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
	    clickOnGenerate.click();
		Thread.sleep(3000);
       
        // Data contains or not  
        String Xpath="(//*[@id=\"excel-table\"]/tbody/tr)[4]";
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
                 
        };
        // Initialize a list to store the fetched text
        Day_WiseTexts = new ArrayList<>();

        // Loop through each XPath and fetch the text
        for (String xpath : Day_Wise) {
            try {
                WebElement cell = driver.findElement(By.xpath(xpath));
             // Ensure the element is visible (scroll into view)
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cell);
                
                // Optionally wait for the element to be interactable/visible
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.visibilityOf(cell));
                
                Day_WiseTexts.add(cell.getText()); // Get the text of the element
            } catch (Exception e) {
            	Day_WiseTexts.add("Not found"); // Handle case where element is not found
            }
        }

        // Print the collected texts
        System.out.println("Day Wise Texts  ::: " + Day_WiseTexts);
        
	} 
  //.....................................................................................................

    @Test(priority = 12)
    public void Check_Data__Of_Service_Type_Wise() throws InterruptedException {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement Service_Type_WisE = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Service Type Wise \"]")));
        Service_Type_WisE.click();
        
        WebElement clickOnGenerate = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
	    clickOnGenerate.click();
		Thread.sleep(4000);
//		// Scroll down to the Vehicle Information section
//        Actions actions2 = new Actions(driver);
//        actions2.sendKeys(Keys.PAGE_DOWN).perform();
        
        // Data contains or not  
        String Xpath="(//*[@id=\"excel-table\"]/tbody/tr)[5]";
        String Name="Service Type Wise";    
        checkDataPresence(Xpath,Name);
        
        // Fetch required table data
        String[] Service_Type_Wise = {
        		 "(//tr[td[contains(., 'Total')]])[4]/td[2]",
        		 "(//tr[td[contains(., 'Total')]])[4]/td[3]",
        		 "(//tr[td[contains(., 'Total')]])[4]/td[4]",
        		 "(//tr[td[contains(., 'Total')]])[4]/td[5]",
        		 "(//tr[td[contains(., 'Total')]])[4]/td[6]",
        		 "(//tr[td[contains(., 'Total')]])[4]/td[7]",
                 "(//tr[td[contains(., 'Total')]])[4]/td[8]",
                 "(//tr[td[contains(., 'Total')]])[4]/td[9]",
                 "(//tr[td[contains(., 'Total')]])[4]/td[10]",
                 "(//tr[td[contains(., 'Total')]])[4]/td[11]",
                
                 
        };
     // Initialize a list to store the fetched text
        Service_TypeTexts = new ArrayList<>();

        // Loop through each XPath and fetch the text
        for (String xpath : Service_Type_Wise) {
            try {
                WebElement cell = driver.findElement(By.xpath(xpath));
                
                // Ensure the element is visible (scroll into view)
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cell);
                
                // Optionally wait for the element to be interactable/visible
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.visibilityOf(cell));
                
                // Fetch the text
                Service_TypeTexts.add(cell.getText());
            } catch (Exception e) {
                Service_TypeTexts.add("Not found"); // Handle case where element is not found
            }
        }

        // Print the collected texts
        System.out.println("Service Type Wise Texts  ::: " + Service_TypeTexts);
    }
    
    //...........................................................................................
    @Test(priority = 14)
    public void Comparison_Of_All_Tab_Text() throws InterruptedException {   	      	    	
    	
    	StringBuilder failureMessages = new StringBuilder();
   	   	
    	 // Check if any tab does not contain data
    	
    	 if (Zone_RegionTexts == null || Zone_RegionTexts.isEmpty()) {
             failureMessages.append("Zone Region Texts is empty or null.\n");
         }
    	 if (Dealer_parentTexts == null || Dealer_parentTexts.isEmpty()) {
             failureMessages.append("Dealer parent wise  Texts is empty or null.\n");
         }
    	 
        if (Workshop_WiseTexts == null || Workshop_WiseTexts.isEmpty()) {
            failureMessages.append("Workshop Wise Texts is empty or null.\n");
        }

        if (Day_WiseTexts == null || Day_WiseTexts.isEmpty()) {
            failureMessages.append("Day Wise Texts is empty or null.\n");
        }

        if (Service_TypeTexts == null || Service_TypeTexts.isEmpty()) {
            failureMessages.append("Service Type Texts is empty or null.\n");
        }

        // Perform comparisons if all tabs contain data
        if (failureMessages.length() == 0) {
        	
        }
        try {
            Assert.assertEquals(Zone_RegionTexts, Workshop_WiseTexts, 
                    "Zone Region Texts do not match Workshop Wise Texts");
        } catch (AssertionError e) {
            Assert.fail("Assertion failed: " + e.getMessage());
        }

        try {
            Assert.assertEquals(Zone_RegionTexts, Day_WiseTexts, 
                    "Zone Region Texts do not match Day Wise Texts");
        } catch (AssertionError e) {
            Assert.fail("Assertion failed: " + e.getMessage());
        }

        try {
            Assert.assertEquals(Zone_RegionTexts, Dealer_parentTexts, 
                    "Zone Region Texts do not match Dealer parent Texts");
        } catch (AssertionError e) {
            Assert.fail("Assertion failed: " + e.getMessage());
        }
        try {
            Assert.assertEquals(Zone_RegionTexts, Service_TypeTexts, 
                    "Zone Region Texts do not match Service Type Texts");
        } catch (AssertionError e) {
            Assert.fail("Assertion failed: " + e.getMessage());
        }

        if (failureMessages.length() > 0) {
            Assert.fail("Test failed with the following issues:\n" + failureMessages);
        }
    }
    
    //.................................................................................
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();  
        }
    }
  //.....................................................................
		private void clickElementUsingJS(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}
///........................................................................................		
		public void checkDataPresence(String xpath, String contextName) {
		    List<WebElement> allData = driver.findElements(By.xpath(xpath));

		    if (allData == null || allData.size() == 0) { // Check for null or if the list is empty
		        Assert.fail("'" + contextName + "' does not contain any data.");
		    } else {
		        System.out.println("'" + contextName + "' contains " + allData.size() + " data element(s).");
		    }
		}


		

		

//................................................................................................		
		private void select_date() throws InterruptedException {
		    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
		   
		    // Click on the calendar to open the date picker
		    WebElement selectCalendar = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[alt=\"calendar\"]")));
		    selectCalendar.click();
		    // Click on the "Previous month" button
		    WebElement clickOnPreviousMonth = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Previous month\"]")));
		    clickOnPreviousMonth.click();

		 // Click on the "Previous month" button
		    WebElement clickOn_1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" 1 \"]")));
		    clickOn_1.click();
		 // Click on the "Previous month" button
		    WebElement clickOn_15 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" 15 \"]")));
		    clickOn_15.click();

		    // Click on the "Generate" report button
		    Thread.sleep(500);
		    WebElement clickOnGenerate = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
		    clickOnGenerate.click();
			Thread.sleep(3000);
		
		}
		}




    

