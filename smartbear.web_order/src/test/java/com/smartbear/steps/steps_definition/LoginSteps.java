package com.smartbear.steps.steps_definition;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.smartbear.page_objects.LoginPage;
import com.smartbear.steps.steps_definition.LoginSteps;
import com.smartbear.utilities.DriverFactory;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps extends DriverFactory{
	private Logger logger = Logger.getLogger(LoginSteps.class);
	private WebDriver driver;
	public LoginSteps() {
		super();
		this.driver=super.getDriver();
	}

	LoginPage lg = new LoginPage(getDriver());



	@When("User enters Username and Password")
	public void user_enters_Username_and_Password() {
		
		logger.info("This is step class");
//		
//		driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
//		driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
//		driver.findElement(By.id("ctl00_MainContent_login_button")).click();
	lg.enterUserName("Tester");
	lg.enterPassword("test");
	
	}

	@When("User clicks on Login button")
	public void user_clicks_on_Login_button() {
	lg.clickLoginButton();
	logger.info("User clicked on Login Button");
	}

	@Then("User is on Web Orders page")
	public void user_is_on_Web_Orders_page() {
		
	Assert.assertTrue("User was successfully Logged In", lg.ifUserWasLoggedIn("Welcome, Tester!"));
		
//		Assert.assertEquals("Web Orders", lg.getHeader());
	//	logger.info("User is on " + lg.getHeader() + " page");
	}

	@When("User enters {string} user name and {string} password")
	public void user_enters_user_name_and_password(String username, String password) {
		lg.enterUserName(username);
		lg.enterPassword(password);
	}

	@Then("User should see error message {string}")
	public void user_should_see_error_message(String errorMessage) {
		
		String actualErrorMessage = lg.getErrorMessage();
	//	Assert.assertTrue("Error message : Actual  - "+ actualErrorMessage+ " , Expected - "+errorMessage, actualErrorMessage.concat(errorMessage));
		Assert.assertEquals(errorMessage, actualErrorMessage);
	}

}
