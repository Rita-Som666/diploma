package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Value;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

@Value
public class CreditPage {
    private SelenideElement payByCredit = $(byText("Кредит по данным карты"));

    public CreditPage(){
        payByCredit.shouldBe(Condition.visible);
    }
}
