package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    public static SelenideElement TopBar = $(".mainarea");
    public static SelenideElement BasicName = $(".wrapper");

    public MainPage checkMainBar(String value) {
        TopBar.shouldHave(text(value));
        return this;
    }

    public MainPage checkpage(String value) {
        BasicName.shouldHave(text(value));
        return this;
    }

    public MainPage clickpage(String value) {
        TopBar.shouldHave(text(value)).click();
        return this;
    }
}
