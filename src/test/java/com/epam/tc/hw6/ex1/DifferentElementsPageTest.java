package com.epam.tc.hw6.ex1;

import static com.epam.tc.hw6.PageElements.LOGS_TEXT;

import com.epam.tc.hw6.BaseHomePageTest;
import com.epam.tc.hw6.page.DifferentElementsPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

@Feature(value = "Test for Different Elements Page")
@Story(value = "Open page, select checkboxes, radio, dropdown and get los text")
public class DifferentElementsPageTest extends BaseHomePageTest {

    DifferentElementsPage diffElPage = new DifferentElementsPage(webDriver);

    @Test
    public void homePageOneTest() {

        //5. Open Page
        diffElPage.clickServiceButton();
        diffElPage.goToDifferentElementsPage();

        //6. Select checkboxes
        diffElPage.selectWaterCheckbox();
        diffElPage.selectWindCheckbox();

        //7. Select radio
        diffElPage.selectSelenRadio();

        //8. Select in dropdown
        diffElPage.clickDropdownColors();
        diffElPage.selectYellowColor();

        //9. Assert log rows
        softAssert.assertEquals(diffElPage.getLogsComponetText(), LOGS_TEXT);

        softAssert.assertAll();
    }
}
