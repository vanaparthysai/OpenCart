package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage{

	public ProductPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//*[@name='quantity']")
	WebElement txtQuantity;
	@FindBy(xpath = "//*[@id='button-cart']")
	WebElement addcartbtn;
	@FindBy(xpath = "//div[contains(text(),'Success: You have added ')]")
	WebElement cnfMsg;
	@FindBy(xpath = "//div[@id='cart']")
	WebElement clikitemsbtn;
	@FindBy(xpath = "//ul[@class='dropdown-menu pull-right']//Strong[contains(text(),'View Cart')]")
	WebElement viewcart;
	
	public void addQuantity() {
		try {
			wait.until(ExpectedConditions.visibilityOf(txtQuantity));
			txtQuantity.clear();
			txtQuantity.sendKeys("5");
		} catch (Exception e) {
			System.out.println("Error while cheking the add quantity field: "+e.getMessage());
		}
	}
	public void addcartbtn() {
		try {
			wait.until(ExpectedConditions.visibilityOf(addcartbtn)).click();
		} catch (Exception e) {
			System.out.println("Error in addcart button : "+e.getMessage());
		}
	}
	public boolean CheckcnfMsg() {
		try {
			wait.until(ExpectedConditions.visibilityOf(cnfMsg));
			return cnfMsg.isDisplayed();
		} catch (Exception e) {
		System.out.println("confirmation message not found : "+e.getMessage());
			return false;
			}	
	}
	public void clicitemsbtnToNavigateToCart() {
		try {
			wait.until(ExpectedConditions.visibilityOf(clikitemsbtn)).click();
		} catch (Exception e) {
	System.out.println("unable to click the item button : "+e.getMessage());
		}
	}
	public void clickview() {
		try {
			wait.until(ExpectedConditions.visibilityOf(viewcart)).click();
		} catch (Exception e) {
		System.out.println("unable to locate view Cart button : "+e.getMessage());
		}
	}
}
