package mergeSMR_North_Zone;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Cross_sell_Intrest_cost {
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
	String z15;
	String z16;
	String z17;
	String z18;
	String z19;
	String z20;
	String z21;
	String z22;
	String z23;

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
	String d20;
	String d21;
	String d22;
	String d23;

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
	String w20;
	String w21;
	String w22;
	String w23;

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
	String day20;
	String day21;
	String day22;
	String day23;

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
	String s15;
	String s16;
	String s17;
	String s18;
	String s19;
	String s20;
	String s21;
	String s22;
	String s23;

	//..................................................................................................
	   @SuppressWarnings("static-access")
	   @BeforeClass
		public void SMR() throws InterruptedException {
		 this.driver=Smart_Eye_lead_performace.driver;	
		 Thread.sleep(5000);
		}
	// ..................................................................................................
	@Test(priority = 5)
	public void Click_On_Report() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement report = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Reports \"]")));
		report.click();
		Thread.sleep(3000);

	}

	// ..............................................................................................................
	@Test(priority = 6)
	public void Click_On_The_Cross_sell_Intrest() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement Cross = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Cross-Sell Interest Log \"]")));
		Cross.click();
		Thread.sleep(3000);

	}

	// .........................................................................................................

	@Test(priority = 7)
	public void Zone_Region_Wise() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Click on the calendar to open date picker
		WebElement select = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[alt=\"calendar\"]")));
		select.click();
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

		Thread.sleep(35000);

		// Try to locate the Totalleads_recived element
		WebElement Total_Dispostion;
		try {
			Total_Dispostion = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[2]"));

			// Check if Totalleads_recived element is displayed
			if (!Total_Dispostion.isDisplayed()) {
				Assert.fail(
						"No Data Found in Zone Region Wise: Lead generated element element is not visible on the page Cross sell Intrest cost.");
			}
		} catch (NoSuchElementException e) {
			Assert.fail("No Data Found in Zone Region Wise: Lead generated element element could not be found  Cross sell Intrest cost : "
					+ e.getMessage());
			return; // Exit the test if the element is not found
		}

		// Check if Totalleads_recived is enabled
		if (!Total_Dispostion.isEnabled()) {
			Assert.fail("Lead generated element is not enabled Cross sell Intrest cost ");
		}

		// Proceed with the rest of your element locators and text retrievals
		WebElement Total_Interest_Dispostion = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[3]"));
		WebElement Not_Interest_Dispostion = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[4]"));
		WebElement Not_confiremed_Dispostion = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[5]"));
		WebElement Total_Intrested = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[6]"));
		WebElement Yes = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[7]"));
		WebElement Gold = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[8]"));
		WebElement Platinum = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[9]"));
		WebElement Royal_Platinium = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[10]"));
		WebElement Total_Intrested1 = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[11]"));
		WebElement Yes2 = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[12]"));
		WebElement CCP_Hydro = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[13]"));
		WebElement CCP_Fuel = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[14]"));
		WebElement CCP_Plus = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[15]"));

		WebElement Total_Intrested2 = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[16]"));
		WebElement yes2 = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[17]"));
		WebElement Platinum2 = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[18]"));
		WebElement Royal_Platinium2 = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[19]"));
		WebElement Total_Intrested3 = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[20]"));
		WebElement Yes3 = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[21]"));
		WebElement CCP_Hydro2 = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[22]"));
		WebElement CCP_Fuel2 = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[23]"));
		WebElement CCP_Plus2 = driver.findElement(By.xpath("//*[@id=\"tableId\"]/tbody/tr[1]/td[24]"));

		Thread.sleep(4000);

		z1 = Total_Dispostion.getText();
		System.out.println("Lead_generated of Zone and region wise In Cross sell Intrest cost::" + z1);

		z2 = Total_Interest_Dispostion.getText();
		z3 = Not_Interest_Dispostion.getText();
		z4 = Not_confiremed_Dispostion.getText();
		z5 = Total_Intrested.getText();
		z6 = Yes.getText();
		z7 = Gold.getText();
		z8 = Platinum.getText();
		z9 = Royal_Platinium.getText();
		z10 = Total_Intrested1.getText();
		z11 = Yes2.getText();
		z12 = CCP_Hydro.getText();
		z13 = CCP_Fuel.getText();
		z14 = CCP_Plus.getText();

		z15 = Total_Intrested2.getText();
		z16 = yes2.getText();
		z17 = Platinum2.getText();
		z18 = Royal_Platinium2.getText();
		z19 = Total_Intrested3.getText();
		z20 = Yes3.getText();
		z21 = CCP_Hydro2.getText();
		z22 = CCP_Fuel2.getText();
		z23 = CCP_Plus2.getText();

		Thread.sleep(5000);

		try {
			// Parse the Total Due value to a numeric type
			Integer totalDueValue = Integer.parseInt(z1);

			if (totalDueValue <= 0 || totalDueValue == null) {

				// Fail the test if Total Due value is 0 or less
				Assert.fail("No Data Found for Zone_Region_wise_Wise In Cross sell Intrest:: " + z1);
			} else {
				// Print the Total Due value
				// System.out.println("Total Due value of Zone_region_Wise::: " + z1);
			}

		} catch (Exception e) {
			// Fail the test if an exception is thrown
			Assert.fail("No Data Found for Zone_Region_Wise of In Cross sell Intrest: " + e.getMessage());
		}
	}

	// ...............................................................................................
	@Test(priority = 8)
	public void Dealer_Parent_Group_Wise() throws InterruptedException {
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

		Thread.sleep(35000);

		// Check if Items per page can be set to 100
		try {
			WebElement Items_Per_page = driver.findElement(By.cssSelector("[id=\"mat-select-value-3\"]"));
			Items_Per_page.click();
			Thread.sleep(2000);

			WebElement click_On_Hundred = driver.findElement(By.xpath("(//*[@class=\"mat-option-text\"])[4]"));
			click_On_Hundred.click();
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {
			System.out.println("Pagination is disabled or less than 100 items are available.");
		}

		boolean paginationExists = false;

		// Check for the pagination button and click if available
		try {
			WebElement click_On_pagination = driver.findElement(By.xpath("(//*[@class=\"mat-paginator-icon\"])[4]"));
			paginationExists = click_On_pagination.isDisplayed();

			if (paginationExists) {
				click_On_pagination.click();
				Thread.sleep(3000);
			} else {
				System.out.println("Pagination is not enabled.");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Pagination element not found, stopping pagination.");
		}

		// Proceed with the rest of your element locators and text retrievals
		WebElement Total_Dispostion = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[2]"));

		WebElement Total_Interest_Dispostion = driver
				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[3]"));
		WebElement Not_Interest_Dispostion = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[4]"));
		WebElement Not_confiremed_Dispostion = driver
				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[5]"));
		WebElement Total_Intrested = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[6]"));
		WebElement Yes = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[7]"));
		WebElement Gold = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[8]"));
		WebElement Platinum = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[9]"));
		WebElement Royal_Platinium = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[10]"));
		WebElement Total_Intrested1 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[11]"));
		WebElement Yes2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[12]"));
		WebElement CCP_Hydro = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[13]"));
		WebElement CCP_Fuel = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[14]"));
		WebElement CCP_Plus = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[15]"));

		WebElement Total_Intrested2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[16]"));
		WebElement yes2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[17]"));
		WebElement Platinum2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[18]"));
		WebElement Royal_Platinium2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[19]"));
		WebElement Total_Intrested3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[20]"));
		WebElement Yes3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[21]"));
		WebElement CCP_Hydro2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[22]"));
		WebElement CCP_Fuel2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[23]"));
		WebElement CCP_Plus2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[1]/td[24]"));

		Thread.sleep(4000);

		if (Total_Dispostion.isDisplayed()) {
			d1 = Total_Dispostion.getText();
			System.out.println("Total_Dispostion of Dealer_Parent_Group_Wise In Cross sell Intrest cost ::" + d1);
		}

		else {
			Assert.fail("no data found for Cross sell Intrest  In Cross sell Intrest cost ");
		}

		d2 = Total_Interest_Dispostion.getText();
		d3 = Not_Interest_Dispostion.getText();
		d4 = Not_confiremed_Dispostion.getText();
		d5 = Total_Intrested.getText();
		d6 = Yes.getText();
		d7 = Gold.getText();
		d8 = Platinum.getText();
		d9 = Royal_Platinium.getText();
		d10 = Total_Intrested1.getText();
		d11 = Yes2.getText();
		d12 = CCP_Hydro.getText();
		d13 = CCP_Fuel.getText();
		d14 = CCP_Plus.getText();

		d15 = Total_Intrested2.getText();
		d16 = yes2.getText();
		d17 = Platinum2.getText();
		d18 = Royal_Platinium2.getText();
		d19 = Total_Intrested3.getText();
		d20 = Yes3.getText();
		d21 = CCP_Hydro2.getText();
		d22 = CCP_Fuel2.getText();
		d23 = CCP_Plus2.getText();

		Thread.sleep(5000);

		try {

			// Parse the Total Disposition value to a numeric type
			Integer value = Integer.parseInt(d1);

			if (value <= 0 || d1 == null) {
				// Fail the test if Total Disposition value is 0 or less
				Assert.fail("No Data Found for Dealer Parent Group Wise  In Cross sell Intrest cost : " + d1);
			} else {
				// Print the Total Disposition value
				// System.out.println("'Total Dispositions' column value of Dealer Parent Group
				// Wise Tab is::: " + d1);
			}

		} catch (Exception e) {
			// Fail the test if an exception is thrown
			Assert.fail("No Data Found for Dealer Parent Group Wise Tab  In Cross sell Intrest cost " + e.getMessage());
		}
	}

	// ...............................................................................................
	@Test(priority = 9)
	public void workshop_Wise() throws InterruptedException {
		Thread.sleep(7000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement WorkShop_Wise = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Workshop Wise \"]")));
		WorkShop_Wise.click();
		Thread.sleep(3000);

		

		// Click on the generate report button
		WebElement clickOnGenerate = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
		clickOnGenerate.click();

		Thread.sleep(35000);

		// Check if Items per page can be set to 100
		try {
			WebElement Items_Per_page = driver.findElement(By.cssSelector("[id=\"mat-select-value-5\"]"));
			Items_Per_page.click();
			Thread.sleep(2000);

			WebElement click_On_Hundred = driver.findElement(By.xpath("(//*[@class=\"mat-option-text\"])[4]"));
			click_On_Hundred.click();
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {
			System.out.println("Pagination is disabled or less than 100 items are available.");
		}

		boolean paginationExists = false;

		// Check for the pagination button and click if available
		try {
			WebElement click_On_pagination = driver.findElement(By.xpath("(//*[@class=\"mat-paginator-icon\"])[6]"));
			paginationExists = click_On_pagination.isDisplayed();

			if (paginationExists) {
				click_On_pagination.click();
				Thread.sleep(3000);
			} else {
				System.out.println("Pagination is not enabled.");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Pagination element not found, stopping pagination.");
		}

		// Proceed with the rest of your element locators and text retrievals
		WebElement Total_Dispostion = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[2]"));

		WebElement Total_Interest_Dispostion = driver
				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[3]"));
		WebElement Not_Interest_Dispostion = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[4]"));
		WebElement Not_confiremed_Dispostion = driver
				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[5]"));
		WebElement Total_Intrested = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[6]"));
		WebElement Yes = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[7]"));
		WebElement Gold = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[8]"));
		WebElement Platinum = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[9]"));
		WebElement Royal_Platinium = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[10]"));
		WebElement Total_Intrested1 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[11]"));
		WebElement Yes2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[12]"));
		WebElement CCP_Hydro = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[13]"));
		WebElement CCP_Fuel = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[14]"));
		WebElement CCP_Plus = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[15]"));

		WebElement Total_Intrested2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[16]"));
		WebElement yes2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[17]"));
		WebElement Platinum2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[18]"));
		WebElement Royal_Platinium2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[19]"));
		WebElement Total_Intrested3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[20]"));
		WebElement Yes3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[21]"));
		WebElement CCP_Hydro2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[22]"));
		WebElement CCP_Fuel2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[23]"));
		WebElement CCP_Plus2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[2]/td[24]"));

		Thread.sleep(4000);

		if (Total_Dispostion.isDisplayed()) {
			w1 = Total_Dispostion.getText();
			System.out.println("Total_Dispostion of Workshop_Wise In Cross sell Intrest cost ::" + w1);
		}

		else {
			Assert.fail("no data found for Cross sell Intrest In Cross sell Intrest cost ");
		}

		w2 = Total_Interest_Dispostion.getText();
		w3 = Not_Interest_Dispostion.getText();
		w4 = Not_confiremed_Dispostion.getText();
		w5 = Total_Intrested.getText();
		w6 = Yes.getText();
		w7 = Gold.getText();
		w8 = Platinum.getText();
		w9 = Royal_Platinium.getText();
		w10 = Total_Intrested1.getText();
		w11 = Yes2.getText();
		w12 = CCP_Hydro.getText();
		w13 = CCP_Fuel.getText();
		w14 = CCP_Plus.getText();

		w15 = Total_Intrested2.getText();
		w16 = yes2.getText();
		w17 = Platinum2.getText();
		w18 = Royal_Platinium2.getText();
		w19 = Total_Intrested3.getText();
		w20 = Yes3.getText();
		w21 = CCP_Hydro2.getText();
		w22 = CCP_Fuel2.getText();
		w23 = CCP_Plus2.getText();

		Thread.sleep(5000);

		try {

			// Parse the Total Disposition value to a numeric type
			Integer value = Integer.parseInt(w1);

			if (value <= 0 || w1 == null) {
				// Fail the test if Total Disposition value is 0 or less
				Assert.fail("No Data Found for Workshop_Wise In Cross sell Intrest cost : " + w1);
			} else {
				// Print the Total Disposition value
				// System.out.println("'Total Dispositions' column value of Dealer Parent Group
				// Wise Tab is::: " + d1);
			}

		} catch (Exception e) {
			// Fail the test if an exception is thrown
			Assert.fail("No Data Found for Workshop_Wise Tab In Cross sell Intrest cost " + e.getMessage());
		}
	}

	// ...............................................................................................
	@Test(priority = 10)
	public void Day_Wise() throws InterruptedException {
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

		Thread.sleep(35000);

		// Check if Items per page can be set to 100
		try {
			WebElement Items_Per_page = driver.findElement(By.cssSelector("[id=\"mat-select-value-7\"]"));
			Items_Per_page.click();
			Thread.sleep(2000);

			WebElement click_On_Hundred = driver.findElement(By.xpath("(//*[@class=\"mat-option-text\"])[4]"));
			click_On_Hundred.click();
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {
			System.out.println("Pagination is disabled or less than 100 items are available.");
		}

		boolean paginationExists = false;

		// Check for the pagination button and click if available
		try {
			WebElement click_On_pagination = driver.findElement(By.xpath("(//*[@class=\"mat-paginator-icon\"])[8]"));
			paginationExists = click_On_pagination.isDisplayed();

			if (paginationExists) {
				click_On_pagination.click();
				Thread.sleep(3000);
			} else {
				System.out.println("Pagination is not enabled.");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Pagination element not found, stopping pagination.");
		}

		// Proceed with the rest of your element locators and text retrievals
		WebElement Total_Dispostion = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[2]"));

		WebElement Total_Interest_Dispostion = driver
				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[3]"));
		WebElement Not_Interest_Dispostion = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[4]"));
		WebElement Not_confiremed_Dispostion = driver
				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[5]"));
		WebElement Total_Intrested = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[6]"));
		WebElement Yes = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[7]"));
		WebElement Gold = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[8]"));
		WebElement Platinum = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[9]"));
		WebElement Royal_Platinium = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[10]"));
		WebElement Total_Intrested1 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[11]"));
		WebElement Yes2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[12]"));
		WebElement CCP_Hydro = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[13]"));
		WebElement CCP_Fuel = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[14]"));
		WebElement CCP_Plus = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[15]"));

		WebElement Total_Intrested2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[16]"));
		WebElement yes2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[17]"));
		WebElement Platinum2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[18]"));
		WebElement Royal_Platinium2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[19]"));
		WebElement Total_Intrested3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[20]"));
		WebElement Yes3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[21]"));
		WebElement CCP_Hydro2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[22]"));
		WebElement CCP_Fuel2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[23]"));
		WebElement CCP_Plus2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[3]/td[24]"));

		Thread.sleep(4000);

		if (Total_Dispostion.isDisplayed()) {
			day1 = Total_Dispostion.getText();
			System.out.println("Total_Dispostion of Day_Wise In Cross sell Intrest cost ::" + day1);
		}

		else {
			Assert.fail("no data found for Cross sell Intrest  In Cross sell Intrest cost ");
		}

		day2 = Total_Interest_Dispostion.getText();
		day3 = Not_Interest_Dispostion.getText();
		day4 = Not_confiremed_Dispostion.getText();
		day5 = Total_Intrested.getText();
		day6 = Yes.getText();
		day7 = Gold.getText();
		day8 = Platinum.getText();
		day9 = Royal_Platinium.getText();
		day10 = Total_Intrested1.getText();
		day11 = Yes2.getText();
		day12 = CCP_Hydro.getText();
		day13 = CCP_Fuel.getText();
		day14 = CCP_Plus.getText();

		day15 = Total_Intrested2.getText();
		day16 = yes2.getText();
		day17 = Platinum2.getText();
		day18 = Royal_Platinium2.getText();
		day19 = Total_Intrested3.getText();
		day20 = Yes3.getText();
		day21 = CCP_Hydro2.getText();
		day22 = CCP_Fuel2.getText();
		day23 = CCP_Plus2.getText();

		Thread.sleep(5000);

		try {

			// Parse the Total Disposition value to a numeric type
			Integer value = Integer.parseInt(day1);

			if (value <= 0 || day1 == null) {
				// Fail the test if Total Disposition value is 0 or less
				Assert.fail("No Data Found for Day_Wise In Cross sell Intrest cost : " + day1);
			} else {
				// Print the Total Disposition value
				// System.out.println("'Total Dispositions' column value of Dealer Parent Group
				// Wise Tab is::: " + d1);
			}

		} catch (Exception e) {
			// Fail the test if an exception is thrown
			Assert.fail("No Data Found for Day_Wise Tab  In Cross sell Intrest cost " + e.getMessage());
		}
	}

	// ...............................................................................................
	@Test(priority = 11)
	public void service_Type_Wise() throws InterruptedException {
		Thread.sleep(7000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement Service_Type_Wise = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\" Service Type Wise \"]")));
		Service_Type_Wise.click();
		Thread.sleep(3000);

		

		// Click on the generate report button
		WebElement clickOnGenerate = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Generate\"]")));
		clickOnGenerate.click();

		Thread.sleep(35000);

		// Check if Items per page can be set to 100
		try {
			WebElement Items_Per_page = driver.findElement(By.cssSelector("[id=\"mat-select-value-9\"]"));
			Items_Per_page.click();
			Thread.sleep(2000);

			WebElement click_On_Hundred = driver.findElement(By.xpath("(//*[@class=\"mat-option-text\"])[4]"));
			click_On_Hundred.click();
			Thread.sleep(3000);
		} catch (NoSuchElementException e) {
			System.out.println("Pagination is disabled or less than 100 items are available.");
		}

		boolean paginationExists = false;

		// Check for the pagination button and click if available
		try {
			WebElement click_On_pagination = driver.findElement(By.xpath("(//*[@class=\"mat-paginator-icon\"])[10]"));
			paginationExists = click_On_pagination.isDisplayed();

			if (paginationExists) {
				click_On_pagination.click();
				Thread.sleep(3000);
			} else {
				System.out.println("Pagination is not enabled.");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Pagination element not found, stopping pagination.");
		}

		// Proceed with the rest of your element locators and text retrievals
		WebElement Total_Dispostion = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[2]"));

		WebElement Total_Interest_Dispostion = driver
				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[3]"));
		WebElement Not_Interest_Dispostion = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[4]"));
		WebElement Not_confiremed_Dispostion = driver
				.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[5]"));
		WebElement Total_Intrested = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[6]"));
		WebElement Yes = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[7]"));
		WebElement Gold = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[8]"));
		WebElement Platinum = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[9]"));
		WebElement Royal_Platinium = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[10]"));
		WebElement Total_Intrested1 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[11]"));
		WebElement Yes2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[12]"));
		WebElement CCP_Hydro = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[13]"));
		WebElement CCP_Fuel = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[14]"));
		WebElement CCP_Plus = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[15]"));

		WebElement Total_Intrested2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[16]"));
		WebElement yes2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[17]"));
		WebElement Platinum2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[18]"));
		WebElement Royal_Platinium2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[19]"));
		WebElement Total_Intrested3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[20]"));
		WebElement Yes3 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[21]"));
		WebElement CCP_Hydro2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[22]"));
		WebElement CCP_Fuel2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[23]"));
		WebElement CCP_Plus2 = driver.findElement(By.xpath("(//tr[td[contains(., 'Total')]])[4]/td[24]"));

		Thread.sleep(4000);

		if (Total_Dispostion.isDisplayed()) {
			s1 = Total_Dispostion.getText();
			System.out.println("Total_Dispostion of Service_Type_Wise In Cross sell Intrest cost ::" + s1);
		}

		else {
			Assert.fail("no data found for Cross sell Intrest In Cross sell Intrest cost  ");
		}

		s2 = Total_Interest_Dispostion.getText();
		s3 = Not_Interest_Dispostion.getText();
		s4 = Not_confiremed_Dispostion.getText();
		s5 = Total_Intrested.getText();
		s6 = Yes.getText();
		s7 = Gold.getText();
		s8 = Platinum.getText();
		s9 = Royal_Platinium.getText();
		s10 = Total_Intrested1.getText();
		s11 = Yes2.getText();
		s12 = CCP_Hydro.getText();
		s13 = CCP_Fuel.getText();
		s14 = CCP_Plus.getText();

		s5 = Total_Intrested2.getText();
		s16 = yes2.getText();
		s17 = Platinum2.getText();
		s18 = Royal_Platinium2.getText();
		s19 = Total_Intrested3.getText();
		s20 = Yes3.getText();
		s21 = CCP_Hydro2.getText();
		s22 = CCP_Fuel2.getText();
		s23 = CCP_Plus2.getText();

		Thread.sleep(5000);

		try {

			// Parse the Total Disposition value to a numeric type
			Integer value = Integer.parseInt(s1);

			if (value <= 0 || s1 == null) {
				// Fail the test if Total Disposition value is 0 or less
				Assert.fail("No Data Found for service_type_Wise In Cross sell Intrest cost  : " + s1);
			} else {
				// Print the Total Disposition value
				// System.out.println("'Total Dispositions' column value of Dealer Parent Group
				// Wise Tab is::: " + d1);
			}

		} catch (Exception e) {
			// Fail the test if an exception is thrown
			Assert.fail("No Data Found for cross sell Intrest  In Cross sell Intrest cost " + e.getMessage());
		}
	}

	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	
	@Test(priority = 12)
	public void Compare_Total_dispostion_Of_ZONE_Region_Wise_from__Dealer_Parent_Wise() throws InterruptedException {
		
		Assert.assertEquals(z1, d1);
	}
	//..............................................................................................
	@Test(priority = 13)
	public void Compare_Total_dispostion_Of_ZONE_Region_Wise_from_Worshop_Wise() throws InterruptedException {
		
		Assert.assertEquals(z1, w1);
	}
	//..............................................................................................
	@Test(priority = 14)
	public void Compare_Total_dispostion_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
		
		Assert.assertEquals(z1, day1);
	}
	//..............................................................................................
	@Test(priority = 15)
	public void Compare_Total_dispostion_Of_ZONE_Region_Wise_from_Service_Type_Wise() throws InterruptedException {
		
		Assert.assertEquals(z1, s1);
	}
	//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
	//..............................................................................................
		@Test(priority = 16)
		public void Compare_Total_Intrest_dispostion_Of_ZONE_Region_Wise_from_Dealer_parent_group_Wise() throws InterruptedException {
			
			Assert.assertEquals(z2, d2);
		}
	//..............................................................................................
				@Test(priority = 17)
				public void Compare_Total_Intrest_dispostion_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
					
					Assert.assertEquals(z2, w2);
				}
		//..............................................................................................
				@Test(priority = 18)
				public void Compare_Total_Intrest_dispostion_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
					
					Assert.assertEquals(z2, day2);
				}
		//..............................................................................................
				@Test(priority = 19)
				public void Compare_Total_Intrest_dispostion_Of_ZONE_Region_Wise_from_Service_Type_Wise() throws InterruptedException {
					
					Assert.assertEquals(z2, s2);
				}
		//.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
				
				@Test(priority = 20)
				public void Compare_Not_Intrest_dispostion_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
					
					Assert.assertEquals(z3, d3);
				}
				//..............................................................................................
				@Test(priority = 21)
				public void Compare_Not_Intrest_dispostion_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
					
					Assert.assertEquals(z3, w3);
				}
		      //..............................................................................................
				@Test(priority = 22)
				public void Compare_Not_Intrest_dispostion_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
					
					Assert.assertEquals(z3, day3);
				}
		      //..............................................................................................
				@Test(priority = 23)
				public void Compare_Not_Intrest_dispostion_Of_ZONE_Region_Wise_from_Service_Type_Wise() throws InterruptedException {
					
					Assert.assertEquals(z3, s3);
				}
         //.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
				
				@Test(priority = 24)
				public void Compare_Not_confiremed_dispostion_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
					
					Assert.assertEquals(z4, d4);
				}
				//..............................................................................................
				@Test(priority = 25)
				public void Compare_Not_confiremed_dispostion_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
					
					Assert.assertEquals(z4, w4);
				}
		      //..............................................................................................
				@Test(priority = 26)
				public void Compare_Not_confiremed_dispostion_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
					
					Assert.assertEquals(z4, day4);
				}
		      //..............................................................................................
				@Test(priority = 27)
				public void Compare_Not_confiremed_dispostion_Of_ZONE_Region_Wise_from_Service_Type_Wise() throws InterruptedException {
					
					Assert.assertEquals(z4, s4);
				}

    //.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
				
				@Test(priority = 28)
				public void Compare_Total_Intrested_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
					
					Assert.assertEquals(z5, d5);
				}
				//..............................................................................................
				@Test(priority = 29)
				public void Compare_Total_Intrested_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
					
					Assert.assertEquals(z5, w5);
				}
		      //..............................................................................................
				@Test(priority = 30)
				public void Compare_Total_Intrested_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
					
					Assert.assertEquals(z5, day5);
				}
		      //..............................................................................................
				@Test(priority = 31)
				public void Compare_Total_Intrested_Of_ZONE_Region_Wise_from_Service_Type_Wise() throws InterruptedException {
					
					Assert.assertEquals(z5, s5);
				}
     //.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
				
				@Test(priority = 32)
				public void Compare_YES_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
					
					Assert.assertEquals(z6, d6);
				}
				//..............................................................................................
				@Test(priority = 33)
				public void Compare_YES_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
					
					Assert.assertEquals(z6, w6);
				}
		      //..............................................................................................
				@Test(priority = 34)
				public void Compare_YES_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
					
					Assert.assertEquals(z6, day6);
				}
		      //..............................................................................................
				@Test(priority = 35)
				public void Compare_YES_Of_ZONE_Region_Wise_from_Service_Type_Wise() throws InterruptedException {
					
					Assert.assertEquals(z6, s6);
				}
 //.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
				
				@Test(priority = 36)
				public void Compare_GOLD_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
					
					Assert.assertEquals(z7, d7);
				}
				//..............................................................................................
				@Test(priority = 37)
				public void Compare_GOLD_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
					
					Assert.assertEquals(z7, w7);
				}
		      //..............................................................................................
				@Test(priority = 38)
				public void Compare_GOLD_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
					
					Assert.assertEquals(z7, day7);
				}
		      //..............................................................................................
				@Test(priority = 39)
				public void Compare_GOLD_Of_ZONE_Region_Wise_from_Service_Type_Wise() throws InterruptedException {
					
					Assert.assertEquals(z7, s7);
				}
   //.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
				
				@Test(priority = 40)
				public void Compare_PLATINUM_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
					
					Assert.assertEquals(z8, d8);
				}
				//..............................................................................................
				@Test(priority = 41)
				public void Compare_PLATINUM_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
					
					Assert.assertEquals(z8, w8);
				}
		      //..............................................................................................
				@Test(priority = 42)
				public void Compare_PLATINUM_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
					
					Assert.assertEquals(z8, day8);
				}
		      //..............................................................................................
				@Test(priority = 43)
				public void Compare_PLATINUM_Of_ZONE_Region_Wise_from_Service_Type_Wise() throws InterruptedException {
					
					Assert.assertEquals(z8, s8);
				}
 //.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
				
				@Test(priority = 44)
				public void Compare_Royal_PLATINUM_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
					
					Assert.assertEquals(z9, d9);
				}
				//..............................................................................................
				@Test(priority = 45)
				public void Compare_Royal_PLATINUM_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
					
					Assert.assertEquals(z9, w9);
				}
		      //..............................................................................................
				@Test(priority = 46)
				public void Compare_Royal_PLATINUM_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
					
					Assert.assertEquals(z9, day9);
				}
		      //..............................................................................................
				@Test(priority = 47)
				public void Compare_Royal_PLATINUM_Of_ZONE_Region_Wise_from_Service_Type_Wise() throws InterruptedException {
					
					Assert.assertEquals(z9, s9);
				}
				
            //.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
				
				@Test(priority = 48)
				public void Compare_Total_intrested_sale2_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
					
					Assert.assertEquals(z10, d10);
				}
				//..............................................................................................
				@Test(priority = 49)
				public void Compare_Total_intrested_sale2_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
					
					Assert.assertEquals(z10, w10);
				}
		      //..............................................................................................
				@Test(priority = 50)
				public void Compare_Total_intrested_sale2_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
					
					Assert.assertEquals(z10, day10);
				}
		      //..............................................................................................
				@Test(priority = 51)
				public void Compare_Total_intrested_sale2_Of_ZONE_Region_Wise_from_Service_Type_Wise() throws InterruptedException {
					
					Assert.assertEquals(z10, s10);
				}
 //.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
				
				@Test(priority = 52)
				public void Compare_YES2_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
					
					Assert.assertEquals(z11, d11);
				}
				//..............................................................................................
				@Test(priority = 53)
				public void Compare_YES2_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
					
					Assert.assertEquals(z11, w11);
				}
		      //..............................................................................................
				@Test(priority = 54)
				public void Compare_YES2_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
					
					Assert.assertEquals(z11, day11);
				}
		      //..............................................................................................
				@Test(priority = 55)
				public void Compare_YES2_Of_ZONE_Region_Wise_from_Service_Type_Wise() throws InterruptedException {
					
					Assert.assertEquals(z11, s11);
				}
				
