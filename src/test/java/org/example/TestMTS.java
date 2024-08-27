package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TestMTS {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    //Проверка заголовка.
    @Test
    public void testFindHeader() {
        try {
            driver.get("https://www.mts.by/");
            System.out.println("Ожидание заголовка...");

            // Попытка закрыть куки
            closeCookies();

            //Поиск заголовка
            WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pay-section\"]/div/div/div[2]/section/div/h2")));
            Assert.assertNotNull("Заголовок не найден!", header);
            System.out.println("Заголовок найден: " + header.getText());

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Тест не прошел из-за исключения: " + e.getMessage());
        }
    }

    //Проверка логотипов
    @Test
    public void testPaymentLogos() {
        try {
            driver.get("https://www.mts.by/");

            // Попытка закрыть куки
            closeCookies();

            // Ожидаемый список логотипов платёжных систем
            List<String> expectedLogos = Arrays.asList(
                    "/local/templates/new_design/assets/html/images/pages/index/pay/visa.svg",
                    "/local/templates/new_design/assets/html/images/pages/index/pay/visa-verified.svg",
                    "/local/templates/new_design/assets/html/images/pages/index/pay/mastercard.svg",
                    "/local/templates/new_design/assets/html/images/pages/index/pay/mastercard-secure.svg",
                    "/local/templates/new_design/assets/html/images/pages/index/pay/belkart.svg"
            );

            // Поиск блока "Онлайн пополнение без комиссии"
            WebElement paymentBlock = driver.findElement(By.className("pay"));

            // Получение всех изображения в этом блоке
            List<WebElement> logos = paymentBlock.findElements(By.tagName("img"));

            // Проверяем наличие каждого ожидаемого логотипа
            for (String expectedLogo : expectedLogos) {
                boolean found = logos.stream().anyMatch(logoElement -> logoElement.getAttribute("src").endsWith(expectedLogo));
                Assert.assertTrue("Логотип " + expectedLogo + " не найден!", found);
            }

            System.out.println("Тест пройден. Все изображения найдены.");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Тест не прошел из-за исключения: " + e.getMessage());
        }
    }

    //Проверка работы ссылки.
    @Test
    public void testLink() {
        try {
            driver.get("https://www.mts.by/");
            System.out.println("Проверка работы ссылки «Подробнее о сервисе» ");

            // Попытка закрыть куки
            closeCookies();

            WebElement moreInfoLink = driver.findElement(By.xpath("//a[contains(text(), 'Подробнее о сервисе')]"));

            // Поиск ссылки
            Assert.assertNotNull("Ссылка 'Подробнее о сервисе' не найдена!", moreInfoLink);
            moreInfoLink.click();

            wait.until(ExpectedConditions.urlContains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue("URL не содержит 'poryadok-oplaty-i-bezopasnost-internet-platezhey'", currentUrl.contains("poryadok-oplaty-i-bezopasnost-internet-platezhey"));
            System.out.println("Тест пройден: Перешли по ссылке 'Подробнее о сервисе'. Текущий URL: " + currentUrl);

            //Возврат на главную страницу.
            driver.navigate().back();

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Тест не прошел из-за исключения: " + e.getMessage());
        }
    }


    //Проверка кнопки «Продолжить»
    @Test
    public void testPayData() {
        try {
            driver.get("https://www.mts.by/");
            System.out.println("Заполнение полей и проверка работы кнопки «Продолжить»");

            // Попытка закрыть куки
            closeCookies();

            // Заполнение номера телефона
            WebElement phoneNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-phone")));
            phoneNumber.sendKeys("297777777");
            System.out.println("Номер телефона заполнен");

            // Заполнение суммы
            WebElement sumField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-sum")));
            Random random = new Random();
            int number = random.nextInt(100) + 1; // Избегаем нуля, чтобы сумма была от 1 до 100
            sumField.sendKeys(String.valueOf(number));
            System.out.println("Сумма заполнена: " + number);

            // Заполнение адреса электронной почты
            WebElement emailAddress = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("connection-email")));
            emailAddress.sendKeys("ivan.ivanov@gmail.com");
            System.out.println("Адрес электронной почты заполнен");

            // Нахождение и нажатие на кнопку "Продолжить"
            WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("button__default")));
            continueButton.click();
            System.out.println("Кнопка «Продолжить» нажата");

            // Ожидание и переключение на iframe
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe"))); // Используем класс iframe

            // Ожидание появления элемента внутри iframe
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("app-wrapper__content")));
            Assert.assertTrue("Элемент не виден", element.isDisplayed());
            System.out.println("Выполнен успешный ввод данных в поле «Онлайн пополнение без комиссии»");

            // Возврат к основному контенту
            driver.switchTo().defaultContent();

        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Элемент не найден: " + e.getMessage());
        } catch (TimeoutException e) {
            e.printStackTrace();
            Assert.fail("Таймаут ожидания элемента: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Тест не прошел из-за исключения: " + e.getMessage());
        }
    }


    @After
    public void tearDown() {
        // Закрытие драйвера
        if (driver != null) {
            driver.quit();
        }
    }

    //Метод для закрытия куки
    private void closeCookies() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement cookieCloseButton = driver.findElement(By.xpath("//button[contains(text(), 'Принять')]"));
            if (cookieCloseButton.isDisplayed()) {
                cookieCloseButton.click();
                System.out.println("Куки закрыты успешно.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Не удалось закрыть куки: элемент не найден.");
        } catch (TimeoutException e) {
            System.out.println("Не удалось закрыть куки: время ожидания истекло.");
        }
    }
}
