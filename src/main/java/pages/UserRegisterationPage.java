package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegisterationPage extends PageBase {
	
	public UserRegisterationPage(WebDriver driver) {
		
		super(driver);
		
	}
	
	@FindBy(id = "gender-male")
	WebElement gender;
	
	@FindBy(id = "FirstName")
	WebElement firstNameTextBox;
	
	@FindBy(id = "LastName")
	WebElement lastNameTextBox;
	
	@FindBy(id = "Email")
	WebElement emailTextBox;
	
	@FindBy(id = "Password")
	WebElement passwordTextBox;
	
	@FindBy(id = "ConfirmPassword")
	WebElement confirmPasswordTextBox;
	
	@FindBy(id = "register-button")
	WebElement registerationButton;
	
	@FindBy(css = "div.result")
	public WebElement successmessage;
	
	@FindBy(css = "a.ico-logout")
	public WebElement logout;
	
	@FindBy(linkText = "My account")
	WebElement myAcount;
	
	public void userRegisteration(String firstName, String lastName, String email, String password) {
		
		clickButton(gender);
		
		sendtext(firstNameTextBox, firstName);
		sendtext(lastNameTextBox, lastName);
		sendtext(emailTextBox, email);
		sendtext(passwordTextBox, password);
		sendtext(confirmPasswordTextBox, password);
		
		clickButton(registerationButton);
		
	}
	
	public void userlogout() {
		
		clickButton(logout);
	}
	
	public void openMyAcountPage() {
		
		clickButton(myAcount);
	}

}
