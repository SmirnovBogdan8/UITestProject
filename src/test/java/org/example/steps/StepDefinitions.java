package org.example.steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    private static WebDriver webDriver;
    private static int initialAddToCartCount;
    private static int finalRemoveCount;

    @Дано("Перейти к сайту по ссылке через Selenide {string}")
    public void setUpSelenideStep(String URL){
        Configuration.browser = "chrome";
        Configuration.webdriverLogsEnabled = true;
        open(URL);
    }

    @Дано("Перейти к сайту по ссылке {string}")
    public void setUpStep(String URL) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get(URL);
    }

    @Дано("Проверить соединение с сайтом")
    public void connectionToSiteStep() {
        String title = webDriver.getTitle();
        assert (title.contains("Swag Labs"));
    }

    @Когда("Пользователь проходит авторизацию сайта с логином: {string} и паролем {string}")
    public void authorizationStep(String login, String password) {
        WebElement usernameInput = webDriver.findElement(By.id("user-name"));
        WebElement passwordInput = webDriver.findElement(By.id("password"));
        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        usernameInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    @Тогда("Проверить что пользователь прошел авторизацию")
    public void assertEqualsStep() {
        WebElement productsTitle = webDriver.findElement(By.className("title"));
        assertEquals("Products", productsTitle.getText(), "Expected title 'Products'");
    }

    @Дано("Вернуться на главную страницу авторизации")
    public void returnStep() throws InterruptedException {
        WebElement openMenu = webDriver.findElement(By.id("react-burger-menu-btn"));
        openMenu.click();
        Thread.sleep(1000);
        WebElement logOut = webDriver.findElement(By.id("logout_sidebar_link"));
        logOut.click();
    }

    @Когда("Пользователь нажимает на кнопки Add to cart")
    public void buttonClickStep(){
        initialAddToCartCount = 0;
        java.util.List<WebElement> buttons = webDriver.findElements(By.tagName("button"));
        for (WebElement button : buttons) {
            String originalText = button.getText();
            if ("Add to cart".equals(originalText)) {
                button.click();
                initialAddToCartCount++;
            }
        }
        buttons = webDriver.findElements(By.tagName("button"));
        finalRemoveCount = 0;
        for (WebElement button : buttons) {
            String buttonText = button.getText();
            if ("Remove".equals(buttonText)) {
                button.click();
                finalRemoveCount++;
            }
        }
    }

    @Тогда("Проверить что все кнопки Add to cart прошли тест и вернулись в исходное состояние")
    public void assertButtonClickStep(){
        assertEquals(initialAddToCartCount, finalRemoveCount, "Button click count mismatch");
        assert initialAddToCartCount == finalRemoveCount : "Test Failed";
    }

    @Дано("Завершить проверку")
    public void tearDownStep() {
        webDriver.close();
    }
}