package com.anthem.APT;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.anthem.enums.AWDISG_data;
import com.anthem.page.AbstractIolsPage;
import com.anthem.pojo.AWDISG_pojo;


public class AWDISG_OneTimePaymentPage extends AbstractIolsPage {
	private By OneTimePayment = By.xpath("//*[text()='One Time Payment']");
	private By pageHeader = By.xpath("//*[text()='MAKE PAYMENT']");
	private By viewForText = By.xpath("//*[contains(text(),'You are viewing for')]");
	private By buttonLink;
	private By anthemLogo = By.xpath("//img[@src='assets/images/anthem.jpg']");
	private By accountTypeLink;
	String accountType;
	private By nickNameLink = By.xpath("//*[@id='nickName']");
	private By accountTypeDropDown = By.xpath("//*[@id='psButtonaccountType']/span[2]");
	private By cardTypeDropDown = By.xpath("//*[@id='psActiveOptionaccountType']");
	private By routingNoLink = By.xpath("//*[@id='bankRoutingNbr']");
	private By bankAccountNoLink = By.xpath("//*[@id='bankAccountNbr']");
	private By reEnterBankAccLink = By.xpath("//*[@id='reEnterbankAccountNbr']");
	private By accountHolderName = By.xpath("//*[@id='accountHolderName']");
	private By address1Link = By.xpath("//*[@id='address1']");
	private By address2Link = By.xpath("//*[@id='address2']");
	private By cityLink = By.xpath("//*[@id='city']");
	private By stateLink = By.xpath("//*[@id='state']");
	private By zipCodeLink = By.xpath("//*[@id='zipCode']");
	private By dateToPayLink = By.xpath("//*[@id='dateToPay']");
	private By payLink = By.xpath("//*[contains(text(),'PAY $')]");
	private By confirmLink = By.xpath("//*[text()='CONFIRM']");
	private By successLink = By.xpath("//*[text()='The Payment is submitted successfully.']");
	private By orderIdLink = By.xpath("//*[contains(text(),'Order ID')]");
	private final static Logger LOG = LogManager.getLogger(HomePage.class);
	private By accountSummaryHeader = By.xpath("//*[text()='MAKE PAYMENT']");
	private By amountLink = By.xpath("//*[contains(@id,'paymentAmt')]");
	private By cancelSuccessMessage = By.xpath("//*[contains(text(),'The payment is cancelled successfully.')]");
	private By formLink;
	private By cardNoLink = By.xpath("//*[@id='cardNumber']");
	private By cardHolderNameLink = By.xpath("//*[@id='cardName']");	
	private By expiryDateLink = By.xpath("//*[@id='expiryDate']");
	private By cardNumberLink = By.xpath("//*[@id='cardNumber']");
	private By paymentMethodLink = By.xpath("//*[@id='psActiveOptionpaymentMethod']");
	private By paymentMethodBankAccountLink = By.xpath("//*[@id='ddlLabelpaymentMethod0']");
	private By paymentMethodCreditDebitLink = By.xpath("//*[@id='ddlLabelpaymentMethod1']");
	private By cardTypeLink;

	
	
	
	@Override
	protected By defineUniqueElement() {
		return anthemLogo;
	}

	public void clickAccountType(String accountType) throws InterruptedException {
		if (accountType.equalsIgnoreCase("Personal Checking")) {
			accountTypeLink = By.xpath("//*[@id='ddlLabelaccountType0']");
		}
		else if(accountType.equalsIgnoreCase("Personal Savings"))
		{
			accountTypeLink = By.xpath("//*[@id='ddlLabelaccountType1']");
		}
		else if(accountType.equalsIgnoreCase("Business Checking"))
		{
			accountTypeLink = By.xpath("//*[@id='ddlLabelaccountType2']");
		}
		else if(accountType.equalsIgnoreCase("Business Savings"))
		{
			accountTypeLink = By.xpath("//*[@id='ddlLabelaccountType3']");
		}
		
		
		else if (accountType.equalsIgnoreCase("Mastercard"))
		{
			accountTypeLink = By.xpath("//*[@id='ddlLabelaccountType1']");
		}
		
		else if (accountType.equalsIgnoreCase("VISA"))
		{
			accountTypeLink = By.xpath("//*[@id='ddlLabelaccountType0']");
		}
		waitForElement(accountTypeLink).click();
		Thread.sleep(3000);
	}

