package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import core.TestListener;
import io.qameta.allure.Step;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@ExtendWith(TestListener.class)
public class MainPage {
    private SelenideElement mainPageLogo = $(".header__logo");
    private SelenideElement footer = $("footer");
    private SelenideElement mailForm = $("body>.form");
    private SelenideElement forecastBar = $("div.sinoptik");
    private List<SelenideElement> sectionsNameList = $$("section.feed__section>.feed__section--title");

    @Step("Check page logo")
    public MainPage isMainLogoPresent(){
        mainPageLogo.waitUntil(Condition.visible,5000);
        return this;
    }

    @Step("Check footer bar")
    public MainPage goToFooter(){
        mainPageLogo.scrollIntoView(true);
        footer.waitUntil(Condition.visible,5000);
        return this;
    }

    @Step("Check Login form present")
    public MainPage isMailFormPresent(){
        //mailForm.waitUntil(Condition.appear,10000).scrollIntoView(true);
        return this;
    }

    @Step("Check forecast bar")
    public MainPage isForecastBarDisplayed(){
        forecastBar.scrollIntoView(true).waitUntil(Condition.visible,5000);
        return this;
    }

    @Step("How many sections appeared")
    public int getSectionsCount(){
        return sectionsNameList.size();
    }

    @Step("Scroll to each section")
    public void checkSections(){
        sectionsNameList.forEach(a->a.waitUntil(Condition.visible,5000).scrollIntoView(true));
    }

    @Step("Is first section contain TEXT")
    public void selenideAssertSectionRange(){
        sectionsNameList.get(0).waitUntil(Condition.visible,5000).shouldHave(Condition.text("fail"));
    }

}
