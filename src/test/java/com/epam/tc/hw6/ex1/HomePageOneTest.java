package com.epam.tc.hw6.ex1;

import static com.epam.tc.hw6.PageElements.IMG_TEXT;
import static com.epam.tc.hw6.PageElements.LEFT_BUTTONS_TEXT;
import static com.epam.tc.hw6.PageElements.MENU_BUTTONS_TEXT;

import com.epam.tc.hw6.BaseHomePageTest;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature(value = "Home Page Test")
@Story(value = "Test for Buttons, iFrame, Text, Icons")
public class HomePageOneTest extends BaseHomePageTest {

    @Test
    public void homePageOneTest() {

        //5. Assert menu buttons are displayed
        softAssert.assertTrue(mainPage.headerMenuDisplayed());
        softAssert.assertEquals(mainPage.getHeaderMenuText(), MENU_BUTTONS_TEXT);

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
