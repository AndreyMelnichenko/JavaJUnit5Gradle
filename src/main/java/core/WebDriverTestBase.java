package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.open;

@ExtendWith(TestListener.class)
public class WebDriverTestBase {

    @Step("Init Driver")
    @BeforeAll
    public static void setUp() {
            Configuration.browser = "chrome";
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));

    }

    @BeforeEach
    public void setupEachMethod(){
        open("about:blank");
    }

    @Step("Kill driver")
    @AfterAll
    public static void tearDown() {
        SelenideLogger.removeListener("allure");
        WebDriverRunner.closeWebDriver();
    }
}