//.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
				
				@Test(priority = 56)
				public void Compare_Ccp_Hydro_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
					
					Assert.assertEquals(z12, d12);
				}
				//..............................................................................................
				@Test(priority = 57)
				public void Compare_Ccp_Hydro_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
					
					Assert.assertEquals(z12, w12);
				}
		      //..............................................................................................
				@Test(priority = 58)
				public void Compare_Ccp_Hydro_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
					
					Assert.assertEquals(z12, day12);
				}
		      //..............................................................................................
				@Test(priority = 59)
				public void Compare_Ccp_Hydro_Of_ZONE_Region_Wise_from_Service_Type_Wise() throws InterruptedException {
					
					Assert.assertEquals(z12, s12);
				}
//.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
				
				@Test(priority = 60)
				public void Compare_Ccp_FUEL_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
					
					Assert.assertEquals(z13, d13);
				}
				//..............................................................................................
				@Test(priority = 61)
				public void Compare_Ccp_FUEL_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
					
					Assert.assertEquals(z13, w13);
				}
		      //..............................................................................................
				@Test(priority = 62)
				public void Compare_Ccp_FUEL_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
					
					Assert.assertEquals(z13, day13);
				}
		      //..............................................................................................
				@Test(priority = 63)
				public void Compare_Ccp_FUEL_Of_ZONE_Region_Wise_from_Service_Type_Wise() throws InterruptedException {
					
					Assert.assertEquals(z13, s13);
				}
      //.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
				
				@Test(priority = 64)
				public void Compare_Ccp_plus_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
					
					Assert.assertEquals(z14, d14);
				}
				//..............................................................................................
				@Test(priority = 65)
				public void Compare_Ccp_plus_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
					
					Assert.assertEquals(z14, w14);
				}
		      //..............................................................................................
				@Test(priority = 66)
				public void Compare_Ccp_plus_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
					
					Assert.assertEquals(z14, day14);
				}
		      //..............................................................................................
				@Test(priority = 67)
				public void Compare_Ccp_plus_Of_ZONE_Region_Wise_from_Service_Type_Wise() throws InterruptedException {
					
					Assert.assertEquals(z14, s14);
				}
 //.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
				
				@Test(priority = 68)
				public void Compare_Total_Intrested3_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
					
					Assert.assertEquals(z15, d15);
				}
				//..............................................................................................
				@Test(priority = 69)
				public void Compare_Total_Intrested3_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
					
					Assert.assertEquals(z15, w15);
				}
		      //..............................................................................................
				@Test(priority = 70)
				public void Compare_Total_Intrested3_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
					
					Assert.assertEquals(z15, day15);
				}
		      //..............................................................................................
				@Test(priority = 71)
				public void Compare_Total_Intrested3_Of_ZONE_Region_Wise_from_Service_Type_Wise() throws InterruptedException {
					
					Assert.assertEquals(z15, s15);
				}
