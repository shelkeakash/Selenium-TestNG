package Day4;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FixedDepositCalculator {

	public static void main(String[] args) throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html?classic=true");
		
		String file = System.getProperty("user.dir")+"\\testdata\\caldata.xlsx";
		
		int noofRows = XLUtils.getRowCount(file, "Sheet1");
		
		for(int i=1 ;i<=noofRows;i++) 
		{
			//read data from excel
			
			String princ = XLUtils.getCellData(file, "Sheet1", i, 0);
			String roi = XLUtils.getCellData(file, "Sheet1", i, 1);
			String per1 = XLUtils.getCellData(file, "Sheet1", i, 2);
			String per2 = XLUtils.getCellData(file, "Sheet1", i, 3);
			String freq = XLUtils.getCellData(file, "Sheet1", i, 4);
			String exp_maturity = XLUtils.getCellData(file, "Sheet1", i, 5);	
			
			
			//pass the data to app
			
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(princ);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(roi);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(per1);
			WebElement dropdown_per2 = driver.findElement(By.xpath("//select[@id='tenurePeriod']"));
			Select dropdownOptions = new Select(dropdown_per2);
			dropdownOptions.selectByVisibleText(per2);
			
			WebElement dropdown_freq = driver.findElement(By.xpath("//select[@id='frequency']"));
			Select dropdownOptions_freq = new Select(dropdown_freq);
			dropdownOptions_freq.selectByVisibleText(freq);
			
			driver.findElement(By.xpath("//img[@src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']")).click();
			
			String maturity = driver.findElement(By.xpath("//span[@id='resp_matval']")).getText();
			
			XLUtils.setCellData(file, "Sheet1", i, 6, maturity);
			
			//validation and update result in excel
			String app_maturity = XLUtils.getCellData(file, "Sheet1", i, 6);
			
			if(Double.parseDouble(app_maturity) == Double.parseDouble(exp_maturity)) {
				XLUtils.setCellData(file, "Sheet1", i, 7, "Pass");
				XLUtils.fillGreenColor(file, "Sheet1", i, 7);
			}
			else {
				XLUtils.setCellData(file, "Sheet1", i, 7, "Fail");
				XLUtils.fillRedColor(file, "Sheet1", i, 7);
			}
			
			driver.findElement(By.xpath("//img[@class='PL5']")).click();
			
		}
		driver.quit();
	}

}
