package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import lombok.Value;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
@Value
public class BuyPage {
    private SelenideElement payByCard = $(byText("Оплата по карте"));


    public BuyPage(){
        payByCard.shouldBe(Condition.visible);
    }
}