//.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
				
				@Test(priority = 72)
				public void Compare_Yes3_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
					
					Assert.assertEquals(z16, d16);
				}
				//..............................................................................................
				@Test(priority = 73)
				public void Compare_Yes3_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
					
					Assert.assertEquals(z16, w16);
				}
		      //..............................................................................................
				@Test(priority = 74)
				public void Compare_Yes3_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
					
					Assert.assertEquals(z16, day16);
				}
		      //..............................................................................................
				@Test(priority = 75)
				public void Compare_Yes3_Of_ZONE_Region_Wise_from_Service_Type_Wise() throws InterruptedException {
					
					Assert.assertEquals(z16, s16);
				}
//.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
				
				@Test(priority = 76)
				public void Compare_Platinum2_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
					
					Assert.assertEquals(z17, d17);
				}
				//..............................................................................................
				@Test(priority = 77)
				public void Compare_Platinum2_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
					
					Assert.assertEquals(z17, w17);
				}
		      //..............................................................................................
				@Test(priority = 78)
				public void Compare_Platinum2_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
					
					Assert.assertEquals(z17, day17);
				}
		      //..............................................................................................
				@Test(priority = 79)
				public void Compare_Platinum2_Of_ZONE_Region_Wise_from_Service_Type_Wise() throws InterruptedException {
					
					Assert.assertEquals(z17, s17);
				}
