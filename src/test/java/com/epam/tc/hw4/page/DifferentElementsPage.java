package com.epam.tc.hw4.page;

import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPage extends AbstractPage {

    @FindBy(className = "dropdown-toggle")
    private WebElement service;

    @FindBy(linkText = "DIFFERENT ELEMENTS")
    private WebElement differentElements;

    @FindBy(xpath = "//label[contains(.,'Water')]")
    private WebElement waterCheckbox;

    @FindBy(xpath = "//label[contains(.,'Wind')]")
    private WebElement windCheckbox;

    @FindBy(xpath = "//label[contains(.,'Selen')]")
    private WebElement radioSelen;

    @FindBy(className = "colors")
    private WebElement dropdownColors;

    @FindBy(xpath = "//option[text()='Yellow']")
    private WebElement yellowColor;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    private List<WebElement> logsComponent;


    public DifferentElementsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    @Step("Click SERVICE button")
    public void clickServiceButton() {
        service.click();
    }

    @Step("Click Different Elements button")
    public void goToDifferentElementsPage() {
        differentElements.click();
    }

    @Step("Select checkbox {Water}")
    public void selectWaterCheckbox() {
        waterCheckbox.click();
    }

    @Step("Select checkbox {Wind}")
    public void selectWindCheckbox() {
        windCheckbox.click();
    }

    @Step("Select radio {Selen}")
    public void selectSelenRadio() {
        radioSelen.click();
    }

    @Step("Click Dropdown Colors")
    public void clickDropdownColors() {
        dropdownColors.click();
    }

    @Step("Dropdown select color {Yellow}")
    public void selectYellowColor() {
        yellowColor.click();
    }

    @Step("Get logs text")
    public List<String> getLogsComponetText() {
        return logsComponent.stream()
                            .map(logsText -> logsText
                                .getText().substring(logsText.getText().indexOf(" ") + 1))
                            .collect(Collectors.toList());
    }
}
