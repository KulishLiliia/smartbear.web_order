package com.smartbear.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.smartbear.utilities.AppProperties;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	public static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null)
			driver = getActivedriver();
		return driver;
	}

	public static WebDriver getActivedriver() {
		String browserType = AppProperties.BROWSER_TYPE;
		switch (browserType) {
		case "chrome":
			driver = getChromeDriver();
			break;
		case "firefox":
			driver = getFirefoxDriver();
			break;
		case "heaadless":
			driver = getHeadlessChromeDriver();
			break;
		default:
			System.out.println("Browser type " + browserType + " invalid");
			break;

		}

		return driver;
	}

	public static ChromeDriver getChromeDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions crChromeOptions = new ChromeOptions();
		crChromeOptions.addArguments("--start-maximized");
		return new ChromeDriver(crChromeOptions);
	}

	public static ChromeDriver getHeadlessChromeDriver() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions crChromeOptions = new ChromeOptions();
		crChromeOptions.addArguments("--start-maximized");
		crChromeOptions.addArguments("--headless");
		return new ChromeDriver(crChromeOptions);
	}

	public static FirefoxDriver getFirefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		return new FirefoxDriver();
	}

	protected static void closeDriver() {
		if (driver != null) {
			driver.close();
			driver.quit();
			driver = null;
		}
	}

}
