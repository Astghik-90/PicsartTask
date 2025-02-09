package com.selenium.ft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private final By ACCEPT_COOKIES = By.cssSelector("[id=onetrust-accept-btn-handler]");


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void acceptCookies(){
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES));
        driver.findElement(ACCEPT_COOKIES).click();
    }
    public void switchToIframe(By iframeLocator) {
        WebElement iframeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(iframeLocator));
        driver.switchTo().frame(iframeElement);
    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));

        driver.findElement(locator).click();
    }

    protected void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void waitElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitElementToBeInvisible(By locator){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitPageToBeLoaded(String partialURL) {
        wait.until(ExpectedConditions.urlContains(partialURL));
    }

    protected void sendKeys(By locator, String text) {
        waitElementToBeVisible(locator);
        driver.findElement(locator).sendKeys(text);
    }

    public boolean isElementVisible(By locator) {
        return driver.findElement(locator).isDisplayed();
    }

    public int getElementCount(By locator) {
        return driver.findElements(locator).size();
    }

    public String getElementState(By locator, String attributeName) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        String state = driver.findElement(locator).getDomAttribute(attributeName);
        return state;
    }

    public void selectCheckbox(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        WebElement checkbox = driver.findElement(locator);
        if(!checkbox.isSelected()){
            click(checkbox);
        }
    }

    public void uncheckCheckbox(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        WebElement checkbox = driver.findElement(locator);
        if(checkbox.isSelected()){
            click(checkbox);
        }
    }
}
