package com.smartbear.page_objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteOrderPage {
	
	WebDriver driver;

	public DeleteOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "ctl00_MainContent_username")
	private WebElement textBoxUserName;
	@FindBy(id = "ctl00_MainContent_password")
	private WebElement password;
	@FindBy(id = "ctl00_MainContent_login_button")
	private WebElement loginButton;
	@FindBy(tagName = "h1")
	private WebElement header;
	@FindBy(id = "ctl00_MainContent_orderGrid")
	private WebElement tableElement;

	@FindBy(xpath = "//input[@type='checkbox']")
	private List<WebElement> listOfCheckBoxes;
	@FindBy (xpath ="//input[@type='checkbox']" )
	private WebElement checkBox; 
	@FindBy(id = "ctl00_MainContent_btnDelete")
	private WebElement deleteButton;
	private int numberOfRowsBeforedelete;
	private int numberOfAfterdelete;

	public void enterUserName(String uname) {
		textBoxUserName.sendKeys(uname);
	}

	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public String getHeader() {
		return header.getText();
	}

	public boolean isTableDisplay() {
		return tableElement.isDisplayed();
	}
	public int countNumberOfRows() {
		return listOfCheckBoxes.size();
	}
	
	public void clickOnCheckBox() {
		checkBox.click();
	}

	public void clickOnDeleteButton() {
		deleteButton.click();
		
	}
	
	
	
	

}
