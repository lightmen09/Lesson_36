package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    @BeforeEach
    void setUp() {
        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1920x1080";
        open("https://mybook.ru/");
        acceptCookiesIfPresent();
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }
    protected void acceptCookiesIfPresent() {
        try {

            $x("//button[contains(.,'Принять')]")
                    .scrollIntoView(true).click();
        } catch (Throwable ignored) {}
    }
}
