package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Homepage extends BasePage {

	public Homepage(WebDriver driver) {
	super(driver);	
	
	
	}
	@FindBy(xpath = "//a[@title='My Account']")
	WebElement lnkmyaccount;
	@FindBy(xpath = "//a[contains(text(),'Register')]")
	WebElement lnkRegister;
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement lnkLogin;
	@FindBy(xpath="//input[@name='search']")
	WebElement txtsearchbox;
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement btnsearch;
	
	//is home page exists
	public boolean isHomePageExists() {
		try {
		return driver.getTitle().equals("your store")	;
		} catch ( Exception e ) {
			// TODO: handle exception
		return false;
		}
	
		
	}
	// Click "My Account" link
		public void clickMyAccount() {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(lnkmyaccount)).click();
			} catch (Exception e) {
				System.out.println("Exception occurred while clicking 'My Account': " + e.getMessage());
			}
		}
	public void clickRegister() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(lnkRegister)).click();
		} catch (Exception e) {
			System.out.println("Exception occured while clicking 'Register' : "+e.getMessage());
		}
	}
	public void Login() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(lnkLogin)).click();
		} catch (Exception e) {
			System.out.println("Exception occured while clicking 'Login' :"+e.getMessage());
		}
	}
	//enter product name in searchbox
	public void searchbox(String pname) {
		try {
			wait.until(ExpectedConditions.visibilityOf(txtsearchbox)).sendKeys(pname);
		} catch (Exception e) {
		System.out.println("Exception occured while entering productname 'searchbox' :"+e.getMessage());
		}
	}
	//click on search button
	public SearchResultsPage btnsearch() {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(btnsearch)).click();
		return new SearchResultsPage(driver);
		} catch (Exception e) {
			System.out.println("Exception occured while clicking 'search_btn' :"+e.getMessage());
		return null;
		}
	}
}
