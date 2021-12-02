package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.SearchResultPage;
import pages.UserRegisterationPage;


public class EmailFriendTest extends TestBase {

	String friendEmail = "ammar10@mail.com";
	String yourEmail = "ammar22@mail.com";
	String message = "This product is very cool";
	
	String successmessage = "Your message has been sent.";

	String productName = "Apple MacBook Pro 13-inch";
//	String productName = "Samsung Series 9 NP900X4C Premium Ultrabook";
	
	SearchPage searchPageObject;
	ProductDetailsPage productDetailsPageObject;
	SearchResultPage searchResultPageObject;
	EmailFriendPage emailFriendPageObject;
	HomePage homepageObject;
	UserRegisterationPage userRegisterationPageObject;
	
	@Test(priority = 1, alwaysRun = true)
	public void userRegisteredSuccessfully(){
		
		homepageObject = new HomePage(driver);
		homepageObject.openRegisterationPage();
				
		userRegisterationPageObject = new UserRegisterationPage(driver);
		userRegisterationPageObject.userRegisteration("Ammar", "Alyy", yourEmail, "12345678");
				
		Assert.assertTrue(userRegisterationPageObject.successmessage.getText().contains("Your registration completed"));
		
	}
	
	@Test(dependsOnMethods = {"userRegisteredSuccessfully"})
	public void userSearch() throws InterruptedException {
		
		searchPageObject = new SearchPage(driver);
		searchResultPageObject = new SearchResultPage(driver);
		productDetailsPageObject = new ProductDetailsPage(driver);

		searchPageObject.productSearch(productName);
						
		searchResultPageObject.openProductDetails();
		
		Assert.assertTrue(productDetailsPageObject.productTitle.getText().equalsIgnoreCase(productName));
		
		System.out.println(productDetailsPageObject.productTitle.getText());
		
		productDetailsPageObject.openEmailfriend();
		
	}
	
	@Test(dependsOnMethods = {"userSearch"})
	public void userEmailfriend() throws InterruptedException {
		
		emailFriendPageObject = new EmailFriendPage(driver);
		
		
		emailFriendPageObject.emailFriend(friendEmail, yourEmail, message);
		
		Assert.assertTrue(emailFriendPageObject.successMessage.getText().equalsIgnoreCase(successmessage));
		
		System.out.println(emailFriendPageObject.successMessage.getText());
		
	}
}
