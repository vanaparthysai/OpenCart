package testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyaccountPage;
import testBase.BaseClass;
import utility.Dataproviders;

public class TC004_LoginDDT  extends BaseClass
{

	/*
	 * Data is valid - login is successful - test pass - logout
	                 - login is failed - test fail 
	 * Data is invalid - login is successful - test fail - logout
	 *                 - login is failed - test pass 
	 * */
	//if dataprovider is in another class and another package then we can mention dataproviderclass like this (dataProviderClass = Dataproviders.class) if it is in same class no need to mention dataprovider class
	
	
	@Test(dataProvider = "LoginData",dataProviderClass = Dataproviders.class,groups = {"Regression"})
	public void verify_loginDDT(String email,String pwd,String exp) {
		
		logger.info("**** Starting TC003_LoginDDTTest ****");
	
try {
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		hp.ClickLogin();
	
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
	    lp.setPassword(pwd);
	    lp.btnLogin();
	    
	    MyaccountPage MA=new MyaccountPage(driver);
	    boolean targetPage=MA.isMyAccountExists();
	    
	    if(exp.equalsIgnoreCase("valid")) {
	    	if(targetPage==true) {
	    		MA.clickLogout();
	    		Assert.assertTrue(true);	    		
	    	}
	    	else {
	    		Assert.assertTrue(false);
	    	}
	    }
if(exp.equalsIgnoreCase("invalid")) {
	if(targetPage==true) {
		MA.clickLogout();
		Assert.assertTrue(false);
	}
	else {
		Assert.assertTrue(true);
	}
}	}
catch(Exception e) {
	Assert.fail();
}
logger.info("**** Finished Data Driven Test for Login ****");
	}
	
	}