	public void enterTheRequiredFields(String functionality, String page, String method) throws Exception {
		String[] parts = method.split("_");
		method = parts[0];
		accountType = parts[1];
		String keyword = page.concat("_" + functionality + "_" + method);
		
		waitForElement(paymentMethodLink).click();
		AWDISG_pojo paymentData = AWDISG_data.valueOf(keyword.toUpperCase()).getInfo();
		if (method.equalsIgnoreCase("bankaccount")) {
			try {
//				waitForElement(nickNameLink).sendKeys(paymentData.getNickName());
				waitForElement(paymentMethodBankAccountLink).click();
				waitForElement(accountTypeDropDown).click();
				clickAccountType(accountType);
				waitForElement(routingNoLink).sendKeys(paymentData.getRoutingNumber());
				waitForElement(bankAccountNoLink).sendKeys(paymentData.getBankAccountNumber());
				waitForElement(reEnterBankAccLink).sendKeys(paymentData.getReEnterBankAccNo());
				waitForElement(accountHolderName).sendKeys(paymentData.getAccountHolderName());
				waitForElement(address1Link).sendKeys(paymentData.getAddress1());
				waitForElement(cityLink).sendKeys(paymentData.getCity());
				waitForElement(zipCodeLink).sendKeys(paymentData.getZipCode());
//				waitForElement(dateToPayLink).sendKeys(paymentData.getDateToPay());
				waitForElement(stateLink).sendKeys("AP");
				waitForElement(payLink).click();
				waitForElement(confirmLink).click();
			} catch (Exception e) {
				LOG.error("form fields are missing");
				throw e;
			}
		} else if (method.equalsIgnoreCase("creditdebitcard")) {
			try {
				waitForElement(paymentMethodCreditDebitLink).click();
				waitForElement(cardTypeDropDown).click();
				if (accountType.equalsIgnoreCase("visa")) {
					cardTypeLink = By.xpath("//*[@id='ddlLabelaccountType0']");
				} else if (accountType.equalsIgnoreCase("Mastercard")) {
					System.out.println("coming");
					cardTypeLink = By.xpath("//*[@id='ddlLabelaccountType1']");
				}
				waitForElement(cardTypeLink).click();
				waitForElement(expiryDateLink).clear();
				waitForElement(expiryDateLink).sendKeys(paymentData.getExpiryDate());
				waitForElement(cardNumberLink).clear();
				waitForElement(cardNumberLink).sendKeys(paymentData.getCardNumber());
				waitForElement(cardHolderNameLink).clear();
				waitForElement(cardHolderNameLink).sendKeys(paymentData.getCardHoldersName());
				waitForElement(address1Link).clear();
				waitForElement(address1Link).sendKeys(paymentData.getAddress1());
				waitForElement(cityLink).clear();
				waitForElement(cityLink).sendKeys(paymentData.getCity());
				waitForElement(zipCodeLink).clear();
				waitForElement(zipCodeLink).sendKeys(paymentData.getZipCode());
				waitForElement(stateLink).sendKeys("AP");
				waitForElement(payLink).click();
				Thread.sleep(1000);
				waitForElement(confirmLink).click();
			} catch (Exception e) {
				LOG.error("form fields are missing");
				throw e;
			}
		}

	}

	public boolean paymentSuccessful() {
		if (waitForElement(successLink).isDisplayed()) {
			return true;
		}
		return false;
	}

	public boolean orderIdDisplayed(String orderId) {
		if (waitForElement(orderIdLink).isDisplayed()) {
			return true;
		}
		return false;
	}

	public void payNow(String amount) {
		waitForElement(amountLink).sendKeys(amount);
		hitXButton("Pay Now");
	}

