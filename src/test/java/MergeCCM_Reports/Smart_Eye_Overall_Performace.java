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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Smart_Eye_Overall_Performace {

	public static WebDriver driver;
    public WebDriverWait wait;
   
    String d1, d2, d3, d4, d5, d6, d7, d8, d9, d10, d11, d12, d13,d14,
           d15,d16,d17,d18,d19,d20,d21,d22,d23;
    String w1, w2, w3, w4, w5, w6, w7, w8, w9, w10, w11, 
           w12, w13, w14,w15,w16,w17,w18,w19,w20,w21,w22,w23;
    String day1, day2, day3, day4, day5, day6, day7, day8, day9, 
            day10, day11, day12, day13, day14,day15,day16,day17,day18,day19,day20,day21,day22,day23;
    String s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14,s15,
           s16,s17,s18,s19,s20,s21,s22,s23;
 //   String SM1, SM2, SM3, SM4, SM5, SM6, SM7, SM8, SM9, SM10, SM11, SM12, SM13, SM14,SM15,SM16,SM17,SM18,SM19,SM20,SM21,SM22,SM23;

    
    @SuppressWarnings("static-access")
    @BeforeClass
    public void SMR() throws InterruptedException {
        // Initialize the driver (assuming it's static in the SMR_due_Datewise class)
        this.driver = DueVsDone.driver;

     // Initialize WebDriverWait with a timeout of 10 seconds using Duration
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
 	public void Click_On_Smart_Eye_Overall_Performace() throws InterruptedException {
 		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement SmartEye = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Smart Eye Overall Performance \"]")));
        clickElementUsingJS(driver, SmartEye);
  		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

 		
 	}
 	
 	 //..................................Dealer Parent Group Wise Tab....................................................................................
    @Test(priority = 10)
    public void Dealer_Parent_Group_Wise_Tab() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();
         Thread.sleep(4000);       //Elements of Dealer Parent Group Wise
        WebElement TotalJCOpen_A = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));
        WebElement JCOpenUsingSmartEye_B = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
        WebElement VehicleConvertedinBodyShopOwnWorkshop_C = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
        WebElement VehicleConvertedinBodyShopRegionParent_D = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
        WebElement VehicleConvertedinBodyShop_E = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
        WebElement PercentJCOpenedUsingSmartEye = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
        WebElement PercentConverted_Vs_TotalJCOpen = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
        WebElement PercentConverted_Vs_OpenedUsingSmartEye = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
        WebElement RevenueEarned = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
        WebElement ConvertedAtOtherDealer = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));

        Thread.sleep(1000);
        //GET THE VALUES

        d1 = TotalJCOpen_A.getText();
        d2 = JCOpenUsingSmartEye_B.getText();
        d3 = VehicleConvertedinBodyShopOwnWorkshop_C.getText();
        d4 = VehicleConvertedinBodyShopRegionParent_D.getText();
        d5 = VehicleConvertedinBodyShop_E.getText();
        d6 = PercentJCOpenedUsingSmartEye.getText();
        d7 = PercentConverted_Vs_TotalJCOpen.getText();
        d8 = PercentConverted_Vs_OpenedUsingSmartEye.getText();
        d9 = RevenueEarned.getText();
        d10 = ConvertedAtOtherDealer.getText();

        Thread.sleep(1000);

        try {
            // Find the attribute value of Total JC Open

            // Parse the Total JC Open value to a numeric type
            double TotalJCOpen = Double.parseDouble(d1);

            if (TotalJCOpen <= 0) {
                // Fail the test if Total JC Open column Value is 0 or less
                Assert.fail("No Data Found for Dealer Parent Group Wise In-Smart_Eye_Overall_Performance : " + d1);
            } else {
                // Print the Total JC Open value
                System.out.println("'Total JC Open' column Value of Dealer Parent Group Wise Tab In-Smart_Eye_Overall_Performance::: " + d1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Dealer Parent Group Wise In-Smart_Eye_Overall_Performance  " + e.getMessage());
        }
    }
    //..................................Workshop Wise Tab....................................................................................
    @Test(priority = 9)
    public void Workshop_Wise_Tab() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement Workshop_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Workshop Wise \"]")));
        Workshop_Wise.click();
        Thread.sleep(3000);
        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();
  		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));


        //Elements of Workshop Wise
        WebElement TotalJCOpen_A = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[3]"));
        WebElement JCOpenUsingSmartEye_B = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[4]"));
        WebElement VehicleConvertedinBodyShopOwnWorkshop_C = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[5]"));
        WebElement VehicleConvertedinBodyShopRegionParent_D = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[6]"));
        WebElement VehicleConvertedinBodyShop_E = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[7]"));
        WebElement PercentJCOpenedUsingSmartEye = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[8]"));
        WebElement PercentConverted_Vs_TotalJCOpen = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[9]"));
        WebElement PercentConverted_Vs_OpenedUsingSmartEye = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[10]"));
        WebElement RevenueEarned = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[11]"));
        WebElement ConvertedAtOtherDealer = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[12]"));

        Thread.sleep(1000);
        //GET THE VALUES

        w1 = TotalJCOpen_A.getText();
        w2 = JCOpenUsingSmartEye_B.getText();
        w3 = VehicleConvertedinBodyShopOwnWorkshop_C.getText();
        w4 = VehicleConvertedinBodyShopRegionParent_D.getText();
        w5 = VehicleConvertedinBodyShop_E.getText();
        w6 = PercentJCOpenedUsingSmartEye.getText();
        w7 = PercentConverted_Vs_TotalJCOpen.getText();
        w8 = PercentConverted_Vs_OpenedUsingSmartEye.getText();
        w9 = RevenueEarned.getText();
        w10 = ConvertedAtOtherDealer.getText();

        Thread.sleep(1000);

        try {
            // Find the attribute value of Total JC Open

            // Parse the Total JC Open value to a numeric type
            double TotalJCOpen = Double.parseDouble(w1);

            if (TotalJCOpen <= 0) {
                // Fail the test if Total JC Open column Value is 0 or less
                Assert.fail("No Data Found for Workshop Wise In-Smart_Eye_Overall_Performance  : " + w1);
            } else {
                // Print the Total JC Open value
                System.out.println("'Total JC Open' column Value of Workshop Wise Tab In-Smart_Eye_Overall_Performance::: " + w1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Workshop Wise Tab In-Smart_Eye_Overall_Performance " + e.getMessage());
        }
    }

    //...................................Day Wise Tab...................................................................................
    @Test(priority = 10)
    public void Day_Wise_Tab() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement Day_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Day Wise \"]")));
        Day_Wise.click();
        Thread.sleep(3000);
        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();
  		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

        //Elements of Day Wise
        WebElement TotalJCOpen_A = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[2]"));
        WebElement JCOpenUsingSmartEye_B = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[3]"));
        WebElement VehicleConvertedinBodyShopOwnWorkshop_C = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[4]"));
        WebElement VehicleConvertedinBodyShopRegionParent_D = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[5]"));
        WebElement VehicleConvertedinBodyShop_E = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[6]"));
        WebElement PercentJCOpenedUsingSmartEye = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[7]"));
        WebElement PercentConverted_Vs_TotalJCOpen = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[8]"));
        WebElement PercentConverted_Vs_OpenedUsingSmartEye = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[9]"));
        WebElement RevenueEarned = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[10]"));
        WebElement ConvertedAtOtherDealer = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[11]"));

        Thread.sleep(1000);
        //GET THE VALUES

        day1 = TotalJCOpen_A.getText();
        day2 = JCOpenUsingSmartEye_B.getText();
        day3 = VehicleConvertedinBodyShopOwnWorkshop_C.getText();
        day4 = VehicleConvertedinBodyShopRegionParent_D.getText();
        day5 = VehicleConvertedinBodyShop_E.getText();
        day6 = PercentJCOpenedUsingSmartEye.getText();
        day7 = PercentConverted_Vs_TotalJCOpen.getText();
        day8 = PercentConverted_Vs_OpenedUsingSmartEye.getText();
        day9 = RevenueEarned.getText();
        day10 = ConvertedAtOtherDealer.getText();

        Thread.sleep(1000);

        try {
            // Find the attribute value of Total JC Open

            // Parse the Total JC Open value to a numeric type
            double TotalJCOpen = Double.parseDouble(day1);

            if (TotalJCOpen <= 0) {
                // Fail the test if Total JC Open column Value is 0 or less
                Assert.fail("No Data Found for Day Wise In-Smart_Eye_Overall_Performance: " + day1);
            } else {
                // Print the Total JC Open value
                System.out.println("'Total JC Open' column Value of Day Wise Tab In-Smart_Eye_Overall_Performance::: " + day1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Day Wise In-Smart_Eye_Overall_Performance  " + e.getMessage());
        }
    }

    //.................................Service Type Wise Tab.....................................................................................
    @Test(priority = 11)
    public void Service_Type_Wise_Tab() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement Service = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Service Type Wise \"]")));
        Service.click();
        Thread.sleep(3000);

        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();
  		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(), 'Loading')]")));

        //Elements of Service Type Wise
        WebElement TotalJCOpen_A = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[2]"));
        WebElement JCOpenUsingSmartEye_B = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[3]"));
        WebElement VehicleConvertedinBodyShopOwnWorkshop_C = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[4]"));
        WebElement VehicleConvertedinBodyShopRegionParent_D = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[5]"));
        WebElement VehicleConvertedinBodyShop_E = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[6]"));
        WebElement PercentJCOpenedUsingSmartEye = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[7]"));
        WebElement PercentConverted_Vs_TotalJCOpen = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[8]"));
        WebElement PercentConverted_Vs_OpenedUsingSmartEye = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[9]"));
        WebElement RevenueEarned = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[10]"));
        WebElement ConvertedAtOtherDealer = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[11]"));

        Thread.sleep(4000);
        //GET THE VALUES

        s1 = TotalJCOpen_A.getText();
        s2 = JCOpenUsingSmartEye_B.getText();
        s3 = VehicleConvertedinBodyShopOwnWorkshop_C.getText();
        s4 = VehicleConvertedinBodyShopRegionParent_D.getText();
        s5 = VehicleConvertedinBodyShop_E.getText();
        s6 = PercentJCOpenedUsingSmartEye.getText();
        s7 = PercentConverted_Vs_TotalJCOpen.getText();
        s8 = PercentConverted_Vs_OpenedUsingSmartEye.getText();
        s9 = RevenueEarned.getText();
        s10 = ConvertedAtOtherDealer.getText();

        Thread.sleep(5000);

        try {
            // Find the attribute value of Total JC Open

            // Parse the Total JC Open value to a numeric type
            double TotalJCOpen = Double.parseDouble(s1);

            if (TotalJCOpen <= 0) {
                // Fail the test if Total JC Open column Value is 0 or less
                Assert.fail("No Data Found for Service Type Wise In-Smart_Eye_Overall_Performance : " + s1);
            } else {
                // Print the Total JC Open value
                System.out.println("'Total JC Open' column Value of Service Type Wise Tab In-Smart_Eye_Overall_Performance::: " + s1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Service Type Wise Tab  " + e.getMessage());
        }
    }
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>	   
    
    @Test(priority = 15)
    public void Comparison_0f_all_Data() throws InterruptedException {
    	    	
    	String[] dealerParentWise = {d1, d2, d3, d4, d5, d6, d7, d8,d9,d10};
    	String[] workshopWise = {w1, w2, w3, w4, w5, w6, w7, w8,w9,w10};
    	String[] dayWise = {day1, day2, day3, day4, day5, day6, day7, day8,day9,day10 };                          
    	String[] Service_TypeWise = {s1, s2, s3, s4, s5, s6, s7, s8,s9,s10};
    	

    	String[] comparisonLabels = {
    	    "TotalJCOpen_A", "JCOpenUsingSmartEye_B", "VehicleConvertedinBodyShopOwnWorkshop_C", "VehicleConvertedinBodyShopRegionParent_D", 
    	    "VehicleConvertedinBodyShop_E", "PercentJCOpenedUsingSmartEye", "PercentConverted_Vs_TotalJCOpen", "PercentConverted_Vs_OpenedUsingSmartEye" 
    	   , "RevenueEarned", "ConvertedAtOtherDealer"};
    	

    	for (int i = 0; i < dealerParentWise.length; i++) {
    	    Assert.assertEquals(dealerParentWise[i], workshopWise[i], "Compare " + comparisonLabels[i] + "_of_DealerParentWise_With_Workshop_Wise");
    	    Assert.assertEquals(dealerParentWise[i], dayWise[i], "Compare " + comparisonLabels[i] + "_of_DealerParentWise_With_Day_Wise");
    	    Assert.assertEquals(dealerParentWise[i], Service_TypeWise[i], "Compare " + comparisonLabels[i] + "_of_DealerParentWise_With_Service_TypeWise");
    	  
    	}
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


