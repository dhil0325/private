package org.samir;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.time.Duration;

@CucumberOptions(features = "src/test/java/org/samir/feature/Login.feature",
    glue = "org/samir/steps",
    tags = "",
    plugin = {"pretty",
        "json:target/cucumber-reports/cucumber.json",
        "html:target/cucumber-reports/cucumber.html"
}, monochrome = true)


public class TestRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeMethod
    public void setupBrowser() {
        // if you use chrome browser please verify chrome browser version 114
        WebDriver webDriver = new BrowserFactory().launchBrowser("firefox");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        DriverManager.getInstance().setDriver(webDriver);
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.getInstance().getDriver().quit();

    }
}
