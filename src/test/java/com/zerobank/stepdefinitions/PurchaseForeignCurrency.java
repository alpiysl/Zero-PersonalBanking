package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBillsTab;
import com.zerobank.pages.PurchaseForeignCurrecyTab;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.cs.Ale;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PurchaseForeignCurrency {

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        String username = ConfigurationReader.get("user");
        String password = ConfigurationReader.get("pass");
        new LoginPage().login(username,password);
        PayBillsTab payBillsTab = new PayBillsTab();
        BrowserUtils.waitFor(3);
        payBillsTab.navigateToModule("pay_bills","Purchase Foreign Currency");
        BrowserUtils.waitFor(3);

    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> menuOptions) {
        PurchaseForeignCurrecyTab pfc = new PurchaseForeignCurrecyTab();

        List<String> actualOptions = BrowserUtils.getElementsText(pfc.repeatOptionsList().getOptions());
        actualOptions.remove(0);
        Assert.assertEquals(actualOptions,menuOptions);

    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {

        PurchaseForeignCurrecyTab pfc =new PurchaseForeignCurrecyTab();
        pfc.amount.sendKeys("123");
        pfc.calcButton.click();
        BrowserUtils.waitFor(2);

    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert = Driver.get().switchTo().alert();
        String alertMessage = alert.getText();
        String expectedMessage = "Please, ensure that you have filled all the required fields with valid values.";
        Assert.assertEquals(alertMessage,expectedMessage);
        alert.accept();


    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {

        new PurchaseForeignCurrecyTab().calcButton.click();
        BrowserUtils.waitFor(2);
    }
}
