package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import pages.GmailLoginPage;

public class GmailLoginTest extends TestBase { 
  
    @Test
    public void init() throws Exception { 
  
        GmailLoginPage loginpage =  
           PageFactory.initElements(driver, 
           GmailLoginPage.class); 
    
        loginpage.setEmail("salahzarga1@gmail.com"); 
        loginpage.clickOnNextButton(); 
        loginpage.setPassword("za_ha_test"); 
loginpage.clickOnNextButton(); 
    } 

}
