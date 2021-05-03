package com.test.lakshmanan.cucumber.stepdefinitions;

import com.test.lakshmanan.selenium.enums.Context;
import com.test.lakshmanan.selenium.framework.DriverManager;
import com.test.lakshmanan.selenium.pageactions.MyAccountActions;
import com.test.lakshmanan.selenium.pageactions.OrderConfirmationActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.test.lakshmanan.selenium.businesscomponents.*;
import org.testng.Assert;

public class OrderConfirmation extends OrderConfirmationActions {

    MyAccountActions myAccount = new MyAccountActions();

    @Given("^I navigate to T-Shirts menu and add a product to basket$")
    public void navigate_to_Tshirts_and_add_a_product() {
        navigateToTshirts();
        getProductPrice();
        addToCartFromPlp();
        waitForPageLoad(20);
        validateCartPrice();
        getCartAttributes();
        clickProceedToCheckout();
        waitForPageLoad(20);
    }

    @Then("I validate the summary and confirm order")
    public void validate_and_confirm_order() {
        validateSummaryPageAttributes();
        clickProceedToCheckoutInSummary();
        clickProceedToCheckoutInAddressPage();
        checkTermsandConditions();
        clickProceedToCheckoutInShippingPage();
        selectPaymentMethod();
        confirmOrder();
        getOrderRef();

    }

    @And("I navigate to order History page and validate the details")
    public void navigate_to_orderHistory_and_validate_details() {

        myAccount.clickMyAccount();
        myAccount.clickOrderHistory();
        myAccount.sortbyOrder();
        myAccount.clickOrderDetails();
        myAccount.validateOrderDetails();

    }

}
