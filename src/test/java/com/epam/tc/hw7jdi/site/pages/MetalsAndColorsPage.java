package com.epam.tc.hw7jdi.site.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.tc.hw7jdi.site.sections.MetalsAndColorsForm;
import java.util.List;
import java.util.stream.Collectors;

@Url("/metals-colors.html")
@Title("Metal and Colors")
public class MetalsAndColorsPage extends WebPage {
    @Css("form")
    public static MetalsAndColorsForm metalsAndColorsForm;
    @Css(".results li")
    private List<UIElement> results;

    public List<String> getResults() {
        return results.stream().map(UIElement::getText).collect(Collectors.toList());
    }
}
