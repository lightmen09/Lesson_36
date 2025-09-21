package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.AutomationPracticeFormPage;

public class RegistrationWithPageObjects {

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
                .setFirstName("Tom")
                .setLastName("Jerry")
                .setEmail("TomJerry@disney.com")
                .selectGender("Male")
                .setPhone("1234567890")
                .setDateOfBirth("9", "August", "1999")
                .setSubject("Economics")
                .selectHobby("Sports")
                .uploadPicture("1234.png")
                .setAddress("Home")
                .selectState("Haryana")
                .selectCity("Panipat")
                .submit()

                .checkTable("Student Name", "Tom Jerry")
                .checkTable("Student Email", "TomJerry@disney.com")
                .checkTable("Gender", "Male")
                .checkTable("Mobile", "1234567890")
                .checkTable("Date of Birth", "9 August,1999")
                .checkTable("Subjects", "Economics")
                .checkTable("Hobbies", "Sports")
                .checkTable("Picture", "1234.png")
                .checkTable("Address", "Home")
                .checkTable("State and City", "Haryana Panipat");
    }

    @Test
    void fillFormMinimumDataTest() {
        formPage.openPage()
                .setFirstName("OnlyName")
                .setLastName("OnlyLast")
                .selectGender("Male")
                .setPhone("9876543210")
                .submit()

        .checkTable("Student Name", "OnlyName OnlyLast")
        .checkTable("Gender", "Male")
        .checkTable("Mobile", "9876543210");
    }

    @Test
    void negativeInvalidEmailTest() {
        formPage.openPage()
                .setFirstName("Bad")
                .setLastName("Email")
                .setEmail("invalidEmail")
                .selectGender("Male")
                .setPhone("1112223333")
                .submit()

        .checkTable("Student Name", "Bad Email");

    }
}
