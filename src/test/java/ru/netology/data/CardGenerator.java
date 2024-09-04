package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

@Value
public class CardGenerator {

    Faker faker;

    private CardGenerator(){
        this.faker = new Faker(new Locale("en"));
    }

    private static String randomName (){
        Faker faker = new Faker(new Locale("en"));
        return faker.name().fullName();

    }
}
