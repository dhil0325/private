package org.samir;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {
    protected WebDriver webDriver;

    public WebDriver launchBrowser(String browserName) {

        //chrome browser launch
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().driverVersion("126.0.6478.182").setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--start-maximized");
            webDriver = new ChromeDriver();

        // headless chrome browser launch
        } else if (browserName.equalsIgnoreCase("headless chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            webDriver = new ChromeDriver(options);

        // firefox browser launch
        } else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();

        // headless firefox browser launch
        } else if (browserName.equalsIgnoreCase("headless firefox")) {
            WebDriverManager.firefoxdriver().setup();
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);
            webDriver = new FirefoxDriver(options);

        // edge browser launch
//        } else if (browserName.equalsIgnoreCase("edge")) {
//            WebDriverManager.edgedriver().setup();
//            webDriver = new EdgeDriver();

        // headless edge browser launch
//        } else if (browserName.equalsIgnoreCase("headless edge")) {
//            WebDriverManager.edgedriver().setup();
//            EdgeOptions options = new EdgeOptions();
//            options.setHeadless(true);
//            webDriver = new ChromeDriver(options);
//        }

    }
        return webDriver;
}}