//.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
				
				@Test(priority = 80)
				public void Compare__Royal_Platinum2_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
					
					Assert.assertEquals(z18, d18);
				}
				//..............................................................................................
				@Test(priority = 81)
				public void Compare_Royal_Platinum2_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
					
					Assert.assertEquals(z18, w18);
				}
		      //..............................................................................................
				@Test(priority = 82)
				public void Compare_Royal_Platinum2_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
					
					Assert.assertEquals(z18, day18);
				}
		      //..............................................................................................
				@Test(priority = 83)
				public void Compare_Royal_Platinum2_Of_ZONE_Region_Wise_from_Service_Type_Wise() throws InterruptedException {
					
					Assert.assertEquals(z18, s18);
				}
//.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
				
				@Test(priority = 84)
				public void Compare__Total_intrest_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
					
					Assert.assertEquals(z19, d19);
				}
				//..............................................................................................
				@Test(priority = 85)
				public void Compare_Total_intrest_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
					
					Assert.assertEquals(z19, w19);
				}
		      //..............................................................................................
				@Test(priority = 86)
				public void Compare_Total_intrest_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
					
					Assert.assertEquals(z19, day19);
				}
		      //..............................................................................................
				@Test(priority = 87)
				public void Compare_Total_intrest_Of_ZONE_Region_Wise_from_Service_Type_Wise() throws InterruptedException {
					
					Assert.assertEquals(z19, s19);
				}
