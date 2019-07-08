package com.zibby.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverUtil {

	WebDriver driver = new ChromeDriver();

	public void login(String username, String password) {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://qa.zibby.com/");

		driver.manage().window().maximize();
		driver.findElement(By.xpath("<a href=\"/customers\">Explore</a>")).click();
		driver.findElement(By.id("Email")).sendKeys(username);

		driver.findElement(By.id("Passwd")).sendKeys(password);

	}
}