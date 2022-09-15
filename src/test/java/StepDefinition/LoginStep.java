package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObjects.LoginPage;
import PageObjects.SearchCustomerPage;
import PageObjects.addnewCustomerPage;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginStep {
	
	public WebDriver driver;
	public LoginPage loginpg;
	public addnewCustomerPage addnewCustPg;
	public SearchCustomerPage searchCustPg;

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
	    //WebDriverManager.chromedriver();
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\mahesh\\chromedriver_win32\\chromedriver.exe");
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    loginpg=new LoginPage(driver);
	    addnewCustPg=new addnewCustomerPage(driver);
	    searchCustPg=new SearchCustomerPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
	   
		driver.get(url);
	}

	@And("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
	   
		loginpg.enterEmail(email);
	    loginpg.enterPassword(password);
	}

	@When("Click on login")
	public void click_on_login() {
	    loginpg.clickLogin();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String exptected) {
	    String actual=driver.getTitle();
	    if(actual.equals(exptected)) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}

	@When("User click on logout link")
	public void user_click_on_logout_link() {
	    loginpg.clickLogout();
	}

	@Then("close browser")
	public void close_browser() {
	    driver.close();
	}
	
	
	//add new customers**************************************************************************
	
	
	

	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	   String actual=addnewCustPg.getPageTitle();
	   String expected="Dashboard / nopCommerce administration";
	   if(actual.equals(expected)) {
		   Assert.assertTrue(true);
	   }else {
		   Assert.assertTrue(false);
	   }
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() {
	    addnewCustPg.clickCustomersMenu();
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() {
	    addnewCustPg.clickCustomersMenuItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() {
	    addnewCustPg.clickAddnew();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
	    String actual1=addnewCustPg.getPageTitle();
	    String expected1="Add a new customer / nopCommerce administration";
	    if(actual1.equals(expected1)) {
	    	Assert.assertTrue(true);
	    }else {
	    	Assert.assertTrue(false);
	    }
	}

	@When("User enter customer info")
	public void user_enter_customer_info() {
	   addnewCustPg.enterEmail("test12@gmail.com");
	   addnewCustPg.enterPassword("testpass");
	   addnewCustPg.enterFirstName("first");
	   addnewCustPg.enterLastName("last");
	   addnewCustPg.enterGender("Male");
	   addnewCustPg.enterDob("05/01/1994");
	   addnewCustPg.enterCompany("TCS");
	   addnewCustPg.enterAdminComment("ok");
	   addnewCustPg.enterManagerofVendor("Manager");
	   
	}

	@When("click on Save button")
	public void click_on_save_button() {
	    addnewCustPg.clicksave();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedcofirm) {
		String bodytag=driver.findElement(By.tagName("Body")).getText();
		if((bodytag.contains(expectedcofirm))) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
	    
	}
	//Search By Email********************************************************************
	
	@When("Enter customer Email")
	public void enter_customer_email() {
	    searchCustPg.enterEmailAdd(	"james_pan@nopCommerce.com");
	}

	@When("Click on search button")
	public void click_on_search_button() {
	    searchCustPg.clickonSearch();
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
	   String expectedEmail="james_pan@nopCommerce.com";
	   Assert.assertTrue(searchCustPg.searchCustomerByEmail(expectedEmail));
//	   if(searchCustPg.searchCustomerByEmail(expectedEmail)==true) {
//		   Assert.assertTrue(true);
//	   }else {
//		   Assert.assertTrue(false);
//	   }
	}
	
	//search by customer name*******************************************************************
	
	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
	   searchCustPg.enterFirstName("Victoria");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() {
	    searchCustPg.enterLastName("Terces");
	}

	@Then("user should found Name in the search table")
	public void user_should_found_name_in_the_search_table() {
	   
		String expectedName="Victoria Terces";
		   
		
		  if(searchCustPg.searchCustomerByName(expectedName)==true) { 
		  Assert.assertTrue(true);  
		  }else { 
			  Assert.assertTrue(false); 
			  }
		  }
		 	
	

}
