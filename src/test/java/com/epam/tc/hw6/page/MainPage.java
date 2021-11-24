package com.epam.tc.hw6.page;

import io.qameta.allure.Step;
import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']/li")
    private List<WebElement> headerMenu;

    @FindBy(xpath = "//div[@class='benefit-icon']")
    private List<WebElement> benefitIcons;

    @FindBy(xpath = "//span[@class='benefit-txt']")
    private List<WebElement> benefitTxt;

    @FindBy(id = "frame")
    private WebElement iframe;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    @FindBy(xpath = "//ul[@class='sidebar-menu left']/li")
    private List<WebElement> leftMenu;

    protected MainPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }

    @Step("Get User Name text")
    public String getUserName() {
        return userName.getText();
    }

    @Step("Get full User Name")
    public WebElement fullUserName() {
        return userName;
    }

    @Step("Get Header Menu Text")
    public List<String> getHeaderMenuText() {
        return headerMenu.stream()
                         .map(WebElement::getText)
            .collect(Collectors.toList());
    }

    @Step("Header menu is displayed")
    public Boolean headerMenuDisplayed() {
        return headerMenu.stream().allMatch(WebElement::isDisplayed);
    }

    @Step("Benefit Icons are displayed")
    public Boolean benefitIconsDisplayed() {
        return benefitIcons.stream()
                           .allMatch(WebElement::isDisplayed);
    }

    @Step("Check Benefit Icons Text")
    public List<String> getBenefitIconsText() {
        return benefitTxt.stream()
                         .map(WebElement::getText)
            .collect(Collectors.toList());
    }

    @Step("Benefit Icons Text is displayed")
    public Boolean benefitIconsTextDisplayed() {
        return benefitTxt.stream().allMatch(WebElement::isDisplayed);
    }

    @Step("Check iFrame")
    public WebElement getIframe() {
        return iframe;
    }

    @Step("Switch to iFrame button")
    public void switchToIframeButton() {
        webDriver.switchTo().frame(iframe);
    }

    @Step("iFrame button is displayed")
    public Boolean iframeButtonDisplayed() {
        return frameButton.isDisplayed();
    }

    @Step("Switch to parent iFrame")
    public void switchToParentFrame() {
        webDriver.switchTo().parentFrame();
    }

    @Step("Left menu is displayed")
    public Boolean leftMenuDisplayed() {
        return leftMenu.stream()
                       .allMatch(WebElement::isDisplayed);
    }

    @Step("Get left menu text")
    public List<String> getLeftMenuText() {
        return leftMenu.stream().map(WebElement::getText)
                       .collect(Collectors.toList());
    }
}
