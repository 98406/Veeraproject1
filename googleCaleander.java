package org.datePickker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class googleCaleander {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://calendar.google.com/calendar/u/0/r?pli=1");
		driver.manage().window().maximize();
	}
}
