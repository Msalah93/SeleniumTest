package pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterAutomationExercicePage {

	WebDriver driver;

	public RegisterAutomationExercicePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@FindBy(xpath = "/html//section[@id='form']//form[@action='/signup']/input[@name='name']")
	WebElement nameTestBox;

	@FindBy(css = "[data-qa='signup-email']")
	WebElement emailTextBox;

	@FindBy(css = "[data-qa='signup-button']")
	WebElement signupButton;

	 @FindBy(css = ".fa.fa-lock")
	    private WebElement lockIcon;
	 
	public void clickOnlockIcon() {
		lockIcon.click();

	}
	
	public void setName(String strEmail) {
		nameTestBox.sendKeys(strEmail);

	}

	public void setEmail(String strEmail) {
		emailTextBox.sendKeys(strEmail);
	}
	
	 public static boolean isValidEmail(String email) {
	        // Pattern pour valider un email
	        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

	        // Création du pattern
	        Pattern pattern = Pattern.compile(emailRegex);

	        // Création du matcher
	        Matcher matcher = pattern.matcher(email);

	        // Vérification de la correspondance
	        return matcher.matches();
	    }

	public void clickOnSignupButton() {
		signupButton.click();
	}
}
