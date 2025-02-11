package com.selenium.ft.pages;

import com.selenium.ft.setup.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditorPage extends BasePage {
    private WebDriver driver;
    private static String editorPartialURL = ConfigReader.getBaseURL() + ConfigReader.getEditorPath();
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
