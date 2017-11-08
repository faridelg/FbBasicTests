package tests;

import gen.BrowserMgr;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.FacebookLogIn;

public class FacebookLogInSuccessfully extends BrowserMgr {
	
	@Test 
	@Parameters ({"validUserName", "validPassword"})
	public void logInSuccess( String userName, String password ) {
		
		FacebookLogIn logInPage = new FacebookLogIn(driver);
		
		//Verify user is @ home page
		logInPage.verifyHomePage();
		//Enter credentials
		logInPage.setFacebookUser(userName);
		logInPage.setPassword(password);
		logInPage.clickLoginButton();		
		//Assert Log In was successful
		logInPage.logInSuccessful();
	}
	
}
