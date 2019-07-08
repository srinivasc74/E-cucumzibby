Feature: MemberWebPayment Portal


@MWP-AccSummary @MWPRegression
Scenario Outline: Navigate to Account Sumamry
 		Given user is on MWP page
		And enters "<HCID>" and "<SummaryBill>"
		Then account summary page is displayed
Examples:
	|HCID|SummaryBill|	
	|624T90975 ||
	
	
@MWP-Sprint4-1 @MWPRegression @AddPay
Scenario Outline:Add New Payment Method bankAccount
        Given user is on MWP page
		And enters "<HCID>" and "<SummaryBill>"
		Then account summary page is displayed
		Then click on managepaymentsmethods link
		Then add new payment method link
		Then select BankAccount as Payment method "<paymentMethod>" and enter "<nickName>" and "<accountType>" and "<routingNumber>" and "<accountNumber>" and "<reAccountNumber>" and "<accountHolderName>" and "<AddressAccount>" and "<address1>" and "<address2>" and "<city>" and "<state>" and "<zipCode>"
		Then click on save button
Examples:
	|HCID|SummaryBill|paymentMethod|nickName|accountType|routingNumber|accountNumber|reAccountNumber|accountHolderName|AddressAccount|address1|address2|city|state|zipCode|
	|018T93726||Banking Account|cherry|Personal Checking|071103473|71103473|71103473|rajan|subscriber|address1|address2|santa carla|CA|90001|
	
@MWP-Sprint4-2 @MWPRegression @AddPay
Scenario Outline:Add New Payment Method creditCard
		Given user is on MWP page
		And enters "<HCID>" and "<SummaryBill>"
		Then account summary page is displayed
		Then click on managepaymentsmethods link
		Then add new payment method link
		Then select creditcard as payment method "<paymentMethod>" and enter "<nickName>" and "<cardType>" and "<cardNumber>" and "<expiry>" and "<cardHolderName>" and "<addressAccount>" and "<address1>" and "<address2>" and "<city>" and "<state>" and "<zipCode>"
		Then click on save button	
		
Examples:
	|HCID|SummaryBill|paymentMethod|nickName|cardType|cardNumber|expiry|cardHolderName|addressAccount|address1|address2|city|state|zipCode|
	|018T93726||Credit / Debit Card|cherryck|VISA|4788250000121443|04/2029|rajan|subscriber|address1|address2|santa carla|CA|90001|
	
@MWP-Sprint4-3 @MWPRegression
Scenario Outline:Edit payment method for Bankaccount
		Given user is on MWP page
        And enters "<HCID>" and "<SummaryBill>"
		Then account summary page is displayed
		Then click on managepaymentsmethods link
		Then click on edit option for accountNumber "<accountNumber>"
		Then edit bankAccount nickName "<nickName>" and "<accountHolderName>" and "<address1>" and "<address2>" and "<city>" and "<state>" and "<zipCode>"
		Then click on edit save button
		Then click on confirm button
Examples:
	|HCID|SummaryBill|accountNumber|nickName|accountHolderName|address1|address2|city|state|zipCode|	
	|624T90975||****3473|ckumarrr|rajankumar|street1|street2|santacarla|CA|90001|	
	
@MWP-Sprint4-3-1 @MWPRegression
Scenario Outline:Edit payment method for Credit card
		Given user is on MWP page
        And enters "<HCID>" and "<SummaryBill>"
		Then account summary page is displayed
		Then click on managepaymentsmethods link
		Then click on edit option for accountNumber "<accountNumber>"
		Then edit creditcard nickName "<nickName>" and "<expiryDate>" and "<cardHolderName>" and "<address1>" and "<address2>" and "<city>" and "<state>" and "<zipCode>"
		Then click on save button
		Then click on confirm button
Examples:
	|HCID|SummaryBill|accountNumber|nickName|expiryDate|cardHolderName|address1|address2|city|state|zipCode|	
	|624T90975||************1443|ckumar|04/2030|rajankumar|street1|street2|santacarla|CA|90001|	
	
@MWP-Sprint4 @MWPRegression
Scenario Outline:Delete PaymentMethod
	  Given user is on MWP page
	  And enters "<HCID>" and "<SummaryBill>"
	  Then account summary page is displayed
	  Then click on managepaymentsmethods link
	  Then click on delete option for accountNumber "<accountNumber>"
	  Then click on confirm button
	  Examples:
	|HCID|SummaryBill|accountNumber|	
	|624T90975 ||*1443|


@MWP-Sprint4 @addrecurringpayemnt @MWPRegression
Scenario Outline: Automatic Payment
        Given user is on MWP page
		And enters "<HCID>" and "<SummaryBill>"
		Then account summary page is displayed
		Then click on manage automatic payments link
		Then click on new automatic payment
		Then select product "<HCID>" and "<plan>" and "<payment method>" and "<pay day>" 
		Then click on automatic payment save button
		#Then verify managepayment page
		Then click on manage automatic payments link
	
Examples:
	|HCID|SummaryBill|plan|payment method|pay day|
	|624T90975 ||Medical Account|Visa ending in 1443|2|

@PP-4804-1 @MWPRegression
Scenario Outline:Add New Payment Method bankAccount
        Given user is on MWP page
		And enters "<HCID>" and "<SummaryBill>"
		Then account summary page is displayed
		
Examples:
|HCID|SummaryBill|accountNumber|	
|624T90975 |||


@PP-4084-5487 @MWPRegression
Scenario Outline: Verify user able make payment with saved bank account
		Given user is on MWP page
		Then user search using HCID in MWP portal "<HCID>"
		Then account summary page is displayed
		Then user clicks on paynow button "<HCID>" and "<accntType>"
		Then select "<paymentMethod>" and click on continue button
		Then check confirm check box click on continue
		Then verify_payment_confirmation "<HCID>"
				
Examples:
	|HCID|SummaryBill|accntType|paymentMethod|
	|857A71754||Medicare Sup|Bank Account|
	|624T90975 ||Medical|Bank Account|
	
@PP-4081 @MWPRegression
Scenario Outline: Payment History
Given user is on MWP page
And enters "<HCID>" and "<SummaryBill>"
Then account summary page is displayed
Then user clicks on Payment History Tab
Then verify the HCID Payment History Details of "<memID>" and "<accountType>" are present
Examples:
	|HCID|SummaryBill|memID|accountType|
	|049T50240||049T50240|Medical|


@PP-4084-5483 @MWPRegression 
Scenario Outline: Verify user able submit one time payment using personal checking account type
		Given user is on MWP page
		Then user search using HCID in MWP portal "<HCID>"
		Then account summary page is displayed
		Then user clicks on paynow button "<HCID>" and "<accntType>"
		Then select oneTimePayment as "<paymentMethod>"
		Then select BankAccount as Payment method "<paymentMethod>" and enter "<nickName>" and "<accountType>" and "<routingNumber>" and "<accountNumber>" and "<reAccountNumber>" and "<accountHolderName>" and "<AddressAccount>" and "<address1>" and "<address2>" and "<city>" and "<state>" and "<zipCode>"
		Then check remember account future purpose checkbox
		Then click on continue button
		Then check confirm check box click on continue
		Then verify_payment_confirmation "<HCID>"
				
Examples:
	|HCID|SummaryBill|accntType|paymentMethod|nickName|accountType|routingNumber|accountNumber|reAccountNumber|accountHolderName|AddressAccount|address1|address2|city|state|zipCode|
	|857A71754 ||Medicare Sup|Bank Account|cherry|Personal Checking|071103473|71103473|71103473|rajan|subscriber|address1|address2|santa carla|CA|90001|

@PP-4084-5484 @MWPRegression
Scenario Outline: Verify user able submit one time payment using personal saving account type
		Given user is on MWP page
		Then user search using HCID in MWP portal "<HCID>"
		Then account summary page is displayed
		Then user clicks on paynow button "<HCID>" and "<accntType>"
		Then select oneTimePayment as "<paymentMethod>"
		Then select BankAccount as Payment method "<paymentMethod>" and enter "<nickName>" and "<accountType>" and "<routingNumber>" and "<accountNumber>" and "<reAccountNumber>" and "<accountHolderName>" and "<AddressAccount>" and "<address1>" and "<address2>" and "<city>" and "<state>" and "<zipCode>"
		Then check remember account future purpose checkbox
		Then click on continue button
		Then check confirm check box click on continue
		Then verify_payment_confirmation "<HCID>"
				
Examples:
	|HCID|SummaryBill|accntType|paymentMethod|nickName|accountType|routingNumber|accountNumber|reAccountNumber|accountHolderName|AddressAccount|address1|address2|city|state|zipCode|
	|624T90975 ||Medical|Bank Account|cherry|Personal Checking|071103473|71103473|71103473|rajan|subscriber|address1|address2|santa carla|CA|90001|	
	
@PP-4084-5485 @MWPRegression
Scenario Outline: Verify user able submit one time payment using business checking account type
		Given user is on MWP page
		Then user search using HCID in MWP portal "<HCID>"
		Then account summary page is displayed
		Then user clicks on paynow button "<HCID>" and "<accntType>"
		Then select oneTimePayment as "<paymentMethod>"
		Then select BankAccount as Payment method "<paymentMethod>" and enter "<nickName>" and "<accountType>" and "<routingNumber>" and "<accountNumber>" and "<reAccountNumber>" and "<accountHolderName>" and "<AddressAccount>" and "<address1>" and "<address2>" and "<city>" and "<state>" and "<zipCode>"
		Then check remember account future purpose checkbox
		Then click on continue button
		Then check confirm check box click on continue
		Then verify_payment_confirmation "<HCID>"
				
Examples:
	|HCID|SummaryBill|accntType|paymentMethod|nickName|accountType|routingNumber|accountNumber|reAccountNumber|accountHolderName|AddressAccount|address1|address2|city|state|zipCode|
	|624T90975 ||Medical|Bank Account|cherry|Personal Checking|071103473|71103473|71103473|rajan|subscriber|address1|address2|santa carla|CA|90001|	
	
#pending for verification method to be added	
@PP-4084-5486 @MWPRegression
Scenario Outline: Verify user able submit one time payment using business checking account type
		Given user is on MWP page
		Then user search using HCID in MWP portal "<HCID>"
		Then account summary page is displayed
		Then user clicks on paynow button "<HCID>" and "<accntType>"
		Then select oneTimePayment as "<paymentMethod>"
		Then select BankAccount as Payment method "<paymentMethod>" and enter "<nickName>" and "<accountType>" and "<routingNumber>" and "<accountNumber>" and "<reAccountNumber>" and "<accountHolderName>" and "<AddressAccount>" and "<address1>" and "<address2>" and "<city>" and "<state>" and "<zipCode>"
		Then check remember account future purpose checkbox
		Then click on continue button
		Then check confirm check box click on continue
		Then verify_payment_confirmation "<HCID>"
		
				
Examples:
	|HCID|SummaryBill|accntType|paymentMethod|nickName|accountType|routingNumber|accountNumber|reAccountNumber|accountHolderName|AddressAccount|address1|address2|city|state|zipCode|
	|624T90975 ||Medical|Bank Account|cherry|Personal Checking|071103473|71103473|71103473|rajan|subscriber|address1|address2|santa carla|CA|90001|	
	

