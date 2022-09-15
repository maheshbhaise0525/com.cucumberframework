package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {

	WebDriver ldriver;
	public SearchCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath="//input[@id='SearchEmail']")
	WebElement emailadd;
	
	@FindBy(xpath="//button[@id='search-customers']")
	WebElement searchbtn;
	
	@FindBy(xpath="//table[@role='grid']")
	WebElement searchresult;
	
	@FindBy(xpath="//table[@id='customers-grid]//tbody/tr")
	List<WebElement> tableRows;
	
	/*
	 * @FindBy(xpath="//table[@id='customers-grid]//tbody/tr[1]/td")
	 * List<WebElement> tableColumns;
	 */
	
	@FindBy(xpath="//input[@id='SearchFirstName']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='SearchLastName']")
	WebElement lastName;
	
	public void enterEmailAdd(String email) {
		emailadd.sendKeys(email);
	}
	
	public void clickonSearch() {
		searchbtn.click();
	}
	
	public boolean searchCustomerByEmail(String email) {
		boolean found=false;
		//total no of rows in a grid
		int totalRows=tableRows.size();
		
		//total no of columns
		//int totalColumns=tableColumns.size();
		
		for(int i=1;i<=totalRows;i++) {
			WebElement webEmail=ldriver.findElement(By.xpath("//table[@id='customers-grid]//tbody/tr["+i+"]/td[2]"));
			String actualemailAdd=webEmail.getText();
			if(actualemailAdd.equals(email)) {
				found=true;
			}
		}
		
		
		return found;
	}
	
	
	
	//Action method to enter first name
	public void enterFirstName(String firstnametext) {
		firstName.sendKeys(firstnametext);
	}
	
	public void enterLastName(String lastnametext) {
		lastName.sendKeys(lastnametext);
	}
	
	public boolean searchCustomerByName(String name) {
		boolean found=false;
		//total no of rows in a grid
		int totalRows=tableRows.size();
		
		
		
		for(int i=1;i<=totalRows;i++) {
			WebElement webName=ldriver.findElement(By.xpath("//table[@id='customers-grid]//tbody/tr["+i+"]/td[3]"));
			String actualName=webName.getText();
			if(actualName.equals(name)) {
				found=true;
				break;
			}
		}
		
		
		return found;
	}
	
	
}


