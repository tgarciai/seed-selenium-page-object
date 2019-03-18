package com.tgarcia.mdas.testwithcucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class VuelingFlightSearchResultPage extends BaseTest {

    private static final String RESEARCH_SECTION_ID = "research";
    private static final String RESULT_CSS_SELECTOR = "#research > div.colRow2.sectionTable.height39 > h3";

    public void waitUntilResultSectionIsShowed(){
        waitForVisibilityOfElementById(RESEARCH_SECTION_ID);
    }

    public String getExpectedResultText(){
        WebElement result = getDriver().findElement(
                By.cssSelector(RESULT_CSS_SELECTOR)
        );
        return result.getText();
    }
}
