package org.example;

import io.qameta.allure.Allure;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class AllureTestWatcher implements TestWatcher {

    @Override
    public void testSuccessful(ExtensionContext context) {
        Allure.step("Тест прошел успешно: " + context.getDisplayName());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        Allure.step("Тест не прошел: " + context.getDisplayName() + " Причина: " + cause.getMessage());
    }

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        Allure.step("Тест пропущен: " + context.getDisplayName() + " Причина: " + reason.orElse("Нет причины"));
    }
}