#PP-3100userstory
@MWP-Sprint4 @PP-3100userstory @MWPRegression
Scenario Outline:FAQ
	Given user is on MWP page
	  And enters "<HCID>" and "<SummaryBill>"
	  Then account summary page is displayed
	  When user clicks on the FAQ link
	  Then FAQ tab should open
	  Then Verify FAQ content with "<FAQquestion>" and "<FAQanswer>"
	  Examples:
	|HCID|SummaryBill|FAQquestion|FAQanswer|
	|756T91280||How do I set up a linked account?|From your bill payment Account Summary page, choose Manage linked accounts. From there you can select Add new linked bill. You'll need to enter the Name, Member ID Number, and Date of Birth for the account you want linked to yours. The other account owner needs to be a registered site user, and have a valid email address set up in their profile. When you submit the linking request, that person will get an email asking for their permission to allow you to view and pay their bills. Once they confirm the request, you're all set.|
	
	@MWP-Sprint4 @PP-5526 @MWPRegression
Scenario Outline:FAQ 
	Given user is on MWP page
	  And enters "<HCID>" and "<SummaryBill>"
	  Then account summary page is displayed
	  When user clicks on the FAQ link
	  Then FAQ tab should open
	  Examples:
	|HCID|SummaryBill|
	|132A62931||
	|344M74484||
	|377A72560||
	|454A62919||
	|594A72431||
	|772A70223||
	|603M77792||
	|327M77857||
	|440M77845||
	

	@MWP-Sprint4 @PP-5527 @MWPRegression
Scenario Outline:FAQ Order check
	Given user is on MWP page
	  And enters "<HCID>" and "<SummaryBill>"
	  Then account summary page is displayed
	  When user clicks on the FAQ link
	  Then FAQ tab should open
	  Then Verify FAQ contentOrder with "<FAQquestion1>" and "<FAQquestion2>" and "<FAQquestion3>" and "<FAQquestion4>" and "<FAQquestion5>" and "<FAQquestion6>" and "<FAQquestion7>" and "<FAQquestion8>" and "<FAQquestion9>"
	  Examples:
	|HCID|SummaryBill|FAQquestion1|FAQquestion2|FAQquestion3|FAQquestion4|FAQquestion5|FAQquestion6|FAQquestion7|FAQquestion8|FAQquestion9|
	|132A62931||What is a linked|How do I set up|What if I no longer|What does my|What kind of accounts|Can I save my banking and|My old credit card|How long does it take for my payments|My policy may have been cancelled|
	|344M74484||What is a linked|How do I set up|What if I no longer|What does my|What kind of accounts|Can I save my banking and|My old credit card|How long does it take for my payments|My policy may have been cancelled|
	|377A72560||What is a linked|How do I set up|What if I no longer|What does my|What kind of accounts|Can I save my banking and|My old credit card|How long does it take for my payments|My policy may have been cancelled|
	|454A62919||What is a linked|How do I set up|What if I no longer|What does my|What kind of accounts|Can I save my banking and|My old credit card|How long does it take for my payments|My policy may have been cancelled|
	|594A72431||What is a linked|How do I set up|What if I no longer|What does my|What kind of accounts|Can I save my banking and|My old credit card|How long does it take for my payments|My policy may have been cancelled|
	|772A70223||What is a linked|How do I set up|What if I no longer|What does my|What kind of accounts|Can I save my banking and|My old credit card|How long does it take for my payments|My policy may have been cancelled|
	|603M77792||What is a linked|How do I set up|What if I no longer|What does my|What kind of accounts|Can I save my banking and|My old credit card|How long does it take for my payments|My policy may have been cancelled|
	|327M77857||What is a linked|How do I set up|What if I no longer|What does my|What kind of accounts|Can I save my banking and|My old credit card|How long does it take for my payments|My policy may have been cancelled|
	|440M77845||What is a linked|How do I set up|What if I no longer|What does my|What kind of accounts|Can I save my banking and|My old credit card|How long does it take for my payments|My policy may have been cancelled|
	
@MWP-Sprint4 @PP-5528 @MWPRegression
Scenario Outline:FAQ
	Given user is on MWP page
	  And enters "<HCID>" and "<SummaryBill>"
	  Then account summary page is displayed
	  When user clicks on the FAQ link
	  Then FAQ tab should open
	  Then Verify FAQ content with "<FAQquestion>" and "<FAQanswer>"
	  Examples:
	|HCID|SummaryBill|FAQquestion|FAQanswer|
	|132A62931||What is a linked account?|A linked account allows you to pay bills other than your own. You can link their account to yours, then you can pay both bills together. The accounts are only linked for paying bills – it does not change your other privacy settings or allow you to see personal health information.|
	|344M74484||What is a linked account?|A linked account allows you to pay bills other than your own. You can link their account to yours, then you can pay both bills together. The accounts are only linked for paying bills – it does not change your other privacy settings or allow you to see personal health information.|
	|377A72560||What is a linked account?|A linked account allows you to pay bills other than your own. You can link their account to yours, then you can pay both bills together. The accounts are only linked for paying bills – it does not change your other privacy settings or allow you to see personal health information.|
	|454A62919||What is a linked account?|A linked account allows you to pay bills other than your own. You can link their account to yours, then you can pay both bills together. The accounts are only linked for paying bills – it does not change your other privacy settings or allow you to see personal health information.|
	|594A72431||What is a linked account?|A linked account allows you to pay bills other than your own. You can link their account to yours, then you can pay both bills together. The accounts are only linked for paying bills – it does not change your other privacy settings or allow you to see personal health information.|
	|772A70223||What is a linked account?|A linked account allows you to pay bills other than your own. You can link their account to yours, then you can pay both bills together. The accounts are only linked for paying bills – it does not change your other privacy settings or allow you to see personal health information.|
	|603M77792||What is a linked account?|A linked account allows you to pay bills other than your own. You can link their account to yours, then you can pay both bills together. The accounts are only linked for paying bills – it does not change your other privacy settings or allow you to see personal health information.|
	|327M77857||What is a linked account?|A linked account allows you to pay bills other than your own. You can link their account to yours, then you can pay both bills together. The accounts are only linked for paying bills – it does not change your other privacy settings or allow you to see personal health information.|
	|440M77845||What is a linked account?|A linked account allows you to pay bills other than your own. You can link their account to yours, then you can pay both bills together. The accounts are only linked for paying bills – it does not change your other privacy settings or allow you to see personal health information.|
	
@MWP-Sprint4 @PP-5529 @MWPRegression
Scenario Outline:FAQ
	Given user is on MWP page
	  And enters "<HCID>" and "<SummaryBill>"
	  Then account summary page is displayed
	  When user clicks on the FAQ link
	  Then FAQ tab should open
	  Then Verify FAQ content with "<FAQquestion>" and "<FAQanswer>"
	  Examples:
	|HCID|SummaryBill|FAQquestion|FAQanswer|
	|132A62931||How do I set up a linked account?|From your bill payment Account Summary page, choose  'Manage linked accounts.' From there you can select 'Add new linked bill.' You'll need to enter the Name, Member ID Number, and Date of Birth for the account you want linked to yours. The other account owner needs to be a registered site user, and have a valid email address set up in their profile. When you submit the linking request, that person will get an email asking for their permission to allow you to view and pay their bills. Once they confirm the request, you're all set.|
	|344M74484||How do I set up a linked account?|From your bill payment Account Summary page, choose  'Manage linked accounts.' From there you can select 'Add new linked bill.' You'll need to enter the Name, Member ID Number, and Date of Birth for the account you want linked to yours. The other account owner needs to be a registered site user, and have a valid email address set up in their profile. When you submit the linking request, that person will get an email asking for their permission to allow you to view and pay their bills. Once they confirm the request, you're all set.|
	|377A72560||How do I set up a linked account?|From your bill payment Account Summary page, choose  'Manage linked accounts.' From there you can select 'Add new linked bill.' You'll need to enter the Name, Member ID Number, and Date of Birth for the account you want linked to yours. The other account owner needs to be a registered site user, and have a valid email address set up in their profile. When you submit the linking request, that person will get an email asking for their permission to allow you to view and pay their bills. Once they confirm the request, you're all set.|
	|454A62919||How do I set up a linked account?|From your bill payment Account Summary page, choose  'Manage linked accounts.' From there you can select 'Add new linked bill.' You'll need to enter the Name, Member ID Number, and Date of Birth for the account you want linked to yours. The other account owner needs to be a registered site user, and have a valid email address set up in their profile. When you submit the linking request, that person will get an email asking for their permission to allow you to view and pay their bills. Once they confirm the request, you're all set.|
	|594A72431||How do I set up a linked account?|From your bill payment Account Summary page, choose  'Manage linked accounts.' From there you can select 'Add new linked bill.' You'll need to enter the Name, Member ID Number, and Date of Birth for the account you want linked to yours. The other account owner needs to be a registered site user, and have a valid email address set up in their profile. When you submit the linking request, that person will get an email asking for their permission to allow you to view and pay their bills. Once they confirm the request, you're all set.|
	|772A70223||How do I set up a linked account?|From your bill payment Account Summary page, choose  'Manage linked accounts.' From there you can select 'Add new linked bill.' You'll need to enter the Name, Member ID Number, and Date of Birth for the account you want linked to yours. The other account owner needs to be a registered site user, and have a valid email address set up in their profile. When you submit the linking request, that person will get an email asking for their permission to allow you to view and pay their bills. Once they confirm the request, you're all set.|
	|603M77792||How do I set up a linked account?|From your bill payment Account Summary page, choose  'Manage linked accounts.' From there you can select 'Add new linked bill.' You'll need to enter the Name, Member ID Number, and Date of Birth for the account you want linked to yours. The other account owner needs to be a registered site user, and have a valid email address set up in their profile. When you submit the linking request, that person will get an email asking for their permission to allow you to view and pay their bills. Once they confirm the request, you're all set.|
	|327M77857||How do I set up a linked account?|From your bill payment Account Summary page, choose  'Manage linked accounts.' From there you can select 'Add new linked bill.' You'll need to enter the Name, Member ID Number, and Date of Birth for the account you want linked to yours. The other account owner needs to be a registered site user, and have a valid email address set up in their profile. When you submit the linking request, that person will get an email asking for their permission to allow you to view and pay their bills. Once they confirm the request, you're all set.|
	|440M77845||How do I set up a linked account?|From your bill payment Account Summary page, choose  'Manage linked accounts.' From there you can select 'Add new linked bill.' You'll need to enter the Name, Member ID Number, and Date of Birth for the account you want linked to yours. The other account owner needs to be a registered site user, and have a valid email address set up in their profile. When you submit the linking request, that person will get an email asking for their permission to allow you to view and pay their bills. Once they confirm the request, you're all set.|
