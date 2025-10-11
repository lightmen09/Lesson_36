package data;

public class TestData {
    public final String firstName;
    public final String lastName;
    public final String fullName;
    public final String email;
    public final String invalidEmail;
    public final String gender;
    public final String phone;
    public final String year;
    public final String day;
    public final String month;
    public final String subject;
    public final String hobby;
    public final String picture;
    public final String address;
    public final String state;
    public final String city;
    public final String stateAndCity;

    public TestData() {
        this.firstName = RandomUtils.randomFirstName();
        this.lastName = RandomUtils.randomLastName();
        this.fullName = firstName + " " + lastName;

        this.email = RandomUtils.randomEmail();
        this.invalidEmail = "invalidEmail";

        this.gender = RandomUtils.randomGender();
        this.phone = RandomUtils.randomPhone();
        this.year = RandomUtils.randomYear();
        this.day = RandomUtils.randomDay();
        this.month = RandomUtils.randomMonth();
        this.subject = RandomUtils.randomSubject();
        this.hobby = RandomUtils.randomHobby();
        this.picture = RandomUtils.randomPicture();
        this.address = RandomUtils.randomAddress();
        this.state = RandomUtils.randomState();
        this.city = RandomUtils.randomCity(state);
        this.stateAndCity = state + " " + city;
    }
}