package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CompareProductsPage;
import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.SearchResultPage;
import pages.UserRegisterationPage;

public class AddProductToCompareTest extends TestBase {

	String yourEmail = "ammar237@mail.com";
	
	String productName = "Apple MacBook Pro 13-inch";
	String pageBodytext = "You have no items to compare.";

	
	SearchPage searchPageObject;
	ProductDetailsPage productDetailsPageObject;
	SearchResultPage searchResultPageObject;
	CompareProductsPage compareProductsPageObject;
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
		
		productDetailsPageObject.addProductToComparelist();
		
		Thread.sleep(5000);
				
		productDetailsPageObject.openComparelist();
		
	}
	
	@Test(dependsOnMethods = {"userSearch"})
	public void userAddProductToComparelist() throws InterruptedException {
		
		compareProductsPageObject = new CompareProductsPage(driver);
				
		Assert.assertTrue(compareProductsPageObject.productTitle.getText().equalsIgnoreCase(productName));
		
		System.out.println("product name in compare : " + compareProductsPageObject.productTitle.getText());
		
		Thread.sleep(5000);
		
		compareProductsPageObject.removeProductFromComparelist();

//		Thread.sleep(2000);
//		wishlistProductsPageObjest.updateWishlist();
		
		Assert.assertTrue(compareProductsPageObject.pageBodyText.getText().equalsIgnoreCase(pageBodytext));
		
		System.out.println(compareProductsPageObject.pageBodyText.getText());
		
	}
}
