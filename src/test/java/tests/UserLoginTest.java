package tests;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.UserLoginPage;

public class UserLoginTest extends TestBase {

	HomePage homepageObject;
	UserLoginPage userLoginPageObject;
	
	@Test
	public void userLogedInSuccessfully(){
		
		homepageObject = new HomePage(driver);
		homepageObject.openLoginPage();
				
		userLoginPageObject = new UserLoginPage(driver);
		userLoginPageObject.userLogin("ammar@mail.com", "12345678");
				
	}

}
