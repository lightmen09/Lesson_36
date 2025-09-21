package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {

    @Test
    void successfulSearchTest() {
        Configuration.pageLoadStrategy = "eager";
        open("https://bing.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("html").shouldHave(text("https://selenide.org"));
    }
    @Test
    void successfulSearchTestNew() {
        Configuration.pageLoadStrategy = "eager";
        open("https://bing.com/");
        $("[name=q]").setValue("yandex").pressEnter();
        $("html").shouldHave(text("https://ya.ru"));
    }
}