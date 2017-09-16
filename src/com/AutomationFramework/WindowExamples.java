package com.AutomationFramework;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.DriverHelper.DriverHelper;

public class WindowExamples {

	static WebDriver driver;

	@Test
	public void test_CloseAllWindowsExceptMainWindow() {

		// Create a new instance of the FireFox driver
		driver = DriverHelper.getDriver("firefox");

		// It will open Naukri website with multiple windows
		driver.get("http://www.naukri.com/");

		// To get the main window handle
		String windowTitle = getCurrentWindowTitle();
		System.out.println(windowTitle);
		String mainWindow = getMainWindowHandle(driver);
		System.out.println(mainWindow);
		Assert.assertTrue(closeAllOtherWindows(mainWindow));
		Assert.assertTrue(windowTitle.contains("Jobs - Recruitment"), "Main window title is not matching");
	}

	public String getMainWindowHandle(WebDriver driver) {
		return driver.getWindowHandle();
	}

	public String getCurrentWindowTitle() {
		String windowTitle = driver.getTitle();
		return windowTitle;
	}

	// To close all the other windows except the main window.
	public static boolean closeAllOtherWindows(String openWindowHandle) {
		Set<String> allWindowHandles = driver.getWindowHandles();
		for (String currentWindowHandle : allWindowHandles) {
			if (!currentWindowHandle.equals(openWindowHandle)) {
				driver.switchTo().window(currentWindowHandle);
				driver.close();
			}
		}

		driver.switchTo().window(openWindowHandle);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}
}