package com.zibby.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.zibby.pages.LoginPage;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs {

	
	//WebDriverUtil driver = new WebDriverUtil();
	WebDriver driver = new ChromeDriver();
	LoginPage login = new LoginPage(driver);
	
	@Given("^a user with a valid set of credentials username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void a_user_with_a_valid_set_of_credentials_username_and_password(String username, String password) throws Throwable {
		login.login(username, password);
		
		
	}

	@When("^user logs in to the LMS application$")
	public void user_logs_in_to_the_LMS_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^user sees the welcome page and is sent for an OTP code\\.$")
	public void user_sees_the_welcome_page_and_is_sent_for_an_OTP_code() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
}
