package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;


public class ContactUsTest extends TestBase {

	String fullName = "Ammar Alyy";
	String email = "ammar@mail.com";
	String enquiry = "Samsung Series 9 NP900X4C Premium Ultrabook";
	
	String successmessage = "Your enquiry has been successfully sent to the store owner.";

	HomePage homePage;
	ContactUsPage contactUsPageObject;
	
	@Test
	public void userUontactUs() throws InterruptedException {
		
		homePage = new HomePage(driver);
		contactUsPageObject = new ContactUsPage(driver);
		
		homePage.openContactus();
		
		contactUsPageObject.contactUs(fullName, email, enquiry);
		
		Assert.assertTrue(contactUsPageObject.successMessage.getText().equalsIgnoreCase(successmessage));
		
		System.out.println(contactUsPageObject.successMessage.getText());
		
	}
}
