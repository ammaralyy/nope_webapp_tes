package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends PageBase {
	
	public SearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "h2.product-title")
	WebElement productTitle;
	
	public void openProductDetails() {
		
		clickButton(productTitle);
	}

}
