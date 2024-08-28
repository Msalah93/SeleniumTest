package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginAutomatiionExerciciePage {

	WebDriver driver;

	public LoginAutomatiionExerciciePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@FindBy(xpath = "/html//section[@id='form']//form[@action='/login']/input[@name='email']")
	WebElement emailTestBox;

	@FindBy(css = "[data-qa='login-password']")
	WebElement passwordTextBox;

	@FindBy(css = "[data-qa='login-button']")
	WebElement loginButton;

	@FindBy(css = ".fa.fa-lock")
	private WebElement lockIcon;

	public void setEmail(String strEmail) {
		emailTestBox.sendKeys(strEmail);

	}
	
	public void verifEmailNotEmpty() {

		Assert.assertTrue(!emailTestBox.getAttribute("value").isEmpty(), "Le champ email est vide");

	}


	public void setPassword(String strPassword) {
		passwordTextBox.sendKeys(strPassword);
	}

	public void verifPasswordNotEmpty() {

		Assert.assertTrue(!passwordTextBox.getAttribute("value").isEmpty(), "Le champ password est vide");

	}
	public void clickLoginButton() {
		loginButton.click();
	}

	public void clickOnlockIcon() {
		lockIcon.click();
	}
}
