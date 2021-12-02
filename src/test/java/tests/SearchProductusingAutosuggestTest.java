package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ProductDetailsPage;
import pages.SearchPage;

public class SearchProductusingAutosuggestTest extends TestBase {

	String productName = "Apple MacBook Pro 13-inch";
//	String productName = "Samsung Series 9 NP900X4C Premium Ultrabook";
	
	SearchPage searchPageObject;
	ProductDetailsPage productDetailsPageObject;
	
	@Test
	public void userSearchUsingAutoSuggest() throws InterruptedException {
		
		searchPageObject = new SearchPage(driver);
		productDetailsPageObject = new ProductDetailsPage(driver);

		searchPageObject.productSearchUsingAutoSuggest("mac");
								
		Assert.assertTrue(productDetailsPageObject.productTitle.getText().equalsIgnoreCase(productName));
		
		System.out.println(productDetailsPageObject.productTitle.getText());
		
	}
}
