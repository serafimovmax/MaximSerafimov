package com.epam.tc.hw7jdi.site;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.tc.hw7jdi.site.pages.HomePage;
import com.epam.tc.hw7jdi.site.pages.MetalsAndColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class SiteJdi {
    public static HomePage homePage;
    public static MetalsAndColorsPage metalsAndColorsPage;
}
