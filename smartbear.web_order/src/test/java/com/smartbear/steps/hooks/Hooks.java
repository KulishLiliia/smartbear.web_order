package com.smartbear.steps.hooks;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.smartbear.utilities.AppProperties;
import com.smartbear.utilities.DriverFactory;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends DriverFactory{
	private static final Logger logger = Logger.getLogger(Hooks.class);
	public WebDriver driver = getDriver();
	
	//@Before hooks runs before the first step of each scenario.
	
	@Before
	public void setUp() {
		driver.get(AppProperties.BASE_URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(AppProperties.IMPLICITLY_WAIT, TimeUnit.SECONDS);
		//driver.get(AppProperties.BASE_URL);
		logger.info("This is Hooks class");
	}
	
	@After 
	public void tearDown (Scenario scenario) {
		if(scenario.isFailed()) {
			TakesScreenshot takeScreenShot = (TakesScreenshot)driver;
			byte [] screenshot = takeScreenShot.getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
			
		}
	}

}
