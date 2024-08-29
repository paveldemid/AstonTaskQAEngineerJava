package org.example;

import java.util.Arrays;
import java.util.List;

public class Locators {

    // Номер телефона для проверки пункта "Услуги связи"
    private String numberPhone = "297777777";
    private String addressEmail = "pavel.demidovich2013@gmail.com";

    //Локатор кнопки  "Продолжить"
    private String buttonNext = "button__default";

    //Локатор Fraim
    private String wrapperContentFraim = "bepaid-iframe";

    //Локатор для селлектора
    private String addresSelector = "select__header";

    //Локатор для теста заголовка "Онлайн пополнение"
    private String addressHeading = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2";


    //Текст заголовка
    private String textHeading = "Онлайн пополнение без комиссии";


    //Ссылка "Подробнее о сервисе"
    private String link = "//a[contains(text(), 'Подробнее о сервисе')]";

    //Текс ссылки  "Подробнее о сервисе"
    private String textLink = "poryadok-oplaty-i-bezopasnost-internet-platezhey";

    /* ----------------------------Услуги связи-------------------------------------------------*/
    private String addressCommunicationServices = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p";
    private String addressFieldConnectionPhone = "connection-phone";
    private String placeholderdConnectionPhone = "Номер телефона";

    private String addressFieldConnectionSum = "connection-sum";
    private String placeholderConnectionSum = "Сумма";

    private String addressFieldConnectionEmail = "connection-email";
    private String placeholderConnectionEmail = "E-mail для отправки чека";

    /*--------------------Домашний интернет--------------------------------*/

