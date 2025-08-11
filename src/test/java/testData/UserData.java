package testData;

import com.github.javafaker.Faker;

public class UserData {
    static Faker faker = new Faker();
    public static Long id = faker.random().nextLong(10_000);
    public static String userName = faker.name().firstName();
    public static String userSurname = faker.name().lastName();
    public static String userEmail = faker.internet().emailAddress();
    public static String userPassword = faker.internet().password();
    public static String userPhone = faker.phoneNumber().phoneNumber();
    public static Integer userStatus = faker.number().numberBetween(Integer.MIN_VALUE, Integer.MAX_VALUE);

}
