package com;

import Pages.MainPage;
import core.WebDriverTestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Epic("UI Tests")
@Feature("Ukr net")
@DisplayName("Ukr Net")
public class OpenMainPage extends WebDriverTestBase {


    @DisplayName("My test")
    @Description("My test")
    @Story("My test")
    @Tag("smoke")
    @Test
    public void openPage(){
        MainPage mainPage = open("https://www.ukr.net/", MainPage.class);
        mainPage.isMainLogoPresent()
                .goToFooter()
                .isMailFormPresent();
    }

    @Test
    public void forecastTest(){
        MainPage mainPage = open("https://www.ukr.net/", MainPage.class);
        mainPage.isForecastBarDisplayed();
        assertEquals(1,3);
    }
}
