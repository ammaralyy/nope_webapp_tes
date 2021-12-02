package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationTest extends TestBase {

	HomePage homepageObject;
	UserRegisterationPage userRegisterationPageObject;
	UserLoginPage userLoginPageObject;
	
	@Test(priority = 1, alwaysRun = true)
	public void userRegisteredSuccessfully(){
		
		homepageObject = new HomePage(driver);
		homepageObject.openRegisterationPage();
				
		userRegisterationPageObject = new UserRegisterationPage(driver);
		userRegisterationPageObject.userRegisteration("Ammar", "Alyy", "ammar36@mail.com", "12345678");
				
		Assert.assertTrue(userRegisterationPageObject.successmessage.getText().contains("Your registration completed"));
		
	}
	
	@Test(dependsOnMethods = {"userRegisteredSuccessfully"})
	public void userRegisterLogout() {
		
		userRegisterationPageObject.userlogout();
	}
	
	@Test(dependsOnMethods = {"userRegisterLogout"})
	public void userRegisterLogin() {
		
		homepageObject.openLoginPage();
		
		userLoginPageObject = new UserLoginPage(driver);
		userLoginPageObject.userLogin("ammar36@mail.com", "12345678");
	}

}
