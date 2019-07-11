package core;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.Optional;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class TestListener extends WebDriverTestBase implements TestWatcher {
    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.println("Method disables");
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("Method success");
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        System.out.println("Method aborted");
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("\n\n\n TEST FAIL !!!");
        WebDriver driver = getWebDriver();
        System.out.println("\n\n\n"+((RemoteWebDriver)driver).getSessionId().toString());
        saveScreenshotPNG(driver);
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
