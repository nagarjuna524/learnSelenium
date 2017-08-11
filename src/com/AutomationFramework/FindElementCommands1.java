package com.AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FindElementCommands1 {
	public static void main(String[] args) {
		// Create a new instance of the FireFox driver
		String path = System.getProperty("user.dir");
		String chromeDriverPath = path + "/drivers/chromedriver";
		String geckoDriverPath = path +  "/drivers/geckodriver";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		System.setProperty("webdriver.gecko.driver", geckoDriverPath);
		
		WebDriver driver = new FirefoxDriver();

		// Launch the ToolsQA WebSite
		driver.get("http://toolsqa.wpengine.com/Automation-practice-form/");

		// Type Name in the FirstName text box
		driver.findElement(By.name("firstname")).sendKeys("Lakshay");

		// Type LastName in the LastName text box
		driver.findElement(By.name("lastname")).sendKeys("Sharma");

		// Click on the Submit button
		driver.findElement(By.id("submit")).click();
	}
}