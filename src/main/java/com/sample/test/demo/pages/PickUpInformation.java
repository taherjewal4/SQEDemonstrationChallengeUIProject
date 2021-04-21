package com.sample.test.demo.pages;

import com.sample.test.demo.model.DialogNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PickUpInformation extends DialogNG {

    private WebElement nameField;
    private WebElement emailField;
    private WebElement phoneField;


    public PickUpInformation(WebElement element) {
        super(element);
        nameField = element.findElement(By.cssSelector("#name"));
        emailField = element.findElement(By.cssSelector("#email"));
        phoneField = element.findElement(By.cssSelector("#phone"));
    }

    public PickUpInformation setNameField(String name) {
        fillField(nameField, name);
        return this;
    }

    public PickUpInformation setEmailField(String email) {
        fillField(emailField, email);
        return this;

    }

    public PickUpInformation setPhoneField(String phone) {
        fillField(phoneField, phone);
        return this;
    }

    public WebElement getNameField() {
        return nameField;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPhoneField() {
        return phoneField;
    }

}