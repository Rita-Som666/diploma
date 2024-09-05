package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Value;
import ru.netology.data.CardData;
import ru.netology.data.CardGenerator;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class CreditPage {
    private final SelenideElement payByCredit = $(byText("Кредит по данным карты"));
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
    private final CardData validUser = CardGenerator.validData();
    private final ElementsCollection buttons = $$(".button");
    private final SelenideElement send = buttons.findBy(Condition.text("Продолжить"));
    private final SelenideElement successSend = $(byText("Операция одобрена Банком."));


    public CreditPage(){
        payByCredit.shouldBe(Condition.visible);
    }

    public void successBuy (){
        cardNumber.sendKeys(validUser.getCardNumber());
        month.sendKeys(validUser.getMonth());
        year.sendKeys(validUser.getYear());
        name.sendKeys(validUser.getName());
        cvv.sendKeys(validUser.getCvv());
        send.click();
        successSend.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }
}
