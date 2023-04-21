package testNG;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstTest {
	 WebDriver driver;
	 
  //@BeforeClass
  @Test(priority=1)
  public void openApp() 
  {
	  ChromeOptions option = new ChromeOptions();
      option.addArguments("--remote-allow-origins=*");
	  WebDriverManager.chromedriver().setup();
	  driver = new ChromeDriver(option);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
	  driver.manage().window().maximize();
	  driver.manage().deleteAllCookies();
	  
      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  
  }
  @Test(priority=2)
  public void login() {
	  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
	  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
	  driver.findElement(By.xpath("//button[@type='submit']")).click();
  }
  
  //@AfterClass
  @Test(priority=3)
  public void close() {
	  driver.quit();
	  
  }
}
