package com.epam.tc.hw7jdi.tests;

import static com.epam.tc.hw7jdi.site.SiteJdi.metalsAndColorsPage;
import static com.epam.tc.hw7jdi.site.pages.HomePage.headerMenu;
import static com.epam.tc.hw7jdi.site.pages.MetalsAndColorsPage.metalsAndColorsForm;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.tc.hw7jdi.entities.MetalsAndColorsData;
import com.epam.tc.hw7jdi.utils.DataProviders;
import org.testng.annotations.Test;

public class TestMetalsAndColorsPage extends BaseTest {

    @Test(dataProvider = "metalsAndColorsDataSet", dataProviderClass = DataProviders.class)
    public void testMetalsAndColorsPage(MetalsAndColorsData metalsAndColors) {

        headerMenu.select("Metals & Colors");
        metalsAndColorsForm.submit(metalsAndColors);
        assertThat(metalsAndColors.getExpectedResultFromMACdata(metalsAndColors))
            .isEqualTo(metalsAndColorsPage.getResults());
    }
}
