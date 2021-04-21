package com.sample.test.demo.model;

import org.openqa.selenium.WebElement;

public class BaseElement {

    protected void fillField(WebElement field, String text) {
        if (text == null) {
            return;
        }
        field.clear();
        field.sendKeys(text);
    }

    protected void fillField(WebElement field, int i) {
        field.clear();
        field.sendKeys(String.valueOf(i) );
    }
}