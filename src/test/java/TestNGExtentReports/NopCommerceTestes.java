package TestNGExtentReports;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(TestNGExtentReports.ExtentReportManager.class)
public class NopCommerceTestes {
	
	WebDriver driver;
	
	@BeforeClass()
	void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com/");
		
	}
	
	@Test(priority=1)
	void testLogo()
	{
		try {
		boolean status = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		Assert.assertEquals(status, true);
		}
		catch(NoSuchElementException e) {
			Assert.assertTrue(false);
		}
	}
	
	@Test(priority=2)
	void testLogin() throws InterruptedException {
		
		try {
		driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("test@test.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("test@123");
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
		Thread.sleep(3000);
		
		boolean status = driver.findElement(By.xpath("//a[@class='ico-account']")).isDisplayed();
		Assert.assertEquals(status, false);
		}
		catch(Exception e) {
			Assert.fail();
		}
	}
	
	@Test(priority=3,dependsOnMethods = {"testLogin"})
	void testLogout() throws InterruptedException {
		driver.findElement(By.xpath("//a[@class='ico-logout']")).click();
		Thread.sleep(3000);
		boolean status = driver.findElement(By.xpath("//a[@class='ico-register']")).isDisplayed();
		Assert.assertEquals(status, true);
		
	}
	
	
	@AfterClass()
	void tearDown()
	{
		driver.quit();
		
	}

}