@MWP-Sprint4 @PP-5530 @MWPRegression
Scenario Outline:FAQ
	  Given user is on MWP page
	  And enters "<HCID>" and "<SummaryBill>"
	  Then account summary page is displayed
	  When user clicks on the FAQ link
	  Then FAQ tab should open
	  Then Verify FAQ content with "<FAQquestion>" and "<FAQanswer>"
	  Examples:
	|HCID|SummaryBill|FAQquestion|FAQanswer|
	|132A62931||What if I no longer wish to receive my paper billing statement by mail?|You can opt in to receive paperless bill statements on your profile page. You will no longer receive paper bills in the mail, though you can switch back later if you want to. You will receive an email reminder when you have a bill you need to pay. IMPORTANT: Keep your email address up to date in your profile to be sure you keep getting email reminders. |
	|344M74484||What if I no longer wish to receive my paper billing statement by mail?|You can opt in to receive paperless bill statements on your profile page. You will no longer receive paper bills in the mail, though you can switch back later if you want to. You will receive an email reminder when you have a bill you need to pay. IMPORTANT: Keep your email address up to date in your profile to be sure you keep getting email reminders. |
	|377A72560||What if I no longer wish to receive my paper billing statement by mail?|You can opt in to receive paperless bill statements on your profile page. You will no longer receive paper bills in the mail, though you can switch back later if you want to. You will receive an email reminder when you have a bill you need to pay. IMPORTANT: Keep your email address up to date in your profile to be sure you keep getting email reminders. |
	|454A62919||What if I no longer wish to receive my paper billing statement by mail?|You can opt in to receive paperless bill statements on your profile page. You will no longer receive paper bills in the mail, though you can switch back later if you want to. You will receive an email reminder when you have a bill you need to pay. IMPORTANT: Keep your email address up to date in your profile to be sure you keep getting email reminders. |
	|594A72431||What if I no longer wish to receive my paper billing statement by mail?|You can opt in to receive paperless bill statements on your profile page. You will no longer receive paper bills in the mail, though you can switch back later if you want to. You will receive an email reminder when you have a bill you need to pay. IMPORTANT: Keep your email address up to date in your profile to be sure you keep getting email reminders. |
	|772A70223||What if I no longer wish to receive my paper billing statement by mail?|You can opt in to receive paperless bill statements on your profile page. You will no longer receive paper bills in the mail, though you can switch back later if you want to. You will receive an email reminder when you have a bill you need to pay. IMPORTANT: Keep your email address up to date in your profile to be sure you keep getting email reminders. |
	|603M77792||What if I no longer wish to receive my paper billing statement by mail?|You can opt in to receive paperless bill statements on your profile page. You will no longer receive paper bills in the mail, though you can switch back later if you want to. You will receive an email reminder when you have a bill you need to pay. IMPORTANT: Keep your email address up to date in your profile to be sure you keep getting email reminders. |
	|327M77857||What if I no longer wish to receive my paper billing statement by mail?|You can opt in to receive paperless bill statements on your profile page. You will no longer receive paper bills in the mail, though you can switch back later if you want to. You will receive an email reminder when you have a bill you need to pay. IMPORTANT: Keep your email address up to date in your profile to be sure you keep getting email reminders. |
	|440M77845||What if I no longer wish to receive my paper billing statement by mail?|You can opt in to receive paperless bill statements on your profile page. You will no longer receive paper bills in the mail, though you can switch back later if you want to. You will receive an email reminder when you have a bill you need to pay. IMPORTANT: Keep your email address up to date in your profile to be sure you keep getting email reminders. |
	
@MWP-Sprint4 @PP-5531 @MWPRegression
Scenario Outline:FAQ
	  Given user is on MWP page
	  And enters "<HCID>" and "<SummaryBill>"
	  Then account summary page is displayed
	  When user clicks on the FAQ link
	  Then FAQ tab should open
	  Then Verify FAQ content with "<FAQquestion>" and "<FAQanswer>"
	  Examples:
	|HCID|SummaryBill|FAQquestion|FAQanswer|
	|132A62931||What does my Total Amount Due include?|It includes any current and past due amounts associated with your account number. It will also include any fees or adjustments applied since your last bill.  To find the details for your account(s), please review the billing statement.|
	|344M74484||What does my Total Amount Due include?|It includes any current and past due amounts associated with your account number. It will also include any fees or adjustments applied since your last bill.  To find the details for your account(s), please review the billing statement.|
	|377A72560||What does my Total Amount Due include?|It includes any current and past due amounts associated with your account number. It will also include any fees or adjustments applied since your last bill.  To find the details for your account(s), please review the billing statement.|
	|454A62919||What does my Total Amount Due include?|It includes any current and past due amounts associated with your account number. It will also include any fees or adjustments applied since your last bill.  To find the details for your account(s), please review the billing statement.|
	|594A72431||What does my Total Amount Due include?|It includes any current and past due amounts associated with your account number. It will also include any fees or adjustments applied since your last bill.  To find the details for your account(s), please review the billing statement.|
	|772A70223||What does my Total Amount Due include?|It includes any current and past due amounts associated with your account number. It will also include any fees or adjustments applied since your last bill.  To find the details for your account(s), please review the billing statement.|
	|603M77792||What does my Total Amount Due include?|It includes any current and past due amounts associated with your account number. It will also include any fees or adjustments applied since your last bill.  To find the details for your account(s), please review the billing statement.|
	|327M77857||What does my Total Amount Due include?|It includes any current and past due amounts associated with your account number. It will also include any fees or adjustments applied since your last bill.  To find the details for your account(s), please review the billing statement.|
	|440M77845||What does my Total Amount Due include?|It includes any current and past due amounts associated with your account number. It will also include any fees or adjustments applied since your last bill.  To find the details for your account(s), please review the billing statement.|
	
	
	@MWP-Sprint4 @PP-5532 @MWPRegression
Scenario Outline:FAQ
	  Given user is on MWP page
	  And enters "<HCID>" and "<SummaryBill>"
	  Then account summary page is displayed
	  When user clicks on the FAQ link
	  Then FAQ tab should open
	  Then Verify FAQ content with "<FAQquestion>" and "<FAQanswer>"
	  Examples:
	|HCID|SummaryBill|FAQquestion|FAQanswer|
	|132A62931||What kind of accounts can I use to pay my bills online?|For credit/debit cards, you can use a Visa or MasterCard. For banking accounts you can use a personal checking or savings account, or business checking or savings account.|
	|132A62931||What kind of accounts can I use to pay my bills online?|For credit/debit cards, you can use a Visa or MasterCard. For banking accounts you can use a personal checking or savings account, or business checking or savings account.|
	|344M74484||What kind of accounts can I use to pay my bills online?|For credit/debit cards, you can use a Visa or MasterCard. For banking accounts you can use a personal checking or savings account, or business checking or savings account.|
	|377A72560||What kind of accounts can I use to pay my bills online?|For credit/debit cards, you can use a Visa or MasterCard. For banking accounts you can use a personal checking or savings account, or business checking or savings account.|
	|454A62919||What kind of accounts can I use to pay my bills online?|For credit/debit cards, you can use a Visa or MasterCard. For banking accounts you can use a personal checking or savings account, or business checking or savings account.|
	|594A72431||What kind of accounts can I use to pay my bills online?|For credit/debit cards, you can use a Visa or MasterCard. For banking accounts you can use a personal checking or savings account, or business checking or savings account.|
	|772A70223||What kind of accounts can I use to pay my bills online?|For credit/debit cards, you can use a Visa or MasterCard. For banking accounts you can use a personal checking or savings account, or business checking or savings account.|
	|603M77792||What kind of accounts can I use to pay my bills online?|For credit/debit cards, you can use a Visa or MasterCard. For banking accounts you can use a personal checking or savings account, or business checking or savings account.|
	|327M77857||What kind of accounts can I use to pay my bills online?|For credit/debit cards, you can use a Visa or MasterCard. For banking accounts you can use a personal checking or savings account, or business checking or savings account.|
	|440M77845||What kind of accounts can I use to pay my bills online?|For credit/debit cards, you can use a Visa or MasterCard. For banking accounts you can use a personal checking or savings account, or business checking or savings account.|
	
	@MWP-Sprint4 @PP-5533 @MWPRegression
Scenario Outline:FAQ
	  Given user is on MWP page
	  And enters "<HCID>" and "<SummaryBill>"
	  Then account summary page is displayed
	  When user clicks on the FAQ link
	  Then FAQ tab should open
	  Then Verify FAQ content with "<FAQquestion>" and "<FAQanswer>"
	  Examples:
	|HCID|SummaryBill|FAQquestion|FAQanswer|
	|132A62931||Can I save my banking and credit card payment accounts to re-use them in the future?|Yes -- when you make a payment you can choose remember this account for future use and it will be available whenever you choose to make a payment. You can also edit and securely save up to 5 different payment accounts on the Manage Payment Methods tab.|
	|132A62931||Can I save my banking and credit card payment accounts to re-use them in the future?|Yes -- when you make a payment you can choose remember this account for future use and it will be available whenever you choose to make a payment. You can also edit and securely save up to 5 different payment accounts on the Manage Payment Methods tab.|
	|344M74484||Can I save my banking and credit card payment accounts to re-use them in the future?|Yes -- when you make a payment you can choose remember this account for future use and it will be available whenever you choose to make a payment. You can also edit and securely save up to 5 different payment accounts on the Manage Payment Methods tab.|
	|377A72560||Can I save my banking and credit card payment accounts to re-use them in the future?|Yes -- when you make a payment you can choose remember this account for future use and it will be available whenever you choose to make a payment. You can also edit and securely save up to 5 different payment accounts on the Manage Payment Methods tab.|
	|454A62919||Can I save my banking and credit card payment accounts to re-use them in the future?|Yes -- when you make a payment you can choose remember this account for future use and it will be available whenever you choose to make a payment. You can also edit and securely save up to 5 different payment accounts on the Manage Payment Methods tab.|
	|594A72431||Can I save my banking and credit card payment accounts to re-use them in the future?|Yes -- when you make a payment you can choose remember this account for future use and it will be available whenever you choose to make a payment. You can also edit and securely save up to 5 different payment accounts on the Manage Payment Methods tab.|
	|772A70223||Can I save my banking and credit card payment accounts to re-use them in the future?|Yes -- when you make a payment you can choose remember this account for future use and it will be available whenever you choose to make a payment. You can also edit and securely save up to 5 different payment accounts on the Manage Payment Methods tab.|
	|603M77792||Can I save my banking and credit card payment accounts to re-use them in the future?|Yes -- when you make a payment you can choose remember this account for future use and it will be available whenever you choose to make a payment. You can also edit and securely save up to 5 different payment accounts on the Manage Payment Methods tab.|
	|327M77857||Can I save my banking and credit card payment accounts to re-use them in the future?|Yes -- when you make a payment you can choose remember this account for future use and it will be available whenever you choose to make a payment. You can also edit and securely save up to 5 different payment accounts on the Manage Payment Methods tab.|
	|440M77845||Can I save my banking and credit card payment accounts to re-use them in the future?|Yes -- when you make a payment you can choose remember this account for future use and it will be available whenever you choose to make a payment. You can also edit and securely save up to 5 different payment accounts on the Manage Payment Methods tab.|
	
	@MWP-Sprint4 @PP-5534
