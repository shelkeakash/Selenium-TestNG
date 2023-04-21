package TestNG_Parameterization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProvider_Demo {
	
	WebDriver driver;
	@BeforeClass
	void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	}
	
	@Test(dataProvider="dp")
	void testLogin(String email, String password) throws InterruptedException {
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
		
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
		
		Thread.sleep(3000);
		String exp_title = "nopCommerce demo store";
		String actual_title = driver.getTitle();
		
		Assert.assertEquals(exp_title, actual_title);
		
	}
	
	@AfterClass
	void tearDown() {
		driver.close();
	}
	
	@DataProvider(name="dp",indices= {0,2})
	String[][] loginData(){
		
		String data[][] = {
							{"abc@gmail.com","pass"},
							{"test@gmail.com","test"},
							{"shelkemisc@gmail.com","nopcommerce"},
							{"test@test.com","test"},
							{"qwerty@gmail.com","qwerty"}
						  };
		
		return data;
		
	}

}