	public void hitXButton(String key) {

		if (key.equalsIgnoreCase("payment method dropDown")) {
			waitForElement(By.xpath("//*[@id='psActiveOptionpaymentMethod']")).click();
			waitForPageLoad();
		} else {
			waitForElement(By.xpath("//*[contains(text(),'" + key + "')]")).click();
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void pageElementsDisplayed(String pageElements) {
		String keyword = "default_" + pageElements;
		AWDISG_pojo paymentData = AWDISG_data.valueOf(keyword.toUpperCase()).getInfo();
		try {
			waitForElement(By.xpath(paymentData.getAnthemLogo())).isDisplayed();
			waitForElement(By.xpath(paymentData.getPageName())).isDisplayed();
			waitForElement(By.xpath(paymentData.getTabName1())).isDisplayed();
			waitForElement(By.xpath(paymentData.getTabName2())).isDisplayed();
			waitForElement(By.xpath(paymentData.getTabName3())).isDisplayed();
			waitForElement(By.id(paymentData.getMenuButton())).isDisplayed();
			waitForElement(By.xpath(paymentData.getBackToSearchButton())).isDisplayed();
			waitForElement(By.xpath(paymentData.getWelcomeName())).isDisplayed();
			waitForElement(pageHeader).isDisplayed();
			waitForElement(viewForText).isDisplayed();
			LOG.error("Mandatory Page elements are displayed");
		} catch (Exception e) {
			LOG.error("Mandatory Page elements missing");
			throw e;
		}
	}

	public boolean successMessage(String key) {
		if (key.equalsIgnoreCase("cancelled") && waitForElement(cancelSuccessMessage).isDisplayed()) {
			return true;
		}
		return false;
	}

	public void enterText(String field, String text) {
		if (field.equalsIgnoreCase("cardNumber")) {
			waitForElement(cardNoLink).clear();
			waitForElement(cardNoLink).sendKeys(text);
		} else if (field.equalsIgnoreCase("cardHolderName")) {
			waitForElement(cardHolderNameLink).clear();
			waitForElement(cardHolderNameLink).sendKeys(text);
		} else if (field.equalsIgnoreCase("Address 1")) {
			waitForElement(address1Link).clear();
			waitForElement(address1Link).sendKeys(text);
		} else if (field.equalsIgnoreCase("Address 2")) {
			waitForElement(address2Link).clear();
			waitForElement(address2Link).sendKeys(text);

		} else if (field.equalsIgnoreCase("City")) {
			waitForElement(cityLink).clear();
			waitForElement(cityLink).sendKeys(text);

		} else if (field.equalsIgnoreCase("state")) {
			waitForElement(stateLink).clear();
			waitForElement(stateLink).sendKeys(text);

		} else if (field.equalsIgnoreCase("Zip code")) {
			waitForElement(zipCodeLink).clear();
			waitForElement(zipCodeLink).sendKeys(text);
		} else if (field.equalsIgnoreCase("Expiry Date")) {
			waitForElement(expiryDateLink).clear();
			waitForElement(expiryDateLink).sendKeys(text);
		}
		else if (field.equalsIgnoreCase("routingno")) {
			waitForElement(routingNoLink).clear();
			waitForElement(routingNoLink).sendKeys(text);
			
		}
	}

	public boolean errorMessageDisplayed(String message) {
		if (waitForElement(By.xpath("//*[contains(text(),'" + message + "')]")).isDisplayed()) {
			return true;
		}
		return false;
	}

	public void amountEntered(String amount) {
		waitForElement(amountLink).sendKeys(amount);
	}
	public void enterTheRequiredFieldsCommon(String functionality, String page, String method)
	{

		String[] parts = method.split("_");
		method = parts[0];
		String accountOrCardType = parts[1];
		String accountOrCardNo = parts[2];
		String routingOrExpiryDate = parts[3];
		String accountOrCardHolderName = parts[4];
		String Address1 = parts[5];
		String Address2 = parts[6];
		String City = parts[7];
		String State =parts[8];
		String ZipCode = parts[9];
		String keyword = page.concat("_" + functionality + "_" + method);
		
		waitForElement(paymentMethodLink).click();
		if (method.equalsIgnoreCase("bankaccount")) {
			try {
//				waitForElement(nickNameLink).sendKeys(paymentData.getNickName());
				waitForElement(paymentMethodBankAccountLink).click();
				waitForElement(accountTypeDropDown).click();
				clickAccountType(accountOrCardType);
				waitForElement(routingNoLink).clear();
				waitForElement(routingNoLink).sendKeys(routingOrExpiryDate);
				waitForElement(bankAccountNoLink).clear();
				waitForElement(bankAccountNoLink).sendKeys(accountOrCardNo);
				waitForElement(reEnterBankAccLink).clear();
				waitForElement(reEnterBankAccLink).sendKeys(accountOrCardNo);
				waitForElement(accountHolderName).clear();
				waitForElement(accountHolderName).sendKeys(accountOrCardHolderName);
				waitForElement(address1Link).clear();
				waitForElement(address1Link).sendKeys(Address1);
				waitForElement(address2Link).clear();
				waitForElement(address2Link).sendKeys(Address2);
				waitForElement(cityLink).clear();
				waitForElement(cityLink).sendKeys(City);
				waitForElement(zipCodeLink).clear();
				waitForElement(zipCodeLink).sendKeys(ZipCode);
				waitForElement(stateLink).clear();
				waitForElement(stateLink).sendKeys(State);
			} catch (Exception e) {
				LOG.error("form fields are missing");
				try {
					throw e;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} else if (method.equalsIgnoreCase("creditdebitcard")) {
			try {
				waitForElement(paymentMethodCreditDebitLink).click();
				waitForElement(cardTypeDropDown).click();
				
				if (accountOrCardType.equalsIgnoreCase("visa")) {
					cardTypeLink = By.xpath("//*[contains(text(),'VISA')]");
				} else if (accountOrCardType.equalsIgnoreCase("Mastercard")) {
					cardTypeLink = By.xpath("//*[contains(text(),'Mastercard')]");
				}
				
				waitForElement(cardTypeLink).click();
				waitForElement(expiryDateLink).clear();
				waitForElement(expiryDateLink).sendKeys(routingOrExpiryDate);
				waitForElement(cardNumberLink).clear();
				waitForElement(cardNumberLink).sendKeys(accountOrCardNo);
				waitForElement(cardHolderNameLink).clear();
				waitForElement(cardHolderNameLink).sendKeys(accountOrCardHolderName);
				waitForElement(address1Link).clear();
				waitForElement(address1Link).sendKeys(Address1);
				waitForElement(address2Link).clear();
				waitForElement(address2Link).sendKeys(Address2);
				waitForElement(cityLink).clear();
				waitForElement(cityLink).sendKeys(City);
				waitForElement(zipCodeLink).clear();
				waitForElement(zipCodeLink).sendKeys(ZipCode);
				waitForElement(stateLink).clear();
				waitForElement(stateLink).sendKeys(State);
				Thread.sleep(1000);
			} catch (Exception e) {
				LOG.error("form fields are missing");
				try {
					throw e;
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}
	public void payAndConfirm()
	{
		waitForElement(payLink).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		waitForElement(confirmLink).click();
	}
	}
