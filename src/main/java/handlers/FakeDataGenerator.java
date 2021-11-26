package handlers;

import com.github.javafaker.Faker;

import java.util.Random;

public class FakeDataGenerator {

    public static String getFakeFirstName() {
        Faker faker = new Faker();
        return faker.name().firstName();
    }

    public static String getFakeLastName() {
        Faker faker = new Faker();
        return faker.name().lastName();
    }

    public static String getFakeEmail() {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public static String getFakeAdultAge() {
        Random randomAge = new Random();
        return randomAge.ints(18, 100).findFirst().toString();
    }

}
