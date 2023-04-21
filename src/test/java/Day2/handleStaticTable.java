package Day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handleStaticTable {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//1. find total no. of rows
		
		int rowCount = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("No. of rows in table are: " + rowCount);
		System.out.println("-------------------------------------");
		
		//2. find total no. of columns
		
		int columnCount = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("No. of columns in table are: " + columnCount);
		System.out.println("-------------------------------------");
		
		//3. Read specific row and column data
		
		String data = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		System.out.println("Data in table is " + data);
		System.out.println("-------------------------------------");
		//4. Read data from all the rows & columns
		
		for(int i = 2; i<=rowCount; i++) {
			
			for(int j = 1; j<= columnCount; j++) {
				String value = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+j+"]")).getText();
				//Parameterization of xpath
				System.out.print(value + "    ");
				
			}
			System.out.println("-------------------------------------");
			
			
		}
		
		//5. Print bookname whose author name is Amit
		
			for(int i = 2; i<=rowCount; i++) {
		
				String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[2]")).getText();
				//Parameterization of xpath
				System.out.print(author + "    ");
				
				if(author.equals("Amit")) {
					String bookname = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[1]")).getText();	
					System.out.print(bookname + "    ");
				}
			
			System.out.println("   ");
		
		//6. Find sum of prices of all the books
		
	}
}
}
