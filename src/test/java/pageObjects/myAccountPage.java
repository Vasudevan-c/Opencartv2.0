package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class myAccountPage extends BasePage{

	
	//constructor

	public myAccountPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	//Locators
	
	
	
	@FindBy(xpath="//h2[normalize-space()='My Account']")
	WebElement  ext_msg;
	
	
	//action
	
	
	
	public boolean isMyAccountPageExixts() {
		System.out.println(ext_msg.getText());
		
		
		try {
			
			return(ext_msg.isDisplayed());
			
			
		}catch(Exception e) {
		
		
		return false;
		
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
