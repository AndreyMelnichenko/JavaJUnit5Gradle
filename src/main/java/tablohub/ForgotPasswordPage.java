package tablohub;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ForgotPasswordPage {
    private SelenideElement inputForgotPassword = $(".form-control input");
    private SelenideElement forgotButton = $(".button");
    private SelenideElement chapterArea = $("form>h3");
    private SelenideElement notificationElement = $(".notification>p");

    public boolean isInputForgotPassword(){
        return inputForgotPassword
                .waitUntil(Condition.visible, 5000)
                .isDisplayed();
    }

    public boolean isForgotButton(){
        return forgotButton
                .waitUntil(Condition.visible, 5000)
                .isEnabled();
    }

    public boolean isTipsShowing(String text){
        inputForgotPassword.waitUntil(Condition.visible, 5000).click();
        chapterArea.waitUntil(Condition.visible, 5000).click();
        return notificationElement.
                waitUntil(Condition.visible, 5000)
                .shouldHave(Condition.text(text))
                .isDisplayed();
    }
}
