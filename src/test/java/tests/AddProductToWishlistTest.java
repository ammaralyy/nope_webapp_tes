package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.SearchResultPage;
import pages.UserRegisterationPage;
import pages.WishlistProductsPage;


public class AddProductToWishlistTest extends TestBase {

	String yourEmail = "ammar236@mail.com";
	
	String productName = "Apple MacBook Pro 13-inch";
	String pageBodytext = "The wishlist is empty!";

	
	SearchPage searchPageObject;
	ProductDetailsPage productDetailsPageObject;
	SearchResultPage searchResultPageObject;
	WishlistProductsPage wishlistProductsPageObjest;
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
		
		productDetailsPageObject.addProductTowishlist();
		
		Thread.sleep(5000);
		
		productDetailsPageObject.openProductTowishlist();
		
	}
	
	@Test(dependsOnMethods = {"userSearch"})
	public void userAddProductToWislist() throws InterruptedException {
		
		wishlistProductsPageObjest = new WishlistProductsPage(driver);
				
		Assert.assertTrue(wishlistProductsPageObjest.productTitle.getText().equalsIgnoreCase(productName));
		
		System.out.println("product name in wishlist" + wishlistProductsPageObjest.productTitle.getText());
		
		Thread.sleep(5000);
		
		wishlistProductsPageObjest.removeProductFromWishlist();

//		Thread.sleep(2000);
//		wishlistProductsPageObjest.updateWishlist();
		
		Assert.assertTrue(wishlistProductsPageObjest.pageBodyText.getText().equalsIgnoreCase(pageBodytext));
		
		System.out.println(wishlistProductsPageObjest.pageBodyText.getText());
		
	}
}
