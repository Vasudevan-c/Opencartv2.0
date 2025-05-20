package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import baseClass.TestBase;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_Verify_Account_Registration extends TestBase {

	@Test(groups = {"Regression","Master"})
	public void account_Registration() throws InterruptedException {

		logger.info("*****TC001_Verify_Account_Registration******");
		try {
			HomePage hmp = new HomePage(driver);

			hmp.clickMyaccount();

			logger.info("**Clicked My Acoount**");
			hmp.clickMyRegister();
			logger.info("**Registered My Acoount**");
			AccountRegistrationPage acreg = new AccountRegistrationPage(driver);
			acreg.setFirstName(randomString());

			acreg.setLastName(randomString());

			acreg.setEmail(randomString() + "@gmail.com");

			acreg.setTelePhone(randomNumber());

			String passwords = randomPassword();

			acreg.setPassword(passwords);

			acreg.setConfirmPassword(passwords);

			acreg.setPolicyCheck();

			acreg.clickContinueBtn();
			logger.info("**Successfully Enter the All Details**");

			String msg = acreg.getConfirmationMsg();

			if (msg.equals("Your Account Has Been Created!")) {

				Assert.assertTrue(true);
				logger.info("Confirmation message received: " + msg);
			} else {

				logger.error("Test failed");
				logger.debug("debug logs");
				Assert.assertTrue(false);

			}
		} catch (Exception e) {
			 logger.error("Exception occurred: ", e);
			    Assert.fail("Exception during registration:" + e.getMessage());
			    

		}

		logger.info("Account register completed");


	}

}
