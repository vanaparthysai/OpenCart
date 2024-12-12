package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ConfigReader;

public class BasePage   {

    protected WebDriver driver;
    protected WebDriverWait wait;
    public ConfigReader config;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        if (driver != null) {
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            PageFactory.initElements(driver, this);
        }
    }

    public WebDriver setup() {
        config = new ConfigReader();
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String url = config.getproperties().getProperty("appURL");
        driver.get(url);
        driver.manage().window().maximize();
        return driver;
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
