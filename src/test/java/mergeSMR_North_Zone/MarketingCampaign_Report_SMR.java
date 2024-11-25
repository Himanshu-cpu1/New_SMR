package mergeSMR_North_Zone;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class MarketingCampaign_Report_SMR {

    public static WebDriver driver;
    public WebDriverWait wait;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    String z1;
    String z2;
    String z3;
    String z4;
    String z5;
    String z6;
    String z7;
    String z8;
    String z9;
    String z10;
    String z11;
    String z12;
    String z13;
    String z14;
    String z15;
    String z16;
    String z17;
    String z18;
    String z19;
    String d1;
    String d2;
    String d3;
    String d4;
    String d5;
    String d6;
    String d7;
    String d8;
    String d9;
    String d10;
    String d11;
    String d12;
    String d13;
    String d14;
    String d15;
    String d16;
    String d17;
    String d18;
    String d19;
    String w1;
    String w2;
    String w3;
    String w4;
    String w5;
    String w6;
    String w7;
    String w8;
    String w9;
    String w10;
    String w11;
    String w12;
    String w13;
    String w14;
    String w15;
    String w16;
    String w17;
    String w18;
    String w19;
    String day1;
    String day2;
    String day3;
    String day4;
    String day5;
    String day6;
    String day7;
    String day8;
    String day9;
    String day10;
    String day11;
    String day12;
    String day13;
    String day14;
    String day15;
    String day16;
    String day17;
    String day18;
    String day19;

    //..................................................................................................
    @SuppressWarnings("static-access")
    @BeforeClass
    public void SMR() throws InterruptedException {
    	 Thread.sleep(5000);
        this.driver = AutoDialer_SMR_Report.driver;
        Thread.sleep(5000);
    }

    //..................................................................................................
    @Test(priority = 5)
    public void Click_On_Report() throws InterruptedException {
    	
    	 Thread.sleep(7000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement report = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Reports \"]")));
        report.click();
        Thread.sleep(7000);

    }
