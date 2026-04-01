package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;
import java.util.logging.Level;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static helpers.Attach.*;

public class TestBase {

    static LoggingPreferences logPrefs = new LoggingPreferences();
    static ChromeOptions options = new ChromeOptions();

    @BeforeAll
    static void beforeAll() {
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);

        ChromeOptions options = new ChromeOptions();
        options.setCapability("goog:loggingPrefs", logPrefs);
        options.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserCapabilities = options;

        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach //метод выполняется перед каждым тестом
    void setUpBeforeEach() {
        open("https://uspu.ru/");
    }

    @AfterEach //выполняется после каждого теста
    void addAttachments() {
        screenshotAs("Screenshot"); //Скриншот последнего состояния браузера.
        pageSource(); //Исходный код страницы.
        browserConsoleLogs(); //Логи консоли браузера.
        addVideo(); //Видео записи теста.
        closeWebDriver(); //Закрывает браузер.
    }
}