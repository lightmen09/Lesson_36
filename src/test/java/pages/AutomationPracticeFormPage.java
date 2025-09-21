package pages;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultsTable;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormPage {

    private final ResultsTable resultsTable = new ResultsTable();
    private final CalendarComponent calendar = new CalendarComponent();

    // elements
    private final SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            phoneInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            state = $("#state"),
            city = $("#city"),
            submitButton = $("#submit");

    // actions
    public AutomationPracticeFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    public AutomationPracticeFormPage removeBanners() {
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        return this;
    }

    public AutomationPracticeFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage selectGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    public AutomationPracticeFormPage setPhone(String value) {
        phoneInput.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setDate(day, month, year);
        return this;
    }

    public AutomationPracticeFormPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public AutomationPracticeFormPage selectHobby(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    public AutomationPracticeFormPage uploadPicture(String fileName) {
        uploadPicture.uploadFromClasspath(fileName);
        return this;
    }

    public AutomationPracticeFormPage setAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }

    public AutomationPracticeFormPage selectState(String value) {
        state.click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }

    public AutomationPracticeFormPage selectCity(String value) {
        city.click();
        $("#stateCity-wrapper").$(byText(value)).click();
        return this;
    }

    public AutomationPracticeFormPage submit() {
        submitButton.click();
        return this;
    }

    public AutomationPracticeFormPage checkTable(String key, String value) {
        resultsTable.checkResult(key, value);
        return this;
    }
}