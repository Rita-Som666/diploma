package ru.netology.data;

import lombok.Value;

@Value
public class User {

    private String cardNumber;
    private String name;
    private String month;
    private String year;
    private String cvv;
}
