package TestLowCoupledToUI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VuelingFlightSearchResultPage extends PageObject {

    private static final String RESEARCH_SECTION_ID = "research";
    private static final String RESULT_CSS_SELECTOR = "#research > div.colRow2.sectionTable.height39 > h3";

    public VuelingFlightSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void waitUntilResultSectionIsShowed(){
        waitForVisibilityOfElement(RESEARCH_SECTION_ID);
    }

    public String getExpectedResultText(){
        WebElement result = driver.findElement(
                By.cssSelector(RESULT_CSS_SELECTOR)
        );
        return result.getText();
    }

}
