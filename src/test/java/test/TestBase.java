package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

public class TestBase {

	public static WebDriver driver = null;

	@BeforeTest
	public void initialize() throws Exception {

		
		
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/driver/chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-web-security","--disable-search-engine-choice-screen" , "--allow-running-insecure-content");

		
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://automationexercise.com/");
	}


	@AfterTest
	public void TeardownTest() {
		// Supprimer les cookies
           //driver.manage().deleteAllCookies();
        // Supprimer le cache
           //driver.manage().deleteLocalStorage(); // Supprimer le stockage local
           //driver.manage().deleteSessionStorage(); // Supprimer le stockage de session
		
		//TestBase.driver.quit();
	}

}
