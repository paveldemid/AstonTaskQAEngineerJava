package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MtsPage {

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

    // Метод для поиска и нажатия на кнопки.
    public void clickButton(String address) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(address)));
        element.click();
    }

    //Метод для переключения на Fraim
    public void shiftFraim(String address) {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className(address)));
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

    //Метод для перехода по ссылке
    public void clickMoreInfoLink(String address) {
        WebElement moreInfoLink = driver.findElement(By.xpath(address));
        moreInfoLink.click();
    }
}
