package tests;

import gen.BrowserMgr;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.FacebookLogIn;

public class FacebookLogInUnsuccessfully extends BrowserMgr{

	@Test
	@Parameters ({"invalidUserName", "invalidPassword"})
	public void logInUnsuccess( String userName, String password){
		
		FacebookLogIn logInPage = new FacebookLogIn(driver);
		
		//Verify user is @ home page
		logInPage.verifyHomePage();
		//Enter credentials
		logInPage.setFacebookUser(userName);
		logInPage.setPassword(password);
		logInPage.clickLoginButton();
	
		//Check Log In was unsuccessful
		logInPage.logInUnsuccessful( );
	}
}
