package org.example.selenideTests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SimpleTest {

    @BeforeAll
    public static void setup() {
        Configuration.browser = "chrome";
        Configuration.webdriverLogsEnabled = true;
    }

    @Test
    public void userCanSearch() {
        open("https://www.google.com");
    }
}

