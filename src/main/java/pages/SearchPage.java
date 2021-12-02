package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {
	
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "small-searchterms")
	WebElement searchTextBox;
	
	@FindBy(id = "ui-id-1")
	List<WebElement> productsAutoSuggestList;
	
	@FindBy(css = "button.button-1.search-box-button")
	WebElement searchButton;
	
	public void productSearch(String productname) {

		sendtext(searchTextBox, productname);
		
		clickButton(searchButton);
	}
	
	public void productSearchUsingAutoSuggest(String productText) throws InterruptedException {

		sendtext(searchTextBox, productText);
		
		Thread.sleep(3000);
		
		productsAutoSuggestList.get(0).click();
	}

}
