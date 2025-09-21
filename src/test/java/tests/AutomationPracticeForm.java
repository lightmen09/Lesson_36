package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeForm {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        //открытие
        open("/automation-practice-form");
        //реклама
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        $("#firstName").setValue("Tom");
        $("#lastName").setValue("Jerry");
        $("#userEmail").setValue("TomJerry@disney.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $("[id=dateOfBirthInput").clear();
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__year-select").selectOption("1999");
        $$(".react-datepicker__day").findBy(text("9")).click();
        $("#subjectsInput").setValue("eco").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("1234.png");
        $("#currentAddress").setValue("Home");
        $("#state").click();
        $("#react-select-3-option-2").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        //отправка формы
        $("#submit").click();

        //Проверка
        $(".table-responsive").shouldHave(text("Tom Jerry"));
        $(".table-responsive").shouldHave(text("TomJerry@disney.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("9 August,1999"));
        $(".table-responsive").shouldHave(text("Economics"));
        $(".table-responsive").shouldHave(text("Sports"));
        $(".table-responsive").shouldHave(text("1234.png"));
        $(".table-responsive").shouldHave(text("Home"));
        $(".table-responsive").shouldHave(text("Haryana Panipat"));
    }
}
