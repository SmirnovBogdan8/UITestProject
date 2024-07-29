package org.example.service;

import com.codeborne.selenide.Condition;
import org.example.storage.ButtonStorage;

public class ButtonServiceImpl implements ButtonService {
    private final ButtonStorage buttonStorage;

    public ButtonServiceImpl(ButtonStorage buttonStorage) {
        this.buttonStorage = buttonStorage;
    }

    @Override
    public void click(String buttonName) {
        buttonStorage.getButtons().get(buttonName).click();
    }

    @Override
    public boolean isDisabled(String buttonName) {
        return buttonStorage.getButtons().get(buttonName).is(Condition.disabled);
    }
}
