package com.sample.test.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PizzaOrderForm {

    private final PizzaMakerDialog pizzaMakerDialog;
    private final PickUpInformation pickUpInformation;
    private final PaymentInformation paymentInformation;
    private final WebElement page;

    public PizzaOrderForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
        page = driver.findElement(By.tagName("body"));
        pizzaMakerDialog = new PizzaMakerDialog(page);
        pickUpInformation = new PickUpInformation(page);
        paymentInformation = new PaymentInformation(page);
    }
    public PizzaMakerDialog getPizzaMakerDialog() {
        return pizzaMakerDialog;
    }

    public PickUpInformation getPickUpInformation() {
        return pickUpInformation;
    }

    public PaymentInformation getPaymentInformation() {
        return paymentInformation;
    }
}