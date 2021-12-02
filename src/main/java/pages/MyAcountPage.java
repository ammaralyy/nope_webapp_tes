package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAcountPage extends PageBase {
	
	public MyAcountPage(WebDriver driver) {
		super(driver);	
	}
	
	@FindBy(linkText = "Change password")
	WebElement changePasswordLink;
	
	@FindBy(id = "OldPassword")
	WebElement oldPasswordTextBox;
	
	@FindBy(id = "NewPassword")
	WebElement newPasswordTextBox;
	
	@FindBy(id = "ConfirmNewPassword")
	WebElement confirmNewPasswordTextBox;
	
	@FindBy(linkText = "Change password")
	WebElement changePasswordButton;
	
	public void openchangePassword() {
		
		clickButton(changePasswordLink);
	}
	
	public void changePassword(String oldPassword, String newPassword) {
		
		sendtext(oldPasswordTextBox, oldPassword);
		sendtext(newPasswordTextBox, newPassword);
		sendtext(confirmNewPasswordTextBox, newPassword);

		clickButton(changePasswordButton);
	}

}
