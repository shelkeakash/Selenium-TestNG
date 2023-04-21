package Day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class waits {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10)); // Explicit wait declaration
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		// Implicit Wait - applicable to every element in script
		// if element if available within 2 sec then it will not for 10 seconds 
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// Explicit wait usage - applicable to single element instead of all elements
		// WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10)); // Explicit wait declaration
		
		WebElement username = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		
		//Thread.sleep(2000);//This will make driver wait for 2 seconds even if element is available
		username.sendKeys("Admin");
		
		//driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.quit();
		
	

	}

}
