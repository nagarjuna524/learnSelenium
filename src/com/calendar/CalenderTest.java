package com.calendar;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalenderTest {

	public CalenderTest() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String OSNAME = System.getProperty("os.name").toLowerCase();
		String path = System.getProperty("user.dir");
		if (OSNAME.contains("windows")) {
			System.setProperty("webdriver.chrome.driver", path + "/drivers/windows32/chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", path + "/drivers/linux32/chromedriver");	
		}
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("file:///C:/Users/E003903/Downloads/TestFolder/JetBlue%20_%20Airline%20Tickets,%20Flights,%20and%20Airfare.html");

	}

}
