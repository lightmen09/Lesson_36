package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.AutomationPracticeFormPage;
import data.TestData;

public class RegistrationWithFaker {

    AutomationPracticeFormPage formPage = new AutomationPracticeFormPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormFullDataTest() {
        formPage.openPage()
                .removeBanners()
                .setFirstName(TestData.firstName)
                .setLastName(TestData.lastName)
                .setEmail(TestData.email)
                .selectGender(TestData.gender)
                .setPhone(TestData.phone)
                .setDateOfBirth(TestData.day, TestData.month, TestData.year)
                .setSubject(TestData.subject)
                .selectHobby(TestData.hobby)
                .uploadPicture(TestData.picture)
                .setAddress(TestData.address)
                .selectState(TestData.state)
                .selectCity(TestData.city)
                .submit()

                .checkTable("Student Name", TestData.fullName)
                .checkTable("Student Email", TestData.email)
                .checkTable("Gender", TestData.gender)
                .checkTable("Mobile", TestData.phone)
                .checkTable("Date of Birth", TestData.day + " " + TestData.month + "," + TestData.year)
                .checkTable("Subjects", TestData.subject)
                .checkTable("Hobbies", TestData.hobby)
                .checkTable("Picture", TestData.picture)
                .checkTable("Address", TestData.address)
                .checkTable("State and City", TestData.stateAndCity);
    }

    @Test
    void fillFormMinimumDataTest() {
        String minFirstName = TestData.firstName;
        String minLastName = TestData.lastName;
        String minFullName = minFirstName + " " + minLastName;
        String minPhone = TestData.phone;

        formPage.openPage()
                .setFirstName(minFirstName)
                .setLastName(minLastName)
                .selectGender("Male")
                .setPhone(minPhone)
                .submit()

                .checkTable("Student Name", minFullName)
                .checkTable("Gender", "Male")
                .checkTable("Mobile", minPhone);
    }

    @Test
    void negativeInvalidEmailTest() {
        formPage.openPage()
                .setFirstName(TestData.firstName)
                .setLastName(TestData.lastName)
                .setEmail(TestData.invalidEmail)
                .selectGender("Male")
                .setPhone(TestData.phone)
                .submit()

                .checkTable("Student Name", TestData.fullName);
    }
}
