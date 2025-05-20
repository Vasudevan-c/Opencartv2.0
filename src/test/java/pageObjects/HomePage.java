package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);

	}

	// locators

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement click_Myaccount;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement Click_Login;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement click_Register;

	// Actions Methods

	public void clickMyaccount() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(click_Myaccount));
		click_Myaccount.click();
	}

	public void clickMyRegister() {

		click_Register.click();

	}

	public void clickLogin() {

		Click_Login.click();

	}

}
