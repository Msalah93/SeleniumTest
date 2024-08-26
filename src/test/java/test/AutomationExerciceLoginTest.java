package test;

import javax.swing.text.html.CSS;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.AccountInformationPage;
import pages.GmailLoginPage;
import pages.LoginAutomatiionExerciciePage;
import pages.RegisterAutomationExercicePage;
import listeners.Listener;

public class AutomationExerciceLoginTest extends TestBase {

//	@Test
//	public void userlogin() throws Exception {
//
//		LoginAutomatiionExerciciePage loginPage = PageFactory.initElements(driver, LoginAutomatiionExerciciePage.class);
//
//		loginPage.clickOnlockIcon();
//		loginPage.setEmail("salahzarga1@gmail.com");
//		loginPage.verifEmailNotEmpty();
//		loginPage.setPassword("");
//		loginPage.verifPasswordNotEmpty();
//		loginPage.clickLoginButton();
//	}

	@Test
	public void userloginWitnIvalidPassword() throws Exception {

		String expectedErrorMessage = "Your email or password is incorrect!";

		LoginAutomatiionExerciciePage loginPage = PageFactory.initElements(driver, LoginAutomatiionExerciciePage.class);
		
		//driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div[2]/div[2]/button[1]/p")).click();
		
		loginPage.clickOnlockIcon();
		loginPage.setEmail("salahzarga1@gmail.com");
		loginPage.verifEmailNotEmpty();
		loginPage.setPassword("5482");
		loginPage.verifPasswordNotEmpty();
		loginPage.clickLoginButton();

		String actualErrorMessage = driver.findElement(By.xpath(
				"/html//section[@id='form']//form[@action='/login']/p[.='Your email or password is incorrect!']"))
				.getText();
		Assert.assertEquals(actualErrorMessage, expectedErrorMessage,
				"Invalid password error message is not displayed");
	}

	@Test
	public void userloginWitnIvalidPassword_Methode2() throws Exception {

		LoginAutomatiionExerciciePage loginPage = PageFactory.initElements(driver, LoginAutomatiionExerciciePage.class);

		loginPage.clickOnlockIcon();
		loginPage.setEmail("salahzarga1@gmail.com");
		loginPage.verifEmailNotEmpty();
		loginPage.setPassword("444");
		loginPage.verifPasswordNotEmpty();
		loginPage.clickLoginButton();

		boolean isErrorDesplayed = driver.findElement(By.xpath(
				"/html//section[@id='form']//form[@action='/login']/p[.='Your email or password is incorrect!']"))
				.isDisplayed();
		Assert.assertTrue(isErrorDesplayed, "Invalid password error message is not displayed");
	}
}
