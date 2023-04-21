package Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handleDynamicTable {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/admin/index.php?route=common/login");
		
		//Login
		driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("demo");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("demo");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		//dialog box cose
		if(driver.findElement(By.xpath("//button[@class='btn-close']")).isDisplayed()) {
			
			driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		}
		//Navigate to customer
		driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
		driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();
		
		//Get the text for no. of pages
		String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
		
		int totalPages = Integer.parseInt(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));
		
		System.out.println("Total Pages are : " + totalPages);
		
		for(int i=1;i<=5;i++) {
			
			if(totalPages>1) {
				WebElement activepage = driver.findElement(By.xpath("//ul[@class='pagination']//li//*[text()="+i+"]"));
				System.out.println("Active page is: " + activepage.getText());
				if(i>2) {
				activepage.click();
				}
				Thread.sleep(5000);
			}
			
			int noofRows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			System.out.println("No. of rows are : " + noofRows);
			
			for(int j=1 ; j<=noofRows;j++) {
				
			String customerName = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+j+"]//td[2]")).getText();	
			String email = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+j+"]//td[3]")).getText();	
			String custGroup = driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+j+"]//td[4]")).getText();	
				
			System.out.println(customerName +"                "+ email +"                     "+ custGroup );	
			}
			
		}

		}
}
