package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	WebDriver driver;

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	// locators

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement text_FirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement text_LastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement text_Email;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement text_TelePhone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement text_Password;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement text_ConPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement ply_Cck;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btn_Click;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	// Action_methods

	public void setFirstName(String fname) {

		text_FirstName.sendKeys(fname);

	}

	public void setLastName(String lName) {

		text_LastName.sendKeys(lName);

	}

	public void setEmail(String email) {

		text_Email.sendKeys(email);

	}

	public void setTelePhone(String phnNUm) {

		text_TelePhone.sendKeys(phnNUm);

	}

	public void setPassword(String pass) {

		text_Password.sendKeys(pass);

	}

	public void setConfirmPassword(String conpass) {

		text_ConPassword.sendKeys(conpass);

	}

	public void setPolicyCheck() {

		ply_Cck.click();

	}

	public void clickContinueBtn() {
		btn_Click.click();

		/*
		 * //sol1 btn_Click.submit();
		 * 
		 * //sol2
		 * 
		 * Actions act= new Actions (driver); act.moveToElement(btn_Click).click();
		 * 
		 * 
		 * //sol3
		 * 
		 * JavascriptExecutor js=(JavascriptExecutor)driver;
		 * js.executeScript("arguments[0].click();", "btn_Click");
		 * 
		 * 
		 * //sol4
		 * 
		 * 
		 * WebDriverWait mywait= new WebDriverWait(driver, Duration.ofSeconds(10));
		 * mywait.until(ExpectedConditions.elementToBeClickable(btn_Click)).click();
		 * 
		 * 
		 */

	}

	public String getConfirmationMsg() {

		try {
			return (msgConfirmation.getText());

		} catch (Exception e) {

			return (e.getMessage());
		}

	}

}
