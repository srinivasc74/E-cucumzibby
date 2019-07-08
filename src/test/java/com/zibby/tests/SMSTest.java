/*package com.zibby.tests;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.zibby.pages.HomePage;
import com.zibby.pages.LoginPage;
import com.zibby.util.SMSUtil;

public class SMSTest {

    private WebDriver driver;
    private LoginPage page;
    private SMSUtil sms;
    private final String fromPhoneNumber = "1234567"; //this is the number your application uses


    public void setup(){
        driver = new ChromeDriver();
        page = new LoginPage(driver);
        sms = new SMSUtil();
    }

   
    public void smsTest(){
        //get a phone number
        String phoneNumber = sms.getNumber();

        //use the number in the application
        page.setNumber(phoneNumber);
        
        //some code which triggers application to send a SMS

        //get SMS
        String code = sms.getMessage(phoneNumber, fromPhoneNumber);

        //use the code
        
    }

}

*/
