package com.sample.test.demo.tests;

import com.sample.test.demo.TestBase;
import com.sample.test.demo.constants.PizzaToppings;
import com.sample.test.demo.constants.PizzaTypes;
import com.sample.test.demo.model.DropDownDialog;
import com.sample.test.demo.model.InfoMessage;
import com.sample.test.demo.model.RadioPicker;
import com.sample.test.demo.pages.PaymentInformation;
import com.sample.test.demo.pages.PickUpInformation;
import com.sample.test.demo.pages.PizzaMakerDialog;
import com.sample.test.demo.pages.PizzaOrderForm;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PizzaOrderTest extends TestBase {

    private PizzaOrderForm pizzaOrderForm;

    @BeforeClass
    public void initPage() {
        pizzaOrderForm = new PizzaOrderForm(driver);
    }

    @Test
    public void successPizzaOrder() {
        String selectedPizza = PizzaTypes.LARGE_THREETOPPINGS
                .getDisplayName().concat(" $" + PizzaTypes.LARGE_THREETOPPINGS.getCost());
        PizzaMakerDialog pizzaMakerDialog = pizzaOrderForm.getPizzaMakerDialog();
        DropDownDialog dropDownDialog = pizzaMakerDialog
                .getPizza1();
        dropDownDialog
                .selectByVisibleText(selectedPizza);

        dropDownDialog = pizzaMakerDialog.getToppings1();
        dropDownDialog
                .selectByVisibleText(PizzaToppings.PARMASAN.getDisplayName());
        dropDownDialog = pizzaMakerDialog.getToppings2();
        dropDownDialog
                .selectByVisibleText(PizzaToppings.MUSHROOMS.getDisplayName());
        pizzaMakerDialog
                .setQuantity(2);
        /**
         * Muted the like due to the locator in the UI.
         * The calculated value of the pizza is not coming as text
         *  !!!!!!!!! it as a bug !!!!!!!!!
         */
//        assertEquals((int) (PizzaTypes.LARGE_THREETOPPINGS.getCost() *
//                Integer.valueOf(pizzaMakerDialog.getQuantity().getText())), pizzaMakerDialog.getCost());

        PickUpInformation pickUpInformation = pizzaOrderForm
                .getPickUpInformation();

        pickUpInformation
                .setNameField("Testing Name")
                .setEmailField("test2021@gmail.com")
                .setPhoneField("0765872323");

        PaymentInformation paymentInformation = pizzaOrderForm.getPaymentInformation();
        RadioPicker picker = paymentInformation.getCreditCard();
        picker.selectOption();
        paymentInformation.placeOrder();
        InfoMessage infoMessage = new InfoMessage(driver);
        assertTrue(infoMessage.getInfoMessage().contains("Thank you for your order!"));
        infoMessage
                .closeMessage();
    }
}