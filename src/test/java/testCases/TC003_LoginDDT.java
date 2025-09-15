package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass= DataProviders.class, groups={"Datadriven"})
	public void verify_loginDDT(String email, String pwd, String exp) {
		
		logger.info("**** Starting TC003_LoginDDT ****");
		
		try {
			//HomePage
			HomePage hp = new HomePage(driver);
			
			hp.clickMyAccount();
			logger.info("Clicked My Account link");
			
			hp.clickLogin();
			logger.info("Clicked Login link");
			
			//LoginPage
			LoginPage lp = new LoginPage(driver);
			
			logger.info("Provide login details");
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();
			
			//MyAccountPage
			MyAccountPage mp = new MyAccountPage(driver);
			boolean targetPage = mp.isMyAccountPageExists();
			
			logger.info("Validating login is successful for valid inputs and not successful for invalid inputs");
			
			if(exp.equalsIgnoreCase("valid")) {
				if(targetPage==true) {
					logger.info("Test passed");
					mp.clickLogout();
					logger.info("Logged out successfully");
					Assert.assertTrue(true);
				}
				else {
					logger.error("Test failed");
					logger.debug("Debug logs..");
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("invalid")) {
				if(targetPage==true) {
					logger.error("Test failed");
					logger.debug("Debug logs..");
					mp.clickLogout();
					logger.info("Logged out successfully");
					Assert.assertTrue(false);
				}
				else {
					logger.info("Test passed");
					Assert.assertTrue(true);
				}
			}
			
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("**** Finished TC003_LoginDDT ****");
		
	}

}
