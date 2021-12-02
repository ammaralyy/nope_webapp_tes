package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcelReader;
import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationUsingDDTAndExcelTest extends TestBase {

	HomePage homepageObject;
	UserRegisterationPage userRegisterationPageObject;
	UserLoginPage userLoginPageObject;
	
	@DataProvider(name = "userData")
	public static Object[][] userData() throws IOException{
		
		ExcelReader excelReader = new ExcelReader();
		
		return excelReader.getExcelData();
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
