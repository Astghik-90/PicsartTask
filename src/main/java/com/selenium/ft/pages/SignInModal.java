package com.selenium.ft.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInModal extends BasePage {
    private WebDriver driver;
    private final By MODAL_LOCATOR = By.cssSelector("[data-testid=registration-modal-container]");
    private final By CLOSE_ICON_LOCATOR = By.cssSelector("[data-testid=modal-close-icon]");

    public SignInModal(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    public boolean isModalOpened(){
        waitElementToBeVisible(MODAL_LOCATOR);
        return isElementVisible(MODAL_LOCATOR);
    }

    public void closeModal(){
        if(isModalOpened()){
            waitElementToBeVisible(CLOSE_ICON_LOCATOR);
            click(CLOSE_ICON_LOCATOR);
        }
    }

}
