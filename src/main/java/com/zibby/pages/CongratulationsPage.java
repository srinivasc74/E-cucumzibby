package com.zibby.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zibby.auto.AbstractIolsPage;
import com.zibby.auto.WebDriverUtil;

public class CongratulationsPage extends AbstractIolsPage{
	
	private static final Logger LOG = LogManager.getLogger(CongratulationsPage.class);
	WebDriver driver = WebDriverUtil.driver();

	private By buildTheirCart = By.xpath("//button[@button-text='Build their cart']");
	private By backToDashboard = By.xpath("//button[@class='button link']");
	
}
