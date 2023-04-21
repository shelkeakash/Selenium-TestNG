package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	public WebDriver driver;
	//Constructor
	LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	//Locators
	By logo_img = By.xpath("//img[@alt='company-branding']");
	By inputUsername = By.xpath("//input[@placeholder='Username']");
	By inputPassword = By.xpath("//input[@placeholder='Password']");
	By btnLogin = By.xpath("//button[@type='submit']");
	
	//Action Methods
	
	public void setUserName(String username) {
		driver.findElement(inputUsername).sendKeys(username);
	}
	
	public void setPassword(String password) {
		driver.findElement(inputPassword).sendKeys(password);
	}
	
	public void clickLogin() {
		driver.findElement(btnLogin).click();
	}
	
	public boolean checkLogo() {
		boolean status =driver.findElement(logo_img).isDisplayed();
		return status;
	}

}
