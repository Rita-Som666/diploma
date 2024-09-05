package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;


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

    private static String month(){

        return LocalDate.now().plusMonths(1).format(DateTimeFormatter.ofPattern("MM"));
    }

    private static String year(){

        return LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }

    private static String invalidYear(){

        return LocalDate.now().plusYears(6).format(DateTimeFormatter.ofPattern("yy"));
    }

    private static String validCardNumber(){

        return "4444444444444441";
    }

    private static String invalidCardNumber1(){

        return "4444444444444442";
    }

    private static String invalidCardNumber2(){

        Faker faker = new Faker();

        return faker.finance().creditCard();
    }

    private static String cvc(){
        Random random = new Random();
        return String.valueOf(100 + random.nextInt(900));
    }

    public static CardData validData(){
        return new CardData(validCardNumber(), randomName(), month(), year(), cvc());
    }
}
