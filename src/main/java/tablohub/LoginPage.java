package tablohub;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPage {
    private SelenideElement logo = $(".header-logo img");
    private SelenideElement SingInForm = $(".auth-page form");
    private SelenideElement loginButton = $(".button");
    private List<SelenideElement> passwordControlsLinks = $$(".password-controls a");
    private SelenideElement loginInput = $("input[formcontrolname='login']");
    private SelenideElement passwordInput = $("input[formcontrolname='password']");

    public boolean isLogoPresent(){
        return logo.waitUntil(Condition.visible, 5000).isDisplayed();
    }

    public boolean isLoginFormPresent(){
        return SingInForm.waitUntil(Condition.visible, 500).isDisplayed();
    }

    public boolean isLoginButtonPresent(){
        return loginButton.waitUntil(Condition.visible, 5000).isDisplayed();
    }

    public SelenideElement loginButton(){
        return loginButton.waitUntil(Condition.visible, 5000);
    }

    private HashMap getPasswordControlLinks(){
        HashMap<String, SelenideElement> passwordControlLinksMap = new HashMap<>();
        passwordControlsLinks.forEach(a-> {passwordControlLinksMap.put(a.getText().trim(), passwordControlsLinks.get(passwordControlsLinks.indexOf(a)));});
        return passwordControlLinksMap;
    }

    public SelenideElement getPasswordControlLink(String key) {
        return (SelenideElement) getPasswordControlLinks().get(key);
    }

    public void goForgotPasswordPage(){
        getPasswordControlLink("Forgot password!").waitUntil(Condition.visible, 5000).click();
    }
}
