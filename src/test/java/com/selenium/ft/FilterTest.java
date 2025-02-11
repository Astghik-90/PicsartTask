package com.selenium.ft;

import com.selenium.ft.pages.EditorPage;
import com.selenium.ft.pages.ImagePage;
import com.selenium.ft.pages.SearchPage;
import com.selenium.ft.pages.SignInModal;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.selenium.ft.utils.Util.sleep;

public class FilterTest extends BaseTest {

    @Test
    @Description("Test to open the search page")
    public void test() {
        SoftAssert softAssert = new SoftAssert();
        //System.out.println("Test started");

        SearchPage searchPage = new SearchPage(driver);

        //Navigate to Picsart Search.
        searchPage.open();
        searchPage.acceptCookies();
        searchPage.switchToIframe();

        //Click on the filter button and verify that the filters disappear.
        searchPage.openFilters();
        searchPage.clickFilterIcon();
        softAssert.assertEquals(searchPage.isFiltersVisible(), false, "Filters are not hidden");

        //Click on the filter button again to open the filters.
        searchPage.openFilters();

        //Choose the "Personal" checkbox from the “License” section and verify that there are no “PLUS” assets.
        searchPage.checkPersonalCheckbox();
        softAssert.assertEquals(searchPage.plusAssetCount(), 0, "There are some plus assets");

        //Clicking on an asset should display image browser page and there will be the like, save, and Edit this image buttons.
        ImagePage imagePage = searchPage.clickOnFirstImage();
        String currentURL = imagePage.getCurrentUrl();
        softAssert.assertTrue(currentURL.contains(ImagePage.getImagePartialURL()));
        softAssert.assertTrue(imagePage.isEditButtonVisible());
        softAssert.assertTrue(imagePage.isSaveButtonVisible());


        //Click on the like button and verify that the sign-in popup appears.
        imagePage.clickLikeButton();

        SignInModal signInModal = new SignInModal(driver);
        softAssert.assertTrue(signInModal.isModalOpened(), "Sign in modal is not opened after clicking 'LIKE'");

        //Close the popup.
        signInModal.closeModal();

        //Go back to the search screen
        driver.navigate().back();
        driver.navigate().refresh();

        //Remove the filter.
        searchPage.switchToIframe();
        searchPage.openFilters();
        searchPage.uncheckPersonalCheckbox();

        //Click on a “PLUS” asset and verify that the editing screen opens with the image applied to the canvas.
        EditorPage editorPage = searchPage.clickOnPlusAsset();
        signInModal.closeModal();
        currentURL = editorPage.getCurrentUrl();
        softAssert.assertTrue(currentURL.contains(editorPage.getEditorPartialURL()));
        softAssert.assertTrue(editorPage.canvasIsVisible());

        softAssert.assertAll();
    }

}
