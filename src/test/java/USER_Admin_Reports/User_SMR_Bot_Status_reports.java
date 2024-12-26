package USER_Admin_Reports;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class User_SMR_Bot_Status_reports extends Login_Admin{
	

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
    public void Click_On_SMR_Bot_Status() throws InterruptedException {
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement SMR_Bot_Status = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"SMR Bot Status \"]")));
        clickElementUsingJS(driver, SMR_Bot_Status);	
        
    }
    
  //.....................................................................................................

    @Test(priority = 8)
    public void Check_Data_Workshop_Wise() throws InterruptedException {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(35));
        select_date();
       
        // Data contains or not  
        String Xpath="(//tr[td[contains(., \"Total\")]])[1]/td";
        String Name="Workshop Wise";    
        checkDataPresence(Xpath,Name);
        
     // Fetch required table data
        String[] Workshop_Wise = {
        		 "(//tr[td[contains(., \"Total\")]])[1]/td[3]",
        		 "(//tr[td[contains(., \"Total\")]])[1]/td[4]",
        		 "(//tr[td[contains(., \"Total\")]])[1]/td[5]",
        		 "(//tr[td[contains(., \"Total\")]])[1]/td[6]",
        		 "(//tr[td[contains(., \"Total\")]])[1]/td[7]",
        		 "(//tr[td[contains(., \"Total\")]])[1]/td[8]",
        		 "(//tr[td[contains(., \"Total\")]])[1]/td[9]",
        		 "(//tr[td[contains(., \"Total\")]])[1]/td[10]",
        		 "(//tr[td[contains(., \"Total\")]])[1]/td[11]",
        		 
        		 "(//tr[td[contains(., \"Total\")]])[1]/td[12]",
        		 "(//tr[td[contains(., \"Total\")]])[1]/td[13]",
        		 "(//tr[td[contains(., \"Total\")]])[1]/td[14]",
        		 "(//tr[td[contains(., \"Total\")]])[1]/td[15]",
        		 "(//tr[td[contains(., \"Total\")]])[1]/td[16]",
        		 "(//tr[td[contains(., \"Total\")]])[1]/td[17]",
        		 "(//tr[td[contains(., \"Total\")]])[1]/td[18]",
        		 "(//tr[td[contains(., \"Total\")]])[1]/td[19]",
        		 "(//tr[td[contains(., \"Total\")]])[1]/td[20]",
        		 
        		 "(//tr[td[contains(., \"Total\")]])[1]/td[21]",
        		 "(//tr[td[contains(., \"Total\")]])[1]/td[22]",
        		 "(//tr[td[contains(., \"Total\")]])[1]/td[23]",
        		 "(//tr[td[contains(., \"Total\")]])[1]/td[24]",
        		 "(//tr[td[contains(., \"Total\")]])[1]/td[25]",
        		
                 
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

    @Test(priority = 9)
    public void Check_Data_Day_Wise() throws InterruptedException {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(35));
        WebElement Click_On_Day_Wise = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Day Wise \"]")));
        Click_On_Day_Wise.click();
        
        select_date();
  
        // Data contains or not       
        String Xpath="(//tr[td[contains(., \"Total\")]])[2]/td";
        String Name="Data Day Wise";     
        checkDataPresence(Xpath,Name);
        
        // Fetch required table data
        String[] Day_Wise = {
        		 "(//tr[td[contains(., \"Total\")]])[2]/td[2]",
        		 "(//tr[td[contains(., \"Total\")]])[2]/td[3]",
        		 "(//tr[td[contains(., \"Total\")]])[2]/td[4]",
        		 "(//tr[td[contains(., \"Total\")]])[2]/td[5]",
        		 "(//tr[td[contains(., \"Total\")]])[2]/td[6]",
        		 "(//tr[td[contains(., \"Total\")]])[2]/td[7]",
        		 "(//tr[td[contains(., \"Total\")]])[2]/td[8]",
        		 "(//tr[td[contains(., \"Total\")]])[2]/td[9]",
        		 "(//tr[td[contains(., \"Total\")]])[2]/td[10]",
        		
        		 "(//tr[td[contains(., \"Total\")]])[2]/td[11]",
        		 "(//tr[td[contains(., \"Total\")]])[2]/td[12]",
        		 "(//tr[td[contains(., \"Total\")]])[2]/td[13]",
        		 "(//tr[td[contains(., \"Total\")]])[2]/td[14]",
        		 "(//tr[td[contains(., \"Total\")]])[2]/td[15]",
        		 "(//tr[td[contains(., \"Total\")]])[2]/td[16]",
        		 "(//tr[td[contains(., \"Total\")]])[2]/td[17]",
        		 "(//tr[td[contains(., \"Total\")]])[2]/td[18]",
        		 "(//tr[td[contains(., \"Total\")]])[2]/td[19]",
        		 "(//tr[td[contains(., \"Total\")]])[2]/td[20]",
        		 
        		 "(//tr[td[contains(., \"Total\")]])[2]/td[21]",
        		 "(//tr[td[contains(., \"Total\")]])[2]/td[22]",
        		 "(//tr[td[contains(., \"Total\")]])[2]/td[23]",
        		 "(//tr[td[contains(., \"Total\")]])[2]/td[24]",
                 
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

    @Test(priority = 10)
    public void Check_Service_Type_Wise() throws InterruptedException {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(35));
        WebElement Click_On_Service_Type_Wise = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Service Type Wise \"]")));
        Click_On_Service_Type_Wise.click();
        
        select_date();
       
        // Data contains or not  
        String Xpath="(//tr[td[contains(., \"Total\")]])[3]/td";
        String Name="Service Type Wise";     
        checkDataPresence(Xpath,Name);
        
        // Fetch required table data
        String[] Service_Type_Wise = {
        		 "(//tr[td[contains(., \"Total\")]])[3]/td[2]",
        		 "(//tr[td[contains(., \"Total\")]])[3]/td[3]",
        		 "(//tr[td[contains(., \"Total\")]])[3]/td[4]",
        		 "(//tr[td[contains(., \"Total\")]])[3]/td[5]",
        		 "(//tr[td[contains(., \"Total\")]])[3]/td[6]",
        		 "(//tr[td[contains(., \"Total\")]])[3]/td[7]",
        		 "(//tr[td[contains(., \"Total\")]])[3]/td[8]",
        		 "(//tr[td[contains(., \"Total\")]])[3]/td[9]",
        		 "(//tr[td[contains(., \"Total\")]])[3]/td[10]",
        		
        		 "(//tr[td[contains(., \"Total\")]])[3]/td[11]",
        		 "(//tr[td[contains(., \"Total\")]])[3]/td[12]",
        		 "(//tr[td[contains(., \"Total\")]])[3]/td[13]",
        		 "(//tr[td[contains(., \"Total\")]])[3]/td[14]",
        		 "(//tr[td[contains(., \"Total\")]])[3]/td[15]",
        		 "(//tr[td[contains(., \"Total\")]])[3]/td[16]",
        		 "(//tr[td[contains(., \"Total\")]])[3]/td[17]",
        		 "(//tr[td[contains(., \"Total\")]])[3]/td[18]",
        		 "(//tr[td[contains(., \"Total\")]])[3]/td[19]",
        		 "(//tr[td[contains(., \"Total\")]])[3]/td[20]",
        		 
        		 "(//tr[td[contains(., \"Total\")]])[3]/td[21]",
        		 "(//tr[td[contains(., \"Total\")]])[3]/td[22]",
        		 "(//tr[td[contains(., \"Total\")]])[3]/td[23]",
        		 "(//tr[td[contains(., \"Total\")]])[3]/td[24]",
                 
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
    
    //.......................................................................................
    @Test(priority = 14)
    public void Comparison_Of_All_Tab_Text() throws InterruptedException {    
        StringBuilder failureMessages = new StringBuilder();

        // Check if any tab does not contain data
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
            try {
                Assert.assertEquals(Workshop_WiseTexts, Day_WiseTexts,
                        "Workshop Wise Texts do not match with Day Wise.");
            } catch (AssertionError e) {
                failureMessages.append("Workshop Wise Texts do not match with Day Wise: ").append(e.getMessage()).append("\n");
            }

            try {
                Assert.assertEquals(Workshop_WiseTexts, Service_TypeTexts, 
                        "Workshop Wise Texts do not match Service Type Wise.");
            } catch (AssertionError e) {
                failureMessages.append("Workshop Wise Texts do not match Service Type Wise: ").append(e.getMessage()).append("\n");
            }
        }

        // Fail if there are any issues
        if (failureMessages.length() > 0) {
            Assert.fail("Test failed with the following issues:\n" + failureMessages.toString());
        }
    }

    //.................................................................................
    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();  
        }
    }
    
    //////////////////////////////////////////////////////////////////////////////////////////////
    
  //.....................................................................
  		private void clickElementUsingJS(WebDriver driver, WebElement element) {
  			JavascriptExecutor js = (JavascriptExecutor) driver;
  			js.executeScript("arguments[0].click();", element);
  		}
 //................................................................................................. 		
  		public void checkDataPresence(String xpath, String contextName) {
		    List<WebElement> AllData = driver.findElements(By.xpath(xpath));

		    if (AllData == null || AllData.size() == 0) {
		        Assert.fail("'" + contextName + "' Admin Reports does not contain any data it is  null.");
		    } else {
		        System.out.println("'" + contextName + "' Admin Reports contains data.");
		    }
		}
//.............................................................................................
  		

  //................................................................................................		
  		private void select_date() throws InterruptedException {
  			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
  			 // Click on the calendar to open date picker
  	        WebElement select = wait1.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[alt=\"calendar\"]")));
  	        select.click();
  	       	        // Select start date (1st of the current month)
  	        LocalDate today = LocalDate.now();
  	        LocalDate firstDayOfMonth = today.withDayOfMonth(1);
  	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");


  	        WebElement selectStart = wait1.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label=\"" + firstDayOfMonth.format(formatter) + "\"]")));
  	        selectStart.click();
  	      	        // Select today's date
  	        WebElement selectToday = wait1.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label=\"" + today.format(formatter) + "\"]")));
  	        selectToday.click();
  	        	        // Click on the generate report button
  	        Thread.sleep(400);
  	        WebElement clickOnGenerate = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
  	        clickOnGenerate.click();

  		}
  }

