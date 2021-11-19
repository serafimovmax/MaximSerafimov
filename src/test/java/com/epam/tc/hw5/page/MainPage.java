package com.epam.tc.hw5.page;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(className = "uui-navigation")
    private WebElement headerMenu;

    @FindBy(className = "benefit-icon")
    private List<WebElement> benefitIcons;

    @FindBy(xpath = "//span[@class='benefit-txt']")
    private List<WebElement> benefitText;

    @FindBy(id = "frame")
    private WebElement iframe;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    @FindBy(xpath = "//ul[@class='sidebar-menu left']/li")
    private List<WebElement> leftMenu;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    @Step("Check user name is displayed")
    public boolean checkUserNameDisplayed() {
        return userName.isDisplayed();
    }
}
