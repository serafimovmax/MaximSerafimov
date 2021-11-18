package com.epam.tc.hw5.page;

import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserTablePage extends AbstractPage {

    private static final String URL = "https://jdi-testing.github.io/jdi-light/user-table.html";

    @FindBy(linkText = "USER TABLE")
    private WebElement userTableButton;

    @FindBy(xpath = "//td[1]")
    private List<WebElement> userNumber;

    @FindBy(css = "td select")
    private List<WebElement> typeDropdowns;

    @FindBy(xpath = "//td[3]")
    private List<WebElement> userNames;

    @FindBy(xpath = "//td[4]//span")
    private List<WebElement> descriptionTexts;

    @FindBy(xpath = "//td[4]//input[@type = 'checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//tbody/tr[1]/td[2]/select/*")
    private List<WebElement> dropdownListRoman;

    @FindBy(id = "ivan")
    private WebElement vipIvanCheckbox;

    @FindBy(xpath = "//ul[@class='panel-body-list logs']/li")
    private List<WebElement> logs;


    public UserTablePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Step("Click on User Table")
    public void clickOnUserTable() {
        userTableButton.click();
        new WebDriverWait(webDriver, TEN_SECONDS).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState").equals("complete"));
    }

    @Step("Get User Table Page URL")
    public String getPageURL() {
        return URL;
    }

    @Step("Get Type Dropdowns quantity")
    public int getTypeDropdownsQuantity() {
        return typeDropdowns.size();
    }

    @Step("Get Usernames quantity")
    public int getUsernamesQuantity() {
        return userNames.size();
    }

    @Step("Get quantity of the Description Texts under Images")
    public int getDescriptionTextsUnderImagesQuantity() {
        return descriptionTexts.size();
    }

    @Step("Get Checkboxes quantity")
    public int getCheckboxesQuantity() {
        return checkboxes.size();
    }

    @Step("Get  list of User Table values")
    public List<List<String>> getUserTableValuesList() {
        List<List<String>> userTableValuesList = new ArrayList<>();
        for (int n = 0; n < 6; n++) {
            List<String> subList = new ArrayList<>();
            subList.add(userNumber.get(n).getText());
            subList.add(userNames.get(n).getText());
            subList.add(descriptionTexts.get(n).getText()
                    .replaceAll("[\\n]", " "));
            userTableValuesList.add(subList);
        }
        return userTableValuesList;
    }

    @Step("Get values of DropdownList")
    public List<String> getRomanDropdownListValues() {
        return dropdownListRoman.stream()
                                .map(WebElement::getText)
                                .collect(Collectors.toList());
    }

    @Step("Select Vip Ivan Checkbox")
    public void selectVipSergeyIvanCheckbox() {
        vipIvanCheckbox.click();
    }

    @Step("Get Log row text")
    public String getLogRowText() {
        String logRowText = logs.get(0).getText();
        return logRowText.substring(logRowText.indexOf(" ") + 1);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
