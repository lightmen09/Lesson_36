package pages.components;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;

public class CalendarComponent {

    public void setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $$(".react-datepicker__day")
                .findBy(text(day))
                .click();
    }
}
