package com.AutomationFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HtmlTableExample {

	public HtmlTableExample() {

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String path = System.getProperty("user.dir") + "/drivers/geckodriver";
		System.setProperty("webdriver.gecko.driver", path);

		WebDriver driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.get("http://toolsqa.wpengine.com/automation-practice-table/");

		WebElement htmlTable = driver.findElement(By.xpath("//table[@class='tsc_table_s13']/tbody"));

		List<WebElement> rows_table = htmlTable.findElements(By.tagName("tr"));

		System.out.println(rows_table.size());

		// Loop will execute for all the rows of the table
		for (int row = 0; row < rows_table.size(); row++) {

			// To locate columns(cells) of that specific row.
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));

			int columns_count = Columns_row.size();

			System.out.println(rows_table.size());
			System.out.println(Columns_row.size());

			for (int column = 0; column < columns_count; column++) {
				// To retrieve text from the cells.
				String celltext = Columns_row.get(column).getText();
				System.out.println(
						"Cell Value Of row number " + row + " and column number " + column + " Is " + celltext);
			}
		}
	}
}