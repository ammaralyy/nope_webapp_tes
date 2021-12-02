package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationUsingDDTAndDataProviderTest extends TestBase {

	HomePage homepageObject;
	UserRegisterationPage userRegisterationPageObject;
	UserLoginPage userLoginPageObject;
	
	
	@DataProvider
	public static Object[][] userData(){
		
		return new Object[][] {
			{"Ammar","Alyy","ammar3@mail.com","12345678"},
			{"wesam","khaled","wesam3@mail.com","12345678"}
		};
	}
	
	@Test(priority = 1, alwaysRun = true, dataProvider = "userData")
	public void userRegisteredSuccessfully(String firstName, String lastName, String email, String password){
		
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
