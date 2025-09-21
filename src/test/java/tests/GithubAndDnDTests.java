package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;


public class GithubAndDnDTests {

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    @DisplayName("GitHub: Solutions → Enterprise (hover) и проверка")
    void githubSolutionsEnterpriseHoverTest() {

        open("https://github.com");

        // Ховер на Solutions,
        $x("//button[normalize-space()='Solutions']").hover();

        //  ищем и кликаем по тексту Enterprise
        $(byTagAndText("a", "Enterprise")).click();

        // Проверка содержит "The AI-powered developer platform."
        $("[data-testid='Hero']").shouldHave(text("The AI-powered developer platform"));
    }

    @Test
    @DisplayName("Drag&Drop через Actions(): A → B")
    void dragAndDropWithActionsTest() {
        open("https://the-internet.herokuapp.com/drag_and_drop");

        // Проверка До
        $("#column-a header").shouldHave(exactText("A"));
        $("#column-b header").shouldHave(exactText("B"));

        //  Перетащить A на место B
        actions().dragAndDrop($("#column-a"), $("#column-b")).perform();

        // Проверка после
        $("#column-a header").shouldHave(exactText("B"));
        $("#column-b header").shouldHave(exactText("A"));
    }
}