//.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
				
				@Test(priority = 88)
				public void Compare__YES4_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
					
					Assert.assertEquals(z20, d20);
				}
				//..............................................................................................
				@Test(priority = 89)
				public void Compare_YES4_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
					
					Assert.assertEquals(z20, w20);
				}
		      //..............................................................................................
				@Test(priority = 90)
				public void Compare_YES4_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
					
					Assert.assertEquals(z20, day20);
				}
		      //..............................................................................................
				@Test(priority = 91)
				public void Compare_YES4_Of_ZONE_Region_Wise_from_Service_Type_Wise() throws InterruptedException {
					
					Assert.assertEquals(z21, s21);
				}
//.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
				
				@Test(priority = 92)
				public void Compare__CCP_Hydro2_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
					
					Assert.assertEquals(z21, d21);
				}
				//..............................................................................................
				@Test(priority = 93)
				public void Compare_CCP_Hydro2_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
					
					Assert.assertEquals(z21, w21);
				}
		      //..............................................................................................
				@Test(priority = 94)
				public void Compare_CCP_Hydro2_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
					
					Assert.assertEquals(z21, day21);
				}
		      //..............................................................................................
				@Test(priority = 95)
				public void Compare_CCP_Hydro2_Of_ZONE_Region_Wise_from_Service_Type_Wise() throws InterruptedException {
					
					Assert.assertEquals(z21, s21);
				}
