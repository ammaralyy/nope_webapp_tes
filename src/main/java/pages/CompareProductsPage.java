package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareProductsPage extends PageBase {
	
	public CompareProductsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[3]/td[2]")
	 public WebElement productTitle;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[2]/button")
	 public WebElement removeProdectFromWishlistLink;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div")
	 public WebElement pageBodyText;
	
	public void removeProductFromComparelist() {
		clickButton(removeProdectFromWishlistLink);
	}

}
