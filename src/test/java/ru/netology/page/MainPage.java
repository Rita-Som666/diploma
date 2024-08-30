package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private SelenideElement Buy = $(byText("Купить"));
    private SelenideElement BuyOnCredit = $(byText("Купить в кредит"));

    public BuyPage (){
        Buy.click();
    }
}
