package com.anthem.auto.step;

import java.util.List;

import com.anthem.auto.page.AbstractPage;
import com.anthem.enums.Environment;
import com.anthem.mwp.CSRLoginPage;
import com.anthem.mwp.FAQpage;
import com.anthem.mwp.MWPLogin;
import com.anthem.mwp.MWPManageLinkedBill;
import com.anthem.mwp.MWPManagePaymentMethods;
import com.anthem.mwp.MWPOneTimePayment;
import com.anthem.mwp.MWPSiteMinderPage;
import com.anthem.mwp.MWPViewPaymentHistory;
import com.anthem.mwp.MWPWebServerPage;
import com.anthem.mwp.ManageAutomaticPaymentMWP;
import com.anthem.mwp.ManageAutomaticPaymentRCP;
import com.anthem.mwp.MemberWebPatmentCSRSearchPage;
import com.anthem.mwp.MemberWebPaymentAddNewPaymentMethod;
import com.anthem.mwp.MemberWebPaymentCSRHomePage;
import com.anthem.mwp.MemberWebPaymentHomePage;
import com.anthem.mwp.MemberWebPaymentSearchPage;
import com.anthem.mwp.RCPLoginPage;
import com.anthem.utilities.PageUtils;
import com.anthem.utilities.WebDriverNavigation;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MWPSteps {

	public MemberWebPaymentSearchPage memberWebPaymentSearchPage;
	public MemberWebPaymentHomePage memberWebPaymentHomePage;
	private MemberWebPatmentCSRSearchPage memberWebPatmentCSRSearchPage;
	private MemberWebPaymentCSRHomePage memberWebPaymentCSRHomePage;
	private MWPWebServerPage mWPWebServerPage;
	private MWPSiteMinderPage mwpSiteminderPage;
	private CSRLoginPage cSRLoginPage;
	// private ScreenShotUtils screenShotUtils;
	public MWPLogin mwplogin;
	public ManageAutomaticPaymentMWP automaticpayment;
	public ManageAutomaticPaymentRCP RCPautomaticpayment;
	public RCPLoginPage RCPLoginpage;

	public MWPViewPaymentHistory MWPViewPaymentHistory;

	public MemberWebPaymentHomePage mwpHomePage;
	public MemberWebPaymentAddNewPaymentMethod addPaymentMethod;
	public MWPManagePaymentMethods paymentmethods;
	private MWPManageLinkedBill mWPManageLinkedBill;
	private MWPOneTimePayment mWPOneTimePayment;
	public FAQpage FaQpage;
	private MWPViewPaymentHistory mWPViewPaymentHistory;

	@Given("^user is on MWP page$")
	public void user_is_on_MWP_page() throws Throwable {
		System.out.println(Environment.getBaseUrl());
		WebDriverNavigation.navigateToURL(Environment.getBaseUrl());
		PageUtils.waitForLoad();
	}

	@Given("^user is on MSMA page$")
	public void user_is_on_MSMA_page() throws Throwable {
		System.out.println(Environment.getBaseUrl());
		WebDriverNavigation.navigateToURL(Environment.getBaseUrl());
		PageUtils.waitForLoad();
	}

	@Given("^enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enters_and(String arg1, String arg2) throws Throwable {
		memberWebPaymentSearchPage = AbstractPage.install(MemberWebPaymentSearchPage.class);
		//memberWebPaymentSearchPage.selectMSMA();
		memberWebPaymentSearchPage.navigateToAccountSummary(arg1, arg2);
	}

	@Then("^account summary page is displayed$")
	public void account_summary_page_is_displayed() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.titleIsDisplayed();
	}

	@Given("^user is on MWP CSR portal \"([^\"]*)\"$")
	public void userIsOnMWPCSRPoertal(String url) {
		WebDriverNavigation.navigateToURL(url);
		PageUtils.waitForLoad();
		memberWebPatmentCSRSearchPage = AbstractPage.install(MemberWebPatmentCSRSearchPage.class);
		memberWebPatmentCSRSearchPage.checkSearchPage();

	}

	@When("^user search using HCID \"([^\"]*)\"$")
	public void userSearchUsingHCID(String hcid) {
		memberWebPatmentCSRSearchPage = AbstractPage.install(MemberWebPatmentCSRSearchPage.class);
		memberWebPatmentCSRSearchPage.searchHcID(hcid);
	}

	@When("^user search using HCID$")
	public void userSearchCSRUsingHCID(DataTable hcid) {
		List<List<String>> data = hcid.raw();
		memberWebPatmentCSRSearchPage = AbstractPage.install(MemberWebPatmentCSRSearchPage.class);
		memberWebPatmentCSRSearchPage.searchHcID(data.get(0).get(0));
	}

	@Then("^portal shows the searched HCID page \"([^\"]*)\"$")
	public void portalShowsTheSearchedHCIDPage(String hcid) {
		memberWebPaymentCSRHomePage = AbstractPage.install(MemberWebPaymentCSRHomePage.class);
		memberWebPaymentCSRHomePage.checkForHomePage(hcid);
	}

	@Given("^user is on MWP portal \"([^\"]*)\"$")
	public void userIsOnMWPPortal(String url) {
		WebDriverNavigation.navigateToURL(url);
		PageUtils.waitForLoad();
		memberWebPaymentSearchPage = AbstractPage.install(MemberWebPaymentSearchPage.class);
		memberWebPaymentSearchPage.checkForSearchpage();
	}

	@Then("^user search using HCID in MWP portal \"([^\"]*)\"$")
	public void userSeachUsingHCIDInMWPPortal(String hcid) {
		memberWebPaymentSearchPage = AbstractPage.install(MemberWebPaymentSearchPage.class);
		//memberWebPaymentSearchPage.selectMSMA();
		memberWebPaymentSearchPage.searchHcID(hcid);
	}

	@Then("^user search using HCID in MWP portal For MWP \"([^\"]*)\"$")
	public void userSeachUsingHCIDInMWPPortalForMWP(String hcid) {
		memberWebPaymentSearchPage = AbstractPage.install(MemberWebPaymentSearchPage.class);
		memberWebPaymentSearchPage.searchHcID(hcid);
	}

	@When("^MWP portal shows the searched HCID page \"([^\"]*)\"$")
	public void mwpPortalShowsTheSearchedHCIDPage(String hcid) {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.checkForHomePage(hcid);
	}

	@Given("^user loads the MWP url \"([^\"]*)\"$")
	public void userLoadsTheMWPCSRUrl(String url) {
		WebDriverNavigation.navigateToURL(url);
		PageUtils.waitForLoad();
	}

	@Then("^MWP portal opens$")
	public void mWPCSRPortalOpens() {
		mWPWebServerPage = AbstractPage.install(MWPWebServerPage.class);
		mWPWebServerPage.checkForMWPPage();
	}

	@Given("^user is on MWP Siteminder portal \"([^\"]*)\"$")
	public void user_is_on_MWP_Siteminder_portal(String arg1) throws Throwable {
		WebDriverNavigation.navigateToURL(arg1);
		PageUtils.waitForLoad();

	}

	@Then("^MWP portal shows the login page")
	public void loginPage() {
		mwpSiteminderPage = AbstractPage.install(MWPSiteMinderPage.class);
		mwpSiteminderPage.checkPage();
	}

	@When("^user clicks on manage automatic payment$")
	public void userClicksOnManageAutomaticPayment() {
		memberWebPaymentCSRHomePage = AbstractPage.install(MemberWebPaymentCSRHomePage.class);
		memberWebPaymentCSRHomePage.clickMngAutPayLink();
	}

	@Then("^Manage automatic tab should open$")
	public void manageAutomaticTabShouldOpen() {
		memberWebPaymentCSRHomePage = AbstractPage.install(MemberWebPaymentCSRHomePage.class);
		memberWebPaymentCSRHomePage.checkMngAutPayTab();
	}

	@When("user clicks on manage payment")
	public void userClicksOnManagePayment() {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.clickMngPayMthd();
	}

	@Then("Manage payment method tab should open")
	public void managePaymentMethodTabShouldOpen() {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.chkMngPayMthd();
	}

	@When("^user clicks on the manage automatic payment link$")
	public void userClicksOnTheManageAutomaticPaymentLink() {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.clickMngAutPay();
	}

	@Then("^Manage automatic method tab should open$")
	public void manageAutomaticMethodTabShouldOpen() {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.chkMngAutPayTab();
	}

	@When("^user clicks on the view payments histrory link$")
	public void userClicksOnTheViewPaymentsHistroryLinks() {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.clickPayHistryLink();
	}

	@Then("^View payment Histrory tab should open$")
	public void viewPaymentHistoryTabShouldOpen() {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.waitForLoading();
		memberWebPaymentHomePage.waitForLoadingFrame();
		memberWebPaymentHomePage.chkViewPayHistryTab();
	}

	@When("^user clicks on the FAQ link$")
	public void userClicksOnTheFAQLink() {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.clickFAQLink();
	}

	@Then("^FAQ tab should open$")
	public void fAQTabShouldOpen() {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.chkFAQTab();
	}

	@Given("^user is on the webserver CSR portal \"([^\"]*)\"$")
	public void userIsOnTheWebserverCSRPortal(String url) {
		WebDriverNavigation.navigateToURL(url);
		PageUtils.waitForLoad();
		cSRLoginPage = AbstractPage.install(CSRLoginPage.class);
		cSRLoginPage.checkLoginPage();
	}

	@When("^user logins \"([^\"]*)\" and \"([^\"]*)\"$")
	public void userLogins(String username, String passowrd) {
		cSRLoginPage = AbstractPage.install(CSRLoginPage.class);
		cSRLoginPage.login(username, passowrd);
	}

	@Then("^user is on MWP CSR portal$")
	public void userIsonMWPCSRPortal() {
		memberWebPatmentCSRSearchPage = AbstractPage.install(MemberWebPatmentCSRSearchPage.class);
		memberWebPatmentCSRSearchPage.checkSearchPage();
	}
	// Sophia-01192018

	@And("^enter the details with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enter_the_details_with_and(String arg1, String arg2) throws Throwable {
		memberWebPaymentSearchPage = AbstractPage.install(MemberWebPaymentSearchPage.class);
		mwplogin = AbstractPage.install(MWPLogin.class);
	
		mwplogin.MWPLogin(arg1, arg2);

	}

	@Then("^View Recurring payment details with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void view_Recurring_payment_details_with_and_and(String arg1, String arg2, String arg3) throws Throwable {
		automaticpayment = AbstractPage.install(ManageAutomaticPaymentMWP.class);
		automaticpayment.ViewAutomaticPayment(arg1, arg2, arg3);
	}

	@Then("^Make payment with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void make_payment_with_and_and(String arg1, String arg2) throws Throwable {
		automaticpayment = AbstractPage.install(ManageAutomaticPaymentMWP.class);
		automaticpayment.MWPpayment(arg1, arg2);
	}
	@Then("^verify the text present under Edit Automatic Payment Page with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void verify_the_text_present_under_Edit_Automatic_Payment_Page_with_and_and(String arg1,String arg2,String arg3){
		automaticpayment = AbstractPage.install(ManageAutomaticPaymentMWP.class);
		automaticpayment.editAutomaticPaymentPageVerbiage(arg1,arg2,arg3);
	}

	@Then("^click on managepaymentsmethods link$")
	public void click_on_managepaymentsmethods_link() throws Throwable {
		mwpHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		mwpHomePage.clickMngPayMthd();
	}

	@Then("^add new payment method link$")
	public void add_new_payment_method_link() {
		addPaymentMethod = AbstractPage.install(MemberWebPaymentAddNewPaymentMethod.class);
		addPaymentMethod.addPaymentmethod();
	}

	@Then("^click on save button$")
	public void click_on_save_button() {
		addPaymentMethod = AbstractPage.install(MemberWebPaymentAddNewPaymentMethod.class);
		addPaymentMethod.savePayment();
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.waitForLoadingFrame(); 
		
	}

	@Then("^click on edit save button$")
	public void click_on_edit_save_button() {
		addPaymentMethod = AbstractPage.install(MemberWebPaymentAddNewPaymentMethod.class);
		addPaymentMethod.editbankSavePayment();
	}

	@Then("^verify manage payments method \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void verify_manage_payments_method_and_and_(String arg1, String arg2, String arg3) {
		addPaymentMethod = AbstractPage.install(MemberWebPaymentAddNewPaymentMethod.class);
		addPaymentMethod.verifyPaymentMethod(arg1, arg2, arg3);
	}

	@Then("^select BankAccount as Payment method \"([^\"]*)\" and enter \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void select_BankAccount_as_Payment_method_and_enter_and_and_and_and_and_and_and_and_and_and_and_(String arg1,
			String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9,
			String arg10, String arg11, String arg12, String arg13) {

		addPaymentMethod = AbstractPage.install(MemberWebPaymentAddNewPaymentMethod.class);
		addPaymentMethod.bankAccountPayment(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12,
				arg13);
	}

	@Then("^select creditcard as payment method \"([^\"]*)\" and enter \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void select_creditcard_as_payment_method_and_enter_and_and_and_and_and_and_and_and_and_and_(String arg1,
			String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8, String arg9,
			String arg10, String arg11, String arg12) {
		addPaymentMethod = AbstractPage.install(MemberWebPaymentAddNewPaymentMethod.class);
		addPaymentMethod.creditCard(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10, arg11, arg12);
	}

	@Then("^click on edit option for accountNumber \"([^\"]*)\"$")
	public void click_on_edit_option_for_accountNumber(String arg1) {
		addPaymentMethod = AbstractPage.install(MemberWebPaymentAddNewPaymentMethod.class);
		addPaymentMethod.editPayment(arg1);
	}

	@Then("^edit bankAccount nickName \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void edit_bankAccount_nickName_and_and_and_and_and_and_(String arg1, String arg2, String arg3, String arg4,
			String arg5, String arg6, String arg7) {
		addPaymentMethod = AbstractPage.install(MemberWebPaymentAddNewPaymentMethod.class);
		addPaymentMethod.editBankAccountPaymentMethod(arg1, arg2, arg3, arg4, arg5, arg6, arg7);
	}

	@Then("^edit creditcard nickName \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void edit_creditcard_nickName_and_and_and_and_and_and_and_(String arg1, String arg2, String arg3,
			String arg4, String arg5, String arg6, String arg7, String arg8) {
		addPaymentMethod = AbstractPage.install(MemberWebPaymentAddNewPaymentMethod.class);
		addPaymentMethod.editCreditCardPaymentMethod(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
	}

	@Then("^click on delete option for accountNumber \"([^\"]*)\"$")
	public void click_on_delete_option_for_accountNumber(String arg1) {
		addPaymentMethod = AbstractPage.install(MemberWebPaymentAddNewPaymentMethod.class);
		addPaymentMethod.deletePayment(arg1);
	}

	@Then("^click on confirm button$")
	public void click_on_confirm_button() {
		addPaymentMethod = AbstractPage.install(MemberWebPaymentAddNewPaymentMethod.class);
		addPaymentMethod.confirmDelete();
	}

	@Then("^click on manage automatic payments link$")
	public void click_on_manage_automatic_payments_link() {
		mwpHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		mwpHomePage.clickMngAutPay();
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.waitForLoading();
	}

	@Then("^click on new automatic payment$")
	public void click_on_new_automatic_payment() {
		automaticpayment = AbstractPage.install(ManageAutomaticPaymentMWP.class);
		automaticpayment.addAutomaticPayment();
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.waitForLoading();
	}

	@Then("^select product \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void select_product_and_and_and_(String arg1, String arg2, String arg3, String arg4) {
		automaticpayment = AbstractPage.install(ManageAutomaticPaymentMWP.class);
		automaticpayment.addNewAutomaticPayment(arg1, arg2, arg3, arg4);
	}

	@Then("^click on automatic payment save button$")
	public void click_on_automatic_payment_save_button() {
		automaticpayment = AbstractPage.install(ManageAutomaticPaymentMWP.class);
		automaticpayment.saveMethod();
		automaticpayment.addButtonAutomaticPayMethod();
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.waitForLoadingFrame();
	}

	@Then("^verify managepayment page$")
	public void verify_managepayment_page() {
		automaticpayment = AbstractPage.install(ManageAutomaticPaymentMWP.class);
		automaticpayment.verifyManageAutomaticPayment();
	}

	@Then("^Edit Recurring payment details with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void edit_Recurring_payment_details_with_and(String arg1, String arg2,String arg3) throws Throwable {
		automaticpayment = AbstractPage.install(ManageAutomaticPaymentMWP.class);
		automaticpayment.EditAutomaticPaymentDetails(arg1, arg2,arg3);
	}

	@Then("^Delete Recurring payment with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void delete_Recurring_payment_with(String arg1, String arg2, String arg3) throws Throwable {
		automaticpayment = AbstractPage.install(ManageAutomaticPaymentMWP.class);
		automaticpayment.DeleteAutomaticpayment(arg1, arg2, arg3);
	}

	@Then("^Verify user is not able to view the payment method details with \"([^\"]*)\"$")
	public void verify_user_is_not_able_to_view_the_payment_method_details_with(String arg1) throws Throwable {
		automaticpayment = AbstractPage.install(ManageAutomaticPaymentMWP.class);
		automaticpayment.notPresentPaymentMethod(arg1);
	}

	@Given("^enter the login details with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enter_the_login_details_with_and(String arg1, String arg2) throws Throwable {
		RCPLoginpage = AbstractPage.install(com.anthem.mwp.RCPLoginPage.class);
		RCPLoginpage.RCPLogin(arg1, arg2);
		// public ManageAutomaticPaymentRCP RCPautomaticpayment;
	}

	@Then("^View PayMyBills$")
	public void view_PayMyBills() throws Throwable {
		RCPautomaticpayment = AbstractPage.install(ManageAutomaticPaymentRCP.class);
		RCPautomaticpayment.ViewPayMyBills();
	}

	@When("^user clicks on the manage linked bill link$")
	public void userClicksOnTheManageLinkedBillLink() {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.clickManageLinkedAccntLink();
	}

	@Then("^user is redirected to manage linked bill page$")
	public void userIsRedirectedToManageLinkedBillPage() {
		mWPManageLinkedBill = AbstractPage.install(MWPManageLinkedBill.class);
		mWPManageLinkedBill.checkMngLinkedBllPage();
	}

	@When("^user click on add new linked bill$")
	public void userClickOnAddNewLinkedBill() {
		mWPManageLinkedBill = AbstractPage.install(MWPManageLinkedBill.class);
		mWPManageLinkedBill.clickAddNewLink();
	}

	@Then("^user is redirected to add new linked bill page$")
	public void userIsRedirectedToAddNewLinkedBillPage() {
		mWPManageLinkedBill = AbstractPage.install(MWPManageLinkedBill.class);
		mWPManageLinkedBill.checkAddNewBillPage();
	}

	@When("^parent add child as new linked bill \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void parentAddChildAsNewLinkedBill(String FName, String LName, String dob, String memberID) {
		mWPManageLinkedBill = AbstractPage.install(MWPManageLinkedBill.class);
		mWPManageLinkedBill.addNewLinkBill(FName, LName, dob, memberID);
	}

	@Then("^child can approve the linked bill request of parent \"([^\"]*)\"$")
	public void childCanApproveTheLinkedBillRequestOfParent(String memberID) {
		mWPManageLinkedBill = AbstractPage.install(MWPManageLinkedBill.class);
		mWPManageLinkedBill.approveLinkedRequest(memberID);
	}

	@And("child removes the linked request \"([^\"]*)\"$")
	public void childRemovesTheLinkedRequest(String memberID) {
		mWPManageLinkedBill = AbstractPage.install(MWPManageLinkedBill.class);
		mWPManageLinkedBill.removeLinkedRequest(memberID);
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.waitForLoadingFrame();
	}

	@Then("^child can reject the linked bill request of parent \"([^\"]*)\"$")
	public void childCanRejectTheLinkedBillRequestOfParent(String memberID) {
		mWPManageLinkedBill = AbstractPage.install(MWPManageLinkedBill.class);
		mWPManageLinkedBill.denyLinkedRequest(memberID);
	}

	@When("^user enters inavlid hcid details \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void userEntersInavlidHcidDetails(String FName, String LName, String dob, String memberID) {
		mWPManageLinkedBill = AbstractPage.install(MWPManageLinkedBill.class);
		mWPManageLinkedBill.enterNewLinkBillDetails(FName, LName, dob, memberID);
	}

	@Then("^user able to see invalid hcid error message$")
	public void userAbleToSeeInvalidHcidErrorMessage() {
		mWPManageLinkedBill = AbstractPage.install(MWPManageLinkedBill.class);
		mWPManageLinkedBill.checkInvalidHcid();
	}

	@When("^user clicks on the child PAY NOW \"([^\"]*)\"$")
	public void userClicksOnTheChildPAYNOW(String memberID) {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.clickPayNow(memberID, "");
		memberWebPaymentHomePage.waitForLoadingFrame();
	}

	@And("select payment method as \"([^\"]*)\"$")
	public void selectPaymentMethodAs(String howToPayMethod) {
		mWPOneTimePayment = AbstractPage.install(MWPOneTimePayment.class);
		mWPOneTimePayment.choosePaymentMethod(howToPayMethod);
	}

	@And("^select the enter new payment method as \"([^\"]*)\"$")
	public void selectTheEnterNewPaymentMethodAs(String paymentMethod) {
		mWPOneTimePayment = AbstractPage.install(MWPOneTimePayment.class);
		mWPOneTimePayment.selectEnterNewPayMethod(paymentMethod);
	}

	@And("^enter credit card details \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enterCreditCardDetails(String nickName, String cardType, String cardNumber, String expiry,
			String cardHolderName) {
		mWPOneTimePayment = AbstractPage.install(MWPOneTimePayment.class);
		mWPOneTimePayment.enterCardDetails(nickName, cardType, cardNumber, expiry, cardHolderName);
	}

	@And("^enter the address in one time pay \"([^\"]*)\"$")
	public void enterTheAddressInOneTimePay(String addressType) {
		mWPOneTimePayment = AbstractPage.install(MWPOneTimePayment.class);
		mWPOneTimePayment.enterSubscriberAddress(addressType, "", "", "", "", "");
	}

	@And("click on the continue")
	public void clickOnTheContinue() {
		mWPOneTimePayment = AbstractPage.install(MWPOneTimePayment.class);
		mWPOneTimePayment.clickContinue();
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.waitForLoadingFrame();
	}

	@And("user confirms information as accurate")
	public void userConfirmsInformationAsAccurate() {
		mWPOneTimePayment = AbstractPage.install(MWPOneTimePayment.class);
		mWPOneTimePayment.chkConfirm();
	}

	@Then("^user able to sumbit the payment \"([^\"]*)\"$")
	public void userAbleToSumbitThePayment(String memberID) {
		mWPOneTimePayment = AbstractPage.install(MWPOneTimePayment.class);
		mWPOneTimePayment.paymentConfirm(memberID);
	}

	@When("^user clicks on the account summary$")
	public void userClicksOnTheAccountSummary() {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.clickOnAccountSummary();
		memberWebPaymentHomePage.waitForLoading();
	}

	@Then("^user able to see the payment inprogress \"([^\"]*)\"$")
	public void userAbleToSeeThePaymentInprogress(String memberID) {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.checkPaymentInProgress(memberID);
	}

	@When("user removes the linked request \"([^\"]*)\"$")
	public void userRemovesTheLinkedRequest(String memberID) {
		mWPManageLinkedBill = AbstractPage.install(MWPManageLinkedBill.class);
		mWPManageLinkedBill.removeLinkedRequest(memberID);
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.waitForLoadingFrame();
	}

	@Then("^user able to see PAY NOW \"([^\"]*)\"$")
	public void userAbleToSeePAYNOW(String memberID) {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.checkPayNow(memberID, "");
	}

	@Then("^user clicks on paynow button \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_clicks_on_paynow_button_and_(String arg1, String arg2) {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.clickPayNow(arg1, arg2);
	}

	@Then("^select \"([^\"]*)\" and click on continue button$")
	public void select_and_click_on_continue_button(String arg1) {
		mWPOneTimePayment = AbstractPage.install(MWPOneTimePayment.class);
		mWPOneTimePayment.choosePaymentMethod(arg1);
	}

	@Then("^check confirm check box click on continue$")
	public void check_confirm_check_box_click_on_continue() {
		mWPOneTimePayment = AbstractPage.install(MWPOneTimePayment.class);
		mWPOneTimePayment.chkConfirm();
		mWPOneTimePayment.clickContinue();
	}

	@Then("^verify_payment_confirmation \"([^\"]*)\"$")
	public void verify_payment_confirmation(String arg1) {
		mWPOneTimePayment = AbstractPage.install(MWPOneTimePayment.class);
		mWPOneTimePayment.paymentConfirm(arg1);
	}

	@Then("^select oneTimePayment as \"([^\"]*)\"$")
	public void select_oneTimePayment_as_(String arg1) {
		mWPOneTimePayment = AbstractPage.install(MWPOneTimePayment.class);
		mWPOneTimePayment.selectEnterNewPayMethod(arg1);

	}

	@Then("^check remember account future purpose checkbox$")
	public void check_remember_account_future_purpose_checkbox() {
		mWPOneTimePayment = AbstractPage.install(MWPOneTimePayment.class);
		mWPOneTimePayment.clickRemberChkBox();
	}

	@Then("^click on continue button$")
	public void click_on_continue_button() {
		mWPOneTimePayment = AbstractPage.install(MWPOneTimePayment.class);
		mWPOneTimePayment.clickContinue();
	}

	@Then("^verify user able to see remove link \"([^\"]*)\"$")
	public void verify_user_able_to_see_remove_link(String memId) {
		mWPManageLinkedBill = AbstractPage.install(MWPManageLinkedBill.class);
		mWPManageLinkedBill.verifyRemoveLink(memId);
	}

	@Then("^verify veribage content confimation \"([^\"]*)\"$")
	public void verify_veribage_content_confimation(String id) {
		mWPManageLinkedBill = AbstractPage.install(MWPManageLinkedBill.class);
		mWPManageLinkedBill.verifyContentManageLinking(id);

	}

	// Sophia
	/*
	 * @Then("^Verify FAQ content with \"([^\"]*)\" and \"([^\"]*)\"$") public
	 * void verify_FAQ_content_with_and_and_and_and_and_and_(String arg1, String
	 * arg2) throws Throwable { FaQpage=AbstractPage.install(FAQpage.class);
	 * FaQpage.VerifyFAQdetails(arg1,arg2);
	 * 
	 * }
	 */

	@Then("^Verify FAQ content with \"([^\"]*)\" and (.*)$")
	public void verify_FAQ_content_with_and_and_and_and_and_and_(String arg1, String arg2) throws Throwable {
		FaQpage = AbstractPage.install(FAQpage.class);
		FaQpage.VerifyFAQdetails(arg1, arg2);

	}

	@Then("^Verify FAQ content with \"([^\"]*)\" and \"([^\"]*)\"remember this account for future use\"([^\"]*)\"Manage Payment Methods\"([^\"]*)\"$")
	public void verify_FAQ_content_with_and_remember_this_account_for_future_use_Manage_Payment_Methods(String arg1,
			String arg2, String arg3, String arg4) throws Throwable {
		FaQpage = AbstractPage.install(FAQpage.class);
		FaQpage.VerifyFAQdetails(arg1, arg2);
	}

	@Then("^Verify FAQ contentOrder with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void verify_FAQ_contentOrder_with_and_and_and_and_and_and_and_and(String arg1, String arg2, String arg3,
			String arg4, String arg5, String arg6, String arg7, String arg8, String arg9) throws Throwable {
		FaQpage = AbstractPage.install(FAQpage.class);
		FaQpage.FAQcontentOrderCheck(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9);

	}

	@Then("^Verify OCP_FAQ contentOrder with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void verify_OCP_FAQ_contentOrder_with_and_and_and_and_and_and_and_and(String arg1, String arg2, String arg3,
			String arg4, String arg5, String arg6, String arg7, String arg8, String arg9, String arg10)
			throws Throwable {
		FaQpage = AbstractPage.install(FAQpage.class);
		FaQpage.FAQcontentOrderCheck_OCP(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);

	}

	@Given("^user clicks on PayNow with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_clicks_on_PayNow_with_and(String arg1, String arg2) throws Throwable {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.clickPayNow(arg1, arg2);
	}

	@Then("^Make OneTimePayment with \"([^\"]*)\"$")
	public void make_OneTimePayment_with(String arg1) throws Throwable {
		mWPOneTimePayment = AbstractPage.install(MWPOneTimePayment.class);
		mWPOneTimePayment.choosePaymentMethod(arg1);
		mWPOneTimePayment.clickContinue();
		mWPOneTimePayment.chkConfirm();
		mWPOneTimePayment.clickContinue();
	}

	@When("^parent add a new bank payment method \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\""
			+ " and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void parentAddANewBankPaymentMethod(String parentHcid, String paymentMethod, String nickName,
			String accountType, String routingNumber, String accountNumber, String reAccountNumber,
			String accountHolderName, String AddressAccount, String address1, String address2, String city,
			String state, String zipCode) {
		// searching with hcid
		memberWebPaymentSearchPage = AbstractPage.install(MemberWebPaymentSearchPage.class);
		memberWebPaymentSearchPage.selectMSMA();
		memberWebPaymentSearchPage.searchHcID(parentHcid);
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.checkForHomePage(parentHcid);
		// adding new payment method
		mwpHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		mwpHomePage.clickMngPayMthd();
		addPaymentMethod = AbstractPage.install(MemberWebPaymentAddNewPaymentMethod.class);
		addPaymentMethod.addPaymentmethod();
		addPaymentMethod.bankAccountPayment(paymentMethod, nickName, accountType, routingNumber, accountNumber,
				reAccountNumber, accountHolderName, AddressAccount, address1, address2, city, state, zipCode);
		addPaymentMethod.savePayment();
	}

	@And("^parent submit a payment \"([^\"]*)\" and \"([^\"]*)\"$")
	public void parentSubmitAPayment(String memberID, String howToPayMethod) {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.clickOnAccountSummary();
		memberWebPaymentHomePage.waitForLoading();
		memberWebPaymentHomePage.checkPayNow(memberID, "");
		memberWebPaymentHomePage.clickPayNow(memberID, "");
		mWPOneTimePayment = AbstractPage.install(MWPOneTimePayment.class);
		mWPOneTimePayment.choosePaymentMethod(howToPayMethod);
		mWPOneTimePayment.clickContinue();
		mWPOneTimePayment.chkConfirm();
		mWPOneTimePayment.clickContinue();
		mWPOneTimePayment.paymentConfirm(memberID);
	}

	@And("^parent deletes the payment method \"([^\"]*)\"$")
	public void parentDeletesThePaymentMethod(String last4Digit) {
		mwpHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		mwpHomePage.clickMngPayMthd();
		addPaymentMethod = AbstractPage.install(MemberWebPaymentAddNewPaymentMethod.class);
		addPaymentMethod.deletePayment(last4Digit);
		addPaymentMethod.confirmDelete();
	}

	@Then("^the inprogress payment should get canceled \"([^\"]*)\"$")
	public void theInprogressPaymentShouldGetCanceled(String memberID) {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.clickOnAccountSummary();
		memberWebPaymentHomePage.waitForLoading();
		memberWebPaymentHomePage.checkPayNow(memberID, "");
	}

	@When("^parent add a new card payment method \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" "
			+ "and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void parentAddANewCardPaymentMethod(String parentHcid, String paymentMethod, String nickName,
			String cardType, String cardNumber, String expiry, String cardHolderName, String addressAccount,
			String address1, String address2, String city, String state, String zipCode) {
		// searching with hcid
		memberWebPaymentSearchPage = AbstractPage.install(MemberWebPaymentSearchPage.class);
		memberWebPaymentSearchPage.selectMSMA();
		memberWebPaymentSearchPage.searchHcID(parentHcid);
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.checkForHomePage(parentHcid);
		// adding new payment method
		mwpHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		mwpHomePage.clickMngPayMthd();
		addPaymentMethod = AbstractPage.install(MemberWebPaymentAddNewPaymentMethod.class);
		addPaymentMethod.addPaymentmethod();
		addPaymentMethod.creditCard(paymentMethod, nickName, cardType, cardNumber, expiry, cardHolderName,
				addressAccount, address1, address2, city, state, zipCode);
		addPaymentMethod.savePayment();
	}

	@Then("^verify paymentSuccess page$")
	public void verifypaymentSuccesspage_() throws Throwable {

		automaticpayment = AbstractPage.install(ManageAutomaticPaymentMWP.class);
		automaticpayment.paymentSuccessMessage();
	}

	@And("^check this account for future use$")
	public void check_this_account_for_future_use() throws Throwable {
		mWPOneTimePayment = AbstractPage.install(MWPOneTimePayment.class);
		mWPOneTimePayment.clickRemberChkBox();
	}

	@Then("^verify paymentmethod with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void verify_paymentmethod_with_and_and(String arg1, String arg2, String arg3) throws Throwable {
		addPaymentMethod = AbstractPage.install(MemberWebPaymentAddNewPaymentMethod.class);
		addPaymentMethod.verifyPaymentMethod(arg1, arg2, arg3);
	}

	@Then("^Verify AccountSummaryProducts details with \"([^\"]*)\"$")
	public void verify_AccountSummaryProducts_details_with(String arg1) throws Throwable {
		mwpHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		mwpHomePage.AccountSummary(arg1);

	}

	@Then("^Verify MinimumDue is not present with \"([^\"]*)\"$")
	public void verifyMinimumDueisnotpresentwith_(String arg1) throws Throwable {
		mwpHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		mwpHomePage.verifyMinimumAmountdue(arg1);

	}

	@Then("^verify error message Linking cannot done$")
	public void verify_error_message_linking_cannot_done() {
		mWPManageLinkedBill = AbstractPage.install(MWPManageLinkedBill.class);
		mWPManageLinkedBill.checkInvalidHcid();
	}

	@And("^user able to see sign up link$")
	public void userAbleToSeeSignUpLink() {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.chkSignUPLink();
	}

	@And("page and number is displayed at top and buttom of the page of account summary page")
	public void pageAndNumberIsDisplayedAtTopAndButtomOfThePageOfAccountSummaryPage() {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.chkPageNumber();
	}

	@Then("^clicks on BacktoAccountSummary$")
	public void clicks_on_BacktoAccountSummary() throws Throwable {
		automaticpayment = AbstractPage.install(ManageAutomaticPaymentMWP.class);
		automaticpayment.click_BacktoAccountSummaryButton();
	}

	@Then("^Cancel the payment$")
	public void cancel_the_payment() throws Throwable {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.cancelInProcessPayment();
	}

	@Then("^verify tooltipDescription \"([^\"]*)\"$")
	public void verify_tooltipDescription(String arg1) throws Throwable {
		mwpHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		mwpHomePage.verifyToolTip(arg1);

	}

	@Then("^verify viewBillpdf link for signedup electronicbill user$")
	public void verify_viewBillpdf_link_for_signedup_electronicbill_user() throws Throwable {
		mwpHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		mwpHomePage.verifyViewBillpdflink();
	}

	@When("^user clicks Pay all$")
	public void userClicksPayAll() {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.clickPayAll();
	}

	@And("^enter bank account details \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void enterBankAccountDetails(String NickName, String AccntToPay, String BankRoutingNo, String BankAccntNo,
			String AccntHolderName) {
		mWPOneTimePayment = AbstractPage.install(MWPOneTimePayment.class);
		mWPOneTimePayment.enterBankDetails(NickName, AccntToPay, BankRoutingNo, BankAccntNo, BankAccntNo,
				AccntHolderName);
	}

	@When("^user clicks on the PAY NOW of HCID \"([^\"]*)\"$")
	public void userClicksOnThePAYNOWOfHCID(String memberID) {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.clickPayNow(memberID, "");
		memberWebPaymentHomePage.waitForLoadingFrame();
	}

	@When("^validate Add new payment method is enable$")
	public void validateAddnewpaymentmethodisenable() {
		addPaymentMethod = AbstractPage.install(MemberWebPaymentAddNewPaymentMethod.class);
		addPaymentMethod.verifyAddpaymentbutton();

	}

	@When("^validate Add new payment method is disable$")
	public void validateAddnewpaymentmethodisdisable() throws Exception {
		addPaymentMethod = AbstractPage.install(MemberWebPaymentAddNewPaymentMethod.class);
		addPaymentMethod.verifyAddpaymentbuttonDisable();
	}

	@Then("^user clicks on Payment History Tab$")
	public void user_clicks_on_payment_history_tab() {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.clickPayHistryLink();
	}

	@Then("^verify the HCID Payment History Details of \"([^\"]*)\" and \"([^\"]*)\" are present$")
	public void verify_the_HCID_Payment_History_Details_are_present(String memId, String accountType) {
		MWPViewPaymentHistory = AbstractPage.install(MWPViewPaymentHistory.class);
		//MWPViewPaymentHistory.memberplan(memId, accountType);
		MWPViewPaymentHistory.paymentHistory(memId, accountType);
	}

	@When("user clicks on the view payments history link")
	public void userClicksOnTheViewPaymentsHistoryLink() {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.clickPayHistryLink();
		memberWebPaymentHomePage.waitForLoading();
		memberWebPaymentHomePage.waitForLoadingFrame();
	}

	@Then("user should not able to see the eligibilty message")
	public void userShouldNotAbleToSeeTheEligibiltyMessage() {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.waitForLoading();
		memberWebPaymentHomePage.chkViewPayHistryTab();

		mWPViewPaymentHistory = AbstractPage.install(MWPViewPaymentHistory.class);
		mWPViewPaymentHistory.eligibityMessageForMSMA();
	}

	@Then("user should able to see the download link")
	public void userShouldAbleToSeeTheDownloadLink() {
		mWPViewPaymentHistory = AbstractPage.install(MWPViewPaymentHistory.class);
		mWPViewPaymentHistory.chkForDownldLink();
	}

	@And("^user tries to Cancel the Recurring Payment with \"([^\"]*)\"$")
	public void user_tries_to_cancel_the_Recurring_Payment(String arg1) {
		automaticpayment = AbstractPage.install(ManageAutomaticPaymentMWP.class);
		automaticpayment.cancelDeletionAutomaticPayment(arg1);
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.waitForLoadingFrame();
	}

	@Then("^user able to verify the presence of recurring payment \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void the_page_should_get_navigated_to_the_Manage_Automatic_Payments_Page(String Hcid, String plan, String payment_method, String payDay) {
		automaticpayment = AbstractPage.install(ManageAutomaticPaymentMWP.class);
		automaticpayment.checkPresenceOfRecurringPay(Hcid,  plan, payment_method, payDay);
	}

	// sophia-mwp regression
	@Then("^Details are displayed when no saved payments$")
	public void details_are_displayed_when_no_saved_payments() throws Throwable {
		paymentmethods = AbstractPage.install(MWPManagePaymentMethods.class);
		paymentmethods.verifyPaymentMethodsMessage();
	}

	@Then("^verify View payment method details with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void verify_View_payment_method_details_with_and(String arg1, String arg2) throws Throwable {
		paymentmethods = AbstractPage.install(MWPManagePaymentMethods.class);
		paymentmethods.ViewPaymentMethods(arg1, arg2);
	}

	@Then("^Edit payment method details with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void edit_payment_method_details_with_and(String arg1, String arg2, String arg3) throws Throwable {
		paymentmethods = AbstractPage.install(MWPManagePaymentMethods.class);
		paymentmethods.EditPaymentMethods(arg1, arg2, arg3);
	}

	@Then("^verify automatic payment with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void verify_automatic_payment_with_and_and(String arg1, String arg2, String arg3) throws Throwable {
		memberWebPatmentCSRSearchPage = AbstractPage.install(MemberWebPatmentCSRSearchPage.class);
		memberWebPatmentCSRSearchPage.viewAutomaticpayment(arg1, arg2, arg3);
	}

	@Then("^Add automatic payment with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void add_automatic_payment_with_and_and_and(String arg1, String arg2, String arg3, String arg4)
			throws Throwable {
		memberWebPatmentCSRSearchPage = AbstractPage.install(MemberWebPatmentCSRSearchPage.class);
		memberWebPatmentCSRSearchPage.AddAutomaticPayment(arg1, arg2, arg3, arg4);
	}

	@Then("^Edit automatic payment with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void edit_automatic_payment_with_and(String arg1, String arg2, String arg3, String arg4, String arg5)
			throws Throwable {
		memberWebPatmentCSRSearchPage = AbstractPage.install(MemberWebPatmentCSRSearchPage.class);
		memberWebPatmentCSRSearchPage.EditAutomaticPayment(arg1, arg2, arg3, arg4, arg5);
	}

	@Then("^Delete automatic payment with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void delete_automatic_payment_with_and_and(String arg1, String arg2, String arg3, String arg4, String arg5)
			throws Throwable {
		memberWebPatmentCSRSearchPage = AbstractPage.install(MemberWebPatmentCSRSearchPage.class);
		memberWebPatmentCSRSearchPage.DeleteAutomaticpayment(arg1, arg2, arg3, arg4, arg5);
	}

	@When("^users click on the edit link$")
	public void usersClickOnTheEditLink() {
		memberWebPaymentCSRHomePage = AbstractPage.install(MemberWebPaymentCSRHomePage.class);
		memberWebPaymentCSRHomePage.clickOnEdit();
	}

	@Then("^user should be able to view all the existing details \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void userShouldBeAbleToViewAllTheExistingDetails(String CardType, String CardNolastdigit, String expiry,
			String cardHolderName) {
		memberWebPaymentCSRHomePage = AbstractPage.install(MemberWebPaymentCSRHomePage.class);
		memberWebPaymentCSRHomePage.verifyDetailsAutomaticpayment(CardType, CardNolastdigit, expiry, cardHolderName);
	}

	@Then("portal should throw error showing HCID must be 9 character")
	public void portalShouldThrowErrorShowingHCIDMustBe9Character() {
		memberWebPatmentCSRSearchPage = AbstractPage.install(MemberWebPatmentCSRSearchPage.class);
		memberWebPatmentCSRSearchPage.chkHCIDErrormesg();
	}

	@When("^user clicks back to search button$")
	public void user_clicks_back_to_search_button() {
		memberWebPaymentCSRHomePage = AbstractPage.install(MemberWebPaymentCSRHomePage.class);
		memberWebPaymentCSRHomePage.clickBack2Search();
	}

	@Then("^User should be able to see CSR Member Payment Account Search page$")
	public void user_should_be_able_to_see_CSR_Member_Payment_Account_Search_page() {
		memberWebPatmentCSRSearchPage = AbstractPage.install(MemberWebPatmentCSRSearchPage.class);
		memberWebPatmentCSRSearchPage.checkSearchPage();
	}

	@And("^user should be able to see the download to excel file link$")
	public void user_should_be_able_to_see_the_download_to_excel_file_link() {
		mWPViewPaymentHistory = AbstractPage.install(MWPViewPaymentHistory.class);
		mWPViewPaymentHistory.chkForDownldLink();
	}

	@And("^user able to check the dates are less than 18 months old$")
	public void user_able_to_check_the_dates_are_less_than_18_months_old() throws Exception{
		mWPViewPaymentHistory = AbstractPage.install(MWPViewPaymentHistory.class);
		mWPViewPaymentHistory.chkForthecloumn();
		mWPViewPaymentHistory.chkNoPaymentHistoryMessage();
		mWPViewPaymentHistory.chkDateReceived();
	}

	@And("^user should be able to see the view billing statements for drop down \"([^\"]*)\"$")
	public void user_should_be_able_to_see_the_view_billing_statements_for_drop_down(String name) {
		mWPViewPaymentHistory = AbstractPage.install(MWPViewPaymentHistory.class);
		mWPViewPaymentHistory.selectViewBillingDropDown(name);
	}

	@When("^user able to see the Sign up to get your bill by Email link$")
	public void user_able_to_see_the_Sign_up_to_get_your_bill_by_Email_link() {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.chkSignUPLink();
	}

	@And("^user able to verify the member details in account summary \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_able_to_verify_the_member_details_in_account_summary(String planName, String subscriberName,
			String billDate, String minDue, String totalDue, String dueDate,String billstatus) {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.chkMemberDetailsInAcntSummry(planName, subscriberName, billDate, minDue, totalDue,
				dueDate,billstatus);
	}

	@And("^user able to see no view bill link is available$")
	public void user_able_to_see_no_view_bill_link_is_available() {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.verifyNoViewBillpdflink();
	}

	@And("^user able to see view bill link is available$")
	public void user_able_to_see_view_bill_link_is_available() {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.verifyViewBillpdflink();
	}

	@When("^user clicks on the view link under view bill column$")
	public void user_clicks_on_the_view_link_under_view_bill_column() {
		mWPViewPaymentHistory = AbstractPage.install(MWPViewPaymentHistory.class);
		mWPViewPaymentHistory.clkViewLink();
	}

	@Then("^user able to see the PDF opened$")
	public void user_able_to_see_the_PDF_opened() {
		PageUtils.waitForLoad();
	}

	@Then("^user able to see account number in masked view \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_able_to_see_account_number_in_masked_view(String AccountNumber, String accountType,
			String nickname) {
		addPaymentMethod = AbstractPage.install(MemberWebPaymentAddNewPaymentMethod.class);
		addPaymentMethod.verifyPaymentMethod(AccountNumber, accountType, nickname);
	}

	@Then("^user able to see the bank account number in masked \"([^\"]*)\"$")
	public void user_able_to_see_the_bank_account_number_in_masked(String accountNumber) {
		mWPOneTimePayment = AbstractPage.install(MWPOneTimePayment.class);
		mWPOneTimePayment.verifyTheAcntNo(accountNumber);
	}
	
	@Then("^user able to verify the removal of recurring payment schedule \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_able_to_verify_the_removal_of_recurring_payment_schedule(String Hcid, String plan, String payment_method, String payDay){
		automaticpayment = AbstractPage.install(ManageAutomaticPaymentMWP.class);
		automaticpayment.checkNoPresenceOfRecurringPay(Hcid,  plan,  payment_method,  payDay);
	}
	
	@Then("^user able to verify the minimum and total due in the review page \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_able_to_verify_the_minimum_and_total_due_in_the_review_page(String hcid, String minDue, String totalDue){
		mWPOneTimePayment = AbstractPage.install(MWPOneTimePayment.class);
		mWPOneTimePayment.reviewMinPayTotaoPay(hcid, minDue, totalDue);
	}
	
	@When("^user selects amount due type \"([^\"]*)\"$")
	public void user_selects_amount_due_type(String amountTypeDue){
		mWPOneTimePayment = AbstractPage.install(MWPOneTimePayment.class);
		mWPOneTimePayment.selectPayllAmountTypeDue(amountTypeDue);
	}
	
	@Then("^user able to verify the amount to pay according to type of due selected before$")
	public void user_able_to_verify_the_amount_to_pay_according_to_type_of_due_selected_before(){
		mWPOneTimePayment = AbstractPage.install(MWPOneTimePayment.class);
		mWPOneTimePayment.checkAmountChoosePayPage();
	}

	@Given("^user navigates to portal \"([^\"]*)\"$")
	public void user_navigates_to_portal(String url){
		WebDriverNavigation.navigateToURL(url);
		PageUtils.waitForLoad();
	}

	@And("^user able to see as enrolled in SSA$")
	public void user_able_to_see_as_enrolled_in_SSA(){
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.enrolledinSSA();
	}
	@And("^user able to see as enrolled in RRB$")
		public void user_able_to_see_as_enrolled_in_RRB(){
			memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
			memberWebPaymentHomePage.enrolledinRRB();

	}
	
	@Then("^user able to see AutomaticWithdrawalsOn in account summary \"([^\"]*)\"$")
	public void user_able_to_see_AutomaticWithdrawalsOn_in_account_summary(String arg1) throws Throwable {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.checkAutomaticWithdrawalsAreOn(arg1);
	}
	
	@Then("^user able to see TwoPartyBill in Account summary \"([^\"]*)\"$")
	public void user_able_to_see_TwoPartyBill_in_Account_summary(String arg1) throws Throwable {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.checkTwoPartyBill(arg1);
	}
	
	@Then("^verify downloadpdf is displayed for MAMember \"([^\"]*)\"$")
	public void verify_downloadpdf_is_displayed_for_MAMember(String arg1) throws Throwable {
		automaticpayment = AbstractPage.install(ManageAutomaticPaymentMWP.class);
		automaticpayment.verifyDownloadPDF_MAmember(arg1);  
	}
	
	@Then("^verify downloadpdf is displayed for MSMember \"([^\"]*)\"$")
	public void verify_downloadpdf_is_displayed_for_MSMember(String arg1) throws Throwable {
		automaticpayment = AbstractPage.install(ManageAutomaticPaymentMWP.class);
		automaticpayment.verifyDownloadPDF_MSmember(arg1);  
	}
	
	@And("^user able to verify the summarybill details in account summary \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_able_to_verify_the_summarybill_details_in_account_summary(String planName, String subscriberName,
			String billDate, String minDue, String totalDue, String dueDate,String billstatus) {
		memberWebPaymentHomePage = AbstractPage.install(MemberWebPaymentHomePage.class);
		memberWebPaymentHomePage.chkMemberDetailsInAcntSummry(planName, subscriberName, billDate, minDue, totalDue,
				dueDate,billstatus);
	}
	
	@Then("^verify the AddAutomaticpaymentmethod details with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void verify_the_AddAutomaticpaymentmethod_details_with_and_and_and_and_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6,String arg7) throws Throwable {
		automaticpayment = AbstractPage.install(ManageAutomaticPaymentMWP.class);
		automaticpayment.verifyAddautomaticpaymentpage(arg1,arg2,arg3,arg4,arg5,arg6,arg7);
	}
	
	@Given("^verify the AccountToPay page with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void verify_the_AccountToPay_page_with_and_and_and_and_and_and(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7) throws Throwable {
		mWPOneTimePayment = AbstractPage.install(MWPOneTimePayment.class);
		mWPOneTimePayment.verifyAccountToPayPage(arg1,arg2,arg3,arg4,arg5,arg6,arg7);
		
	}
	
	@Then("^View Add automatic payment with \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void View_add_automatic_payment_with_and_and_and(String arg1, String arg2, String arg3, String arg4)
			throws Throwable {
		memberWebPatmentCSRSearchPage = AbstractPage.install(MemberWebPatmentCSRSearchPage.class);
		memberWebPatmentCSRSearchPage.AddAutomaticPayment_View(arg1, arg2, arg3, arg4);
	}
	@Then("^verify GARebranding AutomaticPayment verbiage \"([^\"]*)\"$")
	public void verify_GARebranding_AutomaticPayment_verbiage(String arg1) throws Throwable {
		automaticpayment = AbstractPage.install(ManageAutomaticPaymentMWP.class);
		automaticpayment.verifyGARebranding_AutomaticPayment(arg1);
	}
	
	@Then("^click on Edit automatic payment link \"([^\"]*)\"$")
	public void click_on_Edit_automatic_payment_link(String arg1) throws Throwable {
		
		automaticpayment = AbstractPage.install(ManageAutomaticPaymentMWP.class);
		automaticpayment.ClickonEditAutomaticPayment(arg1);
	}
	
}
