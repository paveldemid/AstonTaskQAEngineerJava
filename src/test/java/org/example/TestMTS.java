package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

@ExtendWith(AllureTestWatcher.class)
public class TestMTS {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));

        driver.get("https://www.mts.by/");

        // Попытка закрыть куки
        closeCookies();
    }

    @Feature("Проверка заголовка")
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверка наличие заголовка на главной странице")
    public void testFindHeader() {
        Allure.step("Начало теста: Проверка заголовка \"Онлайн пополнение без комиссии\"");
        try {
            MtsPage mtsPage = new MtsPage(driver);
            Locators address = new Locators();
            Locators data = new Locators();

            System.out.println("Проверка заголовка: Онлайн пополнение без комиссии");
            Assert.assertTrue("Текст заголовка не найден " + mtsPage.getText(address.getAddressHeading()),
                    mtsPage.getText(address.getAddressHeading()).contains(data.getTextHeading()));
            System.out.println("Успешно. Заголовок найден: " + mtsPage.getText(address.getAddressHeading()));

            Allure.step("Тест пройден");
        } catch (TimeoutException e) {
            Assertions.fail("Таймаут ожилание элемента: " + e.getMessage());
            Allure.step("Ошибка: Таймаут ожилание элемента" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Тест не прошел из-за исключения: " + e.getMessage());
            Allure.step("Ошибка: Тест не прошел из-за исключения:" + e.getMessage());
        }
    }


    @Feature("Проверка логотипов")
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка иконок платёжных систем")
    public void testPaymentLogos() {
        Allure.step("Начало работы теста: Проверка иконок платёжных систем");
        try {
            MtsPage mtsPage = new MtsPage(driver);
            Locators address = new Locators();
            Locators data = new Locators();

            //Проверка иконок платёжных систем.
            List<WebElement> logos = mtsPage.getPaymentLogos(address.getAddressLogosPayOnline());

            // Проверка количества логотипов
            Assert.assertEquals("Количество логотипов не совпало с ожидаемым", data.expectedLogosPayOnline.size(), logos.size());

            // Проверяем наличие каждого ожидаемого логотипа
            for (String expectedLogo : data.expectedLogosPayOnline) {
                boolean found = logos.stream().anyMatch(logoElement -> logoElement.getAttribute("src").endsWith(expectedLogo));
                Assert.assertTrue("Логотип " + expectedLogo + " не найден!", found);
            }
            System.out.println("Тест пройден. Все изображения найдены.");
            Allure.step("Тест пройден");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Тест не прошел из-за исключения: " + e.getMessage());
            Allure.step("Ошибка: Тест не прошел из-за исключения" + e.getMessage());
        }
    }

    @Feature("Проверка работы ссылки")
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка работы ссылки: Подробнее о сервисе ")
    public void testLink() {
        Allure.step("Начало работы теста: Проверка работы ссылки \"Подробнее о сервисе\"");
        try {
            MtsPage mtsPage = new MtsPage(driver);
            Locators address = new Locators();
            Locators data = new Locators();

            System.out.println("Проверка работы ссылки «Подробнее о сервисе» ");

            // Проверка наличия ссылки и клик по ней
            Assert.assertTrue("Ссылка 'Подробнее о сервисе' не найдена!", mtsPage.isMoreInfoLinkPresent(address.getLink()));
            mtsPage.clickMoreInfoLink(address.getLink());

            // Ожидание изменения URL и его проверка
            wait.until(ExpectedConditions.urlContains(address.getTextLink()));
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue("URL не содержит 'poryadok-oplaty-i-bezopasnost-internet-platezhey'", currentUrl.contains(address.getTextLink()));
            System.out.println("Тест пройден: Перешли по ссылке 'Подробнее о сервисе'. Текущий URL: " + currentUrl);

            //Возврат на главную страницу.
            driver.navigate().back();

            Allure.step("Тест пройден");
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Тест не прошел из-за исключения: " + e.getMessage());
            Allure.step("Ошибка: Тест не прошел из-за исключения " + e.getMessage());
        }
    }

    @Feature("Проверка placeholder для блока онлайн платежей")
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка надписей в незаполненных полях")
    public void checkPlaceholder() {
        Allure.step("Начало работы теста: Проверка надписей в незаполненных полях");
        try {
            MtsPage mtsPage = new MtsPage(driver);
            Locators address = new Locators();
            Locators placeholder = new Locators();

            System.out.println("Проверка надписей в незаполненных полях");

            /* ----------------------------Услуги связи-------------------------------------------------*/
            mtsPage.clickSelector(address.getAddressSelector(), address.getAddressCommunicationServices());

            // Поля для ввода номера телефона.
            Assert.assertTrue("Текст подсказки не содержит ожидаемого значения: " + placeholder.getPlaceholderConnectionPhone(),
                    mtsPage.getPlaceholder(address.getAddressFieldConnectionPhone()).contains(placeholder.getPlaceholderConnectionPhone()));

            //Поля для ввода суммы платежа.
            Assert.assertTrue("Текст подсказки не содержит ожидаемого значения: " + placeholder.getPlaceholderConnectionSum(),
                    mtsPage.getPlaceholder(address.getAddressFieldConnectionSum()).contains(placeholder.getPlaceholderConnectionSum()));

            //Поля для ввода email.
            Assert.assertTrue("Текст подсказки не содержит ожидаемого значения: " + placeholder.getPlaceholderConnectionEmail(),
                    mtsPage.getPlaceholder(address.getAddressFieldConnectionEmail()).contains(placeholder.getPlaceholderConnectionEmail()));

            /*--------------------Домашний интернет--------------------------------*/
            mtsPage.clickSelector(address.getAddressSelector(), address.getAddressHomeInternet());

            // Поля для ввода номера телефона.
            Assert.assertTrue("Текст подсказки не содержит ожидаемого значения: " + placeholder.getPlaceholderInternetPhone(),
                    mtsPage.getPlaceholder(address.getAddressFieldInternetPhone()).contains(placeholder.getPlaceholderInternetPhone()));

            //Поля для ввода суммы платежа.
            Assert.assertTrue("Текст подсказки не содержит ожидаемого значения: " + placeholder.getPlaceholderInternetSum(),
                    mtsPage.getPlaceholder(address.getAddressFieldInternetSum()).contains(placeholder.getPlaceholderInternetSum()));

            //Поля для ввода email.
            Assert.assertTrue("Текст подсказки не содержит ожидаемого значения: " + placeholder.getPlaceholderInternetEmail(),
                    mtsPage.getPlaceholder(address.getAddressFieldInternetEmail()).contains(placeholder.getPlaceholderInternetEmail()));

            /*--------------------Рассрочка--------------------------------*/
            mtsPage.clickSelector(address.getAddressSelector(), address.getAddressInstallment());

            // Поля для ввода номера счета.
            Assert.assertTrue("Текст подсказки не содержит ожидаемого значения: " + placeholder.getPlaceholderInstallmentScore(),
                    mtsPage.getPlaceholder(address.getAddressFieldInstallmentScore()).contains(placeholder.getPlaceholderInstallmentScore()));

            //Поля для ввода суммы.
            Assert.assertTrue("Текст подсказки не содержит ожидаемого значения." + placeholder.getPlaceholderInstallmentSum(),
                    mtsPage.getPlaceholder(address.getAddressFieldInstallmentSum()).contains(placeholder.getPlaceholderInstallmentSum()));

            //Поля для ввода email.
            Assert.assertTrue("Текст подсказки не содержит ожидаемого значения: " + placeholder.getPlaceholderInstallmentEmail(),
                    mtsPage.getPlaceholder(address.getAddressFieldInstallmentEmail()).contains(placeholder.getPlaceholderInstallmentEmail()));


            /*--------------------Задолженность--------------------------------*/
            mtsPage.clickSelector(address.getAddressSelector(), address.getAddressArrears());

            // Поля для ввода номера счета.
            Assert.assertTrue("Текст подсказки не содержит ожидаемого значения: " + placeholder.getPlaceholderArrearsScore(),
                    mtsPage.getPlaceholder(address.getAddressFieldArrearsScore()).contains(placeholder.getPlaceholderArrearsScore()));

            //Поля для ввода суммы.
            Assert.assertTrue("Текст подсказки не содержит ожидаемого значения: " + placeholder.getPlaceholderArrearsSum(),
                    mtsPage.getPlaceholder(address.getAddressFieldArrearsSum()).contains(placeholder.getPlaceholderArrearsSum()));

            //Поля для ввода email.
            Assert.assertTrue("Текст подсказки не содержит ожидаемого значения: " + placeholder.getPlaceholderArrearsEmail(),
                    mtsPage.getPlaceholder(address.getAddressFieldArrearsEmail()).contains(placeholder.getPlaceholderArrearsEmail()));

            Allure.step("Тест пройден");

        } catch (TimeoutException e) {
            Assert.fail("Таймаут ожилание элемента: " + e.getMessage());
            Allure.step("Ошибка:Таймаут ожилание элемента" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Тест не прошел из-за исключения: " + e.getMessage());
            Allure.step("Ошибка: Тест не прошел из-за исключения" + e.getMessage());
        }
    }

    @Feature("Тест варианта \"Услуги связи\"")
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Проверка варианта \"Услуги связи\"")
    public void communicationServices() {
        Allure.step("Начало работы теста: Проверка варианта \"Услуги связи\"");
        try {
            MtsPage mtsPage = new MtsPage(driver);
            Locators placeholder = new Locators();
            Locators address = new Locators();
            Locators data = new Locators();
            RandomSum random = new RandomSum();

            // Выбор пункта "Услуги связи"
            mtsPage.clickSelector(address.getAddressSelector(), address.getAddressCommunicationServices());

            //Поиск и ввод данных в поле для номера телефона.
            mtsPage.searchElementAndDataInput(address.getAddressFieldConnectionPhone(), data.getNumberPhone());

            //Поиск и ввод двнных в поле для суммы платежа.
            //Генерация случайного значения суммы платежа.
            String sum = random.randomSum();
            mtsPage.searchElementAndDataInput(address.getAddressFieldConnectionSum(), sum);

            //Поиск и ввод данных в поле для email.
            mtsPage.searchElementAndDataInput(address.getAddressFieldConnectionEmail(), data.getAddressEmail());

            // Поиск и нажатие на кнопку "Продолжить"
            mtsPage.clickButton(address.getButtonNext());

            //Ожидание и переключение на iframe
            mtsPage.shiftFraim(address.getWrapperContentFraim());

            //Проверка отображения суммы
            System.out.println("Проверка отображения суммы в заголовке");
            Assert.assertTrue("Номер сумма в заголовке " + mtsPage.getText(address.getAddressSumHeading()) + " не совпадает c введенной суммой " + random.getRamdomSum(),
                    mtsPage.getText(address.getAddressSumHeading()).contains(random.getRamdomSum()));
            System.out.println("Успешно" + " Сумма платежа: " + mtsPage.getText(address.getAddressSumHeading()) + " совпадает c суммой платежа в заголовке: " + random.getRamdomSum());

            System.out.println("Проверка отображения суммы в поле кнопки \"Оплатить\" ");
            Assert.assertTrue("Номер сумма в заголовке " + mtsPage.getText(address.getAddressSumButtonPay()) + " не совпадает c введенной суммой " + random.getRamdomSum(),
                    mtsPage.getText(address.getAddressSumButtonPay()).contains(random.getRamdomSum()));
            System.out.println("Успешно" + " Сумма платежа: " + mtsPage.getText(address.getAddressSumButtonPay()) + " совпадает c суммой платежа в поле кнопки \"Оплатить\": " + random.getRamdomSum());

            //Проверка номера телефона.
            Assert.assertTrue("Номер телефон не совпадает",
                    mtsPage.getNumberPhone(address.getAddressNumberPhoneText()).contains(placeholder.getNumberPhone()));
            System.out.println("Успешно" + " Номер телефона: " + mtsPage.getNumberPhone(address.getAddressNumberPhoneText()) + " совпадает c введенным: " + placeholder.getNumberPhone());

            //Проверка placeholder в полях для ввода данных номера карты
            Assert.assertTrue("Текст подсказки не содержит ожидаемого значения: " + placeholder.getPlaceholderNumberCart(),
                    mtsPage.getText(address.getAddressFieldNumberCart()).contains(placeholder.getPlaceholderNumberCart()));

            //Проверка placeholder в полях для ввода срока действия банковской карты
            Assert.assertTrue("Текст подсказки не содержит ожидаемого значения: " + placeholder.getPlaceholderValidityPeriod(),
                    mtsPage.getText(address.getAddressFieldValidityPeriod()).contains(placeholder.getPlaceholderValidityPeriod()));

            //Проверка placeholder в полях для ввода CVC банковской карты
            Assert.assertTrue("Текст подсказки не содержит ожидаемого значения: " + placeholder.getPlaceholderCVC(),
                    mtsPage.getText(address.getAddressFieldCVC()).contains(placeholder.getPlaceholderCVC()));

            //Проверка placeholder в полях для ввода имя держателя
            Assert.assertTrue("Текст подсказки не содержит ожидаемого значения: " + placeholder.getPlaceholderUsername(),
                    mtsPage.getText(address.getAddressFieldUsername()).contains(placeholder.getPlaceholderUsername()));

            //Проверка иконок платёжных систем.
            List<WebElement> logos = mtsPage.getPaymentLogos(address.getAddressCardsBrands());

            // Проверка количества логотипов
            Assert.assertEquals("Количество логотипов не совпало с ожидаемым ", data.expectedLogosBankСard.size(), logos.size());

            // Проверяем наличие каждого ожидаемого логотипа
            for (String expectedLogo : data.expectedLogosBankСard) {
                boolean found = logos.stream().anyMatch(logoElement -> logoElement.getAttribute("src").endsWith(expectedLogo));
                Assert.assertTrue("Логотип " + expectedLogo + " не найден!", found);
            }
            System.out.println("Тест пройден. Все изображения найдены.");

            Allure.step("Тест пройден");
        } catch (TimeoutException e) {
            Assert.fail("Таймаут ожилание элемента: " + e.getMessage());
            Allure.step("Ошибка: Таймаут ожилание элемента" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Тест не прошел из-за исключения: " + e.getMessage());
            Allure.step("Ощибка: Тест не прошел из-за исключения" + e.getMessage());
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    //Метод для поиска и закрытия куки.
    private void closeCookies() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement cookieCloseButton = driver.findElement(By.xpath("//button[contains(text(), 'Принять')]"));
            if (cookieCloseButton.isDisplayed()) {
                cookieCloseButton.click();
                System.out.println("Куки закрыты успешно.");
            }
        } catch (TimeoutException e) {
            System.out.println("Не удалось закрыть куки: время ожидания истекло.");
        }
    }
}