Scenario Outline:FAQ @MWPRegression
	  Given user is on MWP page
	  And enters "<HCID>" and "<SummaryBill>"
	  Then account summary page is displayed
	  When user clicks on the FAQ link
	  Then FAQ tab should open
	  Then Verify FAQ content with "<FAQquestion>" and "<FAQanswer>"
	  Examples:
	|HCID|SummaryBill|FAQquestion|FAQanswer|
	|132A62931||My old credit card just expired and I received a new one. How do I update my saved card information?|Go to the "Manage Payment Methods" tab. You can edit existing cards there, or delete an old one and enter a new one if you choose.|
	|132A62931||My old credit card just expired and I received a new one. How do I update my saved card information?|Go to the "Manage Payment Methods" tab. You can edit existing cards there, or delete an old one and enter a new one if you choose.|
	|344M74484||My old credit card just expired and I received a new one. How do I update my saved card information?|Go to the "Manage Payment Methods" tab. You can edit existing cards there, or delete an old one and enter a new one if you choose.|
	|377A72560||My old credit card just expired and I received a new one. How do I update my saved card information?|Go to the "Manage Payment Methods" tab. You can edit existing cards there, or delete an old one and enter a new one if you choose.|
	|454A62919||My old credit card just expired and I received a new one. How do I update my saved card information?|Go to the "Manage Payment Methods" tab. You can edit existing cards there, or delete an old one and enter a new one if you choose.|
	|594A72431||My old credit card just expired and I received a new one. How do I update my saved card information?|Go to the "Manage Payment Methods" tab. You can edit existing cards there, or delete an old one and enter a new one if you choose.|
	|772A70223||My old credit card just expired and I received a new one. How do I update my saved card information?|Go to the "Manage Payment Methods" tab. You can edit existing cards there, or delete an old one and enter a new one if you choose.|
	|603M77792||My old credit card just expired and I received a new one. How do I update my saved card information?|Go to the "Manage Payment Methods" tab. You can edit existing cards there, or delete an old one and enter a new one if you choose.|
	|327M77857||My old credit card just expired and I received a new one. How do I update my saved card information?|Go to the "Manage Payment Methods" tab. You can edit existing cards there, or delete an old one and enter a new one if you choose.|
	|440M77845||My old credit card just expired and I received a new one. How do I update my saved card information?|Go to the "Manage Payment Methods" tab. You can edit existing cards there, or delete an old one and enter a new one if you choose.|
	
	@MWP-Sprint4 @PP-5535
Scenario Outline:FAQ @MWPRegression
	 Given user is on MWP page
	  And enters "<HCID>" and "<SummaryBill>"
	  Then account summary page is displayed
	  When user clicks on the FAQ link
	  Then FAQ tab should open
	  Then Verify FAQ content with "<FAQquestion>" and "<FAQanswer>"
	  Examples:
	|HCID|SummaryBill|FAQquestion|FAQanswer|
	|132A62931||How long does it take for my payments to show in this site?|It can take about 24 hours for payments to show on this site (until then it will show "payment processing"). Payments you make before 5:00 pm Eastern Time usually process the same day, or the next day if submitted after 5:00 pm. Note that processing of payments can be delayed by bank holidays and weekends. Your next billing statement will show payments you made for the previous bill. You can go to the 'View Payment History' tab to display any payments you've made in the last 18 months. If made a duplicate payment, it will be refunded.|
	|132A62931||How long does it take for my payments to show in this site?|It can take about 24 hours for payments to show on this site (until then it will show "payment processing"). Payments you make before 5:00 pm Eastern Time usually process the same day, or the next day if submitted after 5:00 pm. Note that processing of payments can be delayed by bank holidays and weekends. Your next billing statement will show payments you made for the previous bill. You can go to the 'View Payment History' tab to display any payments you've made in the last 18 months. If made a duplicate payment, it will be refunded.|
	|344M74484||How long does it take for my payments to show in this site?|It can take about 24 hours for payments to show on this site (until then it will show "payment processing"). Payments you make before 5:00 pm Eastern Time usually process the same day, or the next day if submitted after 5:00 pm. Note that processing of payments can be delayed by bank holidays and weekends. Your next billing statement will show payments you made for the previous bill. You can go to the 'View Payment History' tab to display any payments you've made in the last 18 months. If made a duplicate payment, it will be refunded.|
	|377A72560||How long does it take for my payments to show in this site?|It can take about 24 hours for payments to show on this site (until then it will show "payment processing"). Payments you make before 5:00 pm Eastern Time usually process the same day, or the next day if submitted after 5:00 pm. Note that processing of payments can be delayed by bank holidays and weekends. Your next billing statement will show payments you made for the previous bill. You can go to the 'View Payment History' tab to display any payments you've made in the last 18 months. If made a duplicate payment, it will be refunded.|
	|454A62919||How long does it take for my payments to show in this site?|It can take about 24 hours for payments to show on this site (until then it will show "payment processing"). Payments you make before 5:00 pm Eastern Time usually process the same day, or the next day if submitted after 5:00 pm. Note that processing of payments can be delayed by bank holidays and weekends. Your next billing statement will show payments you made for the previous bill. You can go to the 'View Payment History' tab to display any payments you've made in the last 18 months. If made a duplicate payment, it will be refunded.|
	|594A72431||How long does it take for my payments to show in this site?|It can take about 24 hours for payments to show on this site (until then it will show "payment processing"). Payments you make before 5:00 pm Eastern Time usually process the same day, or the next day if submitted after 5:00 pm. Note that processing of payments can be delayed by bank holidays and weekends. Your next billing statement will show payments you made for the previous bill. You can go to the 'View Payment History' tab to display any payments you've made in the last 18 months. If made a duplicate payment, it will be refunded.|
	|772A70223||How long does it take for my payments to show in this site?|It can take about 24 hours for payments to show on this site (until then it will show "payment processing"). Payments you make before 5:00 pm Eastern Time usually process the same day, or the next day if submitted after 5:00 pm. Note that processing of payments can be delayed by bank holidays and weekends. Your next billing statement will show payments you made for the previous bill. You can go to the 'View Payment History' tab to display any payments you've made in the last 18 months. If made a duplicate payment, it will be refunded.|
	|603M77792||How long does it take for my payments to show in this site?|It can take about 24 hours for payments to show on this site (until then it will show "payment processing"). Payments you make before 5:00 pm Eastern Time usually process the same day, or the next day if submitted after 5:00 pm. Note that processing of payments can be delayed by bank holidays and weekends. Your next billing statement will show payments you made for the previous bill. You can go to the 'View Payment History' tab to display any payments you've made in the last 18 months. If made a duplicate payment, it will be refunded.|
	|327M77857||How long does it take for my payments to show in this site?|It can take about 24 hours for payments to show on this site (until then it will show "payment processing"). Payments you make before 5:00 pm Eastern Time usually process the same day, or the next day if submitted after 5:00 pm. Note that processing of payments can be delayed by bank holidays and weekends. Your next billing statement will show payments you made for the previous bill. You can go to the 'View Payment History' tab to display any payments you've made in the last 18 months. If made a duplicate payment, it will be refunded.|
	|440M77845||How long does it take for my payments to show in this site?|It can take about 24 hours for payments to show on this site (until then it will show "payment processing"). Payments you make before 5:00 pm Eastern Time usually process the same day, or the next day if submitted after 5:00 pm. Note that processing of payments can be delayed by bank holidays and weekends. Your next billing statement will show payments you made for the previous bill. You can go to the 'View Payment History' tab to display any payments you've made in the last 18 months. If made a duplicate payment, it will be refunded.|
	
	@MWP-Sprint4 @PP-5536
Scenario Outline:FAQ
	  Given user is on MWP page
	  And enters "<HCID>" and "<SummaryBill>"
	  Then account summary page is displayed
	  When user clicks on the FAQ link
	  Then FAQ tab should open
	  Then Verify FAQ content with "<FAQquestion>" and "<FAQanswer>"
	  Examples:
	|HCID|SummaryBill|FAQquestion|FAQanswer|
	|132A62931||My policy may have been cancelled. If I make a payment now, will the policy be reinstated?|Payments made on this site do not guarantee reinstatement of a cancelled policy, and this site might not show the current status of your policy. If you think your policy has been cancelled, please call the Customer Service number on your ID card.|
	|132A62931||My policy may have been cancelled. If I make a payment now, will the policy be reinstated?|Payments made on this site do not guarantee reinstatement of a cancelled policy, and this site might not show the current status of your policy. If you think your policy has been cancelled, please call the Customer Service number on your ID card.|
	|344M74484||My policy may have been cancelled. If I make a payment now, will the policy be reinstated?|Payments made on this site do not guarantee reinstatement of a cancelled policy, and this site might not show the current status of your policy. If you think your policy has been cancelled, please call the Customer Service number on your ID card.|
	|377A72560||My policy may have been cancelled. If I make a payment now, will the policy be reinstated?|Payments made on this site do not guarantee reinstatement of a cancelled policy, and this site might not show the current status of your policy. If you think your policy has been cancelled, please call the Customer Service number on your ID card.|
	|454A62919||My policy may have been cancelled. If I make a payment now, will the policy be reinstated?|Payments made on this site do not guarantee reinstatement of a cancelled policy, and this site might not show the current status of your policy. If you think your policy has been cancelled, please call the Customer Service number on your ID card.|
	|594A72431||My policy may have been cancelled. If I make a payment now, will the policy be reinstated?|Payments made on this site do not guarantee reinstatement of a cancelled policy, and this site might not show the current status of your policy. If you think your policy has been cancelled, please call the Customer Service number on your ID card.|
	|772A70223||My policy may have been cancelled. If I make a payment now, will the policy be reinstated?|Payments made on this site do not guarantee reinstatement of a cancelled policy, and this site might not show the current status of your policy. If you think your policy has been cancelled, please call the Customer Service number on your ID card.|
	|603M77792||My policy may have been cancelled. If I make a payment now, will the policy be reinstated?|Payments made on this site do not guarantee reinstatement of a cancelled policy, and this site might not show the current status of your policy. If you think your policy has been cancelled, please call the Customer Service number on your ID card.|
	|327M77857||My policy may have been cancelled. If I make a payment now, will the policy be reinstated?|Payments made on this site do not guarantee reinstatement of a cancelled policy, and this site might not show the current status of your policy. If you think your policy has been cancelled, please call the Customer Service number on your ID card.|
	|440M77845||My policy may have been cancelled. If I make a payment now, will the policy be reinstated?|Payments made on this site do not guarantee reinstatement of a cancelled policy, and this site might not show the current status of your policy. If you think your policy has been cancelled, please call the Customer Service number on your ID card.|
	
	#PP-4069User Story
	@MWP-Sprint4 @PP-5537
	Scenario Outline:MWP payment @MWPRegression
	Given user is on MWP page
	And enters "<HCID>" and "<SummaryBill>"
	And user clicks on PayNow with "<HCID>" and "<Product>"
	Then Make OneTimePayment with "<SavedPaymentmethod>"
	Then verify paymentSuccess page
Examples:
	|HCID|SummaryBill|Product|SavedPaymentmethod|
	|377A72560|||Visa ending in 2562 - CreditTest|
	|603M77792|||Master card ending in 2537 - Test|
	
	@Cancelpayment
	Scenario Outline:MWP payment
	Given user is on MWP page
	And enters "<HCID>" and "<SummaryBill>"
	Then user able to see the payment inprogress "<HCID>"
	Then Cancel the payment
Examples:
	|HCID|SummaryBill|Product|
	|377A72560|||
	|603M77792|||
	
	@MWP-Sprint4 @PP-5538
	Scenario Outline:MWP payment
	Given user is on MWP page
	And enters "<HCID>" and "<SummaryBill>"
	And user clicks on PayNow with "<HCID>" and "<Product>"
	#And select payment method as "Enter new payment method"
	And select the enter new payment method as "Credit / Debit Card"
	And enter credit card details "<NickName>" and "<CardType>" and "<CardNo>" and "<Expiry>" and "<CardHolderName>"
	And enter the address in one time pay "<AddressType>"
	And click on the continue
	And user confirms information as accurate
	And click on the continue
	Then verify paymentSuccess page
