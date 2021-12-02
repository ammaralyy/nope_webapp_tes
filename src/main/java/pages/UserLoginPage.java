package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserLoginPage extends PageBase {
	
	public UserLoginPage(WebDriver driver) {
		
		super(driver);
		
	}
	
	@FindBy(id = "Email")
	WebElement emailTextBox;
	
	@FindBy(id = "Password")
	WebElement passwordTextBox;
	
	@FindBy(linkText = "Log in")
	WebElement loginButton;
	
	public void userLogin(String email, String password) {
		
		sendtext(emailTextBox, email);
		sendtext(passwordTextBox, password);
		
		clickButton(loginButton);
		
	}
	
	

}
