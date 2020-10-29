package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    @FindBy(css = "a[href='/bank/account-activity.html?accountId=1']")
    public WebElement savings;

    @FindBy(css = "a[href='/bank/account-activity.html?accountId=6']")
    public WebElement brokerage;

    @FindBy(css = "a[href='/bank/account-activity.html?accountId=2']")
    public WebElement checking;

    @FindBy(css = "a[href='/bank/account-activity.html?accountId=5']")
    public WebElement creditCard;

    @FindBy(css = "a[href='/bank/account-activity.html?accountId=4']")
    public WebElement loan;

    @FindBy(className = "board-header")
    public List<WebElement> headers;

    //Pay Bills
    @FindBy(id = "pay_bills_tab")
    public WebElement payBillsTab;

    @FindBy(id = "sp_amount")
    public WebElement amount;

    @FindBy(id = "sp_date")
    public WebElement date;

    @FindBy(id = "sp_description")
    public  WebElement description;

    @FindBy(css = ".btn.btn-primary")
    public WebElement pay;

    @FindBy(xpath = "//span[.='The payment was successfully submitted.']")
    public WebElement text;


    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void implicitWait(){Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);}

    public void navigateToModule(String tab, String module) {
        String tabLocator = "//li[@id='"+tab+"_tab']";
        String moduleLocator = "//li[contains(@class,'ui-state-default')]/a[.='"+module+"'] ";
        try {
            BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
            WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
            new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
        } catch (Exception e) {
            BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
        }
        try {
            BrowserUtils.waitForPresenceOfElement(By.xpath(moduleLocator), 5);
            BrowserUtils.waitForVisibility(By.xpath(moduleLocator), 5);
            BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(moduleLocator)));
            Driver.get().findElement(By.xpath(moduleLocator)).click();
        } catch (Exception e) {
//            BrowserUtils.waitForStaleElement(Driver.get().findElement(By.xpath(moduleLocator)));
            BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(moduleLocator)),  5);
        }
    }





}