Examples:
	|HCID     |SummaryBill|Product|NickName|CardType|CardNo             |Expiry|CardHolderName|AddressType|
	|454A62919|           |       |OTPtest |VISA	|4111111114362562	|09/2022|Sophia		|other	|
	
@MWP-Sprint4 @PP-5539
	Scenario Outline:MWP payment
	Given user is on MWP page
	And enters "<HCID>" and "<SummaryBill>"
	And user clicks on PayNow with "<HCID>" and "<Product>"
	And select payment method as "Enter new payment method"
	And select the enter new payment method as "Credit / Debit Card"
	And enter credit card details "<NickName>" and "<CardType>" and "<CardNo>" and "<Expiry>" and "<CardHolderName>"
	And enter the address in one time pay "<AddressType>"
	And check this account for future use
	And click on the continue
	And user confirms information as accurate
	And click on the continue
	Then verify paymentSuccess page
Examples:
	|HCID     |SummaryBill|Product|NickName|CardType|CardNo             |Expiry|CardHolderName|AddressType|
	|011T91353|           |       |OTPtest |VISA	|4111111114362687	|09/2022|Sophia		|subscriber	|
	
@MWP-Sprint4 @PP-5540
	Scenario Outline:MWP payment
	Given user is on MWP page
	And enters "<HCID>" and "<SummaryBill>"
	And user clicks on PayNow with "<HCID>" and "<Product>"
	And select payment method as "Enter new payment method"
	And select the enter new payment method as "Credit / Debit Card"
	And enter credit card details "<NickName>" and "<CardType>" and "<CardNo>" and "<Expiry>" and "<CardHolderName>"
	And enter the address in one time pay "<AddressType>"
	And check this account for future use
	And click on the continue
	And user confirms information as accurate
	And click on the continue
	Then verify paymentSuccess page
	Then click on managepaymentsmethods link
	Then verify paymentmethod with "<CardNo>" and "<AccountType>" and "<NickName>"
Examples:
	|HCID     |SummaryBill|Product|NickName|CardType|CardNo             |Expiry|CardHolderName|AddressType|AccountType|
	|726T92512|766869|       |OTPtest |VISA	|4111111114362687	|09/2022|Sophia		|alternate	|Credit / Debit Card|
#PP-3183 user story
@MWP-Sprint4 @PP-5560
Scenario Outline:Account Summary Details
	Given user is on MWP page
	And enter the details with "<HCID>" and "<SummaryBill>"
	Then Verify AccountSummaryProducts details with "<HCID>"
Examples:
|HCID     |SummaryBill|
|971T65483|           |

@MWP-Sprint4 @PP-5561
Scenario Outline:Account SUmmary Details
	Given user is on MWP page
	And enter the details with "<HCID>" and "<SummaryBill>"
	Then Verify MinimumDue is not present with "<HCID>"
Examples:
|HCID     |SummaryBill|
|971T65483|           |

@MWP-Sprint4 @PP-5562
Scenario Outline:View Bill link in Account summary
	Given user is on MWP page
	And enter the details with "<HCID>" and "<SummaryBill>"
	Then verify viewBillpdf link for signedup electronicbill user
Examples:
|HCID     |SummaryBill|
|976T90665|           |

@MWP-Sprint4 @PP-5564
Scenario Outline:Cancel the payment
	Given user is on MWP page
	And enter the details with "<HCID>" and "<SummaryBill>"
	And user clicks on PayNow with "<HCID>" and "<Product>"
	And select payment method as "Enter new payment method"
	And select the enter new payment method as "Credit / Debit Card"
	And enter credit card details "<NickName>" and "<CardType>" and "<CardNo>" and "<Expiry>" and "<CardHolderName>"
	And enter the address in one time pay "<AddressType>"
	And click on the continue
	And user confirms information as accurate
	And click on the continue
	Then verify paymentSuccess page
	Then clicks on BacktoAccountSummary
	Then user able to see the payment inprogress "<HCID>"
	Then Cancel the payment
	
Examples:
	|HCID     |SummaryBill|Product|NickName|CardType|CardNo             |Expiry|CardHolderName|AddressType|
	|405T91285|    |       |OTPtest |VISA	|4111111114362687	|09/2022|Sophia		|subscriber	|

@MWP-Sprint4 @PP-5566
Scenario Outline:Account SUmmary Details
	Given user is on MWP page
	And enter the details with "<HCID>" and "<SummaryBill>"
	And user clicks on PayNow with "<HCID>" and "<Product>"
	And select payment method as "Enter new payment method"
	And select the enter new payment method as "Credit / Debit Card"
	And enter credit card details "<NickName>" and "<CardType>" and "<CardNo>" and "<Expiry>" and "<CardHolderName>"
	And enter the address in one time pay "<AddressType>"
	And click on the continue
	And user confirms information as accurate
	And click on the continue
	Then verify paymentSuccess page
Examples:
	|HCID     |SummaryBill|Product|NickName|CardType|CardNo             |Expiry|CardHolderName|AddressType|
	|011T91353|           |       |OTPtest |VISA	|4111111114362687	|09/2022|Sophia		|subscriber	|

	
@MWP-Sprint4 @PP-5567_69
Scenario Outline:Account SUmmary Details
	Given user is on MWP page
	And enter the details with "<HCID>" and "<SummaryBill>"
	Then verify tooltipDescription "<Description>"
	
Examples:
	|HCID     |SummaryBill|Description|
	|971T65483|           |Our records show you are currently on an automatic recurring payment option where your premiums are automatically debited from your chosen account. If you wish to make a one time payment, you will first need to cancel the automatic recurring payment option. Upon receiving your first invoice, you will then be able to make manual payments online. If you need to make changes to the financial account associated with your automatic recurring payment option, please go to to make those changes.|




@TC_MSP_Regression_CSR_Member_Payment_15 @Regression @pp-7023
Scenario Outline: Validate whether the user could able to view all the existing details when user is navigated to ‘Edit automatic payment’  page
Given user is on MWP CSR portal "<url>"
When user search using HCID "<hcid>"
Then portal shows the searched HCID page "<hcid>"
When user clicks on manage automatic payment
Then Manage automatic tab should open
When users click on the edit link
Then user should be able to view all the existing details "<CardType>" and "<CardNolastdigit>" and "<expiry>" and "<cardHolderName>"
Examples:
|url																		|hcid		|CardType	|CardNolastdigit|expiry	|cardHolderName|
#|https://va10tuvwbs067.wellpoint.com:19443/member/payment/secure/csr/search	|293A40083	|VISA		|1111			|02/2018|Potrla QA		|
|https://va10n10114.wellpoint.com:9443/member/payment/secure/csr/search	|293A40083	|VISA		|1111			|02/2018|Potrla QA		|

@TC_MSP_Regression_View_Paymen_History_16 @Regression @pp-7024
Scenario Outline: Validate whether the complete Payment history is displayed for last 18 months in View Payment History page
Given user is on MWP page
And enters "<hcid>" and ""
Then MWP portal shows the searched HCID page "<hcid>"
When user clicks on the view payments histrory link
Then View payment Histrory tab should open
And user able to check the dates are less than 18 months old
Examples:
|hcid|
|382T90798|

@TC_MSP_Regression_View_Payment_History_18 @Regression @pp-7026
Scenario Outline: Validate whether the member is able to download payment history in an excel format, via a link Download To Excel file present on the payment history page
Given user is on MWP page
And enters "<hcid>" and ""
Then MWP portal shows the searched HCID page "<hcid>"
When user clicks on the view payments histrory link
Then View payment Histrory tab should open
And user should be able to see the download to excel file link
Examples:
|hcid|
|382T90798|

@TC_MSP_Regression_CSR_Member_Payment_13 @Regression @pp-7021
Scenario Outline: Validate whether the logged in user can able to enter 9 digit HCID in the HCID Field.
Given user is on MWP CSR portal "<url>"
When user search using HCID
|929A07634|
Then portal shows the searched HCID page "<hcid>"
Given user is on MWP CSR portal "<url>"
When user search using HCID "929A076341234"
Then portal shows the searched HCID page "929A07634"
Given user is on MWP CSR portal "<url>"
When user search using HCID "929A"
Then portal should throw error showing HCID must be 9 character
Examples:
|url																		|hcid		|
#|https://va10tuvwbs067.wellpoint.com:19443/member/payment/secure/csr/search	|929A07634	|
|https://va10n10114.wellpoint.com:9443/member/payment/secure/csr/search|929A07634	|


@TC_MSP_Regression_CSR_Member_Payment_14 @Regression @pp-7022
Scenario Outline: Validate whether the user could able to view the “CSR Member Payment Account – Search” page, when user clicks on Back to search link
Given user is on MWP CSR portal "<url>"
When user search using HCID "<hcid>"
Then portal shows the searched HCID page "<hcid>"
When user clicks back to search button
Then User should be able to see CSR Member Payment Account Search page
Examples:
|url																		|hcid		|
#|https://va10tuvwbs067.wellpoint.com:19443/member/payment/secure/csr/search	|929A07634	|
|https://va10n10114.wellpoint.com:9443/member/payment/secure/csr/search|929A07634	|

@TC_MSP_Regression_View_Payment_History_19 @Regression @pp-7027
Scenario Outline: Validate whether the user can be able to view the viewing billing statements for dropdown to view the payment history of a Parent or linked member
Given user is on MWP page
And enters "<hcid>" and ""
Then MWP portal shows the searched HCID page "<hcid>"
When user clicks on the view payments histrory link
Then View payment Histrory tab should open
And user should be able to see the view billing statements for drop down "<parent name>"
And user should be able to see the view billing statements for drop down "<child name>"
Examples:
|hcid|parent name|child name|
|977T91168|Hasan Kamal|Susan Subscriber|

@TC_MSP_Regression_Submit_Payment_22 @Regression @pp-7030
Scenario Outline: Validate whether the user is able to view all the payment transactions when the payment is done for multiple accounts.
Given user is on MWP page
And enters "<hcid>" and ""
Then MWP portal shows the searched HCID page "<hcid>"
When user clicks on the view payments histrory link
Then View payment Histrory tab should open
And user should be able to see the view billing statements for drop down "<child name>"
And user able to check the dates are less than 18 months old
And user should be able to see the view billing statements for drop down "<parent name>"
And user able to check the dates are less than 18 months old
Examples:
|hcid|parent name|child name|
|977T91168|Hasan Kamal|Susan Subscriber|

@TC_MSP_Regression_Account_Summary_24 @Regression @pp-7032
Scenario Outline: Validate whether Sign up to get your bill by Email link is active in View Account Summary page
Given user is on MWP page
And enters "<hcid>" and ""
Then MWP portal shows the searched HCID page "<hcid>"
And user able to see the Sign up to get your bill by Email link
Examples:
|hcid|
|977T91168|

