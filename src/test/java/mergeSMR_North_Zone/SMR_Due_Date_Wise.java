package mergeSMR_North_Zone;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SMR_Due_Date_Wise extends LOGIN {

    public static WebDriver driver;
    public WebDriverWait wait;

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

    String s1;
    String s2;
    String s3;
    String s4;
    String s5;
    String s6;
    String s7;
    String s8;
    String s9;
    String s10;
    String s11;
    String s12;
    String s13;
    String s14;

    //..................................................................................................
    @SuppressWarnings("static-access")
    @BeforeClass
    public void SMR() throws InterruptedException {
        this.driver = LOGIN.driver;
    }

    //................................................................................................
    //..................................................................................................
    @Test(priority = 5)
    public void Click_On_Report() throws InterruptedException {
       	    
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement report = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Reports \"]")));
        report.click();
        Thread.sleep(3000);

    }

    //..................................................................................................
    @Test(priority = 6)
    public void Click_On_The_SMR_Due_date_Wise() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement SMR = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"SMR Due Date Wise \"]")));
        SMR.click();
        Thread.sleep(3000);

    }

    //............................................................................................................
    @Test(priority = 7)
    public void Zone_Region_Wise() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Click on the calendar to open date picker
        WebElement Calender = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[alt=\"calendar\"]")));
        Calender.click();
        Thread.sleep(4000);

        // Select start date (1st of the current month)
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfMonth = today.withDayOfMonth(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        WebElement selectStart = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label=\"" + firstDayOfMonth.format(formatter) + "\"]")));
        selectStart.click();
        Thread.sleep(2000);

        // Select today's date
        WebElement selectToday = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[aria-label=\"" + today.format(formatter) + "\"]")));
        selectToday.click();
        Thread.sleep(2000);

        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

        Thread.sleep(30000);

        //Elements of Zone and Region Wise
        WebElement TotalDue = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[2]"));
        WebElement ReportedAtOWN = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[3]"));
        WebElement ReportedAtOther = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[4]"));
        WebElement AppointmentBooked = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[5]"));
        WebElement CallMeLater = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[6]"));
        WebElement LowMileage = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[7]"));
        WebElement VehicleSoldTo = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[8]"));
        WebElement RefuseForService = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[9]"));
        WebElement WrongNo = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[10]"));
        WebElement AppointmentCancelled = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[11]"));
        WebElement CallNotConnected = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[12]"));
        WebElement Fresh = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[13]"));
        WebElement PendingFresh = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[14]"));
        WebElement UnallocatedData = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[15]"));
        Thread.sleep(4000);
        //GET THE VALUES

        z1 = TotalDue.getText();
        z2 = ReportedAtOWN.getText();
        z3 = ReportedAtOther.getText();
        z4 = AppointmentBooked.getText();
        z5 = CallMeLater.getText();
        z6 = LowMileage.getText();
        z7 = VehicleSoldTo.getText();
        z8 = RefuseForService.getText();
        z9 = WrongNo.getText();
        z10 = AppointmentCancelled.getText();
        z11 = CallNotConnected.getText();
        z12 = Fresh.getText();
        z13 = PendingFresh.getText();
        z14 = UnallocatedData.getText();
        Thread.sleep(5000);

        try {

            // Parse the Total Due value to a numeric type
            double totalDueValue = Double.parseDouble(z1);

            if (totalDueValue <= 0) {

                // Fail the test if Total Due value is 0 or less
                Assert.fail("No Data Found for Zone And Region Wise In SMR due Date wise : " + z1);
            } else {
                // Print the Total Due value
                System.out.println("Total Due value of Zone And Region Wise  In SMR due Date wise ::: " + z1);
            }

            if (z1 == null) {
                Assert.fail("No Data Found for Zone And Region Wise In SMR due Date wise  " + z1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Zone And Region Wise In SMR due Date wise  " + e.getMessage());
        }
    }


// //.................................................................................................................

    @Test(priority = 8)
    public void Dealer_Parent_Group_Wise() throws InterruptedException {
        Thread.sleep(7000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement Dealer_Parent_Group_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Dealer Parent Group Wise \"]")));
        Dealer_Parent_Group_Wise.click();
        Thread.sleep(3000);

        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

        Thread.sleep(30000);

        //Elements of Dealer Parent Wise
        WebElement TotalDue = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[2]"));
        WebElement ReportedAtOWN = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[3]"));
        WebElement ReportedAtOther = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[4]"));
        WebElement AppointmentBooked = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[5]"));
        WebElement CallMeLater = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[6]"));
        WebElement LowMileage = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[7]"));
        WebElement VehicleSoldTo = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[8]"));
        WebElement RefuseForService = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[9]"));
        WebElement WrongNo = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[10]"));
        WebElement AppointmentCancelled = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[11]"));
        WebElement CallNotConnected = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[12]"));
        WebElement Fresh = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[13]"));
        WebElement PendingFresh = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[14]"));
        WebElement UnallocatedData = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[1]/td[15]"));
        Thread.sleep(4000);
        //GET THE VALUES
        String S = TotalDue.getText();
        System.out.println("Dealer parent group wise  of Total due in SMR Due Date wise In SMR due Date wise:::" + S);

        d1 = TotalDue.getText();
        d2 = ReportedAtOWN.getText();
        d3 = ReportedAtOther.getText();
        d4 = AppointmentBooked.getText();
        d5 = CallMeLater.getText();
        d6 = LowMileage.getText();
        d7 = VehicleSoldTo.getText();
        d8 = RefuseForService.getText();
        d9 = WrongNo.getText();
        d10 = AppointmentCancelled.getText();
        d11 = CallNotConnected.getText();
        d12 = Fresh.getText();
        d13 = PendingFresh.getText();
        d14 = UnallocatedData.getText();
        Thread.sleep(5000);


        try {

            // Parse the Total Due value to a numeric type
            int totalDueValue = Integer.parseInt(d1);

            if (totalDueValue <= 0 || d1 == null) {
                // Fail the test if Total Due value is 0 or less
                Assert.fail("No Data Found for Dealer_Parent_Group_Wise In SMR due Date wise: " + d1);
            } else {
                // Print the Total Due value
                //    System.out.println("Total Due value of Dealer_Parent_Group_Wise In SMR due Date wise::: " + d1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Dealer_Parent_Group_Wise In SMR due Date wise " + e.getMessage());
        }
    }


    //.................................................................................................................

    @Test(priority = 9)
    public void WorkShop_Wise() throws InterruptedException {
        Thread.sleep(7000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement WorkShop_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Workshop Wise \"]")));
        WorkShop_Wise.click();
        Thread.sleep(3000);

        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

        Thread.sleep(30000);

        //Elements of Workshop Wise
        WebElement TotalDue = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[3]"));
        WebElement ReportedAtOWN = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[4]"));
        WebElement ReportedAtOther = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[5]"));
        WebElement AppointmentBooked = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[6]"));
        WebElement CallMeLater = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[7]"));
        WebElement LowMileage = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[8]"));
        WebElement VehicleSoldTo = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[9]"));
        WebElement RefuseForService = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[10]"));
        WebElement WrongNo = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[11]"));
        WebElement AppointmentCancelled = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[12]"));
        WebElement CallNotConnected = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[13]"));
        WebElement Fresh = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[14]"));
        WebElement PendingFresh = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[15]"));
        WebElement UnallocatedData = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[2]/td[16]"));
        Thread.sleep(4000);
        //GET THE VALUES

        w1 = TotalDue.getText();
        w2 = ReportedAtOWN.getText();
        w3 = ReportedAtOther.getText();
        w4 = AppointmentBooked.getText();
        w5 = CallMeLater.getText();
        w6 = LowMileage.getText();
        w7 = VehicleSoldTo.getText();
        w8 = RefuseForService.getText();
        w9 = WrongNo.getText();
        w10 = AppointmentCancelled.getText();
        w11 = CallNotConnected.getText();
        w12 = Fresh.getText();
        w13 = PendingFresh.getText();
        w14 = UnallocatedData.getText();

        Thread.sleep(5000);


        try {

            // Parse the Total Due value to a numeric type
            double totalDueValue = Double.parseDouble(w1);

            if (totalDueValue <= 0 || w1 == null) {
                // Fail the test if Total Due value is 0 or less
                Assert.fail("No Data Found for WorkShop_Wise In SMR due Date wise : " + w1);
            } else {
                // Print the Total Due value
                System.out.println("Total Due value of WorkShop_Wise In SMR due Date wise  ::: " + w1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for WorkShop_Wise  In SMR due Date wise " + e.getMessage());
        }
    }

    //..........................................................................................................

    @Test(priority = 10)
    public void Day_Wise() throws InterruptedException {
        Thread.sleep(7000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement Day_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Day Wise \"]")));
        Day_Wise.click();
        Thread.sleep(3000);

        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

        Thread.sleep(30000);

        //Elements of Workshop Wise
        WebElement TotalDue = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[2]"));
        WebElement ReportedAtOWN = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[3]"));
        WebElement ReportedAtOther = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[4]"));
        WebElement AppointmentBooked = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[5]"));
        WebElement CallMeLater = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[6]"));
        WebElement LowMileage = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[7]"));
        WebElement VehicleSoldTo = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[8]"));
        WebElement RefuseForService = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[9]"));
        WebElement WrongNo = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[10]"));
        WebElement AppointmentCancelled = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[11]"));
        WebElement CallNotConnected = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[12]"));
        WebElement Fresh = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[13]"));
        WebElement PendingFresh = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[14]"));
        WebElement UnallocatedData = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[3]/td[15]"));
        Thread.sleep(4000);
        //GET THE VALUES

        day1 = TotalDue.getText();
        day2 = ReportedAtOWN.getText();
        day3 = ReportedAtOther.getText();
        day4 = AppointmentBooked.getText();
        day5 = CallMeLater.getText();
        day6 = LowMileage.getText();
        day7 = VehicleSoldTo.getText();
        day8 = RefuseForService.getText();
        day9 = WrongNo.getText();
        day10 = AppointmentCancelled.getText();
        day11 = CallNotConnected.getText();
        day12 = Fresh.getText();
        day13 = PendingFresh.getText();
        day14 = UnallocatedData.getText();
        Thread.sleep(5000);

        try {

            // Parse the Total Due value to a numeric type
            double totalDueValue = Double.parseDouble(day1);

            if (totalDueValue <= 0 || day1 == null) {
                // Fail the test if Total Due value is 0 or less
                Assert.fail("No Data Found for Day Wise In SMR due Date wise  : " + day1);
            } else {
                // Print the Total Due value
                System.out.println("Total Due value of Day_Wise In SMR due Date wise ::: " + day1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Day_Wise  In SMR due Date wise  " + e.getMessage());
        }
    }
//...............................................................................................................

    @Test(priority = 11)
    public void Service_Type_Wise() throws InterruptedException {
        Thread.sleep(14000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement Service_Type_Wise = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Service Type Wise \"]")));
        Service_Type_Wise.click();

        // Click on the generate report button
        WebElement clickOnGenerate = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
        clickOnGenerate.click();

        Thread.sleep(30000);


        //Elements of Workshop Wise
        WebElement TotalDue = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[2]"));
        WebElement ReportedAtOWN = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[3]"));
        WebElement ReportedAtOther = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[4]"));
        WebElement AppointmentBooked = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[5]"));
        WebElement CallMeLater = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[6]"));
        WebElement LowMileage = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[7]"));
        WebElement VehicleSoldTo = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[8]"));
        WebElement RefuseForService = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[9]"));
        WebElement WrongNo = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[10]"));
        WebElement AppointmentCancelled = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[11]"));
        WebElement CallNotConnected = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[12]"));
        WebElement Fresh = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[13]"));
        WebElement PendingFresh = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[14]"));
        WebElement UnallocatedData = driver.findElement(By.xpath("(//tr[td[contains(text(),'Total')]])[4]/td[15]"));
        Thread.sleep(4000);
        //GET THE VALUES

        s1 = TotalDue.getText();
        s2 = ReportedAtOWN.getText();
        s3 = ReportedAtOther.getText();
        s4 = AppointmentBooked.getText();
        s5 = CallMeLater.getText();
        s6 = LowMileage.getText();
        s7 = VehicleSoldTo.getText();
        s8 = RefuseForService.getText();
        s9 = WrongNo.getText();
        s10 = AppointmentCancelled.getText();
        s11 = CallNotConnected.getText();
        s12 = Fresh.getText();
        s13 = PendingFresh.getText();
        s14 = UnallocatedData.getText();
        Thread.sleep(5000);
        try {
            // Find the attribute value of Total Due
            // Parse the Total Due value to a numeric type
            double totalDueValue = Double.parseDouble(s1);

            if (totalDueValue <= 0 || s1 == null) {
                // Fail the test if Total Due value is 0 or less
                Assert.fail("No Data Found for Service Type Wise   In SMR due Date wise : " + s1);
            } else {
                // Print the Total Due value
                System.out.println("Total Due value of Service Type  Wise In SMR due Date wise ::: " + s1);
            }

        } catch (Exception e) {
            // Fail the test if an exception is thrown
            Assert.fail("No Data Found for Service Type Wise In SMR due Date wise  " + e.getMessage());
        }
    }
