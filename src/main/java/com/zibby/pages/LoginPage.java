package com.zibby.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;

	@FindBy(name = "uid")
	By userName;

	@FindBy(linkText = "/login")
	By loginButton;

	@FindBy(name = "password")
	By password;

	@FindBy(name = "btnLogin")
	By login;

	@FindBy(className = "input-wrap")
	By number;

	@FindBy(xpath = "//a[@id='hs-eu-confirmation-button']")
	By confirmCookie;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void login(String strUserName, String strPasword) throws InterruptedException {

		driver.get("https://qa.zibby.com/app/login");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

		driver.findElement(confirmCookie).click();

		driver.findElement(userName).sendKeys(strUserName);
		driver.findElement(password).sendKeys(strPasword);
		driver.findElement(login).click();
	}

	public void setNumber(String phoneNumber) {
		// TODO Auto-generated method stub

	}

}