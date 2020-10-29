package com.zerobank.stepdefinitions;

import com.zerobank.pages.MainPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class PayBills {

    @Then("click on Pay Bills")
    public void click_on_Pay_Bills() {
        BrowserUtils.waitFor(2);
        new MainPage().payBillsTab.click();

    }

    @When("user fills the blanks")
    public void user_fills_the_blanks() {
        MainPage mainPage = new MainPage();
        mainPage.amount.sendKeys("12345");
        mainPage.date.sendKeys("10/10/2020");
        mainPage.description.sendKeys("asdf");
    }

    @Then("click On Pay")
    public void click_On_Pay() {
         new MainPage().pay.click();
    }

    @Then("The payment was successfully submitted. displayed")
    public void the_payment_was_successfully_submitted_displayed() {

        String expectedMessage = "The payment was successfully submitted.";
        String actualMessage = new MainPage().text.getText();
        Assert.assertEquals(expectedMessage,actualMessage);
        BrowserUtils.waitFor(2);

    }

    @When("user tries to make a payment without entering the amount or date,")
    public void user_tries_to_make_a_payment_without_entering_the_amount_or_date() {

        new MainPage().pay.click();

    }

    @Then("Please fill out this field displayed.")
    public void please_fill_out_this_field_displayed() {

        String actualAlertMessade = new MainPage().amount.getAttribute("Please fill out this field");
        String expected = "Please fill out this field";
    }

    @Then("Amount field should not accept alphabetical or special characters.")
    public void amount_field_should_not_accept_alphabetical_or_special_characters() {
        MainPage mainPage = new MainPage();
        String amountSent = mainPage.amount.getText();
        boolean checkChars = true;
        for (int i = 0; i < amountSent.length(); i++) {

            if(!Character.isAlphabetic(amountSent.charAt(i))){
                checkChars = false;
                break;
            }
        }

        Assert.assertTrue(checkChars);
    }

    @Then("Date field should not accept alphabetical characters.")
    public void date_field_should_not_accept_alphabetical_characters() {
        MainPage mainPage = new MainPage();
        String amountSent = mainPage.date.getText();
        boolean checkChars = true;
        for (int i = 0; i < amountSent.length(); i++) {

            if (Character.isAlphabetic(amountSent.charAt(i))) {
                checkChars = false;
                break;
            }
        }
        Assert.assertTrue(checkChars);
    }
}
