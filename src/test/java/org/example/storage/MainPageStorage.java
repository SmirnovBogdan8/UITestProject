package org.example.storage;

import com.codeborne.selenide.SelenideElement;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$x;

public class MainPageStorage implements ButtonStorage, InputStorage {
    private final Map<String, SelenideElement> buttons;
    private final Map<String, SelenideElement> inputs;

    public MainPageStorage() {
        buttons = new HashMap<>();
        buttons.put("Сохранить", $x("//button[@testid='save']"));

        inputs = new HashMap<>();
    }

    @Override
    public Map<String, SelenideElement> getButtons() {
        return buttons;
    }

    @Override
    public Map<String, SelenideElement> getInputs() {
        return inputs;
    }
}
