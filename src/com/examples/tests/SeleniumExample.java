package com.examples.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumExample {

	public SeleniumExample() {
		// TODO Auto-generated constructor stub
	}

	static WebDriver driver;
	static WebDriverWait wait;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public void helloWorld() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/mercuryregister.php");

		WebElement country = driver.findElement(By.name("country"));
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(country));

		Select countryOption = new Select(country);
		countryOption.selectByIndex(2);
	}

	public static void alert() {

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/V4/index.php");
		WebElement submit = driver.findElement(By.xpath("//input[@type='submit']"));

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(submit));
		submit.click();

		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		alert.accept();

	}

	public void login() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://newtours.demoaut.com/mercurywelcome.php");

		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());

		WebElement searchField = driver.findElement(By.linkText("Flights"));

		wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(searchField));

		WebElement userName = driver.findElement(By.xpath("//tbody/tr/td/input[@name='userName']"));
		WebElement password = driver.findElement(By.xpath("//tbody/tr/td/input[@name='password']"));
		wait.until(ExpectedConditions.visibilityOf(userName));

		userName.sendKeys("test");
		password.sendKeys("test");

		WebElement submit = driver.findElement(By.name("login"));
		submit.click();
	}
}
