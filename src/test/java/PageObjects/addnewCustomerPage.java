package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class addnewCustomerPage {
	
	WebDriver ldriver;
	//constructor
	public addnewCustomerPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(ldriver, this);
	}
	
	@FindBy(xpath="//a[@href='#']//p[contains(text(),'Customers')]")
	WebElement lnkCustomer_menu;
	
	@FindBy(xpath="//a[@href='/Admin/Customer/List']//p[contains(text(),'Customer')]")
	WebElement lnkCustomer_menuitem;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement btnAddnew;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//div[@class='k-multiselec-wrap k-floatwrap']")
	WebElement txtCustomerRoles;
	
	@FindBy(xpath="//li[contains(text(),'Adminstrators')]")
	WebElement listItemAdministrators;
	
	@FindBy(xpath="//li[contains(text(),'Registered')]")
	WebElement listItemRegistered;
	
	@FindBy(xpath="//li[contains(text(),'Guests')]")
	WebElement listItemGuests;
	
	@FindBy(xpath="//li[contains(text(),'Guests')]")
	WebElement listItemVendors;
	
	@FindBy(xpath="//*[@id='VendorId']")
	WebElement dropdownVendorMgr;
	
	@FindBy(id="Gender_Male")
	WebElement Male;
	
	@FindBy(id="Gender_Female")
	WebElement Female;
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='DateOfBirth']")
	WebElement txtDob;
	
	@FindBy(xpath="//input[@id='Company']")
	WebElement txtCompanyName;
	
	@FindBy(xpath="//textarea[@id='AdminComment']")
	WebElement txtAdmincontent;
	
	@FindBy(xpath="//button[@type='submit'][2]")
	WebElement btnsave;
	
	//Actions methods for web elements
	
	public String getPageTitle() {
		return ldriver.getTitle();
	}
	
	public void clickCustomersMenu() {
		lnkCustomer_menu.click();
	}
	
	public void clickCustomersMenuItem() {
		lnkCustomer_menuitem.click();
	}
	
	public void clickAddnew() {
		btnAddnew.click();
	}
	
	public void enterEmail(String email) {
		txtEmail.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void enterFirstName(String firstname) {
		txtFirstName.sendKeys(firstname);
	}
	
	public void enterLastName(String lastname) {
		txtLastName.sendKeys(lastname);
	}
	
	public void enterGender(String gender) {
		if(gender.equals("Male")) {
			Male.click();
		}else if(gender.equals("Female")){
			Female.click();
		}else {
			Male.click();
		}
		
		
	}
	
	public void enterManagerofVendor(String value) {
		Select drp=new Select(dropdownVendorMgr);
		drp.selectByVisibleText(value);
	}
	
	
	public void enterDob(String dob) {
		txtDob.sendKeys(dob);
	}
	
	public void enterCompany(String companyname) {
		txtCompanyName.sendKeys(companyname);
	}
	
	public void enterAdminComment(String admincomment) {
		txtAdmincontent.sendKeys(admincomment);
	}
	
	public void clicksave() {
		btnsave.click();
		//JavascriptExecutor js=(JavascriptExecutor)ldriver;
		//js.executeScript("documet.getElementByXpath(//button[@name='save']).click();");
		
		//WebDriverWait wait=new WebDriverWait(ldriver, 30);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@name='save']"))).click();
	}

}
