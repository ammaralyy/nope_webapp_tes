package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase {
	
	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "AddProductReview_Title")
	WebElement reviewTitle;
	
	@FindBy(id = "AddProductReview_ReviewText")
	WebElement reviewText;
	
	@FindBy(id ="addproductrating_4")
	WebElement ratingButton;
	
	@FindBy(name ="add-review")
	WebElement addReviewButton;
	
	@FindBy(css ="div.result")
	public WebElement successMessage;
	
	public void addReview(String title, String textReview) {
		
		sendtext(reviewTitle, title);
		sendtext(reviewText, textReview);
		clickButton(ratingButton);
		clickButton(addReviewButton);
	}
	
}
