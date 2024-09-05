package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import lombok.Value;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class BuyPage {
    private final SelenideElement payByCard = $(byText("Оплата по карте"));
    private final ElementsCollection input = $$(("span.input__inner"));
    private final SelenideElement cardNumber = input.findBy(Condition.text("Номер карты"))
            .$("input.input__control");
    private final SelenideElement month = input.findBy(Condition.text("Месяц"))
            .$("input.input__control");
    private final SelenideElement year = input.findBy(Condition.text("Год"))
            .$("input.input__control");
    private final SelenideElement name = input.findBy(Condition.text("Владелец"))
            .$("input.input__control");
    private final SelenideElement cvv = input.findBy(Condition.text("CVC/CVV"))
            .$("input.input__control");

    public BuyPage(){
        payByCard.shouldBe(Condition.visible);
    }
}
