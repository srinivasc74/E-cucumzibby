@LogIn
Feature: Log in to LMS Application
@Regression
Scenario Outline: User logs in as a retailer and is welcomed by the screen
Given a user with a valid set of credentials username "<userName>" and password "<password>"
When user logs in to the LMS application
Then user sees the welcome page and is sent for an OTP code.
Examples: 
|userName|password|
|HeyArzie|test|
