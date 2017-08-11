/**
 * 
 */
package com.browsers;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author nagarjuna
 * 
 */
public class FirefoxSanityTest {

	/**
	 * 
	 */
	public FirefoxSanityTest() {

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String path = System.getProperty("user.dir");

		System.setProperty("webdriver.gecko.driver", path + "/drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();

		// System.setProperty("webdriver.chrome.driver", path +
		// "/drivers/chromedriver");
		// WebDriver driver = new FirefoxDriver();

		autoSuggestionGoogle(driver);
		// autoSuggestionMakeMyTrip(driver);

	}

	private static void autoSuggestionGoogle(WebDriver driver) {
		// Initialize browser

		// Open Google
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// WebElement element = driver.switchTo().activeElement();
		WebElement element = driver.findElement(By.xpath("//input[@title='Search']"));
		element.sendKeys("Guru99");
		List<WebElement> lstGoogle = driver.findElement(By.xpath("//ul[@role='listbox']"))
				.findElements(By.xpath("//li[@role='presentation']"));
		System.out.println(lstGoogle.size());
		for (int i = 0; i < lstGoogle.size(); i++) {
			System.out.println(lstGoogle.get(i).getText());
		}
		String textToSelect = "guru99 java";
		for (WebElement option : lstGoogle) {
			System.out.println(option.getText());
			if (option.getText().equals(textToSelect)) {
				System.out.println("Trying to select: " + textToSelect);
				option.click();
				break;
			}

		}
		// element.submit();
		System.out.println("Page title is: " + driver.getTitle());
		// getScreenShot(driver);

		// Close browser
		// driver.close();

	}
}