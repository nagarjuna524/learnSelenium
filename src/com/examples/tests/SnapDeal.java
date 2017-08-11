package com.examples.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SnapDeal {

	static WebDriver driver;
	static WebDriverWait wait;
	static final String EXPECTED_TITLE = "Online Shopping India: Shop Online for Electronics, Mobile, Fashion & Home at Snapdeal";
	static final String CAMERA_LENSE_PAGE_TITLE = "Camera Lens - Buy SLR Camera Lenses Online for Canon, Nikon, Sigma - Snapdeal.com ";
	static final String SITE_URL = "http://www.snapdeal.com/";

	public static void main(String[] args) throws InterruptedException {
		// System.setProperty("webdriver.chrome.driver",
		// "/Users/vdama/Documents/workspace/chromedriver");
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);

		Actions act = new Actions(driver);
		// open main url
		driver.get(SITE_URL);
		// Maximize the browser
		driver.manage().window().maximize();
		// Verify the correct url opened in the browser
		String getTitle = driver.getTitle();
		Assert.assertEquals(getTitle, EXPECTED_TITLE);

		
		
		
		String electronics1 = "//div[@class='leftNavWrapperRevamp']//li[3]";
		WebElement electronics = driver.findElement(By.xpath(electronics1));

		wait.until(ExpectedConditions.visibilityOf(electronics));
		electronics.click();
		WebElement cameras = driver.findElement(By
				.xpath("//span[contains(text(), 'Cameras')]"));
		wait.until(ExpectedConditions.visibilityOf(cameras));
		act.moveToElement(cameras).build().perform();
		WebElement cameraLenses = driver.findElement(By
				.linkText("Camera Lenses"));
		wait.until(ExpectedConditions.visibilityOf(cameraLenses));
		cameraLenses.click();
		WebElement viewAllButton = driver.findElement(By
				.cssSelector("a[class*='color-white']"));
		wait.until(ExpectedConditions.visibilityOf(viewAllButton));
		viewAllButton.click();
		WebElement cameraLensePage = driver.findElement(By
				.cssSelector("#products-main4"));
		wait.until(ExpectedConditions.visibilityOf(cameraLensePage));
		// scroll to down
		WebElement price = driver.findElement(By
				.xpath("//i[@filtername='Price']"));
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView();", price);
		price.click();
		// WebElement source =
		// driver.findElement(By.xpath("//div[@id='slider-Price-id']/div[contains(@class, 'ui-slider-range')]"));
		// int width = source.getSize().getWidth();
		// act.dragAndDropBy(source, ((width * 25) / 100), 0).build().perform();
		WebElement priceTaginputTo = driver.findElement(By
				.id("price-tag-input-to"));
		wait.until(ExpectedConditions.visibilityOf(priceTaginputTo));
		priceTaginputTo.clear();
		// priceTaginputTo.sendKeys("20000");
		driver.findElement(By.cssSelector(".price-tag-go")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement customerRating = driver.findElement(By
				.cssSelector("i[filtername*='avgRating']"));
		customerRating.click();
		driver.findElement(By.xpath("//label[contains(@for, 'avgRating-4.0')]"))
				.click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement fiveRatingProduct = driver
				.findElement(By
						.xpath("//div[@id='prodDetails']//div[@ratings='5.0']/../../p[@class='product-title']/../../a[contains(@class, 'prodLink')]"));
		driver.navigate().to(fiveRatingProduct.getAttribute("href").toString());
		WebElement addtoCart = driver.findElement(By.id("add-cart-button-id"));
		addtoCart.click();
		driver.switchTo().activeElement();
		WebElement pinValue = driver.findElement(By.id("pincode-value"));
		wait.until(ExpectedConditions.visibilityOf(pinValue));
		// pinValue.sendKeys("560016");
		WebElement continueButton = driver.findElement(By
				.cssSelector(".cart-button"));
		continueButton.click();
	}
}
