package com.AutomationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

	public static WebDriver driver;

	public static void main(String[] args) {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.gecko.driver", path + "/drivers/geckodriver");
		driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://store.demoqa.com");

		WebElement element = driver.findElement(By.linkText("Product Category"));

		Actions action = new Actions(driver);

		action.moveToElement(element).build().perform();

		driver.findElement(By.linkText("iPads")).click();

	}

}