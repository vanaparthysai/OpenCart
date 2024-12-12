package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.BasePage;
import pageObjects.Homepage;
import pageObjects.ProductPage;
import pageObjects.SearchResultsPage;

public class TC002_ProductSearch extends BasePage {

    public TC002_ProductSearch() {
        super(null); // Pass null since driver is initialized in @BeforeClass
    }

    @BeforeClass
    public void initialize() {
        driver = setup(); // Call the setup method to initialize WebDriver
    }

   /* @AfterClass
    public void cleanup() {
        tearDown(); // Clean up resources after tests
    }*/

    @Test
    public void verifyTheProduct() {
    	Homepage hp=new Homepage(driver);
    	hp.searchbox("samsung");
    	hp.btnsearch();
        SearchResultsPage srp = new SearchResultsPage(driver);
        Assert.assertTrue(srp.isSearchResulsPageExists());
       String ExpectedProductName="Samsung";
       boolean isproductDisplayed=srp.isproductExisting(ExpectedProductName);
       Assert.assertTrue(isproductDisplayed,ExpectedProductName);
        
        
    }
}