@TC_MSP_Regression_Account_Summary_25 @Regression @pp-7033
Scenario Outline: Validate whether the user is able to view the account information in the Account Summary page. 
Given user is on MWP page
And enters "<hcid>" and ""
Then MWP portal shows the searched HCID page "<hcid>"
And user able to verify the member details in account summary "<Plan Name>" and "<Subscriber Name>" and "<Bill Date>" and "<Minimum Due>" and "<Total Due>" and "<Due Date>" and "<BillStatus>"
Examples:
|hcid		|summarybill|Product Type|Plan Name|Subscriber Name	|Bill Date	|Minimum Due|Total Due	|Due Date	|BillStatus|
|051T50240	|||SV PPO 4000/0%/7150 2ER2	|Fname Lname	|07/20/2018	|$0.00		|$0.00		|01/01/2018	|Paid in Full|

#@pp-4313-5509 is not automated lly to 5507
@PP-4313-5510
Scenario Outline:Verify user navigate to managed linked bills page after linked account info is deleted
Given user is on MWP page
When user search using HCID in MWP portal "<Parent_hcid>"
Then MWP portal shows the searched HCID page "<Parent_hcid>"
When user clicks on the manage linked bill link
Then user is redirected to manage linked bill page
When user click on add new linked bill
Then user is redirected to add new linked bill page
When parent add child as new linked bill "<FName>" and "<LName>" and "<DOB>" and "<Child_hcid>"
And user is on MWP page
When user search using HCID in MWP portal "<Child_hcid>"
Then MWP portal shows the searched HCID page "<Child_hcid>"
When user clicks on the manage linked bill link
And user is redirected to manage linked bill page
Then child can approve the linked bill request of parent "<Parent_hcid>"
And user is on MWP page
When user search using HCID in MWP portal "<Parent_hcid>"
Then MWP portal shows the searched HCID page "<Parent_hcid>"
When user clicks on the manage linked bill link
Then user is redirected to manage linked bill page
And user removes the linked request "<Parent_hcid>"
And user is redirected to manage linked bill page 		
Examples:
|Parent_hcid|Child_hcid	|FName|LName	|DOB		|	
|593T93725|188T93703	|Cherry|Doe	|11/23/1956	|		

@PP-4129-5488 
Scenario Outline: Verify Medsupp member able to add child account to their account
Given user is on MWP page
When user search using HCID in MWP portal "<Parent_hcid>"
Then MWP portal shows the searched HCID page "<Parent_hcid>"
When user clicks on the manage linked bill link
Then user is redirected to manage linked bill page
When user click on add new linked bill
Then user is redirected to add new linked bill page
When parent add child as new linked bill "<FName>" and "<LName>" and "<DOB>" and "<Child_hcid>"
Examples:
|HCID|SummaryBill|	|Parent_hcid|Child_hcid	|FName|LName		|DOB		|NickName	|
|977T91168	|818T90834	|Susan|Subscriber	|01/01/1980	|			|
@PP-4129-5489 
Scenario Outline: Verify MA member able to add child account to their account
Given user is on MWP page
When user search using HCID in MWP portal "<Parent_hcid>"
Then MWP portal shows the searched HCID page "<Parent_hcid>"
When user clicks on the manage linked bill link
Then user is redirected to manage linked bill page
When user click on add new linked bill
Then user is redirected to add new linked bill page
When parent add child as new linked bill "<FName>" and "<LName>" and "<DOB>" and "<Child_hcid>"
Examples:
|HCID|SummaryBill|	|Parent_hcid|Child_hcid	|FName|LName		|DOB		|NickName	|
|977T91168	|818T90834	|Susan|Subscriber	|01/01/1980	|			|
#Verify email manually
@PP-4129-5490
Scenario Outline: Verify Medsupp member child receives link request via confirmation email after linking to Medsupp parent account
Given user is on MWP page
When user search using HCID in MWP portal "<Parent_hcid>"
Then MWP portal shows the searched HCID page "<Parent_hcid>"
When user clicks on the manage linked bill link
Then user is redirected to manage linked bill page
When user click on add new linked bill
Then user is redirected to add new linked bill page
When parent add child as new linked bill "<FName>" and "<LName>" and "<DOB>" and "<Child_hcid>"
Examples:
|HCID|SummaryBill|	|Parent_hcid|Child_hcid	|FName|LName		|DOB		|NickName	|
|977T91168	|818T90834	|Susan|Subscriber	|01/01/1980	|			|
#Verify email manually
@PP-4129-5491
Scenario Outline: Verify MA member child receives link request via confirmation email after linking to Medsupp parent account
Given user is on MWP page
When user search using HCID in MWP portal "<Parent_hcid>"
Then MWP portal shows the searched HCID page "<Parent_hcid>"
When user clicks on the manage linked bill link
Then user is redirected to manage linked bill page
When user click on add new linked bill
Then user is redirected to add new linked bill page
When parent add child as new linked bill "<FName>" and "<LName>" and "<DOB>" and "<Child_hcid>"
Examples:
|HCID|SummaryBill|	|Parent_hcid|Child_hcid	|FName|LName		|DOB		|NickName	|
|977T91168	|818T90834	|Susan|Subscriber	|01/01/1980	|			|
@PP-4129-5494
Scenario Outline: Verify Medsupp member able to see message Linking cannot be done
Given user is on MWP page
When user search using HCID in MWP portal "<Parent_hcid>"
Then MWP portal shows the searched HCID page "<Parent_hcid>"
When user clicks on the manage linked bill link
Then user is redirected to manage linked bill page
When user click on add new linked bill
Then user is redirected to add new linked bill page
When parent add child as new linked bill "<FName>" and "<LName>" and "<DOB>" and "<Child_hcid>"
Then verify error message Linking cannot done
Examples:
|HCID|SummaryBill|	|Parent_hcid|Child_hcid	|FName|LName		|DOB		|NickName	|
|977T91168	|818T90834	|Susan|Subscriber	|01/01/1980	|			|
@PP-4129-5495
Scenario Outline: Verify MA member able to see message Linking cannot be done
Given user is on MWP page
When user search using HCID in MWP portal "<Parent_hcid>"
Then MWP portal shows the searched HCID page "<Parent_hcid>"
When user clicks on the manage linked bill link
Then user is redirected to manage linked bill page
When user click on add new linked bill
Then user is redirected to add new linked bill page
When parent add child as new linked bill "<FName>" and "<LName>" and "<DOB>" and "<Child_hcid>"
Then verify error message Linking cannot done
Examples:
|HCID|SummaryBill|	|Parent_hcid|Child_hcid	|FName|LName		|DOB		|NickName	|
|977T91168	|818T90834	|Susan|Subscriber	|01/01/1980	|			|
@PP-4129-5499-1
Scenario Outline: Verfiy Medsupp member able to add child account to their account for following states GA
Given user is on MWP page
When user search using HCID in MWP portal "<Parent_hcid>"
Then MWP portal shows the searched HCID page "<Parent_hcid>"
When user clicks on the manage linked bill link
Then user is redirected to manage linked bill page
When user click on add new linked bill
Then user is redirected to add new linked bill page
When parent add child as new linked bill "<FName>" and "<LName>" and "<DOB>" and "<Child_hcid>"
Examples:
|HCID|SummaryBill|	|Parent_hcid|Child_hcid	|FName|LName		|DOB		|NickName	|
|977T91168	|818T90834	|Susan|Subscriber	|01/01/1980	|
@PP-4129-5499-2
Scenario Outline: Verfiy Medsupp member able to add child account to their account for following states NY(EBC)
Given user is on MWP page
When user search using HCID in MWP portal "<Parent_hcid>"
Then MWP portal shows the searched HCID page "<Parent_hcid>"
When user clicks on the manage linked bill link
Then user is redirected to manage linked bill page
When user click on add new linked bill
Then user is redirected to add new linked bill page
When parent add child as new linked bill "<FName>" and "<LName>" and "<DOB>" and "<Child_hcid>"
Examples:
|HCID|SummaryBill|	|Parent_hcid|Child_hcid	|FName|LName		|DOB		|NickName	|
|977T91168	|818T90834	|Susan|Subscriber	|01/01/1980	|
@PP-4129-5499-3
Scenario Outline: Verfiy Medsupp member able to add child account to their account for following states NY(EBCBS)
Given user is on MWP page
When user search using HCID in MWP portal "<Parent_hcid>"
Then MWP portal shows the searched HCID page "<Parent_hcid>"
When user clicks on the manage linked bill link
Then user is redirected to manage linked bill page
When user click on add new linked bill
Then user is redirected to add new linked bill page
When parent add child as new linked bill "<FName>" and "<LName>" and "<DOB>" and "<Child_hcid>"
Examples:
|HCID|SummaryBill|	|Parent_hcid|Child_hcid	|FName|LName		|DOB		|NickName	|
|977T91168	|818T90834	|Susan|Subscriber	|01/01/1980	|
@PP-4129-5499-4
Scenario Outline: Verfiy Medsupp member able to add child account to their account for following states CO
Given user is on MWP page
When user search using HCID in MWP portal "<Parent_hcid>"
Then MWP portal shows the searched HCID page "<Parent_hcid>"
When user clicks on the manage linked bill link
Then user is redirected to manage linked bill page
When user click on add new linked bill
Then user is redirected to add new linked bill page
When parent add child as new linked bill "<FName>" and "<LName>" and "<DOB>" and "<Child_hcid>"
Examples:
|HCID|SummaryBill|	|Parent_hcid|Child_hcid	|FName|LName		|DOB		|NickName	|
|977T91168	|818T90834	|Susan|Subscriber	|01/01/1980	|
@PP-4129-5499-5
Scenario Outline: Verfiy Medsupp member able to add child account to their account for following states CA
Given user is on MWP page
When user search using HCID in MWP portal "<Parent_hcid>"
Then MWP portal shows the searched HCID page "<Parent_hcid>"
When user clicks on the manage linked bill link
Then user is redirected to manage linked bill page
When user click on add new linked bill
Then user is redirected to add new linked bill page
When parent add child as new linked bill "<FName>" and "<LName>" and "<DOB>" and "<Child_hcid>"
Examples:
|HCID|SummaryBill|	|Parent_hcid|Child_hcid	|FName|LName		|DOB		|NickName	|
|977T91168	|818T90834	|Susan|Subscriber	|01/01/1980	|





@MWP-TC_MSP_Regression_Manage_Payment_Method_01 @Regression @PP-7000
Scenario Outline: Validate whether the "+Add new payment method" link is disabled after adding the fifth payment method in Manage payment method page
Given user is on MWP page
And enters "<HCID>" and "<SummaryBill>"
Then account summary page is displayed
Then click on managepaymentsmethods link
Then validate Add new payment method is enable
Then add new payment method link
Then select BankAccount as Payment method "<paymentMethod>" and enter "<nickName>" and "<accountType>" and "<routingNumber>" and "<accountNumber>" and "<reAccountNumber>" and "<accountHolderName>" and "<AddressAccount>" and "<address1>" and "<address2>" and "<city>" and "<state>" and "<zipCode>"
Then click on save button
Then validate Add new payment method is disable
Examples:
	|HCID|SummaryBill|paymentMethod|nickName|accountType|routingNumber|accountNumber|reAccountNumber|accountHolderName|AddressAccount|address1|address2|city|state|zipCode|
	|388T90043|763777|Banking Account||Personal Checking|071205850|71205850|71205850|rajan|subscriber|address1|address2|santa carla|CA|90001|	

