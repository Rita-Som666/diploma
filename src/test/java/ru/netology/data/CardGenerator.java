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
        return faker.name().firstName()+" "+faker.name().lastName();

    }

    private static String invalidName1(){
        Faker faker = new Faker(new Locale("en"));
        return faker.name().firstName();

    }

    private static String invalidName2(){
        Faker faker = new Faker(new Locale("ru"));
        return faker.name().firstName()+" "+faker.name().lastName();

    }

    private static String invalidName3(){
        return "ivan1 ivanov";

    }

    private static String invalidName4(){
        return "ivan ivanov.";

    }

    private static String month(){

        return LocalDate.now().plusMonths(1).format(DateTimeFormatter.ofPattern("MM"));
    }

    private static String year(){

        return LocalDate.now().plusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }

    private static String invalidYear1(){

        return LocalDate.now().plusYears(6).format(DateTimeFormatter.ofPattern("yy"));
    }

    private static String invalidYear2(){

        return LocalDate.now().minusYears(1).format(DateTimeFormatter.ofPattern("yy"));
    }

    private static String nowYear(){

        return LocalDate.now().format(DateTimeFormatter.ofPattern("yy"));
    }

    private static String invalidMonth(){

        return LocalDate.now().minusMonths(1).format(DateTimeFormatter.ofPattern("MM"));
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

    private static String invalidCvc(){
        Random random = new Random();
        return String.valueOf(10 + random.nextInt(90));
    }


    public static CardData validData(){
        return new CardData(validCardNumber(), randomName(), month(), year(), cvc());
    }

    public static CardData invalidStatus(){
        return new CardData(invalidCardNumber1(), randomName(),month(), year(),cvc());
    }

    public static CardData invalidData(){
        return new CardData(invalidCardNumber2(), randomName(),month(), year(),cvc());
    }

    public static CardData invalidDate1(){
        return new CardData(validCardNumber(), randomName(), invalidMonth(), nowYear(),cvc());
    }

    public static CardData invalidDate2(){
        return new CardData(validCardNumber(), randomName(), month(), invalidYear2(),cvc());
    }

    public static CardData invalidDate3(){
        return new CardData(validCardNumber(), randomName(), month(), invalidYear1(),cvc());
    }

    public static CardData invalidUser1(){
        return new CardData(validCardNumber(), invalidName1(), month(), year(), cvc());
    }

    public static CardData invalidUser2(){
        return new CardData(validCardNumber(), invalidName2(), month(), year(), cvc());
    }

    public static CardData invalidUser3(){
        return new CardData(validCardNumber(), invalidName3(), month(), year(), cvc());
    }

    public static CardData invalidUser4(){
        return new CardData(validCardNumber(), invalidName4(), month(), year(), cvc());
    }

    public static CardData invalidCvv(){
        return new CardData(validCardNumber(), randomName(), month(), year(), invalidCvc());
    }
}
