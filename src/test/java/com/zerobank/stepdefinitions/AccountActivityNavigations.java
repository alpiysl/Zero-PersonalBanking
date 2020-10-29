package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.MainPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;


public class AccountActivityNavigations {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {

        String username = ConfigurationReader.get("user");
        String password = ConfigurationReader.get("pass");
        new LoginPage().login(username,password);
    }

    //scenario-Savings account redirect
    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page(String input) {

        switch (input.toLowerCase()){
            case "savings":
                new MainPage().savings.click();
                break;
            case "brokerage":
                new MainPage().brokerage.click();
                break;
            case "checking":
                new MainPage().checking.click();
                break;
            case "loan":
                new MainPage().loan.click();
                break;
            case "credit card":
                new MainPage().creditCard.click();
                break;
        }

    }
    @Then("the {string} page should be displayed")
    public void thePageShouldBeDisplayed(String expected){
        String expectedTab=expected;

        String actualTab = new AccountActivityPage().Active.getText();
        Assert.assertEquals(actualTab,expectedTab);
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_Savings_selected(String expected) {
        AccountActivityPage accountActivityPage = new AccountActivityPage();
        String expectedOption =expected;

        String actualOption = accountActivityPage.repeatOptionsList(accountActivityPage.AccountSelections).getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption,expectedOption);
    }

    @Then("the page must have following Account options")
    public void the_page_must_have_following_Account_options(List<String> expectedList) {

        AccountActivityPage activityPage = new AccountActivityPage();
        List<String> actualList = BrowserUtils.getElementsText(activityPage.repeatOptionsList(activityPage.AccountSelections).getOptions());
        actualList.remove(0);
        Assert.assertEquals(expectedList,actualList);
        BrowserUtils.waitFor(2);
        new AccountActivityPage().findTransactions.click();
    }

    @Then("Transactions table must have following columns")
    public void transactions_table_must_have_following_columns(List<String> expectedTable) {
        List<String> actualTableHeads = BrowserUtils.getElementsText(Driver.get().findElements(By.xpath("//*[@id='filtered_transactions_for_account']//tr/th")));
        Assert.assertEquals(expectedTable,actualTableHeads);


    }








}
