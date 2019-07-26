package com.zibby.pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zibby.auto.AbstractIolsPage;
import com.zibby.auto.WebDriverUtil;

public class ShoppingCartPage extends AbstractIolsPage{

	
	private static final Logger LOG = LogManager.getLogger(ShoppingCartPage.class);
	WebDriver driver = WebDriverUtil.driver();
	
	private By salesRepresentativeName = By.xpath("//*[@name='salesrep']");
	private By orderNumber = By.xpath("//*[@name='orderId']");
	private By deliveryMethodDelivery = By.xpath("//*[@type='radio' and @name='668']");
	private By deliveryMethodInstore = By.xpath("//*[@type='radio' and @name='667']");
	private By itemType = By.xpath("//select[@ng-model]");
	private By quantity = By.xpath("//*[@type='number' and @name='quantity']");
	private By cashPrice = By.xpath("//*[@name='retailer_price']");
	private By makeModelNumber = By.xpath("//*[@name='item_code']");
	private By itemDescription	= By.xpath("//*[@name='item_name']");
	private By addWarranty = By.xpath("//*[@type='checkbox']");
	private By warrantyPrice = By.xpath("//*[@type='text' and @name='warrantyPrice']");
	private By warrantyName = By.xpath("//*[@type='text' and @name='warrantyName']");
}
