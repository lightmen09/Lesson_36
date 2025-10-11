package data;

import com.github.javafaker.Faker;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    private static final Faker faker = new Faker(new Locale("en"));

    public static <T> T getRandom(T[] values) {
        return values[ThreadLocalRandom.current().nextInt(values.length)];
    }

    public static String randomFirstName() { return faker.name().firstName(); }
    public static String randomLastName() { return faker.name().lastName(); }
    public static String randomEmail() { return faker.internet().emailAddress(); }
    public static String randomPhone() { return faker.phoneNumber().subscriberNumber(10); }

    public static String randomGender() {
        return faker.options().option("Male", "Female", "Other");
    }

    public static String randomYear() {
        return String.valueOf(faker.number().numberBetween(1950, 2025));
    }

    public static String randomDay() {
        return String.format("%02d", faker.number().numberBetween(1, 25));
    }

    public static String randomMonth() {
        return faker.options().option(
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        );
    }

    public static String randomSubject() {
        return faker.options().option("Math", "Biology", "Chemistry", "Physics");
    }

    public static String randomHobby() {
        return faker.options().option("Sports", "Reading", "Music");
    }

    public static String randomPicture() { return "1234.png"; }

    public static String randomAddress() { return faker.address().streetAddress(); }

    public static String randomState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");
    }

    public static String randomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> "";
        };
    }
}