package com.smartbear.page_objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "ctl00_MainContent_username")
	public WebElement textBoxUserName;

	@FindBy(id = "ctl00_MainContent_password")
	public WebElement password;

	@FindBy(id = "ctl00_MainContent_login_button")
	public WebElement loginButton;

	@FindBy(tagName = "h1")
	public WebElement header;

	@FindBy(id = "ctl00_MainContent_status")
	public WebElement errorMessage;

	public void enterUserName(String uname) {
		textBoxUserName.clear();
		textBoxUserName.sendKeys(uname);
	}

	public void enterPassword(String pwd) {
		password.clear();
		password.sendKeys(pwd);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public String getHeader() {
		return header.getText();
	}

	public String getErrorMessage() {
		return errorMessage.getText();
	}
	public boolean ifUserWasLoggedIn(String confirmationText) {
		return driver.getPageSource().contains(confirmationText);
	}

}
