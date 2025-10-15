package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.AutomationPracticeFormPage;
import data.TestData;

public class RegistrationWithFaker {

    AutomationPracticeFormPage formPage = new AutomationPracticeFormPage();

    @BeforeAll
    static void setupEnvironment() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormFullDataTest() {
        TestData data = new TestData();

        formPage.openPage()
                .removeBanners()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.email)
                .selectGender(data.gender)
                .setPhone(data.phone)
                .setDateOfBirth(data.day, data.month, data.year)
                .setSubject(data.subject)
                .selectHobby(data.hobby)
                .uploadPicture(data.picture)
                .setAddress(data.address)
                .selectState(data.state)
                .selectCity(data.city)
                .submit()

                .checkTable("Student Name", data.fullName)
                .checkTable("Student Email", data.email)
                .checkTable("Gender", data.gender)
                .checkTable("Mobile", data.phone)
                .checkTable("Date of Birth", data.day + " " + data.month + "," + data.year)
                .checkTable("Subjects", data.subject)
                .checkTable("Hobbies", data.hobby)
                .checkTable("Picture", data.picture)
                .checkTable("Address", data.address)
                .checkTable("State and City", data.stateAndCity);
    }

    @Test
    void fillFormMinimumDataTest() {
        TestData data = new TestData();

        formPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .selectGender("Male")
                .setPhone(data.phone)
                .submit()

                .checkTable("Student Name", data.fullName)
                .checkTable("Gender", "Male")
                .checkTable("Mobile", data.phone);
    }

    @Test
    void negativeInvalidEmailTest() {
        TestData data = new TestData();

        formPage.openPage()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setEmail(data.invalidEmail)
                .selectGender("Male")
                .setPhone(data.phone)
                .submit()

                .noTable();
    }
}
