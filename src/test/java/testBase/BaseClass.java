package testBase;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utility.ConfigReader;

public class BaseClass extends ConfigReader   {

    public WebDriver driver;
    public WebDriverWait wait;
    public ConfigReader config;

    

    public WebDriver setup() {
        config = new ConfigReader();
        String browser=config.getproperties().getProperty("browser").toLowerCase();
        
        switch (browser) {
		case "chrome":driver=new ChromeDriver();
			break;
		case "firefox": driver=new org.openqa.selenium.firefox.FirefoxDriver();
		break;
		case "edge": driver=new EdgeDriver();
		break;
		default:
			throw new IllegalArgumentException("Unsupported browser: "+browser);
        }
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
public String randomString() {
	String generateString = RandomStringUtils.randomAlphabetic(5);
return generateString;
}
public String randomNumber() {
	String generatenumber=RandomStringUtils.randomAlphanumeric(10);
	return generatenumber;
}
public String randomAlphaNumber() {
	String generatedString=RandomStringUtils.randomAlphabetic(5);
	String generatednumber=RandomStringUtils.randomNumeric(3);
	return(generatedString+"@"+generatednumber+"gmail.com");
}
}
