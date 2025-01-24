package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyaccountPage extends BasePage {

	public MyaccountPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement heading;
	@FindBy(xpath = "//div/a[text()='Logout']")
	WebElement logout;
	public boolean isMyAccountExists() {
		try {
			return (heading.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}
	public void clickLogout() {
		logout.click();
	}
}
