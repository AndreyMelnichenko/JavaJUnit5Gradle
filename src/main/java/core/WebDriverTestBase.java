package core;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

import static com.codeborne.selenide.Selenide.open;
import static utils.PropertiesCache.getProperty;

public class WebDriverTestBase {

    @BeforeAll
    public static void setUp() throws MalformedURLException, UnknownHostException { ;
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("enableVNC", true);
        ChromeOptions options = new ChromeOptions();
        Configuration.startMaximized = true;
        options.addArguments("start-maximized");
        caps.setCapability(ChromeOptions.CAPABILITY, options);
        if(InetAddress.getLocalHost().getHostName().equals("user5ab6-pc")) {
            RemoteWebDriver driver = new RemoteWebDriver(new URL(getProperty("selenoidUrl")), caps);
            WebDriverRunner.setWebDriver(driver);
        }
    }

//    @BeforeEach
//    public void setupEachMethod(){
//        open("about:blank");
//    }

    @AfterAll
    public static void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
