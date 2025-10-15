package tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebStepsTest {

    @Step("Открываем Github")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Найти репозиторий  {reposit}")
    public void searchButtonAndRepository(String reposit) {
        $(".search-input-container").click();
        $("#query-builder-test").sendKeys(reposit);
        $("#query-builder-test").submit();
    }

    @Step("Переход по ссылке {reposit}")
    public void clickOnFindRepository(String reposit) {
        $(linkText(reposit)).click();
    }

    @Step("Открываем вкладку Issues")
    public void openIssuesPage() {
        $("#issues-tab").click();
    }

    @Step("Проверяем номер ")
    public void shouldHaveIssueWithNumber(String number) {
        $(withText(number)).should(Condition.exist);
    }
}
