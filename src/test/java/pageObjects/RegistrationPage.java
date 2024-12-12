package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}
@FindBy(xpath = "//input[@name='firstname']")
WebElement txtfirstname;
@FindBy(xpath = "//input[@name='lastname']")
WebElement txtlastname;
@FindBy(xpath = "//input[@name='email']")
WebElement txtemail;
@FindBy(xpath = "//input[@name='telephone']")
WebElement txtteleph;
@FindBy(xpath = "//input[@name='password']")
WebElement txtpwd;
@FindBy(xpath = "//input[@name='confirm']")
WebElement txtcpwd;
@FindBy(xpath = "//input[@type='checkbox']")
WebElement chkdpolicy;
@FindBy(xpath = "//input[@value='Continue']")
WebElement btncontinue;
@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;
public void setFirstName(String fname) {
    try {
        wait.until(ExpectedConditions.visibilityOf(txtfirstname)).sendKeys(fname);
    } catch (Exception e) {
        System.out.println("Exception while setting first name: " + e.getMessage());
    }
}
public void setLastName(String lname) {
	try {
		wait.until(ExpectedConditions.visibilityOf(txtlastname)).sendKeys(lname);
	} catch (Exception e) {
		System.out.println("Exception while setting last name: "+e.getMessage());
	}
}
public void setemail(String email) {
	try {
		wait.until(ExpectedConditions.visibilityOf(txtemail)).sendKeys(email);
	} catch (Exception e) {
		System.out.println("Exception while setting email:"+e.getMessage());
	}
}
public void setteleph(String ph) {
	try {
		wait.until(ExpectedConditions.visibilityOf(txtteleph)).sendKeys(ph);
	} catch (Exception e) {
		System.out.println("Exception while setting telephone: "+e.getMessage());
	}
}
public void setpwd(String pwd) {
	try {
		wait.until(ExpectedConditions.visibilityOf(txtpwd)).sendKeys(pwd);
	} catch (Exception e) {
		System.out.println("Exception while setting password: "+e.getMessage());
	}
}
public void setcpwd(String conpwd) {
	try {
		wait.until(ExpectedConditions.visibilityOf(txtcpwd)).sendKeys(conpwd);
	} catch (Exception e) {
		System.out.println("Exception while setting confirmpwd: "+e.getMessage());
	}
}
public void setagree() {
	try {
		wait.until(ExpectedConditions.visibilityOf(chkdpolicy)).click();;
	} catch (Exception e) {
		System.out.println("Exception while setting telephone: "+e.getMessage());
	}
}
public void setcontinuebtn() {
	try {
		wait.until(ExpectedConditions.visibilityOf(btncontinue)).click();;
	} catch (Exception e) {
		System.out.println("Exception while setting continue: "+e.getMessage());
	}
}
public String getconfirmationmsg() {
	try {
	return wait.until(ExpectedConditions.visibilityOf(msgConfirmation)).getText();
	} catch (Exception e) {
		System.out.println("Exception while setting telephone: "+e.getMessage());
	return e.getMessage();
	}
}
}
