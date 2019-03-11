package TestLowCoupledToUI.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObject {
    private static final int TIME_OUT_IN_SECONDS = 20;

    protected WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
    }

    protected void navigateTo(String URL) {
        driver.get(URL);
    }

    protected void waitForVisibilityOfElement(String elementId) {
        WebDriverWait wait= new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elementId)));
    }


}
