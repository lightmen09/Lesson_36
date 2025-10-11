package pages.components;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ResultsTable {
    public void checkResult(String key, String value) {
        $(".table-responsive").shouldHave(text(key), text(value));
    }
    public void shouldNotHaveResult() {
        $(".modal-content").shouldNot();
    }
}
