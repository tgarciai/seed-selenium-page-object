import ch.qos.logback.classic.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;


public class WebDriverOptionsTest {

    private static final Logger LOGGER  = (Logger) LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());


    private static WebDriver driver;


    @Test
    public void testWebDrive() throws InterruptedException {

        LOGGER.debug("Test");

        System.setProperty("webdriver.chrome.driver", "/Users/tirsogarciaibanez1/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        LOGGER.debug("webdriver started");

        driver.get("https://the-internet.herokuapp.com");
        driver.getTitle();
        driver.getCurrentUrl();

        List<WebElement> liElements = driver.findElements(
                By.cssSelector("div li a")
        );
        LOGGER.debug("webdriver END");




        driver.close();
    }
}


//Test unitarios por feature.


