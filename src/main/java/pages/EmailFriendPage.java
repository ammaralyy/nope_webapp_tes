package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase {
	
	public EmailFriendPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FriendEmail")
	WebElement friendEmailTextBox;
	
	@FindBy(id = "YourEmailAddress")
	WebElement yourEmailTextBox;
	
	@FindBy(id = "PersonalMessage")
	WebElement messageTextBox;
	
	@FindBy(name ="send-email")
	WebElement sendEmailButton;
	
	@FindBy(css ="div.result")
	public WebElement successMessage;
	
	public void emailFriend(String friendEmail, String yourEmail, String message) {
		
		sendtext(friendEmailTextBox, friendEmail);
//		sendtext(yourEmailTextBox, yourEmail);
		sendtext(messageTextBox, message);

		clickButton(sendEmailButton);
	}
	
}
