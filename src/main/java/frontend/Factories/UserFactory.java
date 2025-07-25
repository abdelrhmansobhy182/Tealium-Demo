package frontend.Factories;

import com.github.javafaker.Faker;

import java.util.Random;

public class UserFactory {

    private static final Faker faker = new Faker();
    private static final Random random = new Random();

    public static String generatePhoneNumber() {
        String[] egyptPrefixes = {"010", "011", "012", "015"};
        String egPrefix = egyptPrefixes[random.nextInt(egyptPrefixes.length)];
        return egPrefix + faker.number().digits(8);
    }

    public static String generateRandomName() {
        return faker.name().firstName();
    }

    public static String generateRandomPassword() {
        int firstDigit = faker.number().numberBetween(1, 9);
        String remainingDigits = faker.numerify("######");
        return firstDigit + remainingDigits;
    }

    public static String generateRandomEmail() {
        String firstName = faker.name().firstName().toLowerCase();
        String lastName = faker.name().lastName().toLowerCase();
        String digits = faker.number().digits(2);
        return firstName + "." + lastName + digits + "@gmail.com";
    }


}

