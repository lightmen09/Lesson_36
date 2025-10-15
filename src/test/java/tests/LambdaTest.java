package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static org.openqa.selenium.By.linkText;

public class LambdaTest {
    private static final String REPOSITORY = "alfa-laboratory/arui-feather";
    private final String ISSUE = "1268";

    @Test
    public void lambdaStepTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $(".search-input-container").click();
            $("input#query-builder-test").sendKeys(REPOSITORY);
            $("input#query-builder-test").submit();
        });

        step("Кликаем по найденной ссылке репозитория " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });

        step("Открываем вкладку Issues", () -> {
            $("#issues-tab").click();
        });

        step("Issues содержит номер " + ISSUE, () -> {
            $(withText(ISSUE)).should(Condition.exist);
        });
    }

    @Test
    public void testAnnotatedStep() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebStepsTest step = new WebStepsTest();

        step.openMainPage();
        step.searchButtonAndRepository(REPOSITORY);
        step.clickOnFindRepository(REPOSITORY);
        step.openIssuesPage();
        step.shouldHaveIssueWithNumber(ISSUE);
    }
}
