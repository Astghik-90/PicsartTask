package com.selenium.ft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.selenium.ft.constants.Constants.BASE_URL;

public class EditorPage extends BasePage {
    private WebDriver driver;
    private static String editorPartialURL = BASE_URL + "create/editor";
    private final By CANVAS_LOCATOR = By.cssSelector("[data-test=canvas-container]");

    public EditorPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public static String getEditorPartialURL(){
        return editorPartialURL;
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public boolean canvasIsVisible(){
        return isElementVisible(CANVAS_LOCATOR);
    }
}
