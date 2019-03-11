package TestLowCoupledToUI.pages;

import ch.qos.logback.classic.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class VuelingFlightSearchPage extends PageObject {

    private static final String VuelingSearchPageUrl = "https://www.vueling.com/es";
    private static final Logger LOGGER  = (Logger) LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());

    private static final String ORIGIN_INPUT_CSS_SELECTOR = "#tab-search div.form-input.origin input";
    private static final String DESTINATION_INPUT_CSS_SELECTOR = "#tab-search div.form-input.destination input";

    public VuelingFlightSearchPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToVuelingFlightSearchPage(){
        navigateTo(VuelingSearchPageUrl);
    }

    public void selectOriginAirport(String location){
        selectAirport(ORIGIN_INPUT_CSS_SELECTOR,location);
    }

    public void selectDestinationAirport(String location){
        selectAirport(DESTINATION_INPUT_CSS_SELECTOR,location);
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
