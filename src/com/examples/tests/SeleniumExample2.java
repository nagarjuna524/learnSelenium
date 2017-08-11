package com.examples.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumExample2 {

	public SeleniumExample2() {
		// TODO Auto-generated constructor stub
	}

	static WebDriver driver;
	static WebDriverWait wait;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	actionMethod();
	}

	public static void actionMethod () {
		
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		
		
		WebElement mainMenu = driver.findElement(By.xpath("//div[@class='gb_Ec']/a"));
		
		// Mouse Hover
		Actions actions = new Actions(driver);
		actions.moveToElement(mainMenu);
		actions.build().perform();
		
		// Tool tip
		Actions toolTip = new Actions(driver);
		toolTip.moveToElement(mainMenu).perform();
		String actualtoolTipText = mainMenu.getAttribute("title");
		System.out.println(actualtoolTipText);
		
		// drag and drop
		new Actions(driver).dragAndDropBy(mainMenu, 10, 10).build().perform();
		
		// Frames
		driver.switchTo().frame(1);
		driver.switchTo().frame("frame");
		driver.switchTo().frame(driver.findElement(By.tagName("frame")));
	}
	
	/*
	 * Basic login method
	 */
	public void login() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");

		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

		WebElement searchField = driver.findElement(By.linkText("Flights"));

		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(searchField));

		WebElement userName = driver.findElement(By
				.xpath("//tbody/tr/td/input[@name='userName']"));
		WebElement password = driver.findElement(By
				.xpath("//tbody/tr/td/input[@name='password']"));
		wait.until(ExpectedConditions.visibilityOf(userName));

		userName.sendKeys("test");
		password.sendKeys("test");

		WebElement submit = driver.findElement(By.name("login"));
		submit.click();
	}
}
