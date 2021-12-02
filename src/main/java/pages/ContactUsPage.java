package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {
	
	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "FullName")
	WebElement fullNameTextBox;
	
	@FindBy(id = "Email")
	WebElement emailTextBox;
	
	@FindBy(id = "Enquiry")
	WebElement enquiryTextBox;
	
	@FindBy(name ="send-email")
	WebElement sumitButton;
	
	@FindBy(css ="div.result")
	public WebElement successMessage;
	
	public void contactUs(String name, String email, String enquiry) {
		
		sendtext(fullNameTextBox, name);
		sendtext(emailTextBox, email);
		sendtext(enquiryTextBox, enquiry);

		clickButton(sumitButton);
	}
	
}
