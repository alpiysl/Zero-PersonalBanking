package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends BasePage{

    @FindBy(id = "aa_accountId")
    public WebElement AccountSelections;

    @FindBy(css = "li[class='active']")
    public WebElement Active;

    @FindBy(id = "account_activity_tab")
    public WebElement accountActivityTab;

    //find transactions tab
    @FindBy(xpath = "//a[.='Find Transactions']")
    public WebElement findTransactions;

    @FindBy(css = "#aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(css = ".btn.btn-primary")
    public WebElement findButton;

    @FindBy(id = "aa_description")
    public WebElement description;

    @FindBy(id = "aa_type")
    public WebElement type;





    public Select repeatOptionsList(WebElement element){
        return new Select(element);
    }
}
