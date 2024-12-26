package Excel_Sheet_Data;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class Import_Data_In_CCM extends CCM_Login {

	public static WebDriver driver;
    public WebDriverWait wait;
      
  String Campign_Name="A-Raj-901";
  
 
 
  //......................................................
    @SuppressWarnings("static-access")
    @BeforeClass
    public void Admin_Reports() throws InterruptedException {
        // Initialize the driver (assuming it's static in the SMR_due_Datewise class)
        this.driver = CCM_Login.driver;

     // Initialize WebDriverWait with a timeout of 10 seconds using Duration
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
	
    //.....................................................................................................

    @Test(priority = 6)
    public void Click_On_Import_Data() throws InterruptedException {
    	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Import_Data = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Import Data \"]")));
        clickElementUsingJS(driver, Import_Data);
        
        WebElement Click_On_Create_Campign = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Create Campaign \"]")));
        clickElementUsingJS(driver, Click_On_Create_Campign);
      
    }
    
    //.....................................................................................................

    @Test(priority = 7)
    public void Click_On_Choose_File() throws InterruptedException {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement chooseFile = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@type='file']")));
        clickElementUsingJS(driver, chooseFile);
        
    }
    //......................................................................................
	@Test(priority = 8)
	public void Upload_file() throws InterruptedException, AWTException {		
		   WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		// Path to the file to be uploaded
    String filePath = "\"C:\\Users\\AA\\Downloads\\demo_Excel.xlsx\"";
    
    // Call the upload function
    uploadFile(filePath);
   // uploadFile(filePath);
    WebElement Next = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Next\"]")));
    clickElementUsingJS(driver, Next);
    Thread.sleep(400);
    
    WebElement Clcik_On_Validate = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[text()=\"Validate\"])[2]")));
    clickElementUsingJS(driver, Clcik_On_Validate);
}
	
	//......................................................................................
	@Test(priority = 9)
	public void Click_On_Next() throws InterruptedException, IOException {
	    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
	    WebElement Next = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Next\"]")));
	    clickElementUsingJS(driver, Next);
	    
	    WebElement Import = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()=\"Import\"])[2]")));
	    clickElementUsingJS(driver, Import);
	    
	    String message ="Import Process has been scheduled.";
	    WebElement Import_Message = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Import Process has been scheduled.\"]")));

	    String getMessage=Import_Message.getText();
	    System.out.println("Import_Message ::  "+ getMessage);
	    Assert.assertEquals(message, getMessage,"Not Display, Import Process has been scheduled.");
	    
	    
	}
	//......................................................................................
		@Test(priority = 10)
		public void Match_Data_of_Excel() throws InterruptedException, IOException {
		    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));		   
	        excel_Data_Match.getInstance().excelData();
	        
	        WebElement Registration1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr[1]/td[4]")));
	        WebElement Registration2 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr[2]/td[4]")));
	        WebElement Registration3 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr[3]/td[4]")));
	        WebElement Registration4 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr[4]/td[4]")));
	        WebElement Registration5= wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr[5]/td[4]")));

	        String Registration_Number1=Registration1.getText();
	        String Registration_Number2=Registration2.getText();
	        String Registration_Number3=Registration3.getText();
	        String Registration_Number4=Registration4.getText();
	        String Registration_Number5=Registration5.getText();
	        
	        System.out.println(" 1st_Registration number  :: "+Registration_Number1);
	        System.out.println(" 2nd_Registration number  :: "+Registration_Number2);
	        System.out.println(" 3rd_Registration number  :: "+Registration_Number3);
	        System.out.println(" 4th_Registration number  :: "+Registration_Number4);
	        System.out.println(" 5th_Registration number  :: "+Registration_Number5);

		   Assert.assertEquals(Registration_Number1, excel_Data_Match.MU1, "1st Registration number doesn't match");
		   Assert.assertEquals(Registration_Number2, excel_Data_Match.MU2, "2nd Registration number doesn't match");
		   Assert.assertEquals(Registration_Number3, excel_Data_Match.MU3, "3rd Registration number doesn't match");
		   Assert.assertEquals(Registration_Number4, excel_Data_Match.MU4, "4th Registration number doesn't match");
		   Assert.assertEquals(Registration_Number5, excel_Data_Match.MU5, "5th Registration number doesn't  match");
 
	        
		}

		//......................................................................................
		@Test(priority = 11)
		public void Select_All_Customer() throws InterruptedException, IOException {
	    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));	
        WebElement CheckBox = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"mat-checkbox-1\"]/label/span[1]")));
        CheckBox.click();	
        
        WebElement Click_On_AddCampign = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Add To Campaign \"]")));
        Click_On_AddCampign.click();
		}
		
		//......................................................................................
		@Test(priority = 12)
		public  void Select_All_Filter2() throws InterruptedException, IOException, TimeoutException {
		    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));

		    // Locate and input Sub Campaign Name
		   
		     WebElement Sub_Campaign_Name = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id and contains(@id, 'mat-tab-content')]//input)[1]")));
		   //  enteredValue = "Ram-989";
		     Sub_Campaign_Name.sendKeys(Campign_Name);

		    Thread.sleep(300);

		    // Select End Date
		    WebElement Select_End_date = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[@class=\"mat-datepicker-toggle\"])[2]")));
		    Select_End_date.click();

		    // Click to navigate to the next month and select the date
		    WebElement Click_next_Month = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label=\"Next month\"]")));
		    Click_next_Month.click();

		    WebElement Click_Date27 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" 27 \"]")));
		    Click_Date27.click();

		    // Click the checkbox
		    WebElement Click_check_Box = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(@id, 'mat-checkbox-')]/label/span[1])[7]")));
		    Click_check_Box.click();
		    Thread.sleep(400);

		    // Click the Add button
		    WebElement Click_ADD = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Add\"]")));
		    clickElementUsingJS(driver, Click_ADD);

		    WebElement validationMessage = wait1.until(ExpectedConditions.visibilityOfElementLocated(
			    By.xpath("//*[contains(text(), 'Sub-campaign already exists')]")
			));
			
			if (validationMessage.isDisplayed()) {
			    System.out.println("Validation message displayed: Duplicate Campaign name. Please change the campaign name.");
			   // driver.quit();
			    Assert.fail(" Duplicate Campaign name. Please change the campaign name.");
			}}
		
						
		@Test(priority = 13)
		public void Remove_Data_Allocation() throws InterruptedException, IOException {
		    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(3));

		    // Loop to click checkboxes 2 to 5
		    for (int i = 10; i <= 13; i++) {
		        WebElement checkBox = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[contains(@id, 'mat-checkbox')]/label/span[1])[" + i + "]")));
		        checkBox.click();
		    }

		    // Click Submit button
		    WebElement Click_Submit = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\" Submit \"]")));
		    clickElementUsingJS(driver, Click_Submit);

		    // Click Yes button
		    WebElement Click_yes = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()=\"Yes\"]")));
		    clickElementUsingJS(driver, Click_yes);
		}
		   //..................................................................................
        @AfterClass
        public void TearsDown() {
      	  
      	  driver.quit();
        }
    //.....................................................................
		private void clickElementUsingJS(WebDriver driver, WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", element);
		}
		
		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		public static void uploadFile(String filePath) throws AWTException, InterruptedException {
	        // Provide the path of the file to be uploaded
	        StringSelection fileToUpload = new StringSelection(filePath);
	        
	        // Copy the file path to the clipboard
	        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(fileToUpload, null);
	        
	        // Use Robot class to handle the system dialog and upload file
	        Robot robot = new Robot();
	        
	        // Brief delay to ensure the upload dialog is open
	        Thread.sleep(1000);
	        
	        // Press Ctrl + V to paste the file path into the dialog
	        robot.keyPress(KeyEvent.VK_CONTROL);
	        robot.keyPress(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_V);
	        robot.keyRelease(KeyEvent.VK_CONTROL);
	        
	        // Brief delay to ensure the path is pasted
	        Thread.sleep(500);
	        
	        // Press Enter to confirm the file upload
	        robot.keyPress(KeyEvent.VK_ENTER);
	        robot.keyRelease(KeyEvent.VK_ENTER);
	        
	        // Additional delay for confirmation if necessary
	        Thread.sleep(1000);
	    }
		
}
