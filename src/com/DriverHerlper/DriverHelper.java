package com.DriverHerlper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverHelper {

	public static WebDriver getDriver(String browserName) {
		String OSNAME = System.getProperty("os.name").toLowerCase();
		String path = System.getProperty("user.dir");

		switch (OSNAME) {
		case "linux":
			System.setProperty("webdriver.chrome.driver", path + "/drivers/linux32/chromedriver");
			System.setProperty("webdriver.gecko.driver", path + "/drivers/linux32/geckodriver");
			break;
		case "windows":
			System.setProperty("webdriver.chrome.driver", path + "/drivers/windows32/chromedriver.exe");
			System.setProperty("webdriver.gecko.driver", path + "/drivers/windows32/geckodriver.exe");
			break;
		default:
			break;
		}

		if (browserName.equals("chrome")) {
			return new ChromeDriver();
		} else {
			return new FirefoxDriver();
		}
	}
}