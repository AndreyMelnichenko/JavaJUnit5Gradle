package com.tablohub;

import com.codeborne.selenide.Condition;
import core.WebDriverTestBase;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import tablohub.LoginPage;
import utils.LinkResponse;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;
import static utils.PropertiesCache.getProperty;


@Epic("Treatment UI Tests")
@Feature("Treatment Download")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TreatmentDownloadTest extends WebDriverTestBase {

    private LoginPage loginPage = new LoginPage();

    @Test
    @DisplayName("Check Login Page Web Elements")
    @Description("Check Login Page Web Elements")
    @Story("Check Login Page Web Elements")
    public void openLoginPage(){
        open("https://stage.tablohub.com");
        assertTrue(loginPage.isLogoPresent());
        assertTrue(loginPage.isLoginFormPresent());
        assertTrue(loginPage.isLoginButtonPresent());
        assertFalse(loginPage.loginButton().isEnabled());
    }

    @Test
    @DisplayName("Enter with bad credentials")
    @Description("Enter with bad credentials")
    @Story("Enter with bad credentials")
    public void enterWithBadCredentials(){
        open(getProperty("tablohub.baseUrl"));
        assertTrue(loginPage.getPasswordControlLink("Forgot password!").isDisplayed());
    }

    @Test
    @DisplayName("Check forgot password link HTTP response code")
    @Description("Check forgot password link HTTP response code")
    @Story("Check forgot password link HTTP response code")
    public void checkForgotPassword(){
        open(getProperty("tablohub.baseUrl"));
        assertTrue(loginPage.getPasswordControlLink("Forgot password!").isDisplayed());
        assertEquals(200, LinkResponse.getCode(loginPage.getPasswordControlLink("Forgot password!").getAttribute("href")));
    }

    @Test
    @DisplayName("Check Download Treatment")
    @Description("Check Download Treatment")
    @Story("Check Download Treatment")
    public void checkDownloadTreatment(){
        open(getProperty("tablohub.baseUrl"));
        $(".header-logo img").waitUntil(Condition.visible, 5000).isDisplayed();
        $("input[formcontrolname='login']").waitUntil(Condition.visible, 5000).setValue("herfhuef");
        $("input[formcontrolname='password']").waitUntil(Condition.visible, 5000).setValue("eruhegr");
        $(".button").click();
    }
}
