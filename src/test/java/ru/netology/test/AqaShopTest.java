package ru.netology.test;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.page.BuyPage;
import ru.netology.page.CreditPage;
import ru.netology.page.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class AqaShopTest {


    @BeforeAll
    static void setUpAll(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("http://localhost:8080/");



    }

    @BeforeEach
    void setUp(){
        Selenide.refresh();
    }

    @AfterAll
    static void tearDownAll(){
        SelenideLogger.removeListener("allure");
    }

    @Test

    public void successBuyCredit(){


        var mainPage = new MainPage();
        mainPage.payByCredit();
        var credit = new CreditPage();
        credit.successBuy();

    }

    @Test
    void sendWithInvalidStatus(){

        var mainPage = new MainPage();
        mainPage.payByCredit();
        var credit = new CreditPage();
        credit.blockStatus();
    }

    @Test
    void sendWithExpired1(){

        var mainPage = new MainPage();
        mainPage.payByCredit();
        var credit = new CreditPage();
        credit.expired1();
    }

    @Test
    void sendWithExpired2(){

        var mainPage = new MainPage();
        mainPage.payByCredit();
        var credit = new CreditPage();
        credit.expired2();
    }

    @Test
    void sendWithTooFarYear(){

        var mainPage = new MainPage();
        mainPage.payByCredit();
        var credit = new CreditPage();
        credit.notTrueYear();
    }

    @Test
    void sendWithJustFirstName(){

        var mainPage = new MainPage();
        mainPage.payByCredit();
        var credit = new CreditPage();
        credit.justFirstName();
    }
    @Test
    void sendWithCyrillicName(){
        var mainPage = new MainPage();
        mainPage.payByCredit();
        var credit = new CreditPage();
        credit.nameOnCyrillic();
    }

    @Test
    void sendWithNameWithDigit() {
        var mainPage = new MainPage();
        mainPage.payByCredit();
        var credit = new CreditPage();
        credit.nameWithDigit();
    }

    @Test
    void sendWithNameWithSymbol() {
        var mainPage = new MainPage();
        mainPage.payByCredit();
        var credit = new CreditPage();
        credit.nameWithSymbol();
    }

    @Test
    void sendWithIncorrectCvv(){

            var mainPage = new MainPage();
            mainPage.payByCredit();
            var credit = new CreditPage();
            credit.invalidCvv();
    }
}
