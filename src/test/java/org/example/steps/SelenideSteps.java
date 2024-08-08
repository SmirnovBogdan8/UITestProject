package org.example.steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.ru.Дано;

import static com.codeborne.selenide.Selenide.open;

public class SelenideSteps {

    @Дано("Перейти к сайту по ссылке через Selenide {string}")
    public void setUpSelenideStep(String URL){
        Configuration.browser = "chrome";
        Configuration.webdriverLogsEnabled = true;
        open(URL);
    }


}
