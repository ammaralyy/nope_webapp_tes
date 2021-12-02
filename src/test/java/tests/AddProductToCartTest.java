package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.ProductsCartPage;
import pages.SearchPage;
import pages.SearchResultPage;
import pages.UserRegisterationPage;


public class AddProductToCartTest extends TestBase {

	String yourEmail = "ammar2666@mail.com";
	
	String productName = "Apple MacBook Pro 13-inch";
	String pageBodytext = "Your Shopping Cart is empty!";

	
	SearchPage searchPageObject;
	ProductDetailsPage productDetailsPageObject;
	SearchResultPage searchResultPageObject;
	ProductsCartPage productsCartPageObject;
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
		
		productDetailsPageObject.addProductToCart();
		
		Thread.sleep(5000);
		
		productDetailsPageObject.openCart();
		
	}
	
	@Test(dependsOnMethods = {"userSearch"})
	public void userAddProductToCart() throws InterruptedException {
		
		productsCartPageObject = new ProductsCartPage(driver);
				
		Assert.assertTrue(productsCartPageObject.productTitle.getText().equalsIgnoreCase(productName));
		
		System.out.println("product name in Cart : " + productsCartPageObject.productTitle.getText());
		
		Thread.sleep(5000);
		
//		productsCartPageObject.updateProductQuantity("5");
//		
//		Thread.sleep(5000);

		productsCartPageObject.removeProductFromCart();
		
		Thread.sleep(5000);
		
		Assert.assertTrue(productsCartPageObject.pageBodyText.getText().equalsIgnoreCase(pageBodytext));
		
		System.out.println(productsCartPageObject.pageBodyText.getText());
		
	}
}
