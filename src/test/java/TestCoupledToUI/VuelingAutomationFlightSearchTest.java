package TestCoupledToUI;

import ch.qos.logback.classic.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import java.lang.invoke.MethodHandles;

public class VuelingAutomationFlightSearchTest {

    private static final Logger LOGGER  = (Logger) LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());
    private static final String EXPECTED_RESULT = "Tu búsqueda:";
    private static final int TIME_OUT_IN_SECONDS = 20;
    private static final String URL = "https://www.vueling.com/es";
    private static final String ORIGIN_INPUT_CSS_SELECTOR = "#tab-search div.form-input.origin input";
    private static final String DESTINATION_INPUT_CSS_SELECTOR = "#tab-search div.form-input.destination input";
    private static final String RESULT_CSS_SELECTOR = "#research > div.colRow2.sectionTable.height39 > h3";

    private static WebDriver driver;

    @Test
    public void TestVuelingFlightSearch() throws InterruptedException {

        LOGGER.debug("TestVuelingFlightSearch");

        initializeWebDriver();

        navigateTo(URL);

        selectAirport(ORIGIN_INPUT_CSS_SELECTOR, "Barcelona");
        selectAirport(DESTINATION_INPUT_CSS_SELECTOR, "Madrid");

        assertExpectedResult();

        LOGGER.debug("WebDriver close");
        driver.close();
    }

    private void initializeWebDriver() {
        System.setProperty(ChromeDriverConfig.WEBDRIVER_CHROME_DRIVER, ChromeDriverConfig.CHROMEDRIVER_PATH);
        LOGGER.debug("WebDriver Start");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    private void assertExpectedResult() {
        waitForVisibilityOfElement("research");
        WebElement result = driver.findElement(
                By.cssSelector(RESULT_CSS_SELECTOR)
        );
        Assert.assertEquals(result.getText(), EXPECTED_RESULT);
    }

    private void waitForVisibilityOfElement(String elementId) {
        WebDriverWait wait= new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementId)));
    }

    private void navigateTo(String URL) {
        driver.get(URL);
    }

    private void selectAirport(String originInputCssSelector, String location) {
        WebElement airport = driver.findElement(
                By.cssSelector(originInputCssSelector)
        );
        airport.clear();
        airport.sendKeys(location, Keys.ENTER);
        airport.submit();
    }
}