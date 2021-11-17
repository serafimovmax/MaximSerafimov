package com.epam.tc.hw5.cucumber.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.util.TextsForComparison;
import io.cucumber.java.en.Then;
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
    public void clickOnCheckboxes(String checkboxType) {
        switch (checkboxType) {
            case "Water":
                differentElementsPage.selectWaterCheckbox();
                break;
            case "Wind":
                differentElementsPage.selectWindCheckbox();
                break;
            case "Earth":
            case "Fire":
                throw new UnsupportedOperationException();
            default: throw new RuntimeException("Incorrect value");
        }
    }

    @Then("{string} checkbox is selected")
    public void checkboxIsChecked(String checkboxType) {
        switch (checkboxType) {
            case "Water":
                differentElementsPage.isWaterCheckboxSelected();
                break;
            case "Wind":
                differentElementsPage.isWindCheckboxSelected();
                break;
            case "Earth":
            case "Fire":
                throw new UnsupportedOperationException();
            default: throw new RuntimeException("Incorrect value");
        }
    }

    @When("I click on {string} radio")
    public void clickOnRadio(String ratioType) {
        switch (ratioType) {
            case "Selen":
                differentElementsPage.selectSelenRadio();
                break;
            case "Gold":
            case "Silver":
            case "Bronze":
                throw new UnsupportedOperationException();
            default: throw new RuntimeException("Incorrect value");
        }
    }

    @When("{string} radio is checked")
    public void radioIsChecked(String ratioType) {
        switch (ratioType) {
            case "Selen":
                differentElementsPage.isSelenRadioSelected();
                break;
            case "Gold":
            case "Silver":
            case "Bronze":
                throw new UnsupportedOperationException();
            default: throw new RuntimeException("Incorrect value");
        }
    }

    @When("I select {string} color in dropdown")
    public void selectColorInDropdown(String color) {
        differentElementsPage.clickDropdownColors();
        switch (color) {
            case "Yellow":
                differentElementsPage.selectYellow();
                break;
            case "Red":
            case "Green":
            case "Blue":
                throw new UnsupportedOperationException();
            default: throw new RuntimeException("Incorrect value");
        }
    }

    @When("{string} color is selected")
    public void yellowIsChecked(String color) {
        switch (color) {
            case "Yellow":
                differentElementsPage.isYellowSelected();
                break;
            case "Red":
            case "Green":
            case "Blue":
                throw new UnsupportedOperationException();
            default: throw new RuntimeException("Incorrect value");
        }
    }

    @When("Log rows are displayed")
    public void logRowsAreDisplayed() {
        assertThat(differentElementsPage.getLogsPanelText())
                .isEqualTo(TextsForComparison.LOG_CHANGES);
    }
}
