package org.example.seleniumTests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestWeb extends FormatWebTest {

    @Test
    public void connectionToSiteTest() {
        String title = webDriver.getTitle();
        assert (title.contains("Swag Labs"));
    }

    @Test
    public void authorizationTest() {
        WebElement usernameInput = webDriver.findElement(By.id("user-name"));
        WebElement passwordInput = webDriver.findElement(By.id("password"));
        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();
        WebElement productsTitle = webDriver.findElement(By.className("title"));
        assertEquals("Products", productsTitle.getText(), "Expected title 'Products'");
    }
}