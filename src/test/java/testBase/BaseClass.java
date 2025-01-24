package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import utility.ConfigReader;

public class BaseClass extends ConfigReader   {

    public static WebDriver driver;
    public WebDriverWait wait;
    public ConfigReader config;
    public Logger logger;

  @BeforeClass  (groups= {"Sanity","Regression","Master","Datadriven"})
//@Parameters({"os","browser"})
    public WebDriver setup() {
 
    	logger=LogManager.getLogger(this.getClass());
        config = new ConfigReader();
        String browser=config.getproperties().getProperty("browser").toLowerCase();
        
        switch (browser.toLowerCase()) {
		case "chrome":driver=new ChromeDriver();break;
		case "firefox": driver=new org.openqa.selenium.firefox.FirefoxDriver();break;
		case "edge": driver=new EdgeDriver();break;
		case "safari":driver=new SafariDriver();break;
		case "IE":driver=new InternetExplorerDriver();break;
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
    @AfterClass
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
	return(generatedString+generatednumber+"@gmail.com");
}
public String capturescreen(String tname)throws IOException{
	String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	
	TakesScreenshot takescreenshot = (TakesScreenshot)driver;
	File sourcefile=takescreenshot.getScreenshotAs(OutputType.FILE);
	String targetFilepath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"-"+timestamp+".png";
	File targetFile=new File(targetFilepath);
	sourcefile.renameTo(targetFile);
	return targetFilepath;
}
}
