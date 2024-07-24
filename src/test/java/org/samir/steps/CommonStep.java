package org.samir.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.samir.DriverManager;
import org.samir.Keyword;
import org.samir.pages.LoginPage;
import org.testng.asserts.Assertion;

public class CommonStep {
    @Given("navigate to url {string}")
    public void navigateToUrl(String url) {
        Keyword.navigateToUrl(url);
    }

    @When("login as {string}")
    public void loginAs(String credntialType) {
        String username = "";
        String password = "";

        switch (credntialType) {
            case "valid_credential":
                username = "validUser";
                password = "validPassword";
                break;
            case "invvalid_credential":
                username = "invalidUser";
                password = "invalidPassword";
                break;
            default:
                throw new RuntimeException("Invalid credential type: ");
        }
        LoginPage loginPage = new LoginPage(DriverManager.getInstance().getDriver());
        loginPage.inputCredentials(username, password);
    }

    @Then("user tap button login and verify allert message success {string}")
    public void userTapButtonLoginAndVerifyAllertMessageSuccess(String value) {
        LoginPage loginPage = new LoginPage(DriverManager.getInstance().getDriver());
        loginPage.clickLoginButton();
        loginPage.verifySuccessMessage(value);
    }

    @Then("user tap button login and verify allert message error {string}")
    public void userTapButtonLoginAndVerifyAllertMessageError(String value) {
        LoginPage loginPage = new LoginPage(DriverManager.getInstance().getDriver());
        loginPage.clickLoginButton();
        loginPage.verifyErrorMessage(value);
    }

    @Given("user take screenshot full page with name {string}")
    public void userTakeScreenshotFullPageWithName(String fileName) {

        Keyword.takeScreenshot(fileName);
    }


}
