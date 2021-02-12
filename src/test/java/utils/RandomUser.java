package utils;

import com.github.javafaker.Faker;

import java.util.Random;

// Klasa random tworzy randomowe połączenia dla różnego typu inputów do dalszych działąń
public class RandomUser {
    public static void main(String[] args) {
        RandomUser randomUser = new RandomUser();
        System.out.println(randomUser);
    }
    public String firstName;
    public String lastName;
    public String email;
    public Boolean isRegistered = false;
    public String password = "1qaz!QAZ";
    public int yearOfBirth;
    public int dayOfBirth;
    public int monthOfBirth;
    public String postalCode;
    public String state;
    public String address1;
    public String address2;
    public String city;
    public String phone_mobile;

    // Tworzy dane dla randomowego użytkownika i je drukuje
    public RandomUser() {
        Faker faker = new Faker();
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.email = this.firstName + this.lastName + faker.random().nextInt(100000) + "@gmail.com";
        Random random = new Random();
        this.dayOfBirth = random.nextInt(28) + 1;
        this.monthOfBirth = random.nextInt(12)+ 1;
        this.yearOfBirth = random.nextInt(122)+ 1900;
        this.postalCode = String.valueOf(faker.random().nextInt(10000,99999));
        this.state = faker.address().state();
        this.phone_mobile = faker.phoneNumber().cellPhone();
        this.address1 = faker.address().streetAddress();
        this.city = faker.address().cityName();

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
                ", phone_mobile='" + phone_mobile + '\'' +
                '}';
    }
}
