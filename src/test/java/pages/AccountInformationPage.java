package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AccountInformationPage {

	WebDriver driver;

	public AccountInformationPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	@FindBy(id = "id_gender1")
	WebElement mrRadioButton;

	@FindBy(id = "id_gender2")
	WebElement mrsRadioButton;

	@FindBy(css = "[data-qa='password']")
	WebElement passwordTextBox;

	@FindBy(id = "days")
	WebElement dayPicker;

	@FindBy(id = "months")
	WebElement monthPicker;

	@FindBy(id = "years")
	WebElement yearPicker;

	@FindBy(id = "newsletter")
	WebElement newsletterCheckBox;

	@FindBy(id = "optin")
	WebElement optinCheckBox;

	@FindBy(css = "[data-qa='first_name']")
	WebElement firstNameField;

	@FindBy(css = "[data-qa='last_name']")
	WebElement lastNameField;

	@FindBy(css = "[data-qa='company']")
	WebElement companyField;

	@FindBy(css = "[data-qa='address']")
	WebElement addressField;

	@FindBy(css = "[data-qa='address2']")
	WebElement address2Field;

	@FindBy(id = "country")
	private WebElement dropdownCountry;

	@FindBy(css = "[data-qa='state']")
	WebElement stateField;

	@FindBy(css = "[data-qa='city']")
	WebElement cityField;

	@FindBy(css = "[data-qa='zipcode']")
	WebElement zipcodeField;

	@FindBy(css = "[data-qa='mobile_number']")
	WebElement mobile_numberField;
	
	@FindBy(css = "[data-qa='create-account']")
	WebElement createAccountButton;

	public void setMrRadioButton() {
		mrRadioButton.click();

	}

	public void verifyMrRadioButtonSelected() {
		Assert.assertTrue(mrRadioButton.isSelected(), "Le premier bouton radio MR n'est pas sélectionné.");
	}

	public void setMrsRadioButton() {
		mrsRadioButton.click();

	}

	public void verifyMrsRadioButtonSelected() {
		Assert.assertTrue(mrsRadioButton.isSelected(), "Le premier bouton radio Mrs n'est pas sélectionné.");
	}

	public void setPassword(String passsword) {
		passwordTextBox.sendKeys(passsword);
		// System.out.println(passwordTextBox.getAttribute("value"));

	}

	public void verifyPassword() {
		Assert.assertTrue(!passwordTextBox.getAttribute("value").isEmpty(), "Le password est vide.");
	}

	// Méthode pour sélectionner une date
	public void selectDate(String day, String month, String year) {

		// Sélectionner le jour
		// On peut séléctionner avec "selectByValue()"
		Select dayDropdown = new Select(dayPicker);
		dayDropdown.selectByValue(day);
		// System.out.println(day);

		// Sélectionner le mois
		Select monthDropdown = new Select(monthPicker);
		monthDropdown.selectByValue(month);

		// Sélectionner l'année
		Select yearDropdown = new Select(yearPicker);
		yearDropdown.selectByValue(year);

	}

	// Méthode pour vérifier la date sélectionnée dans le date picker
//    public void verifySelectedDate(String expectedDay, String expectedMonth, String expectedYear) {
//        String actualDay = dayPicker.getAttribute("value");
//        String actualMonth = monthPicker.getAttribute("value");
//        String actualYear = yearPicker.getAttribute("value");
//        Assert.assertEquals(actualDay, expectedDay, "Le jour sélectionné n'est pas correct.");
//        Assert.assertEquals(actualMonth, expectedMonth, "Le mois sélectionné n'est pas correct.");
//        Assert.assertEquals(actualYear, expectedYear, "L'année sélectionnée n'est pas correcte.");
//    }
	public void verifySelectedDate() {
		Assert.assertTrue(!dayPicker.getAttribute("value").isEmpty(), "Le jour doit étre saisie");
		Assert.assertTrue(!monthPicker.getAttribute("value").isEmpty(), "Le mois doit étre saisie");
		Assert.assertTrue(!yearPicker.getAttribute("value").isEmpty(), "L'année doit étre saisie.");

	}

	public void setNewsletterCheckBox() {
		WebElement newsletCheckBox = new WebDriverWait(driver, 5000)
				.until(ExpectedConditions.elementToBeClickable(By.id("newsletter")));

		// permet de scroller
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", newsletCheckBox);

		// autre facon que scroller pour aller à un élément
		// Évitez les clics directs : Parfois, les interactions directes avec un élément
		// peuvent être interceptées. Dans ce cas, vous pouvez utiliser des actions pour
		// cliquer sur l'élément.
		// Actions actions = new Actions(driver);
		// actions.moveToElement(newsletCheckBox).click().perform()
		newsletCheckBox.click();

	}

	public void verifyNewsletterCheckBoxChecked() {
		Assert.assertTrue(newsletterCheckBox.isSelected(), "La newsletter case à cocher n'est pas cochée.");
	}

	public void setOptinCheckBox() {
		optinCheckBox.click();

	}

	public void verifyOptinCheckBoxChecked() {
		Assert.assertTrue(optinCheckBox.isSelected(), "La optinCheckBox case à cocher n'est pas cochée.");
	}

	public void serFirstName(String firstName) {
		firstNameField.sendKeys(firstName);

	}

//    public void firstNameIsnNotEmpty(String firstName) {
//        Assert.assertTrue(firstNameField.getAttribute("value").equals(firstName), "Le champ de saisie est correctement saisi.");
//
//	}
	public void verifFirstNameIsNotEmpty() {
		Assert.assertTrue(!firstNameField.getAttribute("value").isEmpty(), "Le prénom est vide");

	}

	public void setLastName(String lastName) {
		lastNameField.sendKeys(lastName);

	}

	public void verfiLastNameIsNotEmpty() {
		Assert.assertTrue(!lastNameField.getAttribute("value").isEmpty(), "Le nom est vide");

	}

//    public void flasstNameIsnNotEmpty(String firstName) {
//        Assert.assertTrue(firstNameField.getAttribute("value").equals(firstName), "Le champ de saisie est correctement saisi.");
//
//	}

	public void setcompanyField(String company) {
		companyField.sendKeys(company);

	}

	public void verifCompany(String lastName) {
		Assert.assertTrue(!companyField.getAttribute("value").isEmpty(), "Le champ company est vide");

	}

//    public void companyIsNotEmpty(String firstName) {
//        Assert.assertTrue(companyField.getAttribute("value").equals(firstName), "Le champ de saisie est correctement saisi.");
//
//	}
	public void setAddressField(String adress) {
		addressField.sendKeys(adress);

	}

	public void verifAddressIsNotEmpty() {

		Assert.assertTrue(!addressField.getAttribute("value").isEmpty(), "Le champ adress est vide");

	}

	public void setAddress2Field(String adress2) {
		address2Field.sendKeys(adress2);

	}

	public void verifAddress2IsNotEmpty() {

		Assert.assertTrue(!address2Field.getAttribute("value").isEmpty(), "Le champ adress 2 est vide");

	}

	public void setCountry(String optionText) {
		// Sélectionner une option dans la liste déroulante par son texte
		// Assurez-vous que votre liste déroulante utilise l'élément <option> pour
		// chaque choix
		dropdownCountry.sendKeys(optionText);
	}

	public String getSelectedOptionText() {
		// Récupérer le texte de l'option sélectionnée
		return dropdownCountry.getText();
	}

	public void verifContry() {
		Assert.assertTrue(!dropdownCountry.getAttribute("value").isEmpty(), "Le champ country est vide");

	}
	// à tester
//    public void verifContry(String actuelCoutnry , String expectedCountry) {
//        Assert.assertEquals(dropdownCountry.getAttribute("value"),expectedCountry, "Le champ de saisie vide");
//
//	}

	public void setstateFieldField(String state) {
		stateField.sendKeys(state);

	}

	public void verifStateFieldFieldIsNotEmty() {

		Assert.assertTrue(!stateField.getAttribute("value").isEmpty(), "Le champ state est vide");

	}

	public void setCityFieldField(String city) {
		cityField.sendKeys(city);

	}

	public void verifCityFieldIsNotEmty() {

		Assert.assertTrue(!cityField.getAttribute("value").isEmpty(), "Le champ city est vide");

	}

	public void setZipcodeField(String zipCode) {
		zipcodeField.sendKeys(zipCode);

	}

	public void verifZipcodeFieldIsNotEmty() {

		Assert.assertTrue(!zipcodeField.getAttribute("value").isEmpty(), "Le champ city est vide");

	}

	public void setMobileNumberField(String mobileNumber) {
		mobile_numberField.sendKeys(mobileNumber);

	}

	public void verifMobileNumberFieldIsNotEmty() {

		Assert.assertTrue(!mobile_numberField.getAttribute("value").isEmpty(), "Le champ mobile_numberField est vide");

	}
	
	public void createAccountClick() {
		Actions actions = new Actions(driver);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", createAccountButton);

		 //actions.moveToElement(createAccountButton).click().perform();
		createAccountButton.click();
	}

}
