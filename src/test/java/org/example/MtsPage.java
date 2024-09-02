package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.List;
import java.util.Random;

public class MtsPage {

    //После работы метода randomSum в переменной будет храниться сгенирированная сумма платежа.
    private String ramdomSum = "";
    private WebDriver driver;
    private WebDriverWait wait;

    public MtsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }


    //Метод для открытие селектора и поиска необходимых элементов.
    public void clickSelector(String addressSelector, String addressElementSelector) {
        //Открытие выпадающего списка.
        WebElement selector = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(addressSelector)));
        selector.click();
        //Выбор необходимого пункта.
        WebElement elementSelector = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(addressElementSelector)));
        elementSelector.click();
    }

    //Метод для определения placeholder
    public String getPlaceholder(String address) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(address)));
        return element.getAttribute("placeholder");
    }


    //Метод для получения теста
    public String getText(String address) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(address)));
        // Получаем текст и заменяем переносы строк на пробелы
        return element.getText().replaceAll("\\n", " ").trim();
    }


    //Метод для поиска и ввода данных в элемент вебстраницы.
    public void searchElementAndDataInput(String address, String data) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(address)));
        element.sendKeys(data);
    }

    //Метод для генерации случайнного значения суммы.
    public String randomSum() {
        Random random = new Random();
        double number = random.nextInt(10000) + 1;
        number /= 100;

        // Форматирование числа до двух знаков после запятой с запятой как разделителем
        DecimalFormat decimalFormat = new DecimalFormat("#0.00");

        String formattedNumber = decimalFormat.format(number);
        this.ramdomSum = formattedNumber;
        return this.ramdomSum;
    }

    // Метод для поиска и нажатия на кнопки.
    public void clickButton(String address) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(address)));
        element.click();
    }


    //Метод для переключения на Fraim
    public void shiftFraim(String address) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));
    }

    // Метод для получения логотипов платёжных систем
    public List<WebElement> getPaymentLogos(String address) {
        WebElement paymentBlock = driver.findElement(By.className(address));
        return paymentBlock.findElements(By.tagName("img"));
    }

    //Метод для получения номера телефона.
    public String getNumberPhone(String address) {
        WebElement phoneElement = driver.findElement(By.cssSelector(address));
        String text = phoneElement.getText();
        // Извлечение  номерf телефона, убирая код 375
        String phoneNumber = text.replaceAll(".*Номер:\\s*(375)?", "").trim();
        return phoneNumber;
    }


    //Метод для поиска ссылки
    public boolean isMoreInfoLinkPresent(String address) {
        try {
            return driver.findElement(By.xpath(address)).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    //Метод для перехода по ссылке.
    public void clickMoreInfoLink(String address) {
        WebElement moreInfoLink = driver.findElement(By.xpath(address));
        moreInfoLink.click();
    }

    public String getRamdomSum() {
        return new BigDecimal(ramdomSum.replace(",", ".")).toString();
    }
}
