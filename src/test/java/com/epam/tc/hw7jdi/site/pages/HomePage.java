package com.epam.tc.hw7jdi.site.pages;

import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.tc.hw7jdi.site.sections.LoginForm;

@Url("/index.html")
@Title("Home Page")
public class HomePage extends WebPage {
    @Css("form")
    public static LoginForm loginForm;
    @Css("img#user-icon")
    public static Icon userIcon;
    @Css(".profile-photo [ui=label]")
    public static Text userName;
    @Css("header ul.navbar-nav.m-l8 > li")
    public static Menu headerMenu;
    @Css(".logout")
    Button buttonLogout;

    public void logOut() {
        userIcon.click();
        buttonLogout.click();
    }
}
