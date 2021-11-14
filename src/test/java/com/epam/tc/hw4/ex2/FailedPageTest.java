package com.epam.tc.hw4.ex2;

import static com.epam.tc.hw4.PageElements.IMG_TEXT;
import static com.epam.tc.hw4.PageElements.LEFT_BUTTONS_TEXT;

import com.epam.tc.hw4.BaseHomePageTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature(value = "Test for Different Elements Page")
@Story(value = "Open page, select checkboxes, radio, dropdown and get los text")
public class FailedPageTest extends BaseHomePageTest {

    @Test
    public void failedHomePageOneTest() {

        //5. Assert menu buttons are displayed
        softAssert.assertTrue(mainPage.headerMenuDisplayed());
        softAssert.assertEquals(mainPage.getHeaderMenuText(), "SOME BUTTONS");

        //6. Assert that there are 4 images on the Index Page and they are displayed
        softAssert.assertTrue(mainPage.benefitIconsDisplayed());

        //7. Assert that texts are displayed and equal to expected
        softAssert.assertTrue(mainPage.benefitIconsTextDisplayed());
        softAssert.assertEquals(mainPage.getBenefitIconsText(), IMG_TEXT);

        //8. Assert that the iframe exists
        softAssert.assertTrue(mainPage.getIframe().isDisplayed());

        //9. Assert that the “Frame Button” exists
        mainPage.switchToIframeButton();
        mainPage.iframeButtonDisplayed();

        //10. Assert that driver has focus on the original window
        mainPage.switchToParentFrame();

        //11. Assert that left section menu items are displayed and have proper text
        softAssert.assertTrue(mainPage.leftMenuDisplayed());
        softAssert.assertEquals(mainPage.getLeftMenuText(), LEFT_BUTTONS_TEXT);

        softAssert.assertAll();
    }
}
