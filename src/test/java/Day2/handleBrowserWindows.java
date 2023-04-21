package Day2;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handleBrowserWindows {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		//Approach 1 to handle two window IDs
		Set<String> windowIDs= driver.getWindowHandles();//stores 2 window IDs
		
		//Approach 1 to handle two window IDs using list collection
	/*	List <String>windowIDsList = new ArrayList(windowIDs); //Set is converted to List to get individual window ids since there are only 2 ids
		
		String parentWindowID = windowIDsList.get(0);
		String childWindowID = windowIDsList.get(1);
		
		//switch to child window
		
		driver.switchTo().window(childWindowID);
		
		driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
		
		driver.switchTo().window(parentWindowID);
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
*/
		//Approach 2 to handle multiple window IDs using looping statement
		
		for(String winid:windowIDs) {
			
			String title = driver.switchTo().window(winid).getTitle();
			
			if(title.equals("OrangeHRM HR Software | Free &amp; Open Source HR Software | HRMS | HRIS | OrangeHRM")) {
				driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
				
			}
			
		}
	}

}
