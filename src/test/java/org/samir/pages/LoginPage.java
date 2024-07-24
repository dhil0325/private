package org.samir.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.samir.Keyword;
import org.testng.Assert;

import java.security.Key;
import java.time.Duration;

public class LoginPage {

    protected WebDriver webDriver;

    public LoginPage(WebDriver driver) {

        this.webDriver = driver;
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//*[@class='container']")
    public WebElement loginForm;

    @FindBy(id = "username")
    public WebElement usernameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(xpath = "//button")
    public WebElement loginButton;

    @FindBy(id = "message")
    public WebElement messageError;

    @FindBy(id = "successMessage")
    public WebElement messageSuccess;

    public void verifyLoginFormIsDisplayed() {
        Keyword.validateElementIsVisibleAndEnabled(loginForm);
    }

    public void inputCredentials(String username, String password) {
        Keyword.inputText(usernameField, username);
        Keyword.inputText(passwordField, password);
    }

    public void clickLoginButton() {
        Keyword.tapElement(loginButton);
    }

    public void verifyErrorMessage(String message) {
        Keyword.waitElementToBeDisplayed(messageError);
        String actual = messageError.getText();
        Assert.assertEquals(actual, message);
    }

    public void verifySuccessMessage(String message) {
        Keyword.waitElementToBeDisplayed(messageSuccess);
        String actual = messageSuccess.getText();
        Assert.assertEquals(actual, message);
    }


}

