package MergeCCM_Reports;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import mergeSMR_North_Zone.LOGIN;
public class SMR_due_Datewise extends login {

	  public static WebDriver driver;
	    public WebDriverWait wait;
	   
	    String d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14;
	    String w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11, w12, w13, w14;
	    String day1, day2, day3, day4, day5, day6, day7, day8, day9, day10, day11, day12, day13, day14;
	    String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14;
	    String SM1, SM2, SM3, SM4, SM5, SM6, SM7, SM8, SM9, SM10, SM11, SM12, SM13, SM14;

	   
	    //..................................................................................................
	    @SuppressWarnings("static-access")
	    @BeforeClass
	    public void SMR() throws InterruptedException {
	        this.driver = login.driver;
	    }

	  	 //..................................................................................................
	    @Test(priority =8)
	    public void Click_On_The_Dealer_Parent_Wise() throws InterruptedException {
	        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        WebElement SMR = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"SMR Due Date Wise \"]")));
	        clickElementUsingJS(driver, SMR);
	        Thread.sleep(3000);	
	    
  			DateSelector();  			  		

          //Elements of Zone and Region Wise
          WebElement Data_Assigned = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[2]"));	
          WebElement Reported_At_Own = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[3]"));
          WebElement ReportedAtSame_Parent_Other_Outlet = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[4]"));
          WebElement Reported_Other = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[5]"));
          WebElement Appointment_Booked = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[6]"));
          WebElement CallMeLater = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[7]"));
          WebElement LowMileage = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[8]"));
          WebElement VehicleSoldTo_New_Owner = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[9]"));
          WebElement RefuseForService = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[10]"));
          WebElement WrongNo = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[11]"));
          WebElement AppointmentCancelled = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[12]"));
          WebElement CallNotConnected = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[13]"));
          WebElement Fresh = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[14]"));
          WebElement PendingFresh = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[15]"));
          Thread.sleep(1000);
          //GET THE VALUES

          d1 = Data_Assigned.getText();
          System.out.println("d1  "+d1);
          d2 = Reported_At_Own.getText();
          d3 = ReportedAtSame_Parent_Other_Outlet.getText();
          d4 = Reported_Other.getText();
          d5 = Appointment_Booked.getText();
          d6 = CallMeLater.getText();
          d7 = LowMileage.getText();
          d8 = VehicleSoldTo_New_Owner.getText();
          d9 = RefuseForService.getText();
          d10 = WrongNo.getText();
          d11 = AppointmentCancelled.getText();
          d12 = CallNotConnected.getText();
          d13 = Fresh.getText();
          d14 = PendingFresh.getText();
          Thread.sleep(1000);

          try {

              // Parse the Total Due value to a numeric type
              double totalDueValue = Double.parseDouble(d1);

              if (totalDueValue <= 0) {

                  // Fail the test if Total Due value is 0 or less
                  Assert.fail("No Data Found for Dealer_Parent Wise In SMR due Date wise : " + d1);
              } else {
                  // Print the Total Due value
                  System.out.println(" Data_Assigned of Dealer_Parent Wise  In SMR due Date wise ::: " + d1);
              }

              if (d1 == null) {
                  Assert.fail("No Data Found for Dealer_Parent Wise In SMR due Date wise  " + d1);
              }

          } catch (Exception e) {
              // Fail the test if an exception is thrown
              Assert.fail("No Data Found for Dealer_Parent Wise In SMR due Date wise  " + e.getMessage());
          }
      }
	  //.................................................................................................................

	    @Test(priority = 9)
	    public void WorkShop_Wise() throws InterruptedException {	       
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        WebElement WorkShop_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Workshop Wise \"]")));
	        WorkShop_Wise.click();
	        Thread.sleep(3000);

	        // Click on the generate report button
	        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
	        clickOnGenerate.click();
  			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));  			

  		  //Elements of Zone and Region Wise
            WebElement Data_Assigned = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[3]"));	
            WebElement Reported_At_Own = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[4]"));
            WebElement ReportedAtSame_Parent_Other_Outlet = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[5]"));
            WebElement Reported_Other = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[6]"));
            WebElement Appointment_Booked = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[7]"));
            WebElement CallMeLater = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[8]"));
            WebElement LowMileage = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[9]"));
            WebElement VehicleSoldTo_New_Owner = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[10]"));
            WebElement RefuseForService = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[11]"));
            WebElement WrongNo = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[12]"));
            WebElement AppointmentCancelled = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[13]"));
            WebElement CallNotConnected = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[14]"));
            WebElement Fresh = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[15]"));
            WebElement PendingFresh = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[16]"));
            Thread.sleep(1000);
            //GET THE VALUES

            w1 = Data_Assigned.getText();
            w2 = Reported_At_Own.getText();
            w3 = ReportedAtSame_Parent_Other_Outlet.getText();
            w4 = Reported_Other.getText();
            w5 = Appointment_Booked.getText();
            w6 = CallMeLater.getText();
            w7 = LowMileage.getText();
            w8 = VehicleSoldTo_New_Owner.getText();
            w9 = RefuseForService.getText();
            w10 = WrongNo.getText();
            w11 = AppointmentCancelled.getText();
            w12 = CallNotConnected.getText();
            w13 = Fresh.getText();
            w14 = PendingFresh.getText();
            Thread.sleep(1000);
	       
	        try {

	            // Parse the Total Due value to a numeric type
	            double totalDueValue = Double.parseDouble(w1);

	            if (totalDueValue <= 0 || w1 == null) {
	                // Fail the test if Total Due value is 0 or less
	                Assert.fail("No Data Found for WorkShop_Wise In SMR due Date wise : " + w1);
	            } else {
	                // Print the Total Due value
	                System.out.println(" Data_Assigned of WorkShop_Wise In SMR due Date wise  ::: " + w1);
	            }

	        } catch (Exception e) {
	            // Fail the test if an exception is thrown
	            Assert.fail("No Data Found for WorkShop_Wise  In SMR due Date wise " + e.getMessage());
	        }
	    }
	    	 
	    //..........................................................................................................

	    @Test(priority = 10)
	    public void Day_Wise() throws InterruptedException {
	        Thread.sleep(1000);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        WebElement Day_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Day Wise \"]")));
	        Day_Wise.click();
	        Thread.sleep(3000);

	        // Click on the generate report button
	        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
	        clickOnGenerate.click();
  			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));  			

	        //Elements of Zone and Region Wise
            WebElement Data_Assigned = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[2]"));	
            WebElement Reported_At_Own = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[3]"));
            WebElement ReportedAtSame_Parent_Other_Outlet = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[4]"));
            WebElement Reported_Other = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[5]"));
            WebElement Appointment_Booked = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[6]"));
            WebElement CallMeLater = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[7]"));
            WebElement LowMileage = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[8]"));
            WebElement VehicleSoldTo_New_Owner = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[9]"));
            WebElement RefuseForService = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[10]"));
            WebElement WrongNo = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[11]"));
            WebElement AppointmentCancelled = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[12]"));
            WebElement CallNotConnected = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[13]"));
            WebElement Fresh = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[14]"));
            WebElement PendingFresh = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[15]"));
            Thread.sleep(1000);
            //GET THE VALUES

            day1 = Data_Assigned.getText();
            day2 = Reported_At_Own.getText();
            day3 = ReportedAtSame_Parent_Other_Outlet.getText();
            day4 = Reported_Other.getText();
            day5 = Appointment_Booked.getText();
            day6 = CallMeLater.getText();
            day7 = LowMileage.getText();
            day8 = VehicleSoldTo_New_Owner.getText();
            day9 = RefuseForService.getText();
            day10 = WrongNo.getText();
            day11 = AppointmentCancelled.getText();
            day12 = CallNotConnected.getText();
            day13 = Fresh.getText();
            day14 = PendingFresh.getText();           
	       
            Thread.sleep(1000);
	        try {

	            // Parse the Total Due value to a numeric type
	            double totalDueValue = Double.parseDouble(day1);

	            if (totalDueValue <= 0 || day1 == null) {
	                // Fail the test if Total Due value is 0 or less
	                Assert.fail("No Data Found for Day Wise In SMR due Date wise  : " + day1);
	            } else {
	                // Print the Total Due value
	                System.out.println("Data_Assigned of Day_Wise In SMR due Date wise ::: " + day1);
	            }

	        } catch (Exception e) {
	            // Fail the test if an exception is thrown
	            Assert.fail("No Data Found for Day_Wise  In SMR due Date wise  " + e.getMessage());
	        }
	    }
	    
	  //...............................................................................................................

	    @Test(priority = 11)
	    public void Service_Type_Wise() throws InterruptedException {
	        Thread.sleep(1000);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        WebElement Service_Type_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Service Type Wise \"]")));
	        Service_Type_Wise.click();

	        // Click on the generate report button
	        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
	        clickOnGenerate.click();

  			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));  			
  		  //Elements of Zone and Region Wise
            WebElement Data_Assigned = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[2]"));	
            WebElement Reported_At_Own = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[3]"));
            WebElement ReportedAtSame_Parent_Other_Outlet = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[4]"));
            WebElement Reported_Other = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[5]"));
            WebElement Appointment_Booked = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[6]"));
            WebElement CallMeLater = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[7]"));
            WebElement LowMileage = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[8]"));
            WebElement VehicleSoldTo_New_Owner = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[9]"));
            WebElement RefuseForService = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[10]"));
            WebElement WrongNo = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[11]"));
            WebElement AppointmentCancelled = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[12]"));
            WebElement CallNotConnected = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[13]"));
            WebElement Fresh = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[14]"));
            WebElement PendingFresh = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[15]"));
            Thread.sleep(1000);
            //GET THE VALUES

            s1 = Data_Assigned.getText();
            s2 = Reported_At_Own.getText();
            s3 = ReportedAtSame_Parent_Other_Outlet.getText();
            s4 = Reported_Other.getText();
            s5 = Appointment_Booked.getText();
            s6 = CallMeLater.getText();
            s7 = LowMileage.getText();
            s8 = VehicleSoldTo_New_Owner.getText();
            s9 = RefuseForService.getText();
            s10 = WrongNo.getText();
            s11 = AppointmentCancelled.getText();
            s12 = CallNotConnected.getText();
            s13 = Fresh.getText();
             s14 = PendingFresh.getText(); 
	        Thread.sleep(1000);
	        try {
	            // Find the attribute value of Total Due
	            // Parse the Total Due value to a numeric type
	            double totalDueValue = Double.parseDouble(s1);

	            if (totalDueValue <= 0 || s1 == null) {
	                // Fail the test if Total Due value is 0 or less
	                Assert.fail("No Data Found for Service Type Wise   In SMR due Date wise : " + s1);
	            } else {
	                // Print the Total Due value
	                System.out.println("Data_Assigned of Service Type  Wise In SMR due Date wise ::: " + s1);
	            }

	        } catch (Exception e) {
	            // Fail the test if an exception is thrown
	            Assert.fail("No Data Found for Service Type Wise In SMR due Date wise  " + e.getMessage());
	        }
	    }
	    //...............................................................................................................

	    @Test(priority = 12)
	    public void SMRE_Wise() throws InterruptedException {
	        Thread.sleep(1000);
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        WebElement SMRE_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Smre Wise \"]")));
	        SMRE_Wise.click();

	        // Click on the generate report button
	        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
	        clickOnGenerate.click();

  			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));  			
  		  //Elements of Zone and Region Wise
            WebElement Data_Assigned = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[3]"));	
            WebElement Reported_At_Own = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[4]"));
            WebElement ReportedAtSame_Parent_Other_Outlet = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[5]"));
            WebElement Reported_Other = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[6]"));
            WebElement Appointment_Booked = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[7]"));
            WebElement CallMeLater = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[8]"));
            WebElement LowMileage = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[9]"));
            WebElement VehicleSoldTo_New_Owner = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[10]"));
            WebElement RefuseForService = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[11]"));
            WebElement WrongNo = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[12]"));
            WebElement AppointmentCancelled = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[13]"));
            WebElement CallNotConnected = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[14]"));
            WebElement Fresh = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[15]"));
            WebElement PendingFresh = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[5]/td[16]"));
            Thread.sleep(1000);
            //GET THE VALUES

            SM1 = Data_Assigned.getText();
            SM2 = Reported_At_Own.getText();
            SM3 = ReportedAtSame_Parent_Other_Outlet.getText();
            SM4 = Reported_Other.getText();
            SM5 = Appointment_Booked.getText();
            SM6 = CallMeLater.getText();
            SM7 = LowMileage.getText();
            SM8 = VehicleSoldTo_New_Owner.getText();
            SM9 = RefuseForService.getText();
            SM10 = WrongNo.getText();
            SM11 = AppointmentCancelled.getText();
            SM12 = CallNotConnected.getText();
            SM13 = Fresh.getText();
            SM14 = PendingFresh.getText(); 
	        Thread.sleep(1000);
	        try {
	            // Find the attribute value of Total Due
	            // Parse the Total Due value to a numeric type
	            double totalDueValue = Double.parseDouble(SM1);

	            if (totalDueValue <= 0 || SM1 == null) {
	                // Fail the test if Total Due value is 0 or less
	                Assert.fail("No Data Found for SMRE_Wise   In SMR due Date wise : " + SM1);
	            } else {
	                // Print the Total Due value
	                System.out.println("Data_Assigned of SMRE_Wise  Wise In SMR due Date wise ::: " + SM1);
	            }

	        } catch (Exception e) {
	            // Fail the test if an exception is thrown
	            Assert.fail("No Data Found for SMRE_Wise In SMR due Date wise  " + e.getMessage());
	        }
	    }
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	   
	    
	    @Test(priority = 14)
	    public void Comparison_0f_all_Data() throws InterruptedException {
	    	
	    	String[] dealerParentWise = {d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13, d14};
	    	String[] workshopWise = {w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11, w12, w13, w14};
	    	String[] dayWise = {day1, day2, day3, day4, day5, day6, day7, day8, day9, day10, day11, day12, day13, day14};
	    	String[] Service_TypeWise = {s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14};
	    	String[] SMRE_Wise = {SM1, SM2, SM3, SM4, SM5, SM6, SM7, SM8, SM9, SM10, SM11, SM12, SM13, SM14};

	    	String[] comparisonLabels = {
	    	    "Data Assigned", "Reported_At_Own", "ReportedAtSame_Parent_Other_Outlet", "Reported_Other", 
	    	    "Appointment_Booked", "CallMeLater", "LowMileage", "VehicleSoldTo_New_Owner", 
	    	    "RefuseForService", "WrongNo", "AppointmentCancelled", "CallNotConnected", "Fresh", "PendingFresh"
	    	};

	    	for (int i = 0; i < dealerParentWise.length; i++) {
	    	    Assert.assertEquals(dealerParentWise[i], workshopWise[i], "Compare " + comparisonLabels[i] + "_of_DealerParentWise_With_Workshop_Wise");
	    	    Assert.assertEquals(dealerParentWise[i], dayWise[i], "Compare " + comparisonLabels[i] + "_of_DealerParentWise_With_Day_Wise");
	    	    Assert.assertEquals(dealerParentWise[i], Service_TypeWise[i], "Compare " + comparisonLabels[i] + "_of_DealerParentWise_With_Service_TypeWise");
	    	    Assert.assertEquals(dealerParentWise[i], SMRE_Wise[i], "Compare " + comparisonLabels[i] + "_of_DealerParentWise_With_SMRE_Wise");

	    	}
	    	 Thread.sleep(4000);
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
	        select.click();
	        Thread.sleep(1000);

	        // Select start date (1st of the current month)
	        LocalDate today = LocalDate.now();
	        LocalDate firstDayOfMonth = today.withDayOfMonth(1);
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

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
	