@MWP-TC_MSP_Regression_Manage_Payment_Method_02 @Regression @PP-7001
Scenario Outline:Validate whether the system allows the user to add a new payment method, when there are no saved payment methods during one time payment
Given user is on MWP page
And enters "<HCID>" and "<SummaryBill>"
Then account summary page is displayed
#Then user clicks on paynow button "<HCID>" and "<accntType>"
Then user clicks on paynow button "<SummaryBill>" and "<accntType>"
And select payment method as "Enter new payment method"
Then select BankAccount as Payment method "<paymentMethod>" and enter "<nickName>" and "<accountType>" and "<routingNumber>" and "<accountNumber>" and "<reAccountNumber>" and "<accountHolderName>" and "<AddressAccount>" and "<address1>" and "<address2>" and "<city>" and "<state>" and "<zipCode>"
Then check remember account future purpose checkbox
Then click on continue button
Then check confirm check box click on continue
#Then verify_payment_confirmation "<HCID>"
Then verify_payment_confirmation "<SummaryBill>"
Examples:
	|HCID|SummaryBill|accntType|paymentMethod|nickName|accountType|routingNumber|accountNumber|reAccountNumber|accountHolderName|AddressAccount|address1|address2|city|state|zipCode|
	|053T50240|765041|Summary Bill|Banking Account|cherryyy|Personal Checking|071103473|71103473|71103473|rajan|subscriber|address1|address2|santa carla|CA|90001|

@MWP-TC_MSP_Regression_Manage_Payment_Method_03 @Regression @PP-7002
Scenario Outline:Validate whether the system allows the user to add a new payment method, when there are saved payment methods during one time payment
Given user is on MWP page
And enters "<HCID>" and "<SummaryBill>"
Then account summary page is displayed
Then user clicks on paynow button "<HCID>" and "<accntType>"
And select payment method as "Enter new payment method"
Then select BankAccount as Payment method "<paymentMethod>" and enter "<nickName>" and "<accountType>" and "<routingNumber>" and "<accountNumber>" and "<reAccountNumber>" and "<accountHolderName>" and "<AddressAccount>" and "<address1>" and "<address2>" and "<city>" and "<state>" and "<zipCode>"
Then check remember account future purpose checkbox
Then click on continue button
Then check confirm check box click on continue
Then verify_payment_confirmation "<HCID>"
				
Examples:
	|HCID|SummaryBill|accntType|paymentMethod|nickName|accountType|routingNumber|accountNumber|reAccountNumber|accountHolderName|AddressAccount|address1|address2|city|state|zipCode|
	|874T90795||Medical|Banking Account|cherry|Personal Checking|071103473|71103473|71103473|rajan|subscriber|address1|address2|santa carla|CA|90001|		
	
@MWP-TC_MSP_Regression_Manage_Payment_Method_05 @Regression @pp-7004
Scenario Outline:Validate whether the Removal of Payment method results in removal of Recurring Payment schedule setup by the parent for the child for both parent and linked-in account
Given user is on MWP page
And enters "<HCID>" and "<SummaryBill>"
Then account summary page is displayed
When click on managepaymentsmethods link
And add new payment method link
And select BankAccount as Payment method "<paymentMethod>" and enter "<nickName>" and "<accountType>" and "<routingNumber>" and "<accountNumber>" and "<reAccountNumber>" and "<accountHolderName>" and "<AddressAccount>" and "<address1>" and "<address2>" and "<city>" and "<state>" and "<zipCode>"
And click on save button
And click on manage automatic payments link
And click on new automatic payment
And select product "<HCID>" and "<plan>" and "<payment method>" and "<pay day>"
And click on automatic payment save button
And click on managepaymentsmethods link
And click on delete option for accountNumber "<last4digit>"
And click on confirm button
And click on manage automatic payments link
Then user able to verify the removal of recurring payment schedule "<HCID>" and "<plan>" and "<payment method>" and "<pay day>"
Examples:
|HCID		|SummaryBill|last4digit	|paymentMethod	|nickName	|accountType		|routingNumber	|accountNumber	|reAccountNumber|accountHolderName	|AddressAccount	|address1|address2|city			|state	|zipCode|plan			|payment method						|pay day|
|624T90975 	|			|*3385		|Banking Account|cherry		|Personal Checking	|071103473		|71103473		|71103473		|rajan				|subscriber		|address1|address2|santa carla	|CA		|90001	|Medical Account|Checking ending in 3385 - cherry	|2		|



@TC_MSP_Regression_View_Payment_History_17 @Regression @pp-7025
Scenario Outline: Validate whether the user could not be able to view the specific Product Type for Summary Bill in Account Field since Summary bill will not have specific product type
Given user is on MWP page
And enters "<hcid>" and "<summarybill>"
Then MWP portal shows the searched HCID page "<summarybill>"
And MWP portal shows the searched HCID page "<Product Type>"
And user able to verify the member details in account summary "<Plan Name>" and "<Subscriber Name>" and "<Bill Date>" and "<Minimum Due>" and "<Total Due>" and "<Due Date>" and "<BillStatus>"
Examples:
|hcid		|summarybill|Product Type|Plan Name|Subscriber Name	|Bill Date	|Minimum Due|Total Due	|Due Date	|BillStatus|
|053T50240	|765041|Summary Bill|Summary Bill	|Fname Lname	|10/16/2018	|$311.34		|$311.34		|10/01/2017	|Pay Now|

@TC_MSP_Regression_View_Bill_09 @Regression @pp-7009
Scenario Outline: Validate whether View bill Link is not available for the users who have not signed up for electronic bills
Given user is on MWP page
And enters "<hcid>" and ""
Then MWP portal shows the searched HCID page "<hcid>"
And user able to see no view bill link is available
Examples:
|hcid|
|977T91168|

@TC_MSP_Regression_View_Bill_08 @Regression @pp-7008
Scenario Outline: Validate whether View bill Link is available in Account Summary page for both the Parent/Linked Account
Given user is on MWP page
And enters "<hcid>" and ""
Then MWP portal shows the searched HCID page "<hcid>"
And user able to see view bill link is available
Examples:
|hcid|
|976T90665|

@TC_MSP_Regression_View_Payment_History_20 @Regression @pp-7028
Scenario Outline: Validate whether the user can be able to open the PDF by selecting the View link in the view bill column under viewing billing statements table. 
Given user is on MWP page
And enters "<hcid>" and ""
Then MWP portal shows the searched HCID page "<hcid>"
And user able to see view bill link is available
When user clicks on the view payments histrory link
Then View payment Histrory tab should open
When user clicks on the view link under view bill column
Then user able to see the PDF opened
Examples:
|hcid|
|976T90665|

@TC_MSP_Regression_Manage_Payment_Method_04 @Regression @PP-7003
Scenario Outline: Validate whether Bank account number field display only the last four digits with the remaining digits are being masked with asterisk symbols when it is entered with values in Choose a payment method (or) Add a new payment method page
Given user is on MWP page
And enters "<hcid>" and ""
Then MWP portal shows the searched HCID page "<hcid>"
When click on managepaymentsmethods link
And add new payment method link
And select BankAccount as Payment method "<paymentMethod>" and enter "<nickName>" and "<accountType>" and "<routingNumber>" and "<accountNumber>" and "<reAccountNumber>" and "<accountHolderName>" and "<AddressAccount>" and "<address1>" and "<address2>" and "<city>" and "<state>" and "<zipCode>"
And click on save button
Then user able to see account number in masked view "<accountNumber>" and "<paymentMethod>" and "<nickName>"
When user clicks on the account summary
And user clicks on the PAY NOW of HCID "<hcid>"
And select payment method as "Personal Checking ending in 3473 - cherry"
And click on the continue
Then user able to see the bank account number in masked "<accountNumber>"
When click on managepaymentsmethods link
Then click on delete option for accountNumber "*3473"
Then click on confirm button
Examples:
|hcid		|paymentMethod	|nickName	|accountType		|routingNumber	|accountNumber	|reAccountNumber|accountHolderName	|AddressAccount	|address1|address2|city			|state	|zipCode|
|382T90798	|Banking Account|cherry		|Personal Checking	|071103473		|71103473		|71103473		|rajan				|subscriber		|address1|address2|santa carla	|CA		|90001	|


@PP-Autopay3999 @Regression @pp-7034
Scenario Outline: Validate whether the user is able to navigate back to the Manage Automatic Payments page while clicking on Cancel button in Are you sure you want to delete this payments page.
Given user is on MWP page
And enter the details with "<HCID>" and "<SummaryBill>"
Then account summary page is displayed
And click on manage automatic payments link
And user tries to Cancel the Recurring Payment with "<MemberName>"
Then user able to verify the presence of recurring payment "<HCID>" and "<plan>" and "<payment method>" and "<pay day>"
Examples:
|HCID     |SummaryBill|MemberName		|plan			|payment method	|pay day|
#|391T90860|           |Antoinette Ancona|Vision Account	|Bank Account	|2nd	|
|792T91653|           |Tpp Test|Summary Bill:	|Bank Account	|2nd	|


#Sophia- 04/12/2018
@MWP-Regression_Scenario6 @Regression @pp-7005
Scenario Outline: Manage payment Methods
 		Given user is on MWP page
		And enters "<HCID>" and "<SummaryBill>"
		Then account summary page is displayed
		Then user clicks on manage payment
		Then Details are displayed when no saved payments
Examples:
	|HCID|SummaryBill|
	|006T91367 ||
@MWP-Regression_Scenario7_View @Regression @pp-7006
Scenario Outline: View payment methods
		Given user is on MWP page
		And enters "<HCID>" and "<SummaryBill>"
		Then account summary page is displayed
		Then user clicks on manage payment
		Then verify View payment method details with "<AccountNo>" and "<PaymentNickName>"
Examples:
	|HCID|SummaryBill|AccountNo|PaymentNickName|
	|388T90043|763777|7890|doubleditpay|

@MWP-Regression_Scenario7_Edit @Regression @pp-7007
Scenario Outline: Edit payment methods
		Given user is on MWP page
		And enters "<HCID>" and "<SummaryBill>"
		Then account summary page is displayed
		Then user clicks on manage payment
		Then Edit payment method details with "<AccountNo>" and "<PaymentNickName>" and "<NewPaymentNickName>"
Examples:
	|HCID|SummaryBill|AccountNo|PaymentNickName|NewPaymentNickName|
	|143T61044||1443|testingBankTT|testingBankTt|

@MWP-Regression_Scenario12_View @Regression @pp-7017
Scenario Outline: View automatic payment methods - CSR
		Given user is on MWP CSR portal "<url>"
		Then user search using HCID "<HCID>"
		Then portal shows the searched HCID page "<HCID>"
		Then user clicks on manage automatic payment
		Then verify automatic payment with "<MemberName>" and "<PaymentMethod>" and "<Paydate>"
Examples:
	|url|HCID|MemberName|PaymentMethod|Paydate|
	|https://va10n10114.wellpoint.com:9443/member/payment/secure/csr/search|791T90906|Jose Ctsuat|Credit/Debit Card|6|

@MWP-Regression_Scenario12_Add @Regression @pp-7018
Scenario Outline: Add automatic payment methods - CSR
		Given user is on MWP CSR portal "<url>"
		Then user search using HCID "<HCID>"
		Then portal shows the searched HCID page "<HCID>"
		Then user clicks on manage automatic payment
		Then Add automatic payment with "<EmailAddress>" and "<Authorizationvalue>" and "<paymentMethod>" and "<Paydate>"
