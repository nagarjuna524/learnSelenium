package com.examples.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PageObjectTest {

	WebDriver driver = new FirefoxDriver();

	/***
	 * Tests login functionality
	 * 
	 * http://www.seleniumeasy.com/selenium-tutorials/simple-page-object-model-framework-example
	 */
	public void loginTestCase() {
		driver.navigate().to("url");
		driver.findElement(By.name("signIn")).click();
		driver.findElement(By.id("username")).sendKeys("testuser");
		driver.findElement(By.id("password")).sendKeys("testpassword");
		driver.findElement(By.name("loginbtn")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("profile")));
		String Expected = driver.findElement(By.id("message")).getText();
		Assert.assertEquals(Expected, "Welcome");
	}

	/***
	 * Tests login functionality
	 */
//	 public void loginTestCase1() {
//	 // To go to home page
//	 homePage.gotoHomePage();
//	 //To click on SignIn link
//	 accountLoginPage = homePage.clickOnSignIn()
//	 //To verify if user is navigated to sign-in page
//	 Assert.assertTrue(accountLoginPage.verifyPage());
//	 //Login to the account
//	 accountLoginPage.userLogin(username,password);
//	 //To verify if user is navigated to user home page after successfull
//	 login
//	 Assert.assertTrue(userHomePage.verifyPage());
//	 }
}