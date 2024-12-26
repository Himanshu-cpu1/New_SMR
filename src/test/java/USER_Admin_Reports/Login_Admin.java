package USER_Admin_Reports;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Admin {
	String customerFullName;
	public static WebDriver driver;
	public WebDriverWait wait;

	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setup() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://dealercrm.co.in/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(16, TimeUnit.SECONDS);

	}
	// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

		@Test(priority = 1)
		public void Username() throws InterruptedException {
			wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			WebElement Username = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id=\"mat-input-0\"]")));
			Username.sendKeys("081001admin00001");
			Thread.sleep(400);
		}

		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

		@Test(priority = 2)
		public void Password() throws InterruptedException {
			wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			WebElement password = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[id=\"mat-input-1\"]")));
			password.sendKeys("Maruti@123");

			Thread.sleep(400);
			WebElement login_Button = wait
					.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[type=\"submit\"]")));
			login_Button.click();

		}

		// >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

		@Test(priority = 3)
		public void Captcha() throws InterruptedException {
			wait = new WebDriverWait(driver, Duration.ofSeconds(15));

			// .................Enter The Captcha
			// ..................................................................
			WebElement Image = driver.findElement(By.xpath("(//*[@type=\"text\"])[1]"));

			String S1 = Image.getAttribute("value");
			System.out.println("captcha ::" + S1);

			Thread.sleep(500);
			WebElement captcha_field = driver.findElement(By.cssSelector("[placeholder=\"Enter the captcha..\"]"));
			captcha_field.sendKeys(S1);
		}

	//.....................................................................................................

		@Test(priority = 4)
		public void SUBMIT_Button() throws InterruptedException {
			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
			WebElement Submit = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()=\"Submit\"]")));
			Submit.click();
		
		}
//		// .....................................................................................................

	@Test(priority = 5)
	public void Remove_PouP() throws InterruptedException {

		WebElement PopUp = driver.findElement(By.xpath("(//*[@title=\"Close message\"])"));
		PopUp.click();
		Thread.sleep(500);

	}
}

