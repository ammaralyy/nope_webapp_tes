package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WishlistProductsPage extends PageBase {
	
	public WishlistProductsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[4]")
	 public WebElement productTitle;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[8]")
	 public WebElement removeProdectFromWishlistLink;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div")
	 public WebElement pageBodyText;
	
	@FindBy(name = "updatecart")
	 public WebElement updateWishlistButton;
	
	public void removeProductFromWishlist() {
		clickButton(removeProdectFromWishlistLink);
	}

	public void updateWishlist() {
		clickButton(updateWishlistButton);
	}
}
