package Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 Launch URL
 Login - orange CRM
 Enter credentials
 verify title of page
 close browser
 */
public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		
//		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		Thread.sleep(2000);
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(2000);
		String title = driver.getTitle();
		
		if(title.equals("OrangeHRM")) {
			driver.quit();
		}
		
		
		
	}

}
