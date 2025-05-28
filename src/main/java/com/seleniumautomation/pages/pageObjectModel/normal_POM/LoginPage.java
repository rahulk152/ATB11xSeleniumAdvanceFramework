package com.seleniumautomation.pages.pageObjectModel.normal_POM;
import com.seleniumautomation.utils.PropertiesReader;
import com.seleniumautomation.utils.WaitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.seleniumautomation.driver.DriverManager.getDriver;

// Page Class
public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Step 1- Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    // If you are not using it , don't keep.
    //private By signBySSO = By.xpath("//button[normalize-space()='Sign in using SSO']");


    // Step 2 - Page Actions
    public String loginToVWOLoginInvalidCreds(String user, String pwd) {
        getDriver().get(PropertiesReader.readKey("url"));
        getDriver().findElement(username).sendKeys(user);
        getDriver().findElement(password).sendKeys(pwd);
        getDriver().findElement(signButton).click();

        // Wait - Thread sleep
//        WaitHelpers.waitJVM(5000);

        WaitHelpers.checkVisibility(getDriver(),error_message,3);

        String error_message_text = getDriver().findElement(error_message).getText();
        return error_message_text;
    }
    // Step 2 - Page Actions
    public void loginToVWOLoginValidCreds(String user, String pwd) {

        driver.get(PropertiesReader.readKey("url"));
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();

        // Wait - Thread sleep
        WaitHelpers.waitJVM(5000);

    }
}