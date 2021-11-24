package com.epam.tc.hw6;

import static com.epam.tc.hw6.Constants.TITLE_HOME_PAGE;

import com.epam.tc.hw6.driver.DriverSingleton;
import com.epam.tc.hw6.model.User;
import com.epam.tc.hw6.page.LoginPage;
import com.epam.tc.hw6.page.MainPage;
import com.epam.tc.hw6.service.UserCreator;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

@Feature("Base Test for Main Page and Different Elements Page")
@Story("Set Up, Login, Tear Down")
public class BaseHomePageTest {
    public WebDriver webDriver;
    public SoftAssert softAssert;
    public LoginPage loginPage;
    public MainPage mainPage;
    public User someUser;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        webDriver = DriverSingleton.getWebDriver();
        softAssert = new SoftAssert();
        loginPage = new LoginPage(webDriver);
        someUser = UserCreator.withCredentialsFromProperty();

        //1. Open test site by URL
        loginPage.openPage();

        //2. Assert Browser title
        softAssert.assertTrue(loginPage.getPageTitle().contains(TITLE_HOME_PAGE.get()));

        //3. Perform login
        mainPage = loginPage.login(someUser);

        //4. Assert Username is loggined
        softAssert.assertTrue(mainPage.fullUserName().isDisplayed());
        softAssert.assertEquals(mainPage.getUserName(), Constants.USER_FULL_NAME.get());
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverSingleton.closeWebDriver();
    }
}
