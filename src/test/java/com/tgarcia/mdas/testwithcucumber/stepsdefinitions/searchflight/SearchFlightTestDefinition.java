package com.tgarcia.mdas.testwithcucumber.stepsdefinitions.searchflight;

import com.tgarcia.mdas.testwithcucumber.domain.SearchFlightDTO;
import com.tgarcia.mdas.testwithcucumber.pages.VuelingFlightSearchPage;
import com.tgarcia.mdas.testwithcucumber.pages.VuelingFlightSearchResultPage;
import com.tgarcia.mdas.testwithcucumber.services.SearchFlightService;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.jetbrains.annotations.NotNull;
import org.junit.Assert;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class SearchFlightTestDefinition {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    private static final String VuelingSearchPageUrl = "https://www.vueling.com/es";
    private static final String EXPECTED_RESULT = "Tu búsqueda:";


    @Steps
    private SearchFlightService reservationService;
    private VuelingFlightSearchPage vuelingFlightSearchPage;
    private VuelingFlightSearchResultPage vuelingFlightSearchResultPage;


    @Before
    public void beforeScenario(){
        LOGGER.debug("beforeScenario starts");
        reservationService.addSearchFlight(2);
    }

    @After
    public void afterScenario(){
        LOGGER.debug("afterScenario starts");
        reservationService.clean();
    }

    @Given("^I'm in the flight search page")
    public void iMInTheFlightSearchPage() throws Throwable {
        LOGGER.debug("iMInTheReservationsPage starts");
        vuelingFlightSearchPage.openAt(VuelingSearchPageUrl);
    }

    @When("^I search for the following flight:\"([^\"]*)\",\"([^\"]*)\"$")
    public void iDoFlightSearch(String origin, String destination) throws Throwable {
        SearchFlightDTO searchFlightDTO = mapSearchFlightDTO(origin, destination);
        vuelingFlightSearchPage.searchFlight(searchFlightDTO);
    }

    @NotNull
    private SearchFlightDTO mapSearchFlightDTO(String origin, String destination) {
        SearchFlightDTO searchFlightDTO = new SearchFlightDTO();
        searchFlightDTO.setOriginLocation(origin);
        searchFlightDTO.setDestinationLocation(destination);
        return searchFlightDTO;
    }

    @Then("^I get the flight search result in the flight search result page$")
    public void iGetSearchResult() throws Throwable {
        LOGGER.debug("iGetTheReservationInTheReservationsList starts");
        vuelingFlightSearchResultPage.waitUntilResultSectionIsShowed();
        Assert.assertEquals(vuelingFlightSearchResultPage.getExpectedResultText(), EXPECTED_RESULT);
    }
}
