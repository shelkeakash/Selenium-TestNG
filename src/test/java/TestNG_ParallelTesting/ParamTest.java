package TestNG_ParallelTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParamTest {
	
	WebDriver driver;
	
	@BeforeClass
	@Parameters({"browser"})
	void setup(String br) throws InterruptedException {
		
		if(br.equals("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		
		else if(br.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		else{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		
	}
	
	@Test(priority=1)
	void testLogo() {
		
		try {
		boolean logo = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(logo, true);
		}
		
		catch(Exception e) {
			Assert.fail();
		}
	}
	
	@Test(priority=2)
	void testHomePageTitle() {
		
		Assert.assertEquals(driver.getTitle(), "OrangeHRM", "Title does not match");
		
	}
	
	@AfterClass
	void tearDown() {
		driver.quit();
	}

}
