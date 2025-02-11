package com.selenium.ft.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Instant;

import static com.selenium.ft.constants.Constants.BASE_URL;

public class SearchPage extends BasePage {
    private WebDriver driver;
    private String searchUrl;
    private final By PLUS_LOCATOR = By.cssSelector("[data-testid='badge']");
    private final By PLUS_ASSET = By.cssSelector("div [rel=nofollow]");
    private final By FILTER_ICON = By.cssSelector("[id=filter_icon]");
    private final String FILTER_STATE_ATTRIBUTE = "data-automation";
    private final By SEARCH_FILTER_ROOT = By.cssSelector("[data-testid=search-filter-root]");
    private final By PERSONAL_CHECKBOX = By.cssSelector("[aria-label=licenses-Personal-checkbox]");
    private final By FIRST_IMAGE = By.cssSelector("[data-testid=item-container]>div>div");
    private final By IFRAME_LOCATOR = By.cssSelector("[data-testid='com.picsart.social.search']");

    public SearchPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.searchUrl = BASE_URL + "/search";
    }
    @Step("Navigate to Picsart Search")
    public void open() {
        driver.get(searchUrl);
    }

    public void switchToIframe() {
        switchToIframe(IFRAME_LOCATOR);
    }

    @Step("Check Plus assets count")
    public int plusAssetCount() {
        return getElementCount(PLUS_LOCATOR);
    }

    @Step("Open Filters, if not opened yet")
    public void openFilters() {
        String currentState = getElementState(FILTER_ICON, FILTER_STATE_ATTRIBUTE);

        if (currentState.equals("closed")) {
            click(FILTER_ICON);
        }
    }
    @Step("Close Filters, if not closed yet")
    public void closeFilters() {
        String currentState = getElementState(FILTER_ICON, FILTER_STATE_ATTRIBUTE);

        if (currentState.equals("open")) {
            click(FILTER_ICON);
        }
    }

    public boolean isFiltersVisible() {
        return isElementVisible(SEARCH_FILTER_ROOT);
    }

    @Step("CLick on Filter Icon")
    public void clickFilterIcon() {
        click(FILTER_ICON);
    }

    public void checkPersonalCheckbox() {
        selectCheckbox(PERSONAL_CHECKBOX);
        waitElementToBeInvisible(PLUS_LOCATOR);
    }

    public void uncheckPersonalCheckbox() {
        uncheckCheckbox(PERSONAL_CHECKBOX);
    }


    public ImagePage clickOnFirstImage() {
        click(FIRST_IMAGE);
        waitPageToBeLoaded(ImagePage.getImagePartialURL());
        return new ImagePage(driver);
    }

    public EditorPage clickOnPlusAsset() {
        waitElementToBeVisible(PLUS_ASSET);
        click(PLUS_ASSET);
        return new EditorPage(driver);
    }

}
