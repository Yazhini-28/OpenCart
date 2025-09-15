package testCases;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{

	@Test(groups= {"Regression", "Master"})
    public void verify_Account_Registration() {
		
		logger.info("**** Starting TC001_AccountRegistrationTest ****");
		try {
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on My Account Link..");
		hp.clickRegister();
		logger.info("Clicked on Registration Link..");
		
		RegistrationPage rp = new RegistrationPage(driver);
		
		logger.info("Providing customer details..");
		rp.setFirstName(randomString().toUpperCase());
		rp.setLastName(randomString().toUpperCase());
		rp.setEmail(randomString() +"@gmail.com");
		rp.setTelephone(randomNumber());
		
		String password = randomAlphaNumeric();
		rp.setPassword(password);
		rp.setPasswordConfirm(password);
		
		rp.setPrivacyPolicy();
		rp.clickContinue();
		
		logger.info("Validating Expected Message..");
		String msg = rp.getConfirmationMsg();
		if(msg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test Failed");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}
		
		//Assert.assertEquals(rp.getConfirmationMsg(), "Your Account Has Been Created!");
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("**** Finished TC001_AccountRegistrationTest ****");
		
	}
	
}