//.............................................................................................
    @Test(priority = 6)
	public void Click_On_MARKETING_CAMPAIGN_REPORT() throws InterruptedException {
	    // Wait for the side scrollable element (e.g., div or section)
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        
	    // Scroll within the scrollable section until the "Marketing Campaign" element is visible
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    
	    // Wait for the "Marketing Campaign" element to be present within the scrollable section
	    WebElement MarketingCamp = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Marketing Campaign ']")));
	    
	    js.executeScript("arguments[0].scrollIntoView(true);", MarketingCamp);
        Thread.sleep(1000); // Allow time for the scroll to complete
        MarketingCamp.click();
        Thread.sleep(4000);
    }



    //........................................................................................................................
    @Test(priority = 7)
    public void Zone_And_Region_Wise_Tab() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on dropdown Marketing Campaign
        WebElement Camp = driver.findElement(By.xpath("(//*[@role=\"combobox\"])"));
        Camp.click();

        Thread.sleep(3000);

        // select Marketing Campaign
        WebElement Market = driver.findElement(By.xpath("//*[text()=\"All\"]"));
        Market.click();
        Thread.sleep(3000);

        // Click on the calendar to open date picker
        WebElement select = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[alt=\"calendar\"]")));
        Actions actions1 = new Actions(driver);
        actions1.doubleClick(select).perform();

        Thread.sleep(4000);

        // Select start date (1st of the current month)
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        WebElement selectStart = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.cssSelector("[aria-label=\"" + firstDayOfMonth.format(formatter) + "\"]")));
        selectStart.click();
        Thread.sleep(2000);

        // Select today's date
        WebElement selectToday = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector("[aria-label=\"" + today.format(formatter) + "\"]")));
        selectToday.click();
        Thread.sleep(2000);

        // Click on the generate report button
        WebElement clickOnGenerate = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

        Thread.sleep(30000);

        // Elements of Zone and Region Wise
        WebElement TotalCampaignLeads = driver
                .findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[2]"));
        WebElement LeadsAttempted = driver
                .findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[3]"));
        WebElement FollowUp = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[4]"));
        WebElement Connected = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[5]"));
        WebElement AppointmentBooked = driver
                .findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[6]"));
        WebElement PercentAppointmentBooked = driver
                .findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[7]"));
        WebElement Reported = driver.findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[8]"));
        WebElement PercentReported = driver
                .findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[9]"));
        WebElement ReportedForFreeService = driver
                .findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[10]"));
        WebElement PercentReportedForFreeService = driver
                .findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[11]"));
        WebElement ReportedForPaidService = driver
                .findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[12]"));
        WebElement PercentReportedForPaidService = driver
                .findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[13]"));
        WebElement FreeServicePaidServiceReported = driver
                .findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[14]"));
        WebElement PercentFreeServicePaidServiceReported = driver
                .findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[15]"));
        WebElement NotAttempted = driver
                .findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[16]"));
        WebElement NotConnected = driver
                .findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[17]"));
        WebElement LabourRevenue = driver
                .findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[18]"));
        WebElement PartsRevenue = driver
                .findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[19]"));
        WebElement LabourPartsRevenue = driver
                .findElement(By.xpath("//tr[td[contains(normalize-space(), 'All INDIA')]]/td[20]"));

        Thread.sleep(4000);
        // GET THE VALUES

        z1 = TotalCampaignLeads.getText();
        z2 = LeadsAttempted.getText();
        z3 = FollowUp.getText();
        z4 = Connected.getText();
        z5 = AppointmentBooked.getText();
        z6 = PercentAppointmentBooked.getText();
        z7 = Reported.getText();
        z8 = PercentReported.getText();
        z9 = ReportedForFreeService.getText();
        z10 = PercentReportedForFreeService.getText();
        z11 = ReportedForPaidService.getText();
        z12 = PercentReportedForPaidService.getText();
        z13 = FreeServicePaidServiceReported.getText();
        z14 = PercentFreeServicePaidServiceReported.getText();
        z15 = NotAttempted.getText();
        z16 = NotConnected.getText();
        z17 = LabourRevenue.getText();
        z18 = PartsRevenue.getText();
        z19 = LabourPartsRevenue.getText();
        Thread.sleep(5000);

        try {
            // Find the attribute value of Total Campaign Leads

            // Parse the Total Campaign Leads value to a numeric type
            double TotalCampaignLead = Double.parseDouble(z1);

            if (TotalCampaignLead <= 0 || z1 == null) {
                // Fail the test if Total Campaign Leads column Value is 0 or less
                Assert.fail("No Data Found for Zone And Region Wise Marketing campagin report: " + z1);
            } else {
                // Print the Total Campaign Leads value
                System.out.println(
                        "'Total Campaign Leads' column Value of Zone And Region Wise Tab Marketing campagin report::: "
                                + z1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Zone And Region Wise Tab Marketing campagin report " + e.getMessage());
        }
    }

    //......................................................................................................................
    @Test(priority = 8)
    public void Dealer_Parent_Group_Wise_Tab() throws InterruptedException {
        Thread.sleep(7000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement Dealer_Parent_Group_Wise = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Dealer Parent Group Wise \"]")));
        Dealer_Parent_Group_Wise.click();
        Thread.sleep(3000);

        // Click on the generate report button
        WebElement clickOnGenerate = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

        Thread.sleep(30000);

        // set item per page as 100

        WebElement ItemPerPage = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[3]"));
        Actions actions1 = new Actions(driver);
        actions1.click(ItemPerPage).perform();


        WebElement Items = driver.findElement(By.xpath("(//*[@role=\"option\"])[4]"));
        Items.click();
        Thread.sleep(3000);

        boolean lastPageReached = false;

        while (!lastPageReached) {
            // Check if the next page button is disabled
            WebElement nextPageButton = driver.findElement(By.xpath("(//*[@type=\"button\"])[6]"));

            if (!nextPageButton.isEnabled()) {
                lastPageReached = true;
            } else {
                // Click on the next page button
                nextPageButton = driver.findElement(By.xpath("(//*[@type=\"button\"])[6]"));
                nextPageButton.click();
                Thread.sleep(3000);
            }
        }
        // Try to locate the Total_Lead_Recived element
        WebElement TotalCampaignLeads;
        try {
            TotalCampaignLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));

            // Check if Total_Lead_Recived element is displayed
            if (!TotalCampaignLeads.isDisplayed()) {
                System.out.println("No Data Found in Dealer_Parent_Group_Wise_Tab: TotalCampaignLeads element is not visible on the page In MarketingCampagin_Report.");
                Assert.fail("No Data Found in Dealer_Parent_Group_Wise_Tab: TotalCampaignLeads element is not visible on the page In MarketingCampagin_Report.");
                return; // Exit the test if the element is not visible
            }
        } catch (NoSuchElementException e) {
            System.out.println("No Data Found in Dealer_Parent_Group_Wise_Tab: TotalCampaignLeads element could not be found In  MarketingCampagin_Report: " + e.getMessage());
            Assert.fail("No Data Found in Dealer_Parent_Group_Wise_Tab: TotalCampaignLeads element could not be found  In MarketingCampagin_Report: " + e.getMessage());
            return; // Exit the test if the element is not found
        }

        // Check if Total_Lead_Recived is enabled
        if (!TotalCampaignLeads.isEnabled()) {
            System.out.println("TotalCampaignLeads element is not enabled In MarketingCampagin_Report");
            Assert.fail("TotalCampaignLeads element is not enabled In MarketingCampagin_Report");
        }

        // Retrieve the text and check if it's null or empty
        d1 = TotalCampaignLeads.getText();
        if (d1 == null || d1.isEmpty()) {
            System.out.println("No Data Found for Dealer_Parent_Group_Wise_Tab: Total_Lead_Recived value is null or empty In MarketingCampagin_Report");
            Assert.fail("No Data Found for Dealer_Parent_Group_Wise_Tab: Total_Lead_Recived value is null or empty In MarketingCampagin_Report");
            return; // Exit the test if the value is null or empty
        }

        // Elements of Dealer Parent Wise
        WebElement LeadsAttempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
        WebElement FollowUp = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
        WebElement Connected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
        WebElement AppointmentBooked = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
        WebElement PercentAppointmentBooked = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
        WebElement Reported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
        WebElement PercentReported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
        WebElement ReportedForFreeService = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
        WebElement PercentReportedForFreeService = driver
                .findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
        WebElement ReportedForPaidService = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[12]"));
        WebElement PercentReportedForPaidService = driver
                .findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[13]"));
        WebElement FreeServicePaidServiceReported = driver
                .findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[14]"));
        WebElement PercentFreeServicePaidServiceReported = driver
                .findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[15]"));
        WebElement NotAttempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[16]"));
        WebElement NotConnected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[17]"));
        WebElement LabourRevenue = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[18]"));
        WebElement PartsRevenue = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[19]"));
        WebElement LabourPartsRevenue = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[20]"));

        Thread.sleep(4000);
        // GET THE VALUES

        d1 = TotalCampaignLeads.getText();
        System.out.println("TotalCampaignLeads of Dealer parent group wise  In  Marketing campaagin report:   :" + d1);
        d2 = LeadsAttempted.getText();
        d3 = FollowUp.getText();
        d4 = Connected.getText();
        d5 = AppointmentBooked.getText();
        d6 = PercentAppointmentBooked.getText();
        d7 = Reported.getText();
        d8 = PercentReported.getText();
        d9 = ReportedForFreeService.getText();
        d10 = PercentReportedForFreeService.getText();
        d11 = ReportedForPaidService.getText();
        d12 = PercentReportedForPaidService.getText();
        d13 = FreeServicePaidServiceReported.getText();
        d14 = PercentFreeServicePaidServiceReported.getText();
        d15 = NotAttempted.getText();
        d16 = NotConnected.getText();
        d17 = LabourRevenue.getText();
        d18 = PartsRevenue.getText();
        d19 = LabourPartsRevenue.getText();
        Thread.sleep(5000);


        try {
            // Parse the Total Due value to a numeric type
            Integer totalDueValue = Integer.parseInt(d1);

            if (totalDueValue == 0) {
                // Fail the test if Total Due value is 0 or less
                System.out.println("No Data Found for Dealer_Parent_Group_Wise_Tab: Total_Lead_Recived value is null or empty In MarketingCampagin_Report" + d1);
                Assert.fail("No Data Found for Dealer_Parent_Group_Wise_Tab: Total_Lead_Recived value is null or empty In MarketingCampagin_Report" + d1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            System.out.println("No Data Found for Dealer_Parent_Group_Wise_Tab: Total_Lead_Recived value is null or empty In MarketingCampagin_Report" + e.getMessage());
            Assert.fail("No Data Found for Dealer_Parent_Group_Wise_Tab: Total_Lead_Recived value is null or empty In MarketingCampagin_Report" + e.getMessage());
        }
    }

    //.............................................................................................................................
    @Test(priority = 9)
    public void WorkShop_Wise_Tab() throws InterruptedException {
        Thread.sleep(7000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement WorkShop_Wise = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Workshop Wise \"]")));
        Actions actions1 = new Actions(driver);
        actions1.click(WorkShop_Wise).perform();

        Thread.sleep(3000);

        // Click on the generate report button
        WebElement clickOnGenerate = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

        Thread.sleep(30000);

        // set item per page as 100

        WebElement ItemPerPage = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[4]"));
        Actions actions2 = new Actions(driver);
        actions2.click(ItemPerPage).perform();


        WebElement Items = driver.findElement(By.xpath("(//*[@role=\"option\"])[4]"));
        Items.click();
        Thread.sleep(3000);

        boolean lastPageReached = false;

        while (!lastPageReached) {
            // Check if the next page button is disabled
            WebElement nextPageButton = driver.findElement(By.xpath("(//*[@type=\"button\"])[8]"));

            if (!nextPageButton.isEnabled()) {
                lastPageReached = true;
            } else {
                // Click on the next page button
                nextPageButton = driver.findElement(By.xpath("(//*[@type=\"button\"])[8]"));
                nextPageButton.click();
                Thread.sleep(3000);
            }
        }

        // Elements of Workshop Wise
        WebElement TotalCampaignLeads = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[3]"));
        WebElement LeadsAttempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[4]"));
        WebElement FollowUp = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[5]"));
        WebElement Connected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[6]"));
        WebElement AppointmentBooked = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[7]"));
        WebElement PercentAppointmentBooked = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[8]"));
        WebElement Reported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[9]"));
        WebElement PercentReported = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[10]"));
        WebElement ReportedForFreeService = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[11]"));
        WebElement PercentReportedForFreeService = driver
                .findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[12]"));
        WebElement ReportedForPaidService = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[13]"));
        WebElement PercentReportedForPaidService = driver
                .findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[14]"));
        WebElement FreeServicePaidServiceReported = driver
                .findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[15]"));
        WebElement PercentFreeServicePaidServiceReported = driver
                .findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[16]"));
        WebElement NotAttempted = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[17]"));
        WebElement NotConnected = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[18]"));
        WebElement LabourRevenue = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[19]"));
        WebElement PartsRevenue = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[20]"));
        WebElement LabourPartsRevenue = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[21]"));

        Thread.sleep(4000);
        // GET THE VALUES

        w1 = TotalCampaignLeads.getText();
        w2 = LeadsAttempted.getText();
        w3 = FollowUp.getText();
        w4 = Connected.getText();
        w5 = AppointmentBooked.getText();
        w6 = PercentAppointmentBooked.getText();
        w7 = Reported.getText();
        w8 = PercentReported.getText();
        w9 = ReportedForFreeService.getText();
        w10 = PercentReportedForFreeService.getText();
        w11 = ReportedForPaidService.getText();
        w12 = PercentReportedForPaidService.getText();
        w13 = FreeServicePaidServiceReported.getText();
        w14 = PercentFreeServicePaidServiceReported.getText();
        w15 = NotAttempted.getText();
        w16 = NotConnected.getText();
        w17 = LabourRevenue.getText();
        w18 = PartsRevenue.getText();
        w19 = LabourPartsRevenue.getText();

        Thread.sleep(5000);

        try {
            // Find the attribute value of Total Campaign Leads

            // Parse the Total Campaign Leads value to a numeric type
            double TotalCampaignLead = Double.parseDouble(w1);

            if (TotalCampaignLead <= 0 || w1 == null) {
                // Fail the test if Total Campaign Leads value is 0 or less
                Assert.fail("No Data Found for WorkShop_Wise Marketing campagin report: " + w1);
            } else {
                // Print the Total Campaign Leads value
                System.out.println(
                        "'Total Campaign Leads' column value of WorkShop Wise Tab Marketing campagin report::: " + w1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for WorkShop Wise Tab Marketing campagin report " + e.getMessage());
        }
    }

    //..........................................................................................................
    @Test(priority = 10)
    public void Day_Wise_Tab() throws InterruptedException {
        Thread.sleep(7000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement Day_Wise = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Day Wise \"]")));
        Day_Wise.click();
        Thread.sleep(3000);

        // Click on the generate report button
        WebElement clickOnGenerate = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

        Thread.sleep(30000);

        // set item per page as 100

        WebElement ItemPerPage = driver.findElement(By.xpath("(//*[@role=\"combobox\"])[5]"));
        Actions actions1 = new Actions(driver);
        actions1.click(ItemPerPage).perform();

        Thread.sleep(2000);

        WebElement Items = driver.findElement(By.xpath("(//*[@role=\"option\"])[4]"));
        Items.click();
        Thread.sleep(3000);

        boolean lastPageReached = false;

        while (!lastPageReached) {
            // Check if the next page button is disabled
            WebElement nextPageButton = driver.findElement(By.xpath("(//*[@type=\"button\"])[10]"));

            if (!nextPageButton.isEnabled()) {
                lastPageReached = true;
            } else {
                // Click on the next page button
                nextPageButton = driver.findElement(By.xpath("(//*[@type=\"button\"])[10]"));
                nextPageButton.click();
                Thread.sleep(3000);
            }
        }

        // Elements of Day Wise
        WebElement TotalCampaignLeads = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[2]"));
        WebElement LeadsAttempted = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[3]"));
        WebElement FollowUp = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[4]"));
        WebElement Connected = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[5]"));
        WebElement AppointmentBooked = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[6]"));
        WebElement PercentAppointmentBooked = driver
                .findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[7]"));
        WebElement Reported = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[8]"));
        WebElement PercentReported = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[9]"));
        WebElement ReportedForFreeService = driver
                .findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[10]"));
        WebElement PercentReportedForFreeService = driver
                .findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[11]"));
        WebElement ReportedForPaidService = driver
                .findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[12]"));
        WebElement PercentReportedForPaidService = driver
                .findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[13]"));
        WebElement FreeServicePaidServiceReported = driver
                .findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[14]"));
        WebElement PercentFreeServicePaidServiceReported = driver
                .findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[15]"));
        WebElement NotAttempted = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[16]"));
        WebElement NotConnected = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[17]"));
        WebElement LabourRevenue = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[18]"));
        WebElement PartsRevenue = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[19]"));
        WebElement LabourPartsRevenue = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[20]"));

        Thread.sleep(4000);
        // GET THE VALUES

        day1 = TotalCampaignLeads.getText();


        day2 = LeadsAttempted.getText();
        day3 = FollowUp.getText();
        day4 = Connected.getText();
        day5 = AppointmentBooked.getText();
        day6 = PercentAppointmentBooked.getText();
        day7 = Reported.getText();
        day8 = PercentReported.getText();
        day9 = ReportedForFreeService.getText();
        day10 = PercentReportedForFreeService.getText();
        day11 = ReportedForPaidService.getText();
        day12 = PercentReportedForPaidService.getText();
        day13 = FreeServicePaidServiceReported.getText();
        day14 = PercentFreeServicePaidServiceReported.getText();
        day15 = NotAttempted.getText();
        day16 = NotConnected.getText();
        day17 = LabourRevenue.getText();
        day18 = PartsRevenue.getText();
        day19 = LabourPartsRevenue.getText();

        Thread.sleep(5000);

        try {
            // Find the attribute value of Total Campaign Leads

            // Parse the Total Campaign Leads value to a numeric type
            double TotalCampaignLead = Double.parseDouble(day1);

            if (TotalCampaignLead <= 0 || day1 == null) {
                // Fail the test if Total Campaign Leads value is 0 or less
                Assert.fail("No Data Found for Day Wise Tab In-Marketing campagin report: " + day1);
            } else {
                // Print the Total Campaign Leads value
                System.out.println(
                        "'Total Campaign Leads' column value of Day Wise Tab In-Marketing campagin report ::: " + day1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Day Wise Tab  " + e.getMessage());
        }
    }

    //..........................................................................................................
    @Test(priority = 12)
    public void Compare_TotalCampaignLeads_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d1, z1);
    }

    //...................................................................................................
    @Test(priority = 13)
    public void Compare_LeadsAttempted_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d2, z2);
    }

    //...................................................................................................
    @Test(priority = 14)
    public void Compare_FollowUp_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d3, z3);
    }

    //...................................................................................................
    @Test(priority = 15)
    public void Compare_Connected_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d4, z4);
    }

    //...................................................................................................
    @Test(priority = 16)
    public void Compare_AppointmentBooked_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d5, z5);
    }

    //...................................................................................................
    @Test(priority = 17)
    public void Compare_PercentAppointmentBooked_Column_ZoneRegionWise_With_DealerParentWise()
            throws InterruptedException {
        String normalizedZ10 = z6.trim().replace(" ", "");
        String normalizedW10 = d6.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);

    }

    //...................................................................................................
    @Test(priority = 18)
    public void Compare_Reported_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d7, z7);
    }

    //...................................................................................................
    @Test(priority = 19)
    public void Compare_PercentReported_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {


        String normalizedZ10 = z8.trim().replace(" ", "");
        String normalizedW10 = d8.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 20)
    public void Compare_ReportedForFreeService_Column_ZoneRegionWise_With_DealerParentWise()
            throws InterruptedException {

        Assert.assertEquals(d9, z9);
    }

    //...................................................................................................
    @Test(priority = 21)
    public void Compare_PercentReportedForFreeService_Column_ZoneRegionWise_With_DealerParentWise()
            throws InterruptedException {


        String normalizedZ10 = z10.trim().replace(" ", "");
        String normalizedW10 = d10.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 22)
    public void Compare_ReportedForPaidService_Column_ZoneRegionWise_With_DealerParentWise()
            throws InterruptedException {


        Assert.assertEquals(d11, z11);
    }

    //...................................................................................................
    @Test(priority = 23)
    public void Compare_PercentReportedForPaidService_Column_ZoneRegionWise_With_DealerParentWise()
            throws InterruptedException {

        String normalizedZ10 = z12.trim().replace(" ", "");
        String normalizedW10 = d12.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 24)
    public void Compare_FreeServicePaidServiceReported_Column_ZoneRegionWise_With_DealerParentWise()
            throws InterruptedException {

        Assert.assertEquals(d13, z13);
    }

    //...................................................................................................
    @Test(priority = 25)
    public void Compare_PercentFreeServicePaidServiceReported_Column_ZoneRegionWise_With_DealerParentWise()
            throws InterruptedException {

        String normalizedZ10 = z14.trim().replace(" ", "");
        String normalizedW10 = d14.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 21)
    public void Compare_NotAttempted_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d15, z15);
    }

    //...................................................................................................
    @Test(priority = 22)
    public void Compare_NotConnected_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d16, z16);
    }

    //...................................................................................................
    @Test(priority = 23)
    public void Compare_LabourRevenue_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d17, z17);
    }

    //...................................................................................................
    @Test(priority = 24)
    public void Compare_PartsRevenue_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d18, z18);
    }

    //...................................................................................................
    @Test(priority = 25)
    public void Compare_LabourPartsRevenue_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d19, z19);
    }

    //...................................................................................................
    @Test(priority = 26)
    public void Compare_TotalCampaignLeads_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w1, z1);
    }

    //...................................................................................................
    @Test(priority = 27)
    public void Compare_LeadsAttempted_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w2, z2);
    }

    //...................................................................................................
    @Test(priority = 28)
    public void Compare_FollowUp_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w3, z3);
    }

    //...................................................................................................
    @Test(priority = 29)
    public void Compare_Connected_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w4, z4);
    }

    //...................................................................................................
    @Test(priority = 30)
    public void Compare_AppointmentBooked_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w5, z5);
    }

    //...................................................................................................
    @Test(priority = 31)
    public void Compare_PercentAppointmentBooked_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        String normalizedZ10 = w6.trim().replace(" ", "");
        String normalizedW10 = z6.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 32)
    public void Compare_Reported_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w7, z7);
    }

    //...................................................................................................
    @Test(priority = 33)
    public void Compare_PercentReported_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        String normalizedZ10 = w8.trim().replace(" ", "");
        String normalizedW10 = z8.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 34)
    public void Compare_ReportedForFreeService_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w9, z9);
    }

    //...................................................................................................
    @Test(priority = 35)
    public void Compare_PercentReportedForFreeService_Column_ZoneRegionWise_With_WorkshopWise()
            throws InterruptedException {


        String normalizedZ10 = w10.trim().replace(" ", "");
        String normalizedW10 = z10.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 36)
    public void Compare_ReportedForPaidService_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w11, z11);
    }

    //...................................................................................................
    @Test(priority = 37)
    public void Compare_PercentReportedForPaidService_Column_ZoneRegionWise_With_WorkshopWise()
            throws InterruptedException {


        String normalizedZ10 = w12.trim().replace(" ", "");
        String normalizedW10 = z12.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 38)
    public void Compare_FreeServicePaidServiceReported_Column_ZoneRegionWise_With_WorkshopWise()
            throws InterruptedException {


        Assert.assertEquals(w13, z13);
    }

    //...................................................................................................
    @Test(priority = 39)
    public void Compare_PercentFreeServicePaidServiceReported_Column_ZoneRegionWise_With_WorkshopWise()
            throws InterruptedException {


        String normalizedZ10 = w14.trim().replace(" ", "");
        String normalizedW10 = z14.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 35)
    public void Compare_NotAttempted_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w15, z15);
    }

    //...................................................................................................
    @Test(priority = 36)
    public void Compare_NotConnected_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w16, z16);
    }

    //...................................................................................................
    @Test(priority = 37)
    public void Compare_LabourRevenue_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w17, z17);
    }

    //...................................................................................................
    @Test(priority = 38)
    public void Compare_PartsRevenue_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w18, z18);
    }

    //...................................................................................................
    @Test(priority = 39)
    public void Compare_LabourPartsRevenue_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w19, z19);
    }

    //...................................................................................................
    @Test(priority = 40)
    public void Compare_TotalCampaignLeads_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day1, z1);
    }

    //...................................................................................................
    @Test(priority = 41)
    public void Compare_LeadsAttempted_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day2, z2);
    }

    //...................................................................................................
    @Test(priority = 42)
    public void Compare_FollowUp_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day3, z3);
    }

    //...................................................................................................
    @Test(priority = 43)
    public void Compare_Connected_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day4, z4);
    }

    //...................................................................................................
    @Test(priority = 44)
    public void Compare_AppointmentBooked_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day5, z5);
    }

    //...................................................................................................
    @Test(priority = 45)
    public void Compare_PercentAppointmentBooked_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        String normalizedZ10 = z6.trim().replace(" ", "");
        String normalizedW10 = day6.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 46)
    public void Compare_Reported_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day7, z7);
    }

    //...................................................................................................
    @Test(priority = 47)
    public void Compare_PercentReported_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        String normalizedZ10 = day8.trim().replace(" ", "");
        String normalizedW10 = z8.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 48)
    public void Compare_ReportedForFreeService_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day9, z9);
    }

    //...................................................................................................
    @Test(priority = 49)
    public void Compare_PercentReportedForFreeService_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {


        String normalizedZ10 = day10.trim().replace(" ", "");
        String normalizedW10 = z10.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 50)
    public void Compare_ReportedForPaidService_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day11, z11);
    }

    //...................................................................................................
    @Test(priority = 51)
    public void Compare_PercentReportedForPaidService_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {


        String normalizedZ10 = day12.trim().replace(" ", "");
        String normalizedW10 = z12.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 52)
    public void Compare_FreeServicePaidServiceReported_Column_ZoneRegionWise_With_DayWise()
            throws InterruptedException {

        Assert.assertEquals(day13, z13);
    }

    //...................................................................................................
    @Test(priority = 53)
    public void Compare_PercentFreeServicePaidServiceReported_Column_ZoneRegionWise_With_DayWise()
            throws InterruptedException {


        String normalizedZ10 = day14.trim().replace(" ", "");
        String normalizedW10 = z14.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 49)
    public void Compare_NotAttempted_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day15, z15);
    }

    //...................................................................................................
    @Test(priority = 50)
    public void Compare_NotConnected_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day16, z16);
    }

    //...................................................................................................
    @Test(priority = 51)
    public void Compare_LabourRevenue_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day17, z17);
    }

    //...................................................................................................
    @Test(priority = 52)
    public void Compare_PartsRevenue_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day18, z18);
    }

    //...................................................................................................
    @Test(priority = 53)
    public void Compare_LabourPartsRevenue_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day19, z19);
    }

    //...................................................................................................
    @Test(priority = 54)
    public void Compare_TotalCampaignLeads_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w1, d1);
    }

    //...................................................................................................
    @Test(priority = 55)
    public void Compare_LeadsAttempted_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w2, d2);
    }

    //...................................................................................................
    @Test(priority = 56)
    public void Compare_FollowUp_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w3, d3);
    }

    //...................................................................................................
    @Test(priority = 57)
    public void Compare_Connected_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w4, d4);
    }

    //...................................................................................................
    @Test(priority = 58)
    public void Compare_AppointmentBooked_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w5, d5);
    }

    //...................................................................................................
    @Test(priority = 59)
    public void Compare_PercentAppointmentBooked_Column_DealerParentWise_With_WorkshopWise()
            throws InterruptedException {

        String normalizedZ10 = w6.trim().replace(" ", "");
        String normalizedW10 = d6.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 60)
    public void Compare_Reported_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertEquals(w7, d7);
    }

    //...................................................................................................
    @Test(priority = 61)
    public void Compare_PercentReported_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {


        String normalizedZ10 = w8.trim().replace(" ", "");
        String normalizedW10 = d8.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 62)
    public void Compare_ReportedForFreeService_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w9, d9);
    }

    //...................................................................................................
    @Test(priority = 63)
    public void Compare_PercentReportedForFreeService_Column_DealerParentWise_With_WorkshopWise()
            throws InterruptedException {


        String normalizedZ10 = w10.trim().replace(" ", "");
        String normalizedW10 = d10.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 64)
    public void Compare_ReportedForPaidService_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w11, d11);
    }

    //...................................................................................................
    @Test(priority = 65)
    public void Compare_PercentReportedForPaidService_Column_DealerParentWise_With_WorkshopWise() {


        String normalizedZ10 = w12.trim().replace(" ", "");
        String normalizedW10 = d12.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 66)
    public void Compare_FreeServicePaidServiceReported_Column_DealerParentWise_With_WorkshopWise() {

        Assert.assertEquals(w13, d13);
    }

    //...................................................................................................
    @Test(priority = 67)
    public void Compare_PercentFreeServicePaidServiceReported_Column_DealerParentWise_With_WorkshopWise()
            throws InterruptedException {

        String normalizedZ10 = w14.trim().replace(" ", "");
        String normalizedW10 = d14.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 63)
    public void Compare_NotAttempted_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w15, d15);
    }

    //...................................................................................................
    @Test(priority = 64)
    public void Compare_NotConnected_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w16, d16);
    }

    //...................................................................................................
    @Test(priority = 65)
    public void Compare_LabourRevenue_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w17, d17);
    }

    //...................................................................................................
    @Test(priority = 66)
    public void Compare_PartsRevenue_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w18, d18);
    }

    //...................................................................................................
    @Test(priority = 67)
    public void Compare_LabourPartsRevenue_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w19, d19);
    }
