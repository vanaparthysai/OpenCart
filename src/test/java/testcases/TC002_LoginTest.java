package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyaccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{

	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		logger.info("**** Starting TC002_LoginTest ****");
	try {

		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		hp.ClickLogin();
	
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(config.getproperties().getProperty("Email"));
	    lp.setPassword(config.getproperties().getProperty("pwd"));
	    lp.btnLogin();
	    
	    MyaccountPage MA=new MyaccountPage(driver);
	    boolean targetPage=MA.isMyAccountExists();
	    Assert.assertTrue(targetPage);
	}
	catch(Exception e) {
		Assert.fail();
		}
	logger.info("**** Finished TC002_LoginTest ***");
	}
}
