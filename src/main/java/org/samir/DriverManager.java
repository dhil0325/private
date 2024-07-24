package org.samir;

import org.openqa.selenium.WebDriver;

public class DriverManager {

    //implements design pattern singleton and thread local
    private static final DriverManager instance = new DriverManager();

    ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverManager() {
    }

    public static DriverManager getInstance() {
        return instance;
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(WebDriver webDriver) { driver.set(webDriver);
    }
}
