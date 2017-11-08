package pages;

import gen.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class FacebookLogIn extends PageObject {

	By facebookUser = By.name("email");
	By facebookPassword = By.name("pass");
	By facebookLogInButton = By.id("loginbutton");
	By notificationsIcon = By.id("fbNotificationsJewel");
	By registerLink = By.id("reg-link");
		
	public FacebookLogIn(WebDriver driver) {
		super(driver);
	}
	
	//Verify user is at Home Page
	
	public void verifyHomePage (){
		Assert.assertEquals("Facebook - Log In or Sign Up", driver.getTitle());
	}

	
	// Set user
	public void setFacebookUser(String userName) {
		driver.findElement(facebookUser).sendKeys(userName);
	}

	// Set password

	public void setPassword(String password) {
		driver.findElement(facebookPassword).sendKeys(password);
	}

	// Submit login

	public void clickLoginButton() {
		driver.findElement(facebookLogInButton).click();
	}

	// LogInSuccesfully - Notifications icon is shown
	
	public void logInSuccessful ( ) {
		Assert.assertEquals(driver.findElement(notificationsIcon).isDisplayed(), true);
	}
	
	public void logInUnsuccessful ( ) {
		Assert.assertEquals( driver.findElement(registerLink).isDisplayed(), true);
	}
	

}
