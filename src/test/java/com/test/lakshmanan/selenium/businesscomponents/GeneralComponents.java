package com.test.lakshmanan.selenium.businesscomponents;
import com.test.lakshmanan.selenium.pageactions.LoginActions;
import org.openqa.selenium.By;
import com.test.lakshmanan.selenium.framework.FrameworkUtils;
import com.test.lakshmanan.selenium.framework.Settings;

import java.util.Properties;

public class GeneralComponents extends FrameworkUtils {
    private static Properties globalProperties = Settings.getInstance();
    LoginActions login= new LoginActions();

    public void launchApplication(String application){

        String url = null;
        if (application.equalsIgnoreCase("automationpractice"))
            url = globalProperties.getProperty(application);
        else
            addStepError("Application URL is not defined");
        driver.get(url);
        waitForPageLoad(20);
        addStepLog(" Application Launched : " +url);
    }

    public void login(String userName,String password){

        login.navigateToLogin();
        login.enterUser(userName);
        login.enterPassword(password);
        login.clickSubmit();
        waitForPageLoad(20);

    }

}
