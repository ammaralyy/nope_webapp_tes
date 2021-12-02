package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductDetailsPage;
import pages.ProductsCartPage;
import pages.SearchPage;
import pages.SearchResultPage;
import tests.TestBase;

public class UserAddToCard extends TestBase{

	SearchPage searchPageObject;
	SearchResultPage searchResultPageObject;
	ProductDetailsPage productDetailsPageObject;
	ProductsCartPage productsCartPageObject;
	
	String productName = "Apple MacBook Pro 13-inch";
	String pageBodytext = "Your Shopping Cart is empty!";

	@Given("user is on Home Page")
	public void user_is_on_home_page() {

		
	}
	
	@When("he search for \"([^\\\"]*)\"$")
	public void he_search_for(String productName) {

		searchPageObject = new SearchPage(driver);
		searchResultPageObject = new SearchResultPage(driver);
		

		searchPageObject.productSearch(productName);
						
		searchResultPageObject.openProductDetails();
		
	}
	
	@When("choose to buy Two items")
	public void choose_to_buy_two_items() throws InterruptedException {
		
		productDetailsPageObject = new ProductDetailsPage(driver);
		
		Assert.assertTrue(productDetailsPageObject.productTitle.getText().equalsIgnoreCase(productName));
		
		productDetailsPageObject.addProductToCart();
		
		Thread.sleep(5000);
		
		productDetailsPageObject.openCart();
		
	}
	@Then("add to card")
	public void add_to_card() throws InterruptedException {
		
		productsCartPageObject = new ProductsCartPage(driver);
		
		Assert.assertTrue(productsCartPageObject.productTitle.getText().equalsIgnoreCase(productName));
		
		System.out.println("product name in Cart : " + productsCartPageObject.productTitle.getText());
		
		Thread.sleep(5000);

		productsCartPageObject.removeProductFromCart();
		
		Thread.sleep(5000);
		
		Assert.assertTrue(productsCartPageObject.pageBodyText.getText().equalsIgnoreCase(pageBodytext));
		
		System.out.println(productsCartPageObject.pageBodyText.getText());
		
	}
}
