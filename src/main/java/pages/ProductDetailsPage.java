package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends PageBase {
	
	public ProductDetailsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "div.product-name")
	public WebElement productTitle;
	
	@FindBy(css = "div.email-a-friend")
	public WebElement emailFriendLink;
	
	@FindBy(id = "price-value-4")
	public WebElement productPrice;
	
	@FindBy(linkText = "Add your review")
	public WebElement addReviewLink;
	
	@FindBy(id = "add-to-wishlist-button-4")
	public WebElement addToWishlistButton;
	
	@FindBy(id = "add-to-cart-button-4")
	public WebElement addToCartButton;
	
	@FindBy(css = "div.compare-products")
	public WebElement addToCompareListButton;
	
	@FindBy(linkText = "Wishlist")
	public WebElement openWishlistButton;
	
	@FindBy(id = "topcartlink")
	public WebElement openCartButton;
	
	@FindBy(xpath = "/html/body/div[6]/div[4]/div[1]/div[2]/ul/li[5]/a")
	public WebElement openCompareListButton;
	
	public void openEmailfriend() {
		clickButton(emailFriendLink);
	}
	
	public void openProductReview() {
		clickButton(addReviewLink);
	}
	
	public void addProductTowishlist() {
		clickButton(addToWishlistButton);
	}
	
	public void openProductTowishlist() {
		clickButton(openWishlistButton);
	}
	
	public void addProductToComparelist() {
		clickButton(addToCompareListButton);
	}
	
	public void openComparelist() {
		
		HomePage.scrollBottom();

		clickButton(openCompareListButton);
	}
	
	public void addProductToCart() {
		clickButton(addToCartButton);
	}
	
	public void openCart() {
		
		clickButton(openCartButton);
	}

}
