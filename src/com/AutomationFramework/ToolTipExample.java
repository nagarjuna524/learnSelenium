package com.AutomationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ToolTipExample {

	public ToolTipExample() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String seleniumURL = "http://docs.seleniumhq.org";
		String jQueryURL = "https://jqueryui.com/tooltip/";
		WebDriver driver;

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		// toolTipCase1(driver, seleniumURL);
		toolTipCase2(driver, jQueryURL);
	}

	public static void toolTipCase1(WebDriver driver, String seleniumURL) {
		driver.navigate().to(seleniumURL);

		WebElement element = driver.findElement(By.cssSelector("#header>h1 a"));
		// Get tooltip text
		String toolTipText = element.getAttribute("title");
		System.out.println("Tool tip text present :- " + toolTipText);

		// Compare toll tip text
		Assert.assertEquals("Return to Selenium home page", toolTipText);
	}

	public static void toolTipCase2(WebDriver driver, String jQueryURL) {
		driver.navigate().to(jQueryURL);

		// As there is frame, we have to navigate to frame
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector(".demo-frame")));

		// Text box field, where we mouse hover
		WebElement element = driver.findElement(By.id("age"));

		// Use action class to mouse hover on Text box field
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		WebElement toolTipElement = driver.findElement(By.cssSelector(".ui-tooltip"));

		// To get the tool tip text and assert
		String toolTipText = toolTipElement.getText();
		Assert.assertEquals("We ask for your age only for statistical purposes.", toolTipText);
	}
	
	/**
	 * A convenience method that performs click-and-hold at the location of the
	 * source element, moves to the location of the target element, then
	 * releases the mouse.
	 *
	 * @param source
	 *            element to emulate button down at.
	 * @param target
	 *            element to move to and release the mouse at.
	 * @return A self reference.
	 * @author scherukuri
	 * @Date 11/02/2015
	 *
	 */
	public static void draganddrop(WebDriver driver, By source, By target) throws Exception {
		WebElement from = driver.findElement(source);
		WebElement to = driver.findElement(target);
		new Actions(driver).dragAndDrop(from, to).perform();
	}
}