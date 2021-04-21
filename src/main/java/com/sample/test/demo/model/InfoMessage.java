package com.sample.test.demo.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InfoMessage extends BaseElement {

    private WebElement message;
    private WebElement messageText;
    private WebElement close;

    public InfoMessage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dialog")));
        messageText = message.findElement(By.xpath("//div[@id='dialog']/p"));
        close = driver.findElement(By.cssSelector(".ui-icon-closethick"));
    }

    public String getInfoMessage() {
        return messageText.getText();
    }

    public void closeMessage() {
        close.click();
    }
}