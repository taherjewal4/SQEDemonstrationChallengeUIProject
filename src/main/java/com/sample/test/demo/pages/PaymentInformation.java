package com.sample.test.demo.pages;

import com.sample.test.demo.model.DialogNG;
import com.sample.test.demo.model.RadioPicker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PaymentInformation extends DialogNG {

    private final RadioPicker creditCard;
    private final RadioPicker cashOnPickup;


    public PaymentInformation(WebElement element){
        super(element);
        creditCard = new RadioPicker(element.findElement(By.cssSelector("#ccpayment")));
        cashOnPickup = new RadioPicker(element.findElement(By.cssSelector("#cashpayment")));
    }

    public RadioPicker getCreditCard() {
        return creditCard;
    }

    public RadioPicker getCashOnPickup() {
        return cashOnPickup;
    }
}