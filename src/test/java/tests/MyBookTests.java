package tests;

import com.codeborne.selenide.SelenideElement;
import data.AuthorBook;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import java.time.Duration;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class MyBookTests extends TestBase {

    @CsvSource({
            "Анджей Сапковский, Ведьмак",
            "Донато Карризи, Девушка в тумане"
    })
    @ParameterizedTest(name = "В результатах поиска по автору {0} должна быть книга {1}")
    @Tag("SEARCH")
    void searchResultShouldShowHeader(String authorName, String bookName) {
        $("[placeholder='Книга или автор']").setValue(authorName).pressEnter();
        $$("a[href*='/books/'], a[href*='/book/'], a[href*='/work/'], a[href*='/author/']")
                .shouldHave(sizeGreaterThan(0), Duration.ofSeconds(10));
        $$("a[href*='/books/'] p, a[href*='/book/'] p, a[href*='/work/'] p, " +
                "a[href*='/author/'] p, p[class*='lnjchu-'], h1, h2, h3, a, span")
                .findBy(text(bookName))
                .shouldBe(visible, Duration.ofSeconds(10));
    }

    @ValueSource(strings = {"Анджей Сапковский", "Донато Карризи"})
    @ParameterizedTest(name = "Поиск по фамилии автора {0} должен показывать книги")
    @Tag("SMOKE")
    void clickFirstSearchResult(String authorName) {
        $("[placeholder='Книга или автор']").setValue(authorName).pressEnter();
        $$("a[href*='/books/'], a[href*='/book/'], a[href*='/work/'], a[href*='/author/']")
                .shouldBe(sizeGreaterThan(0))
                .first()
                .click();
    }

    @EnumSource(AuthorBook.class)
    @ParameterizedTest(name = "В результатах поиска по автору {0} должна быть книга {1}")
    @Tag("SMOKE")
    void checkSearchResultContainFullAuthorName(AuthorBook data) {
        String authorName = data.getAuthor();
        String bookName = data.getBook();

        $("[placeholder='Книга или автор']").setValue(authorName).pressEnter();
        $$("a[href*='/books/'], a[href*='/book/'], a[href*='/work/'], a[href*='/author/']")
                .findBy(text(bookName));

    }
}