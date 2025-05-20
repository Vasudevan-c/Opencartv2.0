package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
//constructors
	public LoginPage(WebDriver driver) {
		super(driver);

	}

//Locators
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txt_Email;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txt_Password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement btn_Click;

//Action Methods	

	public void send_Email(String email) {

		txt_Email.sendKeys(email);

	}

	public void send_Password(String Pass) {

		txt_Password.sendKeys(Pass);

	}

	public void click_Button() {

		btn_Click.click();

	}

}
