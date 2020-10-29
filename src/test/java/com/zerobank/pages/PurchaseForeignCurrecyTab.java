package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class PurchaseForeignCurrecyTab extends BasePage{

    @FindBy(id = "pc_currency")
    public WebElement menuoptions;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calcButton;

    @FindBy(id = "pc_amount")
    public WebElement amount;

    public Select repeatOptionsList(){
        return new Select(menuoptions);
    }


}
