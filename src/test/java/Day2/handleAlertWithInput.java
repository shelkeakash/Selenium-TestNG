package Day2;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handleAlertWithInput {
	
public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		mywait.until(ExpectedConditions.alertIsPresent());
		
		Alert alertwindow = driver.switchTo().alert();
		
		alertwindow.sendKeys("This is input in alert");
		alertwindow.accept();
		
		//System.out.println("Alert window text is " + alertwindow.getText());
		
		//alertwindow.accept();
		//alertwindow.dismiss();
		
	}

}
