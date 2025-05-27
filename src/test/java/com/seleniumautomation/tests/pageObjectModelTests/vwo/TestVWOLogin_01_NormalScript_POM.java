package com.seleniumautomation.tests.pageObjectModelTests.vwo;
import com.seleniumautomation.base.CommonToAllTest;
import com.seleniumautomation.driver.DriverManager;
import com.seleniumautomation.pages.pageObjectModel.normal_POM.LoginPage;
import com.seleniumautomation.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static com.seleniumautomation.driver.DriverManager.driver;
import static com.seleniumautomation.driver.DriverManager.getDriver;
import static org.assertj.core.api.Assertions.*;
import org.testng.Assert;

public class TestVWOLogin_01_NormalScript_POM extends CommonToAllTest {

    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login(){

        // Driver Manager Code - 1
        // Page Class Code (POM Code) - 2
        LoginPage loginPage = new LoginPage(driver);
        String error_msg = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));

        // Assertions - 3
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));

    }
}
