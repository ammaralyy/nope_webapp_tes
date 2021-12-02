package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsCartPage extends PageBase {
	
	public ProductsCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[3]/a")
	 public WebElement productTitle;
	
	@FindBy(css = "td.quantity")
	 public WebElement productQuantity;
	
	@FindBy(xpath = "//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr/td[7]")
	 public WebElement removeProdectFromcart;
	
	@FindBy(name = "updatecart")
	 public WebElement updateCartButton;
	
	@FindBy(xpath = "/html/body/div[6]/div[3]/div/div/div/div[2]/div/div")
	 public WebElement pageBodyText;

	
	public void removeProductFromCart() {
		clickButton(removeProdectFromcart);
	}
	
	public void updateCart() {
		clickButton(updateCartButton);
	}
	
	public void updateProductQuantity(String quantity) {
		clearText(productQuantity);
		sendtext(productQuantity, quantity);
		updateCart();
	}

}
