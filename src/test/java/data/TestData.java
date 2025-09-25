package data;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class TestData {
    private static final Faker faker = new Faker(new Locale("en"));


    public static <T> T getRandom(T[] values) {
        return values[ThreadLocalRandom.current().nextInt(values.length)];
    }

    public static final String firstName = faker.name().firstName();
    public static final String lastName = faker.name().lastName();
    public static final String fullName = firstName + " " + lastName;

    public static final String email = faker.internet().emailAddress();
    public static final String invalidEmail = "invalidEmail";

    public static final String gender = faker.options().option("Male", "Female", "Other");

    public static final String phone = faker.phoneNumber().subscriberNumber(10);
    public static final String year = String.valueOf(faker.number().numberBetween(1950, 2025));
    public static final String day = String.valueOf(faker.number().numberBetween(1, 25));
    public static final String month = faker.options().option(
            "January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"
    );
    public static final String subject = faker.options().option("Math", "Biology", "Chemistry", "Physics");
    public static final String hobby = faker.options().option("Sports", "Reading", "Music");

    public static final String picture = "1234.png";
    public static final String address = faker.address().streetAddress();
    public static final String state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

    public static final String city = switch (state) {
        case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
        case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
        case "Haryana" -> faker.options().option("Karnal", "Panipat");
        case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
        default -> null;
    };

    public static final String stateAndCity = state + " " + city;
}