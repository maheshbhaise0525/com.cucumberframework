package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;
	public LoginPage(WebDriver rDriver) {
		ldriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(xpath="//input[@id='Email']")
			WebElement email;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement Loginbtn;
	
	@FindBy(linkText="Logout")
	WebElement Logoutbtn;
	
	public void enterEmail(String emailadd) {
		email.clear();
		email.sendKeys(emailadd);
	}
	
	public void enterPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickLogin() {
		Loginbtn.click();
	}
	
	public void clickLogout() {
		Logoutbtn.click();
	}

}