//..............................................................................................................................................

    @Test(priority = 12)
    public void Compare_TotalDue_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {

        Assert.assertEquals(d1, z1);
    }

    //...................................................................................................
    @Test(priority = 13)
    public void Compare_ReportedAtOWN_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {


        Assert.assertEquals(d2, z2);
    }

    //...................................................................................................
    @Test(priority = 14)
    public void Compare_ReportedAtOTHER_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {


        Assert.assertEquals(d3, z3);
    }

    //...................................................................................................
    @Test(priority = 15)
    public void Compare_AppointmentBooked_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {


        Assert.assertEquals(d4, z4);
    }

    //...................................................................................................
    @Test(priority = 16)
    public void Compare_CallMeLater_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {


        Assert.assertEquals(d5, z5);
    }

    //...................................................................................................
    @Test(priority = 17)
    public void Compare_LowMileage_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {


        Assert.assertEquals(d6, z6);
    }

    //...................................................................................................
    @Test(priority = 18)
    public void Compare_VehicleSold_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {


        Assert.assertEquals(d7, z7);
    }

    //...................................................................................................
    @Test(priority = 19)
    public void Compare_RefuseForService_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {


        Assert.assertEquals(d8, z8);
    }

    //...................................................................................................
    @Test(priority = 20)
    public void Compare_WrongNo_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {


        Assert.assertEquals(d9, z9);
    }

    //...................................................................................................
    @Test(priority = 21)
    public void Compare_AppointmentCancelled_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {


        Assert.assertEquals(d10, z10);
    }

    //...................................................................................................
    @Test(priority = 22)
    public void Compare_CallNotConnected_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {


        Assert.assertEquals(d11, z11);
    }

    //...................................................................................................
    @Test(priority = 23)
    public void Compare_Fresh_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {
        Thread.sleep(2000);

        Assert.assertEquals(d12, z12);
    }

    //...................................................................................................
    @Test(priority = 24)
    public void Compare_PendingFresh_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {


        Assert.assertEquals(d13, z13);
    }

    //...................................................................................................
    @Test(priority = 25)
    public void Compare_UnallocatedData_Column_ZoneRegionWise_With_DealerParentWise() throws InterruptedException {


        Assert.assertEquals(d14, z14);
    }

    //...................................................................................................
    @Test(priority = 26)
    public void Compare_TotalDue_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w1, z1);
    }

    //...................................................................................................
    @Test(priority = 27)
    public void Compare_ReportedAtOWN_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w2, z2);
    }

    //...................................................................................................
    @Test(priority = 28)
    public void Compare_ReportedAtOTHER_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w3, z3);
    }

    //...................................................................................................
    @Test(priority = 29)
    public void Compare_AppointmentBooked_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w4, z4);
    }

    //...................................................................................................
    @Test(priority = 30)
    public void Compare_CallMeLater_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w5, z5);
    }

    //...................................................................................................
    @Test(priority = 31)
    public void Compare_LowMileage_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w6, z6);
    }

    //...................................................................................................
    @Test(priority = 32)
    public void Compare_VehicleSOLD_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w7, z7);
    }

    //...................................................................................................
    @Test(priority = 33)
    public void Compare_RefuseForService_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w8, z8);
    }

    //...................................................................................................
    @Test(priority = 34)
    public void Compare_WrongNo_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w9, z9);
    }

    //...................................................................................................
    @Test(priority = 35)
    public void Compare_AppointmentCancelled_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w10, z10);
    }

    //...................................................................................................
    @Test(priority = 36)
    public void Compare_CallNotConnected_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w11, z11);
    }

    //...................................................................................................
    @Test(priority = 37)
    public void Compare_Fresh_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w12, z12);
    }

    //...................................................................................................
    @Test(priority = 38)
    public void Compare_PendingFresh_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w13, z13);
    }

    //...................................................................................................
    @Test(priority = 39)
    public void Compare_UnallocatedData_Column_ZoneRegionWise_With_WorkshopWise() throws InterruptedException {


        Assert.assertEquals(w14, z14);
    }

    //...................................................................................................
    @Test(priority = 40)
    public void Compare_TotalDue_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day1, z1);
    }

    //...................................................................................................
    @Test(priority = 41)
    public void Compare_ReportedAtOWN_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day2, z2);
    }

    //...................................................................................................
    @Test(priority = 42)
    public void Compare_ReportedAtOTHER_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day3, z3);
    }

    //...................................................................................................
    @Test(priority = 43)
    public void Compare_AppointmentBooked_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day4, z4);
    }

    //...................................................................................................
    @Test(priority = 44)
    public void Compare_CallMeLater_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day5, z5);
    }

    //...................................................................................................
    @Test(priority = 45)
    public void Compare_LowMileage_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day6, z6);
    }

    //...................................................................................................
    @Test(priority = 46)
    public void Compare_VehicleSOLD_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day7, z7);
    }

    //...................................................................................................
    @Test(priority = 47)
    public void Compare_RefuseForService_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day8, z8);
    }

    //...................................................................................................
    @Test(priority = 48)
    public void Compare_WrongNo_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day9, z9);
    }

    //...................................................................................................
    @Test(priority = 49)
    public void Compare_AppointmentCancelled_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day10, z10);
    }

    //...................................................................................................
    @Test(priority = 50)
    public void Compare_CallNotConnected_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day11, z11);
    }

    //...................................................................................................
    @Test(priority = 51)
    public void Compare_Fresh_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day12, z12);
    }

    //...................................................................................................
    @Test(priority = 52)
    public void Compare_PendingFresh_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day13, z13);
    }

    //...................................................................................................
    @Test(priority = 53)
    public void Compare_UnallocatedData_Column_ZoneRegionWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day14, z14);
    }

    //...................................................................................................
    @Test(priority = 54)
    public void Compare_TotalDue_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s1, z1);
    }

    //...................................................................................................
    @Test(priority = 55)
    public void Compare_ReportedAtOWN_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s2, z2);
    }

    //...................................................................................................
    @Test(priority = 56)
    public void Compare_ReportedAtOTHER_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s3, z3);
    }

    //...................................................................................................
    @Test(priority = 57)
    public void Compare_AppointmentBooked_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s4, z4);
    }

    //...................................................................................................
    @Test(priority = 58)
    public void Compare_CallMeLater_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s5, z5);
    }

    //...................................................................................................
    @Test(priority = 59)
    public void Compare_LowMileage_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s6, z6);
    }

    //...................................................................................................
    @Test(priority = 60)
    public void Compare_VehicleSOLD_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s7, z7);
    }

    //...................................................................................................
    @Test(priority = 61)
    public void Compare_RefuseForService_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s8, z8);
    }

    //...................................................................................................
    @Test(priority = 62)
    public void Compare_WrongNo_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s9, z9);
    }

    //...................................................................................................
    @Test(priority = 63)
    public void Compare_AppointmentCancelled_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s10, z10);
    }

    //...................................................................................................
    @Test(priority = 64)
    public void Compare_CallNotConnected_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s11, z11);
    }

    //...................................................................................................
    @Test(priority = 65)
    public void Compare_Fresh_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s12, z12);
    }

    //...................................................................................................
    @Test(priority = 66)
    public void Compare_PendingFresh_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s13, z13);
    }

    //...................................................................................................
    @Test(priority = 67)
    public void Compare_UnallocatedData_Column_ZoneRegionWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s14, z14);
    }

    //...................................................................................................
    @Test(priority = 68)
    public void Compare_TotalDue_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w1, d1);
    }

    //...................................................................................................
    @Test(priority = 69)
    public void Compare_ReportedAtOWN_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w2, d2);
    }

    //...................................................................................................
    @Test(priority = 70)
    public void Compare_ReportedAtOTHER_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w3, d3);
    }

    //...................................................................................................
    @Test(priority = 71)
    public void Compare_AppointmentBooked_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w4, d4);
    }

    //...................................................................................................
    @Test(priority = 72)
    public void Compare_CallMeLater_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w5, d5);
    }

    //...................................................................................................
    @Test(priority = 73)
    public void Compare_LowMileage_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w6, d6);
    }

    //...................................................................................................
    @Test(priority = 74)
    public void Compare_VehicleSOLD_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w7, d7);
    }

    //...................................................................................................
    @Test(priority = 75)
    public void Compare_RefuseForService_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w8, d8);
    }

    //...................................................................................................
    @Test(priority = 76)
    public void Compare_WrongNo_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w9, d9);
    }

    //...................................................................................................
    @Test(priority = 77)
    public void Compare_AppointmentCancelled_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertEquals(w10, d10);
    }

    //...................................................................................................
    @Test(priority = 78)
    public void Compare_CallNotConnected_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w11, d11);
    }

    //...................................................................................................
    @Test(priority = 79)
    public void Compare_Fresh_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w12, d12);
    }

    //...................................................................................................
    @Test(priority = 80)
    public void Compare_PendingFresh_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w13, d13);
    }

    //...................................................................................................
    @Test(priority = 81)
    public void Compare_UnallocatedData_Column_DealerParentWise_With_WorkshopWise() throws InterruptedException {

        Assert.assertEquals(w14, d14);
    }

    //...................................................................................................
    @Test(priority = 82)
    public void Compare_TotalDue_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day1, d1);
    }

    //...................................................................................................
    @Test(priority = 83)
    public void Compare_ReportedAtOWN_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day2, d2);
    }

    //...................................................................................................
    @Test(priority = 84)
    public void Compare_ReportedAtOTHER_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day3, d3);
    }

    //...................................................................................................
    @Test(priority = 85)
    public void Compare_AppointmentBooked_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day4, d4);
    }

    //...................................................................................................
    @Test(priority = 86)
    public void Compare_CallMeLater_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day5, d5);
    }

    //...................................................................................................
    @Test(priority = 87)
    public void Compare_LowMileage_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day6, d6);
    }

    //...................................................................................................
    @Test(priority = 88)
    public void Compare_VehicleSOLD_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day7, d7);
    }

    //...................................................................................................
    @Test(priority = 89)
    public void Compare_RefuseForService_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day8, d8);
    }

    //...................................................................................................
    @Test(priority = 90)
    public void Compare_WrongNo_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day9, d9);
    }

    //...................................................................................................
    @Test(priority = 91)
    public void Compare_AppointmentCancelled_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day10, d10);
    }

    //...................................................................................................
    @Test(priority = 92)
    public void Compare_CallNotConnected_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day11, d11);
    }

    //...................................................................................................
    @Test(priority = 93)
    public void Compare_Fresh_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day12, d12);
    }

    //...................................................................................................
    @Test(priority = 94)
    public void Compare_PendingFresh_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day13, d13);
    }

    //...................................................................................................
    @Test(priority = 95)
    public void Compare_UnallocatedData_Column_DealerParentWise_With_DayWise() throws InterruptedException {

        Assert.assertEquals(day14, d14);
    }

    //...................................................................................................
    @Test(priority = 96)
    public void Compare_TotalDue_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s1, d1);
    }

    //...................................................................................................
    @Test(priority = 97)
    public void Compare_ReportedAtOWN_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s2, d2);
    }

    //...................................................................................................
    @Test(priority = 98)
    public void Compare_ReportedAtOTHER_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s3, d3);
    }

    //...................................................................................................
    @Test(priority = 99)
    public void Compare_AppointmentBooked_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s4, d4);
    }

    //...................................................................................................
    @Test(priority = 100)
    public void Compare_CallMeLater_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s5, d5);
    }

    //...................................................................................................
    @Test(priority = 101)
    public void Compare_LowMileage_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s6, d6);
    }

    //...................................................................................................
    @Test(priority = 102)
    public void Compare_VehicleSOLD_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s7, d7);
    }

    //...................................................................................................
    @Test(priority = 103)
    public void Compare_RefuseForService_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s8, d8);
    }

    //...................................................................................................
    @Test(priority = 104)
    public void Compare_WrongNo_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s9, d9);
    }

    //...................................................................................................
    @Test(priority = 105)
    public void Compare_AppointmentCancelled_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s10, d10);
    }

    //...................................................................................................
    @Test(priority = 106)
    public void Compare_CallNotConnected_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s11, d11);
    }

    //...................................................................................................
    @Test(priority = 107)
    public void Compare_Fresh_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s12, d12);
    }

    //...................................................................................................
    @Test(priority = 108)
    public void Compare_PendingFresh_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {


        Assert.assertEquals(s13, d13);
    }

    //...................................................................................................
    @Test(priority = 109)
    public void Compare_UnallocatedData_Column_DealerParentWise_With_ServiceTypeWise() throws InterruptedException {


        Assert.assertEquals(s14, d14);
    }

    //...................................................................................................
    @Test(priority = 110)

    public void Compare_TotalDue_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day1, w1);
    }

    //...................................................................................................
    @Test(priority = 111)
    public void Compare_ReportedAtOWN_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day2, w2);
    }

    //...................................................................................................
    @Test(priority = 112)
    public void Compare_ReportedAtOTHER_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day3, w3);
    }

    //...................................................................................................
    @Test(priority = 113)
    public void Compare_AppointmentBooked_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day4, w4);
    }

    //...................................................................................................
    @Test(priority = 114)
    public void Compare_CallMeLater_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day5, w5);
    }

    //...................................................................................................
    @Test(priority = 115)
    public void Compare_LowMileage_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day6, w6);
    }

    //...................................................................................................
    @Test(priority = 116)
    public void Compare_VehicleSOLD_Column_WorkshopWise_With_DayWise() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertEquals(day7, w7);
    }

    //...................................................................................................
    @Test(priority = 117)
    public void Compare_RefuseForService_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day8, w8);
    }

    //...................................................................................................
    @Test(priority = 118)
    public void Compare_WrongNo_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day9, w9);
    }

    //...................................................................................................
    @Test(priority = 119)
    public void Compare_AppointmentCancelled_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day10, w10);
    }

    //...................................................................................................
    @Test(priority = 120)
    public void Compare_CallNotConnected_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day11, w11);
    }

    //...................................................................................................
    @Test(priority = 121)
    public void Compare_Fresh_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day12, w12);
    }

    //...................................................................................................
    @Test(priority = 122)
    public void Compare_PendingFresh_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day13, w13);
    }

    //...................................................................................................
    @Test(priority = 123)
    public void Compare_UnallocatedData_Column_WorkshopWise_With_DayWise() throws InterruptedException {


        Assert.assertEquals(day14, w14);
    }

    //...................................................................................................
    @Test(priority = 124)
    public void Compare_TotalDue_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {


        Assert.assertEquals(s1, w1);
    }

    //...................................................................................................
    @Test(priority = 125)
    public void Compare_ReportedAtOWN_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {


        Assert.assertEquals(s2, w2);
    }

    //...................................................................................................
    @Test(priority = 126)
    public void Compare_ReportedAtOTHER_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {


        Assert.assertEquals(s3, w3);
    }

    //...................................................................................................
    @Test(priority = 127)
    public void Compare_AppointmentBooked_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {


        Assert.assertEquals(s4, w4);
    }

    //...................................................................................................
    @Test(priority = 128)
    public void Compare_CallMeLater_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertEquals(s5, w5);
    }

    //...................................................................................................
    @Test(priority = 129)
    public void Compare_LowMileage_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {


        Assert.assertEquals(s6, w6);
    }

    //...................................................................................................
    @Test(priority = 130)
    public void Compare_VehicleSOLD_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {


        Assert.assertEquals(s7, w7);
    }

    //...................................................................................................
    @Test(priority = 131)
    public void Compare_RefuseForService_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {


        Assert.assertEquals(s8, w8);
    }

    //...................................................................................................
    @Test(priority = 132)
    public void Compare_WrongNo_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s9, w9);
    }

    //...................................................................................................
    @Test(priority = 133)
    public void Compare_AppointmentCancelled_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {

        Assert.assertEquals(s10, w10);
    }

    //...................................................................................................
    @Test(priority = 134)
    public void Compare_CallNotConnected_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {


        Assert.assertEquals(s11, w11);
    }

    //...................................................................................................
    @Test(priority = 135)
    public void Compare_Fresh_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {


        Assert.assertEquals(s12, w12);
    }

    //...................................................................................................
    @Test(priority = 136)
    public void Compare_PendingFresh_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {


        Assert.assertEquals(s13, w13);
    }

    //...................................................................................................
    @Test(priority = 137)
    public void Compare_UnallocatedData_Column_WorkshopWise_With_ServiceTypeWise() throws InterruptedException {


        Assert.assertEquals(s14, w14);
    }

    //...................................................................................................
    @Test(priority = 138)
    public void Compare_TotalDue_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {


        Assert.assertEquals(s1, day1);
    }

    //...................................................................................................
    @Test(priority = 139)
    public void Compare_ReportedAtOWN_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {


        Assert.assertEquals(s2, day2);
    }

    //...................................................................................................
    @Test(priority = 140)
    public void Compare_ReportedAtOTHER_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {


        Assert.assertEquals(s3, day3);
    }

    //...................................................................................................
    @Test(priority = 141)
    public void Compare_AppointmentBooked_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {


        Assert.assertEquals(s4, day4);
    }

    //...................................................................................................
    @Test(priority = 142)
    public void Compare_CallMeLater_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {


        Assert.assertEquals(s5, day5);
    }

    //...................................................................................................
    @Test(priority = 143)
    public void Compare_LowMileage_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Assert.assertEquals(s6, day6);
    }

    //...................................................................................................
    @Test(priority = 144)
    public void Compare_VehicleSOLD_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {


        Assert.assertEquals(s7, day7);
    }

    //...................................................................................................
    @Test(priority = 145)
    public void Compare_RefuseForService_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {


        Assert.assertEquals(s8, day8);
    }

    //...................................................................................................
    @Test(priority = 146)
    public void Compare_WrongNo_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {


        Assert.assertEquals(s9, day9);
    }

    //...................................................................................................
    @Test(priority = 147)
    public void Compare_AppointmentCancelled_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {


        Assert.assertEquals(s10, day10);
    }

    //...................................................................................................
    @Test(priority = 148)
    public void Compare_CallNotConnected_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {


        Assert.assertEquals(s11, day11);
    }

    //...................................................................................................
    @Test(priority = 149)
    public void Compare_Fresh_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {


        Assert.assertEquals(s12, day12);
    }

    //...................................................................................................
    @Test(priority = 150)
    public void Compare_PendingFresh_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {


        Assert.assertEquals(s13, day13);
    }

    //...................................................................................................
    @Test(priority = 151)
    public void Compare_UnallocatedData_Column_DayWise_With_ServiceTypeWise() throws InterruptedException {


        Assert.assertEquals(s14, day14);
        Thread.sleep(5000);
    }
//...................................................................................................	


}
				    
