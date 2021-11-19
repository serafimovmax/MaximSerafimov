package com.epam.tc.hw5.cucumber.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.util.TextsForComparison;
import io.cucumber.java.en.When;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Feature("Test for Service")
@Story("Test for checkboxes and logs")
public class DifferentElementsSteps extends AbstractBaseStep {

    @When("I click on \"Service\" button in Header")
    public void clickServiceButton() {
        differentElementsPage.clickToServiceButton();
    }

    @When("I click on \"Different elements\" button in Service Dropdown")
    public void clickOnButtonInServiceDropdown() {
        differentElementsPage.clickToDifferentElementsButton();
    }

    @When("\"Different elements\" page should be opened")
    public void pageShouldBeOpened() {
        assertThat(differentElementsPage.getDifferentElementsURL())
                .isEqualTo(TextsForComparison.DIFFERENT_ELEMENTS_URL);
    }

    @When("I select {string} in checkbox")
    public void selectCheckboxes(String string) {
        differentElementsPage.selectElements(string);
    }

    @When("I click on \"Selen\" radio")
    public void clickOnRadio() {
        differentElementsPage.selectSelenRadio();
    }

    @When("\"Selen\" radio is checked")
    public void radioIsChecked() {
        differentElementsPage.isSelenRadioSelected();
    }

    @When("I select \"Yellow\" color in dropdown")
    public void selectColorInDropdown() {
        differentElementsPage.clickDropdownColors();
    }

    @When("\"Yellow\" color is selected")
    public void yellowIsChecked() {
        differentElementsPage.isYellowSelected();
    }

    @When("Log rows are displayed")
    public void logRowsAreDisplayed() {
        assertThat(differentElementsPage.getLogsPanelText())
                .isEqualTo(TextsForComparison.LOG_CHANGES);
    }
}
