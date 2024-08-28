package test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountInformationPage;
import pages.RegisterAutomationExercicePage;

public class AutomationExerciceRegisterTest extends TestBase {

	@Test(priority = 0,enabled = false)
	public void userSignUpwithWrongEmail() throws Exception {

		String invalidEmail = "test.example.com";
		RegisterAutomationExercicePage registernpage = PageFactory.initElements(driver,
				RegisterAutomationExercicePage.class);

		registernpage.clickOnlockIcon();
		registernpage.setName("Romdhana");
		registernpage.setEmail(invalidEmail);
		registernpage.clickOnSignupButton();

		Assert.assertFalse(RegisterAutomationExercicePage.isValidEmail(invalidEmail), "Le mail est non valide");

	}

	@Test(priority = 1,enabled = false)
	public void userSignUpwithWrightEmail() throws Exception {

		RegisterAutomationExercicePage registernpage = PageFactory.initElements(driver,
				RegisterAutomationExercicePage.class);

		String valiEmail = "salahzarg@gmail.com";

		registernpage.clickOnlockIcon();
		registernpage.setName("Romdhana");
		registernpage.setEmail(valiEmail);
		registernpage.clickOnSignupButton();
		Assert.assertTrue(RegisterAutomationExercicePage.isValidEmail(valiEmail), "Le mail est valide");

	}

	@Test(priority = 1)
	public void signUpwithEmailExist() throws Exception {

		RegisterAutomationExercicePage registernpage = PageFactory.initElements(driver,
				RegisterAutomationExercicePage.class);

		registernpage.clickOnlockIcon();
		registernpage.setName("Romdhana");
		registernpage.setEmail("salahzarg@gmail.com");
		registernpage.clickOnSignupButton();

		boolean isErrorDesplayed = driver
				.findElement(By.xpath(
						"//*[@id=\"form\"]/div/div/div[3]/div/form/p"))
				.isDisplayed();
				Assert.assertTrue(isErrorDesplayed, "Invalid password error message is not displayed");

	}

	@Test(priority = 4,enabled = false)
	public void registerFillForm() throws Exception {

		AccountInformationPage informationPage = PageFactory.initElements(driver, AccountInformationPage.class);

		userSignUpwithWrightEmail();

		informationPage.setMrRadioButton();
		informationPage.verifyMrRadioButtonSelected();
		informationPage.setPassword("558");
		informationPage.verifyPassword();
		informationPage.selectDate("12", "1", "2005");
		informationPage.verifySelectedDate();
		informationPage.setNewsletterCheckBox();
		informationPage.verifyNewsletterCheckBoxChecked();
		informationPage.setOptinCheckBox();
		informationPage.verifyOptinCheckBoxChecked();
		informationPage.serFirstName("mohamed");
		informationPage.verifFirstNameIsNotEmpty();
		informationPage.setLastName("romdhana");
		informationPage.verfiLastNameIsNotEmpty();
		informationPage.setcompanyField("open");
		informationPage.setAddressField("Bizerte");
		informationPage.verifAddressIsNotEmpty();
		informationPage.setAddressField(" b7ira");
		informationPage.setCountry("");
		informationPage.verifContry();
		informationPage.setstateFieldField("tunisia");
		informationPage.verifStateFieldFieldIsNotEmty();
		informationPage.setCityFieldField("tunis");
		informationPage.verifCityFieldIsNotEmty();
		informationPage.setZipcodeField("7053");
		informationPage.verifZipcodeFieldIsNotEmty();
		informationPage.setMobileNumberField("+21654786126");
		informationPage.verifMobileNumberFieldIsNotEmty();
		informationPage.createAccountClick();

	}

}