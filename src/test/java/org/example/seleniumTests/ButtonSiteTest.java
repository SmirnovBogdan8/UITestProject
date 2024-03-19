package org.example.seleniumTests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ButtonSiteTest extends FormatWebTest {
    @Test
    public void buttonClick() {
        WebElement usernameInput = webDriver.findElement(By.id("user-name"));
        WebElement passwordInput = webDriver.findElement(By.id("password"));
        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        usernameInput.sendKeys("standard_user");
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();
        //переход на другую страницу
        int initialAddToCartCount = 0;
        java.util.List<WebElement> buttons = webDriver.findElements(By.tagName("button"));
        for (WebElement button : buttons) {
            String originalText = button.getText();
            if ("Add to cart".equals(originalText)) {
                button.click();
                initialAddToCartCount++;
            }
        }
        buttons = webDriver.findElements(By.tagName("button"));
        int finalRemoveCount = 0;
        for (WebElement button : buttons) {
            String buttonText = button.getText();
            if ("Remove".equals(buttonText)) {
                button.click();
                finalRemoveCount++;
            }
        }
        assertEquals(initialAddToCartCount, finalRemoveCount, "Button click count mismatch");
        assert initialAddToCartCount == finalRemoveCount : "Test Failed";
    }
}