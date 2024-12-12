package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.Homepage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass{

	  


			@BeforeClass
		    public void initialize() {
		        driver = setup(); // Call the setup method to initialize WebDriver
		    }

		    @AfterClass
		    public void cleanup() {
		        tearDown(); // Clean up resources after tests
		    }
	@Test
	public void verify_Account_registration() {
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		hp.clickRegister();
		
		RegistrationPage regPage=new RegistrationPage(driver);
		regPage.setFirstName(randomString());
		regPage.setLastName(randomString());
		regPage.setemail(randomAlphaNumber());
		regPage.setteleph(randomNumber());
		regPage.setpwd("sai12345");
		regPage.setcpwd("sai12345");
		regPage.setagree();
		regPage.setcontinuebtn();
	String confmsg=	regPage.getconfirmationmsg();
	Assert.assertEquals(confmsg, "Your Account Has Been Created!");
		
	}
	
}
