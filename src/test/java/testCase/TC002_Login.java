package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.TestBase;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.myAccountPage;

public class TC002_Login extends TestBase {
	@Test(groups = {"Sanity","Master"})
	public void login_Acoount() {

		logger.info("*******Starting Account Login*********");
try {
		logger.info("Clicked My Account");
		HomePage home = new HomePage(driver);
		home.clickMyaccount();

		logger.info("Clicked Login");
		home.clickLogin();
		logger.info("Sending valid credentials to Login and Click the Button");
		LoginPage log = new LoginPage(driver);
		log.send_Email(p.getProperty("email"));
		log.send_Password(p.getProperty("pass"));
		log.click_Button();

		logger.info("Checking Account Page Exists or Not ");
		myAccountPage mac = new myAccountPage(driver);

		boolean exixts = mac.isMyAccountPageExixts();

		Assert.assertTrue(exixts);
		logger.info("**************LogIn successfully Completed*******************");
}catch(Exception e){
	
	Assert.fail("Something i made Error");
}
	}

}