//.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
				
				@Test(priority = 96)
				public void Compare__CCP_Fuel2_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
					
					Assert.assertEquals(z22, d22);
				}
				//..............................................................................................
				@Test(priority = 97)
				public void Compare_CCP_Fuel2_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
					
					Assert.assertEquals(z22, w22);
				}
		      //..............................................................................................
				@Test(priority = 98)
				public void Compare_CCP_Fuel2_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
					
					Assert.assertEquals(z22, day22);
				}
		      //..............................................................................................
				@Test(priority = 99)
				public void Compare_CCP_Fuel2_Of_ZONE_Region_Wise_from_Service_Type_Wise() throws InterruptedException {
					
					Assert.assertEquals(z22, s22);
				}
//.>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
				
				@Test(priority = 100)
				public void Compare__CCP_PLUS2_Of_ZONE_Region_Wise_from_Dealer_parent_Group_Wise() throws InterruptedException {
					
					Assert.assertEquals(z23, d23);
				}
				//..............................................................................................
				@Test(priority = 101)
				public void Compare_CCP_PLUS2_Of_ZONE_Region_Wise_from_workshop__Wise() throws InterruptedException {
					
					Assert.assertEquals(z23, w23);
				}
		      //..............................................................................................
				@Test(priority = 102)
				public void Compare_CCP_PLUS2_Of_ZONE_Region_Wise_from_Day_Wise() throws InterruptedException {
					
					Assert.assertEquals(z23, day23);
				}
		      //..............................................................................................
				@Test(priority = 103)
				public void Compare_CCP_PLUS2_Of_ZONE_Region_Wise_from_Service_Type_Wise() throws InterruptedException {
					
					Assert.assertEquals(z23, s2);
				}




}
