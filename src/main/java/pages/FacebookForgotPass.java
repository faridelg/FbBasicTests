package pages;

import gen.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class FacebookForgotPass extends PageObject{

	By forgotLink = By.xpath("//*[@id='login_form']/table/tbody/tr[3]/td[2]/div/a");
	By byEmail = By.id ("send_email");
	By byGoogleAccount = By.id("recover_openid");
	By buttonReset = By.name("reset_action");
	By recoveryCodeEntry = By.id("recovery_code_entry");
	By identifyByEmail = By.id("identify_email");
	By buttonSearchAccount = By.id("did_submit");
	By newPassword = By.xpath("//*[@id='password_new']");
	
	public FacebookForgotPass(WebDriver driver) {
		super(driver);
	}
	
	// Verify link is available
	
	public void forgotLinkPresent(){
		Assert.assertEquals(driver.findElement(forgotLink).isDisplayed(), true);
	}
	
	//	Forgot your password
	public void clickOnForgotPass () {
		try{
			driver.findElement(forgotLink).click();
		}catch ( NoSuchElementException e ){
			System.out.println ( "'Forgot your password?' link not found.");
		}
	}
	
	// Enter id (email or phone)
	public void enterEmailOrPhone( String identification ){
		driver.findElement(identifyByEmail).sendKeys( identification );
	}
	
	//Click on Search account
	public void clickOnSearchAccount (){
		driver.findElement(buttonSearchAccount).click();
	}
	
	// Select 'send code by email"
	public void selectMethod( String methodToReceiveCode ){
		if ( methodToReceiveCode == "googleAccount"){
			try{
				driver.findElement(byGoogleAccount).click();
			}catch (ElementNotSelectableException e){
				System.out.println("Element not Selectable - By Google Account");
			}
		}
		else if ( methodToReceiveCode == "byEmail")
			try{
				driver.findElement(byEmail).click();
			}catch (ElementNotSelectableException e){
				System.out.println("Element not Selectable - By Email");
			}
	}
	
	
	//Request reset
	public void clickOnResetButton (){
		driver.findElement(buttonReset).click();
	}
	
	//Verify code entry 
	public void recoveryCodePresent(){
		Assert.assertTrue(driver.findElement(recoveryCodeEntry).isDisplayed());
	}
	
	//Entering a RecoveryCode
	public void enterRecoveryCode( String code ){
		driver.findElement(recoveryCodeEntry).sendKeys( code );
	}
	
	//Assert recovery code
	public void recoverCodeEntered( boolean result){
		Assert.assertEquals(driver.findElement(newPassword), result);
	}
}
