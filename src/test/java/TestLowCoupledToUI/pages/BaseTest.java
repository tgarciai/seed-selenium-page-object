package TestLowCoupledToUI.pages;

import ch.qos.logback.classic.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class BaseTest {

    protected WebDriver driver;
    private static final Logger LOGGER  = (Logger) LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());
    private static final String WEBDRIVER_CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String CHROMEDRIVER_PATH = "/Users/tirsogarciaibanez1/Downloads/chromedriver";

    protected WebDriver initializeWebDriver() {
        WebDriver driver;
        System.setProperty(WEBDRIVER_CHROME_DRIVER, CHROMEDRIVER_PATH);
        driver = new ChromeDriver();
        LOGGER.debug("WebDriver Start");
        driver.manage().window().maximize();
        return driver;
    }

    protected void endAutomation(){
        LOGGER.debug("WebDriver close");
        driver.close();
    }
}
