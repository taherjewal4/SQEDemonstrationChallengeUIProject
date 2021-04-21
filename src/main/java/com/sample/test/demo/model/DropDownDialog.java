package com.sample.test.demo.model;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownDialog extends BaseElement {

    private final Select select;
    private List<WebElement> items;

    public DropDownDialog(WebElement element) {
        select = new Select(element);
        items = select.getOptions();
    }

    public String getSelectedOption() {
        return select.getFirstSelectedOption().getText();
    }

    public void selectByIndex(int i) {
        select.selectByIndex(i);
    }

    public void selectByVisibleText(String text) {
        select.selectByVisibleText(selectItem(text));
    }

    public void selectByValue(String text) {
        select.selectByValue(text);
    }

    public String selectItem(String item){
       return items.stream().filter(o->o.getText().trim().contains(item)).findFirst().get().getText();
    }
}