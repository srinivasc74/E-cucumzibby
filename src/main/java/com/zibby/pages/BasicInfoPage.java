package com.zibby.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.zibby.auto.AbstractIolsPage;
import com.zibby.auto.PageUtil;
import com.zibby.auto.WebDriverUtil;

public class BasicInfoPage extends AbstractIolsPage {

	private static final Logger LOG = LogManager.getLogger(BasicInfoPage.class);
	WebDriver driver = WebDriverUtil.driver();

	private By firstName = By.xpath("//input[@type='text' and @name='billing_first_name']");
	private By lastName = By.xpath("//*[@type='text' and @name='billing_last_name']");
	private By dateOfBirth = By.xpath("//input[@type='tel' and @name='dob']");
	private By SSN_ITIN = By.xpath("//input[@type='tel' and @name='ssn']");
	private By emailId = By.xpath("//input[@type='email' and @name='email']");
	private By billingAddress1 = By.xpath("//input[@type='text' and @name='billing_address']");
	private By billingAddress2 = By.xpath("// input[@type='text' and @name='billing_address2']");
	private By city = By.xpath("//input[@type='text' and @name='billing_city']");
	private By stateDrpDwn = By.xpath("//select[@name='billing_state']");
	private By zipCode = By.xpath("// *[@type='tel' and @name='billing_zip']");

	private By continueBtn = By.xpath("//button[@type='submit']");
	
	private By logo = By.xpath("//img[@class='logo-main']");

	@Override
	protected By defineUniqueElement() {
		return logo;
	}
	
	public void enterFirstName(String customerFirstName) {
		waitForElement(firstName).sendKeys(customerFirstName);
		LOG.info("Entering firstName.");
	}
	
	public void enterLastName(String customerLastName) {
		waitForElement(lastName).sendKeys(customerLastName);
		LOG.info("Entering last Name");
	}

	public void enterDateOfBirth(String customerDOB) {

		PageUtil.waitForPagetoLoad(5);
		waitForElement(dateOfBirth).sendKeys(customerDOB);
		LOG.info("Entering customer date of birth");
	}
	
	public void enterSSN(String ssn) {
		waitForElement(SSN_ITIN).sendKeys(ssn);
		LOG.info("Entering customer SSN/ITIN");
	}
	
	public void enterEmail(String emailID) {
		waitForElement(emailId).sendKeys(emailID);
		LOG.info("Entering customer email ID");
	}
	
	public void enterBillingAddress(String addressLine1) {
		waitForElement(billingAddress1).sendKeys(addressLine1);
		LOG.info("Entering address information");
	}
	
	public void enterBillingAddress2(String addressLine2) {
		waitForElement(billingAddress2).sendKeys(addressLine2);
		LOG.info("Entering address information");
	}
	
	public void enterCity(String cityName) {
		waitForElement(city).sendKeys(cityName);
		LOG.info("Entering City");
	}
	
	public void selectState(String state) {
		Select drpState = new Select(driver.findElement(stateDrpDwn));
		drpState.selectByValue(state);
		LOG.info("Selecting state from the dropdown menu.");
	}
	
	public void enterZipCode(String customerZipCode) {
		waitForElement(zipCode).sendKeys(customerZipCode);
		LOG.info("Entering zipcode information.");
	}
	
	public void clickContinue() {
		waitForElement(continueBtn).click();
		LOG.info("Clicking continue button.");
	}
	
	
	}
