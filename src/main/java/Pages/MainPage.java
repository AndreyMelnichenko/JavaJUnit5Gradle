package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private SelenideElement mainPageLogo = $(".header__logo");
    private SelenideElement footer = $("footer");
    private SelenideElement mailForm = $("body>.form");

    public MainPage isMainLogoPresent(){
        mainPageLogo.waitUntil(Condition.visible,5000);
        return this;
    }

    public MainPage goToFooter(){
        footer.scrollIntoView(true).waitUntil(Condition.visible,5000);
        return this;
    }

    public MainPage isMailFormPresent(){
        mailForm.scrollIntoView(true).waitUntil(Condition.visible,5000);
        return this;
    }

}
