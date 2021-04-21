package com.sample.test.demo.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public abstract class DialogNG extends BaseElement {


    protected WebElement placeOrderButton;
    private WebElement resetButton;

    public DialogNG(WebElement element) {
        placeOrderButton = element.findElement(By.cssSelector("#placeOrder"));
        resetButton = element.findElement(By.cssSelector("#reset"));
    }

    public void placeOrder() {
        placeOrderButton.click();
    }

    public void resetOrder() {
        resetButton.click();
    }


    public WebElement getPlaceOrderButton() {
        return placeOrderButton;
    }

    public WebElement getResetButton() {
        return resetButton;
    }
}