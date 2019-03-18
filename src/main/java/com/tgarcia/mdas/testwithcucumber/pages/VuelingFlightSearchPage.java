package com.tgarcia.mdas.testwithcucumber.pages;

import com.tgarcia.mdas.testwithcucumber.domain.SearchFlightDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class VuelingFlightSearchPage extends BaseTest {


    private static final String ORIGIN_INPUT_CSS_SELECTOR = "#tab-search div.form-input.origin input";
    private static final String DESTINATION_INPUT_CSS_SELECTOR = "#tab-search div.form-input.destination input";

    public void searchFlight(SearchFlightDTO searchFlightDTO){
        waitForVisibilityOfElementByCss(ORIGIN_INPUT_CSS_SELECTOR);
        selectOriginAirport(searchFlightDTO.getOriginLocation());
        selectDestinationAirport(searchFlightDTO.getDestinationLocation());
    }


    private void selectOriginAirport(String location){
        selectAirport(ORIGIN_INPUT_CSS_SELECTOR,location);
    }

    private void selectDestinationAirport(String location){
        selectAirport(DESTINATION_INPUT_CSS_SELECTOR,location);
    }

    private void selectAirport(String originInputCssSelector, String location) {
        WebElement airport = getDriver().findElement(
                By.cssSelector(originInputCssSelector)
        );
        airport.clear();
        airport.sendKeys(location, Keys.ENTER);
        airport.submit();
    }

}
