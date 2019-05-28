package com.tablohub;

import core.WebDriverTestBase;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import tablohub.ForgotPasswordPage;
import tablohub.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.PropertiesCache.getProperty;

@Epic("Treatment UI Tests")
@Feature("Treatment Forgot Password Test")
public class TreatmentForgotPasswordTest extends WebDriverTestBase {

    private ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage();
    private LoginPage loginPage = new LoginPage();

    @Test
    @DisplayName("Forgot Password Test")
    @Description("Forgot Password Test")
    @Story("Forgot Password Test")
    public void forgotPasswordPageElementsTest() {
        open(getProperty("tablohub.baseUrl"));
        loginPage.goForgotPasswordPage();
        assertTrue(forgotPasswordPage.isInputForgotPassword());
        assertFalse(forgotPasswordPage.isForgotButton());
        assertTrue(forgotPasswordPage.isTipsShowing("Username field can't be empty"));
    }

}
