package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationUsingDDTAndFakerTest extends TestBase {

	HomePage homepageObject;
	UserRegisterationPage userRegisterationPageObject;
	UserLoginPage userLoginPageObject;
	
	Faker fakeData = new Faker(); 
	
	String firstname = fakeData.name().firstName(); 
	String lastname = fakeData.name().lastName(); 
	String email = fakeData.internet().emailAddress(); 
	String password = fakeData.number().digits(8).toString(); 
	
	@Test(priority = 1, alwaysRun = true)
	public void userRegisteredSuccessfully(){
		
		homepageObject = new HomePage(driver);
		homepageObject.openRegisterationPage();
				
		userRegisterationPageObject = new UserRegisterationPage(driver);
		userRegisterationPageObject.userRegisteration(firstname,lastname,email,password);
		
		System.out.println("The Userr Data is : "+ firstname + " " + lastname + " " + email + " " + password);
				
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
		userLoginPageObject.userLogin(email,password);
	}

}