Examples:
	|url|HCID|EmailAddress|Authorizationvalue|paymentMethod|Paydate|
	|https://va10n10114.wellpoint.com:9443/member/payment/secure/csr/search|791T90906|sophia.rani@anthem.com|Telephone|Checking ending in 3385|3|
@MWP-Regression_Addrecurringpayment @Regression 
Scenario Outline: Add automatic payment methods - MWP
		Given user is on MWP page
		And enters "<HCID>" and "<SummaryBill>"
		Then account summary page is displayed
		Then user clicks on manage automatic payment
		Then Add automatic payment with "<EmailAddress>" and "<Authorizationvalue>" and "<paymentMethod>" and "<Paydate>"
Examples:
	|HCID|EmailAddress|Authorizationvalue|paymentMethod|Paydate|
	|051T50240|sophia.rani@anthem.com|Telephone|Checking ending in 3385|3|
@MWP-Regression_Scenario12_Edit @Regression @pp-7019
Scenario Outline: Edit automatic payment methods - CSR
		Given user is on MWP CSR portal "<url>"
		Then user search using HCID "<HCID>"
		Then portal shows the searched HCID page "<HCID>"
		Then user clicks on manage automatic payment
		Then Edit automatic payment with "<MemberName>" and "<Paydate>" and "<EmailAddress>" and "<Authorizationvalue>" and "<NewPayDate>"
Examples:
	|url|HCID|MemberName|EmailAddress|Authorizationvalue|Paydate|NewPayDate|
	|https://va10n10114.wellpoint.com:9443/member/payment/secure/csr/search|791T90906|Jose Ctsuat|sophia.rani@anthem.com|Telephone|3|2|

@MWP-Regression_Scenario12_Delete @Regression @pp-7020
Scenario Outline: Delete automatic payment methods - CSR
		Given user is on MWP CSR portal "<url>"
		Then user search using HCID "<HCID>"
		Then portal shows the searched HCID page "<HCID>"
		Then user clicks on manage automatic payment
		Then Delete automatic payment with "<MemberName>" and "<PaymentMethod>" and "<Paydate>" and "<EmailAddress>" and "<Authorizationvalue>"
Examples:
	|url|HCID|MemberName|PaymentMethod|Paydate|EmailAddress|Authorizationvalue|
	|https://va10n10114.wellpoint.com:9443/member/payment/secure/csr/search|791T90906|Jose Ctsuat|Bank|2|sophia.rani@anthem.com|Telephone|
	
@MWP-Regression_Scenario10_View @Regression @pp-7010
Scenario Outline: Verify member is able to view the recurring payment setup
		Given user is on MWP page
		And enters "<HCID>" and "<SummaryBill>"
		Then account summary page is displayed
		Then View Recurring payment details with "<MemberName>" and "<Product>" and "<PayDate>"
Examples:
	|HCID|SummaryBill|MemberName|Product|PayDate|
	|737T90964||Jane Doe|Life Account: 737T90964|4th|
	
@MWP-Regression_Scenario10_Edit @Regression @pp-7011
Scenario Outline: Verify member is able to edit the recurring payment setup
		Given user is on MWP page
		And enters "<HCID>" and "<SummaryBill>"
		Then account summary page is displayed
		Then Edit Recurring payment details with "<MemberName>" and "<Product>" and "<PayDate>"
Examples:
	|HCID     |SummaryBill|MemberName|Product|PayDate|
	#|737T90964|           |Jane Doe|Life Account|4th   |
	|051T50240||Fname Lname|Medical Account|2nd|

@MWP-Regression_Scenario10_Delete @Regression @pp-7012
Scenario Outline:Verify member is able to delete the recurring payment setup
		Given user is on MWP page
		And enters "<HCID>" and "<SummaryBill>"
		Then account summary page is displayed
		Then Delete Recurring payment with "<MemberName>" and "<Product>" and "<PayDate>"
Examples:
	|HCID|SummaryBill|MemberName|Product|PayDate|
	#|737T90964|      |Jane Doe|Medical Account| |
	|051T50240||Fname Lname|Medical Account|2nd|
	
@MWP-Regression_Scenario21_FAQ @Regression @pp-7029
Scenario Outline:FAQ Order check
	  Given user is on MWP page
	  And enters "<HCID>" and "<SummaryBill>"
	  Then account summary page is displayed
	  When user clicks on the FAQ link
	  Then FAQ tab should open
	  Then Verify OCP_FAQ contentOrder with "<FAQquestion1>" and "<FAQquestion2>" and "<FAQquestion3>" and "<FAQquestion4>" and "<FAQquestion5>" and "<FAQquestion6>" and "<FAQquestion7>" and "<FAQquestion8>" and "<FAQquestion9>" and "<FAQquestion10>"
	  Examples:
	|HCID|SummaryBill|FAQquestion1|FAQquestion2|FAQquestion3|FAQquestion4|FAQquestion5|FAQquestion6|FAQquestion7|FAQquestion8|FAQquestion9|FAQquestion10|
	|143T61044||Can I save my banking and|How long does it take for my payments|How do I set up a linked account|I think my policy might have been cancelled|My old credit card just expired|Will I receive an email reminder|What is the|What does my|What kind of accounts|What is a linked account|

@MWP-Regression_Scenario23_SaveFutureUse @Regression @pp-7031
Scenario Outline:MWP payment
	Given user is on MWP page
	And enters "<HCID>" and "<SummaryBill>"
	And user clicks on PayNow with "<HCID>" and "<Product>"
	And select payment method as "Enter new payment method"
	And select the enter new payment method as "Credit / Debit Card"
	And enter credit card details "<NickName>" and "<CardType>" and "<CardNo>" and "<Expiry>" and "<CardHolderName>"
	And enter the address in one time pay "<AddressType>"
	And check this account for future use
	And click on the continue
	And user confirms information as accurate
	And click on the continue
	Then verify paymentSuccess page
	Then click on managepaymentsmethods link
	Then verify paymentmethod with "<CardNo>" and "<AccountType>" and "<NickName>"
Examples:
	|HCID     |SummaryBill|Product			|NickName		|CardType	|CardNo             |Expiry	|CardHolderName	|AddressType|AccountType		|
	|874T90795|           |Medical Account	|FutureUseTest 	|VISA		|4111111114362687	|09/2022|Sophia			|subscriber	|Credit / Debit Card|

@MWP-Regression_Scenario26_Linking_Unlinking @Regression
Scenario Outline:Linking and Unlinking of ISG member
Given user is on MWP page
When enters "<Parent_hcid>" and ""
Then MWP portal shows the searched HCID page "<Parent_hcid>"
When user clicks on the manage linked bill link
Then user is redirected to manage linked bill page
When user click on add new linked bill
Then user is redirected to add new linked bill page
When parent add child as new linked bill "<FName>" and "<LName>" and "<DOB>" and "<Child_hcid>"
And user is on MWP page
When enters "<Child_hcid>" and ""
When user clicks on the manage linked bill link
And user is redirected to manage linked bill page
Then child can approve the linked bill request of parent "<Parent_hcid>"
And child removes the linked request "<Parent_hcid>"
Examples:
|Parent_hcid|Child_hcid	|FName	|LName	|DOB		|
|391T90860	|394T90798	|Mashik	|Jina	|01/01/1980	|

@MWP_linking_Data
Scenario Outline:MWP data request for linking
Given user is on MWP page
When enters "<Parent_hcid>" and ""
When user clicks on the manage linked bill link
Then user is redirected to manage linked bill page
When user click on add new linked bill
Then user is redirected to add new linked bill page
When parent add child as new linked bill "<FName>" and "<LName>" and "<DOB>" and "<Child_hcid>"
And user is on MWP page
When enters "<Child_hcid>" and ""
When user clicks on the manage linked bill link
And user is redirected to manage linked bill page
Then child can approve the linked bill request of parent "<Parent_hcid>"
Examples:
|Parent_hcid|Child_hcid	|FName		|LName		|DOB		|
|326T91396	|379T65403	|Kizzy		|Cavender	|12/31/1973	|

@MWP_EditAutomaticPayment_2019
Scenario Outline:MWP data request for linking
		Given user is on MWP page
		And enters "<HCID>" and "<SummaryBill>"
		Then account summary page is displayed
		Then View Recurring payment details with "<MemberName>" and "<Product>" and "<PayDate>"
		Then verify the text present under Edit Automatic Payment Page with "<MemberName>" and "<p1>" and "<p2>"
Examples:
|HCID     |SummaryBill|MemberName	 |Product|PayDate|p1																																																																																																																																																																																																																																																																																																										|p2|
|599T92168|			  |Camilla Butler|Medical|1		 |I authorize Anthem Blue Cross and Blue Shield to either charge the credit/debit card if I have listed one or, in the alternative, to initiate debits (and/or corrections to previous debits) from my account with the financial institution indicated for payment of my Anthem Blue Cross and Blue Shieldpremiums. I understand monthly payments will be made on the day I’ve indicated or within 3 business days thereafter. I understand, unless otherwise specified, that all products under the noted Member ID will be set up with this monthly payment option. This includes medical, dental, life and vision coverage. The bank account or credit/debit card may be charged/debited as soon as this authorization is received by Anthem Blue Cross and Blue Shield . The monthly payment may vary as a result of changes(s) I make, such as, but not limited to, adding and removing dependents, changing place of residence, changing coverage and/or changes made by Anthem Blue Cross and Blue Shield of which I am notified according to my plan/policy. In addition, if changes  I make are close to the automatic withdrawal date, Anthem Blue Cross and Blue Shield may not be able to notify me before the withdrawal date.|I agree to pay any service charge that Anthem Blue Cross and Blue Shield may bill me because a debit/charge was not honored.|

@MWP_Regression_AddAuto_GARebranding @Regression
Scenario Outline:To verify the Language/Verbiage on Add Automatic payment page whether its showing  the ABCBS brand for GA state member in place of BCBSGA brand of CSR member portal  WHEN Today's date >= 01/01/2019 AND GA product effective date >= 01/01/2019
		Given user is on MWP page
		And enters "<HCID>" and "<SummaryBill>"
		Then account summary page is displayed
		#Then user clicks on manage automatic payment- CSR page
		Then click on manage automatic payments link
		Then click on new automatic payment
		Then verify GARebranding AutomaticPayment verbiage "<AutomaticVerbiageChange>"
		
Examples:
|HCID     |SummaryBill|AutomaticVerbiageChange|
|264T65155|			  |Anthem Blue Cross and Blue Shield|

@MWP_Regression_EditAuto_GARebranding @Regression
Scenario Outline:To verify the Language/Verbiage on Add Automatic payment page whether its showing  the ABCBS brand for GA state member in place of BCBSGA brand of CSR member portal  WHEN Today's date >= 01/01/2019 AND GA product effective date >= 01/01/2019
		Given user is on MWP page
		And enters "<HCID>" and "<SummaryBill>"
		Then account summary page is displayed
		#Then user clicks on manage automatic payment- CSR page
		Then click on manage automatic payments link
		Then click on Edit automatic payment link "<MemberName>"
		Then verify GARebranding AutomaticPayment verbiage "<AutomaticVerbiageChange>"
		
Examples:
|HCID     |SummaryBill|MemberName|AutomaticVerbiageChange|
|264T65155|			  | |Anthem Blue Cross and Blue Shield|
		
