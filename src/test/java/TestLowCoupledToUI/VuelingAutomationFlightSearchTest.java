package TestLowCoupledToUI;

import ch.qos.logback.classic.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import TestLowCoupledToUI.pages.BaseTest;
import TestLowCoupledToUI.pages.VuelingFlightSearchPage;
import TestLowCoupledToUI.pages.VuelingFlightSearchResultPage;

import java.lang.invoke.MethodHandles;

public class VuelingAutomationFlightSearchTest extends BaseTest {

    private static final Logger LOGGER  = (Logger) LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getName());
    private static final String EXPECTED_RESULT = "Tu búsqueda:";

    @Test
    public void TestVuelingFlightSearch() throws InterruptedException {
        driver = initializeWebDriver();

        VuelingFlightSearchPage vuelingFlightSearchPage = new VuelingFlightSearchPage(driver);
        vuelingFlightSearchPage.navigateToVuelingFlightSearchPage();
        vuelingFlightSearchPage.selectOriginAirport("Barcelona");
        vuelingFlightSearchPage.selectDestinationAirport("Madrid");

        VuelingFlightSearchResultPage vuelingFlightSearchResultPage = new VuelingFlightSearchResultPage(driver);
        vuelingFlightSearchResultPage.waitUntilResultSectionIsShowed();

        String expectedResult = vuelingFlightSearchResultPage.getExpectedResultText();
        Assert.assertEquals(expectedResult, EXPECTED_RESULT);

        endAutomation();
    }
}
