package tests;

import gen.BrowserMgr;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.FacebookForgotPass;

public class FacebookForgotPassword extends BrowserMgr{

	@Test
	@Parameters ({"userName", "recoveryCode"})
	//Request new password using byEmail option and a valid recoveryCode
	public void requestPasswordReset( String userName, String recoveryCode) {
		
			FacebookForgotPass forgotPassPage = new FacebookForgotPass( driver );
			
			//Assert 'Forgot your password' is present
			forgotPassPage.forgotLinkPresent();
			forgotPassPage.clickOnForgotPass();
			forgotPassPage.enterEmailOrPhone ( userName );
			forgotPassPage.clickOnSearchAccount ();
			forgotPassPage.selectMethod( "byEmail" );
			forgotPassPage.clickOnResetButton();
			
			//Assert 'enter code' is present
			forgotPassPage.recoveryCodePresent();
			//Enter valid recovery code
			forgotPassPage.enterRecoveryCode( recoveryCode );
			forgotPassPage.clickOnResetButton();
			//Assert code was entered correctly
			forgotPassPage.recoverCodeEntered( true );

	}
}
