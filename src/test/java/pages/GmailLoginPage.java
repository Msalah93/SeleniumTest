package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GmailLoginPage {

	WebDriver driver;

	public GmailLoginPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(xpath =  "//input[@type='email']")
	WebElement emailTextBox;

	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordTextBox;

	@FindBy(xpath = "//div[@id='identifierNext']//button[@type='button']/span[@class='VfPpkd-vQzf8d']")
	WebElement nextButton;
	

	public void setEmail(String strEmail) { 
        emailTextBox.sendKeys(strEmail); 

}

	public void setPassword(String strPassword) {
		passwordTextBox.sendKeys(strPassword);
	}

	public void clickOnNextButton() {
		nextButton.click();
}
}
