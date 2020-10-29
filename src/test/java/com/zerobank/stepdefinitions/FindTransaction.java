package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.MainPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FindTransaction {

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {

        String username = ConfigurationReader.get("user");
        String password = ConfigurationReader.get("pass");
        new LoginPage().login(username,password);

        AccountActivityPage activityPage = new AccountActivityPage();
        activityPage.accountActivityTab.click();
        activityPage.findTransactions.click();


    }
    @When("the user enters date range from {string} {string} {string} to {string} {string} {string}")
    public void the_user_enters_date_range_from_to(String fYear, String fMonth, String fDay, String toYear, String toMonth, String toDay) {
       AccountActivityPage activityPage = new AccountActivityPage();
       activityPage.implicitWait();
       String FromDate=fYear+"-"+fMonth+"-"+fDay;
       String ToDate=toYear+"-"+toMonth+"-"+toDay;
       activityPage.fromDate.sendKeys(FromDate);
       activityPage.toDate.sendKeys(ToDate);
    }

    @When("clicks search")
    public void clicks_search() {
       AccountActivityPage activityPage = new AccountActivityPage();
       activityPage.implicitWait();
       activityPage.findButton.click();
       BrowserUtils.waitFor(2);


    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {
        List<WebElement> numRows = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr"));
        List<Integer> rowList = new ArrayList<>();
        boolean checkTheDate=false;
        int firsDay = Integer.parseInt(fromDate.substring(fromDate.length()-1));
        int lastDay = Integer.parseInt(toDate.substring(toDate.length()-1));
        for (int i = 1; i <=numRows.size(); i++) {
            WebElement row = Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr[" + i + "]/td[1]"));
            rowList.add(Integer.parseInt(row.getText().substring(row.getText().length() - 1)));
        }
        for(int i=0; i< rowList.size(); i++){
           if(rowList.get(i)>=firsDay){
               checkTheDate=true;
           }
           else if(rowList.get(i)>firsDay && rowList.get(i)<lastDay){
               checkTheDate=true;
           }
           else if(rowList.get(i)<=lastDay){
               checkTheDate=true;
           }
           else{
               checkTheDate=false;
           }
        }
        Assert.assertTrue(checkTheDate);

    }
    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        List<WebElement> numRows = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr"));
        List<Integer> rowList = new ArrayList<>();
        for (int i = 1; i <=numRows.size(); i++) {
            WebElement row = Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr[" + i + "]/td[1]"));
            rowList.add(Integer.parseInt(row.getText().substring(row.getText().length() - 1)));
        }
        int expectedDay = 6;
        int actualDay = rowList.get(0);
        Assert.assertEquals(actualDay,expectedDay);


    }
    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {
        List<WebElement> numRows = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr"));
        List<String> rowList = new ArrayList<>();
        for (int i = 1; i <=numRows.size(); i++) {
            WebElement row = Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr[" + i + "]/td[1]"));
            rowList.add(row.getText());
        }
        boolean checkDates = true;
        for (String dates : rowList) {
            if(dates==date){
                checkDates=false;
            }
        }
        Assert.assertTrue(checkDates);
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String word) {
        AccountActivityPage activityPage = new AccountActivityPage();
        activityPage.implicitWait();
        new AccountActivityPage().description.clear();
        activityPage.description.sendKeys(word);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String GivenWord) {

        List<WebElement> numRows = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr"));
        if(numRows.size()>1) {
            List<String> rowList = new ArrayList<>();
            for (int i = 1; i <= numRows.size(); i++) {
                WebElement row = Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr[" + i + "]/td[2]"));
                rowList.add(row.getText());

            }
            boolean checkDescriptionRows = false;
            for (String Descriptions : rowList) {

                if (Descriptions.contains(GivenWord)) {
                    checkDescriptionRows = true;
                }
            }
            Assert.assertTrue(checkDescriptionRows);
        }
        else{
            Assert.assertNotNull("this row is empty",numRows);
        }
    }
    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String GivenWord) {
        List<WebElement> numRows = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr"));

        List<String> rowList = new ArrayList<>();
        for (int i = 1; i <=numRows.size(); i++) {
            WebElement row = Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr[" + i + "]/td[2]"));
            rowList.add(row.getText());
        }
        boolean checkDescriptionRows = true;
        for (String Descriptions : rowList) {

            if(Descriptions.contains(GivenWord)){
                checkDescriptionRows=false;
            }
        }
        Assert.assertFalse(checkDescriptionRows);
    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String option) {
        List<WebElement> numRows = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr"));
        List<String> rowList = new ArrayList<>();
        int numberOfRow=0;
        switch (option){
            case "Deposit":
                numberOfRow=3;
                break;
            case "Withdrawal":
                numberOfRow=4;
                break;
        }
        for (int i = 1; i <=numRows.size(); i++) {
            WebElement row = Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr["+i+"]/td["+numberOfRow+"]"));
            rowList.add(row.getText());
        }
        boolean checkRows = false;
        if(rowList.size()>=1){
            checkRows=true;
        }
        Assert.assertTrue(checkRows);
    }

    @When("user selects type {string}")
    public void user_selects_type(String option) {
        AccountActivityPage activityPage = new AccountActivityPage();
        activityPage.repeatOptionsList(activityPage.type).selectByVisibleText(option);
    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String option) {
        WebElement rowTableHead = Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']//th[text()='"+option+"']"));
        if(rowTableHead.getText()==option) {
            List<WebElement> numRows = Driver.get().findElements(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr"));
            int numberOfRow = 0;
            int sizeOfDeposit = 0;
            int sizeOfWithdrawal = 0;
            List<String> rowList = new ArrayList<>();
            switch (option) {
                case "Deposit":
                    numberOfRow = 3;

                    for (int i = 1; i <= numRows.size(); i++) {
                        WebElement row = Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr[" + i + "]/td[" + numberOfRow + "]"));
                        rowList.add(row.getText());
                        sizeOfDeposit=rowList.size();
                    }
                    break;
                case "Withdrawal":
                    numberOfRow = 4;
                    for (int i = 1; i <= numRows.size(); i++) {
                        WebElement row = Driver.get().findElement(By.xpath("//div[@id='filtered_transactions_for_account']//tbody/tr[" + i + "]/td[" + numberOfRow + "]"));
                        rowList.add(row.getText());
                        sizeOfWithdrawal=rowList.size();
                    }
                    break;
            }
            boolean isEmpty = false;
            if(sizeOfDeposit>0 && sizeOfWithdrawal==0){
                isEmpty = true;
            }
            else if(sizeOfDeposit==0 && sizeOfWithdrawal>0){
                isEmpty = true;
            }

            Assert.assertTrue(isEmpty);

        }





    }
}
