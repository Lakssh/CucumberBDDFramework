package com.test.lakshmanan.selenium.pageactions;

import com.test.lakshmanan.selenium.enums.Context;
import com.test.lakshmanan.selenium.pagelocators.MyAccount;

import java.util.Random;

public class MyAccountActions extends MyAccount {

    public void clickMyAccount(){
        click(myAccount);
    }
    public void clickOrderHistory(){
        click(orderHistory);
    }
    public void clickPersonalInformation(){
        click(personalInformation);
    }
    public void sortbyOrder(){
        clickUsingJS(dateSort,"Date sort");
    }
    public void clickOrderDetails(){
        click(btnOrderDetails);
    }
    public String getTotalPriceFromHistory(){
       return getText(totalPriceIncTax);
    }

    public void validateOrderDetails(){

        scrollByLocator(orderReference);
        validateTextContains(getText(orderReference),getScenarioContext(Context.ORDERREF));
        scrollByLocator(productName);
        validateTextContains(getText(productName),getScenarioContext(Context.PRODUCT));
        validateText(getText(productQuantity),getScenarioContext(Context.QUANTITY));
        validateText(getText(unitPrice),getScenarioContext(Context.UNITPRICE));
        validateText(getText(totalPriceIncTax),getScenarioContext(Context.PRICEINCLTAX));
    }

    public void updateFirstName(String updatedName,String password){
        updatedName = updatedName + getRandomString("abcdefghijk",3);
        enterValue(txtFirstName,updatedName);
        setScenarioContext(Context.FIRSTNAME,updatedName);
        enterValue(txtOldPassword,password);
    }

    public void validateUpdatedFirstName(){
        validateText(driver.findElement(txtFirstName).getAttribute("value"),getScenarioContext(Context.FIRSTNAME));
    }

    public void savePersonalInformationChanges(){
        click(btnSave);
    }
    public void validateSuccessMessage(){
        if (driver.findElements(successMessage).size() != 0)
            addStepLog("Success Message displayed as expected");
        else
            addStepError("Success message is not displayed");
    }

}
