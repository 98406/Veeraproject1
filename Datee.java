package org.datePickker;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.CellEditor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.Table.Cell;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class Datee {
	

	public static void main(String[] args) throws ParseException {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Datepicker.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("datepicker1")).click();
		
		new WebDriverWait(driver, Duration.ofSeconds(4))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-datepicker-calendar")));
		String month = driver.findElement(By.className("ui-datepicker-title")).getText();
		
		String monthNow = month.split(" ")[0].trim();
		String yearNow = month.split(" ")[1].trim();
		while (!(monthNow.equals("April") && yearNow.equals("1985"))) {
			driver.findElement(By.xpath("//a[@title=\"Prev\"]")).click();
			String monthval = driver.findElement(By.className("ui-datepicker-title")).getText();
			monthNow = monthval.split(" ")[0].trim();
			yearNow = monthval.split(" ")[1].trim();
		}
		driver.findElement(By.xpath("//a[text()='17']")).click();
		String date = driver.findElement(By.id("datepicker1")).getAttribute("value");
		System.out.println(date);
		SimpleDateFormat fday = new SimpleDateFormat("MM/dd/yyyy");
		Date day = fday.parse(date);
		DateFormat day1 = new SimpleDateFormat("EEEE");
        String day3 = day1.format(day);
		System.out.println(day3);

	}
}

	