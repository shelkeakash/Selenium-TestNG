package Day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropdown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
        option.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(option);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Selenium");
		Thread.sleep(3000);
		List<WebElement> results = driver.findElements(By.xpath("//li[@class='sbct']//div[contains(@class,'wM6W7d')]//span"));

		System.out.println("List size is : " + results.size());
		for(int i=0;i< results.size();i++) {
			
			String text = results.get(i).getText();
			
			if(text.equals("selenium rc")) {
				results.get(i).click();
				break;
			}
		}
		driver.quit();
	}

}
