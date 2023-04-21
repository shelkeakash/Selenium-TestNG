package Day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handlingCheckboxes {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Select one specific checkbox
		//driver.findElement(By.xpath("//input[@id='monday']")).click();
		
		//Select all checkboxes
		
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		
		System.out.println("No. of checkboxes are: " + checkboxes.size());// Total no. of checkboxes
		
		//Select all checkboxes

		for(int i=3;i<checkboxes.size();i++) {
			checkboxes.get(i).click();

		}

		for(int i=0;i<checkboxes.size();i++) {
			if(checkboxes.get(i).isSelected())
			checkboxes.get(i).click();

		}

	}
}
