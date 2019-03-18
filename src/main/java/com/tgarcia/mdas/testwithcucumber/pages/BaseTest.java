package com.tgarcia.mdas.testwithcucumber.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest extends PageObject {
    private static final int TIME_OUT_IN_SECONDS = 20;
    protected void waitForVisibilityOfElementById(String elementId) {
        WebDriverWait wait= new WebDriverWait(getDriver(), TIME_OUT_IN_SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementId)));
    }

    protected void waitForVisibilityOfElementByCss(String cssSelector) {
        WebDriverWait wait= new WebDriverWait(getDriver(), TIME_OUT_IN_SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
    }


}
