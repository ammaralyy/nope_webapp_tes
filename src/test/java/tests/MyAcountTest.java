package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.MyAcountPage;
import pages.UserLoginPage;
import pages.UserRegisterationPage;

public class MyAcountTest extends TestBase {

	HomePage homepageObject;
	UserRegisterationPage userRegisterationPageObject;
	UserLoginPage userLoginPageObject;
	MyAcountPage myAcountPageObject;
	
	String firstName = "ammar";
	String lastName = "aly";
	String email = "amar334@mail.com";
	String password = "12345678";
	String newPassword = "123456789";
	
	@Test(priority = 1, alwaysRun = true)
	public void userRegisteredSuccessfully(){
		
		homepageObject = new HomePage(driver);
		homepageObject.openRegisterationPage();
				
		userRegisterationPageObject = new UserRegisterationPage(driver);
		userRegisterationPageObject.userRegisteration(firstName, lastName, email, password);
				
		Assert.assertTrue(userRegisterationPageObject.successmessage.getText().contains("Your registration completed"));
		
	}
	
	@Test(dependsOnMethods = {"userRegisteredSuccessfully"})
	public void userChangePasswordfully(){
		
		myAcountPageObject = new MyAcountPage(driver);

		userRegisterationPageObject.openMyAcountPage();
		myAcountPageObject.openchangePassword();
		
		myAcountPageObject.changePassword(password, newPassword);
				
	}
	
	@Test(dependsOnMethods = {"userChangePasswordfully"})
	public void userRegisterLogout() {
		
		userRegisterationPageObject.userlogout();
	}
		
	@Test(dependsOnMethods = {"userRegisterLogout"})
	public void userLogedInSuccessfully(){
		
		homepageObject = new HomePage(driver);
		homepageObject.openLoginPage();
				
		userLoginPageObject = new UserLoginPage(driver);
		userLoginPageObject.userLogin(email, newPassword);
				
	}

}
