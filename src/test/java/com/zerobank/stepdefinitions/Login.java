package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.Map;

public class Login {

    @Given("users should be able to login to the application.")
    public void users_should_be_able_to_login_to_the_application(Map<String,String> userInfo) {
        new LoginPage().login(userInfo.get("username"),userInfo.get("password"));
    }

    @Then("{string} page should be displayed.")
    public void account_summary_page_should_be_displayed(String expectedPage) {
        String actualPage = new LoginPage().accountSummary.getText();
        Assert.assertEquals(expectedPage,actualPage);
    }

    @When("log in with valid credentials")
    public void log_in_with_valid_credentials_Account_summary_page_should_be_displayed(Map<String,String> userInfo) {
        new LoginPage().login(userInfo.get("username"),userInfo.get("password"));
    }

    @When("login with wrong username or wrong password should not be able to login.")
    public void with_wrong_username_or_wrong_password_should_not_be_able_to_login(Map<String,String> userInfo) {
        new LoginPage().login(userInfo.get("username"),userInfo.get("password"));
    }

    @When("login with blank username or password should also not be able to login.")
    public void with_blank_username_or_password_should_also_not_be_able_to_login() {
       String username="";
       String password="";
       new LoginPage().login(username,password);

    }

    @Then("error message {string} should be displayed.")
    public void error_message_should_be_displayed(String expectedMessage) {
        String actualMessage = new LoginPage().errorMessage.getText();

        Assert.assertEquals(expectedMessage,actualMessage);

    }

}
