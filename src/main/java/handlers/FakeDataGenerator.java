package handlers;

import com.github.javafaker.Faker;

import java.util.Random;

public class FakeDataGenerator {
    Faker faker;
    Random random;

    public FakeDataGenerator() {
        faker = new Faker();
        random = new Random();
    }

    public String getFakeFirstName() {
        return faker.name().firstName();
    }

    public String getFakeLastName() {

        return faker.name().lastName();
    }

    public String getFakeEmail() {
        return faker.internet().emailAddress();
    }

    public String getFakeAdultAge() {
        return String.valueOf(random.ints(18, 100).findFirst().getAsInt());
    }

}
