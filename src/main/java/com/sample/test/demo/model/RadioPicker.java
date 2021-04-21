package com.sample.test.demo.model;

import org.openqa.selenium.WebElement;

public class RadioPicker extends BaseElement {

    private final WebElement radioButton;

    public RadioPicker(WebElement element) {
        radioButton = element;
    }

    public void selectOption() {
        radioButton.click();
    }

    public WebElement getRadioButton() {
        return radioButton;
    }

    public String getRadioText() {
        return radioButton.getText();
    }
}