    private String addressHomeInternet = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]/p";
    private String addressFieldInternetPhone = "internet-phone";
    private String placeholderInternetPhone = "Номер абонента";
    private String addressFieldInternetSum = "internet-sum";
    private String placeholderInternetSum = "Сумма";
    private String addressFieldInternetEmail = "internet-email";
    private String placeholderInternetEmail = "E-mail для отправки чека";

    /*--------------------Рассрочка--------------------------------*/
    private String addressInstallment = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[3]/p";
    private String addressFieldInstallmentScore = "score-instalment";
    private String placeholderInstallmentScore = "Номер счета на 44";
    private String addressFieldInstallmentSum = "instalment-sum";
    private String placeholderInstallmentSum = "Сумма";

    private String addressFieldInstallmentEmail = "instalment-email";
    private String placeholderInstallmentEmail = "E-mail для отправки чека";

    /*--------------------Задолженность--------------------------------*/
    private String addressArrears = "//*[@id=\"pay-section\"]/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[4]/p";
    private String addressFieldArrearsScore = "score-arrears";
    private String placeholderArrearsScore = "Номер счета на 2073";

    private String addressFieldArrearsSum = "arrears-sum";
    private String placeholderArrearsSum = "Сумма";

    private String addressFieldArrearsEmail = "arrears-email";
    private String placeholderArrearsEmail = "E-mail для отправки чека";


    /*--------------------Банковская карта--------------------------------*/
    private String addressFieldNumberCart = "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]/label";
    private String placeholderNumberCart = "Номер карты";

    private String addressFieldValidityPeriod = "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/label";
    private String placeholderValidityPeriod = "Срок действия";

    private String addressFieldCVC = "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]/label";
    private String placeholderCVC = "CVC";

    private String addressFieldUsername = "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/label";
    private String placeholderUsername = "Имя держателя (как на карте)";


    // Ожидаемый список логотипов платёжных систем в блоке "Оплата онлайн"
    List<String> expectedLogosPayOnline = Arrays.asList(
            "/local/templates/new_design/assets/html/images/pages/index/pay/visa.svg",
            "/local/templates/new_design/assets/html/images/pages/index/pay/visa-verified.svg",
            "/local/templates/new_design/assets/html/images/pages/index/pay/mastercard.svg",
            "/local/templates/new_design/assets/html/images/pages/index/pay/mastercard-secure.svg",
            "/local/templates/new_design/assets/html/images/pages/index/pay/belkart.svg"
    );

    //Локатор для класса логотипов
    private String addressLogosPayOnline = "pay";


    // Ожидаемый список логотипов платёжных систем в блоке для ввода данных банковской карты.
    List<String> expectedLogosBankСard = Arrays.asList(
            "assets/images/payment-icons/card-types/visa-system.svg",
            "assets/images/payment-icons/card-types/mastercard-system.svg",
            "assets/images/payment-icons/card-types/belkart-system.svg",
            "assets/images/payment-icons/card-types/maestro-system.svg",
            "assets/images/payment-icons/card-types/mir-system-ru.svg"
    );


    //Локатор для класса логотипов
    private String addressCardsBrands = "cards-brands__container";

    //Локатор для номера телефона в блоке для ввода данных банковских карт.
    private String addressNumberPhoneText = "body > app-root > div > div > div > app-payment-container > section > div > div > div.pay-description__text > span";

    //Локатор для отображения суммы в заголовке
    private String addressSumHeading = "/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]/span[1]";

    //Локатор для отображения суммы в поле кнопки "Оплатить"
    private String addressSumButtonPay = "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button";

    /* ----------------------------Геттеры-------------------------------------------------*/

    public String getNumberPhone() {
        return numberPhone;
    }

    public String getButtonNext() {
        return buttonNext;
    }

    public String getWrapperContentFraim() {
        return wrapperContentFraim;
    }

    public String getAddressEmail() {
        return addressEmail;
    }

    /* ----------------------------Селектор-------------------------------------------------*/
    public String getAddressSelector() {
        return addresSelector;
    }


    /* ----------------------------Услуги связи-------------------------------------------------*/
    public String getAddressCommunicationServices() {
        return addressCommunicationServices;
    }

    public String getAddressFieldConnectionPhone() {
        return addressFieldConnectionPhone;
    }

    public String getPlaceholderConnectionPhone() {
        return placeholderdConnectionPhone;
    }

    public String getAddressFieldConnectionSum() {
        return addressFieldConnectionSum;
    }

    public String getPlaceholderConnectionSum() {
        return placeholderConnectionSum;
    }

    public String getAddressFieldConnectionEmail() {
        return addressFieldConnectionEmail;
    }

    public String getPlaceholderConnectionEmail() {
        return placeholderConnectionEmail;
    }

    /*--------------------Домашний интернет--------------------------------*/
    public String getAddressHomeInternet() {
        return addressHomeInternet;
    }

    public String getAddressFieldInternetPhone() {
        return addressFieldInternetPhone;
    }

    public String getPlaceholderInternetPhone() {
        return placeholderInternetPhone;
    }

    public String getAddressFieldInternetSum() {
        return addressFieldInternetSum;
    }

    public String getPlaceholderInternetSum() {
        return placeholderInternetSum;
    }

    public String getAddressFieldInternetEmail() {
        return addressFieldInternetEmail;
    }

    public String getPlaceholderInternetEmail() {
        return placeholderInternetEmail;
    }

    /*--------------------Рассрочка--------------------------------*/
    public String getAddressInstallment() {
        return addressInstallment;
    }

    public String getAddressFieldInstallmentScore() {
        return addressFieldInstallmentScore;
    }

    public String getPlaceholderInstallmentScore() {
        return placeholderInstallmentScore;
    }

    public String getAddressFieldInstallmentSum() {
        return addressFieldInstallmentSum;
    }

    public String getPlaceholderInstallmentSum() {
        return placeholderInstallmentSum;
    }

    public String getAddressFieldInstallmentEmail() {
        return addressFieldInstallmentEmail;
    }

    public String getPlaceholderInstallmentEmail() {
        return placeholderInstallmentEmail;
    }

    /*--------------------Задолженность--------------------------------*/
    public String getAddressArrears() {
        return addressArrears;
    }

    public String getAddressFieldArrearsScore() {
        return addressFieldArrearsScore;
    }

    public String getPlaceholderArrearsScore() {
        return placeholderArrearsScore;
    }

    public String getAddressFieldArrearsSum() {
        return addressFieldArrearsSum;
    }

    public String getPlaceholderArrearsSum() {
        return placeholderArrearsSum;
    }

    public String getAddressFieldArrearsEmail() {
        return addressFieldArrearsEmail;
    }

    public String getPlaceholderArrearsEmail() {
        return placeholderArrearsEmail;
    }

    /*--------------------Банковская карта--------------------------------*/

    public String getAddressFieldNumberCart() {
        return addressFieldNumberCart;
    }

    public String getPlaceholderNumberCart() {
        return placeholderNumberCart;
    }

    public String getAddressFieldValidityPeriod() {
        return addressFieldValidityPeriod;
    }

    public String getPlaceholderValidityPeriod() {
        return placeholderValidityPeriod;
    }

    public String getAddressFieldCVC() {
        return addressFieldCVC;
    }

    public String getPlaceholderCVC() {
        return placeholderCVC;
    }

    public String getAddressFieldUsername() {
        return addressFieldUsername;
    }

    public String getPlaceholderUsername() {
        return placeholderUsername;
    }

    public String getAddressCardsBrands() {
        return addressCardsBrands;
    }

    public String getAddressNumberPhoneText() {
        return addressNumberPhoneText;
    }

    public String getAddressSumHeading() {
        return addressSumHeading;
    }

    public String getAddressSumButtonPay() {
        return addressSumButtonPay;
    }

    public String getAddressHeading() {
        return addressHeading;
    }

    public String getTextHeading() {
        return textHeading;
    }

    public String getLink() {
        return link;
    }

    public String getTextLink() {
        return textLink;
    }

    public String getAddressLogosPayOnline() {
        return addressLogosPayOnline;
    }
}