//...................................................................................................	

    @Test(priority = 68)
    public void Compare_TotalCampaignLeads_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day1, d1);
    }

    //...................................................................................................
    @Test(priority = 69)
    public void Compare_LeadsAttempted_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day2, d2);
    }

    //...................................................................................................
    @Test(priority = 70)
    public void Compare_FollowUp_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day3, d3);
    }

    //...................................................................................................
    @Test(priority = 71)
    public void Compare_Connected_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day4, d4);
    }

    //...................................................................................................
    @Test(priority = 72)
    public void Compare_AppointmentBooked_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day5, d5);
    }

    //...................................................................................................
    @Test(priority = 73)
    public void Compare_PercentAppointmentBooked_Column_DealerParentWise_With_DayWise() throws InterruptedException {


        String normalizedZ10 = day6.trim().replace(" ", "");
        String normalizedW10 = d6.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 74)
    public void Compare_Reported_Column_DealerParentWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day7, d7);
    }

    //...................................................................................................
    @Test(priority = 75)
    public void Compare_PercentReported_Column_DealerParentWise_With_DayWise() throws InterruptedException {


        String normalizedZ10 = day6.trim().replace(" ", "");
        String normalizedW10 = d8.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 76)
    public void Compare_ReportedForFreeService_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day9, d9);
    }

    //...................................................................................................
    @Test(priority = 77)
    public void Compare_PercentReportedForFreeService_Column_DealerParentWise_With_DayWise() {

        String normalizedZ10 = d10.trim().replace(" ", "");
        String normalizedW10 = day10.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);

    }

    //...................................................................................................
    @Test(priority = 78)
    public void Compare_ReportedForPaidService_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day11, d11);
    }

    //...................................................................................................
    @Test(priority = 79)
    public void Compare_PercentReportedForPaidService_Column_DealerParentWise_With_DayWise()
            throws InterruptedException {


        String normalizedZ10 = day12.trim().replace(" ", "");
        String normalizedW10 = d12.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 80)
    public void Compare_FreeServicePaidServiceReported_Column_DealerParentWise_With_DayWise()
            throws InterruptedException {

        Assert.assertEquals(day13, d13);
    }

    //...................................................................................................
    @Test(priority = 81)
    public void Compare_PercentFreeServicePaidServiceReported_Column_DealerParentWise_With_DayWise()
            throws InterruptedException {

        String normalizedZ10 = d14.trim().replace(" ", "");
        String normalizedW10 = day14.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 77)
    public void Compare_NotAttempted_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day15, d15);
    }

    //...................................................................................................
    @Test(priority = 78)
    public void Compare_NotConnected_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day16, d16);
    }

    //...................................................................................................
    @Test(priority = 79)
    public void Compare_LabourRevenue_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day17, d17);
    }

    //...................................................................................................
    @Test(priority = 80)
    public void Compare_PartsRevenue_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day18, d18);
    }

    //...................................................................................................
    @Test(priority = 81)
    public void Compare_LabourPartsRevenue_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day19, d19);
    }

    //...................................................................................................
    @Test(priority = 82)

    public void Compare_TotalCampaignLeads_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day1, w1);
    }

    //...................................................................................................
    @Test(priority = 83)
    public void Compare_LeadsAttempted_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day2, w2);
    }

    //...................................................................................................
    @Test(priority = 84)
    public void Compare_FollowUp_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day3, w3);
    }

    //...................................................................................................
    @Test(priority = 85)
    public void Compare_Connected_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day4, w4);
    }

    //...................................................................................................
    @Test(priority = 86)
    public void Compare_AppointmentBooked_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day5, w5);
    }

    //...................................................................................................
    @Test(priority = 87)
    public void Compare_PercentAppointmentBooked_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        String normalizedZ10 = day6.trim().replace(" ", "");
        String normalizedW10 = w6.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 88)
    public void Compare_Reported_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day7, w7);
    }

    //...................................................................................................
    @Test(priority = 89)
    public void Compare_PercentReported_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        String normalizedZ10 = d8.trim().replace(" ", "");
        String normalizedW10 = w8.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 90)
    public void Compare_ReportedForFreeService_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day9, w9);
    }

    //...................................................................................................
    @Test(priority = 91)
    public void Compare_PercentReportedForFreeService_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        String normalizedZ10 = day10.trim().replace(" ", "");
        String normalizedW10 = w10.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 92)
    public void Compare_ReportedForPaidService_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day11, w11);
    }

    //...................................................................................................
    @Test(priority = 93)
    public void Compare_PercentReportedForPaidService_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        String normalizedZ10 = w12.trim().replace(" ", "");
        String normalizedW10 = day12.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 94)
    public void Compare_FreeServicePaidServiceReported_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day13, w13);
    }

    //...................................................................................................
    @Test(priority = 95)
    public void Compare_PercentFreeServicePaidServiceReported_Column_WorkshopWise_With_DayWise()
            throws InterruptedException {


        String normalizedZ10 = w14.trim().replace(" ", "");
        String normalizedW10 = day14.trim().replace(" ", "");

        Assert.assertEquals(normalizedZ10, normalizedW10);
    }

    //...................................................................................................
    @Test(priority = 91)
    public void Compare_NotAttempted_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day15, w15);
    }

    //...................................................................................................
    @Test(priority = 92)
    public void Compare_NotConnected_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day16, w16);
    }

    //...................................................................................................
    @Test(priority = 93)
    public void Compare_LabourRevenue_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day17, w17);
    }

    //...................................................................................................
    @Test(priority = 94)
    public void Compare_PartsRevenue_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day18, w18);
    }

    //...................................................................................................
    @Test(priority = 95)
    public void Compare_LabourPartsRevenue_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day19, w19);
        Thread.sleep(4000);
    }
//...................................................................................................	

    //.....................................................................................................

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();  // Close the browser and end the WebDriver session
        }
    }
}
