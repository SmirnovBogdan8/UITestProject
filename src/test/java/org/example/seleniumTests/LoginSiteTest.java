package org.example.seleniumTests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSiteTest extends FormatWebTest {
    private List<String> loginList = new ArrayList<>();

    LoginSiteTest() {
        loginList.add("standard_user");
        loginList.add("locked_out_user");
        loginList.add("problem_user");
        loginList.add("performance_glitch_user");
        loginList.add("error_user");
        loginList.add("visual_user");
    }

    @Test
    public void loginTest() throws InterruptedException {
        for (String username : loginList) {
            webDriver.navigate().refresh();
            WebElement usernameInput = webDriver.findElement(By.id("user-name"));
            WebElement passwordInput = webDriver.findElement(By.id("password"));
            WebElement loginButton = webDriver.findElement(By.id("login-button"));
            usernameInput.sendKeys(username);
            passwordInput.sendKeys("secret_sauce");
            loginButton.click();
            try {
                WebElement productsTitle = webDriver.findElement(By.className("title"));
                assertEquals("Products", productsTitle.getText(), "Login failed for user: " + username);
                WebElement openMenu = webDriver.findElement(By.id("react-burger-menu-btn"));
                openMenu.click();
                Thread.sleep(1000);
                WebElement logOut = webDriver.findElement(By.id("logout_sidebar_link"));
                logOut.click();
                System.out.println("Test passed for user: " + username);
            } catch (Exception e) {
                System.out.println("Test failed for user: " + username + " - Products title not found");
            }
        }
    }
}