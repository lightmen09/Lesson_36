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

    private static final String[] genders = {"Male", "Female", "Other"};
    public static final String gender = getRandom(genders);

    public static final String phone = faker.phoneNumber().subscriberNumber(10);

    public static final String dayOfBirth = String.valueOf(ThreadLocalRandom.current().nextInt(1, 28));
    public static final String monthOfBirth = "August";
    public static final String yearOfBirth = String.valueOf(ThreadLocalRandom.current().nextInt(1980, 2005));
    public static final String birthDate = dayOfBirth + " " + monthOfBirth + "," + yearOfBirth;

    private static final String[] subjects = {"Economics", "Maths", "History", "Computer Science"};
    public static final String subject = getRandom(subjects);

    private static final String[] hobbies = {"Sports", "Reading", "Music"};
    public static final String hobby = getRandom(hobbies);

    public static final String picture = "1234.png";
    public static final String address = faker.address().streetAddress();

    private static final String[] states = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
    public static final String state = getRandom(states);

    public static final String city = switch (state) {
        case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
        case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
        case "Haryana" -> faker.options().option("Karnal", "Panipat");
        case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
        default -> null;
    };

    public static final String stateAndCity = state + " " + city;
}