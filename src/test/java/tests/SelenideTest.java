package tests;

import com.codeborne.selenide.logevents.SelenideLogger;

import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {
    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".search-input-container").click();
        $(".search-input-container").click();
        $("#query-builder-test").sendKeys("alfa-laboratory");
        $("#query-builder-test").submit();

        $(linkText("alfa-laboratory/arui-feather")).click();
        $("#issues-tab").click();
        $("[data-tab-item='i1issues-tab']").shouldHave(text("Issues"));
    }
}
