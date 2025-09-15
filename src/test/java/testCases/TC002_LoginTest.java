package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups= {"Sanity", "Master"})
	public void verify_Login() {
		
		logger.info("**** Starting TC002_LoginTest ****");
		try {
		//HomePage
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked MyAccount link");
		hp.clickLogin();
		logger.info("Clicked login link");
		
		//LoginPage
		LoginPage lp = new LoginPage(driver);
		
		logger.info("Provide login details");
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAccountPage
		logger.info("Validating expected page");
		MyAccountPage mp = new MyAccountPage(driver);
		boolean targetPage = mp.isMyAccountPageExists();
		
		//logger.info("targetPage value: " + targetPage);
		
		if(targetPage==true) {
		  logger.info("Test Passed");
		  Assert.assertTrue(true);
		  //Assert.assertEquals(targetPage, true, "Login Passed");
		  
		}
		else {
		  logger.error("Test failed");
		  logger.debug("Debug logs");
		  Assert.assertTrue(false);
		}
		}
		
		catch(Exception e) {
			
			Assert.fail();
		}
		
		logger.info("**** Finished TC002_LoginTest ****");
		
	}
}
