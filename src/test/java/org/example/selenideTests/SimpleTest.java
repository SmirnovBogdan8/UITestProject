package org.example.selenideTests;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;

public class SimpleTest {

    @BeforeAll
    public static void setup() {
        // Настройка Selenide для использования WebDriverManager
        Configuration.browser = "chrome";
        Configuration.webdriverLogsEnabled = true;
    }

    @Test
    public void userCanSearch() {
        // Открытие страницы Google
        open("https://www.google.com");
    }
}

