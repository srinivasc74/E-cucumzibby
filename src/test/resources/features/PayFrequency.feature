Feature: Pay Frequency flows 

@PayFrequency @Demo 
Scenario Outline: 
	Verify that the payment due date has moved to the next payment array and displays correctly across 
Cart, Contract, Customer Portal and LMS when the time difference between lease origination date and the next pay date is less than 5 business days. 

	Given a user with a valid set of credentials username "<userName>" and password "<password>" 
	Then user sees the welcome page enters customer mobile number. 
	And user initiates a new application by entering phone number and verification code 
	And enter demographic information with first name as "<firstName>" 
	Then enters last name as "<lastName>" 
	Then enters date of birth as "<dateOfBirth>" 
	Then enters SSN or ITIN as "<SSN_ITIN>" 
	Then enters email ID as "<emailId>" 
	Then enters billing address as "<billingAddress1>" 
	Then enter second address line as "<billingAddress2>" 
	Then enter city as "<city>" 
	Then selects state as "<state>" 
	Then enters zipcode as "<zipCode>" and clicks continue 
	And Lands on Pay frequency 
	And Enters Salary "<salary>" for the term  "<payTerm>" 
	And Enters Pay Frequency as "<payFrequency>" 
	And Enters Last Pay date as "<payDate>" 
	#(5 or less days from Todays Date)
	And Enter Next Pay Date "<nextPayDate>" 
	And Selects Direct Deposit as "<directDeposit>" 
	And hits Continue and lands on Preapproval Page 
	When user adds item to cart 
	Then verify the item is added to cart 
	And Verify the Payment due date next cycle on the payment array displays as the customer's due date 
	When user Navigates to Checkout 
	Then Verify the lease details as Rental Term and Payment Schedule begin and end dates correspond to the payment due date 
	And user processes the lease by making a payment 
	When user Navigates to LMS 
	And pulls up the lease 
	Then verify the payment due date on the summary page aligns with contract and cart dates. 
	Examples: 
		|userName|password|firstName|lastName|dateOfBirth|SSN_ITIN|emailId|billingAddress1|billingAddress2|city|state|zipCode|salary|payTerm|payFrequency|payDate|nextPayDate|directDeposit|
		|HeyArzie|test|John|Bonham|06/19/1975|694949898|sunil.geddam@cognical.com|12911 Alton Sq|Apt 202|Herndon|VA|20170|45000|Yearly|Every other week|7/19/2019|08/02/2019|yes|
		#		Less than 5 days
		
		#		|HeyArzie|test|45000|Yearly|monthly|6/24/2019|lessThan5|no|
		#		|HeyArzie|test|45000|Yearly|semi-monthly|6/24/2019|lessThan5|yes|
		#		|HeyArzie|test|45000|Yearly|semi-monthly|6/24/2019|lessThan5|no|
		#		|HeyArzie|test|45000|Yearly|bi-weekly|6/24/2019|lessThan5|no|
		#		|HeyArzie|test|45000|Yearly|bi-weekly|6/24/2019|lessThan5|no|
		#		|HeyArzie|test|45000|Yearly|other|6/24/2019|lessThan5|no|
		#		|HeyArzie|test|45000|Yearly|other|6/24/2019|lessThan5|no|
		##		Equal to 5 days
		#		|HeyArzie|test|45000|Yearly|monthly|6/24/2019|equalTo5|yes|
		#		|HeyArzie|test|45000|Yearly|monthly|6/24/2019|equalTo5|no|
		#		|HeyArzie|test|45000|Yearly|semi-monthly|6/24/2019|equalTo5|yes|
		#		|HeyArzie|test|45000|Yearly|semi-monthly|6/24/2019|equalTo5|no|
		#		|HeyArzie|test|45000|Yearly|bi-weekly|6/24/2019|equalTo5|no|
		#		|HeyArzie|test|45000|Yearly|bi-weekly|6/24/2019|equalTo5|no|
		#		|HeyArzie|test|45000|Yearly|other|6/24/2019|equalTo5|no|
		#		|HeyArzie|test|45000|Yearly|other|6/24/2019|equalTo5|no|
		##		More Than 5 days 
		#		|HeyArzie|test|45000|Yearly|monthly|6/24/2019|moreThan5|yes|
		#		|HeyArzie|test|45000|Yearly|monthly|6/24/2019|moreThan5|no|
		#		|HeyArzie|test|45000|Yearly|semi-monthly|6/24/2019|moreThan5|yes|
		#		|HeyArzie|test|45000|Yearly|semi-monthly|6/24/2019|moreThan5|no|
		#		|HeyArzie|test|45000|Yearly|bi-weekly|6/24/2019|moreThan5|no|
		#		|HeyArzie|test|45000|Yearly|bi-weekly|6/24/2019|moreThan5|no|
		#		|HeyArzie|test|45000|Yearly|other|6/24/2019|moreThan5|no|
		#		|HeyArzie|test|45000|Yearly|other|6/24/2019|moreThan5|no|