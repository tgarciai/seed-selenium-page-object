package TestLowCoupledToUI.pages;

import TestCoupledToUI.ChromeDriverConfig;
import ch.qos.logback.classic.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class BaseTest {

    protected WebDriver driver;
    private static final Logger LOGGER  = (Logger) LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());


    protected WebDriver initializeWebDriver() {
        WebDriver driver;
        System.setProperty(ChromeDriverConfig.WEBDRIVER_CHROME_DRIVER, ChromeDriverConfig.CHROMEDRIVER_PATH);
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
