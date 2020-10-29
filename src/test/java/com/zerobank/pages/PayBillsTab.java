package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PayBillsTab extends BasePage{

    @FindBy(id = "pay_bills_tab")
    public WebElement payBills;

    @FindBy(xpath = "//a[.='Purchase Foreign Currency']")
    public WebElement purchaseForeignCurrency;

    @FindBy(xpath = "//a[.='Add New Payee']")
    public WebElement addNewPayee;

    @FindBy(id = "add_new_payee")
    public WebElement addButton;

    @FindBy(id = "np_new_payee_name")
    public WebElement payeeName;

    @FindBy(id = "np_new_payee_address")
    public WebElement payeeAdress;

    @FindBy(id = "np_new_payee_account")
    public WebElement account;

    @FindBy(id = "np_new_payee_details")
    public WebElement details;

    @FindBy(id = "alert_content")
    public WebElement alert;




}
