package com.seleniumautomation.base;
import com.seleniumautomation.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest {


    @BeforeMethod
    public void setUp(){

        DriverManager.init();

    }

    @AfterMethod
    public void tearDown(){
        DriverManager.down();
    }


}
