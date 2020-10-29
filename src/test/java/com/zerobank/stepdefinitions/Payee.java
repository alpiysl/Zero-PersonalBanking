package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.pages.MainPage;
import com.zerobank.pages.PayBillsTab;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class Payee {

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        String username = ConfigurationReader.get("user");
        String password = ConfigurationReader.get("pass");
        new LoginPage().login(username,password);
        PayBillsTab payBillsTab = new PayBillsTab();
        BrowserUtils.waitFor(3);
        payBillsTab.navigateToModule("pay_bills","Add New Payee");
        BrowserUtils.waitFor(3);


    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> data) {
        PayBillsTab payBillsTab = new PayBillsTab();

        payBillsTab.payeeName.sendKeys(data.get("Payee Name"));
        payBillsTab.payeeAdress.sendKeys(data.get("Payee Address"));
        payBillsTab.account.sendKeys(data.get("Account"));
        payBillsTab.details.sendKeys(data.get("Payee details"));
        BrowserUtils.waitFor(2);
        payBillsTab.addButton.click();
    }

    @Then("message The new payee The Law Offices of Hyde,Price")
    public void message_The_new_payee_The_Law_Offices_of_Hyde_Price() {
        BrowserUtils.waitFor(1);
        String actualMessage = new PayBillsTab().alert.getText();
        String expectedMEssage = "The new payee The Law Offices of Hyde, Price & Scharks was successfully created.";
        Assert.assertEquals(actualMessage,expectedMEssage);
    }

}
