package com.zibby.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zibby.auto.AbstractIolsPage;
import com.zibby.auto.PageUtil;
import com.zibby.auto.WebDriverUtil;

public class LoginPage extends AbstractIolsPage {

	WebDriver driver = WebDriverUtil.driver();
	
	
	private By retailerLogin = By.xpath("//*[@ui-sref='ext-login.retailer']");
	
	private By customerLogin = By.xpath("//a[@href='#/ext-login/customer/username']");
	
	private By userName = By.xpath("//*[@name='username']");

	private By password = By.xpath("//*[@name='password']");

	private By continueBtn = By.xpath("//button[@type='submit']");
	
	private By loginAsCustomer = By.xpath("//a[@class='login-as-other']");

	private By confirmCookie = By.xpath("//a[@id='hs-eu-confirmation-button']");

	private By logos = By.xpath("//*[@title='Zibby']");

	private By logo = By.xpath("//a[@title='Zibby']");

	@Override
	protected By defineUniqueElement() {
		return logo;
	}
	
	public void getIframe(final WebDriver driver) {
	    final List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
	    for (WebElement iframe : iframes) {
	     System.out.println(iframe);  
	    }
	}

	public void performLogin(String strUserName, String strPassword) throws InterruptedException {

		waitForElement(logo);
		waitForElement(confirmCookie).click();
		waitForElement(logo);
		PageUtil.waitForPagetoLoad(5);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@src='/ng/retailer/login.html#ext-login/select']")));
		
		waitForElement(retailerLogin).click();
		
		waitForElement(userName).sendKeys(strUserName);
		waitForElement(password).sendKeys(strPassword);
		
		waitForElement(continueBtn).click();

	}


}