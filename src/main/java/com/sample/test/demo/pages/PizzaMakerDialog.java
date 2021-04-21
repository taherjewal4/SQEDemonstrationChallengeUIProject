package com.sample.test.demo.pages;

import com.sample.test.demo.model.DialogNG;
import com.sample.test.demo.model.DropDownDialog;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PizzaMakerDialog extends DialogNG {

    private final DropDownDialog pizza1;
    private final DropDownDialog toppings1;
    private final DropDownDialog toppings2;
    private final WebElement quantity;
    private final WebElement cost;

    public PizzaMakerDialog(WebElement element) {
        super(element);
        pizza1 = new DropDownDialog(element.findElement(By.cssSelector("#pizza1Pizza")));
        toppings1 = new DropDownDialog(element.findElement(By.xpath("//div[@id='pizza1']//select[@class='toppings1']")));
        toppings2 = new DropDownDialog(element.findElement(By.xpath("//div[@id='pizza1']//select[@class='toppings2']")));
        quantity = element.findElement(By.cssSelector("#pizza1Qty"));
        cost = element.findElement(By.cssSelector("#pizza1Cost"));
    }

    public DropDownDialog getPizza1() {
        return pizza1;
    }

    public DropDownDialog getToppings1() {
        return toppings1;
    }

    public DropDownDialog getToppings2() {
        return toppings2;
    }

    public void setQuantity(int i) {
        fillField(quantity, i);
    }

    public WebElement getQuantity() {
        return quantity;
    }

    public String getCost() {
        cost.click();
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
        return cost.getText();
    }
}
