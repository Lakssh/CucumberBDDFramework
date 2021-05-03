package com.test.lakshmanan.cucumber.stepdefinitions;

import com.test.lakshmanan.selenium.businesscomponents.GeneralComponents;
import com.test.lakshmanan.selenium.pageactions.LoginActions;
import com.test.lakshmanan.selenium.pageactions.OrderConfirmationActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class GeneralStepDef extends OrderConfirmationActions {

    GeneralComponents general = new GeneralComponents();
    LoginActions login = new LoginActions();

    @Given ("^I launch the (.+)$")
    public void i_launch_the_application(String application) throws InterruptedException {
        general.launchApplication(application);

    }

    @And("^I login to the application using (.+) and (.+)$")
    public void login_to_the_application(String userName, String password){

        general.login(userName,password);

    }

    @And("^I clear the cart if present$")
    public void empty_cart(){
        if(driver.findElements(login.cartCount).size()!=0) {
            click(login.cartCount);
            click(login.removeCart);
        }
        else
            addStepLog("Cart is already Empty");

    }

    @And("^I signout from the application$")
    public void signout(){
        login.signOut();
    }


}
