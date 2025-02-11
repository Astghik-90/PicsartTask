package com.selenium.ft.pages;

import com.selenium.ft.setup.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ImagePage extends BasePage {
    private WebDriver driver;
    private static String imagePartialURL = ConfigReader.getBaseURL() + ConfigReader.getEditorPath();
    private final By LIKE_LOCATOR = By.cssSelector("[data-testid=likeComponent]");
    private final By EDIT_BUTTON_LOCATOR = By.xpath("//button[contains(@class,'info-block-editButton')]");
    private final By SAVE_BUTTON_LOCATOR = By.cssSelector("[data-testid=smart-dropdown] div:nth-child(2)");

    public ImagePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    public static String getImagePartialURL(){
        return imagePartialURL;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public void clickLikeButton(){
        click(LIKE_LOCATOR);
    }

    public boolean isEditButtonVisible() {
        return isElementVisible(EDIT_BUTTON_LOCATOR);
    }

    public boolean isSaveButtonVisible() {
        return isElementVisible(SAVE_BUTTON_LOCATOR);
    }
}
