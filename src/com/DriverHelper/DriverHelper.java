package com.DriverHelper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverHelper {

	public static WebDriver getDriver(String browserName) {
		String OSNAME = System.getProperty("os.name").toLowerCase();
		String PATH = System.getProperty("user.dir");

		if (OSNAME.contains("windows")) {
			System.setProperty("webdriver.chrome.driver", PATH + "/drivers/windows32/chromedriver235/chromedriver.exe"); // Supports Chrome v62-64
			System.setProperty("webdriver.gecko.driver", PATH + "/drivers/windows32/geckodriver.exe");
		} else if (OSNAME.contains("linux")) {
			System.setProperty("webdriver.chrome.driver", PATH + "/drivers/linux32/chromedriver");
			System.setProperty("webdriver.gecko.driver", PATH + "/drivers/linux32/geckodriver");
		} else {
			// TO DO
		}

		if (browserName.equals("chrome")) {
			return new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			return new FirefoxDriver();
		} else {
			return new ChromeDriver();
		}
	}
}