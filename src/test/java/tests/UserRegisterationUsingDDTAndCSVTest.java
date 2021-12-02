package tests;

import java.io.FileReader;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegisterationPage;

public class UserRegisterationUsingDDTAndCSVTest extends TestBase {

	HomePage homepageObject;
	UserRegisterationPage userRegisterationPageObject;
	UserLoginPage userLoginPageObject;
	
	CSVReader reader ; 
	
	@Test(priority = 1, alwaysRun = true)
	public void userRegisteredSuccessfully() throws CsvValidationException, IOException{
		
		// get path of CSV file 
		String CSV_file = System.getProperty("user.dir") + "\\src\\test\\java\\data\\userData.csv";
		reader = new CSVReader(new FileReader(CSV_file)); 

		String[] csvCell ; 
		
		// while loop will be executed till the lastValue in CSV file . 
		while((csvCell = reader.readNext()) != null) 
		{
			String firstName = csvCell[0]; 
			String lastName = csvCell[1]; 
			String email = csvCell[2]; 
			String password = csvCell[3]; 

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
	
	

			

}
