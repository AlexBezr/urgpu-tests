package tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import pages.MainPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static pages.MainPage.*;

@Tag("regress")
class mainPageTests extends TestBase {

    MainPage mainPage = new MainPage();

    @DisplayName("Check main page")
    @Test
    void CheckMainBlockMenu() {
        mainPage.checkMainBar("Университет");
        mainPage.checkMainBar("Образование");
        mainPage.checkMainBar("Наука");
        mainPage.checkMainBar("Контакты");
        mainPage.checkMainBar("Пресс-служба");
        mainPage.checkMainBar("Расписание");
    }

    @DisplayName("Проверка кликабельности Университет")
    @Test
    @Step("Проверка кликабельности Университет")
    void CheckUniversityButton() {
        mainPage.clickpage("Университет");
        mainPage.checkpage("Университет");
    }

    @DisplayName("Проверка кликабельности Образование")
    @Test
    @Step("Проверка кликабельности Образование")
    void CheckEducationButton() {
        mainPage.clickpage("Образование");
        mainPage.checkpage("Образовательная деятельность в УрГПУ");
    }

    @DisplayName("Проверка кликабельности Наука")
    @Test
    @Step("Проверка кликабельности Наука")
    void CheckScienceButton() {
        mainPage.clickpage("Наука");
        mainPage.checkpage("Учить и учиться!");
    }

    @DisplayName("Проверка кликабельности Студенту")
    @Test
    @Step("Проверка кликабельности Студенту")
    void CheckStudentButton() {
        mainPage.clickpage("Студенту");
        mainPage.checkpage("Лучшие студенты УрГПУ");
    }

    @DisplayName("Проверка кликабельности Контакты")
    @Test
    @Step("Проверка кликабельности Контакты")
    void CheckContactButton() {
        mainPage.clickpage("Контакты");
        mainPage.checkpage("Контактная информация и реквизиты");
    }

    @DisplayName("Проверка кликабельности Пресс-служба")
    @Test
    @Step("Проверка кликабельности Пресс-служба")
    void CheckNewsButton() {
        mainPage.clickpage("Пресс-служба");
        mainPage.checkpage("Мы делаем новости интересными");
    }

    @DisplayName("Проверка кликабельности Расписание")
    @Test
    @Step("Проверка кликабельности Расписание")
    void CheckScheduleButton() {
        mainPage.clickpage("Расписание");
        mainPage.checkpage("Расписание занятий");
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
