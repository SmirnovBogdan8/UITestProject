package org.example.storage;

import com.codeborne.selenide.SelenideElement;

import java.util.Map;

public interface ButtonStorage {
    Map<String, SelenideElement> getButtons();
}
