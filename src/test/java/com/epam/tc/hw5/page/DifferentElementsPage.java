package com.epam.tc.hw5.page;

import static org.assertj.core.api.Assertions.assertThat;

import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DifferentElementsPage extends AbstractPage {

    @FindBy(linkText = "SERVICE")
    private WebElement service;
    @FindBy(linkText = "DIFFERENT ELEMENTS")
    private WebElement differentElements;

    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//label[contains(.,'Water')]")
    private WebElement waterCheckbox;
    @FindBy(xpath = "//label[contains(.,'Wind')]")
    private WebElement windCheckbox;
    @FindBy(xpath = "//label[contains(.,'Selen')]")
    private WebElement selenRadio;

    @FindBy(css = "select.uui-form-element")
    private WebElement dropdownColors;
    @FindBy(xpath = "//option[contains(.,'Yellow')]")
    private WebElement yellow;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    private List<WebElement> logsPanel;

    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Step("Click to Service button")
    public void clickToServiceButton() {
        service.click();
    }

    @Step("Click to Different Elements button")
    public void clickToDifferentElementsButton() {
        differentElements.click();
    }

    @Step("Check Different Elements url")
    public String getDifferentElementsURL() {
        return webDriver.getCurrentUrl();
    }

    @Step("Select Water Checkbox")
    public void selectWaterCheckbox() {
        waterCheckbox.click();
    }

    public void isWaterCheckboxSelected() {
        assertThat(waterCheckbox.isSelected());
    }

    @Step("Select Wind Checkbox")
    public void selectWindCheckbox() {
        windCheckbox.click();
    }

    public void isWindCheckboxSelected() {
        assertThat(windCheckbox.isSelected());
    }

    @Step("Select Selen Radio")
    public void selectSelenRadio() {
        selenRadio.click();
    }

    public void isSelenRadioSelected() {
        assertThat(selenRadio.isSelected());
    }

    @Step("Click to Dropdown Colors")
    public void clickDropdownColors() {
        Select selectDropdown = new Select(dropdownColors);
        selectDropdown.selectByVisibleText("Yellow");
    }

    public void isYellowSelected() {
        assertThat(yellow.isSelected());
    }

    @Step("Get Logs Panel text")
    public List<String> getLogsPanelText() {
        return logsPanel.stream().map(logMessage -> logMessage.getText()
                        .substring(logMessage.getText().indexOf(" ") + 1))
                .collect(Collectors.toList());
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
