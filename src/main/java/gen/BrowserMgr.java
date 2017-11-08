package gen;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import pages.FacebookForgotPass;

public class BrowserMgr {

	static int implicitWaitSeconds=5;
	static String URL = "https://www.facebook.com/";

	protected static WebDriver driver;

	@BeforeClass
	public static void setUpFF() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(implicitWaitSeconds, TimeUnit.SECONDS);
		driver.get( URL );
	}

	@AfterClass
	public static void closeBrowser() {
		driver.close();
	}
}
