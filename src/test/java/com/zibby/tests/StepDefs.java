package com.zibby.tests;

import com.zibby.auto.AbstractPage;
import com.zibby.auto.Environment;
import com.zibby.auto.PageUtil;
import com.zibby.pages.BasicInfoPage;
import com.zibby.pages.IncomePage;
import com.zibby.pages.LoginPage;
import com.zibby.pages.OTPEntryPage;
import com.zibby.pages.OTPPage;
import com.zibby.pages.ReviewPage;
import com.zibby.util.WebDriverNavigation;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs {

	public LoginPage loginPage;
	public OTPPage otpPage;
	public OTPEntryPage otpEntryPage;
	public BasicInfoPage basicInfoPage;
	public IncomePage incomePage;
	public ReviewPage reviewPage;
	
	@Given("^a user with a valid set of credentials username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void a_user_with_a_valid_set_of_credentials_username_and_password(String username, String password) throws InterruptedException{

		WebDriverNavigation.navigateToURL(Environment.getBaseUrl());
		PageUtil.waitForPagetoLoad(5);
		loginPage = AbstractPage.install(LoginPage.class);
		loginPage.performLogin(username, password);

	}

	@Then("^user sees the welcome page enters customer mobile number\\.$")
	public void user_sees_the_welcome_page_enters_customer_mobile_number() {
		otpPage = AbstractPage.install(OTPPage.class);
		otpPage.enterCustomerMobileNumber();
		otpPage.checksmsPolicy();
		otpPage.checksmsPolicy2();
		otpPage.clickContinue();
	}
	

	@Then("^user initiates a new application by entering phone number and verification code$")
	public void user_initiates_a_new_application_by_entering_phone_number_and_verification_code() {
		otpEntryPage = AbstractPage.install(OTPEntryPage.class);
		otpEntryPage.enterSixDigitCode();
		otpEntryPage.beginApplication();
	}

	@Then("^enter demographic information with first name as \"([^\"]*)\"$")
	public void enter_demographic_information_with_first_name_as(String firstName) {
		basicInfoPage = AbstractPage.install(BasicInfoPage.class);
		basicInfoPage.enterFirstName(firstName);
		
	}

	@Then("^enters last name as \"([^\"]*)\"$")
	public void enters_last_name_as(String lastName) {
		basicInfoPage.enterLastName(lastName);
	}

	@Then("^enters date of birth as \"([^\"]*)\"$")
	public void enters_date_of_birth_as(String dob) {
		basicInfoPage.enterDateOfBirth(dob);
	}

	@Then("^enters SSN or ITIN as \"([^\"]*)\"$")
	public void enters_SSN_or_ITIN_as(String ssn) {
		basicInfoPage.enterSSN(ssn);
	}

	@Then("^enters email ID as \"([^\"]*)\"$")
	public void enters_email_ID_as(String emailId) {
		basicInfoPage.enterEmail(emailId);
	}

	@Then("^enters billing address as \"([^\"]*)\"$")
	public void enters_billing_address_as(String addressLine1) {
		basicInfoPage.enterBillingAddress(addressLine1);
	}

	@Then("^enter second address line as \"([^\"]*)\"$")
	public void enter_second_address_line_as(String addressLine2) {
		basicInfoPage.enterBillingAddress2(addressLine2);
	}

	@Then("^enter city as \"([^\"]*)\"$")
	public void enter_city_as(String city) {
		basicInfoPage.enterCity(city);
	}

	@Then("^selects state as \"([^\"]*)\"$")
	public void selects_state_as(String state) {
		basicInfoPage.selectState(state);
	}

	@Then("^enters zipcode as \"([^\"]*)\" and clicks continue$")
	public void enters_zipcode_as_and_clicks_continue(String zipCode) {
		basicInfoPage.enterZipCode(zipCode);
		basicInfoPage.clickContinue();
	}

	@Then("^Lands on Pay frequency$")
	public void lands_on_Pay_frequency() {
		incomePage = AbstractPage.install(IncomePage.class);
		
	}

	@Then("^Enters Salary \"([^\"]*)\" for the term  \"([^\"]*)\"$")
	public void enters_Salary_for_the_term(String salary, String payTerm)  {
		incomePage.enterIncome(salary);
		
	}

	@Then("^Enters Pay Frequency as \"([^\"]*)\"$")
	public void enters_Pay_Frequency_as(String payFrequency) {
		incomePage.selectPayFrequency(payFrequency);
	}

	@Then("^Enters Last Pay date as \"([^\"]*)\"$")
	public void enters_Last_Pay_date_as(String lastPayDate) {
		incomePage.selectLastPayDate(lastPayDate);
	}

	@Then("^Enter Next Pay Date \"([^\"]*)\"$")
	public void enter_Next_Pay_Date(String nextPayDate) {
		incomePage.selectNextPayDate(nextPayDate);
	}

	@Then("^Selects Direct Deposit as \"([^\"]*)\"$")
	public void selects_Direct_Deposit_as(String directDeposit) {
		incomePage.selectDirectDeposit(directDeposit);
	}

	@Then("^hits Continue and lands on Preapproval Page$")
	public void hits_Continue_and_lands_on_Preapproval_Page() throws InterruptedException {
		incomePage.continueBtn();
		reviewPage = AbstractPage.install(ReviewPage.class);
		reviewPage.clickSubmitBtn();
	}

	@When("^user adds item to cart$")
	public void user_adds_item_to_cart() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^verify the item is added to cart$")
	public void verify_the_item_is_added_to_cart() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Verify the Payment due date next cycle on the payment array displays as the customer's due date$")
	public void verify_the_Payment_due_date_next_cycle_on_the_payment_array_displays_as_the_customer_s_due_date() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^user Navigates to Checkout$")
	public void user_Navigates_to_Checkout() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Verify the lease details as Rental Term and Payment Schedule begin and end dates correspond to the payment due date$")
	public void verify_the_lease_details_as_Rental_Term_and_Payment_Schedule_begin_and_end_dates_correspond_to_the_payment_due_date() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^user processes the lease by making a payment$")
	public void user_processes_the_lease_by_making_a_payment() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^user Navigates to LMS$")
	public void user_Navigates_to_LMS() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^pulls up the lease$")
	public void pulls_up_the_lease() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^verify the payment due date on the summary page aligns with contract and cart dates\\.$")
	public void verify_the_payment_due_date_on_the_summary_page_aligns_with_contract_and_cart_dates() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
}
