package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductReviewPage;
import pages.SearchPage;
import pages.SearchResultPage;
import pages.UserRegisterationPage;


public class AddReviewTest extends TestBase {

	String yourEmail = "ammar222@mail.com";
	String reviewTitle = "great";
	String reviewText = "great product";
	
	String successmessage = "Product review is successfully added.";

	String productName = "Apple MacBook Pro 13-inch";
	
	SearchPage searchPageObject;
	ProductDetailsPage productDetailsPageObject;
	SearchResultPage searchResultPageObject;
	ProductReviewPage productReviewPageObject;
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
		
		productDetailsPageObject.openProductReview();
		
	}
	
	@Test(dependsOnMethods = {"userSearch"})
	public void userAddReview() throws InterruptedException {
		
		productReviewPageObject = new ProductReviewPage(driver);
		
		
		productReviewPageObject.addReview(reviewTitle, reviewText);
		
		Assert.assertTrue(productReviewPageObject.successMessage.getText().equalsIgnoreCase(successmessage));
		
		System.out.println(productReviewPageObject.successMessage.getText());
		
	}
}
