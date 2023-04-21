package POM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	public WebDriver driver;
	LoginPageWithPageFactory lp;
	
	@BeforeClass
	void setup() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	Thread.sleep(3000);
	}
	
	@Test(priority=1)
	void testLogo() {
		lp = new LoginPageWithPageFactory(driver);
		Assert.assertEquals(lp.checkLogo(), true);
	}
	
	@Test(priority=2)
	void testLogin() {
		lp.setUserName("Admin");
		lp.setPassword("admin123");
		lp.clickLogin();
		
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
	}
	
	@AfterClass
	void tearDown() {
		driver.quit();
	}
	
	
}
