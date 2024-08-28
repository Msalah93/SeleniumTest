package listeners;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import test.TestBase;
import utils.ExtentManager;

public class Listener implements ITestListener {

	WebDriver driver;
	String filePath = "C:/Users/Med Salah/eclipse2023-workspace/Selenuim3Project/src/test/resources/rapports/";
	private ExtentReports extent = ExtentManager.createInstance(filePath);
	private ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("*****Test started : " + result.getName());
		test = extent.createTest(result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("*****Test Success : " + result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED", ExtentColor.GREEN));

	}

	public void takeScreenshot(String testName) {
		// Initialiser le pilote
		// WebDriver driver = new ChromeDriver();

		// Prendre une capture d'écran sur l'échec du test
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		// Formater l'heure actuelle dans un format valide pour les noms de fichiers
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH-mm-ss");
		String timestamp = LocalTime.now().format(formatter);

		// Définir le chemin du fichier de capture d'écran avec un nom valide
		String screenshotPath = System.getProperty("user.dir") + "/src/test/resources/Screenshots/fail_" + testName
				+ "_" + timestamp + ".png";

		// Copier la capture d'écran dans le fichier spécifié
		try {
			FileHandler.copy(srcFile, new File(screenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("*****Test Failed : " + result.getName());

		// Cette ligne récupère l'instance actuelle de la classe de test qui a échoué.
		Object currentClass = result.getInstance();
		// cette ligne obtient le pilote WebDriver à partir de l'instance de la classe
		// de test.
		// Elle suppose que la classe de test hérite de TestBase, où driver est déclaré.
		// Cela permet au listener d'accéder au pilote WebDriver pour capturer la
		// capture d'écran.
		driver = ((TestBase) currentClass).driver;
		// Cette ligne vérifie si le pilote WebDriver a été correctement initialisé et
		// n'est pas nul. Cela est important pour éviter une NullPointerException si le
		// pilote n'est pas disponible.
		if (driver != null) {
			// , cette ligne appelle une méthode takeScreenshot() pour capturer la capture
			// d'écran.
			takeScreenshot(result.getName());
		}

		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED", ExtentColor.RED));

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("*****Test Skipped : " + result.getName());

		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED", ExtentColor.ORANGE));

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {

		extent.flush();

	}

}
