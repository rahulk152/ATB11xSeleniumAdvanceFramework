package com.seleniumautomation.driver;
import com.seleniumautomation.utils.PropertiesReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Objects;

public class DriverManager {

    //public static WebDriver driver;
    public static final ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static void setDriver(WebDriver driver) {
        dr.set(driver);
       //DriverManager.driver = driver;
    }

    public static WebDriver getDriver() {
       return dr.get();
        //return driver;
    }


    public static void unload(){
        dr.remove();
    }

    // When we want to start the browser
    public static void init(){
        String browser = PropertiesReader.readKey("browser").toLowerCase();

        switch (browser){
            case "edge" :
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                //edgeOptions.addArguments("--guest");
                setDriver(new EdgeDriver(edgeOptions));
                break;
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                setDriver(new ChromeDriver(chromeOptions));
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                setDriver(new FirefoxDriver(firefoxOptions));
                break;
            default:
                System.out.println("Not browser Supported!!!");
        }



    }

    public static void down() {
        if (Objects.nonNull(DriverManager.getDriver())) {
            getDriver().quit();
            unload();
        }

        // When we want to close the browser
//    public static void down(){
//        if (getDriver() != null) {
//            driver.quit();
//            driver = null;
//        }
//
//    }


    }
}
