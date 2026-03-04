package tests;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import pages.MainPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static pages.MainPage.TopBar;

@Tag("regress")
class mainPageTests extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Проверка вверхней панели")
    void CheckElementsOnTopBar() {
        MainPage.CheckTopBar("Matches");
        MainPage.CheckTopBar("Results");
        MainPage.CheckTopBar("Events");
        MainPage.CheckTopBar("Players");
        MainPage.CheckTopBar("Stats");
        MainPage.CheckTopBar("Fantasy");
        MainPage.CheckTopBar("Forum");
        MainPage.CheckTopBar("Media");
        MainPage.CheckTopBar("Betting");
        MainPage.CheckTopBar("Live");
        Selenide.sleep(3000);
    }

    @Test
    @Tag("regress")
    @DisplayName("Проверка основных элементов страницы")
    void CheckMidElements() {
        TopBar.find(byText("News")).click();
        MainPage.CheckMidBar("TODAY'S MATCHES");
        MainPage.CheckMidBar("RECENT ACTIVITY");
        MainPage.CheckMidBar("TOP 30 TRANSFERS");
        MainPage.CheckMidBar("EVENTS");
        MainPage.CheckMidBar("RANKING");
        MainPage.CheckMidBar("Today's news");
        Selenide.sleep(3000);
    }

    @DisplayName("Проверка кликабельности Matches")
    @Test
    @Step("Проверка кликабельности Matches")
    void CheckResultsPage() {
        TopBar.find(byText("Matches")).click();
        $(".new-standardPageGrid").shouldHave(text("Upcoming Counter-Strike matches"));
        Selenide.sleep(3000);
    }

    @DisplayName("Проверка кликабельности Stats")
    @Test
    @Step("Проверка кликабельности Stats")
    void CheckStatsButton() {
        TopBar.find(byText("Stats")).click();
        $(".widthControl").shouldHave(text("Best players"));
        Selenide.sleep(3000);
    }

    @DisplayName("Проверка кликабельности Results")
    @Test
    @Step("Проверка кликабельности Results")
    void CheckResultsButton() {
        TopBar.find(byText("Results")).click();
        $(".widthControl").shouldHave(text("Featured results"));
        Selenide.sleep(3000);
    }

    @DisplayName("Ошибочная авторизация пользователя")
    @Test
    @Disabled
    void Signup() {
        $(".navsignin").click();
        $(".login-dialog standard-box").$("[name=username]").setValue("login");
        $(".login-dialog standard-box").$("[name=password]").setValue("password");
        $("type=submit").find(byText("Login")).click();
    }
}
