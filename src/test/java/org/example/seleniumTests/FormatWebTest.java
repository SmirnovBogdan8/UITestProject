package org.example.seleniumTests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class FormatWebTest {
    protected static WebDriver webDriver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver-win64\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("https://www.saucedemo.com/");
    }

    @AfterEach
    public void logOutTest() {
        webDriver.close();
    }
}