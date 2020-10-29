package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.MainPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AccountSummary {

    @Given("User able to login")
    public void user_able_to_login() {
        String user = "username";
        String pass = "password";
        new LoginPage().login(user,pass);

    }
    @Then("click on Account Activity")
    public void click_on_Account_Activity() {
         new AccountActivityPage().accountActivityTab.click();
    }

    @Then("be on the {string} page")
    public void be_on_the_expected_page(String expected) {

        String expectedUrl = "http://zero.webappsecurity.com/bank/"+expected+".html";

        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Then("the page must have {string} title")
    public void the_page_must_have_title(String expectedTitle) {

        Assert.assertEquals(expectedTitle,Driver.get().getTitle());

    }

    @Then("the page must have following Account types")
    public void the_page_must_have_following_Account_types(List<String> types) {
        List<String> actualList = BrowserUtils.getElementsText(new MainPage().headers);

        Assert.assertEquals(types,actualList);

    }

    @Then("Credit Accounts must have following columns")
    public void credit_Accounts_must_have_following_columns(List<String> tableRows) {
        List<String> actual = new ArrayList<>();
        WebElement th = Driver.get().findElement(By.xpath("(//div[@class='board-content'])[3]//tr/th[1] "));
        actual.add(th.getText());

        for (int i = 1; i < tableRows.size(); i++) {

        WebElement td = Driver.get().findElement(By.xpath("(//div[@class='board-content'])[3]//tr["+i+"]/td[1] "));
        actual.add(td.getText());
        }

        Assert.assertEquals(tableRows,actual);


    }
}
