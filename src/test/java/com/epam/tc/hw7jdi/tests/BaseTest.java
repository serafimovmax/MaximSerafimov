package com.epam.tc.hw7jdi.tests;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.tc.hw7jdi.site.SiteJdi.homePage;
import static com.epam.tc.hw7jdi.site.pages.HomePage.loginForm;
import static com.epam.tc.hw7jdi.site.pages.HomePage.userIcon;
import static com.epam.tc.hw7jdi.site.pages.HomePage.userName;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.tc.hw7jdi.entities.User;
import com.epam.tc.hw7jdi.site.SiteJdi;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class BaseTest {
    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        WebDriverUtils.killAllSeleniumDrivers();
        initSite(SiteJdi.class);

        homePage.open();
        homePage.checkOpened();
        userIcon.click();
        loginForm.loginAs(User.USER_DEFAULT);
        assertThat(userName.getText())
            .isEqualTo(User.USER_DEFAULT.fullName);
    }

    @AfterSuite(alwaysRun = true)
    public void killDown() {
        homePage.logOut();
        killAllSeleniumDrivers();
    }
}
