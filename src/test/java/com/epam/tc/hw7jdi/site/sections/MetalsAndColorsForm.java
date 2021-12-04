package com.epam.tc.hw7jdi.site.sections;

import com.epam.jdi.light.elements.complex.Checklist;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.complex.RadioButtons;
import com.epam.tc.hw7jdi.entities.MetalsAndColorsData;

public class MetalsAndColorsForm extends Form<MetalsAndColorsData> {

    @UI("[name=custom_radio_odd]")
    public static RadioButtons summaryOdd;
    @UI("[name=custom_radio_even]")
    public static RadioButtons summaryEven;
    @Css("section[id=elements-checklist] input")
    public static Checklist elementsCheckList;

    @JDropdown(root = "div[ui=dropdown]",
               value = ".filter-option",
               list = "li",
               expand = ".caret")
    public static Dropdown colors;

    @JDropdown(root = "div[ui=combobox]",
               value = ".filter-option",
               list = "li",
               expand = ".caret")
    public static Dropdown metals;

    @Css("#vegetables")
    public Button vegetables;

    @JDropdown(root = "div[ui=droplist]",
               value = ".filter-option",
               list = "li",
               expand = ".caret")
    public static Dropdown vegetablesDropdown;

    @UI("[id=submit-button]")
    public Button submit;

    @Css("[type=checkbox][checked=\"checked\"]")
    public Checkbox selectedVegetables;

    @Override
    public void submit(MetalsAndColorsData metalsAndColorsData) {
        summaryOdd.select(metalsAndColorsData.getSummary().get(0).toString());
        summaryEven.select(metalsAndColorsData.getSummary().get(1).toString());
        metalsAndColorsData.getElements().forEach(elementsCheckList::select);
        colors.select(metalsAndColorsData.getColor());
        metals.select(metalsAndColorsData.getMetals());
        vegetables.click();
        vegetablesDropdown.select("Vegetables");
        metalsAndColorsData.getVegetables().forEach(vegetablesDropdown::select);
        submit.click();
    }
}
