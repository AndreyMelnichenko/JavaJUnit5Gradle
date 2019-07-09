package com;

import Pages.MainPage;

import core.WebDriverTestBase;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class OpenMainPage extends WebDriverTestBase {

    @Test
    public void openPage(){
        MainPage mainPage = open("https://www.ukr.net/", MainPage.class);
        mainPage.isMainLogoPresent()
                .isMainLogoPresent()
                .goToFooter();
    }
}
