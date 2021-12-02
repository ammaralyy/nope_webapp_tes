package tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.JsonReader;
import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationUsingDDTAndJSONTest extends TestBase {

	HomePage homepageObject;
	UserRegisterationPage userRegisterationPageObject;
	UserLoginPage userLoginPageObject;
		
	@Test(priority = 1, alwaysRun = true)
	public void userRegisteredSuccessfully() throws IOException, ParseException{
		
		JsonReader jsonReader = new JsonReader(); 
		jsonReader.JsonDataReader();

		homepageObject = new HomePage(driver);
		homepageObject.openRegisterationPage();
				
		userRegisterationPageObject = new UserRegisterationPage(driver);
		userRegisterationPageObject.userRegisteration(jsonReader.firstname,jsonReader.lastname,jsonReader.email,jsonReader.password);
				
		Assert.assertTrue(userRegisterationPageObject.successmessage.getText().contains("Your registration completed"));
		
		// log out
		userRegisterationPageObject.userlogout();
		
		// login
		homepageObject.openLoginPage();
		
		userLoginPageObject = new UserLoginPage(driver);
		userLoginPageObject.userLogin(jsonReader.email,jsonReader.password);
		
	}
	
	

			

}
