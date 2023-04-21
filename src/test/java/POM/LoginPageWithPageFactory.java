package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageWithPageFactory{
	public WebDriver driver;
	//Constructor
	LoginPageWithPageFactory(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Web Elements Locators+identification
	
    @FindBy(xpath= "//img[@alt='company-branding']") 
    WebElement logo_img ;

    @FindBy(xpath="//input[@placeholder='Username']") 
	WebElement inputUsername;
	
    @FindBy(xpath="//input[@placeholder='Password']") 
    WebElement inputPassword; 
	
    @FindBy(xpath="//button[@type='submit']") 
    WebElement btnLogin;
	
	//Action Methods
	
	public void setUserName(String username) {
		inputUsername.sendKeys(username);
	}
	
	public void setPassword(String password) {
		inputPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public boolean checkLogo() {
		boolean status =logo_img.isDisplayed();
		return status;
	}

}
