package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.MyaccountPage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{

	  


		/*	@BeforeClass
		    public void initialize() {
		        driver = setup(); // Call the setup method to initialize WebDriver
		    }

		    @AfterClass
		    public void cleanup() {
		        tearDown(); // Clean up resources after tests
		    }*/
	@Test(groups= {"Regression","Master"})
	public void verify_Account_registration() {
		try {
		logger.info("***** Starting TC001 Account Registration Test))");
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		logger.info("clicked on my Account Link");
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		RegistrationPage regPage=new RegistrationPage(driver);
		
		logger.info("Providing customer details...");

		regPage.setFirstName(randomString());
		regPage.setLastName(randomString());
 	regPage.setemail(randomAlphaNumber());
 	System.out.println(randomAlphaNumber());
		regPage.setteleph(randomNumber());
		regPage.setpwd("sai12345");
		regPage.setcpwd("sai12345");
		regPage.setagree();
		regPage.setcontinuebtn();
	logger.info("validating expected message...");
		String confmsg=	regPage.getconfirmationmsg();
		if(confmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
			MyaccountPage map=new MyaccountPage(driver);
			map.clickLogout();
		}
		else {
			logger.error("Test failed");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}
	//Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		}	
	catch (Exception e) {
		//logger.error("Test failed...");
		//logger.debug("Debug logs...");
		Assert.fail();
	}
		logger.info("**** Finished TC001_AccountRegistrationTest ***");
		
	}
}

