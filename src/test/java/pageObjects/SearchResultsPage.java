package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class SearchResultsPage extends BasePage {

	public SearchResultsPage(WebDriver driver) {
		super(driver);
	}	

	@FindBy(xpath ="//div[@id='content']/h1")
	WebElement SearchPageHeader;
	@FindBy(xpath = "//*[@id='content']/div[3]//img")
List<WebElement> searchProducts;

	
	public boolean isSearchResulsPageExists() {
		try {
		return 	wait.until(ExpectedConditions.visibilityOf(SearchPageHeader)).getText().contains("Search -");
		
		} catch (Exception e) {
			System.out.println("error checking page exist or not: "+e.getMessage());
			return false;
		}
		}
	
		public boolean isproductExisting(String productname) {
			try {
				 wait.until(ExpectedConditions.visibilityOfAllElements(searchProducts));
				 for(WebElement product:searchProducts) {
					 if(product.getAttribute("title").contains(productname)) {
						  return true;
					 }
				 }
			} 
			catch (Exception e) {
				// TODO: handle exception
				System.out.println("Error checking product existence: " + e.getMessage());
			}
			return false;
			
		
	}
	//select product from search results by its by name
		
		public ProductPage selectproduct() {
			try {
				wait.until(ExpectedConditions.visibilityOfAllElements(searchProducts));
				for(WebElement element:searchProducts) {
					if(element.getAttribute("title").contains("Samsung")) {
				wait.until(ExpectedConditions.elementToBeClickable(element));
				element.click();
				return new ProductPage(driver);
				}
					else {
						System.out.println("product not found");
						}
					}
			} catch (Exception e) {
				System.out.println("error checking selection of product: "+e.getMessage());
			}
			return null;
		}
	}

