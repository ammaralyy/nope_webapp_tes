package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProprties;
import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationUsingDDTAndProprtiesFileTest extends TestBase {

	HomePage homepageObject;
	UserRegisterationPage userRegisterationPageObject;
	UserLoginPage userLoginPageObject;
	
	
	String firstName = LoadProprties.userData.getProperty("firstName");
	String lastName= LoadProprties.userData.getProperty("lastName");
	String email= LoadProprties.userData.getProperty("email");
	String password= LoadProprties.userData.getProperty("password");
	
	@Test(priority = 1, alwaysRun = true)
	public void userRegisteredSuccessfully(){
		
		homepageObject = new HomePage(driver);
		homepageObject.openRegisterationPage();
				
		userRegisterationPageObject = new UserRegisterationPage(driver);
		userRegisterationPageObject.userRegisteration(firstName, lastName, email, password);
				
		Assert.assertTrue(userRegisterationPageObject.successmessage.getText().contains("Your registration completed"));
		
		// log out
		userRegisterationPageObject.userlogout();
		
		// login
		homepageObject.openLoginPage();
		
		userLoginPageObject = new UserLoginPage(driver);
		userLoginPageObject.userLogin(email, password);
		
	}

}
