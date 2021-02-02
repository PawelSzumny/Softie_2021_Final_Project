package utils;

import com.github.javafaker.Faker;

public class RandomUser {
    public String firstName;
    public String lastName;
    public String email;
    Boolean isRegistered = false;
    public String password = "1qaz!QAZ";
    public int yearOfBirth;
    public int dayOfBirth;
    public int monthOfBirth;
    String postalCode;
    String state;
    String address1;
    String address2;
    String city;

    public RandomUser() {
        Faker faker = new Faker();
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.email = this.firstName + this.lastName + faker.random().nextInt(100000) + "@gmail.com";
        this.dayOfBirth = faker.date().birthday().getDay();
        this.monthOfBirth = faker.date().birthday().getMonth();
        this.postalCode = faker.address().zipCode();
        this.state = faker.address().state();
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "RandomUser{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", isRegistered=" + isRegistered +
                ", password='" + password + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", dayOfBirth=" + dayOfBirth +
                ", monthOfBirth=" + monthOfBirth +
                ", postalCode='" + postalCode + '\'' +
                ", state='" + state + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
