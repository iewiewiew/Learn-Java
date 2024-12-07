package utils;

import com.github.javafaker.Faker;

/**
 * @author weimenghua
 * @time 2023-08-17 11:13
 * @description
 */
public class DataMockTest {
    public static void main(String[] args) {
        Faker fake = new Faker();
        String name = fake.name().fullName();
        String address = fake.address().fullAddress();
        String email = fake.internet().emailAddress();
        System.out.printf("Name: " + name);
    }
}
