package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;
import pages.SearchPage;
import pages.SearchResultPage;

public class ChangeCurencyTest extends TestBase {

	String productName = "Apple MacBook Pro 13-inch";
	
	SearchPage searchPageObject;
	ProductDetailsPage productDetailsPageObject;
	SearchResultPage searchResultPageObject;
	HomePage homepageObject;

	@Test(priority = 1)
	public void userChangeCurency() throws InterruptedException {
		
		homepageObject = new HomePage(driver);
		homepageObject.changeCurrency();
	}
	
	@Test(priority = 2)
	public void userSearch() throws InterruptedException {
		
		searchPageObject = new SearchPage(driver);
		searchResultPageObject = new SearchResultPage(driver);
		productDetailsPageObject = new ProductDetailsPage(driver);

		searchPageObject.productSearch(productName);
						
		searchResultPageObject.openProductDetails();
		
		Assert.assertTrue(productDetailsPageObject.productPrice.getText().contains("€"));
		
		System.out.println(productDetailsPageObject.productPrice.getText());
		
	}
	
}
