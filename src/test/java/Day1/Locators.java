package Day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://automationexercise.com/products");
		
		driver.findElement(By.id("search_product")).sendKeys("T-Shirt");
		driver.findElement(By.xpath("//button[@id='submit_search']")).click();
		
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='single-products']"));
		System.out.println("No. of products: "+ products.size());
		
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("No. of images: "+ images.size());
		
		
	}

}
