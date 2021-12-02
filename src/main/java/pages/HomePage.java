package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.JavascriptExecutor;

public class HomePage extends PageBase {
	
	public HomePage(WebDriver driver) {
		super(driver);
		
		jse = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}
	
	@FindBy(linkText = "Register")
	WebElement registerLink;
	
	public void openRegisterationPage() {

		clickButton(registerLink);
	}
	
	@FindBy(linkText = "Log in")
	WebElement loginLink;
	
	public void openLoginPage() {

		clickButton(loginLink);
	}
	
	@FindBy(linkText = "Contact us")
	WebElement contactUsLink;
	
	public void openContactus() {

		scrollBottom();
		
		clickButton(contactUsLink);
	}
	
	@FindBy(id = "customerCurrency")
	WebElement currencyId;
	
	public void changeCurrency() {

		select = new Select(currencyId);
		
		select.selectByVisibleText("Euro");
	}
	
	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/a")
	WebElement computerMenu;
	
	@FindBy(xpath = "/html/body/div[6]/div[2]/ul[1]/li[1]/ul/li[2]/a")
	WebElement notebookMenu;
	
	public void opennotebookMenu() {
		action.moveToElement(computerMenu).moveToElement(notebookMenu).click().perform();
	}

}
